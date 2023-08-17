package admin_module;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_Restaurant_test {

	public static void main(String[] args) throws IOException 
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
				
				//open all restaurant link
				driver.findElement(By.className("hide-menu")).click();
				driver.findElement(By.xpath("//a[text()='All Restaurant']")).click();
				
				//select a restaurant and delete
				
				driver.findElement(By.xpath("//a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']")).click();
				driver.navigate().refresh();
				
				driver.quit();


	}

}
