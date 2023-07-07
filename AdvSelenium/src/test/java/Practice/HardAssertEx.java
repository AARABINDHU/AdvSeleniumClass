package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;



public class HardAssertEx {
	@Test
	public void m1() {
       
		System.out.println("Step-1");
		String expData = "Qspiders";
		String actData = "Qspiders";
		
		Assert.assertEquals(actData, expData);
		System.out.println("Step-2");
		System.out.println("Step-3");
		}
	
	@Test
	public void m2()
	{
		System.out.println("Step-4");
		Assert.assertEquals(true, true);
	}
	
}



