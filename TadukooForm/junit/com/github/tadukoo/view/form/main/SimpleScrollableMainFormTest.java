package com.github.tadukoo.view.form.main;

import com.github.tadukoo.util.pojo.AbstractMappedPojo;
import com.github.tadukoo.util.pojo.MappedPojo;
import com.github.tadukoo.view.constants.CloseOperation;
import com.github.tadukoo.view.form.field.FormField;
import com.github.tadukoo.view.form.field.LabelType;
import com.github.tadukoo.view.form.field.StringFormField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleScrollableMainFormTest{
	private boolean weSetThoseFields = false;
	
	private SimpleScrollableMainForm simpleScrollableForm;
	private FormField<?> field;
	
	@BeforeEach
	public void setup() throws Throwable{
		field = StringFormField.builder()
				.labelType(LabelType.NONE)
				.stringFieldType(StringFormField.StringFieldType.NORMAL)
				.key("Derp").defaultValue("No")
				.build();
		simpleScrollableForm = new AbstractSimpleScrollableMainForm(new HashMap<>()){
			
			@Override
			public void setDefaultFields(){
				weSetThoseFields = true;
				addField(field);
			}
		};
	}
	
	@Test
	public void testConstructor(){
		Map<String, Object> map = simpleScrollableForm.getMap();
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
		simpleScrollableForm = new AbstractSimpleScrollableMainForm(pojo){
			@Override
			public void setDefaultFields(){
				weSetThoseFields = true;
				addField(StringFormField.builder()
						.key("Derp").defaultValue("No")
						.build());
			}
		};
		Map<String, Object> map = simpleScrollableForm.getMap();
		assertFalse(map.isEmpty());
		assertTrue(map.containsKey("Derp"));
		assertEquals("No", map.get("Derp"));
		assertTrue(map.containsKey("Test"));
		assertEquals(52, map.get("Test"));
	}
	
	@Test
	public void testHasKeyFalse(){
		assertFalse(simpleScrollableForm.hasKey("Test"));
	}
	
	@Test
	public void testHasKeyTrue(){
		simpleScrollableForm.setItem("Derp", 5);
		assertTrue(simpleScrollableForm.hasKey("Derp"));
	}
	
	@Test
	public void testGetKeysPopulated(){
		simpleScrollableForm.setItem("Derp", 5);
		simpleScrollableForm.setItem("Test", "Yes");
		Set<String> keys = simpleScrollableForm.getKeys();
		assertFalse(keys.isEmpty());
		assertTrue(keys.contains("Derp"));
		assertTrue(keys.contains("Test"));
	}
	
	@Test
	public void testHasItemNotSet(){
		assertFalse(simpleScrollableForm.hasItem("Test"));
	}
	
	@Test
	public void testHasItemSetToNull(){
		simpleScrollableForm.setItem("Test", null);
		assertFalse(simpleScrollableForm.hasItem("Test"));
	}
	
	@Test
	public void testHasItemTrue(){
		simpleScrollableForm.setItem("Derp", 5);
		assertTrue(simpleScrollableForm.hasItem("Derp"));
	}
	
	@Test
	public void testGetItemNotSet(){
		assertNull(simpleScrollableForm.getItem("Test"));
	}
	
	@Test
	public void testGetItem(){
		simpleScrollableForm.setItem("Derp", 5);
		assertEquals(5, simpleScrollableForm.getItem("Derp"));
	}
	
	@Test
	public void testSetItem(){
		simpleScrollableForm.setItem("Derp", 5);
		assertTrue(simpleScrollableForm.hasKey("Derp"));
		assertTrue(simpleScrollableForm.hasItem("Derp"));
		assertEquals(5, simpleScrollableForm.getItem("Derp"));
	}
	
	@Test
	public void testRemoveItem(){
		simpleScrollableForm.setItem("Derp", 5);
		assertTrue(simpleScrollableForm.hasKey("Derp"));
		assertTrue(simpleScrollableForm.hasItem("Derp"));
		assertEquals(5, simpleScrollableForm.getItem("Derp"));
		
		simpleScrollableForm.removeItem("Derp");
		assertFalse(simpleScrollableForm.hasKey("Derp"));
		assertFalse(simpleScrollableForm.hasItem("Derp"));
		assertNull(simpleScrollableForm.getItem("Derp"));
	}
	
	@Test
	public void testGetMap(){
		simpleScrollableForm.setItem("Derp", 5);
		simpleScrollableForm.setItem("Test", "Yes");
		
		Map<String, Object> map = simpleScrollableForm.getMap();
		assertFalse(map.isEmpty());
		assertEquals(2, map.keySet().size());
		assertTrue(map.containsKey("Derp"));
		assertEquals(5, map.get("Derp"));
		assertTrue(map.containsKey("Test"));
		assertEquals("Yes", map.get("Test"));
	}
	
	@Test
	public void testGetFieldMap(){
		Map<String, FormField<?>> fields = simpleScrollableForm.getFieldMap();
		assertEquals(1, fields.size());
		assertTrue(fields.containsKey("Derp"));
		assertEquals(field, fields.get("Derp"));
	}
	
	@Test
	public void testGetComponentMap(){
		Map<String, JComponent> components = simpleScrollableForm.getComponentMap();
		assertEquals(1, components.size());
		assertTrue(components.containsKey("Derp"));
		assertTrue(components.get("Derp") instanceof JTextField);
	}
	
	@Test
	public void testAsComponent(){
		assertNotNull(simpleScrollableForm.asComponent());
	}
	
	@Test
	public void testAsPanel(){
		assertNotNull(simpleScrollableForm.asPanel());
	}
	
	@Test
	public void testSaveValues(){
		assertTrue(simpleScrollableForm.hasItem("Derp"));
		assertEquals("No", simpleScrollableForm.getItem("Derp"));
		((JTextField) simpleScrollableForm.getComponentByKey("Derp")).setText("Yeppers");
		simpleScrollableForm.saveValues();
		assertEquals("Yeppers", simpleScrollableForm.getItem("Derp"));
	}
	
	@Test
	public void testLabelsOnTop(){
		assertTrue(simpleScrollableForm.labelsOnTop());
	}
	
	@Test
	public void testAddField(){
		simpleScrollableForm.addField(StringFormField.builder()
				.key("Test").defaultValue("Yes")
				.build());
		assertTrue(simpleScrollableForm.hasItem("Test"));
		assertEquals("Yes", simpleScrollableForm.getItem("Test"));
	}
	
	@Test
	public void testSetDefaultFields(){
		assertTrue(weSetThoseFields);
	}
	
	@Test
	public void testGetFieldKeys(){
		Set<String> keys = simpleScrollableForm.getFieldKeys();
		assertEquals(1, keys.size());
		assertEquals("Derp", keys.iterator().next());
	}
	
	@Test
	public void testGetFieldByKey(){
		assertEquals(field, simpleScrollableForm.getFieldByKey("Derp"));
	}
	
	@Test
	public void testAddComponent(){
		JLabel label = new JLabel("Test");
		simpleScrollableForm.addComponent("Test", label);
		Map<String, JComponent> components = simpleScrollableForm.getComponentMap();
		assertEquals(2, components.size());
		assertTrue(components.containsKey("Test"));
		assertEquals(label, components.get("Test"));
	}
	
	@Test
	public void testCreateComponentsAndGetComponentByKey(){
		assertTrue(simpleScrollableForm.hasItem("Derp"));
		assertEquals("No", simpleScrollableForm.getItem("Derp"));
		JComponent comp = simpleScrollableForm.getComponentByKey("Derp");
		assertTrue(comp instanceof JTextField);
		assertEquals("No", ((JTextField) comp).getText());
	}
	
	@Test
	public void testGetComponentKeys(){
		Set<String> keys = simpleScrollableForm.getComponentKeys();
		assertEquals(1, keys.size());
		assertEquals("Derp", keys.iterator().next());
	}
	
	@Test
	public void testAsFrame(){
		assertEquals(simpleScrollableForm, simpleScrollableForm.asFrame());
	}
	
	@Test
	public void testDefaultCloseOperation(){
		assertEquals(CloseOperation.DISPOSE_ON_CLOSE, simpleScrollableForm.defaultCloseOperation());
	}
	
	@Test
	public void testIconPath(){
		assertNull(simpleScrollableForm.iconPath());
	}
	
	@Test
	public void testFramePreferredSize(){
		assertNull(simpleScrollableForm.framePreferredSize());
	}
	
	@Test
	public void testConfigureFrameSettingsCloseOperation(){
		assertEquals(simpleScrollableForm.asFrame().getDefaultCloseOperation(),
				simpleScrollableForm.defaultCloseOperation().getValue());
	}
	
	@Test
	public void testConfigureFrameSettingsIconPath(){
		assertNull(simpleScrollableForm.asFrame().getIconImage());
	}
	
	@Test
	public void testConfigureFrameSettingsIconPathSet() throws Throwable{
		simpleScrollableForm = new AbstractSimpleScrollableMainForm(new HashMap<>()){
			@Override
			public String iconPath(){
				return "/img/meteor.png";
			}
			@Override
			public void setDefaultFields(){
				// Do nothing
			}
		};
		assertNotNull(simpleScrollableForm.asFrame().getIconImage());
	}
	
	@Test
	public void testConfigureFrameSettingsFramePreferredSize(){
		assertFalse(simpleScrollableForm.asComponent().isPreferredSizeSet());
	}
	
	@Test
	public void testConfigureFrameSettingsFramePreferredSizeSet() throws Throwable{
		Dimension size = new Dimension(50, 50);
		simpleScrollableForm = new AbstractSimpleScrollableMainForm(new HashMap<>()){
			@Override
			public Dimension framePreferredSize(){
				return size;
			}
			@Override
			public void setDefaultFields(){
				// Do nothing
			}
		};
		assertTrue(simpleScrollableForm.asComponent().isPreferredSizeSet());
		assertEquals(size, simpleScrollableForm.asComponent().getPreferredSize());
	}
	
	@Test
	public void testLaunch(){
		simpleScrollableForm.launch();
		assertTrue(simpleScrollableForm.asFrame().isVisible());
	}
	
	@Test
	public void testAsScrollPane(){
		assertNotNull(simpleScrollableForm.asScrollPane());
	}
	
	@Test
	public void testGetOriginalForm(){
		assertEquals(simpleScrollableForm.asScrollPane(), simpleScrollableForm.getOriginalForm());
	}
	
	@Test
	public void testSetOriginalForm(){
		DummyForm form = new DummyForm();
		Container original = simpleScrollableForm.getOriginalForm();
		simpleScrollableForm.switchForm(form);
		assertEquals(form.asComponent(), simpleScrollableForm.asFrame().getContentPane());
		assertEquals(original, simpleScrollableForm.getOriginalForm());
		simpleScrollableForm.switchToOriginalForm();
		assertEquals(simpleScrollableForm.getOriginalForm(), simpleScrollableForm.asFrame().getContentPane());
		assertEquals(original, simpleScrollableForm.getOriginalForm());
	}
	
	@Test
	public void testSwitchForm(){
		DummyForm form = new DummyForm();
		Container original = simpleScrollableForm.getOriginalForm();
		simpleScrollableForm.switchForm(form);
		assertEquals(form.asComponent(), simpleScrollableForm.asFrame().getContentPane());
		assertEquals(original, simpleScrollableForm.getOriginalForm());
	}
}
