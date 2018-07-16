package org.gluu.gluuQAAutomation.pages.saml;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class NameIdAddPage extends AbstractPage {

	public void setSourceAttribute(String source) {
		WebElement element = webDriver.findElement(By.className("sourceAttributeSelectBox"));
		Select select = new Select(element);
		select.selectByVisibleText(source);
	}

	public void setName(String name) {
		WebElement element = webDriver.findElement(By.className("nameTextBox"));
		element.clear();
		element.sendKeys(name);
	}

	public void setType(String source) {
		WebElement element = webDriver.findElement(By.className("nameIdTypeSelectBox"));
		Select select = new Select(element);
		select.selectByVisibleText(source);
	}

	public void enable() {
		WebElement checkBoxButton = webDriver.findElement(By.className("enableCheckBoxButton"));
		checkBoxButton.click();
	}
	
	public void save() {
		WebElement footer = webDriver.findElement(By.id("updateButtons"));
		footer.findElements(By.tagName("input")).get(0).click();
		
		waitFewSeconds(1000);
	}

}
