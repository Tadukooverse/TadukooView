package com.github.tadukoo.view.form;

import com.github.tadukoo.util.pojo.AbstractMappedPojo;
import com.github.tadukoo.util.pojo.MappedPojo;
import com.github.tadukoo.view.form.field.StringFormField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JTextField;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleFormTest{
	private boolean weSetThoseFields = false;
	
	private SimpleForm simpleForm;
	
	@BeforeEach
	public void setup() throws Throwable{
		simpleForm = new AbstractSimpleForm(new HashMap<>()){
			
			@Override
			public void setDefaultFields(){
				weSetThoseFields = true;
				addField(StringFormField.builder()
						.key("Derp").defaultValue("No")
						.build());
			}
		};
	}
	
	@Test
	public void testConstructor(){
		Map<String, Object> map = simpleForm.getMap();
		assertFalse(map.isEmpty());
		assertTrue(map.containsKey("Derp"));
		assertEquals("No", map.get("Derp"));
	}
	
	@Test
	public void testFormConstructor() throws Throwable{
		MappedPojo pojo = new AbstractMappedPojo(){
			@Override
			public Map<String, Object> getMap(){
				Map<String, Object> aMap = new HashMap<>();
				aMap.put("Test", 52);
				return aMap;
			}
		};
		SimpleForm simpleForm = new AbstractSimpleForm(pojo){
			@Override
			public void setDefaultFields(){
				weSetThoseFields = true;
				addField(StringFormField.builder()
						.key("Derp").defaultValue("No")
						.build());
			}
		};
		Map<String, Object> map = simpleForm.getMap();
		assertFalse(map.isEmpty());
		assertTrue(map.containsKey("Derp"));
		assertEquals("No", map.get("Derp"));
		assertTrue(map.containsKey("Test"));
		assertEquals(52, map.get("Test"));
	}
	
	@Test
	public void testHasKeyFalse(){
		assertFalse(simpleForm.hasKey("Test"));
	}
	
	@Test
	public void testHasKeyTrue(){
		simpleForm.setItem("Derp", 5);
		assertTrue(simpleForm.hasKey("Derp"));
	}
	
	@Test
	public void testGetKeysPopulated(){
		simpleForm.setItem("Derp", 5);
		simpleForm.setItem("Test", "Yes");
		Set<String> keys = simpleForm.getKeys();
		assertFalse(keys.isEmpty());
		assertTrue(keys.contains("Derp"));
		assertTrue(keys.contains("Test"));
	}
	
	@Test
	public void testHasItemNotSet(){
		assertFalse(simpleForm.hasItem("Test"));
	}
	
	@Test
	public void testHasItemSetToNull(){
		simpleForm.setItem("Test", null);
		assertFalse(simpleForm.hasItem("Test"));
	}
	
	@Test
	public void testHasItemTrue(){
		simpleForm.setItem("Derp", 5);
		assertTrue(simpleForm.hasItem("Derp"));
	}
	
	@Test
	public void testGetItemNotSet(){
		assertNull(simpleForm.getItem("Test"));
	}
	
	@Test
	public void testGetItem(){
		simpleForm.setItem("Derp", 5);
		assertEquals(5, simpleForm.getItem("Derp"));
	}
	
	@Test
	public void testSetItem(){
		simpleForm.setItem("Derp", 5);
		assertTrue(simpleForm.hasKey("Derp"));
		assertTrue(simpleForm.hasItem("Derp"));
		assertEquals(5, simpleForm.getItem("Derp"));
	}
	
	@Test
	public void testRemoveItem(){
		simpleForm.setItem("Derp", 5);
		assertTrue(simpleForm.hasKey("Derp"));
		assertTrue(simpleForm.hasItem("Derp"));
		assertEquals(5, simpleForm.getItem("Derp"));
		
		simpleForm.removeItem("Derp");
		assertFalse(simpleForm.hasKey("Derp"));
		assertFalse(simpleForm.hasItem("Derp"));
		assertNull(simpleForm.getItem("Derp"));
	}
	
	@Test
	public void testGetMap(){
		simpleForm.setItem("Derp", 5);
		simpleForm.setItem("Test", "Yes");
		
		Map<String, Object> map = simpleForm.getMap();
		assertFalse(map.isEmpty());
		assertEquals(2, map.keySet().size());
		assertTrue(map.containsKey("Derp"));
		assertEquals(5, map.get("Derp"));
		assertTrue(map.containsKey("Test"));
		assertEquals("Yes", map.get("Test"));
	}
	
	@Test
	public void testLabelsOnTop(){
		assertTrue(simpleForm.labelsOnTop());
	}
	
	@Test
	public void testAddField(){
		simpleForm.addField(StringFormField.builder()
				.key("Test").defaultValue("Yes")
				.build());
		assertTrue(simpleForm.hasItem("Test"));
		assertEquals("Yes", simpleForm.getItem("Test"));
	}
	
	@Test
	public void testSetDefaultFields(){
		assertTrue(weSetThoseFields);
	}
	
	@Test
	public void testCreateComponentsAndGetComponentByKey(){
		assertTrue(simpleForm.hasItem("Derp"));
		assertEquals("No", simpleForm.getItem("Derp"));
		JComponent comp = simpleForm.getComponentByKey("Derp");
		assertTrue(comp instanceof JTextField);
		assertEquals("No", ((JTextField) comp).getText());
	}
	
	@Test
	public void testSaveValues(){
		assertTrue(simpleForm.hasItem("Derp"));
		assertEquals("No", simpleForm.getItem("Derp"));
		((JTextField) simpleForm.getComponentByKey("Derp")).setText("Yeppers");
		simpleForm.saveValues();
		assertEquals("Yeppers", simpleForm.getItem("Derp"));
	}
	
	@Test
	public void testAsComponent(){
		assertEquals(simpleForm, simpleForm.asComponent());
	}
}
