package org.gluu.gluuQAAutomation.pages.saml;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

@Component
public class TrUpdatePage extends TrAddPage {

	public void update() {
		WebElement footer = webDriver.findElement(By.id("updateButtons"));
		footer.findElements(By.tagName("input")).get(0).click();
		waitFewSeconds(COUNT_MEDIUM);
	}

	public void delete() {
		WebElement footer = webDriver.findElement(By.id("updateButtons"));
		List<WebElement> buttons = footer.findElements(By.tagName("input"));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(buttons.get(2)).click().perform();
		waitFewSeconds(COUNT_MEDIUM);
		WebElement dialog = waitElementByID("deleteConfirmation:acceptRemovalModalPanel_content");
		dialog.findElements(By.tagName("input")).get(0).click();
		waitFewSeconds(COUNT_SMALL);
	}

}
