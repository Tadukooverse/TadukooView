package com.github.tadukoo.view.form.field.number;

import com.github.tadukoo.view.border.ShapedLineBorder;
import com.github.tadukoo.view.font.FontFamilies;
import com.github.tadukoo.view.form.field.FieldType;
import com.github.tadukoo.view.form.field.LabelType;
import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.shapes.Shapes;
import org.junit.jupiter.api.Test;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FloatFormFieldTest{
	private FloatFormField field = FloatFormField.builder().build();
	
	@Test
	public void testIsFloatType(){
		assertEquals(FieldType.FLOAT, field.getType());
	}
	
	@Test
	public void testDefaultDefaultValue(){
		assertEquals(Float.valueOf(0), field.getDefaultValue());
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
	public void testDefaultMinValue(){
		assertNull(field.getMinValue());
	}
	
	@Test
	public void testDefaultMaxValue(){
		assertNull(field.getMaxValue());
	}
	
	@Test
	public void testDefaultStepSzie(){
		assertEquals(Float.valueOf(1), field.getStepSize());
	}
	
	@Test
	public void testSetKey(){
		field = FloatFormField.builder().key("Test").build();
		assertEquals("Test", field.getKey());
	}
	
	@Test
	public void testSetDefaultValue(){
		field = FloatFormField.builder().defaultValue(25.0f).build();
		assertEquals(Float.valueOf(25), field.getDefaultValue());
	}
	
	@Test
	public void testSetLabelType(){
		field = FloatFormField.builder().labelType(LabelType.TITLED_BORDER).build();
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
	}
	
	@Test
	public void testSetLabelForegroundPaint(){
		SizableColor red = new SizableColor(Color.RED);
		field = FloatFormField.builder().labelForegroundPaint(red).build();
		assertEquals(red, field.getLabelForegroundPaint());
	}
	
	@Test
	public void testSetLabelBackgroundPaint(){
		SizableColor blue = new SizableColor(Color.BLUE);
		field = FloatFormField.builder().labelBackgroundPaint(blue).build();
		assertEquals(blue, field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testSetLabelFont(){
		field = FloatFormField.builder().labelFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 27).build();
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getLabelFontFamily());
		assertEquals(Font.BOLD, field.getLabelFontStyle());
		assertEquals(27, field.getLabelFontSize());
	}
	
	@Test
	public void testSetLabelShape(){
		field = FloatFormField.builder().labelShape(Shapes.CIRCLE.getShapeInfo()).build();
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getLabelShape());
	}
	
	@Test
	public void testSetLabelBorder(){
		Border labelBorder = ShapedLineBorder.builder().build();
		field = FloatFormField.builder().labelBorder(labelBorder).build();
		assertEquals(labelBorder, field.getLabelBorder());
	}
	
	@Test
	public void testSetRowPos(){
		field = FloatFormField.builder().rowPos(5).build();
		assertEquals(5, field.getRowPos());
	}
	
	@Test
	public void testSetColPos(){
		field = FloatFormField.builder().colPos(25).build();
		assertEquals(25, field.getColPos());
	}
	
	@Test
	public void testSetRowSpan(){
		field = FloatFormField.builder().rowSpan(5).build();
		assertEquals(5, field.getRowSpan());
	}
	
	@Test
	public void testSetColSpan(){
		field = FloatFormField.builder().colSpan(3).build();
		assertEquals(3, field.getColSpan());
	}
	
	@Test
	public void testSetMinValue(){
		field = FloatFormField.builder().minValue(1.0f).build();
		assertEquals(Float.valueOf(1), field.getMinValue());
	}
	
	@Test
	public void testSetMaxValue(){
		field = FloatFormField.builder().maxValue(125.0f).build();
		assertEquals(Float.valueOf(125), field.getMaxValue());
	}
	
	@Test
	public void testSetStepSize(){
		field = FloatFormField.builder().stepSize(5.0f).build();
		assertEquals(Float.valueOf(5), field.getStepSize());
	}
	
	@Test
	public void testAllSettings(){
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		Border labelBorder = ShapedLineBorder.builder().build();
		field = FloatFormField.builder().key("Test").defaultValue(25.0f)
				.labelType(LabelType.TITLED_BORDER).labelForegroundPaint(red).labelBackgroundPaint(blue)
				.labelFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 27)
				.labelShape(Shapes.CIRCLE.getShapeInfo()).labelBorder(labelBorder)
				.rowPos(5).colPos(25).rowSpan(5).colSpan(3)
				.minValue(1.0f).maxValue(125.0f).stepSize(5.0f).build();
		
		assertEquals("Test", field.getKey());
		assertEquals(Float.valueOf(25), field.getDefaultValue());
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
		assertEquals(red, field.getLabelForegroundPaint());
		assertEquals(blue, field.getLabelBackgroundPaint());
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getLabelFontFamily());
		assertEquals(Font.BOLD, field.getLabelFontStyle());
		assertEquals(27, field.getLabelFontSize());
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getLabelShape());
		assertEquals(labelBorder, field.getLabelBorder());
		assertEquals(5, field.getRowPos());
		assertEquals(25, field.getColPos());
		assertEquals(5, field.getRowSpan());
		assertEquals(3, field.getColSpan());
		assertEquals(Float.valueOf(1), field.getMinValue());
		assertEquals(Float.valueOf(125), field.getMaxValue());
		assertEquals(Float.valueOf(5), field.getStepSize());
	}
	
	@Test
	public void testGetValue(){
		assertEquals(Float.valueOf(65),
				field.getValue(new JSpinner(new SpinnerNumberModel(65.0f, null, null, 1.0f))));
	}
}
