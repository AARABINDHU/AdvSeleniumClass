package Generic_Utility;

import java.util.Random;

public class Java_Utility {

	/**
	 * This method is avoid duplicates
	 * @return
	 * @author faiza
	 */
	public int getRandomNum()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
		
	}
}
