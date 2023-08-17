package com.ofos.Objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ofos.GenericUtility.WebDriverUtility;

public class Dashboard_page {

	// declaration
	@FindBy(xpath = "//span[.='Users']")
	private WebElement UsersBtn;

	@FindBy(xpath = "//span[.='Restaurant']")
	private WebElement RestaurantBtn;

	@FindBy(xpath = "//a[.='All Restaurant']")
	private WebElement Allrestaurant;

	@FindBy(xpath = "//a[.='Add Category']")
	private WebElement Allcategory;

	@FindBy(xpath = "//a[.='Add Restaurant']")
	private WebElement Addrestaurant;

	@FindBy(xpath = "//span[.='Menu']")
	private WebElement Menubtn;

	@FindBy(xpath = "//a[.='All Menues']")
	private WebElement Allmenu;

	@FindBy(xpath = "//a[.='Add Menu']")
	private WebElement AddmenuBtn;

	@FindBy(xpath = "//span[.='Orders']")
	private WebElement OrdersBtn;
	
	public WebElement getProfileBtn() {
		return profileBtn;
	}
	@FindBy(xpath = "//img[@class='profile-pic']")
	private WebElement profileBtn;
	
	
	@FindBy(xpath = "//*[@id=\"main-wrapper\"]/div[1]/nav/div[2]/ul[2]/li[2]/a/img")
	private WebElement logoutBtn;

	// initialization
	public Dashboard_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebDriverUtility getwLib() {
		return wLib;
	}

	public WebElement getUsersBtn() {
		return UsersBtn;
	}

	public WebElement getRestaurantBtn() {
		return RestaurantBtn;
	}

	public WebElement getAllrestaurant() {
		return Allrestaurant;
	}

	public WebElement getAllcategory() {
		return Allcategory;
	}

	public WebElement getAddrestaurant() {
		return Addrestaurant;
	}

	public WebElement getMenubtn() {
		return Menubtn;
	}

	public WebElement getAllmenu() {
		return Allmenu;
	}

	public WebElement getAddmenuBtn() {
		return AddmenuBtn;
	}

	public WebElement getOrdersBtn() {
		return OrdersBtn;
	}

//Business libraries
WebDriver driver;	
public void addnewrestaurant()
{
	RestaurantBtn.click();
	Addrestaurant.click();
	
}


public void addnewmenu()
{
	Menubtn.click();
	AddmenuBtn.click();
	
}
public void dltmenu()
{
	Menubtn.click();
	Allmenu.click();
	
}
WebDriverUtility wLib = new WebDriverUtility();

public void logout()
{
	profileBtn.click();
	//wLib.mousehover(driver, logoutBtn);
	logoutBtn.click();
}



}


