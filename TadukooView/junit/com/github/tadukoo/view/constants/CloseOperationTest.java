package com.github.tadukoo.view.constants;

import org.junit.jupiter.api.Test;

import javax.swing.JFrame;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CloseOperationTest{
	
	@Test
	public void testDO_NOTHING_ON_CLOSE(){
		assertEquals(JFrame.DO_NOTHING_ON_CLOSE, CloseOperation.DO_NOTHING_ON_CLOSE.getValue());
	}
	
	@Test
	public void testHIDE_ON_CLOSE(){
		assertEquals(JFrame.HIDE_ON_CLOSE, CloseOperation.HIDE_ON_CLOSE.getValue());
	}
	
	@Test
	public void testDISPOSE_ON_CLOSE(){
		assertEquals(JFrame.DISPOSE_ON_CLOSE, CloseOperation.DISPOSE_ON_CLOSE.getValue());
	}
	
	@Test
	public void testEXIT_ON_CLOSE(){
		assertEquals(JFrame.EXIT_ON_CLOSE, CloseOperation.EXIT_ON_CLOSE.getValue());
	}
}
