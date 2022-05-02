package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class PrintBillCommandTest {

	@Test
	void testPrintBillCommand() {
		PrintBillCommand command = new PrintBillCommand();
		assertNotEquals(command, null);
	}

	@Test
	void testParseCommand() {


		PrintBillCommand command = new PrintBillCommand();
		// Apartment apt=new Apartment(2,0.3,5);
		Apartment apt = new AllotCommand().parseCommand("ALLOT_WATER 2 3:7");
		apt = new AddGuestsCommand().parseCommand(apt, "ADD_GUESTS 5");

		apt = command.parseCommand(apt);
		
				
		LogUtil logger = new LogUtil();
		String firstLine = logger.readFirstLine();
		
		Double[] exp = { 2400.0, 5215.0 };
		String[] tokens = firstLine.trim().split(" ");
		Double litres = Double.parseDouble(tokens[0]);
		Double cost = Double.parseDouble(tokens[1]);
		Double[] observed = { litres, cost };
		Apartment finalApt = apt;
		assertAll("Print Bill Command rate summary", () -> assertEquals(finalApt.getGuests(), 5),
				() -> assertEquals(observed[0], exp[0], 1.0e-6), () -> assertEquals(observed[1], exp[1], 1.0e-6));
	}

}
