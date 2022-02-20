package com.github.tadukoo.view.uimanager;

import com.github.tadukoo.view.paint.PaintUIResource;
import com.github.tadukoo.view.shapes.ShapeInfoUIResource;

import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

/**
 * Contains property keys for properties to be used in a theme / look &amp; feel
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 */
public interface ThemeProperties{
	
	/** The property key piece for {@link PaintUIResource paint} properties */
	String PAINT = ".paint";
	
	/** The property key for foreground {@link ColorUIResource color} properties */
	String FOREGROUND_COLOR = "foreground";
	
	/** The property key for foreground {@link PaintUIResource paint} properties */
	String FOREGROUND_PAINT = FOREGROUND_COLOR + PAINT;
	
	/** The property key for background {@link ColorUIResource color} properties */
	String BACKGROUND_COLOR = "background";
	
	/** The property key for background {@link PaintUIResource paint} properties */
	String BACKGROUND_PAINT = BACKGROUND_COLOR + PAINT;
	
	/** The property key for gradient properties (used in Metal Look &amp; Feel mainly,
	 * otherwise gradients are covered by {@link PaintUIResource paint} properties) */
	String GRADIENT = "gradient";
	
	/** The property key for focus {@link ColorUIResource color} properties */
	String FOCUS_COLOR = "focus";
	
	/** The property key for focus {@link PaintUIResource paint} properties */
	String FOCUS_PAINT = FOCUS_COLOR + PAINT;
	
	/** The property key for select {@link ColorUIResource color} properties */
	String SELECT_COLOR = "select";
	
	/** The property key for select {@link PaintUIResource paint} properties */
	String SELECT_PAINT = SELECT_COLOR + PAINT;
	
	/** The property key for disabled text {@link ColorUIResource color} properties */
	String DISABLED_TEXT_COLOR = "disabledText";
	
	/** The property key for disabled text {@link PaintUIResource paint} properties */
	String DISABLED_TEXT_PAINT = DISABLED_TEXT_COLOR + PAINT;
	
	/** The property key for disabled foreground {@link ColorUIResource color} properties */
	String DISABLED_FOREGROUND_COLOR = "disabledForeground";
	
	/** The property key for disabled foreground {@link PaintUIResource paint} properties */
	String DISABLED_FOREGROUND_PAINT = DISABLED_FOREGROUND_COLOR + PAINT;
	
	/** The property key for {@link FontUIResource font} properties */
	String FONT = "font";
	
	/** The property key for {@link BorderUIResource border} properties */
	String BORDER = "border";
	
	/** The property key for {@link ShapeInfoUIResource shape} properties */
	String SHAPE = "shape";
	
	/*
	 * These couple seem to only be for TitledBorder currently
	 */
	
	/** The property key for title color properties */
	String TITLE_COLOR = "titleColor";
	
	/** The property key for position properties */
	String POSITION = "position";
}
