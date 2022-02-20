package com.github.tadukoo.view.uimanager;

import javax.swing.UIManager;

/**
 * Label Theme Properties contains the property keys for all Label related properties to be used in a
 * theme / Look &amp; Feel
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 */
public interface LabelThemeProperties extends ThemeProperties{
	
	/** The property prefix to use for Label related properties in {@link UIManager} */
	String PROPERTY_PREFIX = "Label.";
	
	/** The property key for Label foreground color (not used by Tadukoo Look &amp; Feel components) */
	String LABEL_FOREGROUND_COLOR = PROPERTY_PREFIX + FOREGROUND_COLOR;
	
	/** The property key for Label foreground paint */
	String LABEL_FOREGROUND_PAINT = PROPERTY_PREFIX + FOREGROUND_PAINT;
	
	/** The property key for Label background color (not used by Tadukoo Look &amp; Feel components) */
	String LABEL_BACKGROUND_COLOR = PROPERTY_PREFIX + BACKGROUND_COLOR;
	
	/** The property key for Label background paint */
	String LABEL_BACKGROUND_PAINT = PROPERTY_PREFIX + BACKGROUND_PAINT;
	
	/** The property key for Label disabled foreground color (not used by Tadukoo Look &amp; Feel components) */
	String LABEL_DISABLED_FOREGROUND_COLOR = PROPERTY_PREFIX + DISABLED_FOREGROUND_COLOR;
	
	/** The property key for Label disabled foreground paint */
	String LABEL_DISABLED_FOREGROUND_PAINT = PROPERTY_PREFIX + DISABLED_FOREGROUND_PAINT;
	
	/** The property key for Label font */
	String LABEL_FONT = PROPERTY_PREFIX + FONT;
	
	/** The property key for Label border */
	String LABEL_BORDER = PROPERTY_PREFIX + BORDER;
	
	/** The property key for Label shape */
	String LABEL_SHAPE = PROPERTY_PREFIX + SHAPE;
}
