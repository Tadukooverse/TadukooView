package com.github.tadukoo.view.lookandfeel;

import com.github.tadukoo.view.paint.PaintUIResource;

import javax.swing.UIDefaults;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.FontFormatException;
import java.io.IOException;

/**
 * Tadukoo Look &amp; Feel is a Look &amp; Feel currently extending {@link MetalLookAndFeel} that allows for easier
 * customization of the Look &amp; Feel. Through the use of specifying a {@link TadukooTheme}, you can customize
 * paints, fonts, shapes, and borders of components, and even swap out the Component UI classes themselves if
 * that's not custom enough for you.
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.3
 * @since Alpha v.0.2
 */
public class TadukooLookAndFeel extends MetalLookAndFeel{
	/** The {@link TadukooTheme theme} to use in the Look &amp; Feel */
	private final TadukooTheme theme;
	
	/**
	 * Constructs a Tadukoo Look &amp; Feel with the default {@link TadukooTheme theme}.
	 *
	 * @throws IOException If font loading goes wrong in creating default theme
	 * @throws FontFormatException If font loading goes wrong in creating default theme
	 */
	public TadukooLookAndFeel() throws IOException, FontFormatException{
		theme = TadukooThemeFactory.createDefaultTheme();
	}
	
	/**
	 * Constructs a Tadukoo Look &amp; Feel with the given {@link TadukooTheme theme}.
	 *
	 * @param theme The {@link TadukooTheme theme} to use for the Look &amp; Feel
	 */
	public TadukooLookAndFeel(TadukooTheme theme){
		this.theme = theme;
	}
	
	/**
	 * @return The {@link TadukooTheme} to use in the Look &amp; Feel
	 */
	public TadukooTheme getTheme(){
		return theme;
	}
	
	/**
	 * @return The name of this look and feel. This returns "Tadukoo"
	 */
	@Override
	public String getName(){
		return "Tadukoo";
	}
	
	/**
	 * @return The identifier of this look and feel. This returns "Tadukoo"
	 */
	@Override
	public String getID(){
		return "Tadukoo";
	}
	
	/**
	 * @return A short description of this look and feel. This returns "The Tadukoo Look and Feel"
	 */
	@Override
	public String getDescription(){
		return "The Tadukoo Look and Feel";
	}
	
	/**
	 * @return {@code false}; TadukooLookAndFeel is not a native look and feel
	 */
	@Override
	public boolean isNativeLookAndFeel(){
		return false;
	}
	
	/**
	 * @return {@code true}; TadukooLookAndFeel can be run on any platform
	 */
	@Override
	public boolean isSupportedLookAndFeel(){
		return true;
	}
	
	/**
	 * Populates the {@link UIDefaults} table with mappings for the Component UI classes to be used
	 * in the Look &amp; Feel. Tadukoo Look &amp; Feel has its own Component UI classes, but you are able
	 * to specify different ones in the {@link TadukooTheme theme} if you pass one in via the
	 * constructor.
	 *
	 * @param table The {@link UIDefaults} table to add the mappings to
	 */
	@Override
	protected void initClassDefaults(UIDefaults table){
		super.initClassDefaults(table);
		
		table.put("ButtonUI", theme.getButtonUI());
		// TODO: Add other mappings
		
		Object[] otherClassDefaults = theme.getClassDefaults();
		if(otherClassDefaults.length != 0){
			table.putDefaults(theme.getClassDefaults());
		}
	}
	
	/**
	 * Populates {@code table} with system colors. Currently just adds the custom systemColorDefaults from
	 * {@link TadukooTheme}. In the future, there will be more settings on the theme for here.
	 *
	 * @param table the {@code UIDefaults} object the values are added to
	 * @throws NullPointerException if {@code table} is {@code null}
	 */
	@Override
	protected void initSystemColorDefaults(UIDefaults table){
		super.initSystemColorDefaults(table);
		
		Object[] otherSystemColorDefaults = theme.getSystemColorDefaults();
		if(otherSystemColorDefaults.length != 0){
			table.putDefaults(theme.getSystemColorDefaults());
		}
	}
	
	/**
	 * Populates the {@link UIDefaults} table with mappings for defaults on the Components themselves.
	 * This includes anything that can be customized on the {@link TadukooTheme theme}, such as
	 * paints and fonts.
	 *
	 * @param table The {@link UIDefaults} table to add the mappings to
	 */
	@Override
	protected void initComponentDefaults(UIDefaults table){
		super.initComponentDefaults(table);
		
		PaintUIResource buttonForegroundPaint = theme.getButtonForegroundPaint();
		PaintUIResource buttonBackgroundPaint = theme.getButtonBackgroundPaint();
		PaintUIResource buttonFocusPaint = theme.getButtonFocusPaint();
		PaintUIResource buttonSelectPaint = theme.getButtonSelectPaint();
		PaintUIResource buttonDisabledTextPaint = theme.getButtonDisabledTextPaint();
		
		Object[] defaults = new Object[]{
				"Button.foreground", buttonForegroundPaint.getColorUIResource(),
				"Button.foreground.paint", buttonForegroundPaint,
				"Button.background", buttonBackgroundPaint.getColorUIResource(),
				"Button.gradient", buttonBackgroundPaint.getMetalGradientList(),
				"Button.background.paint", buttonBackgroundPaint,
				"Button.focus", buttonFocusPaint.getColorUIResource(),
				"Button.focus.paint", buttonFocusPaint,
				"Button.select", buttonSelectPaint.getColorUIResource(),
				"Button.select.paint", buttonSelectPaint,
				"Button.disabledText", buttonDisabledTextPaint.getColorUIResource(),
				"Button.disabledText.paint", buttonDisabledTextPaint,
				"Button.font", theme.getButtonFont(),
				"Button.border", theme.getButtonBorder(),
				"Button.shape", theme.getButtonShapeInfo(),
				
				"TitledBorder.border", theme.getTitledBorderBorder(),
				"TitledBorder.font", theme.getTitledBorderFont(),
				"TitledBorder.titleColor", theme.getTitledBorderColor(),
				"TitledBorder.position", theme.getTitledBorderPosition()
		};
		
		// TODO: Add other mappings
		
		table.putDefaults(defaults);
		
		Object[] otherComponentDefaults = theme.getComponentDefaults();
		if(otherComponentDefaults.length != 0){
			table.putDefaults(theme.getComponentDefaults());
		}
	}
}
