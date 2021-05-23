package com.github.tadukoo.view.constants;

import javax.swing.JTabbedPane;

/**
 * Tab Placement is used to determine where tabs should be placed in a Tabbed Form.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3.3
 */
public enum TabPlacement{
	/** Tabs are placed at the top of the form */
	TOP(JTabbedPane.TOP),
	/** Tabs are placed at the bottom of the form */
	BOTTOM(JTabbedPane.BOTTOM),
	/** Tabs are placed to the left of the form */
	LEFT(JTabbedPane.LEFT),
	/** Tabs are placed to the right of the form */
	RIGHT(JTabbedPane.RIGHT);
	
	/** The int value used to represent the placement option */
	private final int value;
	
	/**
	 * Constructs a new Tab Placement with the given value
	 *
	 * @param value The int value used to represent the placement option
	 */
	TabPlacement(int value){
		this.value = value;
	}
	
	/**
	 * @return The int value used to represent the placement option
	 */
	public int getValue(){
		return value;
	}
}
