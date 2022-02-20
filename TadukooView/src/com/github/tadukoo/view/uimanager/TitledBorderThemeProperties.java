package com.github.tadukoo.view.uimanager;

import javax.swing.UIManager;

/**
 * Titled Border Theme Properties contains the property keys for all Titled Border related properties to be used in a
 * theme / Look &amp; Feel
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 */
public interface TitledBorderThemeProperties extends ThemeProperties{
	
	/** The property prefix to use for Titled Border related properties in {@link UIManager} */
	String PROPERTY_PREFIX = "TitledBorder.";
	
	/** The property key for Titled Border border */
	String TITLED_BORDER_BORDER = PROPERTY_PREFIX + BORDER;
	
	/** The property key for Titled Border font */
	String TITLED_BORDER_FONT = PROPERTY_PREFIX + FONT;
	
	/** The property key for Titled Border title color */
	String TITLED_BORDER_TITLE_COLOR = PROPERTY_PREFIX + TITLE_COLOR;
	
	/** The property key for Titled Border position */
	String TITLED_BORDER_POSITION = PROPERTY_PREFIX + POSITION;
}
