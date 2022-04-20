package com.pablojuice.task_10.elements;

import com.pablojuice.drivers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StackOverflowTestBO {

    private static final StackOverflowHomePO stackOverflowHomePO = new StackOverflowHomePO();
    private static final StackOverFlowSignUpPO stackOverflowSignUpPO = new StackOverFlowSignUpPO();

	@FindBy(xpath = "/html/body/div[4]/div/button[1]")
	private static WebElement acceptCookiesButton;

	public StackOverflowTestBO() {
		PageFactory.initElements(DriverManager.getChromeDriver(), this);
	}

	public static void goToHomePage() {
		stackOverflowHomePO.goToHomePage();
	}

	public static void acceptCookies() {
		try {
			acceptCookiesButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickSignUp() {
		stackOverflowHomePO.clickSignUp();
	}

	public static void verifySignUpPage() {
		stackOverflowSignUpPO.verifySignUpPage();
	}
}
