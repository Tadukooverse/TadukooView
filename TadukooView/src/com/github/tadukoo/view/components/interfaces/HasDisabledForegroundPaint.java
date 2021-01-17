package com.github.tadukoo.view.components.interfaces;

import com.github.tadukoo.view.paint.SizablePaint;

/**
 * Interface to be used on Components for them to contain a {@link SizablePaint} for disabled foreground.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 */
public interface HasDisabledForegroundPaint{
	
	/**
	 * @return The {@link SizablePaint} to be used for disabled foreground on this Component
	 */
	SizablePaint getDisabledForegroundPaint();
	
	/**
	 * Sets the disabled foreground {@link SizablePaint} for this Component
	 *
	 * @param disabledForegroundPaint The {@link SizablePaint} to be used for disabled foreground on this Component
	 */
	void setDisabledForegroundPaint(SizablePaint disabledForegroundPaint);
}
