package com.github.tadukoo.view.font;

import com.github.tadukoo.util.LoggerUtil;
import com.github.tadukoo.util.logger.EasyLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FontResourceLoaderTest{
	private boolean logWarnings;
	private EasyLogger logger;
	private GraphicsEnvironment graphEnv;
	private String path;
	private FontResourceLoader fontResourceLoader;
	
	@BeforeEach
	public void setup() throws IOException{
		logWarnings = false;
		logger = new EasyLogger(LoggerUtil.createFileLogger("/target/dummy-log.txt", Level.OFF));
		graphEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		path = "fonts/";
		fontResourceLoader = new FontResourceLoader(logWarnings, logger, graphEnv, path);
	}
	
	@Test
	public void testGetLogWarnings(){
		assertEquals(logWarnings, fontResourceLoader.getLogWarnings());
	}
	
	@Test
	public void testGetLogger(){
		assertEquals(logger, fontResourceLoader.getLogger());
	}
	
	@Test
	public void testGetGraphEnv(){
		assertEquals(graphEnv, fontResourceLoader.getGraphEnv());
	}
	
	@Test
	public void testGetFontDirectoryPath(){
		assertEquals(path, fontResourceLoader.getFontDirectoryPath());
	}
}
