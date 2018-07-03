package org.gluu.gluuQAAutomation.pages.login;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class SignInPage extends AbstractPage {

	private boolean passportSocialIsEnable = false;

	public void fillForm(String userName, String password) {
		passportSocialIsEnable = getCurrentPageTitle().contains("Passport");
		if (passportSocialIsEnable) {
			WebElement userNameElement = webDriver.findElement(By.xpath("//*[@id='loginForm:username']"));
			userNameElement.sendKeys(userName);
			WebElement passwordElement = webDriver.findElement(By.xpath("//*[@id='loginForm:password']"));
			passwordElement.sendKeys(password);
		} else {
			WebElement userNameElement = webDriver.findElement(By.xpath("//*[@id='loginForm:username']"));
			userNameElement.sendKeys(userName);
			WebElement passwordElement = webDriver.findElement(By.xpath("//*[@id='loginForm:password']"));
			passwordElement.sendKeys(password);
		}
	}

	public void submit() {
		WebElement loginButton = webDriver.findElement(By.id("loginForm:loginButton"));
		loginButton.click();
		wait(5);
	}

	public void checkCurrentPageIsHomePage() {
		String currentPageUrl = getCurrentPageUrl();
		Assert.assertTrue(currentPageUrl.contains("home"));
	}

	public void fillFormAsAdmin() {
		fillForm(settings.getUserName(), settings.getPassword());
	}

	public void checkCurrentPageIsLoginPage() {
		String currentPageUrl = getCurrentPageUrl();
		Assert.assertTrue(currentPageUrl.endsWith("oxauth/login")
				|| currentPageUrl.endsWith("oxauth/auth/passport/passportlogin"));
	}
}
