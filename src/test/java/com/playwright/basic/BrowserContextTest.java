package com.playwright.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextTest {

	public static void main(String[] args) {

		Playwright playWright = Playwright.create();
		Browser browser = playWright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext1 = browser.newContext();
		Page page = browserContext1.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		page.fill("//input[@name='username']", "Admin");
		page.fill("//input[@name='password']", "admin123");
		page.click("//button[@type='submit']");
		System.out.println("Title : " + page.title());
		page.close();
		
		
		browser.close();
		playWright.close();
	}

}
