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

public class SimpleMainFormTest{
	private boolean weSetThoseFields = false;
	
	private SimpleMainForm simpleForm;
	private FormField<?> field;
	
	@BeforeEach
	public void setup() throws Throwable{
		field = StringFormField.builder()
				.labelType(LabelType.NONE)
				.stringFieldType(StringFormField.StringFieldType.NORMAL)
				.key("Derp").defaultValue("No")
				.build();
		simpleForm = new AbstractSimpleMainForm(new HashMap<>()){
			
			@Override
			public void setDefaultFields(){
				weSetThoseFields = true;
				addField(field);
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
		SimpleMainForm simpleForm = new AbstractSimpleMainForm(pojo){
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
	public void testGetFieldMap(){
		Map<String, FormField<?>> fields = simpleForm.getFieldMap();
		assertEquals(1, fields.size());
		assertTrue(fields.containsKey("Derp"));
		assertEquals(field, fields.get("Derp"));
	}
	
	@Test
	public void testGetComponentMap(){
		Map<String, JComponent> components = simpleForm.getComponentMap();
		assertEquals(1, components.size());
		assertTrue(components.containsKey("Derp"));
		assertTrue(components.get("Derp") instanceof JTextField);
	}
	
	@Test
	public void testAsComponent(){
		assertNotNull(simpleForm.asComponent());
	}
	
	@Test
	public void testAsPanel(){
		assertNotNull(simpleForm.asPanel());
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
	public void testGetFieldKeys(){
		Set<String> keys = simpleForm.getFieldKeys();
		assertEquals(1, keys.size());
		assertEquals("Derp", keys.iterator().next());
	}
	
	@Test
	public void testGetFieldByKey(){
		assertEquals(field, simpleForm.getFieldByKey("Derp"));
	}
	
	@Test
	public void testAddComponent(){
		JLabel label = new JLabel("Test");
		simpleForm.addComponent("Test", label);
		Map<String, JComponent> components = simpleForm.getComponentMap();
		assertEquals(2, components.size());
		assertTrue(components.containsKey("Test"));
		assertEquals(label, components.get("Test"));
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
	public void testGetComponentKeys(){
		Set<String> keys = simpleForm.getComponentKeys();
		assertEquals(1, keys.size());
		assertEquals("Derp", keys.iterator().next());
	}
	
	@Test
	public void testAsFrame(){
		assertEquals(simpleForm, simpleForm.asFrame());
	}
	
	@Test
	public void testDefaultCloseOperation(){
		assertEquals(CloseOperation.DISPOSE_ON_CLOSE, simpleForm.defaultCloseOperation());
	}
	
	@Test
	public void testIconPath(){
		assertNull(simpleForm.iconPath());
	}
	
	@Test
	public void testFramePreferredSize(){
		assertNull(simpleForm.framePreferredSize());
	}
	
	@Test
	public void testConfigureFrameSettingsCloseOperation(){
		assertEquals(simpleForm.asFrame().getDefaultCloseOperation(), simpleForm.defaultCloseOperation().getValue());
	}
	
	@Test
	public void testConfigureFrameSettingsIconPath(){
		assertNull(simpleForm.asFrame().getIconImage());
	}
	
	@Test
	public void testConfigureFrameSettingsIconPathSet() throws Throwable{
		simpleForm = new AbstractSimpleMainForm(new HashMap<>()){
			@Override
			public String iconPath(){
				return "/img/meteor.png";
			}
			@Override
			public void setDefaultFields(){
				// Do nothing
			}
		};
		assertNotNull(simpleForm.asFrame().getIconImage());
	}
	
	@Test
	public void testConfigureFrameSettingsFramePreferredSize(){
		assertFalse(simpleForm.asComponent().isPreferredSizeSet());
	}
	
	@Test
	public void testConfigureFrameSettingsFramePreferredSizeSet() throws Throwable{
		Dimension size = new Dimension(50, 50);
		simpleForm = new AbstractSimpleMainForm(new HashMap<>()){
			@Override
			public Dimension framePreferredSize(){
				return size;
			}
			@Override
			public void setDefaultFields(){
				// Do nothing
			}
		};
		assertTrue(simpleForm.asComponent().isPreferredSizeSet());
		assertEquals(size, simpleForm.asComponent().getPreferredSize());
	}
	
	@Test
	public void testLaunch(){
		simpleForm.launch();
		assertTrue(simpleForm.asFrame().isVisible());
	}
	
	@Test
	public void testGetOriginalForm(){
		assertEquals(simpleForm.asPanel(), simpleForm.getOriginalForm());
	}
	
	@Test
	public void testSetOriginalForm(){
		DummyForm form = new DummyForm();
		Container original = simpleForm.getOriginalForm();
		simpleForm.switchForm(form);
		assertEquals(form.asComponent(), simpleForm.asFrame().getContentPane());
		assertEquals(original, simpleForm.getOriginalForm());
		simpleForm.switchToOriginalForm();
		assertEquals(simpleForm.getOriginalForm(), simpleForm.asFrame().getContentPane());
		assertEquals(original, simpleForm.getOriginalForm());
	}
	
	@Test
	public void testSwitchForm(){
		DummyForm form = new DummyForm();
		Container original = simpleForm.getOriginalForm();
		simpleForm.switchForm(form);
		assertEquals(form.asComponent(), simpleForm.asFrame().getContentPane());
		assertEquals(original, simpleForm.getOriginalForm());
	}
}
