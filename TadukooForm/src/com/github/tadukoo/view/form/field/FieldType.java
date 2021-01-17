package com.github.tadukoo.view.form.field;

/**
 * Field Type is used in {@link FormField} for what type of field it is.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 * @since Alpha v.0.2
 */
public enum FieldType{
	/** A boolean field */
	BOOLEAN,
	/** An int field */
	INT,
	/** A float field */
	FLOAT,
	/** A double field */
	DOUBLE,
	/** A short field */
	SHORT,
	/** A long field */
	LONG,
	/** A string field */
	STRING,
	/** A Date field */
	DATE,
	/** A drop-down field */
	DROP_DOWN,
	/** A button (not really a field) */
	BUTTON,
	/** A {@link com.github.tadukoo.view.form.Form Form} field */
	FORM,
	/** A {@link com.github.tadukoo.util.pojo.Table Table} field */
	TABLE,
	/** Used for fields not covered by this non-exhaustive list made outside of Tadukoo Form */
	CUSTOM
}
