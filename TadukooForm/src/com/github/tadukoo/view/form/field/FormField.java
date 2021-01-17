package com.github.tadukoo.view.form.field;

import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.form.Form;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;

import javax.swing.JComponent;
import javax.swing.border.Border;
import java.awt.GraphicsEnvironment;

/**
 * Form Fields are fields used on {@link Form Forms}.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 * @since Alpha v.0.2
 *
 * @param <Type> The type of value being stored in the field (used for default value)
 */
public abstract class FormField<Type>{
	
	/**
	 * Builder to be used to create a {@link FormField}. This is the abstract version to be extended
	 * in subclasses of FormField. It has the following parameters:
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
	 * @since Alpha v.0.2
	 *
	 * @param <Type> The type of value being stored in the field (used for default value)
	 */
	public static abstract class FormFieldBuilder<Type>{
		/*
		 * The Basics
		 */
		/** The name of the field (used as a key in {@link Form Forms}) */
		protected String key;
		/** The starting value of the field */
		protected Type defaultValue = null;
		
		/*
		 * Label Options
		 */
		/** The {@link LabelType} to use for the field */
		protected LabelType labelType = LabelType.LABEL;
		/** The {@link SizablePaint} for the foreground of the Label */
		protected SizablePaint labelForegroundPaint = null;
		/** The {@link SizablePaint} for the background of the Label */
		protected SizablePaint labelBackgroundPaint = null;
		/** The {@link FontFamily} for the Label's font */
		protected FontFamily labelFontFamily = null;
		/** The font style for the Label */
		protected int labelFontStyle = -1;
		/** The font size for the Label */
		protected int labelFontSize = -1;
		/** The {@link ShapeInfo} to use for the Label */
		protected ShapeInfo labelShape = null;
		/** The {@link Border} to use for the Label */
		protected Border labelBorder = null;
		
		/*
		 * Positioning
		 */
		/** The row position of the field */
		protected int rowPos;
		/** The column position of the field */
		protected int colPos;
		/** The row span of the field */
		protected int rowSpan = 1;
		/** The column span of the field */
		protected int colSpan = 1;
		
		/*
		 * Font Resource Loading
		 */
		/** Whether to log warnings generated by the FontResourceLoader
		 *  - can be ignored if you specify your own FontResourceLoader */
		protected boolean logFontResourceLoaderWarnings = false;
		/** An {@link EasyLogger} that will be sent to the FontResourceLoader by default
		 *  - can be ignored if you specify your own FontResourceLoader */
		protected EasyLogger logger = null;
		/** The {@link GraphicsEnvironment} to load a font to in the FontResourceLoader
		 *  - can be ignored if you specify your own FontResourceLoader */
		protected GraphicsEnvironment graphEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		/** The path to the fonts folder to find font files in if needed in the FontResourceLoader
		 *  - can be ignored if you specify your own FontResourceLoader */
		protected String fontFolder = "fonts/";
		/** The {@link FontResourceLoader} to use in loading a font and/or ensuring they're in the system */
		protected FontResourceLoader fontResourceLoader = null;
		
		/**
		 * Constructs a new FormFieldBuilder (to be called in subclasses)
		 */
		protected FormFieldBuilder(){ }
		
		/*
		 * The Basics
		 */
		
		/**
		 * @param key The name of the field (used as a key in {@link Form Forms})
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> key(String key){
			this.key = key;
			return this;
		}
		
		/**
		 * @param defaultValue The starting value of the field
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> defaultValue(Type defaultValue){
			this.defaultValue = defaultValue;
			return this;
		}
		
		/*
		 * Label Options
		 */
		
		/**
		 * @param labelType The {@link LabelType} to use for the field
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> labelType(LabelType labelType){
			this.labelType = labelType;
			return this;
		}
		
		/**
		 * @param labelForegroundPaint The {@link SizablePaint} for the foreground of the Label
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> labelForegroundPaint(SizablePaint labelForegroundPaint){
			this.labelForegroundPaint = labelForegroundPaint;
			return this;
		}
		
		/**
		 * @param labelBackgroundPaint The {@link SizablePaint} for the background of the Label
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> labelBackgroundPaint(SizablePaint labelBackgroundPaint){
			this.labelBackgroundPaint = labelBackgroundPaint;
			return this;
		}
		
		/**
		 * Specifies the font to use on the Label
		 *
		 * @param labelFontFamily The {@link FontFamily} for the Label's font
		 * @param labelFontStyle The font style for the Label
		 * @param labelFontSize The font size for the Label
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> labelFont(FontFamily labelFontFamily, int labelFontStyle,  int labelFontSize){
			this.labelFontFamily = labelFontFamily;
			this.labelFontStyle = labelFontStyle;
			this.labelFontSize = labelFontSize;
			return this;
		}
		
		/**
		 * @param labelShape The {@link ShapeInfo} to use for the Label
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> labelShape(ShapeInfo labelShape){
			this.labelShape = labelShape;
			return this;
		}
		
		/**
		 * @param labelBorder The {@link Border} to use for the Label
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> labelBorder(Border labelBorder){
			this.labelBorder = labelBorder;
			return this;
		}
		
		/*
		 * Positioning
		 */
		
