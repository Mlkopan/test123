package com.Mainframe.Screens;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 
 */

/**
 * @author manoj
 *
 */

import net.sf.f3270.FieldIdentifier;
import net.sf.f3270.Terminal;
import net.sf.f3270.TerminalModel;
import net.sf.f3270.TerminalType;
import net.sf.f3270.junit.rules.TerminalResource;
public class Test {
	//builds a new report using the html template 
    ExtentHtmlReporter htmlReporter;
    
    ExtentReports extent;
    //helps to generate the logs in test report.
    ExtentTest test;
    MediaEntityModelProvider mediaModel;

	@Parameters({ "OS", "browser" })
	//public static void main (String args[]) throws Throwable
	public void Mainframe (String hostname) throws Throwable
	{
		CaptureSnapShot capture = new CaptureSnapShot();
	    htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Automation/testReport.html");
        extent = new ExtentReports();        
        extent.attachReporter(htmlReporter); 
        extent.setSystemInfo("OS", "OS");
        extent.setSystemInfo("Browser", "browser");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        test = extent.createTest("MainframeTest1", "Sample test for Freddie");       
     
		TerminalResource terminal = new TerminalResource().withHost(hostname)
				.withPort(3270).withMode(TerminalModel.MODE_80_24)
				.withType(TerminalType.TYPE_3279)
				.pathToClient("C:\\Mainframe\\Mainframe\\s3270")
				.showTerminalWindow(true);
		    terminal.connect();
		    terminal.getDriver().enter();
		    terminal.getDriver().write("herc01");	 	    
		   
		    MediaEntityBuilder.createScreenCaptureFromPath(capture.snapshot()).build();
		    test.pass("Connect Mainframe", mediaModel);	    
		           
		    terminal.getDriver().enter();
		    terminal.getDriver().write("cul8tr");
		    terminal.getDriver().enter();
		    terminal.getDriver().enter();
		    terminal.getDriver().enter();
		    terminal.getDriver().write(new FieldIdentifier("Option ===>"), "1");
		    MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(capture.snapshot()).build();
		    test.pass("Select Option ===> 1", mediaModel);  
		 
		    terminal.getDriver().enter();
		    terminal.getDriver().write(new FieldIdentifier("COMMAND ===>"), "2");
		    mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(capture.snapshot()).build();
		    test.pass("COMMAND ===> 2", mediaModel);
		    terminal.getDriver().enter();
		    terminal.getDriver().pf(3);
		    terminal.getDriver().write(new FieldIdentifier("COMMAND ===>"), "X");
		    mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(capture.snapshot()).build();
		    test.pass("COMMAND ===> X", mediaModel);
		    terminal.getDriver().enter();
		    terminal.getDriver().write(new FieldIdentifier("Option ===>"), "X");
		    mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(capture.snapshot()).build();
		    test.pass("Option === X", mediaModel);
		    terminal.getDriver().enter();
		    terminal.getDriver().clear();
		    terminal.getDriver().write("LOGOFF");
		   Thread.sleep(1000);
		    mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(capture.snapshot()).build();
		    test.pass("LOGOFF", mediaModel);
		    terminal.getDriver().enter();		     
		    terminal.getDriver().disconnect();
		    extent.flush();
		    System.out.println("Manoj");    		
	}
} 

