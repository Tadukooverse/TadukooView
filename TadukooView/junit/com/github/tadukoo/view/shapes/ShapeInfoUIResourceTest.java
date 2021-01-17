package com.github.tadukoo.view.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
	
	@Test
	public void testEquals(){
		ShapeInfoUIResource resource = new ShapeInfoUIResource(shapeInfo);
		ShapeInfoUIResource resource2 = new ShapeInfoUIResource(shapeInfo.getShapeFunc(), shapeInfo.getShapeInsetsFunc(),
				shapeInfo.getTopLeftDrawFunc(), shapeInfo.getBottomRightDrawFunc());
		assertEquals(resource, resource2);
	}
	
	@Test
	public void testEqualsNotEqualShapeFunc(){
		ShapeInfoUIResource resource = new ShapeInfoUIResource(shapeInfo);
		ShapeInfoUIResource resource2 = new ShapeInfoUIResource(null, shapeInfo.getShapeInsetsFunc(),
				shapeInfo.getTopLeftDrawFunc(), shapeInfo.getBottomRightDrawFunc());
		assertNotEquals(resource, resource2);
	}
	
	@Test
	public void testEqualsNotEqualShapeInsetsFunc(){
		ShapeInfoUIResource resource = new ShapeInfoUIResource(shapeInfo);
		ShapeInfoUIResource resource2 = new ShapeInfoUIResource(shapeInfo.getShapeFunc(), null,
				shapeInfo.getTopLeftDrawFunc(), shapeInfo.getBottomRightDrawFunc());
		assertNotEquals(resource, resource2);
	}
	
	@Test
	public void testEqualsNotEqualTopLeftDrawFunc(){
		ShapeInfoUIResource resource = new ShapeInfoUIResource(shapeInfo);
		ShapeInfoUIResource resource2 = new ShapeInfoUIResource(shapeInfo.getShapeFunc(), shapeInfo.getShapeInsetsFunc(),
				null, shapeInfo.getBottomRightDrawFunc());
		assertNotEquals(resource, resource2);
	}
	
	@Test
	public void testEqualsNotEqualBottomRightDrawFunc(){
		ShapeInfoUIResource resource = new ShapeInfoUIResource(shapeInfo);
		ShapeInfoUIResource resource2 = new ShapeInfoUIResource(shapeInfo.getShapeFunc(), shapeInfo.getShapeInsetsFunc(),
				shapeInfo.getTopLeftDrawFunc(), null);
		assertNotEquals(resource, resource2);
	}
	
	@Test
	public void testEqualsNotShapeUIResource(){
		ShapeInfoUIResource resource = new ShapeInfoUIResource(shapeInfo);
		assertNotEquals(resource, shapeInfo);
	}
}
