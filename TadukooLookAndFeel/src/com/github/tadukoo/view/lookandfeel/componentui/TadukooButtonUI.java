package com.github.tadukoo.view.lookandfeel.componentui;

import com.github.tadukoo.view.lookandfeel.TadukooLookAndFeel;
import com.github.tadukoo.view.paint.HasSelectAndFocusPaints;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeFunction;
import com.github.tadukoo.view.shapes.ShapeInfo;
import com.github.tadukoo.view.shapes.Shaped;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * A {@link ComponentUI} class for use with {@link Button}s, used by {@link TadukooLookAndFeel} to
 * provide customizations for the Buttons beyond those present in existing Look &amp; Feels.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 * @since Alpha v.0.1
 */
public class TadukooButtonUI extends MetalButtonUI{
	
	/**
	 * Returns an instance of {@code TadukooButtonUI}.
	 *
	 * @param c a component
	 * @return an instance of {@code TadukooButtonUI}
	 */
	public static ComponentUI createUI(JComponent c){
		return new TadukooButtonUI();
	}
	
	/** {@inheritDoc} */
	@Override
	public void installDefaults(AbstractButton b){
		super.installDefaults(b);
		
		// Set the default focus and select paints on the button if it's supported
		if(b instanceof HasSelectAndFocusPaints){
			HasSelectAndFocusPaints s = (HasSelectAndFocusPaints) b;
			s.setSelectPaint((SizablePaint) UIManager.get("Button.select.paint"));
			s.setFocusPaint((SizablePaint) UIManager.get("Button.focus.paint"));
		}
		
		// Set the default shape function on the button if it's a Shaped button
		if(b instanceof Shaped){
			Shaped s = (Shaped) b;
			s.setShapeInfo((ShapeInfo) UIManager.get("Button.shape"));
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public void uninstallDefaults(AbstractButton b){
		super.uninstallDefaults(b);
		
		// Remove the default focus and select paints on the button if it's supported + using them
		if(b instanceof HasSelectAndFocusPaints){
			HasSelectAndFocusPaints s = (HasSelectAndFocusPaints) b;
			if(s.getSelectPaint() instanceof UIResource){
				s.setSelectPaint(null);
			}
			if(s.getFocusPaint() instanceof UIResource){
				s.setFocusPaint(null);
			}
		}
		
		// Remove shape function if it's a Shaped button and if it's using the default
		if(b instanceof Shaped){
			Shaped s = (Shaped) b;
			if(s.getShapeInfo() instanceof UIResource){
				s.setShapeInfo(null);
			}
		}
	}
	
	/** {@inheritDoc} */
	@Override
	protected void paintButtonPressed(Graphics g, AbstractButton b){
		// Cast Graphics to Graphics2D for our purposes
		Graphics2D g2d = (Graphics2D) g;
		
		if(b.isContentAreaFilled()){
			// Grab button size for use in paint and shape functions
			Dimension size = b.getSize();
			
			// Grab the paint to use and set it on the graphics
			SizablePaint paint = null;
			if(b instanceof HasSelectAndFocusPaints){
				paint = ((HasSelectAndFocusPaints) b).getSelectPaint();
			}
			if(paint == null){
				paint = (SizablePaint) UIManager.get("Button.select.paint");
			}
			g2d.setPaint(paint.getPaint(size));
			
			// Grab the shape function to be used
			ShapeFunction shapeFunc = null;
			if(b instanceof Shaped){
				shapeFunc = ((Shaped) b).getShapeInfo().getShapeFunc();
			}
			if(shapeFunc == null){
				shapeFunc = ((ShapeInfo) UIManager.get("Button.shape")).getShapeFunc();
			}
			// Fill the shape
			g2d.fill(shapeFunc.apply(0, 0, size.width, size.height));
		}
	}
	
	/** {@inheritDoc} */
	@Override
	protected void paintFocus(Graphics g, AbstractButton b,
	                          Rectangle viewRect, Rectangle textRect, Rectangle iconRect){
		// Cast Graphics to Graphics2D for our purposes
		Graphics2D g2d = (Graphics2D) g;
		
		Rectangle focusRect = new Rectangle();
		String text = b.getText();
		boolean isIcon = b.getIcon() != null;
		
		// If there is text
		if(text != null && !text.isEmpty()){
			if(!isIcon){
				focusRect.setBounds(textRect);
			}else{
				focusRect.setBounds(iconRect.union(textRect));
			}
		}else if(isIcon){
			// If there is an icon and no text
			focusRect.setBounds(iconRect);
		}
		
		// Grab the paint to use and set it on the graphics
		SizablePaint paint = null;
		if(b instanceof HasSelectAndFocusPaints){
			paint = ((HasSelectAndFocusPaints) b).getFocusPaint();
		}
		if(paint == null){
			paint = (SizablePaint) UIManager.get("Button.focus.paint");
		}
		g2d.setPaint(paint.getPaint(focusRect.getSize()));
		
		/* TODO: Potentially draw shape instead of rectangle (requires work on insets)
		// Grab the shape function to be used
		ShapeFunction shapeFunc = null;
		if(b instanceof Shaped){
			shapeFunc = ((Shaped) b).getShapeInfo().getShapeFunc();
		}
		if(shapeFunc == null){
			shapeFunc = ((ShapeInfo) UIManager.get("Button.shape")).getShapeFunc();
		}
		/**/
		
		// Draw the focus rectangle
		g2d.drawRect((focusRect.x-1), (focusRect.y-1),
				focusRect.width+1, focusRect.height+1);
		
	}
}
