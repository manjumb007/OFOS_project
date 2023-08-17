package practice_package;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert_test 
{
	
	@Test
	public void softassert()
	{
		System.out.println("------step1------");
		System.out.println("------step2------");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("A","B");
		System.out.println("------step3------");
		System.out.println("------step4------");
		sa.assertAll();
	}

}
