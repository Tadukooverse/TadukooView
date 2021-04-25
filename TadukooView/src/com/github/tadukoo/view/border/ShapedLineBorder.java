package com.github.tadukoo.view.border;

import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeFunction;
import com.github.tadukoo.view.shapes.ShapeInfo;
import com.github.tadukoo.view.components.interfaces.Shaped;
import com.github.tadukoo.view.shapes.Shapes;

import javax.swing.border.AbstractBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.Path2D;

/**
 * Shaped Line Border mimics the functionality of a {@link javax.swing.border.LineBorder LineBorder}, but uses the
 * {@link ShapeInfo} (if present) on the component to draw the border, rather than making a rectangular border, or
 * it can have its own {@link ShapeInfo} if desired.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.2.1
 * @since Alpha v.0.2
 */
public class ShapedLineBorder extends AbstractBorder{
	
	/**
	 * Shaped Line Border Builder is used to create a {@link ShapedLineBorder}. It uses the following parameters:
	 * <ul>
	 *     <li>shapeInfo - The {@link ShapeInfo} to use on the Border (may be null to use the component's shape) -
	 *     defaults to null</li>
	 *     <li>paint - The {@link SizablePaint} to use on the Border - defaults to solid black</li>
	 *     <li>thickness - the thickness of the line - defaults to 1</li>
	 * </ul>
	 *
	 * @author Logan Ferree (Tadukoo)
	 * @version Alpha v.0.2.1
	 * @since Alpha v.0.2
	 */
	public static class ShapedLineBorderBuilder{
		/** The {@link ShapeInfo} to use on the Border (may be null to use the component's shape) */
		private ShapeInfo shapeInfo = null;
		/** The {@link SizablePaint} to use on the Border */
		private SizablePaint paint = new SizableColor(Color.BLACK);
		/** The thickness of the line */
		private int thickness = 1;
		
		// Can't create the builder outside of ShapeLineBorder
		private ShapedLineBorderBuilder(){ }
		
		/**
		 * @param shapeInfo The {@link ShapeInfo} to use on the Border (may be null to use the component's shape)
		 * @return this, to continue building
		 */
		public ShapedLineBorderBuilder shapeInfo(ShapeInfo shapeInfo){
			this.shapeInfo = shapeInfo;
			return this;
		}
		
		/**
		 * @param paint The {@link SizablePaint} to use on the Border
		 * @return this, to continue building
		 */
		public ShapedLineBorderBuilder paint(SizablePaint paint){
			this.paint = paint;
			return this;
		}
		
		/**
		 * @param thickness The thickness of the line
		 * @return this, to continue building
		 */
		public ShapedLineBorderBuilder thickness(int thickness){
			this.thickness = thickness;
			return this;
		}
		
		/**
		 * @return A newly created {@link ShapedLineBorder} using the set parameters
		 */
		public ShapedLineBorder build(){
			return new ShapedLineBorder(shapeInfo, paint, thickness);
		}
	}
	
	/** The {@link ShapeInfo} to use on this Border (may be null to use the component's shape) */
	private final ShapeInfo shapeInfo;
	/** The {@link SizablePaint} to use on this Border */
	private final SizablePaint paint;
	/** The thickness of the line */
	private final int thickness;
	
	/**
	 * Constructs a new ShapedLineBorder with the given parameters
	 *
	 * @param shapeInfo The {@link ShapeInfo} to use on this Border (may be null to use the component's shape)
	 * @param paint The {@link SizablePaint} to use on this Border
	 * @param thickness The thickness of the line
	 */
	private ShapedLineBorder(ShapeInfo shapeInfo, SizablePaint paint, int thickness){
		this.shapeInfo = shapeInfo;
		this.paint = paint;
		this.thickness = thickness;
	}
	
	/**
	 * @return A {@link ShapedLineBorderBuilder builder} to create a {@link ShapedLineBorder}
	 */
	public static ShapedLineBorderBuilder builder(){
		return new ShapedLineBorderBuilder();
	}
	
	/** {@inheritDoc} */
	@Override
	public Insets getBorderInsets(Component c){
		return new Insets(thickness, thickness, thickness, thickness);
	}
	
	/** {@inheritDoc} */
	@Override
	public Insets getBorderInsets(Component c, Insets insets){
		insets.set(thickness, thickness, thickness, thickness);
		return insets;
	}
	
	/** {@inheritDoc} */
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int w, int h){
		if((this.thickness > 0) && (g instanceof Graphics2D g2d)){
			// Determine Shape function to use
			ShapeFunction shapeFunc = shapeInfo != null?shapeInfo.getShapeFunc():null;
			if(shapeFunc == null){
				if(c instanceof Shaped){
					shapeFunc = ((Shaped) c).getShapeInfo().getShapeFunc();
				}else{
					// Use a Rectangle if it's not a Shaped object
					shapeFunc = Shapes.RECTANGLE.getShapeInfo().getShapeFunc();
				}
			}
			
			// Determine inner + outer shapes for the border
			int offset = thickness;
			int size = offset + offset;
			Shape outer = shapeFunc.apply(x, y, w, h);
			Shape inner = shapeFunc.apply(x + offset, y + offset, w - size, h - size);
			
			// Cast Graphics to Graphics2D
			
			// Set the color and draw the border
			g2d.setPaint(paint.getPaint(new Dimension(w, h)));
			Path2D path = new Path2D.Float(Path2D.WIND_EVEN_ODD);
			path.append(outer, false);
			path.append(inner, false);
			g2d.fill(path);
		}
	}
}
