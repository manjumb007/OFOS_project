package practice_package;

import org.testng.annotations.Test;

public class FetchDP1_test 
{
	
	@Test(dataProviderClass = Dataprovider2_test.class,dataProvider = "data")
	public void getdata(String org,String loc,String batch)
	{
		
		System.out.println("organization---->"+org+"   location--->"+loc+"   batchcode--->"+batch);
		
		
	}

}
