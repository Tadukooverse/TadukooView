package com.github.tadukoo.view.paint;

import org.junit.jupiter.api.Test;

import java.awt.Dimension;

import static org.junit.jupiter.api.Assertions.assertNull;

public class NoPaintUIResourceTest{
	
	@Test
	public void testGetPaint(){
		assertNull(new NoPaintUIResource().getPaint(new Dimension(25, 42)));
	}
}
