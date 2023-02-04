package com.github.tadukoo.view.border;

import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.shapes.Shapes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ShapedBevelBorderTest{
	private ShapedBevelBorder border;
	
	@BeforeEach
	public void setup(){
		border = ShapedBevelBorder.builder().build();
	}
	
	/*
	 * Builder Defaults
	 */
	
	@Test
	public void testDefaultShapeInfo(){
		assertNull(border.getShapeInfo());
	}
	
	@Test
	public void testDefaultBevelType(){
		assertEquals(ShapedBevelBorder.BevelType.LOWERED, border.getBevelType());
	}
	
	@Test
	public void testDefaultHighlightInnerPaint(){
		assertNull(border.getHighlightInnerPaint());
	}
	
	@Test
	public void testDefaultHighlightOuterPaint(){
		assertNull(border.getHighlightOuterPaint());
	}
	
	@Test
	public void testDefaultShadowInnerPaint(){
		assertNull(border.getShadowInnerPaint());
	}
	
	@Test
	public void testDefaultShadowOuterPaint(){
		assertNull(border.getShadowOuterPaint());
	}
	
	/*
	 * Builder Settings
	 */
	
	@Test
	public void testSetShapeInfo(){
		border = ShapedBevelBorder.builder()
				.shapeInfo(Shapes.CIRCLE.getShapeInfo())
				.build();
		assertEquals(Shapes.CIRCLE.getShapeInfo(), border.getShapeInfo());
	}
	
	@Test
	public void testSetBevelType(){
		border = ShapedBevelBorder.builder()
				.bevelType(ShapedBevelBorder.BevelType.RAISED)
				.build();
		assertEquals(ShapedBevelBorder.BevelType.RAISED, border.getBevelType());
	}
	
	@Test
	public void testSetHighlightInnerPaint(){
		border = ShapedBevelBorder.builder()
				.highlightInnerPaint(new SizableColor(Color.RED))
				.build();
		assertEquals(new SizableColor(Color.RED), border.getHighlightInnerPaint());
	}
	
	@Test
	public void testSetHighlightOuterPaint(){
		border = ShapedBevelBorder.builder()
				.highlightOuterPaint(new SizableColor(Color.BLUE))
				.build();
		assertEquals(new SizableColor(Color.BLUE), border.getHighlightOuterPaint());
	}
	
	@Test
	public void testSetShadowInnerPaint(){
		border = ShapedBevelBorder.builder()
				.shadowInnerPaint(new SizableColor(Color.YELLOW))
				.build();
		assertEquals(new SizableColor(Color.YELLOW), border.getShadowInnerPaint());
	}
	
	@Test
	public void testSetShadowOuterPaint(){
		border = ShapedBevelBorder.builder()
				.shadowOuterPaint(new SizableColor(Color.GREEN))
				.build();
		assertEquals(new SizableColor(Color.GREEN), border.getShadowOuterPaint());
	}
	
	@Test
	public void testAllSettings(){
		border = ShapedBevelBorder.builder()
				.shapeInfo(Shapes.CIRCLE.getShapeInfo())
				.bevelType(ShapedBevelBorder.BevelType.RAISED)
				.highlightInnerPaint(new SizableColor(Color.RED))
				.highlightOuterPaint(new SizableColor(Color.BLUE))
				.shadowInnerPaint(new SizableColor(Color.YELLOW))
				.shadowOuterPaint(new SizableColor(Color.GREEN))
				.build();
		assertEquals(Shapes.CIRCLE.getShapeInfo(), border.getShapeInfo());
		assertEquals(ShapedBevelBorder.BevelType.RAISED, border.getBevelType());
		assertEquals(new SizableColor(Color.RED), border.getHighlightInnerPaint());
		assertEquals(new SizableColor(Color.BLUE), border.getHighlightOuterPaint());
		assertEquals(new SizableColor(Color.YELLOW), border.getShadowInnerPaint());
		assertEquals(new SizableColor(Color.GREEN), border.getShadowOuterPaint());
	}
	
	/*
	 * Test Equals
	 */
	
	@Test
	public void testEqualsDefault(){
		assertEquals(ShapedBevelBorder.builder().build(),
				ShapedBevelBorder.builder().build());
	}
	
	@Test
	public void testEqualsAllSettings(){
		assertEquals(ShapedBevelBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.RAISED)
						.highlightInnerPaint(new SizableColor(Color.RED))
						.highlightOuterPaint(new SizableColor(Color.BLUE))
						.shadowInnerPaint(new SizableColor(Color.YELLOW))
						.shadowOuterPaint(new SizableColor(Color.GREEN))
						.build(),
				ShapedBevelBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.RAISED)
						.highlightInnerPaint(new SizableColor(Color.RED))
						.highlightOuterPaint(new SizableColor(Color.BLUE))
						.shadowInnerPaint(new SizableColor(Color.YELLOW))
						.shadowOuterPaint(new SizableColor(Color.GREEN))
						.build());
	}
	
	@Test
	public void testEqualsDifferentShapeInfo(){
		assertNotEquals(ShapedBevelBorder.builder()
						.shapeInfo(Shapes.RECTANGLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.RAISED)
						.highlightInnerPaint(new SizableColor(Color.RED))
						.highlightOuterPaint(new SizableColor(Color.BLUE))
						.shadowInnerPaint(new SizableColor(Color.YELLOW))
						.shadowOuterPaint(new SizableColor(Color.GREEN))
						.build(),
				ShapedBevelBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.RAISED)
						.highlightInnerPaint(new SizableColor(Color.RED))
						.highlightOuterPaint(new SizableColor(Color.BLUE))
						.shadowInnerPaint(new SizableColor(Color.YELLOW))
						.shadowOuterPaint(new SizableColor(Color.GREEN))
						.build());
	}
	
	@Test
	public void testEqualsDifferentBevelType(){
		assertNotEquals(ShapedBevelBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.LOWERED)
						.highlightInnerPaint(new SizableColor(Color.RED))
						.highlightOuterPaint(new SizableColor(Color.BLUE))
						.shadowInnerPaint(new SizableColor(Color.YELLOW))
						.shadowOuterPaint(new SizableColor(Color.GREEN))
						.build(),
				ShapedBevelBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.RAISED)
						.highlightInnerPaint(new SizableColor(Color.RED))
						.highlightOuterPaint(new SizableColor(Color.BLUE))
						.shadowInnerPaint(new SizableColor(Color.YELLOW))
						.shadowOuterPaint(new SizableColor(Color.GREEN))
						.build());
	}
	
	@Test
	public void testEqualsDifferentHighlightInnerPaint(){
		assertNotEquals(ShapedBevelBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.RAISED)
						.highlightInnerPaint(new SizableColor(Color.ORANGE))
						.highlightOuterPaint(new SizableColor(Color.BLUE))
						.shadowInnerPaint(new SizableColor(Color.YELLOW))
						.shadowOuterPaint(new SizableColor(Color.GREEN))
						.build(),
				ShapedBevelBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.RAISED)
						.highlightInnerPaint(new SizableColor(Color.RED))
						.highlightOuterPaint(new SizableColor(Color.BLUE))
						.shadowInnerPaint(new SizableColor(Color.YELLOW))
						.shadowOuterPaint(new SizableColor(Color.GREEN))
						.build());
	}
	
	@Test
	public void testEqualsDifferentHighlightOuterPaint(){
		assertNotEquals(ShapedBevelBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.RAISED)
						.highlightInnerPaint(new SizableColor(Color.RED))
						.highlightOuterPaint(new SizableColor(Color.CYAN))
						.shadowInnerPaint(new SizableColor(Color.YELLOW))
						.shadowOuterPaint(new SizableColor(Color.GREEN))
						.build(),
				ShapedBevelBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.RAISED)
						.highlightInnerPaint(new SizableColor(Color.RED))
						.highlightOuterPaint(new SizableColor(Color.BLUE))
						.shadowInnerPaint(new SizableColor(Color.YELLOW))
						.shadowOuterPaint(new SizableColor(Color.GREEN))
						.build());
	}
	
	@Test
	public void testEqualsDifferentShadowInnerPaint(){
		assertNotEquals(ShapedBevelBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.RAISED)
						.highlightInnerPaint(new SizableColor(Color.RED))
						.highlightOuterPaint(new SizableColor(Color.BLUE))
						.shadowInnerPaint(new SizableColor(Color.MAGENTA))
						.shadowOuterPaint(new SizableColor(Color.GREEN))
						.build(),
				ShapedBevelBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.RAISED)
						.highlightInnerPaint(new SizableColor(Color.RED))
						.highlightOuterPaint(new SizableColor(Color.BLUE))
						.shadowInnerPaint(new SizableColor(Color.YELLOW))
						.shadowOuterPaint(new SizableColor(Color.GREEN))
						.build());
	}
	
	@Test
	public void testEqualsDifferentShadowOuterPaint(){
		assertNotEquals(ShapedBevelBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.RAISED)
						.highlightInnerPaint(new SizableColor(Color.RED))
						.highlightOuterPaint(new SizableColor(Color.BLUE))
						.shadowInnerPaint(new SizableColor(Color.YELLOW))
						.shadowOuterPaint(new SizableColor(Color.PINK))
						.build(),
				ShapedBevelBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.RAISED)
						.highlightInnerPaint(new SizableColor(Color.RED))
						.highlightOuterPaint(new SizableColor(Color.BLUE))
						.shadowInnerPaint(new SizableColor(Color.YELLOW))
						.shadowOuterPaint(new SizableColor(Color.GREEN))
						.build());
	}
	
	@Test
	public void testEqualsDifferentEverything(){
		assertNotEquals(ShapedBevelBorder.builder()
						.shapeInfo(Shapes.RECTANGLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.LOWERED)
						.highlightInnerPaint(new SizableColor(Color.ORANGE))
						.highlightOuterPaint(new SizableColor(Color.CYAN))
						.shadowInnerPaint(new SizableColor(Color.MAGENTA))
						.shadowOuterPaint(new SizableColor(Color.PINK))
						.build(),
				ShapedBevelBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.bevelType(ShapedBevelBorder.BevelType.RAISED)
						.highlightInnerPaint(new SizableColor(Color.RED))
						.highlightOuterPaint(new SizableColor(Color.BLUE))
						.shadowInnerPaint(new SizableColor(Color.YELLOW))
						.shadowOuterPaint(new SizableColor(Color.GREEN))
						.build());
	}
	
	@Test
	public void testEqualsDifferentType(){
		//noinspection AssertBetweenInconvertibleTypes
		assertNotEquals(ShapedBevelBorder.builder().build(), "Test");
	}
}
