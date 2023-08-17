package sanjaysir_xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICC_table {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> data = driver.findElements(By.xpath("//span[.='Team']/ancestor::table"));
		
		for(int i=0;i<data.size();i++)
			
		{
			System.out.println(data.get(i).getText());
		}
		
	}

}
