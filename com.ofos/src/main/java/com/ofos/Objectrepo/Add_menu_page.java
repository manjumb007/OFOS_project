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

public class Add_menu_page 
{
	
	WebDriverUtility wLib= new WebDriverUtility();
	
	//declaration

		@FindBy(name="d_name")
		private WebElement dishnametextfield;
		
		@FindBy(name="about")
		private WebElement desctextfield;
		
		@FindBy(name="price")                                      
		private WebElement pricetextfield;             


		@FindBy(name="file")
		private WebElement fileupload;
		
		@FindBy(name="res_name")
		private WebElement restoname_DD;
		
		@FindBy(name="submit")
		private WebElement submit_btn;
		
		@FindBy(xpath="//*[@id=\"example23\"]/tbody/tr[1]/td[6]/a[1]")
		private WebElement delete_icon;
		
		

		public WebElement getDelete_icon() {
			return delete_icon;
		}

		public WebDriverUtility getwLib() {
			return wLib;
		}

		public WebElement getDishnametextfield() {
			return dishnametextfield;
		}

		public WebElement getDesctextfield() {
			return desctextfield;
		}

		public WebElement getPricetextfield() {
			return pricetextfield;
		}

		public WebElement getFileupload() {
			return fileupload;
		}

		public WebElement getRestoname_DD() {
			return restoname_DD;
		}

		public WebElement getSubmit_btn() {
			return submit_btn;
		}
		
		
		// initialization
				public Add_menu_page(WebDriver driver) {
					PageFactory.initElements(driver, this);
				}
				
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
			
			public void restaurant(String catg)
			{
				restoname_DD.click();
				wLib.selectbytext(catg, restoname_DD);
			}
			
			public void rest_logo(String img_path) {
				fileupload.sendKeys(img_path);
				
			}

		
		public void submit()
		{
			
			submit_btn.click();
			
		}
		
public void delete()
{
	delete_icon.click();
}


}
