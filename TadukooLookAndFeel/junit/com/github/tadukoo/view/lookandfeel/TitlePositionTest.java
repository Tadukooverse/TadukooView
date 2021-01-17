package com.github.tadukoo.view.lookandfeel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TitlePositionTest{
	
	@Test
	public void testAboveTop(){
		assertEquals(1, TitlePosition.ABOVE_TOP.getValue());
	}
	
	@Test
	public void testTop(){
		assertEquals(2, TitlePosition.TOP.getValue());
	}
	
	@Test
	public void testBelowTop(){
		assertEquals(3, TitlePosition.BELOW_TOP.getValue());
	}
	
	@Test
	public void testAboveBottom(){
		assertEquals(4, TitlePosition.ABOVE_BOTTOM.getValue());
	}
	
	@Test
	public void testBottom(){
		assertEquals(5, TitlePosition.BOTTOM.getValue());
	}
	
	@Test
	public void testBelowBottom(){
		assertEquals(6, TitlePosition.BELOW_BOTTOM.getValue());
	}
}
