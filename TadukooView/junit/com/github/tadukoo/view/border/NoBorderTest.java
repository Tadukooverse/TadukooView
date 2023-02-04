package com.github.tadukoo.view.border;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NoBorderTest{
	
	@Test
	public void testEqualsTrue(){
		assertEquals(new NoBorder(), new NoBorder());
	}
	
	@Test
	public void testEqualsFalse(){
		//noinspection AssertBetweenInconvertibleTypes
		assertNotEquals(new NoBorder(), "Derp");
	}
}
