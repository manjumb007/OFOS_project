package practice_package;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenlinks_2 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testhtml5.vulnweb.com");
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		List<WebElement> listlinks = driver.findElements(By.xpath("//a"));
		System.out.println(listlinks.size());

		ArrayList<String> links=new ArrayList<String>();

		for (int i = 0; i < listlinks.size(); i++)
		{
			String eachLink=listlinks.get(i).getAttribute("href");
			URL url=null;
			int statusCode=0;
			try {
				url=new URL(eachLink);
	HttpURLConnection HttpURLConnection=(HttpURLConnection) url.openConnection();
				statusCode = HttpURLConnection.getResponseCode();
				if(statusCode>=400)
				{
					links.add(eachLink+"=========>"+statusCode);
				}
			}
			catch (Exception e) {
				links.add(eachLink+"=========>"+statusCode);
			}

		}
		System.out.println(links);



	}

}



