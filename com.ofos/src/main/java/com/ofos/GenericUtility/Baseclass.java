package com.ofos.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ofos.Objectrepo.AdminLoginPage;
import com.ofos.Objectrepo.Dashboard_page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass
{
	public DatabaseUtility dLib= new DatabaseUtility();
	public FileUtility fLib= new FileUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
@BeforeSuite
public void config_BS() throws Throwable
{
	dLib.connectToDb();
	System.out.println("---connect to DB----");
	
}

	@BeforeClass
	public void config_browser_BC() throws Throwable
	{
		String BROWSER = fLib.getDatafromPropertyFile("browser");
		String URL = fLib.getDatafromPropertyFile("aurl");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		sdriver=driver;
		System.out.println("---launch the browser--");
		wLib.maximize(driver);
		driver.get(URL);
		wLib.waitforPageLoad(driver);
	}
	
	
	@BeforeMethod
	public void config_login_BM() throws Throwable
	{
		String USERNAME = fLib.getDatafromPropertyFile("ausername");
		String PASSWORD= fLib.getDatafromPropertyFile("apassword");
		String  URL=fLib.getDatafromPropertyFile("aurl");

		
             driver.get(URL);
             wLib.waitforPageLoad(driver);          
             AdminLoginPage ALp = new AdminLoginPage(driver);
             ALp.login(USERNAME, PASSWORD);
             System.out.println("---login to application---");
             
	}
	
	@AfterMethod
	public void config_logout_AM()
	{
		Dashboard_page dp = new Dashboard_page(driver);
		dp.logout();
		
		System.out.println("---logout from appln");
	}
	
	@AfterClass
	public void config_AC()
	{
		driver.quit();
		System.out.println("close the browser");
	}
	
	
	@AfterSuite
	public void config_AS() throws Throwable
	{
		dLib.closeDb();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			

}
