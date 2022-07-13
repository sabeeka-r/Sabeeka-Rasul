package com.restassured.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.restassured.utils.TestUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListeners implements ITestListener {
    TestUtils utils;
    File src;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    public TestListeners(){
        utils = new TestUtils();
    }

    public ExtentReports setupExtentReporter(){
        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") +
                File.separator + "html-report/ExecutionReport_"+utils.getDateTime()+".html" );
        extentReports.attachReporter(sparkReporter);

        sparkReporter.config().setDocumentTitle("Document Title");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Regression Test Results");
        return extentReports;
    }


    @Override
    public void onTestStart(ITestResult result)
    {
        //Before the start of tests
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        extentTest.log(Status.PASS,"Test Case:" + result.getMethod().getMethodName() + "passed");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        extentTest.log(Status.FAIL,"Test Case:" + result.getMethod().getMethodName() + "failed");
        extentTest.log(Status.FAIL, result.getThrowable());
        result.getThrowable().printStackTrace();
    }

    @Override
    public void onTestSkipped(ITestResult result)
    { /* compiled code */ }

    @Override
    public void onTestFailedWithTimeout(ITestResult result)
    { /* compiled code */ }

    @Override
    public void onStart(ITestContext context)
    {
        // setup the extent report here
        extentReports = setupExtentReporter();
    }

    @Override
    public void onFinish(ITestContext context)
    {
        // closing the report
        extentReports.flush();
    }



    public void loggerPass(String testCaseMessage, String APIResponse)
    {
        extentTest.getExtent();
        Markup m = MarkupHelper.createLabel(testCaseMessage, ExtentColor.ORANGE);
        extentTest.log(Status.PASS, m);
        extentTest.log(Status.PASS, MarkupHelper.createCodeBlock(APIResponse, CodeLanguage.JSON));

    }

}
