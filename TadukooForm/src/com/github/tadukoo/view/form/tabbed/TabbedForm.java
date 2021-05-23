package com.github.tadukoo.view.form.tabbed;

import com.github.tadukoo.util.pojo.OrderedMappedPojo;
import com.github.tadukoo.view.form.Form;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Component;
import java.util.Collection;
import java.util.Map;

/**
 * Tabbed Form represents a {@link Form} composed of multiple tabs (each tab being its own {@link Form}) for the
 * user to be able to interact with.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3.3
 */
public interface TabbedForm extends Form, OrderedMappedPojo{
	
	/**
	 * @return The Map of {@link Form} tabs in this Tabbed Form
	 */
	Map<String, Form> getTabMap();
	
	/** {@inheritDoc} */
	@Override
	JTabbedPane asComponent();
	
	/** {@inheritDoc} */
	@Override
	default void saveValues(){
		// Save values on all the tabs
		for(Form tab: getAllTabs()){
			tab.saveValues();
		}
	}
	
	/**
	 * @return The {@link TabPlacement} to use for this Tabbed Form
	 */
	default TabPlacement tabPlacement(){
		return TabPlacement.LEFT;
	}
	
	/**
	 * @return The {@link TabLayoutPolicy} to use for this Tabbed Form
	 */
	default TabLayoutPolicy tabLayoutPolicy(){
		return TabLayoutPolicy.SCROLL_TAB_LAYOUT;
	}
	
	/**
	 * Configures settings for this Tabbed Form. This method should be called by the constructor in order to
	 * set at least the {@link #tabPlacement()} and {@link #tabLayoutPolicy()}
	 */
	default void configureSettings(){
		asComponent().setTabPlacement(tabPlacement().getValue());
		asComponent().setTabLayoutPolicy(tabLayoutPolicy().getValue());
	}
	
	/**
	 * @return The default {@link TabLabelType} to use for added tabs that don't specify a label type or custom label
	 */
	default TabLabelType defaultTabLabelType(){
		return TabLabelType.SIMPLE_PANEL_LABEL;
	}
	
	/**
	 * Adds the given {@link Form} tab to this Tabbed Form, using the default tab label type from
	 * {@link #defaultTabLabelType()} with the given title
	 *
	 * @param title The title for the tab, also used as the key
	 * @param tab The {@link Form} tab to be added
	 */
	default void addTab(String title, Form tab){
		addTab(title, tab, defaultTabLabelType());
	}
	
	/**
	 * Adds the given {@link Form} tab to this Tabbed Form, using the given {@link TabLabelType} with
	 * the given title
	 *
	 * @param title The title for the tab, also used as the key
	 * @param tab The {@link Form} tab to be added
	 * @param tabLabelType The {@link TabLabelType} to be used to create the tab's label
	 */
	default void addTab(String title, Form tab, TabLabelType tabLabelType){
		// Determine the tab label based on the given type
		Component tabLabel = switch(tabLabelType){
			case SIMPLE_LABEL -> new JLabel(title);
			case SIMPLE_PANEL_LABEL -> {
				JPanel tabPanel = new JPanel();
				JLabel titleLabel = new JLabel(title);
				tabPanel.add(titleLabel);
				yield tabPanel;
			}
		};
		
		// Send to the other addTab that takes a component
		addTab(title, tab, tabLabel);
	}
	
	/**
	 * Adds the given {@link Form} tab to this Tabbed Form, using the given tab label component
	 * and the given title
	 *
	 * @param title The title for the tab, also used as the key
	 * @param tab The {@link Form} tab to be added
	 * @param customTabLabel The component to use for the tab's label
	 */
	default void addTab(String title, Form tab, Component customTabLabel){
		// Add tha tab to the value and tabs map and add its component to this tabbed pane
		setItem(title, tab);
		getTabMap().put(title, tab);
		asComponent().addTab(title, tab.asComponent());
		
		// Add the tab label
		asComponent().setTabComponentAt(getNumTabs() - 1, customTabLabel);
	}
	
	/**
	 * Used by subclasses to setup the tabs used in the Tabbed Form, mainly by calling the addTab methods
	 *
	 * @throws Throwable If anything goes wrong
	 */
	void setDefaultTabs() throws Throwable;
	
	/**
	 * @return All the {@link Form} tabs contained in this Tabbed Form
	 */
	default Collection<Form> getAllTabs(){
		return getTabMap().values();
	}
	
	/**
	 * @return The number of {@link Form} tabs contained in this Tabbed Form
	 */
	default int getNumTabs(){
		return getTabMap().size();
	}
}
