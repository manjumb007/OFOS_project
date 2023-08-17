package com.ofos.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener_impleclass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result)
	{
		//execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"----------->testscript execution started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"=====>passed");
		Reporter.log(MethodName+"----------->testscript passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		/*EventFiringWebDriver edriver = new EventFiringWebDriver(Baseclass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/FailedScript.png");
		
		try
		{
			FileUtils.copyFile(src, dst);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		*/
		String failed = result.getMethod().getMethodName()+new JavaUtility().getSystemDateInFormat();
		EventFiringWebDriver edriver = new EventFiringWebDriver(Baseclass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/failedscript.png");
		try
		{
			FileUtils.copyFile(src, dst);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, failed+"=====>failed");
		test.log(Status.FAIL,result.getThrowable());
		Reporter.log(failed+"=======>>testscript failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"=====>skipped");
		test.log(Status.SKIP,result.getThrowable());
		Reporter.log(MethodName+"----------->testscript skipped");
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		//create html report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/Report.html");
		htmlreport.config().setDocumentTitle("SDET50");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("OFOS");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS","Windows");
		report.setSystemInfo("Base-Browser","Chrome");
		report.setSystemInfo("Base-URL","http://rmgtestingserver/domain/Online_Food_Ordering_System/admin");
		report.setSystemInfo("reporter name","Manjunath");
	
	}

	@Override
	public void onFinish(ITestContext context)
	{
		//consolidate the report
		
		report.flush();
		
	}
	
	
	
	
	

}
