package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class ExtentReportManager extends TestBase

{
    static ExtentReports report;
    
	public static ExtentReports getReportInstance()
	
	{
		if(report==null)
		{
			String reportName = new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumFramework26\\ExtentReports"+reportName+".html");
		    report = new ExtentReports();
		    report.attachReporter(htmlReporter);
		    report.setSystemInfo("OS", "window");
		    report.setSystemInfo("Environment", "SIT");
		    report.setSystemInfo("Build Number", "102.02.02.123");
		    report.setSystemInfo("Browser", "chrome");
		    htmlReporter.config().setDocumentTitle("UI Teting Document");
		    htmlReporter.config().setReportName("UI Test Reports");
		    
		}
		
		return report;
	}
}
