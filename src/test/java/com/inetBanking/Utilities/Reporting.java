package com.inetBanking.Utilities;
//Listener class used to generate extent reports
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.*;

public class Reporting extends TestListenerAdapter{
	
	ExtentReports extent;
	ExtentTest logger;
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-"+timeStamp+".html";
		
		ExtentSparkReporter Reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		/*try {
			Reporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		extent = new ExtentReports();
		extent.attachReporter(Reporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "tukku");
		
		Reporter.config().setDocumentTitle("InetBanking Test Project");
		Reporter.config().setReportName("Functional Test Reporter");
		//Reporter.config().setTestViewChartLocation(ChartLocation.Top);
		Reporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f = new File(screenshotPath);
		
		if(f.exists())
		{
			
				logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(screenshotPath));
			
			
		}
	}
	public void onTestSkipped(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
	

}
