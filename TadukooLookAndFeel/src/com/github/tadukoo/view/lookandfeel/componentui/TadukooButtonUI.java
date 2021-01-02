package com.github.tadukoo.view.lookandfeel.componentui;

import com.github.tadukoo.view.lookandfeel.TadukooLookAndFeel;
import com.github.tadukoo.view.paint.HasDisabledTextPaint;
import com.github.tadukoo.view.paint.HasSelectAndFocusPaints;
import com.github.tadukoo.view.paint.HasSizablePaints;
import com.github.tadukoo.view.paint.SizablePaint;
import com.github.tadukoo.view.shapes.ShapeInfo;
import com.github.tadukoo.view.shapes.Shaped;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
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
	
	/*
	 * Install/Uninstall Defaults
	 */
	
	/** {@inheritDoc} */
	@Override
	public void installDefaults(AbstractButton b){
		super.installDefaults(b);
		
		// Most of the shapes do not cover the entire area, causing problems if we leave opaque set to true
		b.setOpaque(false);
		
		// Set the default foreground and background paints on the button if it's supported
		if(b instanceof HasSizablePaints){
			HasSizablePaints s = (HasSizablePaints) b;
			s.setForegroundPaint(getForegroundPaint());
			s.setBackgroundPaint(getBackgroundPaint());
		}
		
		// Set the default focus and select paints on the button if it's supported
		if(b instanceof HasSelectAndFocusPaints){
			HasSelectAndFocusPaints s = (HasSelectAndFocusPaints) b;
			s.setSelectPaint(getSelectPaint());
			s.setFocusPaint(getFocusPaint());
		}
		
		// Set the default disabled text paint on the button if it's supported
		if(b instanceof HasDisabledTextPaint){
			HasDisabledTextPaint s = (HasDisabledTextPaint) b;
			s.setDisabledTextPaint(getDisabledTextPaint());
		}
		
		// Set the default shape function on the button if it's a Shaped button
		if(b instanceof Shaped){
			Shaped s = (Shaped) b;
			s.setShapeInfo(getShape());
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public void uninstallDefaults(AbstractButton b){
		super.uninstallDefaults(b);
		
		// Remove the default foreground and background paints on the button if it's supported and using them
		if(b instanceof HasSizablePaints){
			HasSizablePaints s = (HasSizablePaints) b;
			if(s.getForegroundPaint() instanceof UIResource){
				s.setForegroundPaint(null);
			}
			if(s.getBackgroundPaint() instanceof UIResource){
				s.setBackgroundPaint(null);
			}
		}
		
		// Remove the default focus and select paints on the button if it's supported and using them
		if(b instanceof HasSelectAndFocusPaints){
			HasSelectAndFocusPaints s = (HasSelectAndFocusPaints) b;
			if(s.getSelectPaint() instanceof UIResource){
				s.setSelectPaint(null);
			}
			if(s.getFocusPaint() instanceof UIResource){
				s.setFocusPaint(null);
			}
		}
		
		// Remove the default disabled text paint on the button if it's supported and using it
		if(b instanceof HasDisabledTextPaint){
			HasDisabledTextPaint s = (HasDisabledTextPaint) b;
			if(s.getDisabledTextPaint() instanceof UIResource){
				s.setDisabledTextPaint(null);
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
	
	/*
	 * Accessor Methods
	 */
	
	/**
	 * @return The {@link SizablePaint} to be used for the foreground from the Look &amp; Feel
	 */
	protected SizablePaint getForegroundPaint(){
		return (SizablePaint) UIManager.get(getPropertyPrefix() + "foreground.paint");
	}
	
	/**
	 * @param c A {@link Component} which may have the foreground paint on it
	 * @param size The {@link Dimension}s of the surface to be painted
	 * @return The sized {@link Paint} for the foreground - the {@link SizablePaint} used may come from the
	 * {@link Component} if it has it, or default to the Look &amp; Feel's paint
	 */
	protected Paint getForegroundPaint(Component c, Dimension size){
		SizablePaint paint;
		// Grab the foreground paint from the component if it has it
		if(c instanceof HasSizablePaints){
			paint = ((HasSizablePaints) c).getForegroundPaint();
		}else{
			// Default to the Look & Feel's setting
			paint = getForegroundPaint();
		}
		// Return the paint based on the given size
		return paint.getPaint(size);
	}
	
	/**
	 * @return The {@link SizablePaint} to be used for the background from the Look &amp; Feel
	 */
	protected SizablePaint getBackgroundPaint(){
		return (SizablePaint) UIManager.get(getPropertyPrefix() + "background.paint");
	}
	
	/**
	 * @param c A {@link Component} which may have the background paint on it
	 * @param size The {@link Dimension}s of the surface to be painted
	 * @return The sized {@link Paint} for the background - the {@link SizablePaint} used may come from the
	 * {@link Component} if it has it, or default to the Look &amp; Feel's paint
	 */
	protected Paint getBackgroundPaint(Component c, Dimension size){
		SizablePaint paint;
		// Grab the background paint from the component if it has it
		if(c instanceof HasSizablePaints){
			paint = ((HasSizablePaints) c).getBackgroundPaint();
		}else{
			// Default to the Look & Feel's setting
			paint = getBackgroundPaint();
		}
		// Return the paint based on the given size
		return paint.getPaint(size);
	}
	
	/**
	 * @return The {@link SizablePaint} to be used for when the Button is selected from the Look &amp; Feel
	 */
	protected SizablePaint getSelectPaint(){
		return (SizablePaint) UIManager.get(getPropertyPrefix() + "select.paint");
	}
	
	/**
	 * @param c A {@link Component} which may have the select paint on it
	 * @param size The {@link Dimension}s of the surface to be painted
	 * @return The sized {@link Paint} for the select - the {@link SizablePaint} used may come from the
	 * {@link Component} if it has it, or default to the Look &amp; Feel's paint
	 */
	protected Paint getSelectPaint(Component c, Dimension size){
		SizablePaint paint;
		// Grab the select paint from the component if it has it
		if(c instanceof HasSelectAndFocusPaints){
			paint = ((HasSelectAndFocusPaints) c).getSelectPaint();
		}else{
			// Default to the Look & Feel's setting
			paint = getSelectPaint();
		}
		// Return the paint based on the given size
		return paint.getPaint(size);
	}
	
	/**
	 * @return The {@link SizablePaint} to be used for when the Button is focused from the Look &amp; Feel
	 */
	protected SizablePaint getFocusPaint(){
		return (SizablePaint) UIManager.get(getPropertyPrefix() + "focus.paint");
	}
	
	/**
	 * @param c A {@link Component} which may have the focus paint on it
	 * @param size The {@link Dimension}s of the surface to be painted
	 * @return The sized {@link Paint} for the focus - the {@link SizablePaint} used may come from the
	 * {@link Component} if it has it, or default to the Look &amp; Feel's paint
	 */
	protected Paint getFocusPaint(Component c, Dimension size){
		SizablePaint paint;
		// Grab the focus paint from the component if it has it
		if(c instanceof HasSelectAndFocusPaints){
			paint = ((HasSelectAndFocusPaints) c).getFocusPaint();
		}else{
			// Default to the Look & Feel's setting
			paint = getFocusPaint();
		}
		// Return the paint based on the given size
		return paint.getPaint(size);
	}
	
	/**
	 * @return The {@link SizablePaint} to be used for disabled text on the Button from the Look &amp; Feel
	 */
	protected SizablePaint getDisabledTextPaint(){
		return (SizablePaint) UIManager.get(getPropertyPrefix() + "disabledText.paint");
	}
	
	/**
	 * @param c A {@link Component} which may have the disabled text paint on it
	 * @param size The {@link Dimension}s of the surface to be painted
	 * @return The sized {@link Paint} for the disabled text - the {@link SizablePaint} used may come from the
	 * {@link Component} if it has it, or default to the Look &amp; Feel's paint
	 */
	protected Paint getDisabledTextPaint(Component c, Dimension size){
		SizablePaint paint;
		// Grab the disabled text paint from the component if it has it
		if(c instanceof HasDisabledTextPaint){
			paint = ((HasDisabledTextPaint) c).getDisabledTextPaint();
		}else{
			// Default to the Look & Feel's setting
			paint = getDisabledTextPaint();
		}
		// Return the paint based on the given size
		return paint.getPaint(size);
	}
	
	/**
	 * @return The {@link ShapeInfo} to be used from the Look &amp; Feel
	 */
	protected ShapeInfo getShape(){
		return (ShapeInfo) UIManager.get(getPropertyPrefix() + "shape");
	}
	
	/**
	 * @param c A {@link Component} which may be {@link Shaped}
	 * @return The {@link ShapeInfo} from the {@link Component} if it has it, or from the Look &amp; Feel otherwise
	 */
	protected ShapeInfo getShape(Component c){
		// Grab the shape info from the component if it has it
		if(c instanceof Shaped){
			return ((Shaped) c).getShapeInfo();
		}else{
			// Default to the Look & Feel's setting
			return getShape();
		}
	}
	
	/*
	 * Paint Methods
	 */
	
	/** {@inheritDoc} */
	@Override
	public void update(Graphics g, JComponent c){
		// Cast Graphics to Graphics2D for our purposes
		Graphics2D g2d = (Graphics2D) g;
		
		// Grab dimensions
		int width = c.getWidth();
		int height = c.getHeight();
		
		// Grab the background paint and set it
		g2d.setPaint(getBackgroundPaint(c, new Dimension(width, height)));
		
		// Paint the background
		g2d.fill(getShape(c).getShapeFunc().apply(0, 0, width, height));
		
		// Do the other painting
		paint(g, c);
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
			g2d.setPaint(getSelectPaint(b, size));
			
			// Grab the shape and fill it
			g2d.fill(getShape(b).getShapeFunc().apply(0, 0, size.width, size.height));
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
		g2d.setPaint(getFocusPaint(b, focusRect.getSize()));
		
		/* TODO: Potentially draw shape instead of rectangle (requires work on insets)
		// Grab the shape function to be used
		ShapeFunction shapeFunc = null;
		if(b instanceof Shaped){
			shapeFunc = ((Shaped) b).getShapeInfo().getShapeFunc();
		}
		if(shapeFunc == null){
			shapeFunc = getShape().getShapeFunc();
		}
		/**/
		
		// Draw the focus rectangle
		g2d.drawRect((focusRect.x-1), (focusRect.y-1),
				focusRect.width+1, focusRect.height+1);
	}
	
	/** {@inheritDoc} */
	@Override
	protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text){
		// Cast Graphics to Graphics2D for our purposes
		Graphics2D g2d = (Graphics2D) g;
		
		AbstractButton b = (AbstractButton) c;
		ButtonModel model = b.getModel();
		FontMetrics fm = c.getFontMetrics(g.getFont());
		//int mnemIndex = b.getDisplayedMnemonicIndex();
		
		// Determine the size to be painted
		Dimension size = new Dimension(fm.stringWidth(text), fm.getHeight());
		
		// Determine the paint to use
		if(model.isEnabled()){
			// Paint the text normally using foreground paint
			g2d.setPaint(getForegroundPaint(b, size));
		}else{
			// Paint the text disabled
			g2d.setPaint(getDisabledTextPaint(b, size));
		}
		
		// Draw the actual text
		g.drawString(text, textRect.x, textRect.y + fm.getAscent());
		
		// TODO: Implement more of this string drawing method to further support stuff
		// SwingUtilities2.drawStringUnderlineCharAt(c, g,text,mnemIndex,
		//		textRect.x, textRect.y + fm.getAscent());
	}
}
