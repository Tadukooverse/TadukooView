package com.github.tadukoo.view.form.field;

import com.github.tadukoo.util.StringUtil;
import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.form.Form;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GraphicsEnvironment;

/**
 * String Form Field is a {@link FormField} that uses a String. This could be an input prompt or a title
 * (See {@link StringFieldType})
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 * @since Alpha v.0.2
 */
public class StringFormField extends FormField<String>{
	
	/**
	 * String Field Type is used to determine type of String field
	 */
	public enum StringFieldType{
		/** A normal {@link JTextField} - used as a text input prompt */
		NORMAL,
		/** A {@link JLabel} */
		TITLE,
		/** A {@link JPasswordField} - used as a text input prompt that hides the text */
		PASSWORD
	}
	
	/**
	 * Builder to be used to create a {@link StringFormField}. It has the following parameters:
	 *
	 * <table>
	 *     <caption>StringFormField Parameters</caption>
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
	 *         <td>stringFieldType</td>
	 *         <td>The {@link StringFieldType type} of String field</td>
	 *         <td>Defaults to {@link StringFieldType#NORMAL}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>editable</td>
	 *         <td>Whether the field can be edited or not</td>
	 *         <td>Defaults to true</td>
	 *     </tr>
	 *     <tr>
	 *         <td>columns</td>
	 *         <td>Number of columns used to determine the width of the field</td>
	 *         <td>Defaults to -1 (to use the defaultValue for determining size)</td>
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
	 * @since Alpha v.0.2
	 */
	public static class StringFormFieldBuilder extends FormFieldBuilder<String>{
		/** The {@link StringFieldType type} of String field */
		private StringFieldType stringFieldType = StringFieldType.NORMAL;
		/** Whether the field can be edited or not */
		private boolean editable = true;
		/** Number of columns used to determine the width of the field */
		private int columns = -1;
		
		// Can't create StringFormFieldBuilder outside of StringFormField
		private StringFormFieldBuilder(){
			super();
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder key(String key){
			super.key(key);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder defaultValue(String defaultValue){
			super.defaultValue(defaultValue);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder labelType(LabelType labelType){
			super.labelType(labelType);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder rowPos(int rowPos){
			super.rowPos(rowPos);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder colPos(int colPos){
			super.colPos(colPos);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder rowSpan(int rowSpan){
			super.rowSpan(rowSpan);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder colSpan(int colSpan){
			super.colSpan(colSpan);
			return this;
		}
		
		/*
		 * Font Resource Loading Methods
		 */
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder logFontResourceLoaderWarnings(boolean logFontResourceLoaderWarnings){
			super.logFontResourceLoaderWarnings(logFontResourceLoaderWarnings);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder logger(EasyLogger logger){
			super.logger(logger);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder graphEnv(GraphicsEnvironment graphEnv){
			super.graphEnv(graphEnv);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder fontFolder(String fontFolder){
			super.fontFolder(fontFolder);
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormFieldBuilder fontResourceLoader(FontResourceLoader fontResourceLoader){
			super.fontResourceLoader(fontResourceLoader);
			return this;
		}
		
		/**
		 * @param stringFieldType The {@link StringFieldType type} of String field
		 * @return this, to continue building
		 */
		public StringFormFieldBuilder stringFieldType(StringFieldType stringFieldType){
			this.stringFieldType = stringFieldType;
			return this;
		}
		
		/**
		 * @param editable Whether the field can be edited or not
		 * @return this, to continue building
		 */
		public StringFormFieldBuilder editable(boolean editable){
			this.editable = editable;
			return this;
		}
		
		/**
		 * @param columns Number of columns used to determine the width of the field
		 * @return this, to continue building
		 */
		public StringFormFieldBuilder columns(int columns){
			this.columns = columns;
			return this;
		}
		
		/** {@inheritDoc} */
		@Override
		public StringFormField build(){
			return new StringFormField(key, defaultValue, labelType,
					rowPos, colPos, rowSpan, colSpan,
					fontResourceLoader,
					stringFieldType, editable, columns);
		}
	}
	
	/** The {@link StringFieldType type} of String field */
	private final StringFieldType stringFieldType;
	/** Whether this field can be edited or not */
	private final boolean editable;
	/** Number of columns used to determine the width of this field */
	private final int columns;
	
	/**
	 * Creates a new StringFormField with the given parameters
	 *
	 * @param key The name of this field (used as a key in Forms)
	 * @param defaultValue The starting value of the field
	 * @param labelType The {@link LabelType} to use for this field
	 * @param rowPos The row position of this field
	 * @param colPos The column position of this field
	 * @param rowSpan The row span of this field
	 * @param colSpan The column span of this field
	 * @param fontResourceLoader The {@link FontResourceLoader} to use for fonts on this field
	 * @param stringFieldType The {@link StringFieldType type} of String field
	 * @param editable Whether this field can be edited or not
	 * @param columns Number of columns used to determine the width of this field
	 */
	private StringFormField(String key, String defaultValue, LabelType labelType,
	                        int rowPos, int colPos, int rowSpan, int colSpan,
	                        FontResourceLoader fontResourceLoader,
	                        StringFieldType stringFieldType, boolean editable, int columns){
		super(FieldType.STRING, key, defaultValue, labelType, rowPos, colPos, rowSpan, colSpan,
				fontResourceLoader);
		this.stringFieldType = stringFieldType;
		this.editable = editable;
		this.columns = columns;
	}
	
	/**
	 * @return A new {@link StringFormFieldBuilder} to use to make a {@link StringFormField}
	 */
	public static StringFormFieldBuilder builder(){
		return new StringFormFieldBuilder();
	}
	
	/**
	 * @return The {@link StringFieldType type} of String field
	 */
	public StringFieldType getStringFieldType(){
		return stringFieldType;
	}
	
	/**
	 * @return Whether this field can be edited or not
	 */
	public boolean isEditable(){
		return editable;
	}
	
	/**
	 * @return Number of columns used to determine the width of the field
	 */
	public int getColumns(){
		return columns;
	}
	
	/** {@inheritDoc} */
	@Override
	public JComponent getComponent(){
		String value = getDefaultValue();
		
		// Create the appropriate text field type based on the String Field Type
		JTextField textField = null;
		switch(stringFieldType){
			case TITLE -> {
				return new JLabel(value);
			}
			case NORMAL -> textField = new JTextField();
			case PASSWORD -> textField = new JPasswordField();
		}
		
		// Set the text on the field if default value isn't blank
		if(StringUtil.isNotBlank(value)){
			textField.setText(value);
		}
		
		// Set editable
		textField.setEditable(editable);
		
		// Set columns if it's defined, or default to 25 if columns is not defined + default value is blank
		if(columns != -1){
			textField.setColumns(columns);
		}else if(StringUtil.isBlank(value)){
			textField.setColumns(25);
		}
		
		return textField;
	}
	
	/** {@inheritDoc} */
	@Override
	public String getValue(JComponent component){
		if(component instanceof JLabel){
			return ((JLabel) component).getText();
		}else if(component instanceof JTextField){
			return ((JTextField) component).getText();
		}else{
			return null;
		}
	}
}
