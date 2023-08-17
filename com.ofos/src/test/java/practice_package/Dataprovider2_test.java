package practice_package;

import org.testng.annotations.DataProvider;

public class Dataprovider2_test 
{
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj = new Object[3][3];
		
		obj[0][0]="Qspiders";
		obj[0][1]="Rajajinagar";
		obj[0][2]="RCMM44";
		
		obj[1][0]="TestYantra";
		obj[1][1]="Katriguppe";
		obj[1][2]="SDET50";
		

		obj[2][0]="TestYantra";
		obj[2][1]="Katriguppe";
		obj[2][2]="SDET50";

		return obj;
	}
	

	
	
	

}
