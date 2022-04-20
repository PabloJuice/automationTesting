package com.pablojuice.task_13.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {
	private final Logger LOGGER = Logger.getLogger(this.getClass());

	@Override
	public void onTestStart(ITestResult result) {
		LOGGER.info(result.getName() + "START");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		LOGGER.info(result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		LOGGER.info(result.getName() + " failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LOGGER.info(result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		LOGGER.info(result.getName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		LOGGER.info(result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		LOGGER.info(context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		LOGGER.info(context.getName());
	}
}
