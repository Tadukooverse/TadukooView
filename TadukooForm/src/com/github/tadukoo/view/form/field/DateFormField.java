package com.github.tadukoo.view.form.field;

import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.form.components.DateForm;
import com.github.tadukoo.view.form.SimpleForm;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;

import javax.swing.JComponent;
import javax.swing.border.Border;
import java.awt.GraphicsEnvironment;
import java.util.Date;

/**
 * A Date Form Field is a {@link FormField} used to store Dates.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 * @since Alpha v.0.2.1
 */
public class DateFormField extends FormField<Date>{
	
	/**
	 * Builder to be used to create a {@link DateFormField}. It has the following parameters:
	 *
	 * <table>
	 *     <caption>FormField Parameters</caption>
	 *     <tr>
	 *         <th>Name</th>
	 *         <th>Description</th>
	 *         <th>Default Value or Required</th>
	 *     </tr>
	 *     <tr>
	 *         <td>key</td>
	 *         <td>The name of the field (used as a key in {@link SimpleForm Forms})</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultValue</td>
	 *         <td>The starting value of the field</td>
	 *         <td>Defaults to null</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelType</td>
	 *         <td>The {@link LabelType} to use for the field</td>
	 *         <td>Defaults to {@link LabelType#LABEL}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelForegroundPaint</td>
	 *         <td>The {@link SizablePaint} for the foreground of the Label</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Label foreground paint)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelBackgroundPaint</td>
	 *         <td>The {@link SizablePaint} for the background of the Label</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Label background paint)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelFont</td>
	 *         <td>The Font to use for the Label - specified as a {@link FontFamily}, style, and size</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Label font)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelShape</td>
	 *         <td>The {@link ShapeInfo} to use for the Label</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Label shape)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>labelBorder</td>
	 *         <td>The {@link Border} to use for the Label</td>
	 *         <td>Defaults to null (to use the Look &amp; Feel's default Label border)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>rowPos</td>
	 *         <td>The row position of the field</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>colPos</td>
	 *         <td>The column position of the field</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>rowSpan</td>
	 *         <td>The row span of the field</td>
	 *         <td>Defaults to 1</td>
	 *     </tr>
	 *     <tr>
	 *         <td>colSpan</td>
	 *         <td>The column span of the field</td>
	 *         <td>Defaults to 1</td>
	 *     </tr>
	 *     <tr>
	 *         <td>minYear</td>
	 *         <td>The minimum year to allow on the field</td>
	 *         <td>Defaults to 1900</td>
	 *     </tr>
	 *     <tr>
	 *         <td>maxYear</td>
	 *         <td>The maximum year to allow on the field</td>
	 *         <td>Defaults to 2100</td>
	 *     </tr>
	 * </table>
	 * This builder also provides methods and parameters for {@link FontResourceLoader font resource loading}:
	 * <table>
	 *     <caption>Font Resource Loading Parameters</caption>
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
	 *         <td>The {@link GraphicsEnvironment} to load fonts to in the FontResourceLoader
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
	 *        <td>The {@link FontResourceLoader} to use in loading fonts and/or ensuring they're in the system</td>
	 *        <td>a new FontResourceLoader with the specified values for {@link #logFontResourceLoaderWarnings},
	 *         {@link #logger}, {@link #graphEnv}, and {@link #fontFolder}</td>
	 *     </tr>
	 * </table>
	 *
	 * @author Logan Ferree (Tadukoo)
	 * @version Alpha v.0.3
	 * @since Alpha v.0.2.1
	 */
	public static class DateFormFieldBuilder extends FormFieldBuilder<Date>{
		/** The minimum year to allow on the field */
		private int minYear = 1900;
		/** The maximum year to allow on the field */
		private int maxYear = 2100;
		
		/** Not allowed to create outside of DateFormField */
		private DateFormFieldBuilder(){
			super();
		}
		
