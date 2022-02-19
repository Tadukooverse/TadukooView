package com.github.tadukoo.view.constants;

import com.github.tadukoo.util.junit.enums.EnumTest;
import org.junit.jupiter.api.Test;

import javax.swing.JTabbedPane;

import static com.github.tadukoo.view.constants.TabPlacement.BOTTOM;
import static com.github.tadukoo.view.constants.TabPlacement.LEFT;
import static com.github.tadukoo.view.constants.TabPlacement.RIGHT;
import static com.github.tadukoo.view.constants.TabPlacement.TOP;

public class TabPlacementTest{
	
	@Test
	public void testBadValue(){
		EnumTest.assertFromIntBad(TabPlacement::fromValue);
	}
	
	@Test
	public void testTOP(){
		EnumTest.assertToFromInt(TOP, JTabbedPane.TOP, TabPlacement::fromValue, TOP::getValue);
	}
	
	@Test
	public void testBOTTOM(){
		EnumTest.assertToFromInt(BOTTOM, JTabbedPane.BOTTOM, TabPlacement::fromValue, BOTTOM::getValue);
	}
	
	@Test
	public void testLEFT(){
		EnumTest.assertToFromInt(LEFT, JTabbedPane.LEFT, TabPlacement::fromValue, LEFT::getValue);
	}
	
	@Test
	public void testRIGHT(){
		EnumTest.assertToFromInt(RIGHT, JTabbedPane.RIGHT, TabPlacement::fromValue, RIGHT::getValue);
	}
}
