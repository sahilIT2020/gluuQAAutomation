package org.gluu.gluuQAAutomation.pages.users;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class UserImportPage extends AbstractPage {
	private WebElement footer;

	public void importDefaultFile() {
		WebElement form = webDriver.findElement(By.name("personImportForm"));
		form = form.findElement(By.className("box-primary"));
		footer = form.findElement(By.className("box-footer"));
		form = form.findElements(By.tagName("div")).get(3);
		WebElement upLoarder = form.findElement(By.className("uploadFile"));
		WebElement addButton = upLoarder.findElement(By.cssSelector("input[type='file']"));
		addButton.sendKeys("/home/gasmyr/gluuQAAutomation/src/main/resources/ImportUsers.xls");

		validate();
		performImport();
	}

	private void validate() {
		footer.findElements(By.tagName("input")).get(0).click();
	}

	private void performImport() {
		WebElement panel = webDriver.findElement(By.id("updateButtons"));
		panel.findElements(By.tagName("input")).get(0).click();
	}

}
