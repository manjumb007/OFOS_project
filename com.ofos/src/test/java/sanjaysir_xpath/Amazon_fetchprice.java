package sanjaysir_xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_fetchprice {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in");
		WebElement sb = driver.findElement(By.id("twotabsearchtextbox"));
		sb.sendKeys("iphone");
		sb.submit();
		 List<WebElement> prices = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole'][number(translate(text(),'₹,',''))<70000]"));
		
		for(int i=0;i< prices.size();i++)
		{
			System.out.println(prices.get(i).getText());
			
		}
		

	}

}
