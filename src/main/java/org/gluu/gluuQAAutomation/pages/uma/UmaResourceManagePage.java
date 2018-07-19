package org.gluu.gluuQAAutomation.pages.uma;

import java.util.List;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class UmaResourceManagePage extends AbstractPage {

	public void assertUmaResourceExist(String resName, String scopeName) {
		Assert.assertTrue(assertUmaResourceExistInList(resName, scopeName));
	}

	public void goToResourceAddPage() {
	}

	public void searchUmaResource(String scope) {
		WebElement searchBox = webDriver.findElement(By.className("searchBoxClass"));
		searchBox.clear();
		searchBox.sendKeys(scope);
		performSearch();
	}

	private void performSearch() {
		webDriver.findElement(By.className("searchButtonClass")).click();
		fluentWait(SMALL);
	}

	private boolean assertUmaResourceExistInList(String resName, String umaScope) {
		WebElement resourcesList = webDriver.findElement(By.className("resourceScopeListClass"));
		Assert.assertNotNull(resourcesList);
		WebElement body = webDriver.findElement(By.className("resourceScopeListClass")).findElements(By.tagName("tbody")).get(0);
		List<WebElement> listItems = body.findElements(By.tagName("tr"));

		boolean found = false;
		for (WebElement element : listItems) {
			if (element.getText().contains(resName) && element.getText().contains(umaScope)) {
				found = true;
				break;
			}
		}
		return found;
	}

}
