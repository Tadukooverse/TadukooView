package com.github.tadukoo.view.constants;

import com.github.tadukoo.util.junit.enums.EnumTest;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;

import static com.github.tadukoo.view.constants.CloseOperation.DISPOSE_ON_CLOSE;
import static com.github.tadukoo.view.constants.CloseOperation.DO_NOTHING_ON_CLOSE;
import static com.github.tadukoo.view.constants.CloseOperation.EXIT_ON_CLOSE;
import static com.github.tadukoo.view.constants.CloseOperation.HIDE_ON_CLOSE;

public class CloseOperationTest{
	
	@Test
	public void testBadValue(){
		EnumTest.assertFromIntBad(CloseOperation::fromValue);
	}
	
	@Test
	public void testDO_NOTHING_ON_CLOSE(){
		EnumTest.assertToFromInt(DO_NOTHING_ON_CLOSE, JFrame.DO_NOTHING_ON_CLOSE, CloseOperation::fromValue,
				DO_NOTHING_ON_CLOSE::getValue);
	}
	
	@Test
	public void testHIDE_ON_CLOSE(){
		EnumTest.assertToFromInt(HIDE_ON_CLOSE, JFrame.HIDE_ON_CLOSE, CloseOperation::fromValue, HIDE_ON_CLOSE::getValue);
	}
	
	@Test
	public void testDISPOSE_ON_CLOSE(){
		EnumTest.assertToFromInt(DISPOSE_ON_CLOSE, JFrame.DISPOSE_ON_CLOSE, CloseOperation::fromValue,
				DISPOSE_ON_CLOSE::getValue);
	}
	
	@Test
	public void testEXIT_ON_CLOSE(){
		EnumTest.assertToFromInt(EXIT_ON_CLOSE, JFrame.EXIT_ON_CLOSE, CloseOperation::fromValue, EXIT_ON_CLOSE::getValue);
	}
}
