package com.pablojuice.task_12.decorators;

import org.openqa.selenium.WebElement;

public class WebTestInput extends WebTestElement {

	public WebTestInput(WebElement webElement) {
		super(webElement);
	}

	public void fillWith(String value) {
		logger.info("Sent value to input: " + "'" + webElement.getAccessibleName() + "'" + ", value: " + value);
		webElement.sendKeys(value);
	}
}
