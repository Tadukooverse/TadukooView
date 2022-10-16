package com.github.tadukoo.view.form.main;

import com.github.tadukoo.util.pojo.MappedPojo;
import com.github.tadukoo.view.form.field.FormField;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract Simple Scrollable Main Form is an abstract implementation of {@link SimpleScrollableMainForm}
 * extending {@link JFrame} to provide a way for a program to have a single-tabbed scrollable main form
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 */
public abstract class AbstractSimpleScrollableMainForm extends JFrame implements SimpleScrollableMainForm{
	/** The inner {@link JScrollPane} used in this form */
	private final JScrollPane scrollPane;
	/** The map of actual values on this form */
	private final Map<String, Object> valueMap;
	/** The map of {@link FormField}s on this form */
	private final Map<String, FormField<?>> fields;
	/** The map of {@link JComponent components} on this form */
	private final Map<String, JComponent> components;
	
	/**
	 * Constructs a new Simple Scrollable Main Form using the given default values (which are set so they can be used
	 * in {@link #setDefaultFields()})
	 *
	 * @param defaultValues The Map of default values for this Simple Scrollable Main Form
	 * @throws Throwable If anything goes wrong (in setting default fields or creating components)
	 */
	protected AbstractSimpleScrollableMainForm(Map<String, Object> defaultValues) throws Throwable{
		scrollPane = new JScrollPane(new JPanel());
		valueMap = defaultValues;
		fields = new HashMap<>();
		components = new HashMap<>();
		
		configureFrameSettings();
		setDefaultFields();
		createComponents();
		pack();
	}
	
	/**
	 * Constructs a new Simple Scrollable Main Form using the given {@link MappedPojo} for the default values (which are
	 * set so they can be used in {@link #setDefaultFields()})
	 *
	 * @param pojo The {@link MappedPojo} to use for default fields
	 * @throws Throwable If anything goes wrong (in setting default fields or creating components)
	 */
	protected AbstractSimpleScrollableMainForm(MappedPojo pojo) throws Throwable{
		scrollPane = new JScrollPane(new JPanel());
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
	public JScrollPane asComponent(){
		return scrollPane;
	}
	
	/** {@inheritDoc} */
	@Override
	public JPanel asPanel(){
		return (JPanel) scrollPane.getViewport().getView();
	}
	
	/** {@inheritDoc} */
	@Override
	public JFrame asFrame(){
		return this;
	}
	
	/** {@inheritDoc} */
	@Override
	public JScrollPane asScrollPane(){
		return scrollPane;
	}
}
