package testng_practice;

import org.testng.annotations.Test;

import com.ofos.GenericUtility.Baseclass;

public class Create_user_test extends Baseclass
{

	@Test(groups="Smoke")
	public void add_user()
	{
		System.out.println("----- account created---- ");
	}
	@Test(groups="regression")
	public void modify_user()
	{
		System.out.println("-----account modified---- ");
	}

}
