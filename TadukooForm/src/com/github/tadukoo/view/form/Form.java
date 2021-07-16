package com.github.tadukoo.view.form;

import com.github.tadukoo.util.pojo.MappedPojo;

import java.awt.Component;

/**
 * Form represents a form used in a program that the user can fill out and interact with. This could be a simple form
 * with a bunch of fields, or it could be a tabbed form.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3.3
 */
public interface Form extends MappedPojo{
	
	/**
	 * @return This Form as a {@link Component}
	 */
	Component asComponent();
	
	/**
	 * This method can be called by subclasses to update the values present in the form from the Component values
	 */
	void saveValues();
}
