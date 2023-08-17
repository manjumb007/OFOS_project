package practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ofos.GenericUtility.ExcelUtility;

public class Datapro_EXcel_Generic_test 
{
	@Test(dataProvider = "getdata_generic")
	public void fetchdata(String client,String Loc,String emp)
	{
		System.out.println("Client----->"+client+"   location-->"+Loc+"   employees---->"+emp);
	}
	

	@DataProvider
	public Object[][] getdata_generic() throws Throwable
	{
		ExcelUtility eLib= new ExcelUtility();
		Object[][] value = eLib.DPmultiplesetofDat("DP");
		return value;
	}

}
