package com.github.tadukoo.view.form.scrollable;

import com.github.tadukoo.util.pojo.MappedPojo;
import com.github.tadukoo.view.form.field.FormField;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract Simple Scrollable Form is an implementation of {@link SimpleScrollableForm}
 * extending {@link JScrollPane} to provide a program a way to have a simple form that's scrollable.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 */
public abstract class AbstractSimpleScrollableForm extends JScrollPane implements SimpleScrollableForm{
	/** The map of actual values on this form */
	private final Map<String, Object> valueMap;
	/** The map of {@link FormField}s on this form */
	private final Map<String, FormField<?>> fields;
	/** The map of {@link JComponent components} on this form */
	private final Map<String, JComponent> components;
	
	/**
	 * Initializes the form. Sets the values map to the passed in map (used for forms that need the default values
	 * while running {@link #setDefaultFields()}), and sets the fields and components maps to new HashMaps.
	 * <br>
	 * {@link #setDefaultFields()} and {@link #createComponents()} are then called.
	 *
	 * @param defaultValues The default values map, used for forms that need them during {@link #setDefaultFields()}
	 * @throws Throwable If anything goes wrong in creating components
	 */
	protected AbstractSimpleScrollableForm(Map<String, Object> defaultValues) throws Throwable{
		super(new JPanel());
		// Initialize the maps
		valueMap = defaultValues;
		fields = new HashMap<>();
		components = new HashMap<>();
		
		// Initialize fields and components
		setDefaultFields();
		createComponents();
	}
	
	/**
	 * Initializes the form. Sets the values map to the map from the given pojo (used for forms that need the
	 * default values while running {@link #setDefaultFields()}), and sets the fields and components maps to
	 * new HashMaps.
	 * <br>
	 * {@link #setDefaultFields()} and {@link #createComponents()} are then called.
	 *
	 * @param pojo The pojo containing a map, to be used for default values for forms
	 *                that need them during {@link #setDefaultFields()}
	 * @throws Throwable If anything goes wrong in creating components
	 */
	protected AbstractSimpleScrollableForm(MappedPojo pojo) throws Throwable{
		super(new JPanel());
		
		// Initialize the maps
		valueMap = pojo.getMap();
		fields = new HashMap<>();
		components = new HashMap<>();
		
		// Initialize fields and components
		setDefaultFields();
		createComponents();
	}
	
	/** {@inheritDoc} */
	@Override
	public Map<String, Object> getMap(){
		return valueMap;
	}
	
	/** {@inheritDoc} */
	@Override
	public Map<String, FormField<?>> getFieldMap(){
		return fields;
	}
	
	/** {@inheritDoc} */
	@Override
	public Map<String, JComponent> getComponentMap(){
		return components;
	}
	
	/** {@inheritDoc} */
	@Override
	public JScrollPane asComponent(){
		return this;
	}
	
	/** {@inheritDoc} */
	@Override
	public JPanel asPanel(){
		return (JPanel) getViewport().getView();
	}
	
	/** {@inheritDoc} */
	@Override
	public JScrollPane asScrollPane(){
		return this;
	}
}
