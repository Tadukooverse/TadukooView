package com.github.tadukoo.view.components.interfaces;

import java.awt.Label;

/**
 * This is a generic interface to be used in {@link Label}s. It extends {@link TComponent}, along with
 * {@link HasDisabledForegroundPaint}, in order to cover the interfaces needed for
 * the customizations for a Label.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 */
public interface TLabel extends TComponent, HasDisabledForegroundPaint{
}
