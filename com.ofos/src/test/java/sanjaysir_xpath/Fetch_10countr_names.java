package sanjaysir_xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fetch_10countr_names {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		
		List<WebElement> country_names = driver.findElements(By.xpath("(//table//tr[*]//td[2]//span[2])[position()<11]"));
		for(int i=0;i<country_names.size();i++)
		{
			
		System.out.println(country_names.get(i).getText());
		}
	}

}
