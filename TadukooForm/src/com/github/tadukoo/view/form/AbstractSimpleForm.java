package com.github.tadukoo.view.form;

import com.github.tadukoo.util.pojo.MappedPojo;
import com.github.tadukoo.view.form.field.FormField;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract Form is the default implementation of {@link SimpleForm}.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3.3
 * @since Alpha v.0.2
 */
public abstract class AbstractSimpleForm extends JPanel implements SimpleForm{
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
	protected AbstractSimpleForm(Map<String, Object> defaultValues) throws Throwable{
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
	protected AbstractSimpleForm(MappedPojo pojo) throws Throwable{
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
	public JPanel asComponent(){
		return this;
	}
}
