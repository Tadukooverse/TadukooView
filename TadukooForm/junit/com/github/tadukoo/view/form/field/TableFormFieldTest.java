package com.github.tadukoo.view.form.field;

import com.github.tadukoo.util.ListUtil;
import com.github.tadukoo.util.LoggerUtil;
import com.github.tadukoo.util.logger.EasyLogger;
import com.github.tadukoo.util.pojo.AbstractOrderedMappedPojo;
import com.github.tadukoo.util.pojo.OrderedMappedPojo;
import com.github.tadukoo.util.pojo.Table;
import com.github.tadukoo.view.border.ShapedLineBorder;
import com.github.tadukoo.view.components.TadukooTable;
import com.github.tadukoo.view.font.FontFamilies;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.paint.SizableColor;
import com.github.tadukoo.view.shapes.Shapes;
import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableFormFieldTest{
	private TableFormField field = TableFormField.builder().build();
	private final Table<OrderedMappedPojo> table = new Table<>();
	
	@Test
	public void testIsTableType(){
		assertEquals(FieldType.TABLE, field.getType());
	}
	
	@Test
	public void testDefaultDefaultValue(){
		assertNull(field.getDefaultValue());
	}
	
	@Test
	public void testDefaultLabelType(){
		assertEquals(LabelType.NONE, field.getLabelType());
	}
	
	@Test
	public void testDefaultLabelForegroundPaint(){
		assertNull(field.getLabelForegroundPaint());
	}
	
	@Test
	public void testDefaultLabelBackgroundPaint(){
		assertNull(field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testDefaultLabelFontFamily(){
		assertNull(field.getLabelFontFamily());
	}
	
	@Test
	public void testDefaultLabelFontStyle(){
		assertEquals(-1, field.getLabelFontStyle());
	}
	
	@Test
	public void testDefaultLabelFontSize(){
		assertEquals(-1, field.getLabelFontSize());
	}
	
	@Test
	public void testDefaultLabelShape(){
		assertNull(field.getLabelShape());
	}
	
	@Test
	public void testDefaultLabelBorder(){
		assertNull(field.getLabelBorder());
	}
	
	@Test
	public void testDefaultRowSpan(){
		assertEquals(1, field.getRowSpan());
	}
	
	@Test
	public void testDefaultColSpan(){
		assertEquals(1, field.getColSpan());
	}
	
	@Test
	public void testDefaultLogFontResourceLoaderWarnings(){
		assertFalse(field.logFontResourceLoaderWarnings());
	}
	
	@Test
	public void testDefaultLogger(){
		assertNull(field.getLogger());
	}
	
	@Test
	public void testDefaultGraphEnv(){
		assertEquals(GraphicsEnvironment.getLocalGraphicsEnvironment(), field.getGraphEnv());
	}
	
	@Test
	public void testDefaultFontFolder(){
		assertEquals("fonts/", field.getFontFolder());
	}
	
	@Test
	public void testDefaultFontResourceLoader(){
		assertNull(field.getFontResourceLoader());
	}
	
	@Test
	public void testSetKey(){
		field = TableFormField.builder().key("Test").build();
		assertEquals("Test", field.getKey());
	}
	
	@Test
	public void testSetDefaultValue(){
		field = TableFormField.builder().defaultValue(table).build();
		assertEquals(table, field.getDefaultValue());
	}
	
	@Test
	public void testSetLabelType(){
		field = TableFormField.builder().labelType(LabelType.LABEL).build();
		assertEquals(LabelType.LABEL, field.getLabelType());
	}
	
	@Test
	public void testSetLabelForegroundPaint(){
		SizableColor red = new SizableColor(Color.RED);
		field = TableFormField.builder().labelForegroundPaint(red).build();
		assertEquals(red, field.getLabelForegroundPaint());
	}
	
	@Test
	public void testSetLabelBackgroundPaint(){
		SizableColor blue = new SizableColor(Color.BLUE);
		field = TableFormField.builder().labelBackgroundPaint(blue).build();
		assertEquals(blue, field.getLabelBackgroundPaint());
	}
	
	@Test
	public void testSetLabelFont(){
		field = TableFormField.builder().labelFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 27).build();
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getLabelFontFamily());
		assertEquals(Font.BOLD, field.getLabelFontStyle());
		assertEquals(27, field.getLabelFontSize());
	}
	
	@Test
	public void testSetLabelShape(){
		field = TableFormField.builder().labelShape(Shapes.CIRCLE.getShapeInfo()).build();
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getLabelShape());
	}
	
	@Test
	public void testSetLabelBorder(){
		Border labelBorder = ShapedLineBorder.builder().build();
		field = TableFormField.builder().labelBorder(labelBorder).build();
		assertEquals(labelBorder, field.getLabelBorder());
	}
	
	@Test
	public void testSetRowPos(){
		field = TableFormField.builder().rowPos(2).build();
		assertEquals(2, field.getRowPos());
	}
	
	@Test
	public void testSetColPos(){
		field = TableFormField.builder().colPos(5).build();
		assertEquals(5, field.getColPos());
	}
	
	@Test
	public void testSetRowSpan(){
		field = TableFormField.builder().rowSpan(3).build();
		assertEquals(3, field.getRowSpan());
	}
	
	@Test
	public void testSetColSpan(){
		field = TableFormField.builder().colSpan(7).build();
		assertEquals(7, field.getColSpan());
	}
	
	@Test
	public void testSetLogFontResourceLoaderWarnings(){
		field = TableFormField.builder()
				.logFontResourceLoaderWarnings(true).build();
		assertTrue(field.logFontResourceLoaderWarnings());
	}
	
	@Test
	public void testSetLogger() throws IOException{
		EasyLogger logger = new EasyLogger(LoggerUtil.createFileLogger("target/garbo/test.log", Level.OFF));
		field = TableFormField.builder()
				.logger(logger).build();
		assertEquals(logger, field.getLogger());
	}
	
	@Test
	public void testSetGraphEnv(){
		field = TableFormField.builder()
				.graphEnv(null).build();
		assertNull(field.getGraphEnv());
	}
	
	@Test
	public void testSetFontFolder(){
		field = TableFormField.builder()
				.fontFolder("testing/").build();
		assertEquals("testing/", field.getFontFolder());
	}
	
	@Test
	public void testSetFontResourceLoader(){
		FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
				null, "fonts/");
		field = TableFormField.builder()
				.fontResourceLoader(fontResourceLoader).build();
		assertEquals(fontResourceLoader, field.getFontResourceLoader());
	}
	
	@Test
	public void testAllSettings() throws IOException{
		SizableColor red = new SizableColor(Color.RED);
		SizableColor blue = new SizableColor(Color.BLUE);
		Border labelBorder = ShapedLineBorder.builder().build();
		EasyLogger logger = new EasyLogger(LoggerUtil.createFileLogger("target/garbo/test.log", Level.OFF));
		FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
				null, "fonts/");
		field = TableFormField.builder().key("Test").defaultValue(table)
				.labelType(LabelType.LABEL).labelForegroundPaint(red).labelBackgroundPaint(blue)
				.labelFont(FontFamilies.DIALOG.getFamily(), Font.BOLD, 27)
				.labelShape(Shapes.CIRCLE.getShapeInfo()).labelBorder(labelBorder)
				.rowPos(2).colPos(5).rowSpan(3).colSpan(7)
				.logFontResourceLoaderWarnings(true).logger(logger).graphEnv(null).fontFolder("testing/")
				.fontResourceLoader(fontResourceLoader)
				.build();
		assertEquals("Test", field.getKey());
		assertEquals(table, field.getDefaultValue());
		assertEquals(LabelType.LABEL, field.getLabelType());
		assertEquals(red, field.getLabelForegroundPaint());
		assertEquals(blue, field.getLabelBackgroundPaint());
		assertEquals(FontFamilies.DIALOG.getFamily(), field.getLabelFontFamily());
		assertEquals(Font.BOLD, field.getLabelFontStyle());
		assertEquals(27, field.getLabelFontSize());
		assertEquals(Shapes.CIRCLE.getShapeInfo(), field.getLabelShape());
		assertEquals(labelBorder, field.getLabelBorder());
		assertEquals(2, field.getRowPos());
		assertEquals(5, field.getColPos());
		assertEquals(3, field.getRowSpan());
		assertEquals(7, field.getColSpan());
		assertTrue(field.logFontResourceLoaderWarnings());
		assertEquals(logger, field.getLogger());
		assertNull(field.getGraphEnv());
		assertEquals("testing/", field.getFontFolder());
		assertEquals(fontResourceLoader, field.getFontResourceLoader());
	}
	
	@Test
	public void testGetComponent(){
		field = TableFormField.builder().defaultValue(table).build();
		JComponent component = field.getComponent();
		assertTrue(component instanceof TadukooTable);
		assertEquals(0, ((TadukooTable) component).getTable().getRowCount());
	}
	
	@Test
	public void testGetValueBadComponent(){
		assertNull(field.getValue(new JLabel("Test")));
	}
	
	@Test
	public void testGetValue(){
		TadukooTable table2 = TadukooTable.builder().keyOrder(ListUtil.createList("Derp", "Test")).build();
		OrderedMappedPojo pojo = new AbstractOrderedMappedPojo(){
			@Override
			public List<String> getKeyOrder(){
				return ListUtil.createList("Derp", "Test");
			}
		};
		pojo.setItem("Derp", 5);
		pojo.setItem("Test", "Yep");
		table2.addRow(pojo);
		
		Table<OrderedMappedPojo> result = field.getValue(table2);
		assertEquals(1, result.getNumRows());
		OrderedMappedPojo resultPojo = result.getRow(0);
		assertEquals(5, resultPojo.getItem("Derp"));
		assertEquals("Yep", resultPojo.getItem("Test"));
	}
}
