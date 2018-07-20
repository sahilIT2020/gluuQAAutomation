package org.gluu.gluuQAAutomation.pages.configuration.authentication;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class PassportAuthenticationPage extends AbstractPage {

	public void save() {
		WebElement footer = webDriver.findElement(By.id("updateButtons"));
		footer.findElements(By.tagName("input")).get(0).click();
		fluentWait(LITTLE);
	}

	public void setPassportStatus(String status) {
		Select select = new Select(webDriver.findElement(By.className("passportEnableSelectBox")));
		select.selectByVisibleText(status);
	}

	public void addStrategy(String name, String id, String secret) {
		WebElement addStrategyButton = webDriver.findElement(By.className("addStrategyButton"));
		addStrategyButton.click();
		fluentWait(LITTLE);

		WebElement strategiesArea = webDriver.findElement(By.id("customAuthenticationForm:strategyId"));

		WebElement strategyName = strategiesArea.findElement(By.className("strategyNameTextBox"));
		strategyName.clear();
		strategyName.sendKeys(name);

		WebElement strategyArea = strategiesArea.findElement(By.className("NewEmptyStrategy"));
		WebElement value1 = strategyArea.findElements(By.className("propertyValueTextBox")).get(0);
		value1.clear();
		value1.sendKeys(id);

		WebElement value2 = strategyArea.findElements(By.className("propertyValueTextBox")).get(1);
		value2.clear();
		value2.sendKeys(secret);
		fluentWait(LITTLE);
		save();
	}

}
