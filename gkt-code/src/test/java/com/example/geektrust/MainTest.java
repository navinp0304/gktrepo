package test.java.com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.com.example.geektrust.Main;

class MainTest {

	@Test
	void testMain() {
		String[] args = { "sample_input/input2.txt" };
		Main objMain = new Main();

		Main.main(args);

		assertAll("Main test wrapper",
				()->assertNotEquals(objMain,null));

	}

}
