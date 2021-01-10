package com.github.tadukoo.view.form.field;

import com.github.tadukoo.view.form.AbstractForm;
import com.github.tadukoo.view.paint.SizableColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormFormFieldTest{
	private FormFormField field = FormFormField.builder().build();
	private boolean savedValues = false;
	private AbstractForm form;
	
	@BeforeEach
	public void setup() throws Throwable{
		form = new AbstractForm(new HashMap<>()){
			
			@Override
			public void saveValues(){
				super.saveValues();
				savedValues = true;
			}
			
			@Override
			public void setDefaultFields(){
			
			}
		};
	}
	
	@Test
	public void testIsFormType(){
		assertEquals(FieldType.FORM, field.getType());
	}
	
	@Test
	public void testDefaultDefaultValue(){
		assertNull(field.getDefaultValue());
	}
	
	@Test
	public void testDefaultLabelType(){
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
	}
	
	@Test
	public void testDefaultLabelForegroundPaint(){
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
	
	@Test
	public void testSetKey(){
		field = FormFormField.builder().key("Test").build();
		assertEquals("Test", field.getKey());
	}
	
	@Test
	public void testSetDefaultValue(){
		field = FormFormField.builder().defaultValue(form).build();
		assertEquals(form, field.getDefaultValue());
	}
	
	@Test
	public void testSetLabelType(){
		field = FormFormField.builder().labelType(LabelType.LABEL).build();
		assertEquals(LabelType.LABEL, field.getLabelType());
	}
	
	@Test
	public void testSetLabelForegroundPaint(){
		SizableColor red = new SizableColor(Color.RED);
		field = FormFormField.builder().labelForegroundPaint(red).build();
		assertEquals(red, field.getLabelForegroundPaint());
	}
	
	@Test
	public void testSetLabelBackgroundPaint(){
		SizableColor blue = new SizableColor(Color.BLUE);
		field = FormFormField.builder().labelBackgroundPaint(blue).build();
		assertEquals(blue, field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testSetRowPos(){
		field = FormFormField.builder().rowPos(2).build();
		assertEquals(2, field.getRowPos());
	}
	
	@Test
	public void testSetColPos(){
		field = FormFormField.builder().colPos(5).build();
		assertEquals(5, field.getColPos());
	}
	
	@Test
	public void testSetRowSpan(){
		field = FormFormField.builder().rowSpan(3).build();
		assertEquals(3, field.getRowSpan());
	}
	
	@Test
	public void testSetColSpan(){
		field = FormFormField.builder().colSpan(7).build();
		assertEquals(7, field.getColSpan());
	}
	
	@Test
	public void testAllSettings(){
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		field = FormFormField.builder().key("Test").defaultValue(form)
				.labelType(LabelType.LABEL).labelForegroundPaint(red).labelBackgroundPaint(blue)
				.rowPos(2).colPos(5).rowSpan(3).colSpan(7).build();
		assertEquals("Test", field.getKey());
		assertEquals(form, field.getDefaultValue());
		assertEquals(LabelType.LABEL, field.getLabelType());
		assertEquals(red, field.getLabelForegroundPaint());
		assertEquals(blue, field.getLabelBackgroundPaint());
		assertEquals(2, field.getRowPos());
		assertEquals(5, field.getColPos());
		assertEquals(3, field.getRowSpan());
		assertEquals(7, field.getColSpan());
	}
	
	@Test
	public void testGetComponentNoForm(){
		JComponent component = field.getComponent();
		assertTrue(component instanceof JLabel);
		assertEquals("No value", ((JLabel) component).getText());
	}
	
	@Test
	public void testGetComponentForm(){
		field = FormFormField.builder().defaultValue(form).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof AbstractForm);
		assertEquals(form, component);
	}
	
	@Test
	public void testGetValueNotForm(){
		assertNull(field.getValue(new JLabel("Test")));
	}
	
	@Test
	public void testGetValueForm(){
		assertEquals(form, field.getValue(form));
		assertTrue(savedValues);
	}
}
