package sanjaysir_xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Country_30match {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		
		List<WebElement> countries = driver.findElements(By.xpath("//span[@class='u-hide-phablet']"));
		List<WebElement> matches = driver.findElements(By.xpath("//span[@class='u-hide-phablet']/../following-sibling::td[1][text()>30]"));
		
		
		for(int i=0;i<matches.size();i++)
		{
			System.out.println(countries+"------->"+matches);
		}
		

	}

}
