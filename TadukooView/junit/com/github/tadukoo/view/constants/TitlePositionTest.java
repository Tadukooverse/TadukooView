package com.github.tadukoo.view.constants;

import com.github.tadukoo.util.junit.enums.EnumTest;
import org.junit.jupiter.api.Test;

import javax.swing.border.TitledBorder;

import static com.github.tadukoo.view.constants.TitlePosition.ABOVE_BOTTOM;
import static com.github.tadukoo.view.constants.TitlePosition.ABOVE_TOP;
import static com.github.tadukoo.view.constants.TitlePosition.BELOW_BOTTOM;
import static com.github.tadukoo.view.constants.TitlePosition.BELOW_TOP;
import static com.github.tadukoo.view.constants.TitlePosition.BOTTOM;
import static com.github.tadukoo.view.constants.TitlePosition.TOP;

public class TitlePositionTest{
	
	@Test
	public void testBadValue(){
		EnumTest.assertFromIntBad(TitlePosition::fromValue);
	}
	
	@Test
	public void testAboveTop(){
		EnumTest.assertToFromInt(ABOVE_TOP, TitledBorder.ABOVE_TOP, TitlePosition::fromValue, ABOVE_TOP::getValue);
	}
	
	@Test
	public void testTop(){
		EnumTest.assertToFromInt(TOP, TitledBorder.TOP, TitlePosition::fromValue, TOP::getValue);
	}
	
	@Test
	public void testBelowTop(){
		EnumTest.assertToFromInt(BELOW_TOP, TitledBorder.BELOW_TOP, TitlePosition::fromValue, BELOW_TOP::getValue);
	}
	
	@Test
	public void testAboveBottom(){
		EnumTest.assertToFromInt(ABOVE_BOTTOM, TitledBorder.ABOVE_BOTTOM, TitlePosition::fromValue, ABOVE_BOTTOM::getValue);
	}
	
	@Test
	public void testBottom(){
		EnumTest.assertToFromInt(BOTTOM, TitledBorder.BOTTOM, TitlePosition::fromValue, BOTTOM::getValue);
	}
	
	@Test
	public void testBelowBottom(){
		EnumTest.assertToFromInt(BELOW_BOTTOM, TitledBorder.BELOW_BOTTOM, TitlePosition::fromValue, BELOW_BOTTOM::getValue);
	}
}
