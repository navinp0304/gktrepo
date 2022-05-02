package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.Test;

class CommandDispatchTest {

	@Test
	void testRun() {
		CommandDispatch cmdParser = new CommandDispatch("sample_input/input2.txt");

		cmdParser.run();
		
		LogUtil logger = new LogUtil();
		String firstLine = logger.readFirstLine();
		// restore
		assertEquals(firstLine, "2400 5215");
	}

	@Test
	void testCommandParserNoFile() throws IOException {
		CommandDispatch cmdParser = new CommandDispatch("nofile");
		cmdParser.run();
		LogUtil logger= new LogUtil();
		String firstLine=logger.readFirstLine();
		assertEquals(firstLine, "FILE NOT FOUND");
	}

	@Test
	void testCommandParser() {
		CommandDispatch cmdParser = new CommandDispatch("sample_input/input1.txt");
		assertNotEquals(cmdParser, null);
	}

}
