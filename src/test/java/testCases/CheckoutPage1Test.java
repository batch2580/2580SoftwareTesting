package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckoutPage1;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;

public class CheckoutPage1Test extends TestBase
{
	LoginPage login;                                        // globally decalre the variable
	Inventory_Page invent;
	CartPage cart;
	CheckoutPage1 check1;
	@BeforeTest
	
	  public void setUp() throws InterruptedException, IOException 
	   {
		   initialization() ;                                 
		   login= new LoginPage();                             
		   invent = new Inventory_Page();  
		   cart = new CartPage();
		   check1 = new CheckoutPage1();
		   login.LoginToApplication();  
		   invent.add6Products();
		   invent.ClickcartCount();
		   cart.clickCheckOutbtn();
		  
	   }
	@Test
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL =ReadData.readExcel(1,7);                //https://www.saucedemo.com/checkout-step-one.html
		   String actURL =check1.verifyURLOfApplication();
		  Assert.assertEquals(expURL, actURL);
		  Reporter.log("URL of applicatopn = "+actURL );
	}
	@Test
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{ 
		String expTitle = ReadData.readExcel(1, 8);         //Checkout: Your Information
		String actTitle = check1.verifyTitleOfApplication();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("application Title = "+actTitle ); 
	}
	@Test
	public void inputInfoTest() throws EncryptedDocumentException, IOException                       //https://www.saucedemo.com/checkout-step-two.html
	{
		 String expURL =ReadData.readExcel(1,9);                //https://www.saucedemo.com/checkout-step-one.html
		   String actURL =check1.inputInfo();
		  Assert.assertEquals(expURL, actURL);
		  Reporter.log("URL of applicatopn = "+actURL );
		
	}
	@AfterMethod
	  public void CloseBrowser()            //
	   
	   {
		   driver.close();
	   }
	
}
