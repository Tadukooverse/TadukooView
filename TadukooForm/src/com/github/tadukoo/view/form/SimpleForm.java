package com.github.tadukoo.view.form;

import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.view.components.TadukooLabel;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.form.field.FormField;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
	
	/** {@inheritDoc} */
	@Override
	Component asComponent();
	
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
		
		// Determine if we're placing labels above or to the left of components
		boolean topLabels = labelsOnTop();
		
		for(String key: getFieldKeys()){
			// Grab the field
			FormField<?> field = getFieldByKey(key);
			
			// Grab label customizations from the field
			SizablePaint labelForegroundPaint = field.getLabelForegroundPaint();
			SizablePaint labelBackgroundPaint = field.getLabelBackgroundPaint();
			FontFamily labelFontFamily = field.getLabelFontFamily();
			ShapeInfo labelShape = field.getLabelShape();
			Border labelBorder = field.getLabelBorder();
			int labelFontStyle = field.getLabelFontStyle();
			int labelFontSize = field.getLabelFontSize();
			
			// Grab font resource loading info from the field
			boolean logFontResourceLoaderWarnings = field.logFontResourceLoaderWarnings();
			EasyLogger logger = field.getLogger();
			GraphicsEnvironment graphEnv = field.getGraphEnv();
			String fontFolder = field.getFontFolder();
			FontResourceLoader fontResourceLoader = field.getFontResourceLoader();
			
			// Grab grid information from the field
			int rowPos = field.getRowPos();
			int colPos = field.getColPos();
			int rowSpan = field.getRowSpan();
			int colSpan = field.getColSpan();
			
			JComponent component = field.getComponent();
			
			// Add a Label if the Field includes it
			switch(field.getLabelType()){
				case LABEL -> {
					GridBagConstraints labelCons = new GridBagConstraints();
					labelCons.gridy = topLabels?rowPos*2:rowPos;
					labelCons.gridx = topLabels?colPos:colPos*2;
					labelCons.gridheight = rowSpan;
					labelCons.gridwidth = colSpan;
					labelCons.anchor = topLabels?GridBagConstraints.SOUTH:GridBagConstraints.EAST;
					labelCons.insets = topLabels?new Insets(5, 0, 5, 0):new Insets(0, 5, 0, 5);
					TadukooLabel label = TadukooLabel.builder()
							.text(key)
							.foregroundPaint(labelForegroundPaint).backgroundPaint(labelBackgroundPaint)
							.font(labelFontFamily, labelFontStyle, labelFontSize)
							.shapeInfo(labelShape).border(labelBorder)
							.logFontResourceLoaderWarnings(logFontResourceLoaderWarnings).logger(logger)
							.graphEnv(graphEnv).fontFolder(fontFolder).fontResourceLoader(fontResourceLoader)
							.build();
					label.setHorizontalTextPosition(JLabel.RIGHT);
					asPanel().add(label, labelCons);
				}
				case TITLED_BORDER -> component.setBorder(BorderFactory.createTitledBorder(key));
			}
			
			// Add the Component and its constraints
			GridBagConstraints compCons = new GridBagConstraints();
			compCons.gridy = topLabels?rowPos*2+1:rowPos;
			compCons.gridx = topLabels?colPos:colPos*2+1;
			compCons.gridheight = rowSpan;
			compCons.gridwidth = colSpan;
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
