package org.gluu.gluuQAAutomation.pages.users;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

@Component
public class UserImportPage extends AbstractPage {
	private WebElement footer;

	public void importUsers() {
		WebElement form = webDriver.findElement(By.name("personImportForm"));
		WebElement form1 = form.findElement(By.className("box-primary"));
		footer = form1.findElement(By.className("box-footer"));
		WebElement form2 = form1.findElements(By.tagName("div")).get(3);
		WebElement upLoarder = form2.findElement(By.className("uploadFile"));
		WebElement addButton = upLoarder.findElement(By.cssSelector("input[type='file']"));
		String finalPath = getUserDir().concat("/src/main/resources/ImportUsers.xls");
		addButton.sendKeys(finalPath);
		fluentWait(SMALL);
		validate();
		performImport();
	}

	private void validate() {
		Actions actions = new Actions(webDriver);
		actions.moveToElement(footer.findElements(By.tagName("input")).get(0)).click().perform();
		fluentWait(SMALL);
	}

	private void performImport() {
		WebElement panel = webDriver.findElement(By.id("updateButtons"));
		panel.findElements(By.tagName("input")).get(0).click();
		fluentWait(SMALL);
	}

}
