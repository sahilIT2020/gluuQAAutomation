package org.gluu.gluuQAAutomation.pages.configuration;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class OxAuthSettingPage extends AbstractPage {

	public void setServerIp(String ip) {
		WebElement element = webDriver.findElement(By.className("serverIpTextBox"));
		element.clear();
		element.sendKeys(ip);
	}

	public void checkServerIpIsEmpty() {
		WebElement element = webDriver.findElement(By.className("serverIpTextBox"));
		Assert.assertTrue(element.getAttribute("value").isEmpty());
	}

}
