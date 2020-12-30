package com.github.tadukoo.view.components;

import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.InsetsUtil;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.paint.HasSelectAndFocusPaints;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;
import com.github.tadukoo.view.shapes.Shaped;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Tadukoo Button is an extension of {@link JButton} that allows for specifying more parameters that can be used in
 * Tadukoo Look &amp; Feel, such as {@link ShapeInfo}.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 * @since Alpha v.0.2
 */
public class TadukooButton extends JButton implements HasSelectAndFocusPaints, Shaped{
	
	/**
	 * Builder to be used to create a {@link TadukooButton}. This is the abstract version to be extended
	 * in subclasses of FormField. It has the following parameters:
	 *
	 * <table>
	 *     <caption>TadukooButton Parameters</caption>
	 *     <tr>
	 *         <th>Name</th>
	 *         <th>Description</th>
	 *         <th>Default Value or Required</th>
	 *     </tr>
	 *     <tr>
	 *         <td>text</td>
	 *         <td>The text to use on the Button</td>
	 *         <td>Defaults to null</td>
	 *     </tr>
	 *     <tr>
	 *         <td>icon</td>
	 *         <td>The icon to use on the Button</td>
	 *         <td>Defaults to null</td>
	 *     </tr>
	 *     <tr>
	 *         <td>actionListener</td>
	 *         <td>The action to perform on click of the Button</td>
	 *         <td>Defaults to null</td>
	 *     </tr>
	 *     <tr>
	 *         <td>selectPaint</td>
	 *         <td>The {@link SizablePaint} to use for when the Button is selected</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Button select paint)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>focusPaint</td>
	 *         <td>The {@link SizablePaint} to use for when the Button is focused</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Button focus paint)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>font</td>
	 *         <td>The {@link Font} to use on the Button (specified via {@link FontFamily}, font style,
	 *         and font size</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Button font)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>shapeInfo</td>
	 *         <td>The {@link ShapeInfo} to use on the Button</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Button shape, if supported)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>border</td>
	 *         <td>The {@link Border} to use on the Button</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Button border)</td>
	 *     </tr>
	 * </table>
	 *
	 * There are also parameters for loading the font using a {@link FontResourceLoader}, which can be ignored if
	 * you don't specify a {@link Font} for this button:
	 *
	 * <table>
	 *     <caption>Font Resource Loader Parameters</caption>
	 *     <tr>
	 *         <th>Field</th>
	 *         <th>Description</th>
	 *         <th>Default Value</th>
	 *     </tr>
	 *     <tr>
	 *         <td>logFontResourceLoaderWarnings</td>
	 *         <td>Whether to log warnings generated by the FontResourceLoader
	 *         - can be ignored if you specify your own FontResourceLoader</td>
	 *         <td>false</td>
	 *     </tr>
	 *     <tr>
	 *         <td>logger</td>
	 *         <td>An {@link EasyLogger} that will be sent to the FontResourceLoader by default
	 *         - can be ignored if you specify your own FontResourceLoader</td>
	 *         <td>null (since logging warnings is set to false by default)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>graphEnv</td>
	 *         <td>The {@link GraphicsEnvironment} to load a font to in the FontResourceLoader
	 *         - can be ignored if you specify your own FontResourceLoader</td>
	 *         <td>{@link GraphicsEnvironment#getLocalGraphicsEnvironment()}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>fontFolder</td>
	 *         <td>The path to the fonts folder to find font files in if needed in the FontResourceLoader
	 *         - can be ignored if you specify your own FontResourceLoader</td>
	 *         <td>"fonts/"</td>
	 *     </tr>
	 *     <tr>
	 *         <td>fontResourceLoader</td>
	 *        <td>The {@link FontResourceLoader} to use in loading a font and/or ensuring they're in the system</td>
	 *        <td>a new FontResourceLoader with the specified values for {@link #logFontResourceLoaderWarnings},
	 *         {@link #logger}, {@link #graphEnv}, and {@link #fontFolder}</td>
	 *     </tr>
	 * </table>
	 *
	 * @author Logan Ferree (Tadukoo)
	 * @version Alpha v.0.3
	 * @since Alpha v.0.2
	 */
	public static class TadukooButtonBuilder{
		/*
		 * The Basics
		 */
		/** The text to use on the Button */
		private String text = null;
		/** The icon to use on the Button */
		private Icon icon = null;
		/** The action to perform on click of the Button */
		private ActionListener actionListener = null;
		
