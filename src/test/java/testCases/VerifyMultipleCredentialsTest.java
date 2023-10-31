package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class VerifyMultipleCredentialsTest extends TestBase
{
	 LoginPage login;
	 
	 @BeforeMethod  (alwaysRun= true)                                                  
	   public void setUp() throws InterruptedException, IOException 
	   {
		   initialization() ;                                 
		   login= new LoginPage();                           
	   }
	 @Test(dataProvider = "credentials")
	 public void LoginToApplicationWithMultipleDataTest(String un, String pass) throws IOException
	   {
	       //Assert.assertEquals(expURL, actURL); // hard Assert
		 
		   SoftAssert s = new SoftAssert();       // soft assert
		   String expURL =" https://www.saucedemo.com/inventory.html";                 
		   String actURL =login.LoginToApplicationWithMultipleData(un, pass);
		   s.assertEquals(expURL, actURL);
		   s.assertAll();
		  
	   } 
	  @DataProvider(name = "credentials")                                  // provide the data to our test case execution(name input tag)
	  public Object [] [] getData()                                              // arrays used in data providers
	  {
		  return new Object [][]
				  {
			  
			     {"standard_user","secret_sauce"},   //Right userNme and RightPassword
			     {"locked_out_user","secret_sauce"},  
			     {"problem_user","secret_sauce"},  
			     {"performance_glitch_user","secret_sauce"}    
			     
				  };
	
	  }
	  
	  
	  @AfterMethod    (alwaysRun= true )                                                       // used to close the driver same in all 
		 
	     public void CloseBrowser(ITestResult it) throws IOException            
	   
	   {
		   if(it.FAILURE==it.getStatus())
		   {
			   CaptureScreenShot.screenshot(it.getName());
		   }
		   report.flush();
		   driver.close();
	   }

}
