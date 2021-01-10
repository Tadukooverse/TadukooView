package com.github.tadukoo.view.form.field;

import com.github.tadukoo.util.time.DateUtil;
import com.github.tadukoo.view.border.ShapedLineBorder;
import com.github.tadukoo.view.font.FontFamilies;
import com.github.tadukoo.view.form.components.DateForm;
import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.shapes.Shapes;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import java.time.Month;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateFormFieldTest{
	private DateFormField field = DateFormField.builder().build();
	
	@Test
	public void testIsDateType(){
		assertEquals(FieldType.DATE, field.getType());
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
	public void testDefaultMinYear(){
		assertEquals(1900, field.getMinYear());
	}
	
	@Test
	public void testDefaultMaxYear(){
		assertEquals(2100, field.getMaxYear());
	}
	
	@Test
	public void testSetKey(){
		field = DateFormField.builder().key("Derp").build();
		assertEquals("Derp", field.getKey());
	}
	
	@Test
	public void testSetDefaultValue(){
		Date date = DateUtil.createDate(Month.JULY, 4, 1776);
		field = DateFormField.builder().defaultValue(date).build();
		assertEquals(date, field.getDefaultValue());
	}
	
	@Test
	public void testSetLabelType(){
		field = DateFormField.builder().labelType(LabelType.TITLED_BORDER).build();
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
	}
	
	@Test
	public void testSetLabelForegroundPaint(){
		SizableColor red = new SizableColor(Color.RED);
		field = DateFormField.builder().labelForegroundPaint(red).build();
		assertEquals(red, field.getLabelForegroundPaint());
	}
	
	@Test
	public void testSetLabelBackgroundPaint(){
		SizableColor blue = new SizableColor(Color.BLUE);
		field = DateFormField.builder().labelBackgroundPaint(blue).build();
		assertEquals(blue, field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testSetLabelFont(){
		field = DateFormField.builder().labelFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 27).build();
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getLabelFontFamily());
		assertEquals(Font.BOLD, field.getLabelFontStyle());
		assertEquals(27, field.getLabelFontSize());
	}
	
	@Test
	public void testSetLabelShape(){
		field = DateFormField.builder().labelShape(Shapes.CIRCLE.getShapeInfo()).build();
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getLabelShape());
	}
	
	@Test
	public void testSetLabelBorder(){
		Border labelBorder = ShapedLineBorder.builder().build();
		field = DateFormField.builder().labelBorder(labelBorder).build();
		assertEquals(labelBorder, field.getLabelBorder());
	}
	
	@Test
	public void testSetRowPos(){
		field = DateFormField.builder().rowPos(5).build();
		assertEquals(5, field.getRowPos());
	}
	
	@Test
	public void testSetColPos(){
		field = DateFormField.builder().colPos(3).build();
		assertEquals(3, field.getColPos());
	}
	
	@Test
	public void testSetRowSpan(){
		field = DateFormField.builder().rowSpan(2).build();
		assertEquals(2, field.getRowSpan());
	}
	
	@Test
	public void testSetColSpan(){
		field = DateFormField.builder().colSpan(4).build();
		assertEquals(4, field.getColSpan());
	}
	
	@Test
	public void testSetMinYear(){
		field = DateFormField.builder().minYear(120).build();
		assertEquals(120, field.getMinYear());
	}
	
	@Test
	public void testSetMaxYear(){
		field = DateFormField.builder().maxYear(1920).build();
		assertEquals(1920, field.getMaxYear());
	}
	
	@Test
	public void testAllSettings(){
		Date date = DateUtil.createDate(Month.JULY, 4, 1776);
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		Border labelBorder = ShapedLineBorder.builder().build();
		field = DateFormField.builder().key("Derp").defaultValue(date)
				.labelType(LabelType.TITLED_BORDER).labelForegroundPaint(red).labelBackgroundPaint(blue)
				.labelFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 27)
				.labelShape(Shapes.CIRCLE.getShapeInfo()).labelBorder(labelBorder)
				.rowPos(5).colPos(3).rowSpan(2).colSpan(4).minYear(120).maxYear(1920).build();
		
		assertEquals(FieldType.DATE, field.getType());
		assertEquals("Derp", field.getKey());
		assertEquals(date, field.getDefaultValue());
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
		assertEquals(red, field.getLabelForegroundPaint());
		assertEquals(blue, field.getLabelBackgroundPaint());
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getLabelFontFamily());
		assertEquals(Font.BOLD, field.getLabelFontStyle());
		assertEquals(27, field.getLabelFontSize());
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getLabelShape());
		assertEquals(labelBorder, field.getLabelBorder());
		assertEquals(5, field.getRowPos());
		assertEquals(3, field.getColPos());
		assertEquals(2, field.getRowSpan());
		assertEquals(4, field.getColSpan());
		assertEquals(120, field.getMinYear());
		assertEquals(1920, field.getMaxYear());
	}
	
	@Test
	public void testGetComponent() throws Throwable{
		field = DateFormField.builder().build();
		
		JComponent component = field.getComponent();
		assertTrue(component instanceof DateForm);
	}
	
	@Test
	public void testGetComponentDefaultValue() throws Throwable{
		Date date = DateUtil.createDate(Month.JULY, 4, 2000);
		field = DateFormField.builder().defaultValue(date).build();
		
		JComponent component = field.getComponent();
		assertTrue(component instanceof DateForm);
		DateForm dateForm = (DateForm) component;
		assertEquals(date, dateForm.getDate());
		assertEquals(Month.JULY, dateForm.getMonth());
		assertEquals(4, dateForm.getDay());
		assertEquals(2000, dateForm.getYear());
	}
	
	@Test
	public void testGetComponentMinYear() throws Throwable{
		field = DateFormField.builder().minYear(120).build();
		
		JComponent component = field.getComponent();
		assertTrue(component instanceof DateForm);
		DateForm dateForm = (DateForm) component;
		assertEquals(120, dateForm.getMinYear());
	}
	
	@Test
	public void testGetComponentMaxYear() throws Throwable{
		field = DateFormField.builder().maxYear(1920).build();
		
		JComponent component = field.getComponent();
		assertTrue(component instanceof DateForm);
		DateForm dateForm = (DateForm) component;
		assertEquals(1920, dateForm.getMaxYear());
	}
	
	@Test
	public void testGetComponentAllSettings() throws Throwable{
		Date date = DateUtil.createDate(Month.JULY, 4, 1776);
		field = DateFormField.builder().defaultValue(date).minYear(120).maxYear(1920).build();
		
		JComponent component = field.getComponent();
		assertTrue(component instanceof DateForm);
		DateForm dateForm = (DateForm) component;
		assertEquals(date, dateForm.getDate());
		assertEquals(Month.JULY, dateForm.getMonth());
		assertEquals(4, dateForm.getDay());
		assertEquals(1776, dateForm.getYear());
		assertEquals(120, dateForm.getMinYear());
		assertEquals(1920, dateForm.getMaxYear());
	}
	
	@Test
	public void testGetValue() throws Throwable{
		Date date = DateUtil.createDate(Month.JULY, 4, 1776);
		Date otherDate = field.getValue(new DateForm(date, 120, 1920));
		assertEquals(date, otherDate);
	}
	
	@Test
	public void testGetValueNotDateForm(){
		assertNull(field.getValue(new JLabel("Testing Stuff")));
	}
}
