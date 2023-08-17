package admin_module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ofos.GenericUtility.ExcelUtility;
import com.ofos.GenericUtility.FileUtility;
import com.ofos.GenericUtility.JavaUtility;
import com.ofos.GenericUtility.WebDriverUtility;
import com.ofos.Objectrepo.Add_menu_page;
import com.ofos.Objectrepo.AdminLoginPage;
import com.ofos.Objectrepo.Dashboard_page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_restaurant_POM_test {

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
		dbp.dltmenu();
		
		Add_menu_page amp = new Add_menu_page(driver);
		amp.delete();
		
		
		

	}

}
