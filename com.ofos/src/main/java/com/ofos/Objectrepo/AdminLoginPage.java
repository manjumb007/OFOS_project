package com.ofos.Objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ofos.GenericUtility.WebDriverUtility;

public class AdminLoginPage extends WebDriverUtility{



	// declaration

	@FindBy(name = "username")
	private WebElement UserName;

	@FindBy(name = "password")
	private WebElement PassWord;

	@FindBy(name = "submit")
	private WebElement LgnBtn;

	// Initialization

	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassWord() {
		return PassWord;
	}

	public WebElement getLgnBtn() {
		return LgnBtn;
	}

	
public void login(String UN,String PSWD )	
{
	
	UserName.sendKeys(UN);
	PassWord.sendKeys(PSWD);
	LgnBtn.click();
}
	

	
}




