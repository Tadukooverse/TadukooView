package com.github.tadukoo.view.form.field;

import com.github.tadukoo.util.LoggerUtil;
import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.border.ShapedLineBorder;
import com.github.tadukoo.view.components.TadukooLabel;
import com.github.tadukoo.view.font.FontFamilies;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.shapes.Shapes;
import org.junit.jupiter.api.Test;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringFormFieldTest{
	private StringFormField field = StringFormField.builder().build();
	
	@Test
	public void testIsStringType(){
		assertEquals(FieldType.STRING, field.getType());
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
	public void testDefaultStringFieldType(){
		assertEquals(StringFormField.StringFieldType.NORMAL, field.getStringFieldType());
	}
	
	@Test
	public void testDefaultEditable(){
		assertTrue(field.isEditable());
	}
	
	@Test
	public void testDefaultColumns(){
		assertEquals(-1, field.getColumns());
	}
	
	@Test
	public void testDefaultStringBackgroundPaint(){
		assertNull(field.getStringBackgroundPaint());
	}
	
	@Test
	public void testDefaultStringForegroundPaint(){
		assertNull(field.getStringForegroundPaint());
	}
	
	@Test
	public void testDefaultStringDisabledForegroundPaint(){
		assertNull(field.getStringDisabledForegroundPaint());
	}
	
	@Test
	public void testSetKey(){
		field = StringFormField.builder().key("Test").build();
		assertEquals("Test", field.getKey());
	}
	
	@Test
	public void testSetDefaultValue(){
		field = StringFormField.builder().defaultValue("Yes").build();
		assertEquals("Yes", field.getDefaultValue());
	}
	
	@Test
	public void testSetLabelType(){
		field = StringFormField.builder().labelType(LabelType.NONE).build();
		assertEquals(LabelType.NONE, field.getLabelType());
	}
	
	@Test
	public void testSetLabelForegroundPaint(){
		SizableColor red = new SizableColor(Color.RED);
		field = StringFormField.builder().labelForegroundPaint(red).build();
		assertEquals(red, field.getLabelForegroundPaint());
	}
	
	@Test
	public void testSetLabelBackgroundPaint(){
		SizableColor blue = new SizableColor(Color.BLUE);
		field = StringFormField.builder().labelBackgroundPaint(blue).build();
		assertEquals(blue, field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testSetLabelFont(){
		field = StringFormField.builder().labelFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 27).build();
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getLabelFontFamily());
		assertEquals(Font.BOLD, field.getLabelFontStyle());
		assertEquals(27, field.getLabelFontSize());
	}
	
	@Test
	public void testSetLabelShape(){
		field = StringFormField.builder().labelShape(Shapes.CIRCLE.getShapeInfo()).build();
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getLabelShape());
	}
	
	@Test
	public void testSetLabelBorder(){
		Border labelBorder = ShapedLineBorder.builder().build();
		field = StringFormField.builder().labelBorder(labelBorder).build();
		assertEquals(labelBorder, field.getLabelBorder());
	}
	
	@Test
	public void testSetRowPos(){
		field = StringFormField.builder().rowPos(2).build();
		assertEquals(2, field.getRowPos());
	}
	
	@Test
	public void testSetColPos(){
		field = StringFormField.builder().colPos(5).build();
		assertEquals(5, field.getColPos());
	}
	
	@Test
	public void testSetRowSpan(){
		field = StringFormField.builder().rowSpan(3).build();
		assertEquals(3, field.getRowSpan());
	}
	
	@Test
	public void testSetColSpan(){
		field = StringFormField.builder().colSpan(7).build();
		assertEquals(7, field.getColSpan());
	}
	
	@Test
	public void testSetLogFontResourceLoaderWarnings(){
		field = StringFormField.builder()
				.logFontResourceLoaderWarnings(true).build();
		assertTrue(field.logFontResourceLoaderWarnings());
	}
	
	@Test
	public void testSetLogger() throws IOException{
		EasyLogger logger = new EasyLogger(LoggerUtil.createFileLogger("target/garbo/test.log", Level.OFF));
		field = StringFormField.builder()
				.logger(logger).build();
		assertEquals(logger, field.getLogger());
	}
	
	@Test
	public void testSetGraphEnv(){
		field = StringFormField.builder()
				.graphEnv(null).build();
		assertNull(field.getGraphEnv());
	}
	
	@Test
	public void testSetFontFolder(){
		field = StringFormField.builder()
				.fontFolder("testing/").build();
		assertEquals("testing/", field.getFontFolder());
	}
	
	@Test
	public void testSetFontResourceLoader(){
		FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
				null, "fonts/");
		field = StringFormField.builder()
				.fontResourceLoader(fontResourceLoader).build();
		assertEquals(fontResourceLoader, field.getFontResourceLoader());
	}
	
	@Test
	public void testSetStringFieldType(){
		field = StringFormField.builder().stringFieldType(StringFormField.StringFieldType.PASSWORD).build();
		assertEquals(StringFormField.StringFieldType.PASSWORD, field.getStringFieldType());
	}
	
	@Test
	public void testSetEditable(){
		field = StringFormField.builder().editable(false).build();
		assertFalse(field.isEditable());
	}
	
	@Test
	public void testSetColumns(){
		field = StringFormField.builder().columns(27).build();
		assertEquals(27, field.getColumns());
	}
	
	@Test
	public void testSetStringBackgroundPaint(){
		SizableColor red = new SizableColor(Color.RED);
		field = StringFormField.builder().stringBackgroundPaint(red).build();
		assertEquals(red, field.getStringBackgroundPaint());
	}
	
	@Test
	public void testSetStringForegroundPaint(){
		SizableColor blue = new SizableColor(Color.BLUE);
		field = StringFormField.builder().stringForegroundPaint(blue).build();
		assertEquals(blue, field.getStringForegroundPaint());
	}
	
	@Test
	public void testSetStringDisabledForegroundPaint(){
		SizableColor black = new SizableColor(Color.BLACK);
		field = StringFormField.builder().stringDisabledForegroundPaint(black).build();
		assertEquals(black, field.getStringDisabledForegroundPaint());
	}
	
	@Test
	public void testSettings() throws IOException{
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		SizableColor black = new SizableColor(Color.BLACK);
		Border labelBorder = ShapedLineBorder.builder().build();
		EasyLogger logger = new EasyLogger(LoggerUtil.createFileLogger("target/garbo/test.log", Level.OFF));
		FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
				null, "fonts/");
		field = StringFormField.builder().key("Test").defaultValue("Yes")
				.labelType(LabelType.NONE).labelForegroundPaint(red).labelBackgroundPaint(blue)
				.labelFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 27)
				.labelShape(Shapes.CIRCLE.getShapeInfo()).labelBorder(labelBorder)
				.rowPos(2).colPos(5).rowSpan(3).colSpan(7)
				.logFontResourceLoaderWarnings(true).logger(logger).graphEnv(null).fontFolder("testing/")
				.fontResourceLoader(fontResourceLoader)
				.stringFieldType(StringFormField.StringFieldType.PASSWORD)
				.stringBackgroundPaint(red).stringForegroundPaint(blue).stringDisabledForegroundPaint(black)
				.editable(false).columns(27).build();
		assertEquals("Test", field.getKey());
		assertEquals("Yes", field.getDefaultValue());
		assertEquals(LabelType.NONE, field.getLabelType());
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
		assertTrue(field.logFontResourceLoaderWarnings());
		assertEquals(logger, field.getLogger());
		assertNull(field.getGraphEnv());
		assertEquals("testing/", field.getFontFolder());
		assertEquals(fontResourceLoader, field.getFontResourceLoader());
		assertEquals(StringFormField.StringFieldType.PASSWORD, field.getStringFieldType());
		assertFalse(field.isEditable());
		assertEquals(27, field.getColumns());
		assertEquals(red, field.getStringBackgroundPaint());
		assertEquals(blue, field.getStringForegroundPaint());
		assertEquals(black, field.getStringDisabledForegroundPaint());
	}
	
	@Test
	public void testGetComponentNormal() throws IOException, FontFormatException{
		field = StringFormField.builder().defaultValue("Derp")
				.stringFieldType(StringFormField.StringFieldType.NORMAL).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof JTextField);
		assertEquals("Derp", ((JTextField) component).getText());
	}
	
	@Test
	public void testGetComponentTitle() throws IOException, FontFormatException{
		field = StringFormField.builder().defaultValue("Test")
				.stringFieldType(StringFormField.StringFieldType.TITLE).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof TadukooLabel);
		assertEquals("Test", ((TadukooLabel) component).getText());
	}
	
	@Test
	public void testGetComponentTitleSetBackgroundPaint() throws IOException, FontFormatException{
		SizableColor red = new SizableColor(Color.RED);
		field = StringFormField.builder().defaultValue("Derp")
				.stringFieldType(StringFormField.StringFieldType.TITLE)
				.stringBackgroundPaint(red)
				.build();
		assertEquals(red, ((TadukooLabel) field.getComponent()).getBackgroundPaint());
	}
	
	@Test
	public void testGetComponentTitleSetForegroundPaint() throws IOException, FontFormatException{
		SizableColor blue = new SizableColor(Color.BLUE);
		field = StringFormField.builder().defaultValue("Derp")
				.stringFieldType(StringFormField.StringFieldType.TITLE)
				.stringForegroundPaint(blue)
				.build();
		assertEquals(blue, ((TadukooLabel) field.getComponent()).getForegroundPaint());
	}
	
	@Test
	public void testGetComponentTitleSetDisabledForegroundPaint() throws IOException, FontFormatException{
		SizableColor black = new SizableColor(Color.BLACK);
		field = StringFormField.builder().defaultValue("Derp")
				.stringFieldType(StringFormField.StringFieldType.TITLE)
				.stringDisabledForegroundPaint(black)
				.build();
		assertEquals(black, ((TadukooLabel) field.getComponent()).getDisabledForegroundPaint());
	}
	
	@Test
	public void testGetComponentTitleSetAll() throws IOException, FontFormatException{
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		SizableColor black = new SizableColor(Color.BLACK);
		field = StringFormField.builder().defaultValue("Derp")
				.stringFieldType(StringFormField.StringFieldType.TITLE)
				.stringBackgroundPaint(red).stringForegroundPaint(blue).stringDisabledForegroundPaint(black)
				.build();
		TadukooLabel label = ((TadukooLabel) field.getComponent());
		assertEquals(red, label.getBackgroundPaint());
		assertEquals(blue, label.getForegroundPaint());
		assertEquals(black, label.getDisabledForegroundPaint());
	}
	
	@Test
	public void testGetComponentPassword() throws IOException, FontFormatException{
		field = StringFormField.builder().defaultValue("Testy")
				.stringFieldType(StringFormField.StringFieldType.PASSWORD).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof JPasswordField);
		assertArrayEquals(new char[]{'T', 'e', 's', 't', 'y'}, ((JPasswordField) component).getPassword());
	}
	
	@Test
	public void testGetComponentDefaultColumns() throws IOException, FontFormatException{
		assertEquals(25, ((JTextField) field.getComponent()).getColumns());
	}
	
	@Test
	public void testGetComponentSetColumns() throws IOException, FontFormatException{
		field = StringFormField.builder().columns(19).build();
		assertEquals(19, ((JTextField) field.getComponent()).getColumns());
	}
	
	@Test
	public void testGetValueNormal(){
		assertEquals("Testy", field.getValue(new JTextField("Testy")));
	}
	
	@Test
	public void testGetValueTitle(){
		assertEquals("Yep", field.getValue(new JLabel("Yep")));
	}
	
	@Test
	public void testGetValuePassword(){
		assertEquals("A Password", field.getValue(new JPasswordField("A Password")));
	}
	
	@Test
	public void testGetValueRandomComponent(){
		assertNull(field.getValue(new JButton("Testing")));
	}
}
