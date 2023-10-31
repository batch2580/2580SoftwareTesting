package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase

{
	@FindBy (xpath = "//span[@class='title']") private WebElement titleofCartPage; 
	@FindBy(xpath="//button[@id='checkout']") private WebElement checkOutBtn ;
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyURLofApplication()
	{
		return driver.getCurrentUrl();
		
	}
	public String verifyTitleCartPage()
	{
		return titleofCartPage.getText();
		
	}
	public void clickCheckOutbtn()           // void keyword does not have any return value(only we need to click here
	{
		checkOutBtn.click();
	}

}
