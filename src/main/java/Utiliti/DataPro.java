package Utiliti;

import org.testng.annotations.DataProvider;

public class DataPro {
	
	@DataProvider
	public Object[][] dataP() {
		return new Object[][] {{"abcdeabcde212","abcd1abcd"},{"abcdeabcde212","abcd1abc"}};
	}

}
