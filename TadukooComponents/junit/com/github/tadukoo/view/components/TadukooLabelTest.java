package com.github.tadukoo.view.components;

import com.github.tadukoo.view.border.ShapedLineBorder;
import com.github.tadukoo.view.font.FontFamilies;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.shapes.ShapeInfo;
import com.github.tadukoo.view.shapes.Shapes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TadukooLabelTest{
	private final String text = "Some Text";
	private final Icon icon = new ImageIcon("");
	private final SizableColor foregroundPaint = new SizableColor(Color.ORANGE);
	private final SizableColor backgroundPaint = new SizableColor(Color.PINK);
	private final SizableColor disabledForegroundPaint = new SizableColor(Color.GRAY);
	private final FontFamily fontFamily = FontFamilies.DIALOG.getFamily();
	private final int fontStyle = Font.BOLD;
	private final int fontSize = 12;
	private final ShapeInfo shapeInfo = Shapes.ELLIPSE.getShapeInfo();
	private final Border border = ShapedLineBorder.builder().build();
	
	private TadukooLabel label;
	
	@BeforeEach
	public void setup() throws IOException, FontFormatException{
		label = TadukooLabel.builder()
				.text(text).icon(icon)
				.foregroundPaint(foregroundPaint).backgroundPaint(backgroundPaint)
				.disabledForegroundPaint(disabledForegroundPaint)
				.font(fontFamily, fontStyle, fontSize)
				.shapeInfo(shapeInfo)
				.border(border)
				.build();
	}
	
	@Test
	public void testBuilderNoValues() throws IOException, FontFormatException{
		TadukooLabel simpleLabel = TadukooLabel.builder().build();
		assertNotNull(simpleLabel);
		assertNull(simpleLabel.getText());
		assertNull(simpleLabel.getIcon());
		assertTrue(simpleLabel.getForegroundPaint() instanceof UIResource ||
				simpleLabel.getForegroundPaint() == null);
		assertTrue(simpleLabel.getBackgroundPaint() instanceof UIResource ||
				simpleLabel.getBackgroundPaint() == null);
		assertTrue(simpleLabel.getDisabledForegroundPaint() instanceof UIResource ||
				simpleLabel.getDisabledForegroundPaint() == null);
		assertTrue(simpleLabel.getFont() instanceof UIResource || simpleLabel.getFont() == null);
		assertNull(simpleLabel.getShapeInfo());
		assertTrue(simpleLabel.getBorder() instanceof UIResource || simpleLabel.getBorder() == null);
	}
	
	@Test
	public void testBuilderText(){
		assertEquals(text, label.getText());
	}
	
	@Test
	public void testBuilderIcon(){
		assertEquals(icon, label.getIcon());
	}
	
	@Test
	public void testBuilderForegroundPaint(){
		assertEquals(foregroundPaint, label.getForegroundPaint());
	}
	
	@Test
	public void testBuilderBackgroundPaint(){
		assertEquals(backgroundPaint, label.getBackgroundPaint());
	}
	
	@Test
	public void testBuilderDisabledForegroundPaint(){
		assertEquals(disabledForegroundPaint, label.getDisabledForegroundPaint());
	}
	
	@Test
	public void testBuilderFont(){
		Font font = label.getFont();
		assertEquals(fontFamily.getName(), font.getName());
		assertEquals(fontStyle, font.getStyle());
		assertEquals(fontSize, font.getSize());
	}
	
	@Test
	public void testBuilderShapeInfo(){
		assertEquals(shapeInfo, label.getShapeInfo());
	}
	
	@Test
	public void testBuilderBorder(){
		assertEquals(border, label.getBorder());
	}
	
	@Test
	public void testSetForegroundPaint(){
		assertEquals(foregroundPaint, label.getForegroundPaint());
		SizableColor newPaint = new SizableColor(Color.DARK_GRAY);
		label.setForegroundPaint(newPaint);
		assertEquals(newPaint, label.getForegroundPaint());
	}
	
	@Test
	public void testSetBackgroundPaint(){
		assertEquals(backgroundPaint, label.getBackgroundPaint());
		SizableColor newPaint = new SizableColor(Color.DARK_GRAY);
		label.setBackgroundPaint(newPaint);
		assertEquals(newPaint, label.getBackgroundPaint());
	}
	
	@Test
	public void testSetDisabledForegroundPaint(){
		assertEquals(disabledForegroundPaint, label.getDisabledForegroundPaint());
		SizableColor newPaint = new SizableColor(Color.YELLOW);
		label.setDisabledForegroundPaint(newPaint);
		assertEquals(newPaint, label.getDisabledForegroundPaint());
	}
	
	@Test
	public void testSetShapeInfo(){
		assertEquals(shapeInfo, label.getShapeInfo());
		ShapeInfo newInfo = Shapes.ROUND_RECTANGLE.getShapeInfo();
		label.setShapeInfo(newInfo);
		assertEquals(newInfo, label.getShapeInfo());
	}
}
