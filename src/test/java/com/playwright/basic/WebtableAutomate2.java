package com.playwright.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WebtableAutomate2 {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context= browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.primefaces.org/primeng/table");
		Locator tableRows= page.locator("table#pr_id_2-table tr");
		System.out.println("Row counts : " + tableRows.count());
	    tableRows.locator(":scope",new Locator.LocatorOptions()
	    		                                .setHasText("James Butt"))
	                                               .locator(".p-checkbox-box")
	                                                    .click();
//	    page.close();
//	    context.close();
//	    browser.close();
//	    playwright.close();

	}

}
