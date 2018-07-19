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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

	public static WebDriver webDriver = ApplicationDriver.getInstance();
	public static Settings settings;
	public int COUNT_SMALL = 1000;
	public int COUNT_MEDIUM = 2000;
	public int COUNT_HIGH = 3000;
	public int COUNT_LARGE = 4000;

	public void navigate(final String value) {
		webDriver.get(value);
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
	

	public void waitForLoad() {
		new WebDriverWait(webDriver, 30).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
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

	public double computeHeavy(int number) {
		if (number == 1) {
			return 1L;
		} else {
			return number * computeHeavy(number - 1);
		}
	}

	@SuppressWarnings("unchecked")
	public List<WebElement> waitElementsByTag(String tagName) {
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		return (List<WebElement>) wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagName)));
	}

	public void waitFewSeconds(int count) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver t) {
				for (int i = 0; i < count; i++) {
					for (int j = 0; j < count; j++) {
						for (int k = 0; k < count; k++) {
							for (int l = 0; l < 10; l++) {

							}
						}
					}
				}
				return true;
			}

		});
	}

	public void wait(int seconds) {
		webDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
}
