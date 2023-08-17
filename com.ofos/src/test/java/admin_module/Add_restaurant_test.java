package admin_module;

import java.io.FileInputStream;
import java.io.IOException;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Add_restaurant_test 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		//create object for property class
		Properties pObj = new Properties();
		//load the file 
		pObj.load(fis);

		String AURL = pObj.getProperty("Aurl");
		String BROWSER = pObj.getProperty("browser");
		String Admin_USERNAME = pObj.getProperty("ausn");
		String Admin_PASSWORD = pObj.getProperty("apswd");

		System.out.println(AURL);
		System.out.println(BROWSER);
		System.out.println(Admin_PASSWORD);
		System.out.println(Admin_USERNAME);

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
		driver.manage().window().maximize();
		driver.get(AURL);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//admin login
		driver.findElement(By.name("username")).sendKeys(Admin_USERNAME);
		driver.findElement(By.name("password")).sendKeys(Admin_PASSWORD);
		driver.findElement(By.name("submit")).click();
		//open add restaurant link
		driver.findElement(By.className("hide-menu")).click();
		driver.findElement(By.xpath("//a[text()='Add Restaurant']")).click();

		//fetch the data from test data file

		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TESTDATA_ofos.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Restaurants");
		int count = sh.getLastRowNum();

		HashMap<String, String> map = new HashMap<String, String>();

		for(int i=0;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);

		}

		//enter all the fields to add restaurant
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}

		
		Select open_hrs = new Select(driver.findElement(By.name("o_hr")));
		open_hrs.selectByVisibleText("6am");

		Select close_hrs = new Select(driver.findElement(By.name("c_hr")));
		close_hrs.selectByVisibleText("10pm");

		Select open_days = new Select(driver.findElement(By.name("o_days")));
		open_days.selectByVisibleText("Mon-Sat");

		Select catg_name = new Select(driver.findElement(By.name("c_name")));
		catg_name.selectByVisibleText("Continental");
		driver.findElement(By.name("file")).sendKeys("C:\\Users\\91810\\Desktop\\TESTYANTRA");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", " ");
		
		Thread.sleep(3000);

		driver.findElement(By.name("submit")).click();
		Thread.sleep(5000);
		
		

	}

}


