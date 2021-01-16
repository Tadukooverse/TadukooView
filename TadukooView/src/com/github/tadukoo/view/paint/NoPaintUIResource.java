package com.github.tadukoo.view.paint;

import javax.swing.plaf.ColorUIResource;
import java.util.List;

/**
 * No Paint UIResource is a {@link PaintUIResource} version of {@link NoPaint} - where it's used when you need a
 * non-null {@link PaintUIResource} but don't want an actual paint.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 */
public class NoPaintUIResource extends NoPaint implements PaintUIResource{
	
	/** {@inheritDoc} */
	@Override
	public ColorUIResource getColorUIResource(){
		return null;
	}
	
	/** {@inheritDoc} */
	@Override
	public List<Object> getMetalGradientList(){
		return null;
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj){
		return obj instanceof NoPaintUIResource;
	}
}
