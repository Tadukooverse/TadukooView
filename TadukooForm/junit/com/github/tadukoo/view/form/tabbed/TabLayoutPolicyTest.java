package com.github.tadukoo.view.form.tabbed;

import org.junit.jupiter.api.Test;

import javax.swing.JTabbedPane;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TabLayoutPolicyTest{
	
	@Test
	public void testWRAP_TAB_LAYOUT(){
		assertEquals(JTabbedPane.WRAP_TAB_LAYOUT, TabLayoutPolicy.WRAP_TAB_LAYOUT.getValue());
	}
	
	@Test
	public void testSCROLL_TAB_LAYOUT(){
		assertEquals(JTabbedPane.SCROLL_TAB_LAYOUT, TabLayoutPolicy.SCROLL_TAB_LAYOUT.getValue());
	}
}
