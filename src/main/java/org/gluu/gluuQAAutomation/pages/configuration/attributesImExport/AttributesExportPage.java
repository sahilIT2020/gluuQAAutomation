package org.gluu.gluuQAAutomation.pages.configuration.attributesImExport;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class AttributesExportPage extends AbstractPage {

	private List<WebElement> rows = new ArrayList<WebElement>();

	public void clickExportButton() {
		webDriver.findElement(By.className("exportAttributeButton")).click();
		fluentWait(LITTLE);
	}

	private void init() {
		rows = webDriver.findElement(By.id("attributesFormId:attributesListId")).findElement(By.tagName("tbody"))
				.findElements(By.tagName("tr"));
	}

	public void pickAttributeToImport(String name) {
		init();
		pickAppropriateRow(name);
	}

	private void pickAppropriateRow(String name) {
		for (WebElement row : rows) {
			if (row.findElements(By.tagName("td")).get(2).getText().equalsIgnoreCase(name)) {
				row.findElements(By.tagName("td")).get(0).findElement(By.tagName("div")).click();
				break;
			}
		}
	}

	public void export() {
		scrollDown();
		String fullPath = getUserDir().concat(File.separator).concat("attributes.ldif");
		File donwloadFile = new File(fullPath);
		if(donwloadFile.exists() && !donwloadFile.isDirectory()) {
			FileUtils.deleteQuietly(donwloadFile);
		}
		webDriver.findElement(By.className("exportAttributeButton")).click();
		fluentWait(LITTLE);
	}

	public void verifyFile(String fileName) {
		String fullPath = getUserDir().concat(File.separator).concat(fileName);
		System.out.println("FILE PATH:"+fullPath);
		File donwloadFile = new File(fullPath);
		Assert.assertTrue(donwloadFile.exists() && !donwloadFile.isDirectory());
	}

}
