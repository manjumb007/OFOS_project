package practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider_test 
{
	
	
	@Test(dataProvider="data")
	public void getdata(String org,String Loc)
	{
		System.out.println("organizatin----->"+org+"    location--->"+Loc);
		
		
	}
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj = new Object[2][2];
		
		obj[0][0]="Qspiders";
		obj[0][1]="Rajajinagar";
		
		obj[1][1]="TestYantra";
		obj[1][0]="Katriguppe";
		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
