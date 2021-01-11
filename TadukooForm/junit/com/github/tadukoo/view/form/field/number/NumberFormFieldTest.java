package com.github.tadukoo.view.form.field.number;

import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.form.field.FieldType;
import com.github.tadukoo.view.form.field.LabelType;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import java.awt.GraphicsEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberFormFieldTest{
	
	private static class TestFormField extends NumberFormField<Integer>{
		
		private TestFormField(FieldType type, String key, Integer defaultValue,
		                      LabelType labelType, SizablePaint labelForegroundPaint, SizablePaint labelBackgroundPaint,
		                      FontFamily labelFontFamily, int labelFontStyle, int labelFontSize,
		                      ShapeInfo labelShape, Border labelBorder,
		                      int rowPos, int colPos, int rowSpan, int colSpan,
		                      boolean logFontResourceLoaderWarnings, EasyLogger logger, GraphicsEnvironment graphEnv,
		                      String fontFolder, FontResourceLoader fontResourceLoader,
		                      Integer minValue, Integer maxValue, Integer stepSize){
			super(type, key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					labelFontFamily, labelFontStyle, labelFontSize,
					labelShape, labelBorder,
					rowPos, colPos, rowSpan, colSpan,
					logFontResourceLoaderWarnings, logger, graphEnv,
					fontFolder, fontResourceLoader,
					minValue, maxValue, stepSize);
		}
		
		@Override
		protected Integer convertToType(Number number){
			return number.intValue();
		}
	}
	
	private static class TestFormFieldBuilder extends NumberFormField.NumberFormFieldBuilder<Integer>{
		
		@Override
		public NumberFormField<Integer> build(){
			return new TestFormField(FieldType.INT, key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					labelFontFamily, labelFontStyle, labelFontSize,
					labelShape, labelBorder,
					rowPos, colPos, rowSpan, colSpan,
					logFontResourceLoaderWarnings, logger, graphEnv,
					fontFolder, fontResourceLoader,
					minValue, maxValue, stepSize);
		}
	}
	
	private NumberFormField<Integer> field = new TestFormFieldBuilder().stepSize(54).build();
	
	@Test
	public void testDefaultMinValue(){
		assertNull(field.getMinValue());
	}
	
	@Test
	public void testDefaultMaxValue(){
		assertNull(field.getMaxValue());
	}
	
	@Test
	public void testSettings(){
		assertEquals(Integer.valueOf(54), field.getStepSize());
	}
	
	@Test
	public void testGetComponent() throws Throwable{
		field = (NumberFormField<Integer>) new TestFormFieldBuilder().minValue(20).maxValue(105)
				.stepSize(54).defaultValue(42).build();
		
		JComponent component = field.getComponent();
		assertTrue(component instanceof JSpinner);
		SpinnerModel model = ((JSpinner) component).getModel();
		assertTrue(model instanceof SpinnerNumberModel);
		assertEquals(20, ((SpinnerNumberModel) model).getMinimum());
		assertEquals(105, ((SpinnerNumberModel) model).getMaximum());
		assertEquals(54, ((SpinnerNumberModel) model).getStepSize());
		assertEquals(42, model.getValue());
	}
	
	@Test
	public void testGetValue(){
		assertEquals(Integer.valueOf(120),
				field.getValue(new JSpinner(
						new SpinnerNumberModel(120, null, null, 54))));
	}
	
	@Test
	public void testGetValueNotSpinner(){
		assertNull(field.getValue(new JLabel("Test")));
	}
}
