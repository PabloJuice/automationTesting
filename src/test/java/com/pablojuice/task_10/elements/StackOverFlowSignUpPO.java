package com.pablojuice.task_10.elements;

import com.pablojuice.drivers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class StackOverFlowSignUpPO {

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/h1")
    private static WebElement joinCommunityPageTitle;

    public StackOverFlowSignUpPO() {
        PageFactory.initElements(DriverManager.getChromeDriver(), this);
    }

    public static void verifySignUpPage() {
        Assert.assertTrue(joinCommunityPageTitle.isDisplayed());
    }
}
