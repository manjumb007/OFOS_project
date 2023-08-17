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

public class Userlogin_page 
{
WebDriverUtility wLib= new WebDriverUtility();
	
	//declaration

		@FindBy(xpath = "//a[text()='Register']")
		private WebElement Register_link;
		
		@FindBy(name = "username")
		private WebElement usn_textfield;
		
		@FindBy(name = "firstname")
		private WebElement frstname_textfield;
		
		@FindBy(name ="lastname")
		private WebElement lastname_textfield;
		
		@FindBy(name = "email")
		private WebElement email_textfield;
		
		@FindBy(name = "phone")
		private WebElement phone_textfield;
		
		@FindBy(name = "password")
		private WebElement password_textfield;
		
		@FindBy(name = "cpassword")
		private WebElement cpassword_textfield;
		
		@FindBy(name = "address")
		private WebElement address_textfield;
		
		@FindBy(name = "submit")
		private WebElement submit_button;

		public WebDriverUtility getwLib() {
			return wLib;
		}

		public WebElement getRegister_link() {
			return Register_link;
		}

		public WebElement getUsn_textfield() {
			return usn_textfield;
		}

		public WebElement getFrstname_textfield() {
			return frstname_textfield;
		}

		public WebElement getLastname_textfield() {
			return lastname_textfield;
		}

		public WebElement getEmail_textfield() {
			return email_textfield;
		}

		public WebElement getPhone_textfield() {
			return phone_textfield;
		}

		public WebElement getPassword_textfield() {
			return password_textfield;
		}

		public WebElement getCpassword_textfield() {
			return cpassword_textfield;
		}

		public WebElement getAddress_textfield() {
			return address_textfield;
		}

		public WebElement getSubmit_button() {
			return submit_button;
		}
		
		// initialization
				public Userlogin_page(WebDriver driver) {
					PageFactory.initElements(driver, this);
				}

				// utilization
				
				
		public void reg_link()
		{
			Register_link.click();
			
		}
		

		JavaUtility jLib= new JavaUtility();
		
		
		public void enterAllField(HashedMap<String, String> map, WebDriver driver, JavaUtility jLib) 
		{
			for (Entry<String, String> set : map.entrySet())
			{
			if (set.getKey().contains("useraccounts2"))
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
			submit_button.click();
			
		}
	

}
