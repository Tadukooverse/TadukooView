package com.github.tadukoo.view.uimanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LabelThemePropertiesTest implements LabelThemeProperties{
	
	@Test
	public void testPROPERTY_PREFIX(){
		assertEquals("Label.", PROPERTY_PREFIX);
	}
	
	@Test
	public void testLABEL_FOREGROUND_COLOR(){
		assertEquals("Label.foreground", LABEL_FOREGROUND_COLOR);
	}
	
	@Test
	public void testLABEL_FOREGROUND_PAINT(){
		assertEquals("Label.foreground.paint", LABEL_FOREGROUND_PAINT);
	}
	
	@Test
	public void testLABEL_BACKGROUND_COLOR(){
		assertEquals("Label.background", LABEL_BACKGROUND_COLOR);
	}
	
	@Test
	public void testLABEL_BACKGROUND_PAINT(){
		assertEquals("Label.background.paint", LABEL_BACKGROUND_PAINT);
	}
	
	@Test
	public void testLABEL_DISABLED_FOREGROUND_COLOR(){
		assertEquals("Label.disabledForeground", LABEL_DISABLED_FOREGROUND_COLOR);
	}
	
	@Test
	public void testLABEL_DISABLED_FOREGROUND_PAINT(){
		assertEquals("Label.disabledForeground.paint", LABEL_DISABLED_FOREGROUND_PAINT);
	}
	
	@Test
	public void testLABEL_FONT(){
		assertEquals("Label.font", LABEL_FONT);
	}
	
	@Test
	public void testLABEL_BORDER(){
		assertEquals("Label.border", LABEL_BORDER);
	}
	
	@Test
	public void testLABEL_SHAPE(){
		assertEquals("Label.shape", LABEL_SHAPE);
	}
}
