package org.gluu.gluuQAAutomation.pages.saml;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class NameIdConfigurationPage extends AbstractPage {

	public void startAddingNewConfiguration() {
		fluentWait(SMALL);
		WebElement element = webDriver.findElement(By.className("addConfig"));
		element=element.findElement(By.tagName("a"));
		element.click();
	}

}
