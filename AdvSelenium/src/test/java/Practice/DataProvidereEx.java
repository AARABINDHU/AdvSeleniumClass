package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidereEx {

	@Test(dataProvider = "dataProviderExecute")
	public void bookTickets(String src, String dest) {
		System.out.println("book tickets from" + src + " to" + dest);
	}

	@DataProvider
	public Object[][] dataProviderExecute() {
		Object[][] obj = new Object[2][2];

		obj[0][0] = "chennai";
		obj[0][1] = "madurai";

		obj[1][0] = "kerala";
		obj[1][1] = "chennai";

		return obj;
	}

}
