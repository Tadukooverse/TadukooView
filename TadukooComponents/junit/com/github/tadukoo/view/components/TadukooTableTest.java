package com.github.tadukoo.view.components;

import com.github.tadukoo.util.ListUtil;
import com.github.tadukoo.util.pojo.AbstractOrderedMappedPojo;
import com.github.tadukoo.util.pojo.OrderedMappedPojo;
import com.github.tadukoo.view.constants.SizingMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

public class TadukooTableTest{
	private TadukooTable table = TadukooTable.builder().build();
	private final List<String> keyOrder = ListUtil.createList("Test", "Derp");
	private final List<String> keyOrder2 = ListUtil.createList("Test", "Derp", "Plop");
	private final List<OrderedMappedPojo> data = new ArrayList<>();
	private final int testValue = 5;
	private final String derpValue = "Yep";
	private final float plopValue = 2.5f;
	
	@BeforeEach
	public void setup(){
		data.add(new AbstractOrderedMappedPojo(){
			@Override
			public List<String> getKeyOrder(){
				return keyOrder2;
			}
		});
		data.get(0).setItem("Test", testValue);
		data.get(0).setItem("Derp", derpValue);
		data.get(0).setItem("Plop", plopValue);
		data.add(new AbstractOrderedMappedPojo(){
			@Override
			public List<String> getKeyOrder(){
				return keyOrder2;
			}
		});
		data.get(1).setItem("Derp", derpValue);
	}
	
	@Test
	public void testBuilderDefaultKeyOrder(){
		assertNull(table.getKeyOrder());
	}
	
	@Test
	public void testBuilderDefaultData(){
		assertEquals(0, table.getTableModel().getColumnCount());
		assertEquals(0, table.getTable().getRowCount());
	}
	
	@Test
	public void testBuilderDefaultHorizontalSizingMethod(){
		assertEquals(table.getHorizontalSizingMethod(), SizingMethod.DEFAULT_JAVA);
	}
	
	@Test
	public void testBuilderDefaultVerticalSizingMethod(){
		assertEquals(table.getVerticalSizingMethod(), SizingMethod.DEFAULT_JAVA);
	}
	
	@Test
	public void testBuilderDefaultBuilderWidth(){
		assertEquals(table.getBuilderWidth(), -1);
	}
	
	@Test
	public void testBuilderDefaultBuilderHeight(){
		assertEquals(table.getBuilderHeight(), -1);
	}
	
	@Test
	public void testBuilderSetKeyOrder(){
		table = TadukooTable.builder().keyOrder(keyOrder).build();
		assertEquals(keyOrder, table.getKeyOrder());
	}
	
	@Test
	public void testBuilderSetData(){
		table = TadukooTable.builder().data(data).build();
		assertEquals(data.size(), table.getTable().getRowCount());
	}
	
	@Test
	public void testBuilderSetOverallSizingMethod(){
		table = TadukooTable.builder().overallSizingMethod(SizingMethod.BY_DATA).build();
		assertEquals(table.getHorizontalSizingMethod(), SizingMethod.BY_DATA);
		assertEquals(table.getVerticalSizingMethod(), SizingMethod.BY_DATA);
	}
	
	@Test
	public void testBuilderSetHorizontalSizingMethod(){
		table = TadukooTable.builder().horizontalSizingMethod(SizingMethod.BY_DATA).build();
		assertEquals(table.getHorizontalSizingMethod(), SizingMethod.BY_DATA);
		assertEquals(table.getVerticalSizingMethod(), SizingMethod.DEFAULT_JAVA);
	}
	
	@Test
	public void testBuilderSetVerticalSizingMethod(){
		table = TadukooTable.builder().verticalSizingMethod(SizingMethod.BY_DATA).build();
		assertEquals(table.getVerticalSizingMethod(), SizingMethod.BY_DATA);
		assertEquals(table.getHorizontalSizingMethod(), SizingMethod.DEFAULT_JAVA);
	}
	
	@Test
	public void testBuilderSetWidth(){
		table = TadukooTable.builder().width(42).build();
		assertEquals(42, table.getBuilderWidth());
	}
	
	@Test
	public void testBuilderSetHeight(){
		table = TadukooTable.builder().height(42).build();
		assertEquals(42, table.getBuilderHeight());
	}
	
