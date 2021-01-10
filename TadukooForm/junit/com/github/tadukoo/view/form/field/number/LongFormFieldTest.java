package com.github.tadukoo.view.form.field.number;

import com.github.tadukoo.view.form.field.FieldType;
import com.github.tadukoo.view.form.field.LabelType;
import com.github.tadukoo.view.paint.SizableColor;
import org.junit.jupiter.api.Test;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LongFormFieldTest{
	private LongFormField field = LongFormField.builder().build();
	
	@Test
	public void testIsLongType(){
		assertEquals(FieldType.LONG, field.getType());
	}
	
	@Test
	public void testDefaultDefaultValue(){
		assertEquals(Long.valueOf(0), field.getDefaultValue());
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
	public void testDefaultStepSize(){
		assertEquals(Long.valueOf(1), field.getStepSize());
	}
	
	@Test
	public void testSetKey(){
		field = LongFormField.builder().key("Test").build();
		assertEquals("Test", field.getKey());
	}
	
	@Test
	public void testSetDefaultValue(){
		field = LongFormField.builder().defaultValue(25L).build();
		assertEquals(Long.valueOf(25), field.getDefaultValue());
	}
	
	@Test
	public void testSetLabelType(){
		field = LongFormField.builder().labelType(LabelType.TITLED_BORDER).build();
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
	}
	
	@Test
	public void testSetLabelForegroundPaint(){
		SizableColor red = new SizableColor(Color.RED);
		field = LongFormField.builder().labelForegroundPaint(red).build();
		assertEquals(red, field.getLabelForegroundPaint());
	}
	
	@Test
	public void testSetLabelBackgroundPaint(){
		SizableColor blue = new SizableColor(Color.BLUE);
		field = LongFormField.builder().labelBackgroundPaint(blue).build();
		assertEquals(blue, field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testSetRowPos(){
		field = LongFormField.builder().rowPos(5).build();
		assertEquals(5, field.getRowPos());
	}
	
	@Test
	public void testSetColPos(){
		field = LongFormField.builder().colPos(25).build();
		assertEquals(25, field.getColPos());
	}
	
	@Test
	public void testSetRowSpan(){
		field = LongFormField.builder().rowSpan(5).build();
		assertEquals(5, field.getRowSpan());
	}
	
	@Test
	public void testSetColSpan(){
		field = LongFormField.builder().colSpan(3).build();
		assertEquals(3, field.getColSpan());
	}
	
	@Test
	public void testSetMinValue(){
		field = LongFormField.builder().minValue(1L).build();
		assertEquals(Long.valueOf(1), field.getMinValue());
	}
	
	@Test
	public void testSetMaxValue(){
		field = LongFormField.builder().maxValue(125L).build();
		assertEquals(Long.valueOf(125), field.getMaxValue());
	}
	
	@Test
	public void testSetStepSize(){
		field = LongFormField.builder().stepSize(5L).build();
		assertEquals(Long.valueOf(5), field.getStepSize());
	}
	
	@Test
	public void testAllSettings(){
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		field = LongFormField.builder().key("Test").defaultValue(25L)
				.labelType(LabelType.TITLED_BORDER).labelForegroundPaint(red).labelBackgroundPaint(blue)
				.rowPos(5).colPos(25).rowSpan(5).colSpan(3)
				.minValue(1L).maxValue(125L).stepSize(5L).build();
		
		assertEquals("Test", field.getKey());
		assertEquals(Long.valueOf(25), field.getDefaultValue());
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
		assertEquals(red, field.getLabelForegroundPaint());
		assertEquals(blue, field.getLabelBackgroundPaint());
		assertEquals(5, field.getRowPos());
		assertEquals(25, field.getColPos());
		assertEquals(5, field.getRowSpan());
		assertEquals(3, field.getColSpan());
		assertEquals(Long.valueOf(1), field.getMinValue());
		assertEquals(Long.valueOf(125), field.getMaxValue());
		assertEquals(Long.valueOf(5), field.getStepSize());
	}
	
	@Test
	public void testGetValue(){
		assertEquals(Long.valueOf(65),
				field.getValue(new JSpinner(new SpinnerNumberModel(65L, null, null, 1L))));
	}
}
