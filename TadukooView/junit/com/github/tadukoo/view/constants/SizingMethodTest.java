package com.github.tadukoo.view.constants;

import org.junit.jupiter.api.Test;

import static com.github.tadukoo.util.junit.enums.EnumTest.assertFromStringBad;
import static com.github.tadukoo.util.junit.enums.EnumTest.assertToFromString;

public class SizingMethodTest{
	
	@Test
	public void testFromStringBad(){
		assertFromStringBad(SizingMethod::fromMethod);
	}
	
	@Test
	public void testToFromStringDEFAULT_JAVA(){
		assertToFromString(SizingMethod.DEFAULT_JAVA, "Default Java", SizingMethod::fromMethod);
	}
	
	@Test
	public void testToFromStringDEFAULT_THEME(){
		assertToFromString(SizingMethod.DEFAULT_THEME, "Default Theme", SizingMethod::fromMethod);
	}
	
	@Test
	public void testToFromStringBY_DATA(){
		assertToFromString(SizingMethod.BY_DATA, "By Data", SizingMethod::fromMethod);
	}
	
	@Test
	public void testToFromStringSPECIFY_DATA(){
		assertToFromString(SizingMethod.SPECIFY_DATA, "Specify Data", SizingMethod::fromMethod);
	}
	
	@Test
	public void testToFromStringSPECIFY_EXACT(){
		assertToFromString(SizingMethod.SPECIFY_EXACT, "Specify Exact", SizingMethod::fromMethod);
	}
}
