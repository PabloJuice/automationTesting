package com.pablojuice.task_10;

import com.pablojuice.drivers.DriverManager;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		DriverManager.setupChromeDriver();
		DriverManager.getChromeDriver().get("https://www.google.com.ua/");
		Thread.sleep(3000);
		DriverManager.closeDriver();
	}
}
