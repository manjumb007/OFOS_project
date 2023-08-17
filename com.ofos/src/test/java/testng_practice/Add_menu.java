package testng_practice;

import org.testng.annotations.Test;

import com.ofos.GenericUtility.Baseclass;

public class Add_menu extends Baseclass
{
	@Test
	public void menu()
	{
		System.out.println("menu is added");
	}

	@Test
	public void delete_menu()
	{
		System.out.println("menu is deleted");
	}

}
