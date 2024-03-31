package com.playwright.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WebtableAutomate {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser=  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page= context.newPage();
		page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
	    Locator row=	page.locator("table#example tr");
	    row.locator(":scope", new Locator.LocatorOptions()
	    		                .setHasText("Timothy Mooney"))
	                                .locator(".select-checkbox").click();
		
	}

}
