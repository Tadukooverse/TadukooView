package com.github.tadukoo.view.components;

import com.github.tadukoo.util.ListUtil;
import com.github.tadukoo.util.StringUtil;
import com.github.tadukoo.util.map.MapUtil;
import com.github.tadukoo.util.pojo.AbstractOrderedMappedPojo;
import com.github.tadukoo.util.pojo.OrderedMappedPojo;
import com.github.tadukoo.view.constants.SizingMethod;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tadukoo Table is an extension of {@link JScrollPane} that contains a {@link JTable}. It provides methods for
 * using {@link List}s of {@link OrderedMappedPojo}s to populate the {@link JTable} and to make it easier to update
 * the table.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3.3
 * @since Alpha v.0.2
 */
public class TadukooTable extends JScrollPane{
	
	/**
	 * Builder to be used to create a {@link TadukooTable}. It has the following parameters:
	 *
	 * <table>
	 *     <caption>TadukooTable Parameters</caption>
	 *     <tr>
	 *         <th>Name</th>
	 *         <th>Description</th>
	 *         <th>Default Value or Required</th>
	 *     </tr>
	 *     <tr>
	 *         <td>keyOrder</td>
	 *         <td>The order of the keys in the table - can be null to use the pojos in the data</td>
	 *         <td>Defaults to null (to use the pojos in the data)</td>
	 *     </tr>
	 *     <tr>
	 *         <td>data</td>
	 *         <td>The data to be put in the table</td>
	 *         <td>Defaults to null</td>
	 *     </tr>
	 *     <tr>
	 *         <td>horizontalSizingMethod</td>
	 *         <td>The {@link SizingMethod} to use horizontally for the table</td>
	 *         <td>Defaults to {@link SizingMethod#DEFAULT_JAVA}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>verticalSizingMethod</td>
	 *         <td>The {@link SizingMethod} to use vertically for the table</td>
	 *         <td>Defaults to {@link SizingMethod#DEFAULT_JAVA}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>width</td>
	 *         <td>The width to use for certain {@link SizingMethod horizontalSizingMethod} options</td>
	 *         <td>Required if using {@link SizingMethod#SPECIFY_DATA} or {@link SizingMethod#SPECIFY_EXACT}
	 *         for {@code horizontalSizingMethod}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>height</td>
	 *         <td>The height to use for certain {@link SizingMethod verticalSizingMethod} options</td>
	 *         <td>Required if using {@link SizingMethod#SPECIFY_DATA} or {@link SizingMethod#SPECIFY_EXACT}
	 *         for {@code verticalSizingMethod}</td>
	 *     </tr>
	 *     <tr>
	 *         <td>columnDefs</td>
	 *         <td>The {@link JComponent components} to use for columns</td>
	 *         <td>Defaults to an empty Map</td>
	 *     </tr>
	 * </table>
	 */
	public static class TadukooTableBuilder{
		/** The order of the keys in the table - can be null to use the pojos in the data */
		private List<String> keyOrder = null;
		/** The data to be put in the table */
		private List<OrderedMappedPojo> data = null;
		/** The {@link SizingMethod} to use horizontally for the table */
		private SizingMethod horizontalSizingMethod = SizingMethod.DEFAULT_JAVA;
		/** The {@link SizingMethod} to use vertically for the table */
		private SizingMethod verticalSizingMethod = SizingMethod.DEFAULT_JAVA;
		/** The width to use for certain {@link SizingMethod horizontalSizingMethod} options */
		private int width = -1;
		/** The height to use for certain {@link SizingMethod verticalSizingMethod} options */
		private int height = -1;
		/** The {@link JComponent components} to use for columns */
		private Map<String, JComponent> columnDefs = new HashMap<>();
		
		/** Can't create outside of Tadukoo Table */
		private TadukooTableBuilder(){ }
		
		/**
		 * @param keyOrder The order of the keys in the table - can be null to use the pojos in the data
		 * @return this, to continue building
		 */
		public TadukooTableBuilder keyOrder(List<String> keyOrder){
			this.keyOrder = keyOrder;
			return this;
		}
		
