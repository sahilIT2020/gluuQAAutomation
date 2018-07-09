package org.gluu.gluuQAAutomation.pages.openidconnect;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class OpenIdConnectScopeUpdatePage extends AbstractPage {

	public void edit() {
		WebElement footer = webDriver.findElement(By.id("updateButtons"));
		footer.findElements(By.tagName("input")).get(0).click();
	}

	public void delete() {
		WebElement footer = webDriver.findElement(By.id("updateButtons"));
		footer.findElements(By.tagName("input")).get(1).click();
		waitFewSeconds(COUNT_MEDIUM);
		WebElement dialog = webDriver.findElement(By.id("deleteConfirmation:acceptRemovalModalPanel_content"));
		dialog.findElements(By.tagName("input")).get(0).click();
		waitFewSeconds(COUNT_MEDIUM);
	}
}
