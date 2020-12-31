package com.github.tadukoo.view.paint;

/**
 * Interface to be used on Components for them to contain a {@link SizablePaint} for disabled text.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 */
public interface HasDisabledTextPaint{
	
	/**
	 * @return The {@link SizablePaint} to be used for disabled text on this Component
	 */
	SizablePaint getDisabledTextPaint();
	
	/**
	 * Sets the disabled text {@link SizablePaint} for this Component
	 *
	 * @param disabledTextPaint The {@link SizablePaint} to be used for disabled text on this Component
	 */
	void setDisabledTextPaint(SizablePaint disabledTextPaint);
}
