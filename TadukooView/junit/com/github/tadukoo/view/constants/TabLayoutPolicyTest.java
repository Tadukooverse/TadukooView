package com.github.tadukoo.view.constants;

import com.github.tadukoo.util.junit.enums.EnumTest;
import org.junit.jupiter.api.Test;

import javax.swing.JTabbedPane;

import static com.github.tadukoo.view.constants.TabLayoutPolicy.SCROLL_TAB_LAYOUT;
import static com.github.tadukoo.view.constants.TabLayoutPolicy.WRAP_TAB_LAYOUT;

public class TabLayoutPolicyTest{
	
	@Test
	public void testBadValue(){
		EnumTest.assertFromIntBad(TabLayoutPolicy::fromValue);
	}
	
	@Test
	public void testWRAP_TAB_LAYOUT(){
		EnumTest.assertToFromInt(WRAP_TAB_LAYOUT, JTabbedPane.WRAP_TAB_LAYOUT, TabLayoutPolicy::fromValue,
				WRAP_TAB_LAYOUT::getValue);
	}
	
	@Test
	public void testSCROLL_TAB_LAYOUT(){
		EnumTest.assertToFromInt(SCROLL_TAB_LAYOUT, JTabbedPane.SCROLL_TAB_LAYOUT, TabLayoutPolicy::fromValue,
				SCROLL_TAB_LAYOUT::getValue);
	}
}
