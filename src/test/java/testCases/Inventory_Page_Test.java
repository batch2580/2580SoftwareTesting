package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;

public class Inventory_Page_Test extends TestBase


   {
	
	LoginPage login;                                        // globally decalre the variable
	Inventory_Page invent;
	
	@BeforeTest (alwaysRun = true)
	
	  public void setUp() throws InterruptedException, IOException 
	   {
		   initialization() ;                                  // access the initialization() method
		   login= new LoginPage();                              // create the object of the respective page
		   invent = new Inventory_Page();            
		   login.LoginToApplication();                         // to call the login method
	   }
	@Test      (enabled= true,groups = {"retest"}, invocationCount = 3)      //invocationCount means it run 3 times                                            //Actual test cases write down 
	  public void verifyProductLableTest() throws EncryptedDocumentException, IOException                     // copy the same method name and write only test next 
	  {
		String expLable = ReadData.readExcel(1, 3);        //Products
		String actLable = invent.verifyProductLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("application Lable = "+actLable );             // given more explanation baout our report
		
	  }
	@Test  (enabled= true,groups = {"regression"}, timeOut = 5000)  //timeOut it wait for 5 sec to load web element and then execute testCase
	public void verifyTwitterLogoTest()
	{
		boolean result = invent.verifyTwitterLogo();         // boolean used for logo and image 
		Assert.assertEquals(result, true);
		Reporter.log("Visibility Of Twiiter Logo = "+result );
	}
	@Test (enabled= true,groups = {"retest"," sanity"})       
	public void add6ProductsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount = ReadData.readExcel(1,4);             //6
		String actCount= invent.add6Products();
	//	Assert.assertEquals(expCount, actCount);
		Reporter.log("Total product added into the cart = " + actCount );
		
	}
	
	@AfterTest      (alwaysRun = true)                                            
	  
	 public void CloseBrowser()            
	   
	   {
		 driver.close();
	   }
	
    }
