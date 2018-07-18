package org.gluu.gluuQAAutomation.pages.login;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;


@Component
public class PasswordResetPage extends AbstractPage {

	public void setEmail(String email) {
		WebElement element = webDriver.findElement(By.id("formArea:username"));
		element.clear();
		element.sendKeys(email);
	}

	public void sendMail() {
		WebElement element = webDriver.findElement(By.id("formArea:submit"));
		element.click();
	}
	
	public void verifyMailWasSend() {
		WebElement element=waitElementByClass("lockscreen-name");
		Assert.assertTrue(element.getText().contains(""));
	}

}