		/**
		 * @param data The data to be put in the table
		 * @return this, to continue building
		 */
		public TadukooTableBuilder data(List<OrderedMappedPojo> data){
			this.data = data;
			return this;
		}
		
		/**
		 * @param overallSizingMethod The {@link SizingMethod} to use horizontally and vertically for the table
		 * @return this, to continue building
		 */
		public TadukooTableBuilder overallSizingMethod(SizingMethod overallSizingMethod){
			this.horizontalSizingMethod = overallSizingMethod;
			this.verticalSizingMethod = overallSizingMethod;
			return this;
		}
		
		/**
		 * @param horizontalSizingMethod The {@link SizingMethod} to use horizontally for the table
		 * @return this, to continue building
		 */
		public TadukooTableBuilder horizontalSizingMethod(SizingMethod horizontalSizingMethod){
			this.horizontalSizingMethod = horizontalSizingMethod;
			return this;
		}
		
		/**
		 * @param verticalSizingMethod The {@link SizingMethod} to use vertically for the table
		 * @return this, to continue building
		 */
		public TadukooTableBuilder verticalSizingMethod(SizingMethod verticalSizingMethod){
			this.verticalSizingMethod = verticalSizingMethod;
			return this;
		}
		
		/**
		 * @param width The width to use for certain {@link SizingMethod horizontalSizingMethod} options
		 * @return this, to continue building
		 */
		public TadukooTableBuilder width(int width){
			this.width = width;
			return this;
		}
		
		/**
		 * @param height The height to use for certain {@link SizingMethod verticalSizingMethod} options
		 * @return this, to continue building
		 */
		public TadukooTableBuilder height(int height){
			this.height = height;
			return this;
		}
		
		public TadukooTableBuilder columnDefs(Map<String, JComponent> columnDefs){
			this.columnDefs = columnDefs;
			return this;
		}
		
		/**
		 * Checks for any errors in the set parameters and will throw an {@link IllegalArgumentException} if any
		 * errors are found
		 */
		private void checkForErrors(){
			List<String> errors = new ArrayList<>();
			
			// Check horizontal sizing method with width
			if(width == -1 && (horizontalSizingMethod == SizingMethod.SPECIFY_DATA ||
					horizontalSizingMethod == SizingMethod.SPECIFY_EXACT)){
				errors.add("When using 'specify data' or 'specify exact' for horizontal sizing, you must specify width!");
			}
			
			// Check vertical sizing method with height
			if(height == -1 && (verticalSizingMethod == SizingMethod.SPECIFY_DATA ||
					verticalSizingMethod == SizingMethod.SPECIFY_EXACT)){
				errors.add("When using 'specify data' or 'specify exact' for vertical sizing, you must specify height!");
			}
			
			// Report any errors
			if(!errors.isEmpty()){
				throw new IllegalArgumentException("Encountered errors building a TadukooTable: \n" +
						StringUtil.buildStringWithNewLines(errors));
			}
		}
		
		/**
		 * Builds a {@link TadukooTable} using the set parameters after checking for any errors
		 *
		 * @return A newly created {@link TadukooTable}
		 */
		public TadukooTable build(){
			checkForErrors();
			
			return new TadukooTable(keyOrder, data, horizontalSizingMethod, verticalSizingMethod, width, height, columnDefs);
		}
	}
	
	/** The order of the keys in the table - can be null to use the pojos in the data */
	private final List<String> keyOrder;
	/** The {@link SizingMethod} to use horizontally for the table */
	private final SizingMethod horizontalSizingMethod;
	/** The {@link SizingMethod} to use vertically for the table */
	private final SizingMethod verticalSizingMethod;
	/** The width to use for certain {@link SizingMethod horizontalSizingMethod} options */
	private final int builderWidth;
	/** The height to use for certain {@link SizingMethod verticalSizingMethod} options */
	private final int builderHeight;
	/** The {@link JComponent components} to use for columns */
	private final Map<String, JComponent> columnDefs;
	
