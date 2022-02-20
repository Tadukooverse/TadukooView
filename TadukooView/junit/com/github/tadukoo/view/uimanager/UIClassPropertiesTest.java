package com.github.tadukoo.view.uimanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UIClassPropertiesTest implements UIClassProperties{
	
	@Test
	public void testBUTTON_UI(){
		assertEquals("ButtonUI", BUTTON_UI);
	}
	
	@Test
	public void testLABEL_UI(){
		assertEquals("LabelUI", LABEL_UI);
	}
}
