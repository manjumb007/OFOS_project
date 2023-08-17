package testng_practice;

import org.testng.annotations.Test;

import com.ofos.GenericUtility.Baseclass;

public class Place_order extends Baseclass
{
	@Test
	public void order()
	{
		System.out.println("order is placed");
	}

	@Test
	public void delete_order()
	{
		System.out.println("order is deleted");
	}

}
