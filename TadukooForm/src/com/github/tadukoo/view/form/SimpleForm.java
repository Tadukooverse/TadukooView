package com.github.tadukoo.view.form;

import com.github.tadukoo.view.form.field.FormField;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Map;
import java.util.Set;

/**
 * Simple Form represents a form used in a program that the user can fill out and interact with.
 * It uses {@link FormField}s for the fields and buttons and such to be displayed on a single tab.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 * @since Alpha v.0.2
 */
public interface SimpleForm extends Form{
	
	/**
	 * @return The Map of {@link FormField}s by their keys
	 */
	Map<String, FormField<?>> getFieldMap();
	
	/**
	 * @return The Map of {@link JComponent}s by their keys
	 */
	Map<String, JComponent> getComponentMap();
	
	/**
	 * @return The {@link JPanel} used in this {@link SimpleForm}
	 */
	JPanel asPanel();
	
	/** {@inheritDoc} */
	@Override
	default void saveValues(){
		// Iterate through all the components and save the values
		for(String key: getComponentKeys()){
			JComponent component = getComponentByKey(key);
			FormField<?> field = getFieldByKey(key);
			Object value = field.getValue(component);
			setItem(key, value);
		}
	}
	
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
	default void addField(FormField<?> field){
		String key = field.getKey();
		setItem(key, field.getDefaultValue());
		getFieldMap().put(key, field);
	}
	
	/**
	 * This method should be called by the constructor to set default fields (this is where you should create new
	 * {@link FormField}s by calling {@link #addField(FormField)})
	 *
	 * @throws Throwable If anything goes wrong in creating the fields
	 */
	void setDefaultFields() throws Throwable;
	
	/**
	 * @return The keys in the Map of {@link FormField}s
	 */
	default Set<String> getFieldKeys(){
		return getFieldMap().keySet();
	}
	
	/**
	 * @param key The key for the {@link FormField} to retrieve
	 * @return The {@link FormField} stored with the given key
	 */
	default FormField<?> getFieldByKey(String key){
		return getFieldMap().get(key);
	}
	
	/**
	 * Adds the given {@link JComponent} to the Components map
	 *
	 * @param key The key to use for the {@link JComponent}
	 * @param component The {@link JComponent} to be stored
	 */
	default void addComponent(String key, JComponent component){
		getComponentMap().put(key, component);
	}
	
	/**
	 * This method should be called by the constructor (after calling {@link #setDefaultFields()}), and will
	 * create the components to be used on this Form
	 *
	 * @throws Throwable If anything goes wrong in creating the components
	 */
	default void createComponents() throws Throwable{
		// Use GridBayLayout for this panel
		asPanel().setLayout(new GridBagLayout());
		
		for(String key: getFieldKeys()){
			// Grab the field
			FormField<?> field = getFieldByKey(key);
			JComponent component = field.getComponent(labelsOnTop());
			
			// Add the Component and its constraints
			GridBagConstraints compCons = new GridBagConstraints();
			compCons.gridy = field.getRowPos();
			compCons.gridx = field.getColPos();
			compCons.gridheight = field.getRowSpan();
			compCons.gridwidth = field.getColSpan();
			asPanel().add(component, compCons);
			
			// Add the component to the map
			addComponent(key, component);
		}
	}
	
	/**
	 * @return The keys in the Map of {@link JComponent}s
	 */
	default Set<String> getComponentKeys(){
		return getComponentMap().keySet();
	}
	
	/**
	 * Grabs the appropriate {@link JComponent} present on this form for the given key for the field
	 *
	 * @param key The key used by the field to find the {@link JComponent}
	 * @return The appropriate {@link JComponent} for the given key for its field
	 */
	default JComponent getComponentByKey(String key){
		return getComponentMap().get(key);
	}
}
