package com.github.tadukoo.view.form.field;

import com.github.tadukoo.view.components.TadukooButton;
import com.github.tadukoo.view.font.FontFamilies;
import com.github.tadukoo.view.font.FontResourceLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
