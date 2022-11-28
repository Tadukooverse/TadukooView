package com.github.tadukoo.view.form.main;

import com.github.tadukoo.util.pojo.MappedPojo;
import com.github.tadukoo.view.form.field.FormField;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract Simple Main Form is an abstract implementation of {@link SimpleMainForm} extending {@link JFrame} to
 * provide a way for a program to have a single-tabbed main form
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 * @since Alpha v.0.3.3
 */
public abstract class AbstractSimpleMainForm extends JFrame implements SimpleMainForm{
	/** The original {@link JPanel} in this form */
	private final JPanel originalPanel;
	/** The inner {@link JPanel} used in this form */
	private final JPanel panel;
	/** The map of actual values on this form */
	private final Map<String, Object> valueMap;
	/** The map of {@link FormField}s on this form */
	private final Map<String, FormField<?>> fields;
	/** The map of {@link JComponent components} on this form */
	private final Map<String, JComponent> components;
	
	/**
	 * Constructs a new Simple Main Form using the given default values (which are set so they can be used
	 * in {@link #setDefaultFields()})
	 *
	 * @param defaultValues The Map of default values for this Simple Main Form
	 * @throws Throwable If anything goes wrong (in setting default fields or creating components)
	 */
	protected AbstractSimpleMainForm(Map<String, Object> defaultValues) throws Throwable{
		originalPanel = new JPanel();
		panel = originalPanel;
		valueMap = defaultValues;
		fields = new HashMap<>();
		components = new HashMap<>();
		
		configureFrameSettings();
		setDefaultFields();
		createComponents();
		pack();
	}
	
	/**
	 * Constructs a new Simple Main Form using the given {@link MappedPojo} for the default values (which are
	 * set so they can be used in {@link #setDefaultFields()})
	 *
	 * @param pojo The {@link MappedPojo} to use for default fields
	 * @throws Throwable If anything goes wrong (in setting default fields or creating components)
	 */
	protected AbstractSimpleMainForm(MappedPojo pojo) throws Throwable{
		originalPanel = new JPanel();
		panel = originalPanel;
		valueMap = pojo.getMap();
		fields = new HashMap<>();
		components = new HashMap<>();
		
		configureFrameSettings();
		setDefaultFields();
		createComponents();
		pack();
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
		return panel;
	}
	
	/** {@inheritDoc} */
	@Override
	public JPanel asPanel(){
		return panel;
	}
	
	/** {@inheritDoc} */
	@Override
	public JFrame asFrame(){
		return this;
	}
	
	/** {@inheritDoc} */
	@Override
	public Container getOriginalForm(){
		return originalPanel;
	}
}
