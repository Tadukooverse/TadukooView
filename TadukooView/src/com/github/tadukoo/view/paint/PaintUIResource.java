package com.github.tadukoo.view.paint;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.Paint;
import java.util.List;

/**
 * PaintUIResource is a {@link UIResource} to be used for {@link Paint}s for in
 * Tadukoo Look &amp; Feel (or other custom Look &amp; Feels as desired). It provides methods to get the actual
 * {@link Paint} or to get a single {@link ColorUIResource} or a {@code List<Object>} for use in supporting
 * {@link MetalLookAndFeel} component UI classes.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 * @since Alpha v.0.2
 */
public interface PaintUIResource extends SizablePaint, UIResource{
	
	/**
	 * In some cases, we need to return a ColorUIResource to support the Look &amp; Feel properly. I don't like it,
	 * but it needs to be done for those Look &amp; Feel pieces to work, and I'm trying to support all of them.
	 *
	 * @return A ColorUIResource
	 */
	ColorUIResource getColorUIResource();
	
	/**
	 * Metal Look and Feel has a trash way of handling gradients. Basically it takes 3 colors and 2 fractions, but
	 * with the 3 colors, it repeats color 1 and does 1, 2, 1, 3. The fractions represent the 2 middle points,
	 * but the 2nd point is calculated as mid1 * 2 + mid2.
	 * <br><br>
	 * This method exists for the purpose of appeasing the Metal Look &amp; Feel god who decided this disgusting way
	 * of code.
	 *
	 * @return The garbage List that Metal Look and Feel expects for gradients that matches best to the one defined here
	 */
	List<Object> getMetalGradientList();
}
