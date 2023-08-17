package practice_package;

import org.testng.annotations.Test;

public class Fetchdata_TNG_DP_test
{
	
 @Test(dataProviderClass=Dataprovider_test.class,dataProvider = "data")
 public void fetchDP(String org,String Loc)
 {
	 System.out.println("organzation---->"+org+"   location-->>"+Loc);
 }
 
 
 
 
 
 
 
}
