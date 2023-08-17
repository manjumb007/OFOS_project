package register_module;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createacnt_usingmaps_test 
{

	public static void main(String[] args) throws IOException 
	{



		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		//create object for property class
		Properties pObj = new Properties();
		//load the file 
		pObj.load(fis);

		String URL = pObj.getProperty("url");
		String BROWSER = pObj.getProperty("browser");
		String PASSWORD = pObj.getProperty("password");

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
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//fetch the data from test data file

		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TESTDATA_ofos.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("useraccounts2");
		int count = sh.getLastRowNum();

		HashMap<String, String> map = new HashMap<String, String>();
		

		for(int i=0;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);

		}

		//enter all the fields
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}



		driver.findElement(By.name("submit")).click();
	}
}