		/**
		 * @param rowPos The row position of the field
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> rowPos(int rowPos){
			this.rowPos = rowPos;
			return this;
		}
		
		/**
		 * @param colPos The column position of the field
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> colPos(int colPos){
			this.colPos = colPos;
			return this;
		}
		
		/**
		 * @param rowSpan The row span of the field
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> rowSpan(int rowSpan){
			this.rowSpan = rowSpan;
			return this;
		}
		
		/**
		 * @param colSpan The column span of the field
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> colSpan(int colSpan){
			this.colSpan = colSpan;
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
		public FormFieldBuilder<Type> logFontResourceLoaderWarnings(boolean logFontResourceLoaderWarnings){
			this.logFontResourceLoaderWarnings = logFontResourceLoaderWarnings;
			return this;
		}
		
		/**
		 * @param logger An {@link EasyLogger} that will be sent to the FontResourceLoader by default
		 *  - can be ignored if you specify your own FontResourceLoader
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> logger(EasyLogger logger){
			this.logger = logger;
			return this;
		}
		
		/**
		 * @param graphEnv The {@link GraphicsEnvironment} to load fonts to in the FontResourceLoader
		 *  - can be ignored if you specify your own FontResourceLoader
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> graphEnv(GraphicsEnvironment graphEnv){
			this.graphEnv = graphEnv;
			return this;
		}
		
		/**
		 * @param fontFolder The path to the fonts folder to find font files in if needed in the FontResourceLoader
		 *  - can be ignored if you specify your own FontResourceLoader
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> fontFolder(String fontFolder){
			this.fontFolder = fontFolder;
			return this;
		}
		
		/**
		 * @param fontResourceLoader The {@link FontResourceLoader} to use in loading fonts and/or ensuring
		 *  they're in the system
		 * @return this, to continue building
		 */
		public FormFieldBuilder<Type> fontResourceLoader(FontResourceLoader fontResourceLoader){
			this.fontResourceLoader = fontResourceLoader;
			return this;
		}
		
		/**
		 * Builds the {@link FormField}
		 *
		 * @return A newly created {@link FormField}
		 * @throws Throwable If anything goes wrong in building the Form Field
		 */
		public abstract FormField<Type> build() throws Throwable;
	}
	
	/*
	 * The Basics
	 */
	/** The {@link FieldType} of this field */
	private final FieldType type;
	/** The name of this field (used as a key in {@link Form Forms}) */
	private final String key;
	/** The starting value of the field */
	private final Type defaultValue;
	
	/*
	 * Label Options
	 */
	/** The {@link LabelType} to use for this field */
	private final LabelType labelType;
	/** The {@link SizablePaint} for the foreground of the Label */
	private final SizablePaint labelForegroundPaint;
	/** The {@link SizablePaint} for the background of the Label */
	private final SizablePaint labelBackgroundPaint;
	/** The {@link FontFamily} for the Label's font */
	private final FontFamily labelFontFamily;
	/** The font style for the Label */
	private final int labelFontStyle;
	/** The font size for the Label */
	private final int labelFontSize;
	/** The {@link ShapeInfo} to use for the Label */
	private final ShapeInfo labelShape;
	/** The {@link Border} to use for the Label */
	private final Border labelBorder;
	
	/*
	 * Positioning
	 */
	/** The row position of this field */
	private final int rowPos;
	/** The column position of this field */
	private final int colPos;
	/** The row span of this field */
	private final int rowSpan;
	/** The column span of this field */
	private final int colSpan;
	
	/*
	 * Font Resource Loading
	 */
	/** Whether to log warnings generated by the FontResourceLoader
	 *  - can be ignored if you specify your own FontResourceLoader */
	private final boolean logFontResourceLoaderWarnings;
	/** An {@link EasyLogger} that will be sent to the FontResourceLoader by default
	 *  - can be ignored if you specify your own FontResourceLoader */
	private final EasyLogger logger;
	/** The {@link GraphicsEnvironment} to load a font to in the FontResourceLoader
	 *  - can be ignored if you specify your own FontResourceLoader */
	private final GraphicsEnvironment graphEnv;
	/** The path to the fonts folder to find font files in if needed in the FontResourceLoader
	 *  - can be ignored if you specify your own FontResourceLoader */
	private final String fontFolder;
	/** The {@link FontResourceLoader} to use for fonts on this field */
	private final FontResourceLoader fontResourceLoader;
	
