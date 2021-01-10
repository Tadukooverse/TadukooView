package com.github.tadukoo.view.border;

import javax.swing.plaf.BorderUIResource;

/**
 * No Border UI Resource is a version of {@link NoBorder} that extends {@link BorderUIResource}, so that it can be
 * used in Look &amp; Feels in cases where you don't want a border, but can't use null
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 */
public class NoBorderUIResource extends BorderUIResource{
	
	/**
	 * Creates a UIResource border object which wraps
	 * a {@link NoBorder} instance.
	 */
	public NoBorderUIResource(){
		super(new NoBorder());
	}
}
