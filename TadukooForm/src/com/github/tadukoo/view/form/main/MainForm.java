package com.github.tadukoo.view.form.main;

import com.github.tadukoo.util.StringUtil;
import com.github.tadukoo.view.constants.CloseOperation;
import com.github.tadukoo.view.form.Form;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;

/**
 * Main Form represents the main {@link Form} in a program for a user to interact with. As such, it's expected
 * that the Main Form will inherit from {@link JFrame} to provide everything needed.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3.3
 */
public interface MainForm extends Form{
	
	/**
	 * @return This form as a {@link JFrame}
	 */
	JFrame asFrame();
	
	/**
	 * @return The default {@link CloseOperation} to use for this Main Form
	 */
	default CloseOperation defaultCloseOperation(){
		return CloseOperation.DISPOSE_ON_CLOSE;
	}
	
	/**
	 * @return The filepath to the icon to use for this Main Form (can be null to not set an icon)
	 */
	default String iconPath(){
		return null;
	}
	
	/**
	 * @return The {@link Dimension} for the preferred size of this Main Form (can be null to not set a preferred size)
	 */
	default Dimension framePreferredSize(){
		return null;
	}
	
	/**
	 * Configures frame settings for this Main Form. This method should be called by the constructor to at least
	 * set the {@link #defaultCloseOperation()}, use the {@link #iconPath()} and {@link #framePreferredSize()} if
	 * they're not null, and add the inner component to the frame
	 */
	@SuppressWarnings("MagicConstant")
	default void configureFrameSettings(){
		// Set default close operation
		asFrame().setDefaultCloseOperation(defaultCloseOperation().getValue());
		
		// Set icon (if not null)
		String iconPath = iconPath();
		if(StringUtil.isNotBlank(iconPath)){
			URL iconURL = this.getClass().getResource(iconPath);
			asFrame().setIconImage(Toolkit.getDefaultToolkit().getImage(iconURL));
		}
		
		// Set preferred size for the inner component (if not null)
		Dimension preferredSize = framePreferredSize();
		if(preferredSize != null){
			asComponent().setPreferredSize(preferredSize);
		}
		
		// Add the inner component to the frame
		asFrame().add(asComponent());
	}
	
	/**
	 * Launches this Main Form (default is setting visible to true)
	 */
	default void launch(){
		asFrame().setVisible(true);
	}
}
