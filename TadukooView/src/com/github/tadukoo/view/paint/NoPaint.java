package com.github.tadukoo.view.paint;

import java.awt.Dimension;
import java.awt.Paint;

/**
 * No Paint is to be used when you don't actually want a Paint object, but need to specify a non-null value.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 */
public class NoPaint implements SizablePaint{
	/** {@inheritDoc} */
	@Override
	public Paint getPaint(Dimension size){
		return null;
	}
}
