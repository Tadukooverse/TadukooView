package com.github.tadukoo.view.components.interfaces;

import com.github.tadukoo.view.paint.SizablePaint;

/**
 * Interface to be used on Components for them to contain {@link SizablePaint} versions of the foreground and
 * background colors, to be used instead of the simple colors.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 */
public interface HasSizablePaints{
	
	/**
	 * @return The {@link SizablePaint} to be used for the foreground of this Component
	 */
	SizablePaint getForegroundPaint();
	
	/**
	 * Sets the foreground {@link SizablePaint} for this Component
	 *
	 * @param foregroundPaint The {@link SizablePaint} to be used for the foreground of this Component
	 */
	void setForegroundPaint(SizablePaint foregroundPaint);
	
	/**
	 * @return The {@link SizablePaint} to be used for the background of this Component
	 */
	SizablePaint getBackgroundPaint();
	
	/**
	 * Sets the background {@link SizablePaint} for this Component
	 *
	 * @param backgroundPaint The {@link SizablePaint} to be used for the background of this Component
	 */
	void setBackgroundPaint(SizablePaint backgroundPaint);
}
