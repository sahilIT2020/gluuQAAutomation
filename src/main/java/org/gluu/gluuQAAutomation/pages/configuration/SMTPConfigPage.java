package org.gluu.gluuQAAutomation.pages.configuration;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class SMTPConfigPage extends AbstractPage {

	public void setSmtpHost(String host) {
		WebElement element = webDriver.findElement(By.className("smtpHostTextBox"));
		element.clear();
		element.sendKeys(host);
	}

	public void setSmtpFromName(String host) {
		WebElement element = webDriver.findElement(By.className("fromNameTextBox"));
		element.clear();
		element.sendKeys(host);
	}

	public void setSmtpFromEmailAddress(String host) {
		WebElement element = webDriver.findElement(By.className("fromEmailAddressTextBox"));
		element.clear();
		element.sendKeys(host);
	}

	public void setSmtpRequireAuthentication(boolean value) {
		WebElement element = webDriver.findElement(By.className("requiresAuthenticationCheckBox"));
		element.click();
	}

	public void setSmtpUserName(String value) {
		WebElement element = webDriver.findElement(By.className("smtpUserNameTextBox"));
		element.clear();
		element.sendKeys(value);
	}

	public void setSmtpPassword(String value) {
		WebElement element = webDriver.findElement(By.className("smtpPasswordTextBox"));
		element.clear();
		element.sendKeys(value);
	}

	public void setSmtpRequireSSL(boolean value) {
		WebElement element = webDriver.findElement(By.className("requiresSSLCheckBox"));
		element.click();
	}

	public void setSmtpTrustServer(boolean value) {
		WebElement element = webDriver.findElement(By.className("trustserverCheckBox"));
		element.click();
	}

	public void setSmtpPort(String value) {
		WebElement element = webDriver.findElement(By.className("smtpPortTextBox"));
		element.clear();
		element.sendKeys(value);
	}

	public void test() {
		WebElement textButton = webDriver.findElement(By.className("smtpPortTextBox"));
		textButton.click();
		waitFewSeconds(COUNT_MEDIUM);
	}

	public void update() {
		WebElement footer = webDriver.findElement(By.id("organizationForm:updateButtons"));
		footer.findElements(By.tagName("input")).get(0).click();
		waitFewSeconds(COUNT_MEDIUM);
	}

}
