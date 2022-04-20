package com.pablojuice.task_11.elements;

import com.pablojuice.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class InstagramMainPagePO {

	@FindBy(xpath = "//*[@id=\"react-root\"]/section/nav")
	WebElement header;
	private final WebDriver chromeDriver = DriverManager.getChromeDriver();

	public InstagramMainPagePO() {
		PageFactory.initElements(DriverManager.getChromeDriver(), this);
	}

	public void verifyLogin() {
		WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//*[@id=\"react-root\"]/section/nav")));
		} catch (TimeoutException e) {
			Assert.fail("Login failed");
		}
		Assert.assertTrue(header.isDisplayed(), "Login failed");
	}
}
