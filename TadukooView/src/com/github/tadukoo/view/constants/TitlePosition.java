package com.github.tadukoo.view.constants;

import javax.swing.border.TitledBorder;

/**
 * An enum used for Title Position (for Titled Borders)
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.4
 * @since Alpha v.0.2
 */
public enum TitlePosition{
	/** Position the title above the border's top line. */
	ABOVE_TOP(TitledBorder.ABOVE_TOP),
	/** Position the title in the middle of the border's top line. */
	TOP(TitledBorder.TOP),
	/** Position the title below the border's top line. */
	BELOW_TOP(TitledBorder.BELOW_TOP),
	/** Position the title above the border's bottom line. */
	ABOVE_BOTTOM(TitledBorder.ABOVE_BOTTOM),
	/** Position the title in the middle of the border's bottom line. */
	BOTTOM(TitledBorder.BOTTOM),
	/** Position the title below the border's bottom line. */
	BELOW_BOTTOM(TitledBorder.BELOW_BOTTOM);
	
	/** The value of the Title Position (used in Titled Border class) */
	private final int value;
	
	/**
	 * Constructs a new Title Position with the given value
	 *
	 * @param value The value for this Title Position
	 */
	TitlePosition(int value){
		this.value = value;
	}
	
	/**
	 * Searches for a {@link TitlePosition} with the given value
	 *
	 * @param value The value to use to find a {@link TitlePosition}
	 * @return The found {@link TitlePosition} or {@code null} if none were found with the given value
	 */
	public static TitlePosition fromValue(int value){
		for(TitlePosition pos: values()){
			if(pos.value == value){
				return pos;
			}
		}
		return null;
	}
	
	/**
	 * @return The value of the Title Position (used in Titled Border class)
	 */
	public int getValue(){
		return value;
	}
}
