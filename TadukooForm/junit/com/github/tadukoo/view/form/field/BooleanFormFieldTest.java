package com.github.tadukoo.view.form.field;

import com.github.tadukoo.view.paint.SizableColor;
import org.junit.jupiter.api.Test;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooleanFormFieldTest{
	private BooleanFormField field = BooleanFormField.builder().build();
	
	@Test
	public void testTypeIsBoolean(){
		assertEquals(FieldType.BOOLEAN, field.getType());
	}
	
	@Test
	public void testDefaultDefaultValue(){
		assertFalse(field.getDefaultValue());
	}
	
	@Test
	public void testDefaultLabelType(){
		assertEquals(LabelType.NONE, field.getLabelType());
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
	public void testDefaultEditable(){
		assertTrue(field.isEditable());
	}
	
	@Test
	public void testSetKey(){
		field = BooleanFormField.builder().key("Test").build();
		assertEquals("Test", field.getKey());
	}
	
	@Test
	public void testSetDefaultValue(){
		field = BooleanFormField.builder().defaultValue(true).build();
		assertTrue(field.getDefaultValue());
	}
	
	@Test
	public void testSetLabelType(){
		field = BooleanFormField.builder().labelType(LabelType.TITLED_BORDER).build();
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
	}
	
	@Test
	public void testSetLabelForegroundPaint(){
		SizableColor red = new SizableColor(Color.RED);
		field = BooleanFormField.builder().labelForegroundPaint(red).build();
		assertEquals(red, field.getLabelForegroundPaint());
	}
	
	@Test
	public void testSetLabelBackgroundPaint(){
		SizableColor blue = new SizableColor(Color.BLUE);
		field = BooleanFormField.builder().labelBackgroundPaint(blue).build();
		assertEquals(blue, field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testSetRowPos(){
		field = BooleanFormField.builder().rowPos(2).build();
		assertEquals(2, field.getRowPos());
	}
	
	@Test
	public void testSetColPos(){
		field = BooleanFormField.builder().colPos(5).build();
		assertEquals(5, field.getColPos());
	}
	
	@Test
	public void testSetRowSpan(){
		field = BooleanFormField.builder().rowSpan(3).build();
		assertEquals(3, field.getRowSpan());
	}
	
	@Test
	public void testSetColSpan(){
		field = BooleanFormField.builder().colSpan(7).build();
		assertEquals(7, field.getColSpan());
	}
	
	@Test
	public void testAllSettings(){
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		field = BooleanFormField.builder().key("Test").defaultValue(true)
				.labelType(LabelType.TITLED_BORDER).labelForegroundPaint(red).labelBackgroundPaint(blue)
				.rowPos(2).colPos(5).rowSpan(3).colSpan(7)
				.editable(false).build();
		assertEquals("Test", field.getKey());
		assertTrue(field.getDefaultValue());
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
		assertEquals(red, field.getLabelForegroundPaint());
		assertEquals(blue, field.getLabelBackgroundPaint());
		assertEquals(2, field.getRowPos());
		assertEquals(5, field.getColPos());
		assertEquals(3, field.getRowSpan());
		assertEquals(7, field.getColSpan());
		assertFalse(field.isEditable());
	}
	
	@Test
	public void testGetComponent(){
		field = BooleanFormField.builder().key("Test").build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof JCheckBox);
		assertEquals("Test", ((JCheckBox) component).getText());
	}
	
	@Test
	public void testGetComponentDefaultValue(){
		field = BooleanFormField.builder().key("Test").defaultValue(true).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof JCheckBox);
		assertEquals("Test", ((JCheckBox) component).getText());
		assertTrue(((JCheckBox) component).isSelected());
	}
	
	@Test
	public void testGetComponentNotEditable(){
		field = BooleanFormField.builder().key("Test").editable(false).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof JCheckBox);
		assertEquals("Test", ((JCheckBox) component).getText());
		assertFalse(component.isEnabled());
	}
	
	@Test
	public void testGetComponentAllSettings(){
		field = BooleanFormField.builder().key("Test").defaultValue(true).editable(false).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof JCheckBox);
		assertEquals("Test", ((JCheckBox) component).getText());
		assertTrue(((JCheckBox) component).isSelected());
		assertFalse(component.isEnabled());
	}
	
	@Test
	public void testGetValueBadComponent(){
		assertNull(field.getValue(new JLabel("Yep")));
	}
	
	@Test
	public void testGetValue(){
		assertTrue(field.getValue(new JCheckBox("Testing", true)));
	}
}