		/*
		 * The Paints
		 */
		/** The {@link SizablePaint} to use for when the Button is selected */
		private SizablePaint selectPaint = null;
		/** The {@link SizablePaint} to use for when the Button is focused */
		private SizablePaint focusPaint = null;
		
		/*
		 * Other Customizations
		 */
		/** The {@link FontFamily} to use on the font of the Button */
		private FontFamily fontFamily = null;
		/** The font style to use on the font of the Button */
		private int fontStyle = -1;
		/** The font size to use on the font of the Button */
		private int fontSize = -1;
		/** The {@link ShapeInfo} to use on the Button */
		private ShapeInfo shapeInfo = null;
		/** The {@link Border} to use on the Button */
		private Border border = null;
		
		/*
		 * Font Resource Loading
		 */
		
		/** Whether to log warnings generated by the FontResourceLoader
		 *  - can be ignored if you specify your own FontResourceLoader */
		private boolean logFontResourceLoaderWarnings = false;
		/** An {@link EasyLogger} that will be sent to the FontResourceLoader by default
		 *  - can be ignored if you specify your own FontResourceLoader */
		private EasyLogger logger = null;
		/** The {@link GraphicsEnvironment} to load a font to in the FontResourceLoader
		 *  - can be ignored if you specify your own FontResourceLoader */
		private GraphicsEnvironment graphEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		/** The path to the fonts folder to find font files in if needed in the FontResourceLoader
		 *  - can be ignored if you specify your own FontResourceLoader */
		private String fontFolder = "fonts/";
		/** The {@link FontResourceLoader} to use in loading a font and/or ensuring they're in the system */
		private FontResourceLoader fontResourceLoader = null;
		
		// Can't create outside of Tadukoo Button
		private TadukooButtonBuilder(){ }
		
		/*
		 * The Basics
		 */
		
		/**
		 * @param text The text to use on the Button
		 * @return this, to continue building
		 */
		public TadukooButtonBuilder text(String text){
			this.text = text;
			return this;
		}
		
		/**
		 * @param icon The icon to use on the Button
		 * @return this, to continue building
		 */
		public TadukooButtonBuilder icon(Icon icon){
			this.icon = icon;
			return this;
		}
		
		/**
		 * @param actionListener The action to perform on click of the Button
		 * @return this, to continue building
		 */
		public TadukooButtonBuilder actionListener(ActionListener actionListener){
			this.actionListener = actionListener;
			return this;
		}
		
		/*
		 * The Paints
		 */
		
		/**
		 * @param selectPaint The {@link SizablePaint} to use for when the Button is selected
		 * @return this, to continue building
		 */
		public TadukooButtonBuilder selectPaint(SizablePaint selectPaint){
			this.selectPaint = selectPaint;
			return this;
		}
		
		/**
		 * @param focusPaint The {@link SizablePaint} to use for when the Button is focused
		 * @return this, to continue building
		 */
		public TadukooButtonBuilder focusPaint(SizablePaint focusPaint){
			this.focusPaint = focusPaint;
			return this;
		}
		
		/*
		 * Other Customizations
		 */
		
