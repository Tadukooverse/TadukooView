package com.github.tadukoo.view.constants;

import javax.swing.JTabbedPane;

/**
 * Tab Layout Policy represents what to do when there are too many tabs to fit in the given space on a Tabbed Form
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3.3
 */
public enum TabLayoutPolicy{
	/** The tabs will be wrapped if there are too many to fit in the given space */
	WRAP_TAB_LAYOUT(JTabbedPane.WRAP_TAB_LAYOUT),
	/** The tabs can be scrolled if there are too many to fit in the given space */
	SCROLL_TAB_LAYOUT(JTabbedPane.SCROLL_TAB_LAYOUT);
	
	/** The int value used to represent the layout policy */
	private final int value;
	
	/**
	 * Constructs a new tab layout policy with the given value
	 *
	 * @param value The int value used to represent the layout policy
	 */
	TabLayoutPolicy(int value){
		this.value = value;
	}
	
	/**
	 * @return The int value used to represent the layout policy
	 */
	public int getValue(){
		return value;
	}
}
