package com.github.tadukoo.view.form.components;

import com.github.tadukoo.util.ExceptionUtil;
import com.github.tadukoo.util.download.ProgressRBCWrapperListener;
import com.github.tadukoo.util.download.ProgressReadableByteChannelWrapper;
import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.util.tuple.Pair;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Collection;

/**
 * File Downloader is used to give a File Download option dialog to the user for them to be able to download files
 * and watch the progress of the download(s).
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3.3
 */
public class FileDownloader extends JPanel implements ProgressRBCWrapperListener{
	/** The progress bar for all the files to be downloaded */
	private final JProgressBar overallProgressBar;
	/** The progress bar for the current file being downloaded */
	private final JProgressBar singleProgressBar;
	/** The {@link EasyLogger logger} to use for logging problems */
	private final EasyLogger logger;
	
	/**
	 * Creates a new File Downloader, which will be an Option Dialog for the user from the given parent component
	 *
	 * @param parentComponent The {@link Component} used to launch this File Downloader
	 * @param logger The {@link EasyLogger logger} to use for logging problems
	 * @param fileAddressAndPathPairs Pairs of file URLs and local filepaths of files to be downloaded
	 */
	public FileDownloader(Component parentComponent, EasyLogger logger,
	                      Collection<Pair<String, String>> fileAddressAndPathPairs){
		// Store the logger for later use if needed
		this.logger = logger;
		
		// Create a Start button that will download the files (or verify we already have them)
		JButton button = new JButton("Start");
		button.addActionListener(e -> {
			try{
				loadFiles(fileAddressAndPathPairs);
			}catch(IOException ex){
				// Log the error and show it to the user
				logger.logError("Failed to download files", ex);
				JOptionPane.showMessageDialog(parentComponent, ExceptionUtil.getStackTraceAsString(ex));
			}
		});
		add(button);
		
		// Create a progress bar to show the total progress for all the files to be downloaded
		overallProgressBar = new JProgressBar(0, fileAddressAndPathPairs.size());
		overallProgressBar.setStringPainted(true);
		add(overallProgressBar);
		
		// Create a progress bar to show the current progress of the current file being downloaded
		singleProgressBar = new JProgressBar(0, 100);
		singleProgressBar.setStringPainted(true);
		add(singleProgressBar);
		
		// Use the created panel in a popup for the files to be downloaded
		JOptionPane.showOptionDialog(parentComponent, this, "File Download", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, null, null);
	}
	
	/** {@inheritDoc} */
	@Override
	public void progressUpdate(double progress, long bytesSoFar, long expectedSize){
		// If we went over 100% somehow, set the progress to 100 instead
		if(progress > 100.0){
			progress = 100.0;
			bytesSoFar = expectedSize;
		}
		// Update the current file progress bar with the current progress
		singleProgressBar.setValue((int) progress);
		singleProgressBar.setString(progress + "% - " + bytesSoFar + "/" + expectedSize + " bytes");
	}
	
	/**
	 * Attempts to grab the file size for the file at the given {@link URL}. If it fails, a warning
	 * will be logged, but it will not error out and return -1
	 *
	 * @param url The {@link URL} the file is located at
	 * @return The size of the file in bytes, or -1 if we fail to retrieve it
	 */
	private int getFileSize(URL url){
		// Set file size default to -1 (so we can at least return something if it fails)
		int fileLength = -1;
		
		try{
			// Do not follow redirects for grabbing file size
			HttpURLConnection.setFollowRedirects(false);
			
			// Setup a connection to get the HEAD for the file
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("HEAD");
			
			// Grab the file size from the connection
			fileLength = connection.getContentLength();
		}catch(Exception e){
			// Log warning that we couldn't get file size + notify user
			logger.logWarning("Failed to get file size at url: " + url.getPath(), e);
		}
		
		return fileLength;
	}
	
	/**
	 * Iterates over the given file address and filepath pairs to download the files as needed and updates
	 * the overall progress bar on the overall files progress.
	 *
	 * @param fileAddressAndPathPairs Pairs of file URLs and local filepaths for files to be downloaded
	 * @throws IOException If anything goes wrong in downloading files
	 */
	private void loadFiles(Collection<Pair<String, String>> fileAddressAndPathPairs) throws IOException{
		// Set the number of files done and total files
		int done = 0;
		int total = fileAddressAndPathPairs.size();
		
		// Set the overall progress bar to 0 files done
		overallProgressBar.setValue(done);
		overallProgressBar.setString(done + "/" + total + " files");
		
		// Download the files
		for(Pair<String, String> fileAddressAndPath: fileAddressAndPathPairs){
			loadFile(fileAddressAndPath.getLeft(), fileAddressAndPath.getRight());
			
			// Update the number of files completed in the overall progress bar
			done++;
			overallProgressBar.setValue(done);
			overallProgressBar.setString(done + "/" + total + " files");
		}
	}
	
	/**
	 * If the file already exists at the given filepath, nothing happens. Otherwise, we download it from the
	 * given address, and progress will be updated by sending this as a {@link ProgressRBCWrapperListener} to
	 * the {@link ProgressReadableByteChannelWrapper} we use
	 *
	 * @param address The URL for the file to be downloaded
	 * @param filepath The local filepath for the file
	 * @throws IOException If anything goes wrong in downloading the file
	 */
	private void loadFile(String address, String filepath) throws IOException{
		// Check if file already exists so we don't need to download it
		File file = new File(filepath);
		if(file.exists()){
			return;
		}
		
		// Reset current file progress to 0
		singleProgressBar.setValue(0);
		
		// Setup the download, including setting this as the listener for progress updates
		URL url = new URL(address);
		ReadableByteChannel fileDownload = new ProgressReadableByteChannelWrapper(
				Channels.newChannel(url.openStream()), this, getFileSize(url));
		// Follow redirects for the file
		HttpURLConnection.setFollowRedirects(true);
		
		// Perform the file transfer from the URL to our local filepath
		FileOutputStream fileOutputStream = new FileOutputStream(filepath);
		FileChannel fileChannel = fileOutputStream.getChannel();
		fileChannel.transferFrom(fileDownload, 0, Long.MAX_VALUE);
		
		// Close the file channels and output stream now that we're done
		fileDownload.close();
		fileChannel.close();
		fileOutputStream.close();
	}
}
