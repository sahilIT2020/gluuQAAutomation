package org.gluu.gluuQAAutomation.pages.users;

import java.util.List;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class GroupManagePage extends AbstractPage {
	private List<WebElement> inputs;
	private WebElement tableBody;
	private WebElement foundGroup;

	public void searchGroup(String pattern) {
		WebElement searchBox = webDriver.findElement(By.className("searchArea"));
		WebElement searchSpanBox = searchBox.findElement(By.tagName("span"));
		inputs = searchSpanBox.findElements(By.tagName("input"));
		Assert.assertTrue(inputs.size() == 2);
		inputs.get(0).sendKeys(pattern);
		inputs.get(1).click();
		tableBody = webDriver.findElement(By.id("groupsFormId:groupsListId")).findElements(By.tagName("tbody"))
				.get(0);
	}

	public boolean groupExistList(String username) {
		List<WebElement> trs = tableBody.findElements(By.tagName("tr"));
		boolean found = false;
		for (WebElement element : trs) {
			if (element.getText().contains(username)) {
				found = true;
				foundGroup = element;
				break;
			}
		}
		return found;
	}

	public void assertGroupWithExist(String value) {
		Assert.assertTrue(groupExistList(value));
	}

	public void startGroupUpdate() {
		foundGroup.findElements(By.tagName("td")).get(0).click();
	}

}