		/*
		 * The Basics
		 */
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder key(String key){
			super.key(key);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder defaultValue(Date defaultValue){
			super.defaultValue(defaultValue);
			return this;
		}
		
		/*
		 * Label Settings
		 */
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder labelType(LabelType labelType){
			super.labelType(labelType);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder labelForegroundPaint(SizablePaint labelForegroundPaint){
			super.labelForegroundPaint(labelForegroundPaint);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder labelBackgroundPaint(SizablePaint labelBackgroundPaint){
			super.labelBackgroundPaint(labelBackgroundPaint);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder labelFont(FontFamily labelFontFamily, int labelFontStyle, int labelFontSize){
			super.labelFont(labelFontFamily, labelFontStyle, labelFontSize);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder labelShape(ShapeInfo labelShape){
			super.labelShape(labelShape);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder labelBorder(Border labelBorder){
			super.labelBorder(labelBorder);
			return this;
		}
		
		/*
		 * Positioning
		 */
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder rowPos(int rowPos){
			super.rowPos(rowPos);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder colPos(int colPos){
			super.colPos(colPos);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder rowSpan(int rowSpan){
			super.rowSpan(rowSpan);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder colSpan(int colSpan){
			super.colSpan(colSpan);
			return this;
		}
		
		/*
		 * Font Resource Loading Methods
		 */
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder logFontResourceLoaderWarnings(boolean logFontResourceLoaderWarnings){
			super.logFontResourceLoaderWarnings(logFontResourceLoaderWarnings);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder logger(EasyLogger logger){
			super.logger(logger);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder graphEnv(GraphicsEnvironment graphEnv){
			super.graphEnv(graphEnv);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder fontFolder(String fontFolder){
			super.fontFolder(fontFolder);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public DateFormFieldBuilder fontResourceLoader(FontResourceLoader fontResourceLoader){
			super.fontResourceLoader(fontResourceLoader);
			return this;
		}
		
		/*
		 * Date Form Specific Methods
		 */
		
		/**
		 * @param minYear The minimum year to allow on the field
		 * @return this, to continue building
		 */
		public DateFormFieldBuilder minYear(int minYear){
			this.minYear = minYear;
			return this;
		}
		
		/**
		 * @param maxYear The maximum year to allow on the field
		 * @return this, to continue building
		 */
		public DateFormFieldBuilder maxYear(int maxYear){
			this.maxYear = maxYear;
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public DateFormField build(){
			return new DateFormField(key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					labelFontFamily, labelFontStyle, labelFontSize,
					labelShape, labelBorder,
					rowPos, colPos, rowSpan, colSpan,
					logFontResourceLoaderWarnings, logger, graphEnv,
					fontFolder, fontResourceLoader,
					minYear, maxYear);
		}
	}
	
	/** The minimum year to allow on this field */
	private final int minYear;
	/** The maximum year to allow on this field */
	private final int maxYear;
	
	/**
	 * Creates a new DateFormField with the given parameters.
	 *
	 * @param key The name of this field (used as a key in {@link SimpleForm Forms})
	 * @param defaultValue The starting value of the field
	 * @param labelType The {@link LabelType} to use for this field
	 * @param labelForegroundPaint The {@link SizablePaint} for the foreground of the Label
	 * @param labelBackgroundPaint The {@link SizablePaint} for the background of the Label
	 * @param labelFontFamily The {@link FontFamily} for the Label's font
	 * @param labelFontStyle The font style for the Label
	 * @param labelFontSize The font size for the Label
	 * @param labelShape The {@link ShapeInfo} to use for the Label
	 * @param labelBorder The {@link Border} to use for the Label
	 * @param rowPos The row position of this field
	 * @param colPos The column position of this field
	 * @param rowSpan The row span of this field
	 * @param colSpan The column span of this field
	 * @param logFontResourceLoaderWarnings Whether to log warnings generated by the FontResourceLoader
	 *                                      - can be ignored if you specify your own FontResourceLoader
	 * @param logger An {@link EasyLogger} that will be sent to the FontResourceLoader by default
	 *               - can be ignored if you specify your own FontResourceLoader
	 * @param graphEnv The {@link GraphicsEnvironment} to load a font to in the FontResourceLoader
	 *                 - can be ignored if you specify your own FontResourceLoader
	 * @param fontFolder The path to the fonts folder to find font files in if needed in the FontResourceLoader
	 *                   - can be ignored if you specify your own FontResourceLoader
	 * @param fontResourceLoader The {@link FontResourceLoader} to use for fonts on this field
	 * @param minYear The minimum year to allow on this field
	 * @param maxYear The maximum year to allow on this field
	 */
	private DateFormField(String key, Date defaultValue,
	                      LabelType labelType, SizablePaint labelForegroundPaint, SizablePaint labelBackgroundPaint,
	                      FontFamily labelFontFamily, int labelFontStyle, int labelFontSize,
	                      ShapeInfo labelShape, Border labelBorder,
	                      int rowPos, int colPos, int rowSpan, int colSpan,
	                      boolean logFontResourceLoaderWarnings, EasyLogger logger, GraphicsEnvironment graphEnv,
	                      String fontFolder, FontResourceLoader fontResourceLoader,
	                      int minYear, int maxYear){
		super(FieldType.DATE, key, defaultValue,
				labelType, labelForegroundPaint, labelBackgroundPaint,
				labelFontFamily, labelFontStyle, labelFontSize,
				labelShape, labelBorder,
				rowPos, colPos, rowSpan, colSpan,
				logFontResourceLoaderWarnings, logger, graphEnv,
				fontFolder, fontResourceLoader);
		this.minYear = minYear;
		this.maxYear = maxYear;
	}
	
	/**
	 * @return A new {@link DateFormFieldBuilder} to use to make a {@link DateFormField}
	 */
	public static DateFormFieldBuilder builder(){
		return new DateFormFieldBuilder();
	}
	
	/**
	 * @return The minimum year to allow on this field
	 */
	public int getMinYear(){
		return minYear;
	}
	
	/**
	 * @return The maximum year to allow on this field
	 */
	public int getMaxYear(){
		return maxYear;
	}
	
	/** {@inheritDoc} */
	@Override
	public JComponent getComponent() throws Throwable{
		return new DateForm(getDefaultValue(), minYear, maxYear);
	}
	
	/** {@inheritDoc} */
	@Override
	public Date getValue(JComponent component){
		if(component instanceof DateForm){
			return ((DateForm) component).getDate();
		}
		return null;
	}
}
