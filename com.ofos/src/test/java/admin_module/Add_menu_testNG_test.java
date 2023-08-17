package admin_module;

import org.testng.annotations.Test;

import com.ofos.GenericUtility.Baseclass;
import com.ofos.Objectrepo.Add_menu_page;
import com.ofos.Objectrepo.Dashboard_page;

public class Add_menu_testNG_test extends Baseclass
{
@Test
 public void addmenu() throws Throwable
{
	
		
		Dashboard_page dbp = new Dashboard_page(driver);
		dbp.addnewmenu();
		
		Add_menu_page amp = new Add_menu_page(driver);
		
		amp.enterAllField(eLib.getMultipleDataFromExcel("Menu", 0,1), driver, jLib);
		
		String res_name = eLib.readDataFromexcel("Menu", 4, 1);
		String img_path = eLib.readDataFromexcel("Menu", 3, 1);
		
		amp.restaurant(res_name);
		amp.rest_logo(img_path);
		Thread.sleep(3000);
		amp.submit();
		
		

}
}
 