package com.github.tadukoo.view.components.interfaces;

import com.github.tadukoo.view.paint.SizablePaint;

/**
 * Interface to be used on Components for them to contain {@link SizablePaint}s for select and focus.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 */
public interface HasSelectAndFocusPaints{
	
	/**
	 * @return The {@link SizablePaint} to be used for the select of this Component
	 */
	SizablePaint getSelectPaint();
	
	/**
	 * Sets the select {@link SizablePaint} for this Component
	 *
	 * @param selectPaint The {@link SizablePaint} to be used for the select of this Component
	 */
	void setSelectPaint(SizablePaint selectPaint);
	
	/**
	 * @return The {@link SizablePaint} to be used for the focus of this Component
	 */
	SizablePaint getFocusPaint();
	
	/**
	 * Sets the focus {@link SizablePaint} for this Component
	 *
	 * @param focusPaint The {@link SizablePaint} to be used for the focus of this Component
	 */
	void setFocusPaint(SizablePaint focusPaint);
}
