package com.playwright.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandle {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("http://the-internet.herokuapp.com/iframe");
		String textArea = page.frameLocator("#mce_0_ifr").locator("text=Your content goes here.").textContent();
		System.out.println("textAreaMessage :" + textArea);
		page.frameLocator("#mce_0_ifr").locator("text=Your content goes here.");
	}

}
