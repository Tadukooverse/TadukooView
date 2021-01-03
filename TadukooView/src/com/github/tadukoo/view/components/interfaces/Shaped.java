package com.github.tadukoo.view.components.interfaces;

import com.github.tadukoo.view.shapes.ShapeInfo;

/**
 * Shaped provides methods for getting and setting {@link ShapeInfo}, to be used on custom components to allow them
 * to use custom shapes.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 * @since Alpha v.0.2
 */
public interface Shaped{
	
	/**
	 * @return The {@link ShapeInfo} for this component
	 */
	ShapeInfo getShapeInfo();
	
	/**
	 * Sets the {@link ShapeInfo} for this component
	 *
	 * @param shapeInfo The {@link ShapeInfo} to be set
	 */
	void setShapeInfo(ShapeInfo shapeInfo);
}
