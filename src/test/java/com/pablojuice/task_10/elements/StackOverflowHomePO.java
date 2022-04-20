package com.pablojuice.task_10.elements;

import com.pablojuice.drivers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class StackOverflowHomePO {

    @FindBy(xpath = "//*[@id=\"content\"]/header/div/div[1]/div[1]/div/a")
    private static WebElement joinCommunityButton;

    public StackOverflowHomePO() {
        PageFactory.initElements(DriverManager.getChromeDriver(), this);
    }

    public static void goToHomePage() {
        DriverManager.getChromeDriver().get("https://stackoverflow.com/");
    }

    public static void clickSignUp() {
        joinCommunityButton.click();
    }

}
