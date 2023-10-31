package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutPage1 extends TestBase
{
	@FindBy (xpath="//span[@class='title']")  WebElement checkOut1Title;
	@FindBy (xpath="//input[@id='first-name']")  WebElement firstNameBox;
	@FindBy (xpath="//input[@id='last-name']")  WebElement lastNameBox;
	@FindBy (xpath ="//input[@id='postal-code']")  WebElement postalCodeBox;
	@FindBy (xpath="//input[@type='submit']") WebElement continueBtn;
	public CheckoutPage1()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
		
	}
	public String verifyTitleOfApplication()
	{
		return checkOut1Title.getText();
		
	}
	public String inputInfo()
	{
		 firstNameBox.sendKeys("kiran");
		 lastNameBox.sendKeys("ragade");
		 postalCodeBox.sendKeys("430032");
		 continueBtn.click();
		return driver.getCurrentUrl();
		
	}
	

}
