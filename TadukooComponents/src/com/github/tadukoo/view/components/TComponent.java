package com.github.tadukoo.view.components;

import com.github.tadukoo.view.paint.HasSizablePaints;
import com.github.tadukoo.view.shapes.Shaped;

/**
 * Generic Interface to be used by Tadukoo Components. It extends both {@link HasSizablePaints} and {@link Shaped},
 * which most or all components will have.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 */
public interface TComponent extends HasSizablePaints, Shaped{
}
