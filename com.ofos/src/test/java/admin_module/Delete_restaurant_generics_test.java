package admin_module;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ofos.GenericUtility.DatabaseUtility;
import com.ofos.GenericUtility.ExcelUtility;
import com.ofos.GenericUtility.FileUtility;
import com.ofos.GenericUtility.JavaUtility;
import com.ofos.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_restaurant_generics_test {

	public static void main(String[] args) throws Throwable
	{
		
		

		DatabaseUtility dLib = new DatabaseUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();



		String AURL = fLib.getDatafromPropertyFile("aurl");
		String BROWSER = fLib.getDatafromPropertyFile("browser");
		String A_PASSWORD = fLib.getDatafromPropertyFile("apassword");
		String  A_USERNAME = fLib.getDatafromPropertyFile("ausername");

		System.out.println(AURL);
		System.out.println(BROWSER);
		System.out.println(A_PASSWORD);
		System.out.println(A_USERNAME);


		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.get(AURL);
		wLib.maximize(driver);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//admin login
		driver.findElement(By.name("username")).sendKeys(A_USERNAME);
		driver.findElement(By.name("password")).sendKeys(A_PASSWORD);
		driver.findElement(By.name("submit")).click();
		
		//open add restaurant link
				driver.findElement(By.className("hide-menu")).click();
				driver.findElement(By.xpath("//a[text()='All Restaurant']")).click();
				
				//select a restaurant and delete
				
				driver.findElement(By.xpath("//a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']")).click();
				driver.navigate().refresh();
				
				driver.quit();



	}

}