		/**
		 * Specifies the font to use on the Button
		 *
		 * @param fontFamily The {@link FontFamily} to use
		 * @param fontStyle The font style to use
		 * @param fontSize The font size to use
		 * @return this, to continue building
		 */
		public TadukooButtonBuilder font(FontFamily fontFamily, int fontStyle, int fontSize){
			this.fontFamily = fontFamily;
			this.fontStyle = fontStyle;
			this.fontSize = fontSize;
			return this;
		}
		
		/**
		 * @param shapeInfo The {@link ShapeInfo} to use on the Button
		 * @return this, to continue building
		 */
		public TadukooButtonBuilder shapeInfo(ShapeInfo shapeInfo){
			this.shapeInfo = shapeInfo;
			return this;
		}
		
		/**
		 * @param border The {@link Border} to use on the Button
		 * @return this, to continue building
		 */
		public TadukooButtonBuilder border(Border border){
			this.border = border;
			return this;
		}
		
		/*
		 * Font Resource Loading Methods
		 */
		
		/**
		 * @param logFontResourceLoaderWarnings Whether to log warnings generated by the FontResourceLoader
		 *  - can be ignored if you specify your own FontResourceLoader
		 * @return this, to continue building
		 */
		public TadukooButtonBuilder logFontResourceLoaderWarnings(boolean logFontResourceLoaderWarnings){
			this.logFontResourceLoaderWarnings = logFontResourceLoaderWarnings;
			return this;
		}
		
		/**
		 * @param logger An {@link EasyLogger} that will be sent to the FontResourceLoader by default
		 *  - can be ignored if you specify your own FontResourceLoader
		 * @return this, to continue building
		 */
		public TadukooButtonBuilder logger(EasyLogger logger){
			this.logger = logger;
			return this;
		}
		
		/**
		 * @param graphEnv The {@link GraphicsEnvironment} to load a font to in the FontResourceLoader
		 *  - can be ignored if you specify your own FontResourceLoader
		 * @return this, to continue building
		 */
		public TadukooButtonBuilder graphEnv(GraphicsEnvironment graphEnv){
			this.graphEnv = graphEnv;
			return this;
		}
		
		/**
		 * @param fontFolder The path to the fonts folder to find font files in if needed in the FontResourceLoader
		 *  - can be ignored if you specify your own FontResourceLoader
		 * @return this, to continue building
		 */
		public TadukooButtonBuilder fontFolder(String fontFolder){
			this.fontFolder = fontFolder;
			return this;
		}
		
		/**
		 * @param fontResourceLoader The {@link FontResourceLoader} to use in loading a font and/or ensuring
		 *  they're in the system
		 * @return this, to continue building
		 */
		public TadukooButtonBuilder fontResourceLoader(FontResourceLoader fontResourceLoader){
			this.fontResourceLoader = fontResourceLoader;
			return this;
		}
		
		/**
		 * Builds a {@link TadukooButton}
		 *
		 * @return A newly created {@link TadukooButton}
		 * @throws IOException If something goes wrong during {@link FontResourceLoader font resource loading}
		 * @throws FontFormatException If something goes wrong during {@link FontResourceLoader font resource loading}
		 */
		public TadukooButton build() throws IOException, FontFormatException{
			// Determine the font to use if it was specified
			Font font = null;
			if(fontFamily != null){
				// Handle font resource loading
				if(fontResourceLoader == null){
					fontResourceLoader = new FontResourceLoader(logFontResourceLoaderWarnings, logger, graphEnv,
							fontFolder);
				}
				
				// Load font + create it
				String foundFont = fontResourceLoader.loadFont(fontFamily, true);
				font = new Font(foundFont, fontStyle, fontSize);
			}
			
			return new TadukooButton(text, icon, actionListener,
					selectPaint, focusPaint,
					font, shapeInfo, border);
		}
	}
	
	/** The {@link SizablePaint} to use for when this Button is selected */
	private SizablePaint selectPaint;
	/** The {@link SizablePaint} to use for when this Button is focused */
	private SizablePaint focusPaint;
	/** The {@link ShapeInfo} to use on the Button */
	private ShapeInfo shapeInfo;
	
