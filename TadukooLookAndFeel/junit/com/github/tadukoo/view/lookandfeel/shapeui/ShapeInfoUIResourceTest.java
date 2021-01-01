package com.github.tadukoo.view.lookandfeel.shapeui;

import com.github.tadukoo.view.shapes.ShapeInfo;
import com.github.tadukoo.view.shapes.Shapes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeInfoUIResourceTest{
	private final ShapeInfo shapeInfo = Shapes.RECTANGLE_WITH_CUT_CORNERS_TL_BR.getShapeInfo();
	
	@Test
	public void testShapeInfoConstructor(){
		ShapeInfoUIResource resource = new ShapeInfoUIResource(shapeInfo);
		assertEquals(shapeInfo.getShapeFunc(), resource.getShapeFunc());
		assertEquals(shapeInfo.getShapeInsetsFunc(), resource.getShapeInsetsFunc());
		assertEquals(shapeInfo.getTopLeftDrawFunc(), resource.getTopLeftDrawFunc());
		assertEquals(shapeInfo.getBottomRightDrawFunc(), resource.getBottomRightDrawFunc());
	}
	
	@Test
	public void testFunctionsConstructor(){
		ShapeInfoUIResource resource = new ShapeInfoUIResource(shapeInfo.getShapeFunc(), shapeInfo.getShapeInsetsFunc(),
				shapeInfo.getTopLeftDrawFunc(), shapeInfo.getBottomRightDrawFunc());
		assertEquals(shapeInfo.getShapeFunc(), resource.getShapeFunc());
		assertEquals(shapeInfo.getShapeInsetsFunc(), resource.getShapeInsetsFunc());
		assertEquals(shapeInfo.getTopLeftDrawFunc(), resource.getTopLeftDrawFunc());
		assertEquals(shapeInfo.getBottomRightDrawFunc(), resource.getBottomRightDrawFunc());
	}
}
