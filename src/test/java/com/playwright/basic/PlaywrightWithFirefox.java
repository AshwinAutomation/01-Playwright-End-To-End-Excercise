package com.playwright.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightWithFirefox {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		page.fill("//input[@name='username']", "Admin");
		page.fill("//input[@name='password']", "admin123");
		page.click("//button[@type='submit']");
		System.out.println("Title : " + page.title());
		Locator employeeList = page.locator("//a[text()='Employee List']");
		employeeList.click();
	//	page.close();
	//	browser.close();
		//playwright.close();

	}

}
