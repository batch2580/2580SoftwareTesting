package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReportManager;
import utility.ReadData;

public class TestBase 
    {
	  public ExtentReports report = ExtentReportManager.getReportInstance();
	  public ExtentTest logger;
	  public static  WebDriver driver;
      public void initialization() throws InterruptedException, IOException
    {
    	  String browser = ReadData.readPropertyFile("Browser");
    //	  String browser = "chrome";
    	  // CROSS BROWSER COMPATIBILITY
    	  if(browser.equalsIgnoreCase("chrome"))
    	  {
    		  WebDriverManager.chromedriver().setup();
    		  driver = new ChromeDriver();
    	  }
    	  else if(browser.equalsIgnoreCase("firefox"))
    		  
    	  {
    		  WebDriverManager.firefoxdriver().setup();
    		  driver = new FirefoxDriver();
    		  
    	  }
    	  else if(browser.equalsIgnoreCase("edge"))
    	  {
    		  WebDriverManager.edgedriver().setup();
    		  driver = new EdgeDriver();
    	  }
    	  
    	  
	    driver.manage().window().maximize();
	    driver.get(ReadData.readPropertyFile("URL"));
	    driver.manage().deleteAllCookies();
	    Thread.sleep(4000);
	    
	    //<class name="testCases.CheckOutPage1Test"/>
	   // <class name="testCases.CheckOutPage2Test"/>
	  //  <class name="testCases.CartPageTest"/>
	  //  <class name="testCases.VerifyMultipleCredentialsTest"/>
    }
 
 
    }