	/**
	 * Creates a new Tadukoo Table using the given parameters
	 *
	 * @param keyOrder The order of the keys in the table - can be null to use the pojos in the data
	 * @param data The data to be put in the table
	 * @param horizontalSizingMethod How to size the table horizontally
	 * @param verticalSizingMethod How to size the table vertically
	 * @param width The width to use for certain {@code horizontalSizingMethod} options
	 * @param height The height to use for certain {@code verticalSizingMethod} options
	 * @param columnDefs The {@link JComponent components} to use for columns
	 */
	private TadukooTable(
			List<String> keyOrder, List<OrderedMappedPojo> data,
			SizingMethod horizontalSizingMethod, SizingMethod verticalSizingMethod,
			int width, int height, Map<String, JComponent> columnDefs){
		super(new JTable(new DefaultTableModel()));
		this.keyOrder = keyOrder;
		this.horizontalSizingMethod = horizontalSizingMethod;
		this.verticalSizingMethod = verticalSizingMethod;
		this.builderWidth = width;
		this.builderHeight = height;
		this.columnDefs = columnDefs;
		setTableData(data);
		
		// Resize the table based on the sizing methods
		// Check if we have data and grab the table
		boolean haveData = ListUtil.isNotBlank(data);
		JTable table = getTable();
		
		// TODO: If using DEFAULT_THEME sizing method, grab the right method from the theme if possible
		
		// Determine dimensions by sizing method
		int realWidth = switch(horizontalSizingMethod){
			case DEFAULT_JAVA, DEFAULT_THEME -> getPreferredSize().width;
			case BY_DATA -> table.getPreferredSize().width;
			case SPECIFY_DATA -> table.getPreferredSize().width*width;
			case SPECIFY_EXACT -> width;
		};
		int realHeight = switch(verticalSizingMethod){
			case DEFAULT_JAVA, DEFAULT_THEME -> getPreferredSize().height;
			case BY_DATA -> haveData?table.getRowHeight()*data.size():this.getPreferredSize().height;
			case SPECIFY_DATA -> table.getRowHeight()*height;
			case SPECIFY_EXACT -> height;
		};
		// Actually set the dimensions
		table.setPreferredScrollableViewportSize(new Dimension(realWidth, realHeight));
		
		// Set the column defs if we have them
		if(MapUtil.isNotBlank(columnDefs)){
			// Make a map of column names to their index
			Map<String, Integer> columnNamesToIndex = new HashMap<>();
			if(ListUtil.isNotBlank(keyOrder)){
				for(int i = 0; i < keyOrder.size(); i++){
					columnNamesToIndex.put(keyOrder.get(i), i);
				}
			}else{
				List<String> keysOrder = data.get(0).getKeyOrder();
				for(int i = 0; i < keysOrder.size(); i++){
					columnNamesToIndex.put(keysOrder.get(i), i);
				}
			}
			
			// Grab the column model and set cell editors on it
			TableColumnModel colModel = table.getColumnModel();
			for(String columnName: columnDefs.keySet()){
				// TODO: Allow for other types of cell editors
				colModel.getColumn(columnNamesToIndex.get(columnName))
						.setCellEditor(new DefaultCellEditor((JComboBox<String>) columnDefs.get(columnName)));
			}
		}
	}
	
	/**
	 * @return A new {@link TadukooTableBuilder} to use to make a {@link TadukooTable}
	 */
	public static TadukooTableBuilder builder(){
		return new TadukooTableBuilder();
	}
	
	/**
	 * @return The order of the keys in the table - can be null to use the pojos in the data
	 */
	public List<String> getKeyOrder(){
		return keyOrder;
	}
	
	/**
	 * @return The {@link SizingMethod} to use horizontally for the table
	 */
	public SizingMethod getHorizontalSizingMethod(){
		return horizontalSizingMethod;
	}
	
	/**
	 * @return The {@link SizingMethod} to use vertically for the table
	 */
	public SizingMethod getVerticalSizingMethod(){
		return verticalSizingMethod;
	}
	
	/**
	 * @return The width to use for certain {@link SizingMethod horizontalSizingMethod} options
	 */
	public int getBuilderWidth(){
		return builderWidth;
	}
	
