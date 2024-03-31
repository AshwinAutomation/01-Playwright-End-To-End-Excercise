package com.playwright.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {

	public static void main(String[] args) {

		
		Playwright playwright= Playwright.create();
		Browser browse= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    BrowserContext context=	browse.newContext();
	    Page page= context.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		page.fill("//input[@name='username']", "Admin");
		page.fill("//input[@name='password']", "admin123");
		page.click("//button[@type='submit']");
		String textMessage= page.locator("text=Employee Information").textContent();
		System.out.println("textMessage : " + textMessage);
		
	}

}
