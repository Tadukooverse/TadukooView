package com.github.tadukoo.view.form.main;

import com.github.tadukoo.util.pojo.MappedPojo;
import com.github.tadukoo.view.form.Form;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Container;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract Tabbed Main Form is an abstract implementation of {@link TabbedMainForm} extending {@link JFrame} to
 * provide a way for a program to have a multiple tab main form
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3.3
 */
public abstract class AbstractTabbedMainForm extends JFrame implements TabbedMainForm{
	/** The original {@link JTabbedPane} in this form */
	private final JTabbedPane originalPane;
	/** The inner {@link JTabbedPane} used in this form */
	private final JTabbedPane tabbedPane;
	/** The map of actual values on this form */
	private final Map<String, Object> valueMap;
	/** The map of {@link Form} tabs on this form */
	private final Map<String, Form> tabs;
	
	/**
	 * Constructs a new Tabbed Main Form using the given default values (which are set to be used in the
	 * {@link #setDefaultTabs()} method as needed)
	 *
	 * @param defaultValues The Map of default values for this Tabbed Main Form
	 * @throws Throwable If anything goes wrong (in {@link #setDefaultTabs()})
	 */
	protected AbstractTabbedMainForm(Map<String, Object> defaultValues) throws Throwable{
		originalPane = new JTabbedPane();
		tabbedPane = originalPane;
		valueMap = defaultValues;
		tabs = new HashMap<>();
		
		configureSettings();
		configureFrameSettings();
		setDefaultTabs();
		pack();
	}
	
	/**
	 * Constructs a new Tabbed Main Form using the given {@link MappedPojo} for default values (which are set
	 * to be used in the {@link #setDefaultTabs()} method as needed)
	 *
	 * @param pojo The {@link MappedPojo} to use for default values
	 * @throws Throwable If anything goes wrong (in {@link #setDefaultTabs()})
	 */
	protected AbstractTabbedMainForm(MappedPojo pojo) throws Throwable{
		originalPane = new JTabbedPane();
		tabbedPane = originalPane;
		valueMap = pojo.getMap();
		tabs = new HashMap<>();
		
		configureSettings();
		configureFrameSettings();
		setDefaultTabs();
		pack();
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
		return tabbedPane;
	}
	
	/** {@inheritDoc} */
	@Override
	public JFrame asFrame(){
		return this;
	}
	
	/** {@inheritDoc} */
	@Override
	public Container getOriginalForm(){
		return originalPane;
	}
}
