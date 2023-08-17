package practice_package;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class Assertion_hardassert_test 
{
	@Test
	public void assert_test()
	{
		System.out.println("------step1------");
		System.out.println("------step1------");
		
		assertEquals("A", "B");
		System.out.println("------step3------");
		System.out.println("------step4------");
		
		
		
	}
	

	@Test
	public void assert_test2()
	{
		System.out.println("------step5------");
		System.out.println("------step6------");
		int a=5;
		assertNull(a);
		
		System.out.println("------step7------");
		System.out.println("------step8------");
		
		
		
	}
	

}
