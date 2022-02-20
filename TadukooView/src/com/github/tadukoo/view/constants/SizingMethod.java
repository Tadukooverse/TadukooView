package com.github.tadukoo.view.constants;

import com.github.tadukoo.util.StringUtil;

/**
 * {@link SizingMethod} represents the method to use to size a component
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 */
public enum SizingMethod{
	
	/** Let Java size it however Java decides to */
	DEFAULT_JAVA("Default Java"),
	/** Grab the default from the current theme / look &amp; feel */
	DEFAULT_THEME("Default Theme"),
	/** Use the data to determine the size */
	BY_DATA("By Data"),
	/** Specify the exact size */
	SPECIFY_EXACT("Specify Exact"),
	/** Specify the size based on data sizing (e.g. you may have 3 rows of data, but specify to space it for 5 rows) */
	SPECIFY_DATA("Specify Data");
	
	/** The string representation of the {@link SizingMethod} */
	private final String method;
	
	/**
	 * Constructs a new {@link SizingMethod} using the given parameters
	 *
	 * @param method The string representation of the {@link SizingMethod}
	 */
	SizingMethod(String method){
		this.method = method;
	}
	
	/**
	 * Tries to find a {@link SizingMethod} that matches the given method string
	 *
	 * @param method The method string to use to find a {@link SizingMethod}
	 * @return The matching {@link SizingMethod}, or {@code null} if none matched
	 */
	public static SizingMethod fromMethod(String method){
		for(SizingMethod sizingMethod: values()){
			if(StringUtil.equalsIgnoreCase(sizingMethod.method, method)){
				return sizingMethod;
			}
		}
		return null;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString(){
		return method;
	}
}
