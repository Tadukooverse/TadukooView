package com.github.tadukoo.view.components.interfaces;

import com.github.tadukoo.view.InsetsUtil;
import com.github.tadukoo.view.shapes.ShapeInfo;

import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.Insets;

/**
 * Generic Interface to be used by Tadukoo Components. It extends both {@link HasSizablePaints} and {@link Shaped},
 * which most or all components will have. It also contains methods for grabbing proper {@link Insets}, based on
 * using the {@link ShapeInfo} on these Components.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 */
public interface TComponent extends HasSizablePaints, Shaped{
	
	/**
	 * @return The {@link Border} present on this Component (may be null)
	 */
	Border getBorder();
	
	/**
	 * Given the {@link Component} we're working with, will calculate the proper {@link Insets} for the Component,
	 * checking the {@link Border} and the {@link ShapeInfo}, if they're present.
	 *
	 * @param c The {@link Component} we're working with
	 * @return The proper {@link Insets} for the {@link Component}
	 */
	default Insets getProperInsets(Component c){
		Insets insets = InsetsUtil.zeroInsets(null);
		Border border = getBorder();
		ShapeInfo shapeInfo = getShapeInfo();
		if(border != null || shapeInfo != null){
			insets = new Insets(0, 0, 0, 0);
			
			// Use border insets if we have one
			if(border != null){
				insets = border.getBorderInsets(c);
			}
			
			// Use Shape insets if we have any
			if(shapeInfo != null){
				Insets shapeInsets = shapeInfo.getShapeInsetsFunc().apply(c.getX(), c.getY(),
						c.getWidth(), c.getHeight());
				insets = InsetsUtil.addInsets(insets, shapeInsets);
			}
		}
		return insets;
	}
	
	/**
	 * Given the {@link Component} we're working with, will calculate the proper {@link Insets} for the Component,
	 * checking the {@link Border} and the {@link ShapeInfo}, if they're present.
	 *
	 * @param c The {@link Component} we're working with
	 * @param insets An {@link Insets} instance to be used
	 * @return The proper {@link Insets} for the {@link Component}
	 */
	default Insets getProperInsets(Component c, Insets insets){
		// Reset insets to 0 before starting
		insets = InsetsUtil.zeroInsets(insets);
		
		// Add in border insets if we have one
		Border border = getBorder();
		if(border != null) {
			if(border instanceof AbstractBorder){
				insets = ((AbstractBorder)border).getBorderInsets(c, insets);
			}else{
				insets = border.getBorderInsets(c);
			}
		}
		
		// Add in Shape insets if we have any
		ShapeInfo shapeInfo = getShapeInfo();
		if(shapeInfo != null){
			Insets shapeInsets = shapeInfo.getShapeInsetsFunc().apply(c.getX(), c.getY(),
					c.getWidth(), c.getHeight());
			insets = InsetsUtil.addInsets(insets, shapeInsets);
		}
		
		return insets;
	}
}
