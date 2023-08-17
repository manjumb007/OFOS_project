package admin_module;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.ofos.GenericUtility.DatabaseUtility;
import com.ofos.GenericUtility.ExcelUtility;
import com.ofos.GenericUtility.FileUtility;
import com.ofos.GenericUtility.JavaUtility;
import com.ofos.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Add_restaurant_generics_test {

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
		wLib.maximize(driver);
		driver.get(AURL);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//admin login
		driver.findElement(By.name("username")).sendKeys(A_USERNAME);
		driver.findElement(By.name("password")).sendKeys(A_PASSWORD);
		driver.findElement(By.name("submit")).click();
		//open add restaurant link
		driver.findElement(By.className("hide-menu")).click();
		driver.findElement(By.xpath("//a[text()='Add Restaurant']")).click();

		//fetch the data from test data file
		eLib.getMultipleDataFromExcel("Restaurants", 0, 1, driver);



		WebElement open_hrs = driver.findElement(By.name("o_hr"));
		wLib.selectbytext("6am",open_hrs);


		WebElement close_hrs = driver.findElement(By.name("c_hr"));
		wLib.selectbytext("10pm",close_hrs);


		WebElement open_days = driver.findElement(By.name("o_days"));
		wLib.selectbytext("Mon-Sat",open_days);


		WebElement catg_name = driver.findElement(By.name("c_name"));
		wLib.selectbytext("Continental",catg_name);




		driver.findElement(By.name("file")).sendKeys("C:\\Users\\91810\\Desktop\\TESTYANTRA");

		wLib.scrollBarAction(driver);


		Thread.sleep(3000);

		driver.findElement(By.name("submit")).click();
		Thread.sleep(5000);



	}

}
