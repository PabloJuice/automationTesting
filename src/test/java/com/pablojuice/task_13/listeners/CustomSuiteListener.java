package com.pablojuice.task_13.listeners;

import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class CustomSuiteListener implements ISuiteListener {

	private final Logger LOGGER = Logger.getLogger(this.getClass());

	@Override
	public void onStart(ISuite suite) {
		LOGGER.info(suite.getName());
	}

	@Override
	public void onFinish(ISuite suite) {
		LOGGER.info(suite.getName());
	}
}
