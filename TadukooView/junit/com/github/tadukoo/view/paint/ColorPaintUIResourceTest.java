package com.github.tadukoo.view.paint;

import org.junit.jupiter.api.Test;

import javax.swing.plaf.ColorUIResource;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorPaintUIResourceTest{
	
	@Test
	public void testColorUIResourceConstructor(){
		ColorPaintUIResource color = new ColorPaintUIResource(new ColorUIResource(Color.BLUE));
		assertEquals(Color.BLUE.getRGB(), color.getRGB());
	}
	
	@Test
	public void testColorConstructor(){
		ColorPaintUIResource color = new ColorPaintUIResource(Color.PINK);
		assertEquals(Color.PINK.getRGB(), color.getRGB());
	}
	
	@Test
	public void testRGBConstructor(){
		ColorPaintUIResource color = new ColorPaintUIResource(Color.GRAY.getRGB());
		assertEquals(Color.GRAY.getRGB(), color.getRGB());
	}
	
	@Test
	public void testRGBIntsConstructor(){
		ColorPaintUIResource color = new ColorPaintUIResource(25, 39, 129);
		assertEquals(25, color.getRed());
		assertEquals(39, color.getGreen());
		assertEquals(129, color.getBlue());
	}
	
	@Test
	public void testRGBFloatsConstructor(){
		ColorPaintUIResource color = new ColorPaintUIResource(0.25f, 0.75f, 0.125f);
		assertEquals(64, color.getRed());
		assertEquals(191, color.getGreen());
		assertEquals(32, color.getBlue());
	}
	
	@Test
	public void testGetPaint(){
		ColorPaintUIResource color = new ColorPaintUIResource(Color.YELLOW);
		assertEquals(color, color.getPaint(new Dimension(25, 129)));
	}
	
	@Test
	public void testGetColorUIResource(){
		ColorPaintUIResource color = new ColorPaintUIResource(Color.BLACK);
		assertEquals(color, color.getColorUIResource());
	}
	
	@Test
	public void testGetMetalGradientList(){
		ColorPaintUIResource color = new ColorPaintUIResource(Color.YELLOW);
		List<Object> theList = color.getMetalGradientList();
		assertEquals(5, theList.size());
		assertEquals(0.33, theList.get(0));
		assertEquals(0, theList.get(1));
		assertEquals(color, theList.get(2));
		assertEquals(color, theList.get(3));
		assertEquals(color, theList.get(4));
	}
}
