package com.github.tadukoo.view.constants;

import javax.swing.JFrame;

/**
 * Close Operation represents what to do on closure of a frame/window.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 * @since Alpha v.0.3.3
 */
public enum CloseOperation{
	/** Do nothing when the frame/window is closed */
	DO_NOTHING_ON_CLOSE(JFrame.DO_NOTHING_ON_CLOSE),
	/** Hide the frame/window when closed */
	HIDE_ON_CLOSE(JFrame.HIDE_ON_CLOSE),
	/** Disposes of the frame/window when closed */
	DISPOSE_ON_CLOSE(JFrame.DISPOSE_ON_CLOSE),
	/** Exits the program when the frame/window is closed */
	EXIT_ON_CLOSE(JFrame.EXIT_ON_CLOSE);
	
	/** The int value used to represent the close operation */
	private final int value;
	
	/**
	 * Constructs a new close operation with the given value
	 *
	 * @param value The int value used to represent the close operation
	 */
	CloseOperation(int value){
		this.value = value;
	}
	
	/**
	 * Searches for a {@link CloseOperation} using the given value
	 *
	 * @param value The value to use to find a {@link CloseOperation}
	 * @return The found {@link CloseOperation} or {@code null} if none were found with the given value
	 */
	public static CloseOperation fromValue(int value){
		for(CloseOperation operation: values()){
			if(operation.value == value){
				return operation;
			}
		}
		return null;
	}
	
	/**
	 * @return The int value used to represent the close operation
	 */
	public int getValue(){
		return value;
	}
}
