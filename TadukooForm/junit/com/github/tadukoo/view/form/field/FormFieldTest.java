package com.github.tadukoo.view.form.field;

import com.github.tadukoo.view.font.FontResourceLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JLabel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FormFieldTest{
	private final JLabel label = new JLabel("Derp");
	
	private class TestFormField extends FormField<String>{
		
		private TestFormField(FieldType type, String key, String defaultValue, LabelType labelType,
		                      int rowPos, int colPos, int rowSpan, int colSpan,
		                      FontResourceLoader fontResourceLoader){
			super(type, key, defaultValue, labelType, rowPos, colPos, rowSpan, colSpan, fontResourceLoader);
		}
		
		@Override
		public JComponent getComponent(){
			return label;
		}
		
		@Override
		public String getValue(JComponent component){
			return label.getText();
		}
	}
	
	private class TestFormFieldBuilder extends FormField.FormFieldBuilder<String>{
		
		public TestFormFieldBuilder(){ }
		
		@Override
		public FormField<String> build(){
			return new TestFormField(FieldType.STRING, key, defaultValue, labelType,
					rowPos, colPos, rowSpan, colSpan, fontResourceLoader);
		}
	}
	
	private FormField<String> field;
	
	@BeforeEach
	public void setup() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5).build();
	}
	
	@Test
	public void testDefaults(){
		assertNull(field.getDefaultValue());
		assertEquals(LabelType.LABEL, field.getLabelType());
		assertEquals(1, field.getRowSpan());
		assertEquals(1, field.getColSpan());
	}
	
	@Test
	public void testSettings() throws Throwable{
		FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
				null, "fonts/");
		field = new TestFormFieldBuilder().key("Test").defaultValue("Yes").labelType(LabelType.NONE)
				.rowPos(2).colPos(5).rowSpan(3).colSpan(7).fontResourceLoader(fontResourceLoader).build();
		assertEquals(FieldType.STRING, field.getType());
		assertEquals("Test", field.getKey());
		assertEquals("Yes", field.getDefaultValue());
		assertEquals(LabelType.NONE, field.getLabelType());
		assertEquals(2, field.getRowPos());
		assertEquals(5, field.getColPos());
		assertEquals(3, field.getRowSpan());
		assertEquals(7, field.getColSpan());
		assertEquals(fontResourceLoader, field.getFontResourceLoader());
	}
	
	@Test
	public void testGetComponent() throws Throwable{
		assertEquals(label, field.getComponent());
	}
	
	@Test
	public void testGetValue(){
		assertEquals("Derp", field.getValue(label));
	}
}
