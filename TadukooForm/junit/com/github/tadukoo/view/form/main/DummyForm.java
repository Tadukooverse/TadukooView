package com.github.tadukoo.view.form.main;

import com.github.tadukoo.view.form.Form;

import javax.swing.JLabel;
import java.awt.Container;
import java.util.Map;

public class DummyForm implements Form{
	private final JLabel label;
	
	public DummyForm(){
		label = new JLabel("Test");
	}
	
	@Override
	public Container asComponent(){
		return label;
	}
	
	@Override
	public void saveValues(){
	
	}
	
	@Override
	public Map<String, Object> getMap(){
		return null;
	}
}
