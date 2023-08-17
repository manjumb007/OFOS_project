package register_module;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_account_test 
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
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TESTDATA_ofos.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		
		String user_name = wb.getSheet("useraccounts").getRow(1).getCell(0).getStringCellValue();
		String first_name = wb.getSheet("useraccounts").getRow(1).getCell(1).getStringCellValue();
		String last_name = wb.getSheet("useraccounts").getRow(1).getCell(2).getStringCellValue();
		 String phone_number = wb.getSheet("useraccounts").getRow(1).getCell(3).getStringCellValue();
		 String email_id = wb.getSheet("useraccounts").getRow(1).getCell(4).getStringCellValue();
		 String pswd = wb.getSheet("useraccounts").getRow(1).getCell(5).getStringCellValue();
		 String address = wb.getSheet("useraccounts").getRow(1).getCell(6).getStringCellValue();
		
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
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//click on register link
		driver.findElement(By.xpath("//a[text()='Register']")).click();
	
		
		//enter all the fields
		driver.findElement(By.name("username")).sendKeys(user_name);
		driver.findElement(By.name("firstname")).sendKeys(first_name);
		driver.findElement(By.name("lastname")).sendKeys(last_name);
		driver.findElement(By.name("phone")).sendKeys(phone_number);
	
		driver.findElement(By.name("email")).sendKeys(email_id);
		driver.findElement(By.name("password")).sendKeys(pswd);
		driver.findElement(By.name("cpassword")).sendKeys(pswd);
		driver.findElement(By.name("address")).sendKeys(address);
		
		driver.findElement(By.name("submit")).click();
		
		

		
	}
	

}
