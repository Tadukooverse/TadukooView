package com.github.tadukoo.view.form.tabbed;

import com.github.tadukoo.util.pojo.MappedPojo;
import com.github.tadukoo.view.form.Form;

import javax.swing.JTabbedPane;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract Tabbed Form is a simple implementation of {@link TabbedForm}, extending {@link JTabbedPane} to
 * create a simple tabbed form for users to input data and interact with.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3.3
 */
public abstract class AbstractTabbedForm extends JTabbedPane implements TabbedForm{
	/** The map of actual values on this form */
	private final Map<String, Object> valueMap;
	/** The map of {@link Form} tabs on this form */
	private final Map<String, Form> tabs;
	
	/**
	 * Initializes the form. Sets the values map to the passed in map (used for tabs that need the default values
	 * while running {@link #setDefaultTabs()}), and sets the tabs map to a new HashMap.
	 * <br>
	 * {@link #configureSettings()} and {@link #setDefaultTabs()} are then called.
	 *
	 * @param defaultValues The default values map, used for tabs that need them during {@link #setDefaultTabs()}
	 * @throws Throwable If anything goes wrong in creating tabs
	 */
	protected AbstractTabbedForm(Map<String, Object> defaultValues) throws Throwable{
		valueMap = defaultValues;
		tabs = new HashMap<>();
		
		configureSettings();
		setDefaultTabs();
	}
	
	/**
	 * Initializes the form. Sets the values map to the map from the given pojo (used for tabs that need the
	 * default values while running {@link #setDefaultTabs()}), and sets the tabs map to a new HashMap.
	 * <br>
	 * {@link #configureSettings()} and {@link #setDefaultTabs()} are then called.
	 *
	 * @param pojo The pojo containing a map, to be used for default values for tabs
	 *                that need them during {@link #setDefaultTabs()}
	 * @throws Throwable If anything goes wrong in creating tabs
	 */
	protected AbstractTabbedForm(MappedPojo pojo) throws Throwable{
		valueMap = pojo.getMap();
		tabs = new HashMap<>();
		
		configureSettings();
		setDefaultTabs();
	}
	
	/** {@inheritDoc} */
	@Override
	public Map<String, Object> getMap(){
		return valueMap;
	}
	
	/** {@inheritDoc} */
	@Override
	public Map<String, Form> getTabMap(){
		return tabs;
	}
	
	/** {@inheritDoc} */
	@Override
	public JTabbedPane asComponent(){
		return this;
	}
}