	@Test
	public void testBuilderErrorWidth(){
		try{
			table = TadukooTable.builder().horizontalSizingMethod(SizingMethod.SPECIFY_DATA).build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered errors building a TadukooTable: \n" +
					"When using 'specify data' or 'specify exact' for horizontal sizing, you must specify width!",
					e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorHeight(){
		try{
			table = TadukooTable.builder().verticalSizingMethod(SizingMethod.SPECIFY_DATA).build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("Encountered errors building a TadukooTable: \n" +
							"When using 'specify data' or 'specify exact' for vertical sizing, you must specify height!",
					e.getMessage());
		}
	}
	
	@Test
	public void testBuilderErrorAll(){
		try{
			table = TadukooTable.builder()
					.horizontalSizingMethod(SizingMethod.SPECIFY_EXACT)
					.verticalSizingMethod(SizingMethod.SPECIFY_EXACT)
					.build();
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("""
							Encountered errors building a TadukooTable:\s
							When using 'specify data' or 'specify exact' for horizontal sizing, you must specify width!
							When using 'specify data' or 'specify exact' for vertical sizing, you must specify height!""",
					e.getMessage());
		}
	}
	
	@Test
	public void testDefaultWidth(){
		table = TadukooTable.builder().horizontalSizingMethod(SizingMethod.DEFAULT_JAVA).build();
		assertEquals(453, table.getTable().getPreferredScrollableViewportSize().getWidth());
	}
	
	@Test
	public void testDefaultHeight(){
		table = TadukooTable.builder().verticalSizingMethod(SizingMethod.DEFAULT_JAVA).build();
		assertEquals(403, table.getTable().getPreferredScrollableViewportSize().getHeight());
	}
	
	@Test
	public void testSetTableDataNulls(){
		table.setTableData(null);
		assertEquals(0, table.getTable().getColumnCount());
		assertEquals(0, table.getTable().getRowCount());
	}
	
	@Test
	public void testSetTableDataNullData(){
		table = TadukooTable.builder().keyOrder(keyOrder).build();
		table.setTableData(null);
		assertEquals(keyOrder.size(), table.getTable().getColumnCount());
		assertEquals(0, table.getTable().getRowCount());
	}
	
	@Test
	public void testSetTableDataNullKeys(){
		table = TadukooTable.builder().data(data).build();
		table.setTableData(data);
		assertEquals(keyOrder2.size(), table.getTable().getColumnCount());
		assertEquals(data.size(), table.getTable().getRowCount());
	}
	
	@Test
	public void testSetTableDataNeitherNull(){
		table = TadukooTable.builder().keyOrder(keyOrder).data(data).build();
		table.setTableData(data);
		assertEquals(keyOrder.size(), table.getTable().getColumnCount());
		assertEquals(data.size(), table.getTable().getRowCount());
	}
	
	@Test
	public void testSetTableDataResets(){
		table = TadukooTable.builder().keyOrder(keyOrder).data(data).build();
		table.setTableData(data);
		assertEquals(keyOrder.size(), table.getTable().getColumnCount());
		assertEquals(data.size(), table.getTable().getRowCount());
		
		table.setTableData(data);
		assertEquals(keyOrder.size(), table.getTable().getColumnCount());
		assertEquals(data.size(), table.getTable().getRowCount());
	}
	
	@Test
	public void testUpdatePojosNull(){
		table = TadukooTable.builder().data(data).build();
		List<OrderedMappedPojo> result = table.updatePojos(null);
		assertEquals(2, result.size());
		OrderedMappedPojo pojo1 = result.get(0);
		assertEquals(keyOrder2, pojo1.getKeyOrder());
		assertEquals(derpValue, pojo1.getItem("Derp"));
		assertEquals(testValue, pojo1.getItem("Test"));
		assertEquals(plopValue, pojo1.getItem("Plop"));
		OrderedMappedPojo pojo2 = result.get(1);
		assertEquals(keyOrder2, pojo2.getKeyOrder());
		assertEquals(derpValue, pojo2.getItem("Derp"));
		assertNull(pojo2.getItem("Test"));
		assertNull(pojo2.getItem("Plop"));
	}
	
	@Test
	public void testUpdatePojosNoChange(){
		table = TadukooTable.builder().data(data).build();
		assertEquals(data, table.updatePojos(data));
	}
	
	@Test
	public void testAddEmptyRow(){
		table.addEmptyRow();
		assertEquals(1, table.getTable().getRowCount());
	}
	
	@Test
	public void testAddRow(){
		table = TadukooTable.builder().data(data).build();
		OrderedMappedPojo newPojo = new AbstractOrderedMappedPojo(){
			@Override
			public List<String> getKeyOrder(){
				return keyOrder2;
			}
		};
		newPojo.setItem("Derp", testValue);
		newPojo.setItem("Test", derpValue);
		table.addRow(newPojo);
		assertEquals(3, table.getTable().getRowCount());
		assertEquals(derpValue, table.getTable().getValueAt(2, 0));
		assertEquals(testValue, table.getTable().getValueAt(2, 1));
		assertNull(table.getTable().getValueAt(2, 2));
	}
}
