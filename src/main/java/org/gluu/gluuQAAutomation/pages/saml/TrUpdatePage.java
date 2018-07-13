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
		waitFewSeconds(COUNT_SMALL);
		WebElement footer = webDriver.findElement(By.id("updateButtons"));
		footer.findElements(By.tagName("input")).get(2).click();
		waitFewSeconds(COUNT_MEDIUM);
		WebElement dialog = webDriver.findElement(By.id("deleteConfirmation:acceptRemovalModalPanel_content"));
		List<WebElement> list = dialog.findElements(By.tagName("input"));
		for (WebElement input : list) {
			if (input.getAttribute("value").equalsIgnoreCase("Cancel")) {
				Actions actions=new Actions(webDriver);
				actions.click(input).build().perform();
				waitFewSeconds(COUNT_MEDIUM);
				break;
			}
		}
	}

}
