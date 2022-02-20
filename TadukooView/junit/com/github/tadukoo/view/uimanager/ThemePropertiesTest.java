package com.github.tadukoo.view.uimanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThemePropertiesTest implements ThemeProperties{
	
	@Test
	public void testPAINT(){
		assertEquals(".paint", PAINT);
	}
	
	@Test
	public void testFOREGROUND_COLOR(){
		assertEquals("foreground", FOREGROUND_COLOR);
	}
	
	@Test
	public void testFOREGROUND_PAINT(){
		assertEquals("foreground.paint", FOREGROUND_PAINT);
	}
	
	@Test
	public void testBACKGROUND_COLOR(){
		assertEquals("background", BACKGROUND_COLOR);
	}
	
	@Test
	public void testBACKGROUND_PAINT(){
		assertEquals("background.paint", BACKGROUND_PAINT);
	}
	
	@Test
	public void testGRADIENT(){
		assertEquals("gradient", GRADIENT);
	}
	
	@Test
	public void testFOCUS_COLOR(){
		assertEquals("focus", FOCUS_COLOR);
	}
	
	@Test
	public void testFOCUS_PAINT(){
		assertEquals("focus.paint", FOCUS_PAINT);
	}
	
	@Test
	public void testSELECT_COLOR(){
		assertEquals("select", SELECT_COLOR);
	}
	
	@Test
	public void testSELECT_PAINT(){
		assertEquals("select.paint", SELECT_PAINT);
	}
	
	@Test
	public void testDISABLED_TEXT_COLOR(){
		assertEquals("disabledText", DISABLED_TEXT_COLOR);
	}
	
	@Test
	public void testDISABLED_TEXT_PAINT(){
		assertEquals("disabledText.paint", DISABLED_TEXT_PAINT);
	}
	
	@Test
	public void testDISABLED_FOREGROUND_COLOR(){
		assertEquals("disabledForeground", DISABLED_FOREGROUND_COLOR);
	}
	
	@Test
	public void testDISABLED_FOREGROUND_PAINT(){
		assertEquals("disabledForeground.paint", DISABLED_FOREGROUND_PAINT);
	}
	
	@Test
	public void testFONT(){
		assertEquals("font", FONT);
	}
	
	@Test
	public void testBORDER(){
		assertEquals("border", BORDER);
	}
	
	@Test
	public void testSHAPE(){
		assertEquals("shape", SHAPE);
	}
	
	@Test
	public void testTITLE_COLOR(){
		assertEquals("titleColor", TITLE_COLOR);
	}
	
	@Test
	public void testPOSITION(){
		assertEquals("position", POSITION);
	}
}
