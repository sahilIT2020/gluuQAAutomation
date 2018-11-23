package org.gluu.gluuQAAutomation.pages.profile;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ProfilePage extends AbstractPage {

	public void changePassword(String oldPwd, String newPwd) {
		showPasswordDiolag();
		WebElement old = webDriver.findElement(By.id("personPassword:changePasswordForm:old"));
		old.sendKeys(oldPwd);
		WebElement newField = webDriver.findElement(By.id("personPassword:changePasswordForm:pass"));
		newField.sendKeys(newPwd);
		WebElement confirm = webDriver.findElement(By.id("personPassword:changePasswordForm:conf"));
		confirm.sendKeys(newPwd);
		performPasswordChange();
	}

	private void showPasswordDiolag() {
		webDriver.findElement(By.className("changeUserPasswordButton")).click();
	}

	private void performPasswordChange() {
		WebElement main = webDriver.findElement(By.id("personPassword:changePasswordModalPanel_content"));
		Assert.assertNotNull(main);
		WebElement button = main.findElement(By.className("savePasswordButton"));
		button.click();
		fluentWait(ONE_SEC);
		webDriver.findElement(By.className("updateProfileButton")).click();
	}

}
