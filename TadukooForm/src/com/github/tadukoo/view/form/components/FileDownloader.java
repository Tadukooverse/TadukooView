package com.github.tadukoo.view.form.components;

import com.github.tadukoo.util.ExceptionUtil;
import com.github.tadukoo.util.download.DownloadUtil;
import com.github.tadukoo.util.download.ProgressRBCWrapperListener;
import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.util.tuple.Pair;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.Component;
import java.io.IOException;
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
			singleProgressBar.setValue(0);
			DownloadUtil.downloadFile(logger, this, fileAddressAndPath.getLeft(), fileAddressAndPath.getRight());
			
			// Update the number of files completed in the overall progress bar
			done++;
			overallProgressBar.setValue(done);
			overallProgressBar.setString(done + "/" + total + " files");
		}
	}
}
