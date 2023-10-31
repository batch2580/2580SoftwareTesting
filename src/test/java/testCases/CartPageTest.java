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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;

public class CartPageTest extends TestBase
{
	LoginPage login;                                        // globally decalre the variable
	Inventory_Page invent;
	CartPage cart;
	@BeforeTest
	
	  public void setUp() throws InterruptedException, IOException 
	   {
		   initialization() ;                                 
		   login= new LoginPage();                             
		   invent = new Inventory_Page();  
		   cart = new CartPage();
		   login.LoginToApplication();  
		   invent.add6Products();
		   invent.ClickcartCount();
	   }
     @Test
     public void verifyURLofApplicationTest() throws EncryptedDocumentException, IOException
     {
    	 String expURL =ReadData.readExcel(1, 5);       //https://www.saucedemo.com/cart.html
    	 String actURL =cart.verifyURLofApplication();
 	 Assert.assertEquals(expURL, actURL);
    	 Reporter.log("URL of cart page = " +actURL);
     }
     @Test
     public void verifyTitleCartPageTest() throws EncryptedDocumentException, IOException
     {
    	 String expTitle = ReadData.readExcel(1, 6);  //Your Cart
    	 String actTitle= cart.verifyTitleCartPage();
    	 Assert.assertEquals(expTitle, actTitle);
    	 Reporter.log("Title of cart page = " +actTitle);
     }
     
     @AfterMethod
     
     public void CloseBrowser()            
	   
	   {
    	 driver.close();
	   }
}
