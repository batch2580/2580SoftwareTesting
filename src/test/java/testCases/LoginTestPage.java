package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class LoginTestPage extends TestBase

{
      LoginPage login;  // globally decalre the variable
	
	   @BeforeMethod     (alwaysRun = true)                                               // write down all the pre conditions here
	   public void setUp() throws InterruptedException, IOException 
	   {
		   initialization() ;                                  // access the initialization() method
		   login= new LoginPage();                            // create the object of the respective page
		   
	   }
	   
	    @Test (enabled= true,/* priority = 1*/groups = {"sanity"})                                                      //Write down actual test cases
	         public void VerifyURLOfApplictionTest() throws EncryptedDocumentException, IOException               // copy the same method name and write only test next 
	  	   {
	  		   String expURL =ReadData.readExcel(1,0);                //  https://www.saucedemo.com/
	  		   String actURL =login.VerifyURLOfAppliction();
	  		  Assert.assertEquals(expURL, actURL);
	  	   }       
	    @Test  (enabled= true, /*priority = 2/* dependsOnMethods = "VerifyURLOfApplictionTest"*/groups = {"regression"} )     
	   public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException 
	   {
		   String expTitle=ReadData.readExcel(1,1);                  //Swag Labs(1,1)
		   String actTitle= login.verifyTitleOfApplication();
		  Assert.assertEquals(expTitle, actTitle);                       //take the 1st assert
	   }
	   @Test   (enabled= true, /*priority = 3 /* dependsOnMethods = "VerifyURLOfApplictionTest"*/ groups = { "retest","sanity"})     
	   public void LoginToApplicationTest() throws IOException
	   {
		   String expURL =ReadData.readExcel(1,2);                   //https://www.saucedemo.com/inventory.html(1,2)
  		   String actURL =login.LoginToApplication();
  		  Assert.assertEquals(expURL, actURL); 
	   }
	   
	   @AfterMethod  (alwaysRun = true)                                                      // used to close the driver same in all 
	 
	     public void CloseBrowser(ITestResult it) throws IOException            
	   
	   {
		   if(it.FAILURE==it.getStatus())
		   {
			   CaptureScreenShot.screenshot(it.getName());
		   }
		   driver.close();
	   }
	
}
