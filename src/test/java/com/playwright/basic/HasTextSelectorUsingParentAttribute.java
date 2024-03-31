package com.playwright.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HasTextSelectorUsingParentAttribute {

	public static void main(String[] args) {

		
		Playwright playwright= Playwright.create();
		Browser browse= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    BrowserContext context=	browse.newContext();
	    Page page= context.newPage();
		page.navigate("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		//capture new customer using hastext selector
		String text= page.locator("div.card-body h2:has-text('New Customer')").textContent();
		System.out.println("text : " + text);
	}

}
