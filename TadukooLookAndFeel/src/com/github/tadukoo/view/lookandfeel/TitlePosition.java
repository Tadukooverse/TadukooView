package com.github.tadukoo.view.lookandfeel;

/**
 * An enum used for Title Position (for Titled Borders)
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 * @since Alpha v.0.2
 */
public enum TitlePosition{
	/** Position the title above the border's top line. */
	ABOVE_TOP(1),
	/** Position the title in the middle of the border's top line. */
	TOP(2),
	/** Position the title below the border's top line. */
	BELOW_TOP(3),
	/** Position the title above the border's bottom line. */
	ABOVE_BOTTOM(4),
	/** Position the title in the middle of the border's bottom line. */
	BOTTOM(5),
	/** Position the title below the border's bottom line. */
	BELOW_BOTTOM(6);
	
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
	 * @return The value of the Title Position (used in Titled Border class)
	 */
	public int getValue(){
		return value;
	}
}
