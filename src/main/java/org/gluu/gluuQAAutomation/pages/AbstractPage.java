package org.gluu.gluuQAAutomation.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.gluu.gluuQAAutomation.common.ApplicationDriver;
import org.gluu.gluuQAAutomation.common.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,250)");
	}

	public void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,-250)");
	}

	public void signOut() {
		WebElement element = webDriver.findElement(By.className("user-menu"));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(element).click().perform();

		WebElement footer = waitElementByClass("user-footer");
		List<WebElement> elements = footer.findElements(By.className("pull-left"));
		elements.get(1).click();
		finishLogout();
	}

	public String getCurrentPageUrl() {
		return webDriver.getCurrentUrl();
	}

	private void finishLogout() {
		WebElement finishButton = webDriver.findElement(By.className("btn-lg"));
		finishButton.click();
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

	public WebElement waitElementByClass(String className) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
	}

	public WebElement waitElementByTag(String tagName) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagName)));
	}
	
	@SuppressWarnings("unchecked")
	public List<WebElement> waitElementsByTag(String tagName) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		return (List<WebElement>) wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagName)));
	}


	public void wait(int seconds) {
		webDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
}
