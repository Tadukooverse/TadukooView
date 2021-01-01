package com.github.tadukoo.view.lookandfeel.shapeui;

import com.github.tadukoo.view.shapes.ShapeDrawingFunction;
import com.github.tadukoo.view.shapes.ShapeFunction;
import com.github.tadukoo.view.shapes.ShapeInfo;
import com.github.tadukoo.view.shapes.ShapeInsetsFunction;

import javax.swing.plaf.UIResource;

/**
 * A wrapper around {@link ShapeInfo} to turn it into a {@link UIResource} for use in the Look &amp; Feel.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 */
public class ShapeInfoUIResource extends ShapeInfo implements UIResource{
	
	/**
	 * Creates a new Shape Info UIResource using the given {@link ShapeInfo}. It just takes the functions present on
	 * the {@link ShapeInfo} and sends them to the constructor.
	 *
	 * @param shapeInfo The {@link ShapeInfo} to wrap as a UIResource
	 */
	public ShapeInfoUIResource(ShapeInfo shapeInfo){
		super(shapeInfo.getShapeFunc(), shapeInfo.getShapeInsetsFunc(),
				shapeInfo.getTopLeftDrawFunc(), shapeInfo.getBottomRightDrawFunc());
	}
	
	/** {@inheritDoc} */
	public ShapeInfoUIResource(ShapeFunction shapeFunc, ShapeInsetsFunction shapeInsetsFunc,
	                           ShapeDrawingFunction topLeftDrawFunc, ShapeDrawingFunction bottomRightDrawFunc){
		super(shapeFunc, shapeInsetsFunc, topLeftDrawFunc, bottomRightDrawFunc);
	}
}
