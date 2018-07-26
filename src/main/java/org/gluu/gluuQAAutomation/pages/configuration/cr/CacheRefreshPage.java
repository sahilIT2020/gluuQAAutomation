package org.gluu.gluuQAAutomation.pages.configuration.cr;

import java.util.List;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class CacheRefreshPage extends AbstractPage {

	public void addSourceAttribute(String source, String destination) {
		WebElement element = webDriver.findElement(By.className("addNewPropertyButton"));
		element.click();
		fluentWait(LITTLE);
		List<WebElement> tables = webDriver.findElements(By.className("propertiesList"));
		WebElement lastTable = tables.get(tables.size() - 1);
		lastTable.findElement(By.className("propertyLabelTextBox")).sendKeys(source);
		lastTable.findElement(By.className("propertyValueTextBox")).sendKeys(destination);
		fluentWait(LITTLE);
	}

	public void setPollingInterval(String intervall) {
		webDriver.findElement(By.className("pollingIntervalTextBox")).clear();
		webDriver.findElement(By.className("pollingIntervalTextBox")).sendKeys(intervall);
	}

	public void enableCacheRefresh() {
		Select select = new Select(webDriver.findElement(By.className("enableCacheRefreshSelectBox")));
		select.selectByVisibleText("Enabled");
	}

	public void save() {
		webDriver.findElement(By.className("updateButon")).click();
		fluentWait(LITTLE);
	}

	public void addKeyAttrib(String attrib) {
		webDriver.findElements(By.className("addItemButton")).get(0).click();
		fluentWait(LITTLE);
		WebElement newAttrib=webDriver.findElements(By.className("propertiesList")).get(0);
		newAttrib.findElement(By.tagName("input")).sendKeys(attrib);
		fluentWait(LARGE);
		
	}

}
