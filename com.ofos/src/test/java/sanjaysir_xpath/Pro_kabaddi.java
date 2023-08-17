package sanjaysir_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pro_kabaddi {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.prokabaddi.com/standings");
		String team = "Bengaluru Bulls";
	 String played = driver.findElement(By.xpath("//p[.='"+team+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-play']/p")).getText();
 String won = driver.findElement(By.xpath("//p[.='"+team+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-won']/p")).getText();
             
System.out.println("played-->"+played+"  won---> "+won);
		
	

}
}
