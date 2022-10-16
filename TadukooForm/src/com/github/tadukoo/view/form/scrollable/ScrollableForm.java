package com.github.tadukoo.view.form.scrollable;

import com.github.tadukoo.view.form.Form;

import javax.swing.JScrollPane;

/**
 * Represents a {@link Form} that is also scrollable
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 */
public interface ScrollableForm extends Form{
	
	/**
	 * @return This form as a {@link JScrollPane}
	 */
	JScrollPane asScrollPane();
}
