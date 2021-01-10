package com.github.tadukoo.view.form.field;

import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.paint.SizablePaint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JLabel;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FormFieldTest{
	private final JLabel label = new JLabel("Derp");
	
	private class TestFormField extends FormField<String>{
		
		private TestFormField(FieldType type, String key, String defaultValue,
		                      LabelType labelType, SizablePaint labelForegroundPaint, SizablePaint labelBackgroundPaint,
		                      int rowPos, int colPos, int rowSpan, int colSpan,
		                      FontResourceLoader fontResourceLoader){
			super(type, key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					rowPos, colPos, rowSpan, colSpan, fontResourceLoader);
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
			return new TestFormField(FieldType.STRING, key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					rowPos, colPos, rowSpan, colSpan, fontResourceLoader);
		}
	}
	
	private FormField<String> field;
	
	@BeforeEach
	public void setup() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5).build();
	}
	
	/*
	 * Test Default Settings
	 */
	
	@Test
	public void testDefaultDefaultValue(){
		assertNull(field.getDefaultValue());
	}
	
	@Test
	public void testDefaultLabelType(){
		assertEquals(LabelType.LABEL, field.getLabelType());
	}
	
	@Test
	public void tesetDefaultLabelForegroundPaint(){
		assertNull(field.getLabelForegroundPaint());
	}
	
	@Test
	public void testDefaultLabelBackgroundPaint(){
		assertNull(field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testDefaultRowSpan(){
		assertEquals(1, field.getRowSpan());
	}
	
	@Test
	public void testDefaultColSpan(){
		assertEquals(1, field.getColSpan());
	}
	
	/*
	 * Test Settings
	 */
	
	@Test
	public void testSettingKey() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5).build();
		assertEquals("Test", field.getKey());
	}
	
	@Test
	public void testSettingDefaultValue() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.defaultValue("Yes").build();
		assertEquals("Yes", field.getDefaultValue());
	}
	
	@Test
	public void testSettingLabelType() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.labelType(LabelType.NONE).build();
		assertEquals(LabelType.NONE, field.getLabelType());
	}
	
	@Test
	public void testSettingLabelForegroundPaint() throws Throwable{
		SizablePaint red = new SizableColor(Color.RED);
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.labelForegroundPaint(red).build();
		assertEquals(red, field.getLabelForegroundPaint());
	}
	
	@Test
	public void testSettingLabelBackgroundPaint() throws Throwable{
		SizablePaint blue = new SizableColor(Color.BLUE);
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.labelBackgroundPaint(blue).build();
		assertEquals(blue, field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testSettingRowPos() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.rowPos(2).build();
		assertEquals(2, field.getRowPos());
	}
	
	@Test
	public void testSettingColPos() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.colPos(5).build();
		assertEquals(5, field.getColPos());
	}
	
	@Test
	public void testSettingRowSpan() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.rowSpan(3).build();
		assertEquals(3, field.getRowSpan());
	}
	
	@Test
	public void testSettingColSpan() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.colSpan(7).build();
		assertEquals(7, field.getColSpan());
	}
	
	@Test
	public void testAllSettings() throws Throwable{
		SizablePaint red = new SizableColor(Color.RED);
		SizablePaint blue = new SizableColor(Color.BLUE);
		FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
				null, "fonts/");
		field = new TestFormFieldBuilder().key("Test").defaultValue("Yes")
				.labelType(LabelType.NONE).labelForegroundPaint(red).labelBackgroundPaint(blue)
				.rowPos(2).colPos(5).rowSpan(3).colSpan(7).fontResourceLoader(fontResourceLoader).build();
		assertEquals(FieldType.STRING, field.getType());
		assertEquals("Test", field.getKey());
		assertEquals("Yes", field.getDefaultValue());
		assertEquals(LabelType.NONE, field.getLabelType());
		assertEquals(red, field.getLabelForegroundPaint());
		assertEquals(blue, field.getLabelBackgroundPaint());
		assertEquals(2, field.getRowPos());
		assertEquals(5, field.getColPos());
		assertEquals(3, field.getRowSpan());
		assertEquals(7, field.getColSpan());
		assertEquals(fontResourceLoader, field.getFontResourceLoader());
	}
	
	/*
	 * Test Component Methods
	 */
	
	@Test
	public void testGetComponent() throws Throwable{
		assertEquals(label, field.getComponent());
	}
	
	@Test
	public void testGetValue(){
		assertEquals("Derp", field.getValue(label));
	}
}
