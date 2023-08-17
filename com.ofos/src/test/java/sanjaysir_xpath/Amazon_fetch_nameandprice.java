package sanjaysir_xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_fetch_nameandprice {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in");
		WebElement sb = driver.findElement(By.id("twotabsearchtextbox"));
		sb.sendKeys("iphone");
		sb.submit();
		
		List<WebElement> m_name = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'] "));
		List<WebElement> m_price = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole']"));

		for(int i=0;i<m_name.size();i++)
		{
			System.out.println(m_name.get(i).getText()+"-------->"+m_price.get(i).getText());
		}
	}

}
