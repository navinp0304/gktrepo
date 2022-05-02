package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LogUtilTest {
	
	@Test
	void testReadFirstLine() {
		LogUtil logger = new LogUtil();
		String line = "This is first line\n";
		logger.writeFirstLine(line);
		String observed = logger.readFirstLine();
		assertEquals(line.trim(),observed);
	}

	@Test
	void testWriteFirstLine() {
		LogUtil logger = new LogUtil();
		String line = "This is first line\n";
		String secondLine = "This is second line\n";
		logger.writeFirstLine(line);
		logger.writeFirstLine(secondLine);
		String observed = logger.readFirstLine();
		assertEquals(secondLine.trim(),observed);

	}

}
