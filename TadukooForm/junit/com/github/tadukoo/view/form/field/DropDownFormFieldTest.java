package com.github.tadukoo.view.form.field;

import com.github.tadukoo.view.border.ShapedLineBorder;
import com.github.tadukoo.view.font.FontFamilies;
import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.shapes.Shapes;
import org.junit.jupiter.api.Test;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropDownFormFieldTest{
	private DropDownFormField field = DropDownFormField.builder().build();
	
	@Test
	public void testIsDropDownType(){
		assertEquals(FieldType.DROP_DOWN, field.getType());
	}
	
	@Test
	public void testDefaultDefaultValue(){
		assertNull(field.getDefaultValue());
	}
	
	@Test
	public void testDefaultLabelType(){
		assertEquals(LabelType.LABEL, field.getLabelType());
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
	public void testDefaultLabelFontFamily(){
		assertNull(field.getLabelFontFamily());
	}
	
	@Test
	public void testDefaultLabelFontStyle(){
		assertEquals(-1, field.getLabelFontStyle());
	}
	
	@Test
	public void testDefaultLabelFontSize(){
		assertEquals(-1, field.getLabelFontSize());
	}
	
	@Test
	public void testDefaultLabelShape(){
		assertNull(field.getLabelShape());
	}
	
	@Test
	public void testDefaultLabelBorder(){
		assertNull(field.getLabelBorder());
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
	public void testDefaultOptions(){
		assertArrayEquals(new String[]{}, field.getOptions());
	}
	
	@Test
	public void testSetKey(){
		field = DropDownFormField.builder().key("Test").build();
		assertEquals("Test", field.getKey());
	}
	
	@Test
	public void testSetDefaultValue(){
		field = DropDownFormField.builder().defaultValue("Derp").build();
		assertEquals("Derp", field.getDefaultValue());
	}
	
	@Test
	public void testSetLabelType(){
		field = DropDownFormField.builder().labelType(LabelType.TITLED_BORDER).build();
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
	}
	
	@Test
	public void testSetLabelForegroundPaint(){
		SizableColor red = new SizableColor(Color.RED);
		field = DropDownFormField.builder().labelForegroundPaint(red).build();
		assertEquals(red, field.getLabelForegroundPaint());
	}
	
	@Test
	public void testSetLabelBackgroundPaint(){
		SizableColor blue = new SizableColor(Color.BLUE);
		field = DropDownFormField.builder().labelBackgroundPaint(blue).build();
		assertEquals(blue, field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testSetLabelFont(){
		field = DropDownFormField.builder().labelFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 27).build();
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getLabelFontFamily());
		assertEquals(Font.BOLD, field.getLabelFontStyle());
		assertEquals(27, field.getLabelFontSize());
	}
	
	@Test
	public void testSetLabelShape(){
		field = DropDownFormField.builder().labelShape(Shapes.CIRCLE.getShapeInfo()).build();
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getLabelShape());
	}
	
	@Test
	public void testSetLabelBorder(){
		Border labelBorder = ShapedLineBorder.builder().build();
		field = DropDownFormField.builder().labelBorder(labelBorder).build();
		assertEquals(labelBorder, field.getLabelBorder());
	}
	
	@Test
	public void testSetRowPos(){
		field = DropDownFormField.builder().rowPos(2).build();
		assertEquals(2, field.getRowPos());
	}
	
	@Test
	public void testSetColPos(){
		field = DropDownFormField.builder().colPos(5).build();
		assertEquals(5, field.getColPos());
	}
	
	@Test
	public void testSetRowSpan(){
		field = DropDownFormField.builder().rowSpan(3).build();
		assertEquals(3, field.getRowSpan());
	}
	
	@Test
	public void testSetColSpan(){
		field = DropDownFormField.builder().colSpan(7).build();
		assertEquals(7, field.getColSpan());
	}
	
	@Test
	public void testSetEditable(){
		field = DropDownFormField.builder().editable(false).build();
		assertFalse(field.isEditable());
	}
	
	@Test
	public void testSetOptions(){
		field = DropDownFormField.builder().options(new String[]{"Test", "Derp"}).build();
		assertArrayEquals(new String[]{"Test", "Derp"}, field.getOptions());
	}
	
	@Test
	public void testAllSettings(){
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		Border labelBorder = ShapedLineBorder.builder().build();
		field = DropDownFormField.builder().key("Test").defaultValue("Derp")
				.labelType(LabelType.TITLED_BORDER).labelForegroundPaint(red).labelBackgroundPaint(blue)
				.labelFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 27)
				.labelShape(Shapes.CIRCLE.getShapeInfo()).labelBorder(labelBorder)
				.rowPos(2).colPos(5).rowSpan(3).colSpan(7)
				.editable(false).options(new String[]{"Test", "Derp"}).build();
		assertEquals("Test", field.getKey());
		assertEquals("Derp", field.getDefaultValue());
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
		assertEquals(red, field.getLabelForegroundPaint());
		assertEquals(blue, field.getLabelBackgroundPaint());
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getLabelFontFamily());
		assertEquals(Font.BOLD, field.getLabelFontStyle());
		assertEquals(27, field.getLabelFontSize());
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getLabelShape());
		assertEquals(labelBorder, field.getLabelBorder());
		assertEquals(2, field.getRowPos());
		assertEquals(5, field.getColPos());
		assertEquals(3, field.getRowSpan());
		assertEquals(7, field.getColSpan());
		assertFalse(field.isEditable());
		assertArrayEquals(new String[]{"Test", "Derp"}, field.getOptions());
	}
	
	@Test
	public void testGetComponent(){
		field = DropDownFormField.builder().build();
		
		JComponent component = field.getComponent();
		assertTrue(component instanceof JComboBox);
	}
	
	@Test
	public void testGetComponentDefaultValue(){
		field = DropDownFormField.builder().defaultValue("Test").options(new String[]{"Test"}).build();
		
		JComponent component = field.getComponent();
		assertTrue(component instanceof JComboBox);
		JComboBox<?> comboBox = (JComboBox<?>) component;
		assertEquals("Test", comboBox.getSelectedItem());
	}
	
	@Test
	public void testGetComponentOptions(){
		field = DropDownFormField.builder().options(new String[]{"Derp", "Test"}).build();
		
		JComponent component = field.getComponent();
		assertTrue(component instanceof JComboBox);
		JComboBox<?> comboBox = (JComboBox<?>) component;
		assertEquals(2, comboBox.getItemCount());
	}
	
	@Test
	public void testGetComponentAllSettings(){
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