	/**
	 * Creates a new FormField with the given parameters.
	 *
	 * @param type The {@link FieldType} of this field
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
	 */
	protected FormField(FieldType type, String key, Type defaultValue,
	                    LabelType labelType, SizablePaint labelForegroundPaint, SizablePaint labelBackgroundPaint,
	                    FontFamily labelFontFamily, int labelFontStyle, int labelFontSize,
	                    ShapeInfo labelShape, Border labelBorder,
	                    int rowPos, int colPos, int rowSpan, int colSpan,
	                    boolean logFontResourceLoaderWarnings, EasyLogger logger, GraphicsEnvironment graphEnv,
	                    String fontFolder, FontResourceLoader fontResourceLoader){
		// Set The Basics
		this.type = type;
		this.key = key;
		this.defaultValue = defaultValue;
		
		// Set the Label Options
		this.labelType = labelType;
		this.labelForegroundPaint = labelForegroundPaint;
		this.labelBackgroundPaint = labelBackgroundPaint;
		this.labelFontFamily = labelFontFamily;
		this.labelFontStyle = labelFontStyle;
		this.labelFontSize = labelFontSize;
		this.labelShape = labelShape;
		this.labelBorder = labelBorder;
		
		// Set the positioning
		this.rowPos = rowPos;
		this.colPos = colPos;
		this.rowSpan = rowSpan;
		this.colSpan = colSpan;
		
		// Set the font resource loader settings
		this.logFontResourceLoaderWarnings = logFontResourceLoaderWarnings;
		this.logger = logger;
		this.graphEnv = graphEnv;
		this.fontFolder = fontFolder;
		this.fontResourceLoader = fontResourceLoader;
	}
	
	/*
	 * The Basics
	 */
	
	/**
	 * @return The {@link FieldType} of this field
	 */
	public FieldType getType(){
		return type;
	}
	
	/**
	 * @return The name of this field (used as a key in {@link Form Forms})
	 */
	public String getKey(){
		return key;
	}
	
	/**
	 * @return The starting value of this field
	 */
	public Type getDefaultValue(){
		return defaultValue;
	}
	
	/*
	 * Label Options
	 */
	
	/**
	 * @return The {@link LabelType} to use for this field
	 */
	public LabelType getLabelType(){
		return labelType;
	}
	
	/**
	 * @return The {@link SizablePaint} for the foreground of the Label
	 */
	public SizablePaint getLabelForegroundPaint(){
		return labelForegroundPaint;
	}
	
	/**
	 * @return The {@link SizablePaint} for the background of the Label
	 */
	public SizablePaint getLabelBackgroundPaint(){
		return labelBackgroundPaint;
	}
	
	/**
	 * @return The {@link FontFamily} for the Label's font
	 */
	public FontFamily getLabelFontFamily(){
		return labelFontFamily;
	}
	
	/**
	 * @return The font style for the Label
	 */
	public int getLabelFontStyle(){
		return labelFontStyle;
	}
	
	/**
	 * @return The font size for the Label
	 */
	public int getLabelFontSize(){
		return labelFontSize;
	}
	
	/**
	 * @return The {@link ShapeInfo} to use for the Label
	 */
	public ShapeInfo getLabelShape(){
		return labelShape;
	}
	
	/**
	 * @return The {@link Border} to use for the Label
	 */
	public Border getLabelBorder(){
		return labelBorder;
	}
	
	/*
	 * Positioning
	 */
	
	/**
	 * @return The row position of this field
	 */
	public int getRowPos(){
		return rowPos;
	}
	
	/**
	 * @return The column position of this field
	 */
	public int getColPos(){
		return colPos;
	}
	
	/**
	 * @return The row span of this field
	 */
	public int getRowSpan(){
		return rowSpan;
	}
	
	/**
	 * @return The column span of this field
	 */
	public int getColSpan(){
		return colSpan;
	}
	
	/*
	 * Font Resource Loading
	 */
	
	/** @return Whether to log warnings generated by the FontResourceLoader
	 *  - can be ignored if you specify your own FontResourceLoader
	 */
	public boolean logFontResourceLoaderWarnings(){
		return logFontResourceLoaderWarnings;
	}
	
	/**
	 * @return An {@link EasyLogger} that will be sent to the FontResourceLoader by default
	 *  - can be ignored if you specify your own FontResourceLoader
	 */
	public EasyLogger getLogger(){
		return logger;
	}
	
	/**
	 * @return The {@link GraphicsEnvironment} to load a font to in the FontResourceLoader
	 *  - can be ignored if you specify your own FontResourceLoader
	 */
	public GraphicsEnvironment getGraphEnv(){
		return graphEnv;
	}
	
	/**
	 * @return The path to the fonts folder to find font files in if needed in the FontResourceLoader
	 *  - can be ignored if you specify your own FontResourceLoader
	 */
	public String getFontFolder(){
		return fontFolder;
	}
	
	/**
	 * @return The {@link FontResourceLoader} to use for fonts on this field
	 */
	public FontResourceLoader getFontResourceLoader(){
		return fontResourceLoader;
	}
	
	/*
	 * Field Component Methods
	 */
	
	/**
	 * Creates the {@link JComponent} to be used for this field.
	 *
	 * @return A newly created {@link JComponent} to use on the form
	 * @throws Throwable If anything goes wrong setting up the Component
	 */
	public abstract JComponent getComponent() throws Throwable;
	
	/**
	 * Takes in the {@link JComponent} for this field and grabs the data off of it, returning it in the proper
	 * format for the field to be repopulated on the form.
	 *
	 * @param component The {@link JComponent} associated with this field
	 * @return The data extracted from the {@link JComponent}
	 */
	public abstract Type getValue(JComponent component);
}
