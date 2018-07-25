package org.gluu.gluuQAAutomation.pages.configuration.attributesImExport;

import java.io.File;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class AttributesImportPage extends AbstractPage {

	public void importAttributesFromFile(String fileName) {
		WebElement upLoader = webDriver.findElement(By.className("fileUploader"));
		WebElement addButton = upLoader.findElement(By.cssSelector("input[type='file']"));
		String finalPath = getUserDir().concat(File.separator).concat("attributes.ldif");
		addButton.sendKeys(finalPath);
		fluentWait(LITTLE);
	}

	public void validateAndImport() {
		webDriver.findElement(By.className("validateButton")).click();
		fluentWait(LITTLE);
		webDriver.findElement(By.className("importButton")).click();
		fluentWait(LITTLE);
	}

}
