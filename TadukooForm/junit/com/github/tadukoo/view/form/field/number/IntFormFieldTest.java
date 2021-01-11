package com.github.tadukoo.view.form.field.number;

import com.github.tadukoo.util.LoggerUtil;
import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.border.ShapedLineBorder;
import com.github.tadukoo.view.font.FontFamilies;
import com.github.tadukoo.view.font.FontResourceLoader;
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
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	public void testDefaultLogFontResourceLoaderWarnings(){
		assertFalse(field.logFontResourceLoaderWarnings());
	}
	
	@Test
	public void testDefaultLogger(){
		assertNull(field.getLogger());
	}
	
	@Test
	public void testDefaultGraphEnv(){
		assertEquals(GraphicsEnvironment.getLocalGraphicsEnvironment(), field.getGraphEnv());
	}
	
	@Test
	public void testDefaultFontFolder(){
		assertEquals("fonts/", field.getFontFolder());
	}
	
	@Test
	public void testDefaultFontResourceLoader(){
		assertNull(field.getFontResourceLoader());
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
	public void testSetLabelFont(){
		field = IntFormField.builder().labelFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 27).build();
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getLabelFontFamily());
		assertEquals(Font.BOLD, field.getLabelFontStyle());
		assertEquals(27, field.getLabelFontSize());
	}
	
	@Test
	public void testSetLabelShape(){
		field = IntFormField.builder().labelShape(Shapes.CIRCLE.getShapeInfo()).build();
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getLabelShape());
	}
	
	@Test
	public void testSetLabelBorder(){
		Border labelBorder = ShapedLineBorder.builder().build();
		field = IntFormField.builder().labelBorder(labelBorder).build();
		assertEquals(labelBorder, field.getLabelBorder());
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
	public void testSetLogFontResourceLoaderWarnings(){
		field = IntFormField.builder()
				.logFontResourceLoaderWarnings(true).build();
		assertTrue(field.logFontResourceLoaderWarnings());
	}
	
	@Test
	public void testSetLogger() throws IOException{
		EasyLogger logger = new EasyLogger(LoggerUtil.createFileLogger("target/garbo/test.log", Level.OFF));
		field = IntFormField.builder()
				.logger(logger).build();
		assertEquals(logger, field.getLogger());
	}
	
	@Test
	public void testSetGraphEnv(){
		field = IntFormField.builder()
				.graphEnv(null).build();
		assertNull(field.getGraphEnv());
	}
	
	@Test
	public void testSetFontFolder(){
		field = IntFormField.builder()
				.fontFolder("testing/").build();
		assertEquals("testing/", field.getFontFolder());
	}
	
	@Test
	public void testSetFontResourceLoader(){
		FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
				null, "fonts/");
		field = IntFormField.builder()
				.fontResourceLoader(fontResourceLoader).build();
		assertEquals(fontResourceLoader, field.getFontResourceLoader());
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
	public void testAllSettings() throws IOException{
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		Border labelBorder = ShapedLineBorder.builder().build();
		EasyLogger logger = new EasyLogger(LoggerUtil.createFileLogger("target/garbo/test.log", Level.OFF));
		FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
				null, "fonts/");
		field = IntFormField.builder().key("Test").defaultValue(25)
				.labelType(LabelType.TITLED_BORDER).labelForegroundPaint(red).labelBackgroundPaint(blue)
				.labelFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 27)
				.labelShape(Shapes.CIRCLE.getShapeInfo()).labelBorder(labelBorder)
				.rowPos(5).colPos(25).rowSpan(5).colSpan(3)
				.logFontResourceLoaderWarnings(true).logger(logger).graphEnv(null).fontFolder("testing/")
				.fontResourceLoader(fontResourceLoader)
				.minValue(1).maxValue(125).stepSize(5).build();
		
		assertEquals("Test", field.getKey());
		assertEquals(Integer.valueOf(25), field.getDefaultValue());
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
		assertTrue(field.logFontResourceLoaderWarnings());
		assertEquals(logger, field.getLogger());
		assertNull(field.getGraphEnv());
		assertEquals("testing/", field.getFontFolder());
		assertEquals(fontResourceLoader, field.getFontResourceLoader());
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
