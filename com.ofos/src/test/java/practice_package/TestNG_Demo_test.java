package practice_package;

import org.testng.annotations.Test;

public class TestNG_Demo_test 
{
	
	@Test(enabled=false)
	
	public void createdata()
	{
		System.out.println("-----------created data------>>");
	}
@Test(dependsOnMethods="createdata")
	
	public void editdata()
	{
		System.out.println("-----------edited data------>>");
	}

@Test(priority=1)

public void deletedata()
{
	System.out.println("-----------deleted data------>>");
}

}
