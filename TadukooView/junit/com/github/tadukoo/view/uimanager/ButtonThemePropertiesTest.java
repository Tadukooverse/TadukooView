package com.github.tadukoo.view.uimanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ButtonThemePropertiesTest implements ButtonThemeProperties{
	
	@Test
	public void testPROPERTY_PREFIX(){
		assertEquals("Button.", PROPERTY_PREFIX);
	}
	
	@Test
	public void testBUTTON_FOREGROUND_COLOR(){
		assertEquals("Button.foreground", BUTTON_FOREGROUND_COLOR);
	}
	
	@Test
	public void testBUTTON_FOREGROUND_PAINT(){
		assertEquals("Button.foreground.paint", BUTTON_FOREGROUND_PAINT);
	}
	
	@Test
	public void testBUTTON_BACKGROUND_COLOR(){
		assertEquals("Button.background", BUTTON_BACKGROUND_COLOR);
	}
	
	@Test
	public void testBUTTON_BACKGROUND_PAINT(){
		assertEquals("Button.background.paint", BUTTON_BACKGROUND_PAINT);
	}
	
	@Test
	public void testBUTTON_GRADIENT(){
		assertEquals("Button.gradient", BUTTON_GRADIENT);
	}
	
	@Test
	public void testBUTTON_FOCUS_COLOR(){
		assertEquals("Button.focus", BUTTON_FOCUS_COLOR);
	}
	
	@Test
	public void testBUTTON_FOCUS_PAINT(){
		assertEquals("Button.focus.paint", BUTTON_FOCUS_PAINT);
	}
	
	@Test
	public void testBUTTON_SELECT_COLOR(){
		assertEquals("Button.select", BUTTON_SELECT_COLOR);
	}
	
	@Test
	public void testBUTTON_SELECT_PAINT(){
		assertEquals("Button.select.paint", BUTTON_SELECT_PAINT);
	}
	
	@Test
	public void testBUTTON_DISABLED_TEXT_COLOR(){
		assertEquals("Button.disabledText", BUTTON_DISABLED_TEXT_COLOR);
	}
	
	@Test
	public void testBUTTON_DISABLED_TEXT_PAINT(){
		assertEquals("Button.disabledText.paint", BUTTON_DISABLED_TEXT_PAINT);
	}
	
	@Test
	public void testBUTTON_FONT(){
		assertEquals("Button.font", BUTTON_FONT);
	}
	
	@Test
	public void testBUTTON_BORDER(){
		assertEquals("Button.border", BUTTON_BORDER);
	}
	
	@Test
	public void testBUTTON_SHAPE(){
		assertEquals("Button.shape", BUTTON_SHAPE);
	}
}
