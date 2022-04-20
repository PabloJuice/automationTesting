package com.pablojuice.task_12.decorators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public abstract class WebTestElement {
	protected static final Logger logger = Logger.getLogger(WebTestElement.class);
	protected final WebElement webElement;

	protected WebTestElement(WebElement webElement) {
		this.webElement = webElement;
	}
}
