package com.ofos.Objectrepo;

import java.util.Map.Entry;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ofos.GenericUtility.JavaUtility;
import com.ofos.GenericUtility.WebDriverUtility;

public class Add_restaurant_page 
{
    WebDriverUtility wLib= new WebDriverUtility();
	
//declaration

	@FindBy(name="res_name")
	private WebElement Restaurantnametextfield;

	@FindBy(name="email")
	private WebElement Restauranemailtextfield;

	@FindBy(name="phone")
	private WebElement Restaurantphonetextfield;

	@FindBy(name="url")
	private WebElement Restauranturltextfield;

	@FindBy(name="o_hr")
	private WebElement Restaurantopen_hours;

	@FindBy(name="c_hr")
	private WebElement Restaurantclose_hours;

	@FindBy(name="o_days")
	private WebElement Restaurant_opendays;

	@FindBy(name="c_name")
	private WebElement Restaurant_category;

	@FindBy(name="file")
	private WebElement Restaurant_logo;

	@FindBy(name="address")
	private WebElement Restaurant_address;

	@FindBy(name="submit")
	private WebElement Savebutton;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/div[3]/div/div[1]")
	private WebElement Restaurantconfirmmsg;

	

	public WebElement getRestaurantconfirmmsg() {
		return Restaurantconfirmmsg;
	}

	public JavaUtility getjLib() {
		return jLib;
	}

	public WebDriverUtility getwLib() {
	return wLib;
}

	public WebElement getSavebutton() {
		return Savebutton;
	}

	

	public WebElement getRestaurantnametextfield() {
		return Restaurantnametextfield;
	}

	public WebElement getRestauranemailtextfield() {
		return Restauranemailtextfield;
	}

	public WebElement getRestaurantphonetextfield() {
		return Restaurantphonetextfield;
	}

	public WebElement getRestauranturltextfield() {
		return Restauranturltextfield;
	}

	public WebElement getRestaurantopen_hours() {
		return Restaurantopen_hours;
	}

	public WebElement getRestaurantclose_hours() {
		return Restaurantclose_hours;
	}

	public WebElement getRestaurant_opendays() {
		return Restaurant_opendays;
	}

	public WebElement getRestaurant_category() {
		return Restaurant_category;
	}

	public WebElement getRestaurant_logo() {
		return Restaurant_logo;
	}

	public WebElement getRestaurant_address() {
		return Restaurant_address;
	}
	
	// initialization
		public Add_restaurant_page(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		// utilization
	public void opendrp(String opentime) {
		Restaurantopen_hours.click();

		wLib.selectbytext(opentime, Restaurantopen_hours);

		}

		public void closedrp(String closetime) {
			Restaurantclose_hours.click();
		wLib.selectbytext(closetime, Restaurantclose_hours);

		}

		public void openday(String opendays) {
			Restaurant_opendays.click();
		wLib.selectbytext(opendays, Restaurant_opendays);

		}
		
		public void category(String catg)
		{
			Restaurant_category.click();
			wLib.selectbytext(catg, Restaurant_category);
		}
		
		public void rest_logo(String img_path) {
			Restaurant_logo.sendKeys(img_path);
			
		}
		
		
		
		JavaUtility jLib= new JavaUtility();
		
		
		public void enterAllField(HashedMap<String, String> map, WebDriver driver, JavaUtility jLib) 
		{
			for (Entry<String, String> set : map.entrySet())
			{
			if (set.getKey().contains("Restaurants"))
			{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue() + jLib.getRandomnum());
			} 
			else 
			{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
			}
			
		}
		
		public void submit()
		{  
			Savebutton.click();
			
		}
		
			public void confirmmsg()
			{
				String msg = Restaurantconfirmmsg.getText();
				System.out.println(msg);
			}
	
			
			
		
//Business libraries
	
	




}
