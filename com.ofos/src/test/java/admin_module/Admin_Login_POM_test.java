package admin_module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ofos.GenericUtility.FileUtility;
import com.ofos.GenericUtility.WebDriverUtility;
import com.ofos.Objectrepo.AdminLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Admin_Login_POM_test {

	public static void main(String[] args) throws Throwable 
	{
	 FileUtility fLib = new FileUtility();
	 WebDriverUtility wLib = new WebDriverUtility();
	 
	String url = fLib.getDatafromPropertyFile("aurl");
	String username = fLib.getDatafromPropertyFile("ausername");
	String password = fLib.getDatafromPropertyFile("apassword");
    String browser = fLib.getDatafromPropertyFile("browser");
    
    WebDriver driver;
	if(browser.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	else
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	wLib.maximize(driver);
	driver.get(url);

	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	AdminLoginPage Alp = new AdminLoginPage(driver);
	Alp.login(username, password);
	

	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	

}