	/**
	 * @return The height to use for certain {@link SizingMethod verticalSizingMethod} options
	 */
	public int getBuilderHeight(){
		return builderHeight;
	}
	
	/**
	 * @return The {@link JComponent components} to use for columns
	 */
	public Map<String, JComponent> getColumnDefs(){
		return columnDefs;
	}
	
	/**
	 * @return The {@link JTable} behind this Tadukoo Table
	 */
	public JTable getTable(){
		return (JTable) getViewport().getView();
	}
	
	/**
	 * @return The {@link DefaultTableModel} behind this Tadukoo Table
	 */
	public DefaultTableModel getTableModel(){
		return (DefaultTableModel) getTable().getModel();
	}
	
	/**
	 * Sets the columns and rows of the table based on the passed in data. If the key order was set on the
	 * Tadukoo Table, that key order will be used, otherwise the key order of the first pojo in the data will
	 * be used.
	 *
	 * @param data The pojos to use to populate the table
	 */
	public void setTableData(List<OrderedMappedPojo> data){
		// Grab that table model
		DefaultTableModel model = getTableModel();
		
		// Reset the columns based on either the key order we have or grab it off a pojo
		List<String> keys = keyOrder != null?
				keyOrder:
				(data != null && !data.isEmpty()?data.get(0).getKeyOrder():null);
		model.setColumnCount(0);
		if(keys != null){
			for(String key: keys){
				model.addColumn(key);
			}
		}
		
		// Reset the row data of the table based on the passed in pojos
		model.setRowCount(0);
		if(data != null && !data.isEmpty() && keys != null){
			for(OrderedMappedPojo pojo: data){
				Object[] row = new Object[keys.size()];
				for(int i = 0; i < keys.size(); i++){
					row[i] = pojo.getItem(keys.get(i));
				}
				model.addRow(row);
			}
		}
	}
	
	/**
	 * Update the passed in data based on the current values in the table
	 *
	 * @param data The {@link List} of pojos to be updated
	 * @return The newly updated pojos {@link List}
	 */
	public List<OrderedMappedPojo> updatePojos(List<OrderedMappedPojo> data){
		// If the data is null, create a new table
		if(data == null){
			data = new ArrayList<>();
		}
		
		// Grab the table model and the size of the data
		int dataSize = data.size();
		DefaultTableModel model = getTableModel();
		
		// Get the key order from the model
		List<String> keys = new ArrayList<>();
		for(int col = 0; col < model.getColumnCount(); col++){
			keys.add(model.getColumnName(col));
		}
		
		// Iterate over all the table rows
		for(int row = 0; row < model.getRowCount(); row++){
			OrderedMappedPojo pojo;
			if(row < dataSize){
				// Grab the pojo from the data if there's enough rows
				pojo = data.get(row);
			}else{
				// Make a new pojo if the data is too small
				pojo = new AbstractOrderedMappedPojo(){
					@Override
					public List<String> getKeyOrder(){
						return keys;
					}
				};
				data.add(pojo);
			}
			// Set the values on the pojo from the table
			for(int col = 0; col < keys.size(); col++){
				String key = keys.get(col);
				Object value = model.getValueAt(row, col);
				pojo.setItem(key, value);
			}
		}
		
		// Return the updated data
		return data;
	}
	
	/**
	 * Adds a new row to the end of the table with empty data
	 */
	public void addEmptyRow(){
		DefaultTableModel model = getTableModel();
		Object[] row = new Object[model.getColumnCount()];
		model.addRow(row);
	}
	
	/**
	 * Adds a new row to the end of the table using values from the passed in pojo
	 *
	 * @param row The {@link OrderedMappedPojo} to use to add data to the table
	 */
	public void addRow(OrderedMappedPojo row){
		// Grab the table model
		DefaultTableModel model = getTableModel();
		
		// Create an Object array based on values in the pojo
		Object[] rowData = new Object[model.getColumnCount()];
		for(int i = 0; i < model.getColumnCount(); i++){
			String key = model.getColumnName(i);
			rowData[i] = row.getItem(key);
		}
		
		// Add the data to the table
		model.addRow(rowData);
	}
}
