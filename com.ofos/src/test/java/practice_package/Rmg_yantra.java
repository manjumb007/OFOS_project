package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rmg_yantra
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra"); 
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("OFOS");
		driver.findElement(By.xpath("//input[@name='teamSize']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Manjunath");
		
		WebElement ele = driver.findElement(By.xpath("//select[@name='status']"));
		Select s = new Select(ele);
		s.selectByVisibleText("created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
	}

}
