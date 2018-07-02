package org.gluu.gluuQAAutomation.pages.uma;

import java.util.List;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class UmaResourceManagePage extends AbstractPage {
	WebElement listBody;
	List<WebElement> listItems;
	WebElement foundResource;

	public void assertUmaResourceExist(String scopeName) {
		Assert.assertTrue(assertUmaResourceExistInList(scopeName));
	}

	public void goToResourceAddPage() {
		foundResource.click();
	}

	public void searchUmaResource(String scope) {
		WebElement searchBox = webDriver.findElement(By.className("searchBoxClass"));
		searchBox.clear();
		searchBox.sendKeys(scope);
		performSearch();
	}

	private void performSearch() {
		webDriver.findElement(By.className("searchButtonClass")).click();
	}

	private void getListItems() {
		WebElement pane = webDriver.findElement(By.className("resourceScopeListClass"));
		listBody = pane.findElement(By.tagName("tbody"));
		listItems = listBody.findElements(By.tagName("tr"));
	}

	private boolean assertUmaResourceExistInList(String umaScope) {
		getListItems();
		boolean found = false;
		for (WebElement element : listItems) {
			if (element.getText().contains(umaScope)) {
				found = true;
				foundResource = element;
				break;
			}
		}
		return found;
	}

}