	/**
	 * Creates a new Button with the given parameters
	 *
	 * @param text The text to use on the Button
	 * @param icon The icon to use on the Button
	 * @param actionListener The action to perform on click of the Button
	 * @param selectPaint The {@link SizablePaint} to use for when this Button is selected
	 * @param focusPaint The {@link SizablePaint} to use for when this Button is focused
	 * @param font The {@link Font} to use on the Button
	 * @param shapeInfo The {@link ShapeInfo} to use on the Button
	 * @param border The {@link Border} to use on the Button
	 */
	private TadukooButton(String text, Icon icon, ActionListener actionListener,
	                      SizablePaint selectPaint, SizablePaint focusPaint,
	                      Font font, ShapeInfo shapeInfo, Border border){
		super(text, icon);
		
		// Set action listener if present
		if(actionListener != null){
			addActionListener(actionListener);
		}
		
		// Set paints
		if(selectPaint != null){
			setSelectPaint(selectPaint);
		}
		if(focusPaint != null){
			setFocusPaint(focusPaint);
		}
		
		// Set other customizations
		if(font != null){
			setFont(font);
		}
		if(shapeInfo != null){
			setShapeInfo(shapeInfo);
		}
		if(border != null){
			setBorder(border);
		}
	}
	
	/**
	 * @return A new {@link TadukooButtonBuilder} to use to make a {@link TadukooButton}
	 */
	public static TadukooButtonBuilder builder(){
		return new TadukooButtonBuilder();
	}
	
	/** {@inheritDoc} */
	@Override
	public SizablePaint getSelectPaint(){
		return selectPaint;
	}
	
	/** {@inheritDoc} */
	@Override
	public void setSelectPaint(SizablePaint selectPaint){
		this.selectPaint = selectPaint;
	}
	
	/** {@inheritDoc} */
	@Override
	public SizablePaint getFocusPaint(){
		return focusPaint;
	}
	
	/** {@inheritDoc} */
	@Override
	public void setFocusPaint(SizablePaint focusPaint){
		this.focusPaint = focusPaint;
	}
	
	/** {@inheritDoc} */
	@Override
	public ShapeInfo getShapeInfo(){
		return shapeInfo;
	}
	
	/** {@inheritDoc} */
	@Override
	public void setShapeInfo(ShapeInfo shapeInfo){
		this.shapeInfo = shapeInfo;
	}
	
	/** {@inheritDoc} */
	@Override
	public Insets getInsets(){
		Insets insets;
		Border border = getBorder();
		if(border != null || shapeInfo != null){
			insets = new Insets(0, 0, 0, 0);
			
			// Use border insets if we have one
			if(border != null){
				insets = border.getBorderInsets(this);
			}
			
			// Use Shape insets if we have any
			if(shapeInfo != null){
				Insets shapeInsets = shapeInfo.getShapeInsetsFunc().apply(getX(), getY(), getWidth(), getHeight());
				insets = InsetsUtil.addInsets(insets, shapeInsets);
			}
		}else{
			insets = super.getInsets();
		}
		return insets;
	}
	
	/** {@inheritDoc} */
	@Override
	public Insets getInsets(Insets insets){
		// Reset insets to 0 before starting
		insets = InsetsUtil.zeroInsets(insets);
		
		// Add in border insets if we have one
		Border border = getBorder();
		if(border != null) {
			if(border instanceof AbstractBorder){
				insets = ((AbstractBorder)border).getBorderInsets(this, insets);
			}else{
				insets = border.getBorderInsets(this);
			}
		}
		
		// Add in Shape insets if we have any
		if(shapeInfo != null){
			Insets shapeInsets = shapeInfo.getShapeInsetsFunc().apply(getX(), getY(), getWidth(), getHeight());
			insets = InsetsUtil.addInsets(insets, shapeInsets);
		}
		
		return insets;
	}
}
