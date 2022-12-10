package com.github.tadukoo.view.form.field;

import com.github.tadukoo.util.LoggerUtil;
import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.border.ShapedLineBorder;
import com.github.tadukoo.view.components.TadukooButton;
import com.github.tadukoo.view.font.FontFamilies;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.Shapes;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ButtonFormFieldTest{
	private ButtonFormField field = ButtonFormField.builder().build();
	private final ActionListener testAction = e -> { };
	
	@Test
	public void testFieldTypeIsButton(){
		assertEquals(FieldType.BUTTON, field.getType());
	}
	
	@Test
	public void testDefaultDefaultValue(){
		assertNull(field.getDefaultValue());
	}
	
	@Test
	public void testDefaultLabelType(){
		assertEquals(LabelType.NONE, field.getLabelType());
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
	public void testSetKey(){
		field = ButtonFormField.builder().key("Test").build();
		assertEquals("Test", field.getKey());
	}
	
	@Test
	public void testSetDefaultValue(){
		field = ButtonFormField.builder().defaultValue("Yes").build();
		assertEquals("Yes", field.getDefaultValue());
	}
	
	@Test
	public void testSetLabelType(){
		field = ButtonFormField.builder().labelType(LabelType.TITLED_BORDER).build();
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
	}
	
	@Test
	public void testSetLabelForegroundPaint(){
		SizablePaint red = new SizableColor(Color.RED);
		field = ButtonFormField.builder().labelForegroundPaint(red).build();
		assertEquals(red, field.getLabelForegroundPaint());
	}
	
	@Test
	public void testSetLabelBackgroundPaint(){
		SizablePaint blue = new SizableColor(Color.BLUE);
		field = ButtonFormField.builder().labelBackgroundPaint(blue).build();
		assertEquals(blue, field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testSetLabelFont(){
		field = ButtonFormField.builder().labelFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 27).build();
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getLabelFontFamily());
		assertEquals(Font.BOLD, field.getLabelFontStyle());
		assertEquals(27, field.getLabelFontSize());
	}
	
	@Test
	public void testSetLabelShape(){
		field = ButtonFormField.builder().labelShape(Shapes.CIRCLE.getShapeInfo()).build();
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getLabelShape());
	}
	
	@Test
	public void testSetLabelBorder(){
		Border labelBorder = ShapedLineBorder.builder().build();
		field = ButtonFormField.builder().labelBorder(labelBorder).build();
		assertEquals(labelBorder, field.getLabelBorder());
	}
	
	@Test
	public void testSetRowPos(){
		field = ButtonFormField.builder().rowPos(2).build();
		assertEquals(2, field.getRowPos());
	}
	
	@Test
	public void testSetColPos(){
		field = ButtonFormField.builder().colPos(5).build();
		assertEquals(5, field.getColPos());
	}
	
	@Test
	public void testSetRowSpan(){
		field = ButtonFormField.builder().rowSpan(3).build();
		assertEquals(3, field.getRowSpan());
	}
	
	@Test
	public void testSetColSpan(){
		field = ButtonFormField.builder().colSpan(7).build();
		assertEquals(7, field.getColSpan());
	}
	
	@Test
	public void testSetLogFontResourceLoaderWarnings(){
		field = ButtonFormField.builder()
				.logFontResourceLoaderWarnings(true).build();
		assertTrue(field.logFontResourceLoaderWarnings());
	}
	
	@Test
	public void testSetLogger() throws IOException{
		EasyLogger logger = new EasyLogger(LoggerUtil.createFileLogger("target/garbo/test.log", Level.OFF));
		field = ButtonFormField.builder()
				.logger(logger).build();
		assertEquals(logger, field.getLogger());
	}
	
	@Test
	public void testSetGraphEnv(){
		field = ButtonFormField.builder()
				.graphEnv(null).build();
		assertNull(field.getGraphEnv());
	}
	
	@Test
	public void testSetFontFolder(){
		field = ButtonFormField.builder()
				.fontFolder("testing/").build();
		assertEquals("testing/", field.getFontFolder());
	}
	
	@Test
	public void testSetFontResourceLoader(){
		FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
				null, "fonts/");
		field = ButtonFormField.builder()
				.fontResourceLoader(fontResourceLoader).build();
		assertEquals(fontResourceLoader, field.getFontResourceLoader());
	}
	
	@Test
	public void testSetActionListener(){
		field = ButtonFormField.builder().actionListener(testAction).build();
		assertEquals(testAction, field.getActionListener());
	}
	
	@Test
	public void testSetButtonForegroundPaint(){
		SizableColor red = new SizableColor(Color.RED);
		field = ButtonFormField.builder().buttonForegroundPaint(red).build();
		assertEquals(red, field.getButtonForegroundPaint());
	}
	
	@Test
	public void testSetButtonBackgroundPaint(){
		SizableColor blue = new SizableColor(Color.BLUE);
		field = ButtonFormField.builder().buttonBackgroundPaint(blue).build();
		assertEquals(blue, field.getButtonBackgroundPaint());
	}
	
	@Test
	public void testSetButtonSelectPaint(){
		SizableColor yellow = new SizableColor(Color.YELLOW);
		field = ButtonFormField.builder().buttonSelectPaint(yellow).build();
		assertEquals(yellow, field.getButtonSelectPaint());
	}
	
	@Test
	public void testSetButtonFocusPaint(){
		SizableColor black = new SizableColor(Color.BLACK);
		field = ButtonFormField.builder().buttonFocusPaint(black).build();
		assertEquals(black, field.getButtonFocusPaint());
	}
	
	@Test
	public void testSetButtonDisabledTextPaint(){
		SizableColor gray = new SizableColor(Color.GRAY);
		field = ButtonFormField.builder().buttonDisabledTextPaint(gray).build();
		assertEquals(gray, field.getButtonDisabledTextPaint());
	}
	
	@Test
	public void testSetButtonFont(){
		field = ButtonFormField.builder().buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12)
				.build();
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getButtonFontFamily());
		assertEquals(Font.BOLD, field.getButtonFontStyle());
		assertEquals(12, field.getButtonFontSize());
	}
	
	@Test
	public void testSetButtonBorder(){
		Border border = ShapedLineBorder.builder().build();
		field = ButtonFormField.builder().buttonBorder(border).build();
		assertEquals(border, field.getButtonBorder());
	}
	
	@Test
	public void testSetButtonShape(){
		field = ButtonFormField.builder().buttonShape(Shapes.CIRCLE.getShapeInfo()).build();
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getButtonShape());
	}
	
	@Test
	public void testAllSettings() throws IOException, FontFormatException{
		SizableColor magenta = new SizableColor(Color.MAGENTA);
		SizableColor pink = new SizableColor(Color.PINK);
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		SizableColor black = new SizableColor(Color.BLACK);
		SizableColor yellow = new SizableColor(Color.YELLOW);
		SizableColor gray = new SizableColor(Color.GRAY);
		Border labelBorder = ShapedLineBorder.builder().build();
		Border buttonBorder = ShapedLineBorder.builder().build();
		EasyLogger logger = new EasyLogger(LoggerUtil.createFileLogger("target/garbo/test.log", Level.OFF));
		FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
				null, "fonts/");
		field = ButtonFormField.builder().key("Test").defaultValue("Yes")
				.labelType(LabelType.TITLED_BORDER).labelForegroundPaint(magenta).labelBackgroundPaint(pink)
				.labelFont(FontFamilies.DIALOG_INPUT.getFamily(), Font.ITALIC, 27)
				.labelShape(Shapes.ELLIPSE.getShapeInfo()).labelBorder(labelBorder)
				.rowPos(2).colPos(5).rowSpan(3).colSpan(7)
				.logFontResourceLoaderWarnings(true).logger(logger).graphEnv(null).fontFolder("testing/")
				.fontResourceLoader(fontResourceLoader)
				.actionListener(testAction)
				.buttonForegroundPaint(red).buttonBackgroundPaint(blue)
				.buttonSelectPaint(black).buttonFocusPaint(yellow).buttonDisabledTextPaint(gray)
				.buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12)
				.buttonBorder(buttonBorder).buttonShape(Shapes.CIRCLE.getShapeInfo())
				.build();
		assertEquals("Test", field.getKey());
		assertEquals("Yes", field.getDefaultValue());
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
		assertEquals(magenta, field.getLabelForegroundPaint());
		assertEquals(pink, field.getLabelBackgroundPaint());
		assertEquals(FontFamilies.DIALOG_INPUT.getFamily(), field.getLabelFontFamily());
		assertEquals(Font.ITALIC, field.getLabelFontStyle());
		assertEquals(27, field.getLabelFontSize());
		assertEquals(Shapes.ELLIPSE.getShapeInfo(), field.getLabelShape());
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
		assertEquals(testAction, field.getActionListener());
		assertEquals(red, field.getButtonForegroundPaint());
		assertEquals(blue, field.getButtonBackgroundPaint());
		assertEquals(black, field.getButtonSelectPaint());
		assertEquals(yellow, field.getButtonFocusPaint());
		assertEquals(gray, field.getButtonDisabledTextPaint());
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getButtonFontFamily());
		assertEquals(Font.BOLD, field.getButtonFontStyle());
		assertEquals(12, field.getButtonFontSize());
		assertEquals(buttonBorder, field.getButtonBorder());
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getButtonShape());
	}
	
	@Test
	public void testGetJustComponent() throws IOException, FontFormatException{
		field = ButtonFormField.builder().key("Test Key").build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		assertEquals("Test Key", ((TadukooButton) component).getText());
	}
	
	@Test
	public void testGetJustComponentActionListener() throws IOException, FontFormatException{
		field = ButtonFormField.builder().key("Test")
				.actionListener(testAction).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(testAction, button.getActionListeners()[0]);
	}
	
	@Test
	public void testGetJustComponentButtonForegroundPaint() throws IOException, FontFormatException{
		SizableColor red = new SizableColor(Color.RED);
		field = ButtonFormField.builder().key("Test")
				.buttonForegroundPaint(red).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(red, button.getForegroundPaint());
	}
	
	@Test
	public void testGetJustComponentButtonBackgroundPaint() throws IOException, FontFormatException{
		SizableColor blue = new SizableColor(Color.BLUE);
		field = ButtonFormField.builder().key("Test")
				.buttonBackgroundPaint(blue).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(blue, button.getBackgroundPaint());
	}
	
	@Test
	public void testGetJustComponentButtonSelectPaint() throws IOException, FontFormatException{
		SizableColor black = new SizableColor(Color.BLACK);
		field = ButtonFormField.builder().key("Test")
				.buttonSelectPaint(black).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(black, button.getSelectPaint());
	}
	
	@Test
	public void testGetJustComponentButtonFocusPaint() throws IOException, FontFormatException{
		SizableColor yellow = new SizableColor(Color.YELLOW);
		field = ButtonFormField.builder().key("Test")
				.buttonFocusPaint(yellow).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(yellow, button.getFocusPaint());
	}
	
	@Test
	public void testGetJustComponentButtonDisabledTextPaint() throws IOException, FontFormatException{
		SizableColor gray = new SizableColor(Color.GRAY);
		field = ButtonFormField.builder().key("Test")
				.buttonDisabledTextPaint(gray).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(gray, button.getDisabledTextPaint());
	}
	
	@Test
	public void testGetJustComponentButtonFont() throws IOException, FontFormatException{
		field = ButtonFormField.builder().key("Test")
				.buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		Font font = button.getFont();
		assertEquals(FontFamilies.DIALOG.getFamily().getName(), font.getName());
		assertEquals(Font.BOLD, font.getStyle());
		assertEquals(12, font.getSize());
	}
	
	@Test
	public void testGetJustComponentButtonBorder() throws IOException, FontFormatException{
		Border border = ShapedLineBorder.builder().build();
		field = ButtonFormField.builder().key("Test")
				.buttonBorder(border).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(border, button.getBorder());
	}
	
	@Test
	public void testGetJustComponentButtonShape() throws IOException, FontFormatException{
		field = ButtonFormField.builder().key("Test")
				.buttonShape(Shapes.CIRCLE.getShapeInfo()).build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(Shapes.CIRCLE.getShapeInfo(), button.getShapeInfo());
	}
	
	@Test
	public void testGetJustComponentAllSettings() throws IOException, FontFormatException{
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		SizableColor black = new SizableColor(Color.BLACK);
		SizableColor yellow = new SizableColor(Color.YELLOW);
		SizableColor gray = new SizableColor(Color.GRAY);
		Border border = ShapedLineBorder.builder().build();
		field = ButtonFormField.builder().key("Test")
				.actionListener(testAction)
				.buttonForegroundPaint(red).buttonBackgroundPaint(blue)
				.buttonSelectPaint(black).buttonFocusPaint(yellow).buttonDisabledTextPaint(gray)
				.buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12)
				.buttonBorder(border).buttonShape(Shapes.CIRCLE.getShapeInfo())
				.build();
		JComponent component = field.getJustComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(testAction, button.getActionListeners()[0]);
		assertEquals(red, button.getForegroundPaint());
		assertEquals(blue, button.getBackgroundPaint());
		assertEquals(black, button.getSelectPaint());
		assertEquals(yellow, button.getFocusPaint());
		assertEquals(gray, button.getDisabledTextPaint());
		Font font = button.getFont();
		assertEquals(FontFamilies.DIALOG.getFamily().getName(), font.getName());
		assertEquals(Font.BOLD, font.getStyle());
		assertEquals(12, font.getSize());
		assertEquals(border, button.getBorder());
		assertEquals(Shapes.CIRCLE.getShapeInfo(), button.getShapeInfo());
	}
	
	@Test
	public void testGetValueFromJustComponent(){
		assertNull(field.getValueFromJustComponent(new JLabel("Derp")));
	}
}
