package com.github.tadukoo.view.form.field;

import com.github.tadukoo.util.LoggerUtil;
import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.border.ShapedBevelBorder;
import com.github.tadukoo.view.font.FontFamilies;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;
import com.github.tadukoo.view.shapes.Shapes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormFieldTest{
	private final JLabel label = new JLabel("Derp");
	
	private class TestFormField extends FormField<String>{
		
		private TestFormField(FieldType type, String key, String defaultValue,
		                      LabelType labelType, SizablePaint labelForegroundPaint, SizablePaint labelBackgroundPaint,
		                      FontFamily labelFontFamily, int labelFontStyle, int labelFontSize,
		                      ShapeInfo labelShape, Border labelBorder,
		                      int rowPos, int colPos, int rowSpan, int colSpan,
		                      boolean logFontResourceLoaderWarnings, EasyLogger logger, GraphicsEnvironment graphEnv,
		                      String fontFolder, FontResourceLoader fontResourceLoader){
			super(type, key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					labelFontFamily, labelFontStyle, labelFontSize, labelShape, labelBorder,
					rowPos, colPos, rowSpan, colSpan,
					logFontResourceLoaderWarnings, logger, graphEnv,
					fontFolder, fontResourceLoader);
		}
		
		@Override
		public JComponent getComponent(){
			return label;
		}
		
		@Override
		public String getValue(JComponent component){
			return label.getText();
		}
	}
	
	private class TestFormFieldBuilder extends FormField.FormFieldBuilder<String>{
		
		public TestFormFieldBuilder(){ }
		
		@Override
		public FormField<String> build(){
			return new TestFormField(FieldType.STRING, key, defaultValue,
					labelType, labelForegroundPaint, labelBackgroundPaint,
					labelFontFamily, labelFontStyle, labelFontSize, labelShape, labelBorder,
					rowPos, colPos, rowSpan, colSpan,
					logFontResourceLoaderWarnings, logger, graphEnv,
					fontFolder, fontResourceLoader);
		}
	}
	
	private FormField<String> field;
	
	@BeforeEach
	public void setup() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5).build();
	}
	
	/*
	 * Test Default Settings
	 */
	
	@Test
	public void testDefaultDefaultValue(){
		assertNull(field.getDefaultValue());
	}
	
	@Test
	public void testDefaultLabelType(){
		assertEquals(LabelType.LABEL, field.getLabelType());
	}
	
	@Test
	public void tesetDefaultLabelForegroundPaint(){
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
	
	/*
	 * Test Settings
	 */
	
	@Test
	public void testSettingKey() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5).build();
		assertEquals("Test", field.getKey());
	}
	
	@Test
	public void testSettingDefaultValue() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.defaultValue("Yes").build();
		assertEquals("Yes", field.getDefaultValue());
	}
	
	@Test
	public void testSettingLabelType() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.labelType(LabelType.NONE).build();
		assertEquals(LabelType.NONE, field.getLabelType());
	}
	
	@Test
	public void testSettingLabelForegroundPaint() throws Throwable{
		SizablePaint red = new SizableColor(Color.RED);
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.labelForegroundPaint(red).build();
		assertEquals(red, field.getLabelForegroundPaint());
	}
	
	@Test
	public void testSettingLabelBackgroundPaint() throws Throwable{
		SizablePaint blue = new SizableColor(Color.BLUE);
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.labelBackgroundPaint(blue).build();
		assertEquals(blue, field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testSettingLabelFont() throws Throwable{
		field = new TestFormFieldBuilder().labelFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 27)
				.build();
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getLabelFontFamily());
		assertEquals(Font.BOLD, field.getLabelFontStyle());
		assertEquals(27, field.getLabelFontSize());
	}
	
	@Test
	public void testSettingLabelShape() throws Throwable{
		ShapeInfo shape = Shapes.CIRCLE.getShapeInfo();
		field = new TestFormFieldBuilder().labelShape(shape).build();
		assertEquals(shape, field.getLabelShape());
	}
	
	@Test
	public void testSettingLabelBorder() throws Throwable{
		Border border = ShapedBevelBorder.builder().build();
		field = new TestFormFieldBuilder().labelBorder(border).build();
		assertEquals(border, field.getLabelBorder());
	}
	
	@Test
	public void testSettingRowPos() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.rowPos(2).build();
		assertEquals(2, field.getRowPos());
	}
	
	@Test
	public void testSettingColPos() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.colPos(5).build();
		assertEquals(5, field.getColPos());
	}
	
	@Test
	public void testSettingRowSpan() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.rowSpan(3).build();
		assertEquals(3, field.getRowSpan());
	}
	
	@Test
	public void testSettingColSpan() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.colSpan(7).build();
		assertEquals(7, field.getColSpan());
	}
	
	@Test
	public void testSettingLogFontResourceLoaderWarnings() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.logFontResourceLoaderWarnings(true).build();
		assertTrue(field.logFontResourceLoaderWarnings());
	}
	
	@Test
	public void testSettingLogger() throws Throwable{
		EasyLogger logger = new EasyLogger(LoggerUtil.createFileLogger("target/garbo/test.log", Level.OFF));
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.logger(logger).build();
		assertEquals(logger, field.getLogger());
	}
	
	@Test
	public void testSettingGraphEnv() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.graphEnv(null).build();
		assertNull(field.getGraphEnv());
	}
	
	@Test
	public void testSettingFontFolder() throws Throwable{
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.fontFolder("testing/").build();
		assertEquals("testing/", field.getFontFolder());
	}
	
	@Test
	public void testSettingFontResourceLoader() throws Throwable{
		FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
				null, "fonts/");
		field = new TestFormFieldBuilder().key("Test").rowPos(2).colPos(5)
				.fontResourceLoader(fontResourceLoader).build();
		assertEquals(fontResourceLoader, field.getFontResourceLoader());
	}
	
	@Test
	public void testAllSettings() throws Throwable{
		SizablePaint red = new SizableColor(Color.RED);
		SizablePaint blue = new SizableColor(Color.BLUE);
		ShapeInfo shape = Shapes.CIRCLE.getShapeInfo();
		Border border = ShapedBevelBorder.builder().build();
		EasyLogger logger = new EasyLogger(LoggerUtil.createFileLogger("target/garbo/test.log", Level.OFF));
		FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
				null, "fonts/");
		field = new TestFormFieldBuilder().key("Test").defaultValue("Yes")
				.labelType(LabelType.NONE).labelForegroundPaint(red).labelBackgroundPaint(blue)
				.labelFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 27)
				.labelShape(shape).labelBorder(border)
				.rowPos(2).colPos(5).rowSpan(3).colSpan(7)
				.logFontResourceLoaderWarnings(true).logger(logger).graphEnv(null).fontFolder("testing/")
				.fontResourceLoader(fontResourceLoader).build();
		assertEquals(FieldType.STRING, field.getType());
		assertEquals("Test", field.getKey());
		assertEquals("Yes", field.getDefaultValue());
		assertEquals(LabelType.NONE, field.getLabelType());
		assertEquals(red, field.getLabelForegroundPaint());
		assertEquals(blue, field.getLabelBackgroundPaint());
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getLabelFontFamily());
		assertEquals(Font.BOLD, field.getLabelFontStyle());
		assertEquals(27, field.getLabelFontSize());
		assertEquals(shape, field.getLabelShape());
		assertEquals(border, field.getLabelBorder());
		assertEquals(2, field.getRowPos());
		assertEquals(5, field.getColPos());
		assertEquals(3, field.getRowSpan());
		assertEquals(7, field.getColSpan());
		assertTrue(field.logFontResourceLoaderWarnings());
		assertEquals(logger, field.getLogger());
		assertNull(field.getGraphEnv());
		assertEquals("testing/", field.getFontFolder());
		assertEquals(fontResourceLoader, field.getFontResourceLoader());
	}
	
	/*
	 * Test Component Methods
	 */
	
	@Test
	public void testGetComponent() throws Throwable{
		assertEquals(label, field.getComponent());
	}
	
	@Test
	public void testGetValue(){
		assertEquals("Derp", field.getValue(label));
	}
}
