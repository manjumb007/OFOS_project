package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Makemytrip_test {

	public static void main(String[] args) 
	
	{   String Monthandyear="January 2024";
	     int date = 29;
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Actions act = new Actions(driver);
		act.moveByOffset(40,40 ).click().perform();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
	String	actualdate="//div[text()='"+Monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
	String	nextArrow="//span[@aria-label='Next Month']";
		for(;;)
			try {
				driver.findElement(By.xpath(actualdate)).click();
				break;
			}
		catch(Exception e)
		{
			driver.findElement(By.xpath(nextArrow)).click();
		}
		
		

	}

}
