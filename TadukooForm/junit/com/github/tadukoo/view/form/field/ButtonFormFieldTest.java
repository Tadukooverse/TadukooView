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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ButtonFormFieldTest{
	private ButtonFormField field;
	private final ActionListener testAction = e -> { };
	
	@BeforeEach
	public void setup() throws IOException, FontFormatException{
		field = ButtonFormField.builder().build();
	}
	
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
	public void testDefaultRowSpan(){
		assertEquals(1, field.getRowSpan());
	}
	
	@Test
	public void testDefaultColSpan(){
		assertEquals(1, field.getColSpan());
	}
	
	@Test
	public void testSetKey() throws IOException, FontFormatException{
		field = ButtonFormField.builder().key("Test").build();
		assertEquals("Test", field.getKey());
	}
	
	@Test
	public void testSetDefaultValue() throws IOException, FontFormatException{
		field = ButtonFormField.builder().defaultValue("Yes").build();
		assertEquals("Yes", field.getDefaultValue());
	}
	
	@Test
	public void testSetLabelType() throws IOException, FontFormatException{
		field = ButtonFormField.builder().labelType(LabelType.TITLED_BORDER).build();
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
	}
	
	@Test
	public void testSetLabelForegroundPaint() throws IOException, FontFormatException{
		SizablePaint red = new SizableColor(Color.RED);
		field = ButtonFormField.builder().labelForegroundPaint(red).build();
		assertEquals(red, field.getLabelForegroundPaint());
	}
	
	@Test
	public void testSetLabelBackgroundPaint() throws IOException, FontFormatException{
		SizablePaint blue = new SizableColor(Color.BLUE);
		field = ButtonFormField.builder().labelBackgroundPaint(blue).build();
		assertEquals(blue, field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testSetRowPos() throws IOException, FontFormatException{
		field = ButtonFormField.builder().rowPos(2).build();
		assertEquals(2, field.getRowPos());
	}
	
	@Test
	public void testSetColPos() throws IOException, FontFormatException{
		field = ButtonFormField.builder().colPos(5).build();
		assertEquals(5, field.getColPos());
	}
	
	@Test
	public void testSetRowSpan() throws IOException, FontFormatException{
		field = ButtonFormField.builder().rowSpan(3).build();
		assertEquals(3, field.getRowSpan());
	}
	
	@Test
	public void testSetColSpan() throws IOException, FontFormatException{
		field = ButtonFormField.builder().colSpan(7).build();
		assertEquals(7, field.getColSpan());
	}
	
	@Test
	public void testFontResourceLoaderDefaults() throws IOException, FontFormatException{
		field = ButtonFormField.builder().buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12)
				.build();
		FontResourceLoader fontResourceLoader = field.getFontResourceLoader();
		assertFalse(fontResourceLoader.getLogWarnings());
		assertNull(fontResourceLoader.getLogger());
		assertEquals(GraphicsEnvironment.getLocalGraphicsEnvironment(), fontResourceLoader.getGraphEnv());
		assertEquals("fonts/", fontResourceLoader.getFontDirectoryPath());
	}
	
	@Test
	public void testSetLogFontResourceLoaderWarnings() throws IOException, FontFormatException{
		field = ButtonFormField.builder().buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12)
				.logFontResourceLoaderWarnings(true).build();
		assertTrue(field.getFontResourceLoader().getLogWarnings());
	}
	
	@Test
	public void testSetLogger() throws IOException, FontFormatException{
		EasyLogger logger = new EasyLogger(LoggerUtil.createFileLogger("/target/dummy-log.txt", Level.OFF));
		field = ButtonFormField.builder().buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12)
				.logger(logger).build();
		assertEquals(logger, field.getFontResourceLoader().getLogger());
	}
	
	@Test
	public void testSetGraphicsEnvironment() throws IOException, FontFormatException{
		GraphicsEnvironment graphEnv = new GraphicsEnvironment(){
			@Override
			public GraphicsDevice[] getScreenDevices() throws HeadlessException{
				return new GraphicsDevice[0];
			}
			
			@Override
			public GraphicsDevice getDefaultScreenDevice() throws HeadlessException{
				return null;
			}
			
			@Override
			public Graphics2D createGraphics(BufferedImage img){
				return null;
			}
			
			@Override
			public Font[] getAllFonts(){
				return new Font[0];
			}
			
			@Override
			public String[] getAvailableFontFamilyNames(){
				return new String[]{Font.DIALOG};
			}
			
			@Override
			public String[] getAvailableFontFamilyNames(Locale l){
				return new String[0];
			}
		};
		field = ButtonFormField.builder().buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12)
				.graphEnv(graphEnv).build();
		assertEquals(graphEnv, field.getFontResourceLoader().getGraphEnv());
	}
	
	@Test
	public void testSetFontFolder() throws IOException, FontFormatException{
		field = ButtonFormField.builder().buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12)
				.fontFolder("test-fonts/").build();
		assertEquals("test-fonts/", field.getFontResourceLoader().getFontDirectoryPath());
	}
	
	@Test
	public void testSetFontResourceLoader() throws IOException, FontFormatException{
		FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
				GraphicsEnvironment.getLocalGraphicsEnvironment(), "fonts/");
		field = ButtonFormField.builder().fontResourceLoader(fontResourceLoader).build();
		assertEquals(fontResourceLoader, field.getFontResourceLoader());
	}
	
	@Test
	public void testSetActionListener() throws IOException, FontFormatException{
		field = ButtonFormField.builder().actionListener(testAction).build();
		assertEquals(testAction, field.getActionListener());
	}
	
	@Test
	public void testSetButtonForegroundPaint() throws IOException, FontFormatException{
		SizableColor red = new SizableColor(Color.RED);
		field = ButtonFormField.builder().buttonForegroundPaint(red).build();
		assertEquals(red, field.getButtonForegroundPaint());
	}
	
	@Test
	public void testSetButtonBackgroundPaint() throws IOException, FontFormatException{
		SizableColor blue = new SizableColor(Color.BLUE);
		field = ButtonFormField.builder().buttonBackgroundPaint(blue).build();
		assertEquals(blue, field.getButtonBackgroundPaint());
	}
	
	@Test
	public void testSetButtonSelectPaint() throws IOException, FontFormatException{
		SizableColor yellow = new SizableColor(Color.YELLOW);
		field = ButtonFormField.builder().buttonSelectPaint(yellow).build();
		assertEquals(yellow, field.getButtonSelectPaint());
	}
	
	@Test
	public void testSetButtonFocusPaint() throws IOException, FontFormatException{
		SizableColor black = new SizableColor(Color.BLACK);
		field = ButtonFormField.builder().buttonFocusPaint(black).build();
		assertEquals(black, field.getButtonFocusPaint());
	}
	
	@Test
	public void testSetButtonDisabledTextPaint() throws IOException, FontFormatException{
		SizableColor gray = new SizableColor(Color.GRAY);
		field = ButtonFormField.builder().buttonDisabledTextPaint(gray).build();
		assertEquals(gray, field.getButtonDisabledTextPaint());
	}
	
	@Test
	public void testSetButtonFont() throws IOException, FontFormatException{
		field = ButtonFormField.builder().buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12)
				.build();
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getButtonFontFamily());
		assertEquals(Font.BOLD, field.getButtonFontStyle());
		assertEquals(12, field.getButtonFontSize());
	}
	
	@Test
	public void testSetButtonBorder() throws IOException, FontFormatException{
		Border border = ShapedLineBorder.builder().build();
		field = ButtonFormField.builder().buttonBorder(border).build();
		assertEquals(border, field.getButtonBorder());
	}
	
	@Test
	public void testSetButtonShape() throws IOException, FontFormatException{
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
		Border border = ShapedLineBorder.builder().build();
		FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
				GraphicsEnvironment.getLocalGraphicsEnvironment(), "fonts/");
		field = ButtonFormField.builder().key("Test").defaultValue("Yes")
				.labelType(LabelType.TITLED_BORDER).labelForegroundPaint(magenta).labelBackgroundPaint(pink)
				.rowPos(2).colPos(5).rowSpan(3).colSpan(7).fontResourceLoader(fontResourceLoader)
				.actionListener(testAction)
				.buttonForegroundPaint(red).buttonBackgroundPaint(blue)
				.buttonSelectPaint(black).buttonFocusPaint(yellow).buttonDisabledTextPaint(gray)
				.buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12)
				.buttonBorder(border).buttonShape(Shapes.CIRCLE.getShapeInfo())
				.build();
		assertEquals("Test", field.getKey());
		assertEquals("Yes", field.getDefaultValue());
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
		assertEquals(magenta, field.getLabelForegroundPaint());
		assertEquals(pink, field.getLabelBackgroundPaint());
		assertEquals(2, field.getRowPos());
		assertEquals(5, field.getColPos());
		assertEquals(3, field.getRowSpan());
		assertEquals(7, field.getColSpan());
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
		assertEquals(border, field.getButtonBorder());
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getButtonShape());
	}
	
	@Test
	public void testGetComponent() throws IOException, FontFormatException{
		field = ButtonFormField.builder().key("Test Key").build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof TadukooButton);
		assertEquals("Test Key", ((TadukooButton) component).getText());
	}
	
	@Test
	public void testGetComponentActionListener() throws IOException, FontFormatException{
		field = ButtonFormField.builder().key("Test")
				.actionListener(testAction).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(testAction, button.getActionListeners()[0]);
	}
	
	@Test
	public void testGetComponentButtonForegroundPaint() throws IOException, FontFormatException{
		SizableColor red = new SizableColor(Color.RED);
		field = ButtonFormField.builder().key("Test")
				.buttonForegroundPaint(red).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(red, button.getForegroundPaint());
	}
	
	@Test
	public void testGetComponentButtonBackgroundPaint() throws IOException, FontFormatException{
		SizableColor blue = new SizableColor(Color.BLUE);
		field = ButtonFormField.builder().key("Test")
				.buttonBackgroundPaint(blue).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(blue, button.getBackgroundPaint());
	}
	
	@Test
	public void testGetComponentButtonSelectPaint() throws IOException, FontFormatException{
		SizableColor black = new SizableColor(Color.BLACK);
		field = ButtonFormField.builder().key("Test")
				.buttonSelectPaint(black).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(black, button.getSelectPaint());
	}
	
	@Test
	public void testGetComponentButtonFocusPaint() throws IOException, FontFormatException{
		SizableColor yellow = new SizableColor(Color.YELLOW);
		field = ButtonFormField.builder().key("Test")
				.buttonFocusPaint(yellow).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(yellow, button.getFocusPaint());
	}
	
	@Test
	public void testGetComponentButtonDisabledTextPaint() throws IOException, FontFormatException{
		SizableColor gray = new SizableColor(Color.GRAY);
		field = ButtonFormField.builder().key("Test")
				.buttonDisabledTextPaint(gray).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(gray, button.getDisabledTextPaint());
	}
	
	@Test
	public void testGetComponentButtonFont() throws IOException, FontFormatException{
		field = ButtonFormField.builder().key("Test")
				.buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		Font font = button.getFont();
		assertEquals(FontFamilies.DIALOG.getFamily().getName(), font.getName());
		assertEquals(Font.BOLD, font.getStyle());
		assertEquals(12, font.getSize());
	}
	
	@Test
	public void testGetComponentButtonBorder() throws IOException, FontFormatException{
		Border border = ShapedLineBorder.builder().build();
		field = ButtonFormField.builder().key("Test")
				.buttonBorder(border).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(border, button.getBorder());
	}
	
	@Test
	public void testGetComponentButtonShape() throws IOException, FontFormatException{
		field = ButtonFormField.builder().key("Test")
				.buttonShape(Shapes.CIRCLE.getShapeInfo()).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof TadukooButton);
		TadukooButton button = (TadukooButton) component;
		assertEquals("Test", button.getText());
		assertEquals(Shapes.CIRCLE.getShapeInfo(), button.getShapeInfo());
	}
	
	@Test
	public void testGetComponentAllSettings() throws IOException, FontFormatException{
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
		JComponent component = field.getComponent();
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
	public void testGetValue(){
		assertNull(field.getValue(new JLabel("Derp")));
	}
}
