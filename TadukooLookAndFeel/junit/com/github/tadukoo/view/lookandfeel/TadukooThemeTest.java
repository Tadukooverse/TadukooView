package com.github.tadukoo.view.lookandfeel;

import com.github.tadukoo.view.border.ShapedEtchedBorder;
import com.github.tadukoo.view.font.FontFamilies;
import com.github.tadukoo.view.font.FontFamily;
import com.github.tadukoo.view.font.FontResourceLoader;
import com.github.tadukoo.view.lookandfeel.componentui.TadukooButtonUI;
import com.github.tadukoo.view.lookandfeel.paintui.ColorPaintUIResource;
import com.github.tadukoo.view.lookandfeel.paintui.PaintUIResource;
import com.github.tadukoo.view.shapes.ShapeInfo;
import com.github.tadukoo.view.shapes.Shapes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TadukooThemeTest{
	private TadukooTheme defaultTheme;
	private final PaintUIResource defaultForegroundPaint = new ColorPaintUIResource(Color.BLACK);
	private final PaintUIResource defaultBackgroundPaint = new ColorPaintUIResource(Color.WHITE);
	private final PaintUIResource defaultFocusPaint = new ColorPaintUIResource(Color.YELLOW);
	private final PaintUIResource defaultSelectPaint = new ColorPaintUIResource(Color.RED);
	private final PaintUIResource defaultDisabledTextPaint = new ColorPaintUIResource(Color.GRAY);
	private final FontFamily defaultFontFamily = FontFamilies.CALIBRI.getFamily();
	private final int defaultFontStyle = Font.PLAIN;
	private final int defaultFontSize = 12;
	private final ShapeInfo defaultShapeInfo = Shapes.RECTANGLE_WITH_CUT_CORNERS_TR_BL.getShapeInfo();
	//private final BorderUIResource defaultBorder = new BorderUIResource(ShapedLineBorder.builder().build());
	private final ColorUIResource defaultTitledBorderColor = new ColorUIResource(Color.BLACK);
	private final TitlePosition defaultTitledBorderPosition = TitlePosition.TOP;
	
	private final GraphicsEnvironment dummyGraphEnv = new GraphicsEnvironment(){
		@Override
		public GraphicsDevice[] getScreenDevices() throws HeadlessException{
			return new GraphicsDevice[0];
		}
		
		@Override
		public GraphicsDevice getDefaultScreenDevice() throws HeadlessException{
			return null;
		}
		
		@Override
		public Graphics2D createGraphics(BufferedImage img){
			return null;
		}
		
		@Override
		public Font[] getAllFonts(){
			return new Font[0];
		}
		
		@Override
		public String[] getAvailableFontFamilyNames(){
			return new String[]{defaultFontFamily.getName(), Font.DIALOG};
		}
		
		@Override
		public String[] getAvailableFontFamilyNames(Locale l){
			return new String[0];
		}
	};
	
	private final FontResourceLoader fontResourceLoader = new FontResourceLoader(false, null,
			dummyGraphEnv, "fonts/");
	
	@BeforeEach
	public void setup() throws IOException, FontFormatException{
		defaultTheme = TadukooTheme.builder().fontResourceLoader(fontResourceLoader).build();
	}
	
	/*
	 * Test Default Component UIs
	 */
	
	@Test
	public void testDefaultButtonUI(){
		assertEquals(TadukooButtonUI.class.getCanonicalName(), defaultTheme.getButtonUI());
	}
	
	/*
	 * Test Setting Component UIs
	 */
	
	@Test
	public void testSetButtonUI() throws IOException, FontFormatException{
		TadukooTheme theme = TadukooTheme.builder().buttonUI(MetalButtonUI.class).build();
		assertEquals(MetalButtonUI.class.getCanonicalName(), theme.getButtonUI());
	}
	
	/*
	 * Test Paint Defaults
	 */
	
	@Test
	public void testDefaultForegroundPaintOnButton(){
		assertEquals(defaultForegroundPaint, defaultTheme.getButtonForegroundPaint());
	}
	
	@Test
	public void testDefaultBackgroundPaintOnButton(){
		assertEquals(defaultBackgroundPaint, defaultTheme.getButtonBackgroundPaint());
	}
	
	@Test
	public void testDefaultFocusPaintOnButton(){
		assertEquals(defaultFocusPaint, defaultTheme.getButtonFocusPaint());
	}
	
	@Test
	public void testDefaultSelectPaintOnButton(){
		assertEquals(defaultSelectPaint, defaultTheme.getButtonSelectPaint());
	}
	
	@Test
	public void testDefaultDisabledTextPaintOnButton(){
		assertEquals(defaultDisabledTextPaint, defaultTheme.getButtonDisabledTextPaint());
	}
	
	/*
	 * Test Setting Default Paints
	 */
	
	@Test
	public void testSetDefaultForegroundPaintOnButton() throws IOException, FontFormatException{
		ColorPaintUIResource pink = new ColorPaintUIResource(Color.PINK);
		TadukooTheme theme = TadukooTheme.builder().defaultForegroundPaint(pink).build();
		assertEquals(pink, theme.getButtonForegroundPaint());
	}
	
	@Test
	public void testSetDefaultBackgroundPaintOnButton() throws IOException, FontFormatException{
		ColorPaintUIResource pink = new ColorPaintUIResource(Color.PINK);
		TadukooTheme theme = TadukooTheme.builder().defaultBackgroundPaint(pink).build();
		assertEquals(pink, theme.getButtonBackgroundPaint());
	}
	
	@Test
	public void testSetDefaultFocusPaintOnButton() throws IOException, FontFormatException{
		ColorPaintUIResource pink = new ColorPaintUIResource(Color.PINK);
		TadukooTheme theme = TadukooTheme.builder().defaultFocusPaint(pink).build();
		assertEquals(pink, theme.getButtonFocusPaint());
	}
	
	@Test
	public void testSetDefaultSelectPaintOnButton() throws IOException, FontFormatException{
		ColorPaintUIResource pink = new ColorPaintUIResource(Color.PINK);
		TadukooTheme theme = TadukooTheme.builder().defaultSelectPaint(pink).build();
		assertEquals(pink, theme.getButtonSelectPaint());
	}
	
	@Test
	public void testSetDefaultDisabledTextPaintOnButton() throws IOException, FontFormatException{
		ColorPaintUIResource pink = new ColorPaintUIResource(Color.PINK);
		TadukooTheme theme = TadukooTheme.builder().defaultDisabledTextPaint(pink).build();
		assertEquals(pink, theme.getButtonDisabledTextPaint());
	}
	
	/*
	 * Test Setting Button Paints
	 */
	
	@Test
	public void testSetButtonForegroundPaint() throws IOException, FontFormatException{
		ColorPaintUIResource pink = new ColorPaintUIResource(Color.PINK);
		TadukooTheme theme = TadukooTheme.builder().buttonForegroundPaint(pink).build();
		assertEquals(pink, theme.getButtonForegroundPaint());
	}
	
	@Test
	public void testSetButtonBackgroundPaint() throws IOException, FontFormatException{
		ColorPaintUIResource pink = new ColorPaintUIResource(Color.PINK);
		TadukooTheme theme = TadukooTheme.builder().buttonBackgroundPaint(pink).build();
		assertEquals(pink, theme.getButtonBackgroundPaint());
	}
	
	@Test
	public void testSetButtonFocusPaint() throws IOException, FontFormatException{
		ColorPaintUIResource pink = new ColorPaintUIResource(Color.PINK);
		TadukooTheme theme = TadukooTheme.builder().buttonFocusPaint(pink).build();
		assertEquals(pink, theme.getButtonFocusPaint());
	}
	
	@Test
	public void testSetButtonSelectPaint() throws IOException, FontFormatException{
		ColorPaintUIResource pink = new ColorPaintUIResource(Color.PINK);
		TadukooTheme theme = TadukooTheme.builder().buttonSelectPaint(pink).build();
		assertEquals(pink, theme.getButtonSelectPaint());
	}
	
	@Test
	public void testSetButtonDisabledTextPaint() throws IOException, FontFormatException{
		ColorPaintUIResource pink = new ColorPaintUIResource(Color.PINK);
		TadukooTheme theme = TadukooTheme.builder().buttonDisabledTextPaint(pink).build();
		assertEquals(pink, theme.getButtonDisabledTextPaint());
	}
	
	/*
	 * Test Font Defaults
	 */
	
	@Test
	public void testDefaultFontOnButton(){
		FontUIResource buttonFont = defaultTheme.getButtonFont();
		assertEquals(defaultFontFamily.getName(), buttonFont.getName());
		assertEquals(defaultFontStyle, buttonFont.getStyle());
		assertEquals(defaultFontSize, buttonFont.getSize());
	}
	
	/*
	 * Test Setting Default Font
	 */
	
	@Test
	public void testSetDefaultFontOnButton() throws IOException, FontFormatException{
		TadukooTheme theme = TadukooTheme.builder()
				.defaultFont(FontFamilies.DIALOG.getFamily(), Font.PLAIN, 26)
				.fontResourceLoader(fontResourceLoader).build();
		FontUIResource buttonFont = theme.getButtonFont();
		assertEquals(FontFamilies.DIALOG.getFamily().getName(), buttonFont.getName());
		assertEquals(Font.PLAIN, buttonFont.getStyle());
		assertEquals(26, buttonFont.getSize());
	}
	
	/*
	 * Test Setting Other Fonts
	 */
	
	@Test
	public void testSetButtonFont() throws IOException, FontFormatException{
		TadukooTheme theme = TadukooTheme.builder()
				.buttonFont(FontFamilies.DIALOG.getFamily(), Font.PLAIN, 26)
				.fontResourceLoader(fontResourceLoader).build();
		FontUIResource buttonFont = theme.getButtonFont();
		assertEquals(FontFamilies.DIALOG.getFamily().getName(), buttonFont.getName());
		assertEquals(Font.PLAIN, buttonFont.getStyle());
		assertEquals(26, buttonFont.getSize());
	}
	
	/*
	 * Test Shape Defaults
	 */
	
	@Test
	public void testDefaultShapeOnButton(){
		assertEquals(defaultShapeInfo, defaultTheme.getButtonShapeInfo());
	}
	
	/*
	 * Test Setting Default Shape
	 */
	
	@Test
	public void testSetDefaultShapeOnButton() throws IOException, FontFormatException{
		ShapeInfo shape = Shapes.CIRCLE.getShapeInfo();
		TadukooTheme theme = TadukooTheme.builder().defaultShapeInfo(shape).build();
		assertEquals(shape, theme.getButtonShapeInfo());
	}
	
	/*
	 * Test Setting Other Shapes
	 */
	
	@Test
	public void testSetButtonShape() throws IOException, FontFormatException{
		ShapeInfo shape = Shapes.CIRCLE.getShapeInfo();
		TadukooTheme theme = TadukooTheme.builder().buttonShapeInfo(shape).build();
		assertEquals(shape, theme.getButtonShapeInfo());
	}
	
	/*
	 * Test Border Defaults (Unfortunately can't do assertEquals due to weird BorderUIResource stuff)
	 */
	
	@Test
	public void testDefaultBorderOnButton(){
		assertNotNull(defaultTheme.getButtonBorder());
	}
	
	/*
	 * Test Setting Default Border
	 */
	
	@Test
	public void testSetDefaultBorderOnButton() throws IOException, FontFormatException{
		BorderUIResource border = new BorderUIResource(ShapedEtchedBorder.builder().build());
		TadukooTheme theme = TadukooTheme.builder().defaultBorder(border).build();
		assertEquals(border, theme.getButtonBorder());
	}
	
	/*
	 * Test Setting Other Borders
	 */
	
	@Test
	public void testSetButtonBorder() throws IOException, FontFormatException{
		BorderUIResource border = new BorderUIResource(ShapedEtchedBorder.builder().build());
		TadukooTheme theme = TadukooTheme.builder().buttonBorder(border).build();
		assertEquals(border, theme.getButtonBorder());
	}
	
	/*
	 * Test Titled Border Defaults
	 */
	
	@Test
	public void testDefaultTitledBorderBorder(){
		assertNotNull(defaultTheme.getTitledBorderBorder());
	}
	
	@Test
	public void testDefaultTitledBorderFont(){
		FontUIResource titledBorderFont = defaultTheme.getTitledBorderFont();
		assertEquals(defaultFontFamily.getName(), titledBorderFont.getName());
		assertEquals(defaultFontStyle, titledBorderFont.getStyle());
		assertEquals(defaultFontSize, titledBorderFont.getSize());
	}
	
	@Test
	public void testDefaultTitledBorderColor(){
		assertEquals(defaultTitledBorderColor, defaultTheme.getTitledBorderColor());
	}
	
	@Test
	public void testDefaultTitledBorderPosition(){
		assertEquals(defaultTitledBorderPosition.getValue(), defaultTheme.getTitledBorderPosition());
	}
	
	/*
	 * Test Setting Titled Border Settings
	 */
	
	@Test
	public void testSetTitledBorderBorder() throws IOException, FontFormatException{
		BorderUIResource border = new BorderUIResource(ShapedEtchedBorder.builder().build());
		TadukooTheme theme = TadukooTheme.builder().titledBorderBorder(border).build();
		assertEquals(border, theme.getTitledBorderBorder());
	}
	
	@Test
	public void testSetTitledBorderFont() throws IOException, FontFormatException{
		TadukooTheme theme = TadukooTheme.builder()
				.titledBorderFont(FontFamilies.DIALOG.getFamily(), Font.PLAIN, 26)
				.fontResourceLoader(fontResourceLoader).build();
		FontUIResource titledBorderFont = theme.getTitledBorderFont();
		assertEquals(FontFamilies.DIALOG.getFamily().getName(), titledBorderFont.getName());
		assertEquals(Font.PLAIN, titledBorderFont.getStyle());
		assertEquals(26, titledBorderFont.getSize());
	}
	
	@Test
	public void testSetTitledBorderColor() throws IOException, FontFormatException{
		ColorUIResource pink = new ColorUIResource(Color.PINK);
		TadukooTheme theme = TadukooTheme.builder().titledBorderColor(pink).build();
		assertEquals(pink, theme.getTitledBorderColor());
	}
	
	@Test
	public void testSetTitledBorderPosition() throws IOException, FontFormatException{
		TitlePosition belowBottom = TitlePosition.BELOW_BOTTOM;
		TadukooTheme theme = TadukooTheme.builder().titledBorderPosition(belowBottom).build();
		assertEquals(belowBottom.getValue(), theme.getTitledBorderPosition());
	}
	
	/*
	 * Test Default Other Customizations
	 */
	
	@Test
	public void testDefaultClassDefaults(){
		Object[] classDefaults = defaultTheme.getClassDefaults();
		assertEquals(0, classDefaults.length);
	}
	
	@Test
	public void testDefaultSystemColorDefaults(){
		Object[] systemColorDefaults = defaultTheme.getSystemColorDefaults();
		assertEquals(0, systemColorDefaults.length);
	}
	
	@Test
	public void testDefaultComponentDefaults(){
		Object[] componentDefaults = defaultTheme.getComponentDefaults();
		assertEquals(0, componentDefaults.length);
	}
	
	/*
	 * Test Setting Other Customizations
	 */
	
	@Test
	public void testSetClassDefaultsMap() throws IOException, FontFormatException{
		Map<String, Class<?>> classDefaultsMap = new HashMap<>();
		classDefaultsMap.put("Test", String.class);
		classDefaultsMap.put("Derp", Map.class);
		TadukooTheme theme = TadukooTheme.builder().classDefaults(classDefaultsMap).build();
		Object[] classDefaults = theme.getClassDefaults();
		assertEquals(4, classDefaults.length);
		assertEquals("Test", classDefaults[0]);
		assertEquals(String.class.getCanonicalName(), classDefaults[1]);
		assertEquals("Derp", classDefaults[2]);
		assertEquals(Map.class.getCanonicalName(), classDefaults[3]);
	}
	
	@Test
	public void testSetClassDefaultsIndividually() throws IOException, FontFormatException{
		TadukooTheme theme = TadukooTheme.builder()
				.classDefault("Test", String.class)
				.classDefault("Derp", Map.class).build();
		Object[] classDefaults = theme.getClassDefaults();
		assertEquals(4, classDefaults.length);
		assertEquals("Test", classDefaults[0]);
		assertEquals(String.class.getCanonicalName(), classDefaults[1]);
		assertEquals("Derp", classDefaults[2]);
		assertEquals(Map.class.getCanonicalName(), classDefaults[3]);
	}
	
	@Test
	public void testSetSystemColorDefaultsMap() throws IOException, FontFormatException{
		ColorUIResource pink = new ColorUIResource(Color.PINK);
		ColorUIResource magenta = new ColorUIResource(Color.MAGENTA);
		Map<String, ColorUIResource> systemColorDefaultsMap = new HashMap<>();
		systemColorDefaultsMap.put("Test", pink);
		systemColorDefaultsMap.put("Derp", magenta);
		TadukooTheme theme = TadukooTheme.builder().systemColorDefaults(systemColorDefaultsMap).build();
		Object[] systemColorDefaults = theme.getSystemColorDefaults();
		assertEquals(4, systemColorDefaults.length);
		assertEquals("Test", systemColorDefaults[0]);
		assertEquals(pink, systemColorDefaults[1]);
		assertEquals("Derp", systemColorDefaults[2]);
		assertEquals(magenta, systemColorDefaults[3]);
	}
	
	@Test
	public void testSetSystemColorDefaultsIndividually() throws IOException, FontFormatException{
		ColorUIResource pink = new ColorUIResource(Color.PINK);
		ColorUIResource magenta = new ColorUIResource(Color.MAGENTA);
		TadukooTheme theme = TadukooTheme.builder()
				.systemColorDefault("Test", pink)
				.systemColorDefault("Derp", magenta).build();
		Object[] systemColorDefaults = theme.getSystemColorDefaults();
		assertEquals(4, systemColorDefaults.length);
		assertEquals("Test", systemColorDefaults[0]);
		assertEquals(pink, systemColorDefaults[1]);
		assertEquals("Derp", systemColorDefaults[2]);
		assertEquals(magenta, systemColorDefaults[3]);
	}
	
	@Test
	public void testSetComponentDefaultsMap() throws IOException, FontFormatException{
		FontUIResource aFont = new FontUIResource(Font.DIALOG, Font.BOLD, 12);
		PaintUIResource red = new ColorPaintUIResource(Color.RED);
		Map<String, Object> componentDefaultsMap = new HashMap<>();
		componentDefaultsMap.put("Test", aFont);
		componentDefaultsMap.put("Derp", red);
		TadukooTheme theme = TadukooTheme.builder().componentDefaults(componentDefaultsMap).build();
		Object[] componentDefaults = theme.getComponentDefaults();
		assertEquals(4, componentDefaults.length);
		assertEquals("Test", componentDefaults[0]);
		assertEquals(aFont, componentDefaults[1]);
		assertEquals("Derp", componentDefaults[2]);
		assertEquals(red, componentDefaults[3]);
	}
	
	@Test
	public void testSetComponentDefaultsIndividually() throws IOException, FontFormatException{
		FontUIResource aFont = new FontUIResource(Font.DIALOG, Font.BOLD, 12);
		PaintUIResource red = new ColorPaintUIResource(Color.RED);
		TadukooTheme theme = TadukooTheme.builder()
				.componentDefault("Test", aFont)
				.componentDefault("Derp", red).build();
		Object[] componentDefaults = theme.getComponentDefaults();
		assertEquals(4, componentDefaults.length);
		assertEquals("Test", componentDefaults[0]);
		assertEquals(aFont, componentDefaults[1]);
		assertEquals("Derp", componentDefaults[2]);
		assertEquals(red, componentDefaults[3]);
	}
}
