package com.github.tadukoo.view.border;

import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.shapes.Shapes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ShapedLineBorderTest{
	private ShapedLineBorder border;
	
	@BeforeEach
	public void setup(){
		border = ShapedLineBorder.builder().build();
	}
	
	/*
	 * Builder Defaults
	 */
	
	@Test
	public void testDefaultShapeInfo(){
		assertNull(border.getShapeInfo());
	}
	
	@Test
	public void testDefaultPaint(){
		assertEquals(new SizableColor(Color.BLACK), border.getPaint());
	}
	
	@Test
	public void testDefaultThickness(){
		assertEquals(1, border.getThickness());
	}
	
	/*
	 * Builder Settings
	 */
	
	@Test
	public void testSetShapeInfo(){
		border = ShapedLineBorder.builder()
				.shapeInfo(Shapes.CIRCLE.getShapeInfo())
				.build();
		assertEquals(Shapes.CIRCLE.getShapeInfo(), border.getShapeInfo());
	}
	
	@Test
	public void testSetPaint(){
		border = ShapedLineBorder.builder()
				.paint(new SizableColor(Color.RED))
				.build();
		assertEquals(new SizableColor(Color.RED), border.getPaint());
	}
	
	@Test
	public void testSetThickness(){
		border = ShapedLineBorder.builder()
				.thickness(5)
				.build();
		assertEquals(5, border.getThickness());
	}
	
	@Test
	public void testSetAll(){
		border = ShapedLineBorder.builder()
				.shapeInfo(Shapes.CIRCLE.getShapeInfo())
				.paint(new SizableColor(Color.RED))
				.thickness(5)
				.build();
		assertEquals(Shapes.CIRCLE.getShapeInfo(), border.getShapeInfo());
		assertEquals(new SizableColor(Color.RED), border.getPaint());
		assertEquals(5, border.getThickness());
	}
	
	/*
	 * Test Equals
	 */
	
	@Test
	public void testEqualsDefault(){
		assertEquals(ShapedLineBorder.builder().build(),
				ShapedLineBorder.builder().build());
	}
	
	@Test
	public void testEqualsAllSettings(){
		assertEquals(ShapedLineBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.paint(new SizableColor(Color.RED))
						.thickness(5)
						.build(),
				ShapedLineBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.paint(new SizableColor(Color.RED))
						.thickness(5)
						.build());
	}
	
	@Test
	public void testEqualsDifferentShape(){
		assertNotEquals(ShapedLineBorder.builder()
						.shapeInfo(Shapes.RECTANGLE.getShapeInfo())
						.paint(new SizableColor(Color.RED))
						.thickness(5)
						.build(),
				ShapedLineBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.paint(new SizableColor(Color.RED))
						.thickness(5)
						.build());
	}
	
	@Test
	public void testEqualsDifferentPaint(){
		assertNotEquals(ShapedLineBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.paint(new SizableColor(Color.BLUE))
						.thickness(5)
						.build(),
				ShapedLineBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.paint(new SizableColor(Color.RED))
						.thickness(5)
						.build());
	}
	
	@Test
	public void testEqualsDifferentThickness(){
		assertNotEquals(ShapedLineBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.paint(new SizableColor(Color.RED))
						.thickness(10)
						.build(),
				ShapedLineBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.paint(new SizableColor(Color.RED))
						.thickness(5)
						.build());
	}
	
	@Test
	public void testEqualsDifferentEverything(){
		assertNotEquals(ShapedLineBorder.builder()
						.shapeInfo(Shapes.RECTANGLE.getShapeInfo())
						.paint(new SizableColor(Color.BLUE))
						.thickness(10)
						.build(),
				ShapedLineBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.paint(new SizableColor(Color.RED))
						.thickness(5)
						.build());
	}
	
	@Test
	public void testEqualsNotShapedLineBorder(){
		//noinspection AssertBetweenInconvertibleTypes
		assertNotEquals(ShapedLineBorder.builder().build(), "Test");
	}
}
