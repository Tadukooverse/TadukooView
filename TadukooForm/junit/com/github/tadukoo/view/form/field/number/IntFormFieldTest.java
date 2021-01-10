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

public class IntFormFieldTest{
	private IntFormField field = IntFormField.builder().build();
	
	@Test
	public void testIsIntType(){
		assertEquals(FieldType.INT, field.getType());
	}
	
	@Test
	public void testDefaultDefaultValue(){
		assertEquals(Integer.valueOf(0), field.getDefaultValue());
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
		assertEquals(Integer.valueOf(1), field.getStepSize());
	}
	
	@Test
	public void testSetKey(){
		field = IntFormField.builder().key("Test").build();
		assertEquals("Test", field.getKey());
	}
	
	@Test
	public void testSetDefaultValue(){
		field = IntFormField.builder().defaultValue(25).build();
		assertEquals(Integer.valueOf(25), field.getDefaultValue());
	}
	
	@Test
	public void testSetLabelType(){
		field = IntFormField.builder().labelType(LabelType.TITLED_BORDER).build();
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
	}
	
	@Test
	public void testSetLabelForegroundPaint(){
		SizableColor red = new SizableColor(Color.RED);
		field = IntFormField.builder().labelForegroundPaint(red).build();
		assertEquals(red, field.getLabelForegroundPaint());
	}
	
	@Test
	public void testSetLabelBackgroundPaint(){
		SizableColor blue = new SizableColor(Color.BLUE);
		field = IntFormField.builder().labelBackgroundPaint(blue).build();
		assertEquals(blue, field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testSetRowPos(){
		field = IntFormField.builder().rowPos(5).build();
		assertEquals(5, field.getRowPos());
	}
	
	@Test
	public void testSetColPos(){
		field = IntFormField.builder().colPos(25).build();
		assertEquals(25, field.getColPos());
	}
	
	@Test
	public void testSetRowSpan(){
		field = IntFormField.builder().rowSpan(5).build();
		assertEquals(5, field.getRowSpan());
	}
	
	@Test
	public void testSetColSpan(){
		field = IntFormField.builder().colSpan(3).build();
		assertEquals(3, field.getColSpan());
	}
	
	@Test
	public void testSetMinValue(){
		field = IntFormField.builder().minValue(1).build();
		assertEquals(Integer.valueOf(1), field.getMinValue());
	}
	
	@Test
	public void testSetMaxValue(){
		field = IntFormField.builder().maxValue(125).build();
		assertEquals(Integer.valueOf(125), field.getMaxValue());
	}
	
	@Test
	public void testSetStepSize(){
		field = IntFormField.builder().stepSize(5).build();
		assertEquals(Integer.valueOf(5), field.getStepSize());
	}
	
	@Test
	public void testAllSettings(){
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		field = IntFormField.builder().key("Test").defaultValue(25)
				.labelType(LabelType.TITLED_BORDER).labelForegroundPaint(red).labelBackgroundPaint(blue)
				.rowPos(5).colPos(25).rowSpan(5).colSpan(3)
				.minValue(1).maxValue(125).stepSize(5).build();
		
		assertEquals("Test", field.getKey());
		assertEquals(Integer.valueOf(25), field.getDefaultValue());
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
		assertEquals(red, field.getLabelForegroundPaint());
		assertEquals(blue, field.getLabelBackgroundPaint());
		assertEquals(5, field.getRowPos());
		assertEquals(25, field.getColPos());
		assertEquals(5, field.getRowSpan());
		assertEquals(3, field.getColSpan());
		assertEquals(Integer.valueOf(1), field.getMinValue());
		assertEquals(Integer.valueOf(125), field.getMaxValue());
		assertEquals(Integer.valueOf(5), field.getStepSize());
	}
	
	@Test
	public void testGetValue(){
		assertEquals(Integer.valueOf(65),
				field.getValue(new JSpinner(new SpinnerNumberModel(65, null, null, 1))));
	}
}
