package org.gluu.gluuQAAutomation.pages.users;

import java.util.List;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class GroupAddPage extends AbstractPage {

	WebElement footer;

	public void fillDisplayName(String value) {
		WebElement element = webDriver.findElement(By.className("displayNameField"));
		element.click();
		WebElement input = element.findElements(By.tagName("input")).get(1);
		input.clear();
		input.sendKeys(value);

	}

	public void fillDescription(String value) {
		WebElement element = webDriver.findElement(By.tagName("textarea"));
		element.clear();
		element.sendKeys(value);
	}

	public void fillStatus(String value) {
		WebElement dropDown = webDriver.findElement(By.className("visibilityField"));
		Select select = new Select(dropDown);
		select.selectByVisibleText(value);
	}

	public void save() {
		footer = webDriver.findElement(By.id("updateButtons"));
		footer.findElements(By.tagName("input")).get(0).click();
	}

	public void cancel() {
		footer = webDriver.findElement(By.id("updateButtons"));
		footer.findElements(By.tagName("input")).get(1).click();
	}

	public void pickUser(String user) {
		WebElement addButton = webDriver.findElement(By.className("AddMember"));
		addButton.click();

		WebElement dialogBox = webDriver.findElement(By.id("member:selectMemberModalPanel_container"));
		WebElement content = dialogBox.findElement(By.id("member:selectMemberModalPanel_content"));
		content = content.findElement(By.tagName("table"));
		List<WebElement> inupts = content.findElements(By.tagName("input"));
		inupts.get(0).clear();
		inupts.get(0).sendKeys(user);
		inupts.get(1).click();

		dialogBox = waitElementByID("member:selectMemberModalPanel_container");
		content = dialogBox.findElement(By.id("member:selectMemberModalPanel_content"));
		content.click();
		content = content.findElement(By.tagName("table"));
		content.click();
		WebElement searchResult = content.findElements(By.tagName("tr")).get(1);
		Assert.assertNotNull(searchResult);
		searchResult = searchResult.findElement(By.tagName("tbody"));
		WebElement firstRow = searchResult.findElements(By.tagName("tr")).get(0);
		Assert.assertNotNull(firstRow);
		firstRow.findElements(By.tagName("td")).get(0).click();

		List<WebElement> trs = content.findElements(By.tagName("tr"));
		WebElement buttonZone = trs.get(trs.size() - 1);
		buttonZone.findElements(By.tagName("input")).get(0).click();
	}

}
