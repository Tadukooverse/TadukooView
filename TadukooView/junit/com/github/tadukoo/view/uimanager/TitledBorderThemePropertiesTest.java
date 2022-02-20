package com.github.tadukoo.view.uimanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TitledBorderThemePropertiesTest implements TitledBorderThemeProperties{
	
	@Test
	public void testPROPERTY_PREFIX(){
		assertEquals("TitledBorder.", PROPERTY_PREFIX);
	}
	
	@Test
	public void testTITLED_BORDER_BORDER(){
		assertEquals("TitledBorder.border", TITLED_BORDER_BORDER);
	}
	
	@Test
	public void testTITLED_BORDER_FONT(){
		assertEquals("TitledBorder.font", TITLED_BORDER_FONT);
	}
	
	@Test
	public void testTITLED_BORDER_TITLE_COLOR(){
		assertEquals("TitledBorder.titleColor", TITLED_BORDER_TITLE_COLOR);
	}
	
	@Test
	public void testTITLED_BORDER_POSITION(){
		assertEquals("TitledBorder.position", TITLED_BORDER_POSITION);
	}
}
