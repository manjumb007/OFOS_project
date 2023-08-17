package admin_module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Add_menu_test {

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
		
		//add menu
		driver.findElement(By.xpath("//span[text()='Menu']")).click();
		driver.findElement(By.xpath("//a[text()='Add Menu']")).click();
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TESTDATA_ofos.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Menu");
		int count = sh.getLastRowNum();

		HashMap<String, String> map = new HashMap<String, String>();

		for(int i=0;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);

		}

		//enter all the fields to add MEnu
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		
		Select RES_name = new Select(driver.findElement(By.name("res_name")));
		RES_name.selectByVisibleText("meghana");
		driver.findElement(By.name("file")).sendKeys("C:\\Users\\91810\\Desktop\\TESTYANTRA");
		Thread.sleep(5000);
		driver.findElement(By.name("submit")).click();
		driver.navigate().refresh();
		

	}

}
