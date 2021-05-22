package com.github.tadukoo.view.form.tabbed;

import com.github.tadukoo.util.ListUtil;
import com.github.tadukoo.util.pojo.AbstractMappedPojo;
import com.github.tadukoo.util.pojo.MappedPojo;
import com.github.tadukoo.view.form.AbstractSimpleForm;
import com.github.tadukoo.view.form.Form;
import com.github.tadukoo.view.form.SimpleForm;
import com.github.tadukoo.view.form.field.StringFormField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Component;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TabbedFormTest{
	private boolean weSetThoseFields = false;
	private boolean weSavedValues = false;
	
	private TabbedForm tabbedForm;
	private SimpleForm innerForm;
	private final List<String> keys = ListUtil.createList("yep");
	
	@BeforeEach
	public void setup() throws Throwable{
		innerForm = new AbstractSimpleForm(new HashMap<>()){
			@Override
			public void setDefaultFields(){
				addField(StringFormField.builder()
						.key("Derp").defaultValue("No")
						.build());
			}
			@Override
			public void saveValues(){
				weSavedValues = true;
			}
		};
		tabbedForm = new AbstractTabbedForm(new HashMap<>()){
			
			@Override
			public List<String> getKeyOrder(){
				return keys;
			}
			
			@Override
			public void setDefaultTabs(){
				weSetThoseFields = true;
				addTab("Test", innerForm);
			}
		};
	}
	
	@Test
	public void testConstructor(){
		Map<String, Object> map = tabbedForm.getMap();
		assertFalse(map.isEmpty());
		assertTrue(map.containsKey("Test"));
		assertEquals(innerForm, map.get("Test"));
	}
	
	@Test
	public void testFormConstructor() throws Throwable{
		MappedPojo pojo = new AbstractMappedPojo(){
			@Override
			public Map<String, Object> getMap(){
				Map<String, Object> aMap = new HashMap<>();
				aMap.put("Derp", innerForm);
				return aMap;
			}
		};
		TabbedForm tabbedForm = new AbstractTabbedForm(pojo){
			@Override
			public List<String> getKeyOrder(){
				return null;
			}
			
			@Override
			public void setDefaultTabs(){
				weSetThoseFields = true;
				addTab("Test", innerForm);
			}
		};
		Map<String, Object> map = tabbedForm.getMap();
		assertFalse(map.isEmpty());
		assertTrue(map.containsKey("Derp"));
		assertEquals(innerForm, map.get("Derp"));
		assertTrue(map.containsKey("Test"));
		assertEquals(innerForm, map.get("Test"));
	}
	
	@Test
	public void testHasKeyFalse(){
		assertFalse(tabbedForm.hasKey("Derp"));
	}
	
	@Test
	public void testHasKeyTrue(){
		tabbedForm.setItem("Derp", 5);
		assertTrue(tabbedForm.hasKey("Derp"));
	}
	
	@Test
	public void testGetKeysPopulated(){
		tabbedForm.setItem("Derp", 5);
		tabbedForm.setItem("Test", "Yes");
		Set<String> keys = tabbedForm.getKeys();
		assertFalse(keys.isEmpty());
		assertTrue(keys.contains("Derp"));
		assertTrue(keys.contains("Test"));
	}
	
	@Test
	public void testHasItemNotSet(){
		assertFalse(tabbedForm.hasItem("Derp"));
	}
	
	@Test
	public void testHasItemSetToNull(){
		tabbedForm.setItem("Test", null);
		assertFalse(tabbedForm.hasItem("Test"));
	}
	
	@Test
	public void testHasItemTrue(){
		tabbedForm.setItem("Derp", 5);
		assertTrue(tabbedForm.hasItem("Derp"));
	}
	
	@Test
	public void testGetItemNotSet(){
		assertNull(tabbedForm.getItem("Derp"));
	}
	
	@Test
	public void testGetItem(){
		tabbedForm.setItem("Derp", 5);
		assertEquals(5, tabbedForm.getItem("Derp"));
	}
	
	@Test
	public void testSetItem(){
		tabbedForm.setItem("Derp", 5);
		assertTrue(tabbedForm.hasKey("Derp"));
		assertTrue(tabbedForm.hasItem("Derp"));
		assertEquals(5, tabbedForm.getItem("Derp"));
	}
	
	@Test
	public void testRemoveItem(){
		tabbedForm.setItem("Derp", 5);
		assertTrue(tabbedForm.hasKey("Derp"));
		assertTrue(tabbedForm.hasItem("Derp"));
		assertEquals(5, tabbedForm.getItem("Derp"));
		
		tabbedForm.removeItem("Derp");
		assertFalse(tabbedForm.hasKey("Derp"));
		assertFalse(tabbedForm.hasItem("Derp"));
		assertNull(tabbedForm.getItem("Derp"));
	}
	
	@Test
	public void testGetMap(){
		tabbedForm.setItem("Derp", 5);
		tabbedForm.setItem("Test", "Yes");
		
		Map<String, Object> map = tabbedForm.getMap();
		assertFalse(map.isEmpty());
		assertEquals(2, map.keySet().size());
		assertTrue(map.containsKey("Derp"));
		assertEquals(5, map.get("Derp"));
		assertTrue(map.containsKey("Test"));
		assertEquals("Yes", map.get("Test"));
	}
	
	@Test
	public void testGetTabMap(){
		Map<String, Form> tabs = tabbedForm.getTabMap();
		assertEquals(1, tabs.size());
		assertTrue(tabs.containsKey("Test"));
		assertEquals(innerForm, tabs.get("Test"));
	}
	
	@Test
	public void testAsComponent(){
		assertEquals(tabbedForm, tabbedForm.asComponent());
	}
	
	@Test
	public void testSaveValues(){
		tabbedForm.saveValues();
		assertTrue(weSavedValues);
	}
	
	@Test
	public void testConfigureSettings(){
		assertEquals(tabbedForm.tabPlacement().getValue(), ((AbstractTabbedForm) tabbedForm).getTabPlacement());
		assertEquals(tabbedForm.tabLayoutPolicy().getValue(), ((AbstractTabbedForm) tabbedForm).getTabLayoutPolicy());
	}
	
	@Test
	public void testTabPlacement(){
		assertEquals(TabPlacement.LEFT, tabbedForm.tabPlacement());
	}
	
	@Test
	public void testTabLayoutPolicy(){
		assertEquals(TabLayoutPolicy.SCROLL_TAB_LAYOUT, tabbedForm.tabLayoutPolicy());
	}
	
	@Test
	public void testDefaultTabLabelType(){
		assertEquals(TabLabelType.SIMPLE_PANEL_LABEL, tabbedForm.defaultTabLabelType());
	}
	
	@Test
	public void testSetDefaultTabs(){
		assertTrue(weSetThoseFields);
	}
	
	@Test
	public void testAddTab(){
		assertEquals(innerForm, tabbedForm.getItem("Test"));
		assertEquals(1, tabbedForm.getAllTabs().size());
		assertEquals(innerForm, tabbedForm.getAllTabs().iterator().next());
		JTabbedPane tabbedPane = (JTabbedPane) tabbedForm;
		assertEquals(innerForm, tabbedPane.getComponentAt(0));
		Component tabCom = tabbedPane.getTabComponentAt(0);
		assertNotNull(tabCom);
		assertTrue(tabCom instanceof JPanel);
	}
	
	@Test
	public void testAddTabLabelType() throws Throwable{
		Form tab = new AbstractSimpleForm(new HashMap<>()){
			@Override
			public void setDefaultFields(){
				// Do nothing
			}
		};
		tabbedForm.addTab("Derp", tab, TabLabelType.SIMPLE_LABEL);
		assertEquals(tab, tabbedForm.getItem("Derp"));
		Collection<Form> tabs = tabbedForm.getAllTabs();
		assertEquals(2, tabs.size());
		Iterator<Form> tabsIt = tabs.iterator();
		assertEquals(innerForm, tabsIt.next());
		assertEquals(tab, tabsIt.next());
		JTabbedPane tabbedPane = (JTabbedPane) tabbedForm;
		assertEquals(innerForm, tabbedPane.getComponentAt(0));
		assertEquals(tab, tabbedPane.getComponentAt(1));
		Component tabCom = tabbedPane.getTabComponentAt(1);
		assertNotNull(tabCom);
		assertTrue(tabCom instanceof JLabel);
	}
	
	@Test
	public void testAddTabCustomLabel() throws Throwable{
		Form tab = new AbstractSimpleForm(new HashMap<>()){
			@Override
			public void setDefaultFields(){
				// Do nothing
			}
		};
		JLabel label = new JLabel("Yessir");
		tabbedForm.addTab("Derp", tab, label);
		assertEquals(tab, tabbedForm.getItem("Derp"));
		Collection<Form> tabs = tabbedForm.getAllTabs();
		assertEquals(2, tabs.size());
		Iterator<Form> tabsIt = tabs.iterator();
		assertEquals(innerForm, tabsIt.next());
		assertEquals(tab, tabsIt.next());
		JTabbedPane tabbedPane = (JTabbedPane) tabbedForm;
		assertEquals(innerForm, tabbedPane.getComponentAt(0));
		assertEquals(tab, tabbedPane.getComponentAt(1));
		assertEquals(label, tabbedPane.getTabComponentAt(1));
	}
	
	@Test
	public void testGetAllTabs(){
		Collection<Form> tabs = tabbedForm.getAllTabs();
		assertEquals(1, tabs.size());
		assertEquals(innerForm, tabs.iterator().next());
	}
	
	@Test
	public void testGetNumTabs() throws Throwable{
		assertEquals(1, tabbedForm.getNumTabs());
		tabbedForm.addTab("Test 2", new AbstractSimpleForm(new HashMap<>()){
			@Override
			public void setDefaultFields(){
				// Do nothing
			}
		});
		assertEquals(2, tabbedForm.getNumTabs());
	}
}
