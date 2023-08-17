package admin_module;

import static org.testng.Assert.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ofos.GenericUtility.Baseclass;
import com.ofos.Objectrepo.Add_restaurant_page;
import com.ofos.Objectrepo.Dashboard_page;


@Listeners(com.ofos.GenericUtility.Listener_impleclass.class)
public class Add_resto_listener_test extends Baseclass
{
	@Test
	public void add_restaurant()throws Throwable 
	{
		
	Dashboard_page dbp = new Dashboard_page(driver);
		dbp.addnewrestaurant();
		
	
	   Add_restaurant_page art = new Add_restaurant_page(driver);
	   
		art.enterAllField(eLib.getMultipleDataFromExcel("Restaurants", 0, 1), driver, jLib);
		
	   String opentime = eLib.readDataFromexcel("Resto_DD", 0, 1);
	   String closetime = eLib.readDataFromexcel("Resto_DD", 1, 1);
	   String opendays = eLib.readDataFromexcel("Resto_DD", 2, 1);
	   String categ = eLib.readDataFromexcel("Resto_DD", 3, 1);
	   
	   art.opendrp(opentime);
	   art.closedrp(closetime);
	   art.openday(opendays);
	   
	  fail();
	   art.category(categ);
	   art.submit();
	   art.confirmmsg();
	   
	}

}
