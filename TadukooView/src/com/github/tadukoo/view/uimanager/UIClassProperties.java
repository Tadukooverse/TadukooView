package com.github.tadukoo.view.uimanager;

import javax.swing.UIManager;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.LabelUI;

/**
 * UI Class Properties contains property keys for the UI classes stored in the {@link UIManager}
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 */
public interface UIClassProperties{
	
	/** The property key used for the {@link ButtonUI} class */
	String BUTTON_UI = "ButtonUI";
	
	/** The property key used for the {@link LabelUI} class */
	String LABEL_UI = "LabelUI";
}
