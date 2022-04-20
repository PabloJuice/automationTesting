package com.pablojuice.task_11.test;


import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import com.pablojuice.drivers.DriverManager;
import com.pablojuice.task_11.elements.InstagramAuthTestBO;
import com.pablojuice.task_13.listeners.CustomSuiteListener;
import com.pablojuice.task_13.listeners.CustomTestListener;
import org.testng.annotations.*;

@Listeners({
		UniversalVideoListener.class,
		CustomSuiteListener.class,
		CustomTestListener.class
})
public class InstagramAuthTest {

	@BeforeTest
	void init() {
		DriverManager.setupChromeDriver();
	}

	@DataProvider
	Object[][] instagramAuthProvider() {
		return new Object[][]{
				{"user1212323", "12323345"},
				{"user123434523", "456567565234"},
				{"user123123", "user123123"},
				{"aqatest12", "AQAAuthenticationTest"}
		};
	}

	@Test(dataProvider = "instagramAuthProvider")
	@Video(name = "Instagram_auth")
	void instagramAuthTest(String login, String password) {
		InstagramAuthTestBO instagramAuthTestBO = new InstagramAuthTestBO();
		instagramAuthTestBO
				.openLoginPage()
				.login(login, password)
				.verifyLogin();
	}

	@AfterTest
	void closeSession() {
		DriverManager.closeDriver();
	}
}
