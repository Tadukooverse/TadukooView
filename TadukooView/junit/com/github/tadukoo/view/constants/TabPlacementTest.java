package com.github.tadukoo.view.constants;

import org.junit.jupiter.api.Test;

import javax.swing.JTabbedPane;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TabPlacementTest{
	
	@Test
	public void testTOP(){
		assertEquals(JTabbedPane.TOP, TabPlacement.TOP.getValue());
	}
	
	@Test
	public void testBOTTOM(){
		assertEquals(JTabbedPane.BOTTOM, TabPlacement.BOTTOM.getValue());
	}
	
	@Test
	public void testLEFT(){
		assertEquals(JTabbedPane.LEFT, TabPlacement.LEFT.getValue());
	}
	
	@Test
	public void testRIGHT(){
		assertEquals(JTabbedPane.RIGHT, TabPlacement.RIGHT.getValue());
	}
}
