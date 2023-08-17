package register_module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ofos.GenericUtility.DatabaseUtility;
import com.ofos.GenericUtility.ExcelUtility;
import com.ofos.GenericUtility.FileUtility;
import com.ofos.GenericUtility.JavaUtility;
import com.ofos.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Create_accountusing_generics_test {

	public static void main(String[] args) throws Throwable
	{
		
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		

		String URL = fLib.getDatafromPropertyFile("url");
		String BROWSER = fLib.getDatafromPropertyFile("browser");
		String  PASSWORD = fLib.getDatafromPropertyFile("password");

		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(PASSWORD);

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

		wLib.maximize(driver);
		
		driver.get(URL);
		WebElement reg = driver.findElement(By.xpath("//a[text()='Register']"));
		reg.click();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	

		eLib.getMultipleDataFromExcel("useraccounts2", 0, 1, driver);
		Thread.sleep(3000);

		

		driver.findElement(By.name("submit")).click();

	}

}
