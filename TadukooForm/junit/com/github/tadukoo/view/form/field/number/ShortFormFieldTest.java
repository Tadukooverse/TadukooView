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

public class ShortFormFieldTest{
	private ShortFormField field = ShortFormField.builder().build();
	
	@Test
	public void testIsShortType(){
		assertEquals(FieldType.SHORT, field.getType());
	}
	
	@Test
	public void testDefaultDefaultValue(){
		assertEquals(Short.valueOf((short) 0), field.getDefaultValue());
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
		assertEquals(Short.valueOf((short) 1), field.getStepSize());
	}
	
	@Test
	public void testSetKey(){
		field = ShortFormField.builder().key("Test").build();
		assertEquals("Test", field.getKey());
	}
	
	@Test
	public void testSetDefaultValue(){
		field = ShortFormField.builder().defaultValue((short) 25).build();
		assertEquals(Short.valueOf((short) 25), field.getDefaultValue());
	}
	
	@Test
	public void testSetLabelType(){
		field = ShortFormField.builder().labelType(LabelType.TITLED_BORDER).build();
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
	}
	
	@Test
	public void testSetLabelForegroundPaint(){
		SizableColor red = new SizableColor(Color.RED);
		field = ShortFormField.builder().labelForegroundPaint(red).build();
		assertEquals(red, field.getLabelForegroundPaint());
	}
	
	@Test
	public void testSetLabelBackgroundPaint(){
		SizableColor blue = new SizableColor(Color.BLUE);
		field = ShortFormField.builder().labelBackgroundPaint(blue).build();
		assertEquals(blue, field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testSetRowPos(){
		field = ShortFormField.builder().rowPos(5).build();
		assertEquals(5, field.getRowPos());
	}
	
	@Test
	public void testSetColPos(){
		field = ShortFormField.builder().colPos(25).build();
		assertEquals(25, field.getColPos());
	}
	
	@Test
	public void testSetRowSpan(){
		field = ShortFormField.builder().rowSpan(5).build();
		assertEquals(5, field.getRowSpan());
	}
	
	@Test
	public void testSetColSpan(){
		field = ShortFormField.builder().colSpan(3).build();
		assertEquals(3, field.getColSpan());
	}
	
	@Test
	public void testSetMinValue(){
		field = ShortFormField.builder().minValue((short) 1).build();
		assertEquals(Short.valueOf((short) 1), field.getMinValue());
	}
	
	@Test
	public void testSetMaxValue(){
		field = ShortFormField.builder().maxValue((short) 125).build();
		assertEquals(Short.valueOf((short) 125), field.getMaxValue());
	}
	
	@Test
	public void testSetStepSize(){
		field = ShortFormField.builder().stepSize((short) 5).build();
		assertEquals(Short.valueOf((short) 5), field.getStepSize());
	}
	
	@Test
	public void testAllSettings(){
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		field = ShortFormField.builder().key("Test").defaultValue((short) 25)
				.labelType(LabelType.TITLED_BORDER).labelForegroundPaint(red).labelBackgroundPaint(blue)
				.rowPos(5).colPos(25).rowSpan(5).colSpan(3)
				.minValue((short) 1).maxValue((short) 125).stepSize((short) 5).build();
		
		assertEquals("Test", field.getKey());
		assertEquals(Short.valueOf((short) 25), field.getDefaultValue());
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
		assertEquals(red, field.getLabelForegroundPaint());
		assertEquals(blue, field.getLabelBackgroundPaint());
		assertEquals(5, field.getRowPos());
		assertEquals(25, field.getColPos());
		assertEquals(5, field.getRowSpan());
		assertEquals(3, field.getColSpan());
		assertEquals(Short.valueOf((short) 1), field.getMinValue());
		assertEquals(Short.valueOf((short) 125), field.getMaxValue());
		assertEquals(Short.valueOf((short) 5), field.getStepSize());
	}
	
	@Test
	public void testGetValue(){
		assertEquals(Short.valueOf((short) 65),
				field.getValue(new JSpinner(new SpinnerNumberModel((short) 65, null, null, (short) 1))));
	}
}
