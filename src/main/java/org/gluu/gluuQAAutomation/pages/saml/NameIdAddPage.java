package org.gluu.gluuQAAutomation.pages.saml;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class NameIdAddPage extends AbstractPage {

	public void addNamedId(String source, String name, String type, String enable) {

		WebElement section = webDriver.findElement(By.className("NewNamedID"));

		WebElement element = section.findElement(By.className("sourceAttributeSelectBox"));
		Select select = new Select(element);
		select.selectByVisibleText(source);

		WebElement element1 = section.findElement(By.className("nameTextBox"));
		element1.clear();
		element1.sendKeys(name);

		WebElement element2 = section.findElement(By.className("nameIdTypeSelectBox"));
		Select select1 = new Select(element2);
		select1.selectByVisibleText(type);

		if (enable.equalsIgnoreCase("true")) {
			WebElement checkBoxButton = section.findElement(By.className("enableCheckBoxButton"));
			checkBoxButton.click();
		}
	}

	public void enable(String value) {

	}

	public void save() {
		WebElement footer = webDriver.findElement(By.id("updateButtons"));
		footer.findElements(By.tagName("input")).get(0).click();
		fluentWait(ONE_SEC);
	}

	public void assertNamedExist(String name) {
		WebElement section = webDriver.findElement(By.className(name));
		Assert.assertNotNull(section);
	}

	public void assertNamedDontExist(String name) {
		try {
			WebElement section = webDriver.findElement(By.className(name));
			Assert.assertNull(section);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

}
