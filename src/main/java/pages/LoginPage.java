package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
  {
	// object repository(x path) to indentify the element
	@FindBy (xpath = "//input[@id='user-name']") private WebElement userNameTextBox;
	@FindBy (xpath = "//input[@id='password']")   private WebElement passwordTextBOX;
	@FindBy(xpath = "//input[@type='submit']")   private WebElement loginBtn;
	
	//user defined constructor to initialize the web element(current class) it does not have dataType
	//this refer to respective current object
	//page factory class(findby and initi element givent by page factory)(inti element helps for initialise element) 
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	//method to login in the application
	public String LoginToApplication() throws IOException
	{
		logger = report.createTest("Login to sauce lab APPlipcation");
		userNameTextBox.sendKeys(ReadData.readPropertyFile("UserName"));
		logger.log(Status.INFO, "usename is entered");
		passwordTextBOX.sendKeys(ReadData.readPropertyFile("Password"));
		logger.log(Status.INFO, "password id entered");
		loginBtn.click();
		logger.log(Status.INFO, "login button is clicked");
		logger.log(Status.PASS, "Login is sucessful");
		return driver.getCurrentUrl();
	}
	public String LoginToApplicationWithMultipleData(String un,String pass)
	{
		userNameTextBox.sendKeys(un);
		passwordTextBOX.sendKeys(pass);
		loginBtn.click();
		
		return driver.getCurrentUrl();
		
	}
	
    public String verifyTitleOfApplication()
    { 
    return driver.getTitle();
	
    }
    public String VerifyURLOfAppliction()
    
    {
		return driver.getCurrentUrl();
    	
    }
    
    
    
   }
