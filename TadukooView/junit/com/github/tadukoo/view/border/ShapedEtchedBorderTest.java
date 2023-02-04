package com.github.tadukoo.view.border;

import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.shapes.Shapes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ShapedEtchedBorderTest{
	private ShapedEtchedBorder border;
	
	@BeforeEach
	public void setup(){
		border = ShapedEtchedBorder.builder().build();
	}
	
	/*
	 * Builder Defaults
	 */
	
	@Test
	public void testDefaultShapeInfo(){
		assertNull(border.getShapeInfo());
	}
	
	@Test
	public void testDefaultEtchType(){
		assertEquals(ShapedEtchedBorder.EtchType.LOWERED, border.getEtchType());
	}
	
	@Test
	public void testDefaultHighlightPaint(){
		assertNull(border.getHighlightPaint());
	}
	
	@Test
	public void testDefaultShadowPaint(){
		assertNull(border.getShadowPaint());
	}
	
	/*
	 * Builder Settings
	 */
	
	@Test
	public void testSetShapeInfo(){
		border = ShapedEtchedBorder.builder()
				.shapeInfo(Shapes.CIRCLE.getShapeInfo())
				.build();
		assertEquals(Shapes.CIRCLE.getShapeInfo(), border.getShapeInfo());
	}
	
	@Test
	public void testSetEtchType(){
		border = ShapedEtchedBorder.builder()
				.etchType(ShapedEtchedBorder.EtchType.RAISED)
				.build();
		assertEquals(ShapedEtchedBorder.EtchType.RAISED, border.getEtchType());
	}
	
	@Test
	public void testSetHighlightPaint(){
		border = ShapedEtchedBorder.builder()
				.highlightPaint(new SizableColor(Color.RED))
				.build();
		assertEquals(new SizableColor(Color.RED), border.getHighlightPaint());
	}
	
	@Test
	public void testSetShadowPaint(){
		border = ShapedEtchedBorder.builder()
				.shadowPaint(new SizableColor(Color.BLUE))
				.build();
		assertEquals(new SizableColor(Color.BLUE), border.getShadowPaint());
	}
	
	@Test
	public void testAllSettings(){
		border = ShapedEtchedBorder.builder()
				.shapeInfo(Shapes.CIRCLE.getShapeInfo())
				.etchType(ShapedEtchedBorder.EtchType.RAISED)
				.highlightPaint(new SizableColor(Color.RED))
				.shadowPaint(new SizableColor(Color.BLUE))
				.build();
		assertEquals(Shapes.CIRCLE.getShapeInfo(), border.getShapeInfo());
		assertEquals(ShapedEtchedBorder.EtchType.RAISED, border.getEtchType());
		assertEquals(new SizableColor(Color.RED), border.getHighlightPaint());
		assertEquals(new SizableColor(Color.BLUE), border.getShadowPaint());
	}
	
	/*
	 * Test Equals
	 */
	
	@Test
	public void testEqualsDefault(){
		assertEquals(ShapedEtchedBorder.builder().build(),
				ShapedEtchedBorder.builder().build());
	}
	
	@Test
	public void testEqualsAllSettings(){
		assertEquals(ShapedEtchedBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.etchType(ShapedEtchedBorder.EtchType.RAISED)
						.highlightPaint(new SizableColor(Color.RED))
						.shadowPaint(new SizableColor(Color.BLUE))
						.build(),
				ShapedEtchedBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.etchType(ShapedEtchedBorder.EtchType.RAISED)
						.highlightPaint(new SizableColor(Color.RED))
						.shadowPaint(new SizableColor(Color.BLUE))
						.build());
	}
	
	@Test
	public void testEqualsDifferentShapeInfo(){
		assertNotEquals(ShapedEtchedBorder.builder()
						.shapeInfo(Shapes.RECTANGLE.getShapeInfo())
						.etchType(ShapedEtchedBorder.EtchType.RAISED)
						.highlightPaint(new SizableColor(Color.RED))
						.shadowPaint(new SizableColor(Color.BLUE))
						.build(),
				ShapedEtchedBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.etchType(ShapedEtchedBorder.EtchType.RAISED)
						.highlightPaint(new SizableColor(Color.RED))
						.shadowPaint(new SizableColor(Color.BLUE))
						.build());
	}
	
	@Test
	public void testEqualsDifferentEtchType(){
		assertNotEquals(ShapedEtchedBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.etchType(ShapedEtchedBorder.EtchType.LOWERED)
						.highlightPaint(new SizableColor(Color.RED))
						.shadowPaint(new SizableColor(Color.BLUE))
						.build(),
				ShapedEtchedBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.etchType(ShapedEtchedBorder.EtchType.RAISED)
						.highlightPaint(new SizableColor(Color.RED))
						.shadowPaint(new SizableColor(Color.BLUE))
						.build());
	}
	
	@Test
	public void testEqualsDifferentHighlightPaint(){
		assertNotEquals(ShapedEtchedBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.etchType(ShapedEtchedBorder.EtchType.RAISED)
						.highlightPaint(new SizableColor(Color.YELLOW))
						.shadowPaint(new SizableColor(Color.BLUE))
						.build(),
				ShapedEtchedBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.etchType(ShapedEtchedBorder.EtchType.RAISED)
						.highlightPaint(new SizableColor(Color.RED))
						.shadowPaint(new SizableColor(Color.BLUE))
						.build());
	}
	
	@Test
	public void testEqualsDifferentShadowPaint(){
		assertNotEquals(ShapedEtchedBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.etchType(ShapedEtchedBorder.EtchType.RAISED)
						.highlightPaint(new SizableColor(Color.RED))
						.shadowPaint(new SizableColor(Color.GREEN))
						.build(),
				ShapedEtchedBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.etchType(ShapedEtchedBorder.EtchType.RAISED)
						.highlightPaint(new SizableColor(Color.RED))
						.shadowPaint(new SizableColor(Color.BLUE))
						.build());
	}
	
	@Test
	public void testEqualsDifferentEverything(){
		assertNotEquals(ShapedEtchedBorder.builder()
						.shapeInfo(Shapes.RECTANGLE.getShapeInfo())
						.etchType(ShapedEtchedBorder.EtchType.LOWERED)
						.highlightPaint(new SizableColor(Color.YELLOW))
						.shadowPaint(new SizableColor(Color.GREEN))
						.build(),
				ShapedEtchedBorder.builder()
						.shapeInfo(Shapes.CIRCLE.getShapeInfo())
						.etchType(ShapedEtchedBorder.EtchType.RAISED)
						.highlightPaint(new SizableColor(Color.RED))
						.shadowPaint(new SizableColor(Color.BLUE))
						.build());
	}
	
	@Test
	public void testEqualsDifferentType(){
		//noinspection AssertBetweenInconvertibleTypes
		assertNotEquals(ShapedEtchedBorder.builder().build(), "Test");
	}
}
