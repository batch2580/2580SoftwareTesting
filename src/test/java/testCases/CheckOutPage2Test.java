package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckOutPage2;
import pages.CheckoutPage1;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;

public class CheckOutPage2Test extends TestBase 
{
	LoginPage login;                                        // globally decalre the variable
	Inventory_Page invent;
	CartPage cart;
	CheckoutPage1 check1;
	CheckOutPage2 check2;
	
	@BeforeTest
	
	  public void setUp() throws InterruptedException, IOException 
	   {
		   initialization() ;                                 
		   login= new LoginPage();                             
		   invent = new Inventory_Page();  
		   cart = new CartPage();
		   check1 = new CheckoutPage1();
		   check2 = new CheckOutPage2();
		   login.LoginToApplication();  
		   invent.add6Products();
		   invent.ClickcartCount();
		   cart.clickCheckOutbtn();
		   check1.inputInfo();
		   
	   }
	@Test
	public void verifycheckoutpage2LableTest() throws EncryptedDocumentException, IOException
	{
		String expLable =ReadData.readExcel(1,10);                //Checkout: Overview
		   String actLable =check2.verifycheckoutpage2Lable();
		  Assert.assertEquals(expLable, actLable);
		  Reporter.log("Lable of applicatopn = "+actLable );
	}
	@Test
	public void verifypaymentInfoLableTest() throws EncryptedDocumentException, IOException
	{
		String expLable =ReadData.readExcel(1,11);                //Payment Information
		   String actLable =check2.verifypaymentInfoLable();
		  Assert.assertEquals(expLable, actLable);
		  Reporter.log("Lable of paymnet Info applicatopn = "+actLable );
	}
	
	@AfterTest                                                 
	  
	 public void CloseBrowser()            
	   
	   {
		 driver.close();
	   }
	
}
