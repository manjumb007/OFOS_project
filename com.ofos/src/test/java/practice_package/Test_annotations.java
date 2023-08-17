package practice_package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test_annotations
{
	@BeforeSuite
	public void connectDB_BS()
	{
		System.out.println("DB connected---BS");
	}
	
	@BeforeClass
	public void launchbrowser_BC()
	{
		System.out.println("browser is launched----BC");
	}
	@BeforeMethod
	public void login_BM()
	{
		System.out.println("login to appln-----BM");
	}
	
@Test
public void test()
{
	System.out.println("execute test script-----@test");
}
	@AfterClass
	public void closebrowser_AC()
	{
		System.out.println("browser closed-----AC");
	}
	
	@AfterMethod
	public void logout_AM()
	{
		System.out.println("logged out------AM");
	}
	@AfterSuite
	public void closeDB_AS()
	{
		System.out.println("DB closed----AS");
	
	}

}
