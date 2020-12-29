package com.github.tadukoo.view.form.field;

import com.github.tadukoo.util.LoggerUtil;
import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.components.TadukooButton;
import com.github.tadukoo.view.font.FontFamilies;
import com.github.tadukoo.view.font.FontResourceLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JLabel;
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
	public void testDefaults(){
		assertEquals(FieldType.BUTTON, field.getType());
		assertNull(field.getDefaultValue());
		assertEquals(LabelType.NONE, field.getLabelType());
		assertEquals(1, field.getRowSpan());
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
	public void testSetButtonFont() throws IOException, FontFormatException{
		field = ButtonFormField.builder().buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12)
				.build();
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getButtonFontFamily());
		assertEquals(Font.BOLD, field.getButtonFontStyle());
		assertEquals(12, field.getButtonFontSize());
	}
	
	@Test
	public void testAllSettings() throws IOException, FontFormatException{
		FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
				GraphicsEnvironment.getLocalGraphicsEnvironment(), "fonts/");
		field = ButtonFormField.builder().key("Test").defaultValue("Yes").labelType(LabelType.TITLED_BORDER)
				.rowPos(2).colPos(5).rowSpan(3).colSpan(7).fontResourceLoader(fontResourceLoader)
				.actionListener(testAction)
				.buttonFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 12).build();
		assertEquals("Test", field.getKey());
		assertEquals("Yes", field.getDefaultValue());
		assertEquals(LabelType.TITLED_BORDER, field.getLabelType());
		assertEquals(2, field.getRowPos());
		assertEquals(5, field.getColPos());
		assertEquals(3, field.getRowSpan());
		assertEquals(7, field.getColSpan());
		assertEquals(fontResourceLoader, field.getFontResourceLoader());
		assertEquals(testAction, field.getActionListener());
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getButtonFontFamily());
		assertEquals(Font.BOLD, field.getButtonFontStyle());
		assertEquals(12, field.getButtonFontSize());
	}
	
	@Test
	public void testGetComponent() throws IOException, FontFormatException{
		field = ButtonFormField.builder().key("Test Key").actionListener(testAction).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof TadukooButton);
		assertEquals("Test Key", ((TadukooButton) component).getText());
		assertEquals(testAction, ((TadukooButton) component).getActionListeners()[0]);
	}
	
	@Test
	public void testGetValue(){
		assertNull(field.getValue(new JLabel("Derp")));
	}
}
