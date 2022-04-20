package com.pablojuice.task_11.elements;

import com.pablojuice.drivers.DriverManager;
import com.pablojuice.task_12.decorators.CustomFieldDecorator;
import com.pablojuice.task_12.decorators.WebTestButton;
import com.pablojuice.task_12.decorators.WebTestInput;
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

public class InstagramAuthPagePO {
	private final WebDriver chromeDriver = DriverManager.getChromeDriver();

	@FindBy(xpath = "//*[@id=\"loginForm\"]/div/div[1]/div/label/input")
	private WebTestInput loginInput;
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div/div[2]/div/label/input")
	private WebTestInput passwordInput;
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div/div[3]/button")
	private WebTestButton loginButton;

	public InstagramAuthPagePO() {
		PageFactory.initElements(new CustomFieldDecorator(DriverManager.getChromeDriver()), this);
	}

	public void goToLoginPage() {
		chromeDriver.get("https://www.instagram.com/");
	}

	public void login(String login, String password) {
		WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//*[@id=\"loginForm\"]/div/div[3]/button")));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		loginInput.fillWith(login);
		passwordInput.fillWith(password);
		if (loginButton.isActive()) {
			loginButton.press();
		} else {
			Assert.fail("Incorrect input data");
		}
	}
}
