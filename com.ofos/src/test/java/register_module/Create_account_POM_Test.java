package register_module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ofos.GenericUtility.ExcelUtility;
import com.ofos.GenericUtility.FileUtility;
import com.ofos.GenericUtility.JavaUtility;
import com.ofos.GenericUtility.WebDriverUtility;
import com.ofos.Objectrepo.Userlogin_page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_account_POM_Test {

	public static void main(String[] args) throws Throwable 
	{
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		 JavaUtility jLib = new JavaUtility();

		String url = fLib.getDatafromPropertyFile("url");
	
		driver.get(url);
		wLib.waitforPageLoad(driver);
		wLib.maximize(driver);
	
		Userlogin_page ulp = new Userlogin_page(driver);
		
		ulp.reg_link();
		ulp.enterAllField(eLib.getMultipleDataFromExcel("useraccounts2", 0, 1), driver, jLib);
		
		ulp.submit();
		
		
		
		
		
		
		
		

	}

}
