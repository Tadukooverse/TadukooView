package com.github.tadukoo.view.form;

import com.github.tadukoo.view.form.field.FormField;

import javax.swing.JComponent;

/**
 * Simple Form represents a form used in a program that the user can fill out and interact with.
 * It uses {@link FormField}s for the fields and buttons and such to be displayed on a single tab.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3.3
 * @since Alpha v.0.2
 */
public interface SimpleForm extends Form{
	
	/**
	 * @return Whether to have labels for components above them (true) or to the left (false) - defaults to true
	 */
	default boolean labelsOnTop(){
		return true;
	}
	
	/**
	 * Adds the given {@link FormField} to this Form
	 *
	 * @param field The {@link FormField} to add to this Form
	 */
	void addField(FormField<?> field);
	
	/**
	 * This method should be called by the constructor to set default fields (this is where you should create new
	 * {@link FormField}s by calling {@link #addField(FormField)})
	 *
	 * @throws Throwable If anything goes wrong in creating the fields
	 */
	void setDefaultFields() throws Throwable;
	
	/**
	 * This method should be called by the constructor (after calling {@link #setDefaultFields()}), and will
	 * create the components to be used on this Form
	 *
	 * @throws Throwable If anything goes wrong in creating the components
	 */
	void createComponents() throws Throwable;
	
	/**
	 * Grabs the appropriate {@link JComponent} present on this form for the given key for the field
	 *
	 * @param key The key used by the field to find the {@link JComponent}
	 * @return The appropriate {@link JComponent} for the given key for its field
	 */
	JComponent getComponentByKey(String key);
}
