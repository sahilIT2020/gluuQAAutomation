package org.gluu.gluuQAAutomation.pages;

import java.util.concurrent.TimeUnit;

import org.gluu.gluuQAAutomation.common.ApplicationDriver;
import org.gluu.gluuQAAutomation.common.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

	protected WebDriver webDriver = ApplicationDriver.getInstance();
	public static Settings settings;

	public void navigate(final String value) {
		webDriver.get(value);
	}

	public void goToLoginPage() {
		webDriver.get(settings.getUrl());
		navigate(settings.getUrl());
	}

	public String getCurrentPageTitle() {
		return webDriver.getTitle();
	}

	public String getCurrentPageUrl() {
		return webDriver.getCurrentUrl();
	}

	public void close() {
		webDriver.close();
	}

	public void open() {
		webDriver = ApplicationDriver.getInstance();
	}

	public WebElement waitElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public void wait(int seconds) {
		webDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
}
