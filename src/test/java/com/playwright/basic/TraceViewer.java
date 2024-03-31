package com.playwright.basic;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class TraceViewer {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();

		// Start tracing
		context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));

		Page page = context.newPage();
		page.navigate("https://playwright.dev");

		// Stop tracing and export it into a zip archive.
		context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
	}

}
