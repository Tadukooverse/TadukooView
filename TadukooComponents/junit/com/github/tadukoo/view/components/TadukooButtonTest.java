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
import java.awt.event.ActionListener;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TadukooButtonTest{
	private String text = "Some Text";
	private final Icon icon = new ImageIcon("");
	private final ActionListener actionListener = e -> text = "Some Other Text";
	private final SizableColor foregroundPaint = new SizableColor(Color.ORANGE);
	private final SizableColor backgroundPaint = new SizableColor(Color.PINK);
	private final SizableColor selectPaint = new SizableColor(Color.BLACK);
	private final SizableColor focusPaint = new SizableColor(Color.YELLOW);
	private final SizableColor disabledTextPaint = new SizableColor(Color.GRAY);
	private final FontFamily fontFamily = FontFamilies.DIALOG.getFamily();
	private final int fontStyle = Font.BOLD;
	private final int fontSize = 12;
	private final ShapeInfo shapeInfo = Shapes.ELLIPSE.getShapeInfo();
	private final Border border = ShapedLineBorder.builder().build();
	
	private TadukooButton button;
	
	@BeforeEach
	public void setup() throws IOException, FontFormatException{
		button = TadukooButton.builder()
				.text(text).icon(icon)
				.actionListener(actionListener)
				.foregroundPaint(foregroundPaint).backgroundPaint(backgroundPaint)
				.selectPaint(selectPaint).focusPaint(focusPaint).disabledTextPaint(disabledTextPaint)
				.font(fontFamily, fontStyle, fontSize)
				.shapeInfo(shapeInfo)
				.border(border)
				.build();
	}
	
	@Test
	public void testBuilderNoValues() throws IOException, FontFormatException{
		TadukooButton simpleButton = TadukooButton.builder().build();
		assertNotNull(simpleButton);
		assertEquals("", simpleButton.getText());
		assertNull(simpleButton.getIcon());
		assertEquals(0, simpleButton.getActionListeners().length);
		assertTrue(simpleButton.getForegroundPaint() instanceof UIResource ||
				simpleButton.getForegroundPaint() == null);
		assertTrue(simpleButton.getBackgroundPaint() instanceof UIResource ||
				simpleButton.getBackgroundPaint() == null);
		assertTrue(simpleButton.getSelectPaint() instanceof UIResource ||
				simpleButton.getSelectPaint() == null);
		assertTrue(simpleButton.getFocusPaint() instanceof UIResource ||
				simpleButton.getFocusPaint() == null);
		assertTrue(simpleButton.getDisabledTextPaint() instanceof UIResource ||
				simpleButton.getDisabledTextPaint() == null);
		assertTrue(simpleButton.getFont() instanceof UIResource || simpleButton.getFont() == null);
		assertNull(simpleButton.getShapeInfo());
		assertTrue(simpleButton.getBorder() instanceof UIResource || simpleButton.getBorder() == null);
	}
	
	@Test
	public void testBuilderText(){
		assertEquals(text, button.getText());
	}
	
	@Test
	public void testBuilderIcon(){
		assertEquals(icon, button.getIcon());
	}
	
	@Test
	public void testBuilderActionListener(){
		assertEquals(actionListener, button.getActionListeners()[0]);
	}
	
	@Test
	public void testBuilderForegroundPaint(){
		assertEquals(foregroundPaint, button.getForegroundPaint());
	}
	
	@Test
	public void testBuilderBackgroundPaint(){
		assertEquals(backgroundPaint, button.getBackgroundPaint());
	}
	
	@Test
	public void testBuilderSelectPaint(){
		assertEquals(selectPaint, button.getSelectPaint());
	}
	
	@Test
	public void testBuilderFocusPaint(){
		assertEquals(focusPaint, button.getFocusPaint());
	}
	
	@Test
	public void testBuilderDisabledTextPaint(){
		assertEquals(disabledTextPaint, button.getDisabledTextPaint());
	}
	
	@Test
	public void testBuilderFont(){
		Font font = button.getFont();
		assertEquals(fontFamily.getName(), font.getName());
		assertEquals(fontStyle, font.getStyle());
		assertEquals(fontSize, font.getSize());
	}
	
	@Test
	public void testBuilderShapeInfo(){
		assertEquals(shapeInfo, button.getShapeInfo());
	}
	
	@Test
	public void testBuilderBorder(){
		assertEquals(border, button.getBorder());
	}
	
	@Test
	public void testSetForegroundPaint(){
		assertEquals(foregroundPaint, button.getForegroundPaint());
		SizableColor newPaint = new SizableColor(Color.DARK_GRAY);
		button.setForegroundPaint(newPaint);
		assertEquals(newPaint, button.getForegroundPaint());
	}
	
	@Test
	public void testSetBackgroundPaint(){
		assertEquals(backgroundPaint, button.getBackgroundPaint());
		SizableColor newPaint = new SizableColor(Color.DARK_GRAY);
		button.setBackgroundPaint(newPaint);
		assertEquals(newPaint, button.getBackgroundPaint());
	}
	
	@Test
	public void testSetSelectPaint(){
		assertEquals(selectPaint, button.getSelectPaint());
		SizableColor newPaint = new SizableColor(Color.RED);
		button.setSelectPaint(newPaint);
		assertEquals(newPaint, button.getSelectPaint());
	}
	
	@Test
	public void testSetFocusPaint(){
		assertEquals(focusPaint, button.getFocusPaint());
		SizableColor newPaint = new SizableColor(Color.RED);
		button.setFocusPaint(newPaint);
		assertEquals(newPaint, button.getFocusPaint());
	}
	
	@Test
	public void testSetDisabledTextPaint(){
		assertEquals(disabledTextPaint, button.getDisabledTextPaint());
		SizableColor newPaint = new SizableColor(Color.YELLOW);
		button.setDisabledTextPaint(newPaint);
		assertEquals(newPaint, button.getDisabledTextPaint());
	}
	
	@Test
	public void testSetShapeInfo(){
		assertEquals(shapeInfo, button.getShapeInfo());
		ShapeInfo newInfo = Shapes.ROUND_RECTANGLE.getShapeInfo();
		button.setShapeInfo(newInfo);
		assertEquals(newInfo, button.getShapeInfo());
	}
}
