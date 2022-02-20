package com.github.tadukoo.view.uimanager;

import javax.swing.UIManager;

/**
 * Button Theme Properties contains the property keys for all Button related properties to be used in a
 * theme / Look &amp; Feel
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 */
public interface ButtonThemeProperties extends ThemeProperties{
	
	/** The property prefix to use for Button related properties in {@link UIManager} */
	String PROPERTY_PREFIX = "Button.";
	
	/** The property key for Button foreground color (not used by Tadukoo Look &amp; Feel components) */
	String BUTTON_FOREGROUND_COLOR = PROPERTY_PREFIX + FOREGROUND_COLOR;
	
	/** The property key for Button foreground paint */
	String BUTTON_FOREGROUND_PAINT = PROPERTY_PREFIX + FOREGROUND_PAINT;
	
	/** The property key for Button background color (not used by Tadukoo Look &amp; Feel components) */
	String BUTTON_BACKGROUND_COLOR = PROPERTY_PREFIX + BACKGROUND_COLOR;
	
	/** The property key for Button background paint */
	String BUTTON_BACKGROUND_PAINT = PROPERTY_PREFIX + BACKGROUND_PAINT;
	
	/** The property key for Button gradient (used in Metal Look &amp; Feel only) */
	String BUTTON_GRADIENT = PROPERTY_PREFIX + GRADIENT;
	
	/** The property key for Button focus color (not used by Tadukoo Look &amp; Feel components) */
	String BUTTON_FOCUS_COLOR = PROPERTY_PREFIX + FOCUS_COLOR;
	
	/** The property key for Button focus paint */
	String BUTTON_FOCUS_PAINT = PROPERTY_PREFIX + FOCUS_PAINT;
	
	/** The property key for Button select color (not used by Tadukoo Look &amp; Feel components) */
	String BUTTON_SELECT_COLOR = PROPERTY_PREFIX + SELECT_COLOR;
	
	/** The property key for Button select paint */
	String BUTTON_SELECT_PAINT = PROPERTY_PREFIX + SELECT_PAINT;
	
	/** The property key for Button disabled text color (not used by Tadukoo Look &amp; Feel components) */
	String BUTTON_DISABLED_TEXT_COLOR = PROPERTY_PREFIX + DISABLED_TEXT_COLOR;
	
	/** The property key for Button disabled text paint */
	String BUTTON_DISABLED_TEXT_PAINT = PROPERTY_PREFIX + DISABLED_TEXT_PAINT;
	
	/** The property key for Button font */
	String BUTTON_FONT = PROPERTY_PREFIX + FONT;
	
	/** The property key for Button border */
	String BUTTON_BORDER = PROPERTY_PREFIX + BORDER;
	
	/** The property key for Button shape */
	String BUTTON_SHAPE = PROPERTY_PREFIX + SHAPE;
}
