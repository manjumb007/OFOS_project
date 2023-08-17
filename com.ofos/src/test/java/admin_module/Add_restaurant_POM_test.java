package admin_module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.ofos.GenericUtility.ExcelUtility;
import com.ofos.GenericUtility.FileUtility;
import com.ofos.GenericUtility.JavaUtility;
import com.ofos.GenericUtility.WebDriverUtility;
import com.ofos.Objectrepo.Add_restaurant_page;
import com.ofos.Objectrepo.AdminLoginPage;
import com.ofos.Objectrepo.Dashboard_page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Add_restaurant_POM_test 

{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
           WebDriver driver = new ChromeDriver();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		 JavaUtility jLib = new JavaUtility();

		String url = fLib.getDatafromPropertyFile("aurl");
		String username = fLib.getDatafromPropertyFile("ausername");
		String password = fLib.getDatafromPropertyFile("apassword");
		

		
		driver.get(url);
		wLib.waitforPageLoad(driver);
		wLib.maximize(driver);
	
		
		AdminLoginPage Alp = new AdminLoginPage(driver);
		Alp.login(username, password);
		
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
	   art.category(categ);
	   art.submit();
	   
                
		




	}

}
