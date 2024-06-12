package com.comcast.crm.listenerutility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImplementation extends BaseClass implements ITestListener, ISuiteListener  {

	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report configuration");
		String time = new Date().toString().replace(" ","_").replace(":","_  ");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Win-11");
		report.setSystemInfo("Browser", "Chrome-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=====>"+result.getMethod().getMethodName()+"<====START====");
	    test = report.createTest(result.getMethod().getMethodName());
	    UtilityClassObject.setTest(test);
	    test.log(Status.INFO, result.getMethod().getMethodName()+"====>STARTED<====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=====>"+result.getMethod().getMethodName()+"<====END====");
		test.log(Status.PASS, result.getMethod().getMethodName()+"====>COMPLETED<====");
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		//System.out.println(testName);
		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
		String filePath=ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ","_").replace(":","_  ");
		//System.out.println(sdriver.getTitle());
		test.addScreenCaptureFromBase64String(filePath,testName+"_"+time+"====>FAILED<====");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test.log(Status.PASS, result.getMethod().getMethodName()+"====>SKIPPED<====");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
