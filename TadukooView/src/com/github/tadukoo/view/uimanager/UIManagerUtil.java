package com.github.tadukoo.view.uimanager;

import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;

import javax.swing.UIManager;

/**
 * Utilities for working with {@link UIManager}
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 */
public class UIManagerUtil implements UIClassProperties, ThemeProperties{
	
	/** Not allowed to instantiate {@link UIManagerUtil} */
	private UIManagerUtil(){ }
	
	/*
	 * SizablePaint Methods
	 */
	
	/**
	 * @param propertyKey The property key of the {@link SizablePaint} to grab
	 * @return A {@link SizablePaint} from the {@link UIManager} using the given property key
	 */
	public static SizablePaint getSizablePaint(String propertyKey){
		return (SizablePaint) UIManager.get(propertyKey);
	}
	
	/**
	 * @param propertyPrefix The property prefix to use to grab a foreground {@link SizablePaint paint}
	 * @return A {@link SizablePaint} from the {@link UIManager} using the given prefix and {@link #FOREGROUND_PAINT}
	 */
	public static SizablePaint getForegroundPaint(String propertyPrefix){
		return getSizablePaint(propertyPrefix + FOREGROUND_PAINT);
	}
	
	/**
	 * @param propertyPrefix The property prefix to use to grab a background {@link SizablePaint paint}
	 * @return A {@link SizablePaint} from the {@link UIManager} using the given prefix and {@link #BACKGROUND_PAINT}
	 */
	public static SizablePaint getBackgroundPaint(String propertyPrefix){
		return getSizablePaint(propertyPrefix + BACKGROUND_PAINT);
	}
	
	/**
	 * @param propertyPrefix The property prefix to use to grab a select {@link SizablePaint paint}
	 * @return A {@link SizablePaint} from the {@link UIManager} using the given prefix and {@link #SELECT_PAINT}
	 */
	public static SizablePaint getSelectPaint(String propertyPrefix){
		return getSizablePaint(propertyPrefix + SELECT_PAINT);
	}
	
	/**
	 * @param propertyPrefix The property prefix to use to grab a focus {@link SizablePaint paint}
	 * @return A {@link SizablePaint} from the {@link UIManager} using the given prefix and {@link #FOCUS_PAINT}
	 */
	public static SizablePaint getFocusPaint(String propertyPrefix){
		return getSizablePaint(propertyPrefix + FOCUS_PAINT);
	}
	
	/**
	 * @param propertyPrefix The property prefix to use to grab a disabled text {@link SizablePaint paint}
	 * @return A {@link SizablePaint} from the {@link UIManager} using the given prefix and {@link #DISABLED_TEXT_PAINT}
	 */
	public static SizablePaint getDisabledTextPaint(String propertyPrefix){
		return getSizablePaint(propertyPrefix + DISABLED_TEXT_PAINT);
	}
	
	/**
	 * @param propertyPrefix The property prefix to use to grab a disabled foreground {@link SizablePaint paint}
	 * @return A {@link SizablePaint} from the {@link UIManager} using the given prefix and {@link #DISABLED_FOREGROUND_PAINT}
	 */
	public static SizablePaint getDisabledForegroundPaint(String propertyPrefix){
		return getSizablePaint(propertyPrefix + DISABLED_FOREGROUND_PAINT);
	}
	
	/*
	 * ShapeInfo Methods
	 */
	
	/**
	 * @param propertyKey The property key of the {@link ShapeInfo} to grab
	 * @return A {@link ShapeInfo} from the {@link UIManager} using the given property key
	 */
	public static ShapeInfo getShapeInfo(String propertyKey){
		return (ShapeInfo) UIManager.get(propertyKey);
	}
	
	/**
	 * @param propertyPrefix The property prefix to use to grab the default {@link ShapeInfo shape}
	 * @return A {@link ShapeInfo} from the {@link UIManager} using the given prefix and {@link #SHAPE}
	 */
	public static ShapeInfo getDefaultShapeInfo(String propertyPrefix){
		return getShapeInfo(propertyPrefix + SHAPE);
	}
}
