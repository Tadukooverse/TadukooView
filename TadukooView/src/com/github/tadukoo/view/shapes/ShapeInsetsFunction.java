package com.github.tadukoo.view.shapes;

import com.github.tadukoo.util.functional.NoException;
import com.github.tadukoo.util.functional.function.ThrowingFunction4;

import java.awt.Insets;

/**
 * It's a {@link ThrowingFunction4} that throws {@link NoException} (just a way to avoid throwing stuff),
 * takes in 4 integers (which should be x, y, width, and height), and returns an {@link Insets}. This interface
 * exists solely as shorthand for using the long ThrowingFunction4 name.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.2
 */
@FunctionalInterface
public interface ShapeInsetsFunction extends ThrowingFunction4<Integer, Integer, Integer, Integer, Insets, NoException>{
}
