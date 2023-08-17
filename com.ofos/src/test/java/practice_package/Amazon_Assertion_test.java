package practice_package;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Assertion_test 
{
@Test
public void amazon()
{
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("https://www.amazon.in/");
	String expect = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	String actual = driver.getTitle();
	System.out.println(actual);
	assertEquals(actual, expect);
	System.out.println("actual and exp both are matching");
	
	
	
}
}
