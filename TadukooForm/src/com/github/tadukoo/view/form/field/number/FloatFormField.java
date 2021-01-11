package com.github.tadukoo.view.form.field.number;

import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.form.Form;
import com.github.tadukoo.view.form.field.FieldType;
import com.github.tadukoo.view.form.field.FormField;
import com.github.tadukoo.view.form.field.LabelType;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;

import javax.swing.border.Border;
import java.awt.GraphicsEnvironment;

/**
 * A Float Form Field is a {@link FormField} used to store floats.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 * @since Alpha v.0.2.1
 */
public class FloatFormField extends NumberFormField<Float>{
	
	/**
	 * Builder to be used to create an {@link FloatFormField}. It has the following parameters:
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
	 *         <td>The name of the field (used as a key in {@link Form Forms})</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>defaultValue</td>
	 *         <td>The starting value of the field</td>
	 *         <td>Defaults to 0</td>
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
	 *         <td>minValue</td>
	 *         <td>The minimum value allowed for the field</td>
	 *         <td>Defaults to null (no minimum)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>maxValue</td>
	 *         <td>The maximum value allowed for the field</td>
	 *         <td>Defaults to null (no maximum)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>stepSize</td>
	 *         <td>The increment value for the spinner for the field</td>
	 *         <td>Defaults to 1.0</td>
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
	 *         <td>The {@link FontResourceLoader} to use in loading fonts and/or ensuring they're in the system</td>
	 *         <td>a new FontResourceLoader with the specified values for {@link #logFontResourceLoaderWarnings},
	 *         {@link #logger}, {@link #graphEnv}, and {@link #fontFolder}</td>
	 *     </tr>
	 * </table>
	 *
	 * @author Logan Ferree (Tadukoo)
	 * @version Alpha v.0.3
	 * @since Alpha v.0.2.1
	 */
	public static class FloatFormFieldBuilder extends NumberFormFieldBuilder<Float>{
		
		// Can't create outside of FloatFormField
		private FloatFormFieldBuilder(){
			super();
			defaultValue = 0.0f;
			stepSize = 1.0f;
		}
		
		/*
		 * The Basics
		 */
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder key(String key){
			super.key(key);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder defaultValue(Float defaultValue){
			super.defaultValue(defaultValue);
			return this;
		}
		
		/*
		 * Label Settings
		 */
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder labelType(LabelType labelType){
			super.labelType(labelType);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder labelForegroundPaint(SizablePaint labelForegroundPaint){
			super.labelForegroundPaint(labelForegroundPaint);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder labelBackgroundPaint(SizablePaint labelBackgroundPaint){
			super.labelBackgroundPaint(labelBackgroundPaint);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder labelFont(FontFamily labelFontFamily, int labelFontStyle, int labelFontSize){
			super.labelFont(labelFontFamily, labelFontStyle, labelFontSize);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder labelShape(ShapeInfo labelShape){
			super.labelShape(labelShape);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder labelBorder(Border labelBorder){
			super.labelBorder(labelBorder);
			return this;
		}
		
		/*
		 * Positioning
		 */
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder rowPos(int rowPos){
			super.rowPos(rowPos);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder colPos(int colPos){
			super.colPos(colPos);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder rowSpan(int rowSpan){
			super.rowSpan(rowSpan);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder colSpan(int colSpan){
			super.colSpan(colSpan);
			return this;
		}
		
		/*
		 * Font Resource Loading Methods
		 */
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder logFontResourceLoaderWarnings(boolean logFontResourceLoaderWarnings){
			super.logFontResourceLoaderWarnings(logFontResourceLoaderWarnings);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder logger(EasyLogger logger){
			super.logger(logger);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder graphEnv(GraphicsEnvironment graphEnv){
			super.graphEnv(graphEnv);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder fontFolder(String fontFolder){
			super.fontFolder(fontFolder);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder fontResourceLoader(FontResourceLoader fontResourceLoader){
			super.fontResourceLoader(fontResourceLoader);
			return this;
		}
		
		/*
		 * Number Specific Methods
		 */
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder minValue(Float minValue){
			super.minValue(minValue);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder maxValue(Float maxValue){
			super.maxValue(maxValue);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormFieldBuilder stepSize(Float stepSize){
			super.stepSize(stepSize);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public FloatFormField build(){
			return new FloatFormField(key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					labelFontFamily, labelFontStyle, labelFontSize,
					labelShape, labelBorder,
					rowPos, colPos, rowSpan, colSpan,
					logFontResourceLoaderWarnings, logger, graphEnv,
					fontFolder, fontResourceLoader,
					minValue, maxValue, stepSize);
		}
	}
	
	/**
	 * Creates a new FloatFormField with the given parameters.
	 *
	 * @param key The name of this field (used as a key in {@link Form Forms})
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
	 * @param minValue The minimum value allowed for this field
	 * @param maxValue The maximum value allowed for this field
	 * @param stepSize The increment value for the spinner for this field
	 */
	private FloatFormField(String key, Float defaultValue,
	                       LabelType labelType, SizablePaint labelForegroundPaint, SizablePaint labelBackgroundPaint,
	                       FontFamily labelFontFamily, int labelFontStyle, int labelFontSize,
	                       ShapeInfo labelShape, Border labelBorder,
	                       int rowPos, int colPos, int rowSpan, int colSpan,
	                       boolean logFontResourceLoaderWarnings, EasyLogger logger, GraphicsEnvironment graphEnv,
	                       String fontFolder, FontResourceLoader fontResourceLoader,
	                       Float minValue, Float maxValue, Float stepSize){
		super(FieldType.FLOAT, key, defaultValue,
				labelType, labelForegroundPaint, labelBackgroundPaint,
				labelFontFamily, labelFontStyle, labelFontSize,
				labelShape, labelBorder,
				rowPos, colPos, rowSpan, colSpan,
				logFontResourceLoaderWarnings, logger, graphEnv,
				fontFolder, fontResourceLoader,
				minValue, maxValue, stepSize);
	}
	
	/**
	 * @return A new {@link FloatFormFieldBuilder} to use to make a {@link FloatFormField}
	 */
	public static FloatFormFieldBuilder builder(){
		return new FloatFormFieldBuilder();
	}
	
	/** {@inheritDoc} */
	@Override
	protected Float convertToType(Number number){
		return number.floatValue();
	}
}
