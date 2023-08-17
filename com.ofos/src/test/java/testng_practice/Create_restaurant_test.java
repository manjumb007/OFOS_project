package testng_practice;

import org.testng.annotations.Test;

import com.ofos.GenericUtility.Baseclass;

public class Create_restaurant_test extends Baseclass
{
@Test(groups="regression")
public void add()
{
	System.out.println("-----restaurant added---- ");
}
@Test(groups="Smoke")
public void modify()
{
	System.out.println("-----restaurant modified---- ");
}



}
