package org.gluu.gluuQAAutomation.pages.users;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

@Component
public class UserImportPage extends AbstractPage {
	private WebElement footer;

	public void importUsers(String filePath) {
		WebElement form = webDriver.findElement(By.name("personImportForm"));
		form = form.findElement(By.className("box-primary"));
		footer = form.findElement(By.className("box-footer"));
		form = form.findElements(By.tagName("div")).get(3);
		WebElement upLoarder = form.findElement(By.className("uploadFile"));
		WebElement addButton = upLoarder.findElement(By.cssSelector("input[type='file']"));
		addButton.sendKeys(filePath);

		validate();
		performImport();
	}

	private void validate() {
		Actions actions = new Actions(webDriver);
		actions.moveToElement(footer.findElements(By.tagName("input")).get(0)).click().perform();
	}

	private void performImport() {
		WebElement panel = webDriver.findElement(By.id("updateButtons"));
		panel.findElements(By.tagName("input")).get(0).click();
	}

}
