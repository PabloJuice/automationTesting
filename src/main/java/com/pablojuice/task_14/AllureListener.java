package com.pablojuice.task_14;

import com.pablojuice.drivers.DriverManager;
import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class AllureListener implements ITestListener {
	private static final Logger LOGGER = Logger.getLogger(AllureListener.class);

	@Override
	public void onTestStart(ITestResult result) {
		LOGGER.debug("onTestStart");
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		LOGGER.debug("onTestSuccess");
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		LOGGER.debug("onTestFailure");
		ITestListener.super.onTestFailure(result);
		takeScreenshot();
		getSourceTree();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LOGGER.debug("onTestSkipped");
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		LOGGER.debug("onTestFailedButWithinSuccessPercentage");
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		LOGGER.debug("onTestFailedWithTimeout");
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		LOGGER.debug("onStart");
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		LOGGER.debug("onFinish");
		ITestListener.super.onFinish(context);
	}

	private void takeScreenshot() {
		Allure.addAttachment(
				"Page screenshot",
				new ByteArrayInputStream(
						((TakesScreenshot) DriverManager.getChromeDriver()).getScreenshotAs(OutputType.BYTES)
				)
		);
	}

	private void getSourceTree() {
		Allure.addAttachment("DOM Tree", DriverManager.getChromeDriver().getPageSource());
	}
}
