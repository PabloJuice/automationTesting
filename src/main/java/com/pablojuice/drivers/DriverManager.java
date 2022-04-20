package com.pablojuice.drivers;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	private static final ThreadLocal<WebDriver> INSTANCE = new InheritableThreadLocal<>();

	public static WebDriver getChromeDriver() {
		if (INSTANCE.get() == null) {
			throw new RuntimeException("Instance was not initialized");
		}
		return INSTANCE.get();
	}

	public static void setupChromeDriver() {
		//System.setProperty("webdriver.chrome.driver", "src/main/java/com/pablojuice/drivers/chromedriver.exe");
		ChromeDriverManager.getInstance().setup();
		INSTANCE.set(new ChromeDriver());
	}

	public static void closeDriver() {
		WebDriver driver = INSTANCE.get();
		if (driver != null) {
			driver.close();
			driver.quit();
			INSTANCE.remove();
		}
	}
}
