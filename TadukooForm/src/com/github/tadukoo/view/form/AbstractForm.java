package com.github.tadukoo.view.form;

import com.github.tadukoo.util.pojo.MappedPojo;
import com.github.tadukoo.view.components.TadukooLabel;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.form.field.FormField;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Abstract Form is the default implementation of {@link Form}.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 * @since Alpha v.0.2
 */
public abstract class AbstractForm extends JPanel implements Form{
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
	protected AbstractForm(Map<String, Object> defaultValues) throws Throwable{
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
	protected AbstractForm(MappedPojo pojo) throws Throwable{
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
	public boolean hasKey(String key){
		return valueMap.containsKey(key);
	}
	
	/** {@inheritDoc} */
	@Override
	public Set<String> getKeys(){
		return valueMap.keySet();
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean hasItem(String key){
		return valueMap.get(key) != null;
	}
	
	/** {@inheritDoc} */
	@Override
	public Object getItem(String key){
		return valueMap.get(key);
	}
	
	/** {@inheritDoc} */
	@Override
	public void setItem(String key, Object item){
		valueMap.put(key, item);
	}
	
	/** {@inheritDoc} */
	@Override
	public void removeItem(String key){
		valueMap.remove(key);
	}
	
	/** {@inheritDoc} */
	@Override
	public Map<String, Object> getMap(){
		return valueMap;
	}
	
	/** {@inheritDoc} */
	@Override
	public void addField(FormField<?> field){
		String key = field.getKey();
		setItem(key, field.getDefaultValue());
		fields.put(key, field);
	}
	
	/** {@inheritDoc} */
	@Override
	public void createComponents() throws Throwable{
		// Use GridBayLayout for this panel
		setLayout(new GridBagLayout());
		
		// Determine if we're placing labels above or to the left of components
		boolean topLabels = labelsOnTop();
		
		for(String key: fields.keySet()){
			// Grab the field and its label and grid information
			FormField<?> field = fields.get(key);
			SizablePaint labelForegroundPaint = field.getLabelForegroundPaint();
			SizablePaint labelBackgroundPaint = field.getLabelBackgroundPaint();
			FontFamily labelFontFamily = field.getLabelFontFamily();
			ShapeInfo labelShape = field.getLabelShape();
			Border labelBorder = field.getLabelBorder();
			int labelFontStyle = field.getLabelFontStyle();
			int labelFontSize = field.getLabelFontSize();
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
							.build();
					label.setHorizontalTextPosition(JLabel.RIGHT);
					add(label, labelCons);
				}
				case TITLED_BORDER -> component.setBorder(BorderFactory.createTitledBorder(key));
			}
			
			// Add the Component and its constraints
			GridBagConstraints compCons = new GridBagConstraints();
			compCons.gridy = topLabels?rowPos*2+1:rowPos;
			compCons.gridx = topLabels?colPos:colPos*2+1;
			compCons.gridheight = rowSpan;
			compCons.gridwidth = colSpan;
			add(component, compCons);
			
			// Add the component to the map
			components.put(key, component);
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public void saveValues(){
		// Iterate through all the components and save the values
		for(String key: components.keySet()){
			JComponent component = components.get(key);
			FormField<?> field = fields.get(key);
			Object value = field.getValue(component);
			valueMap.put(key, value);
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public JComponent getComponentByKey(String key){
		return components.get(key);
	}
}
