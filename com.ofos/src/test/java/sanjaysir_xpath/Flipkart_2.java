package sanjaysir_xpath;

import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_2 {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.get("https://www.flipkart.com/");
		
	    driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Samsung phones");
		driver.findElement(By.xpath("//*[name()='svg'][1]")).click();
		 List<WebElement> name = driver.findElements(By.xpath("//div[@class='col col-7-12']//div[@class='_4rR01T']"));
		System.out.println(name.size());
		 TreeSet<String> t = new TreeSet<String>();
		for(WebElement opt:name)
		{
			t.add(opt.getText());
		}
		for(String o:t)
		{
			System.out.println(o);
		}
		List<WebElement> prices=driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[@class='_30jeq3 _1_WHN1']"));
		System.out.println(prices.size());
		TreeSet<String> the=new TreeSet<String>();
		for(WebElement ele:prices)
		{		
			the.add(ele.getText());
		}
		for(String o1:the)
		{
			System.out.println(o1);
		}


	}

}
