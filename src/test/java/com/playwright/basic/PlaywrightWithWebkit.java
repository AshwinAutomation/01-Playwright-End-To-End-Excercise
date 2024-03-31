package com.playwright.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightWithWebkit {
	public static void main(String[] args) {
	
		Playwright playwright=Playwright.create();
		Browser browser =playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page =browser.newPage();
		page.navigate("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		String title = page.title();
		String url = page.url();
		System.out.println("title : " + title);
		System.out.println("url : " + url);
		
		browser.close();
		playwright.close();
		
	}

}
