package com.github.tadukoo.view.form.scrollable;

import com.github.tadukoo.util.pojo.AbstractMappedPojo;
import com.github.tadukoo.util.pojo.MappedPojo;
import com.github.tadukoo.view.form.field.FormField;
import com.github.tadukoo.view.form.field.StringFormField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JTextField;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleScrollableFormTest{
	private SimpleScrollableForm scrollableForm;
	private FormField<?> field;
	
	@BeforeEach
	public void setup() throws Throwable{
		field = StringFormField.builder()
				.stringFieldType(StringFormField.StringFieldType.NORMAL)
				.key("Derp").defaultValue("No")
				.build();
		scrollableForm = new AbstractSimpleScrollableForm(new HashMap<>()){
			
			@Override
			public void setDefaultFields(){
				addField(field);
			}
		};
	}
	
	@Test
	public void testConstructor(){
		Map<String, Object> map = scrollableForm.getMap();
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
		SimpleScrollableForm scrollableForm = new AbstractSimpleScrollableForm(pojo){
			@Override
			public void setDefaultFields(){
				addField(StringFormField.builder()
						.key("Derp").defaultValue("No")
						.build());
			}
		};
		Map<String, Object> map = scrollableForm.getMap();
		assertFalse(map.isEmpty());
		assertTrue(map.containsKey("Derp"));
		assertEquals("No", map.get("Derp"));
		assertTrue(map.containsKey("Test"));
		assertEquals(52, map.get("Test"));
	}
	
	@Test
	public void testGetMap(){
		scrollableForm.setItem("Derp", 5);
		scrollableForm.setItem("Test", "Yes");
		
		Map<String, Object> map = scrollableForm.getMap();
		assertFalse(map.isEmpty());
		assertEquals(2, map.keySet().size());
		assertTrue(map.containsKey("Derp"));
		assertEquals(5, map.get("Derp"));
		assertTrue(map.containsKey("Test"));
		assertEquals("Yes", map.get("Test"));
	}
	
	@Test
	public void testGetFieldMap(){
		Map<String, FormField<?>> fields = scrollableForm.getFieldMap();
		assertEquals(1, fields.size());
		assertTrue(fields.containsKey("Derp"));
		assertEquals(field, fields.get("Derp"));
	}
	
	@Test
	public void testGetComponentMap(){
		Map<String, JComponent> components = scrollableForm.getComponentMap();
		assertEquals(1, components.size());
		assertTrue(components.containsKey("Derp"));
		assertTrue(components.get("Derp") instanceof JTextField);
	}
	
	@Test
	public void testAsComponent(){
		assertEquals(scrollableForm, scrollableForm.asComponent());
	}
	
	@Test
	public void testAsPanel(){
		assertNotNull(scrollableForm.asPanel());
	}
	
	@Test
	public void testAsScrollPane(){
		assertEquals(scrollableForm, scrollableForm.asScrollPane());
	}
}
