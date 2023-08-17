package sanjaysir_xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_fetchname_and_price {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		
		WebElement sb = driver.findElement(By.xpath("//input[@type='text']"));
		sb.sendKeys("samsung mobiles");
		sb.submit();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
	
		
		
		List<WebElement> m_name = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> m_price = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[@class='_30jeq3 _1_WHN1']"));
		
		
		
		for(int i=0;i<m_name.size();i++)
		{
			System.out.println(m_name.get(i).getText()+"--------->"+m_price.get(i).getText());
		}

	}

}          
