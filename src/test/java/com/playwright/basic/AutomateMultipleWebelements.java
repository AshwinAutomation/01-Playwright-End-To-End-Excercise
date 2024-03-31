package com.playwright.basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutomateMultipleWebelements {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.rahulshettyacademy.com/AutomationPractice/");
		Locator branchList = page.locator("//select[@id='dropdown-class-example']//option");
		
		System.out.println("branchCount : " + branchList.count());

		for (int i = 0; i < branchList.count(); i++) {

			String dropdownOptions = branchList.nth(i).textContent();
			System.out.println("dropdownOptions : " + dropdownOptions);

			if (dropdownOptions.contains("Option3")) {
				
				branchList.nth(i).click();
				System.out.println("after click ");
				
			}

		}

	}

}
