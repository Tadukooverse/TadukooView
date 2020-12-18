package com.github.tadukoo.view.form.field;

import org.junit.jupiter.api.Test;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropDownFormFieldTest{
	private DropDownFormField field = DropDownFormField.builder().build();
	
	@Test
	public void testDefaults(){
		assertEquals(FieldType.DROP_DOWN, field.getType());
		assertNull(field.getDefaultValue());
		assertEquals(LabelType.LABEL, field.getLabelType());
		assertEquals(1, field.getRowSpan());
		assertEquals(1, field.getColSpan());
		assertTrue(field.isEditable());
		assertArrayEquals(new String[]{}, field.getOptions());
	}
	
	@Test
	public void testSettings(){
		field = DropDownFormField.builder().key("Test").defaultValue("Derp").labelType(LabelType.TITLED_BORDER)
				.rowPos(2).colPos(5).rowSpan(3).colSpan(7)
				.editable(false).options(new String[]{"Test", "Derp"}).build();
		assertEquals("Test", field.getKey());
		assertEquals("Derp", field.getDefaultValue());
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
		assertEquals(2, field.getRowPos());
		assertEquals(5, field.getColPos());
		assertEquals(3, field.getRowSpan());
		assertEquals(7, field.getColSpan());
		assertFalse(field.isEditable());
		assertArrayEquals(new String[]{"Test", "Derp"}, field.getOptions());
	}
	
	@Test
	public void testGetComponent(){
		field = DropDownFormField.builder().defaultValue("Test").options(new String[]{"Derp", "Test"}).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof JComboBox);
		assertEquals("Test", ((JComboBox<?>) component).getSelectedItem());
		assertEquals(2, ((JComboBox<?>) component).getItemCount());
	}
	
	@Test
	public void testGetValueBadComponent(){
		assertNull(field.getValue(new JLabel("Derp")));
	}
	
	@Test
	public void testGetValue(){
		JComboBox<String> box = new JComboBox<>(new String[]{"Test", "Derp"});
		box.setSelectedItem("Derp");
		assertEquals("Derp", field.getValue(box));
	}
}
