package com.github.tadukoo.view.constants;

import javax.swing.JTabbedPane;

/**
 * Tab Layout Policy represents what to do when there are too many tabs to fit in the given space on a Tabbed Form
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 * @since Alpha v.0.3.3
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
	 * Searches for a {@link TabLayoutPolicy} using the given value
	 *
	 * @param value The value to use to find a {@link TabLayoutPolicy}
	 * @return The found {@link TabLayoutPolicy} or {@code null} if none were found with the given value
	 */
	public static TabLayoutPolicy fromValue(int value){
		for(TabLayoutPolicy policy: values()){
			if(policy.value == value){
				return policy;
			}
		}
		return null;
	}
	
	/**
	 * @return The int value used to represent the layout policy
	 */
	public int getValue(){
		return value;
	}
}
