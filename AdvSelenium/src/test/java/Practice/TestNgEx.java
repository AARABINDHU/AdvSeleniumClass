package Practice;

import org.testng.annotations.Test;

public class TestNgEx {

	@Test(priority= 0)
	public void createContact() {
		System.out.println("ContactCreated");
	}
@Test(priority= 2)
	public void modiftContact() {
		System.out.println("ContactModified");

	}
@Test(priority= -1)
	public void deleteContact() {
		System.out.println("ContactDeleted");

	}
}
