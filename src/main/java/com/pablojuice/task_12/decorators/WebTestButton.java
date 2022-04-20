package com.pablojuice.task_12.decorators;

import org.openqa.selenium.WebElement;

public class WebTestButton extends WebTestElement {

	public WebTestButton(WebElement webElement) {
		super(webElement);
	}

	public void press() {
		logger.info("Button " + "'" + webElement.getText() + "'" + " pressed");
		webElement.click();
	}

	public boolean isActive() {
		return webElement.isEnabled();
	}
}
