package org.gluu.gluuQAAutomation.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.gluu.gluuQAAutomation.common.ApplicationDriver;
import org.gluu.gluuQAAutomation.common.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

	public static WebDriver webDriver = ApplicationDriver.getInstance();
	public static Settings settings;
	public int ONE_SEC = 1;
	public int LITTLE = 2;
	public int SMALL = 4;
	public int MEDIUM = 6;
	public int HIGH = 10;
	public int LARGE = 12;
	private String QAFakeClassName = "QaFakeClassName";
	private By locator = By.className(QAFakeClassName);

	public void navigate(final String value) {
		webDriver.get(value);
	}

	public String getUserDir() {
		String result = System.getProperty("user.dir");
		System.out.println("##################### Current Worlking Directory:" + result);
		return result;
	}

	public void goToLoginPage() {
		if (webDriver != null) {
			System.out.println("**********************1");
			webDriver.get(settings.getUrl());
			webDriver.get(settings.getUrl());
		} else {
			System.out.println("**********************2");
			webDriver = ApplicationDriver.getInstance();
			webDriver.get(settings.getUrl());
			webDriver.get(settings.getUrl());
		}

	}

	public WebElement fluentWaitFor(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return foo;
	}

	public void fluentWait(int seconds) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(seconds, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

			wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(locator);
				}
			});
		} catch (Exception e) {

		}
	}

	public void selectTab(String tabText) {
		WebElement section = webDriver.findElement(By.className("nav-tabs"));
		List<WebElement> tabs = section.findElements(By.tagName("li"));
		for (WebElement tab : tabs) {
			if (tab.getText().contains(tabText)) {
				tab.click();
				break;
			}
		}
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

	public void clear() {
		webDriver.manage().deleteAllCookies();
	}

	public void open() {
		webDriver = ApplicationDriver.getInstance();
	}

	public WebElement waitElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public WebElement waitElementByClass(String className) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
	}

	public WebElement waitElementByTag(String tagName) {
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagName)));
	}

	public WebElement waitElementByID(String id) {
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}

	@SuppressWarnings("unchecked")
	public List<WebElement> waitElementsByTag(String tagName) {
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		return (List<WebElement>) wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagName)));
	}
}
