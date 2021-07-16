package com.github.tadukoo.view.components.interfaces;

import com.github.tadukoo.view.components.interfaces.paint.HasDisabledTextPaint;
import com.github.tadukoo.view.components.interfaces.paint.HasSelectAndFocusPaints;

import java.awt.Button;

/**
 * This is a generic interface to be used in {@link Button}s. It extends {@link TComponent}, along with
 * {@link HasSelectAndFocusPaints} and {@link HasDisabledTextPaint}, in order to cover the interfaces needed for
 * the customizations for a Button.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 */
public interface TButton extends TComponent, HasSelectAndFocusPaints, HasDisabledTextPaint{
}
