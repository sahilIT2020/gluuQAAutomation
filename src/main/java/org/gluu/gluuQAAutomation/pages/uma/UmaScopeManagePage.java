package org.gluu.gluuQAAutomation.pages.uma;

import java.util.List;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class UmaScopeManagePage extends AbstractPage {

	WebElement listBody;
	List<WebElement> listItems;
	WebElement foundScope;

	public void assertUmaScopeExist(String scopeName) {
		Assert.assertTrue(assertUmaScopeExistInList(scopeName));
	}

	public void goToScopeAddPage() {
		webDriver.findElement(By.className("addScopeButtonClass")).click();
	}

	public void searchUmaScope(String scope) {
		WebElement searchBox = webDriver.findElement(By.className("searchBoxClass"));
		searchBox.clear();
		searchBox.sendKeys(scope);
		performSearch();
	}

	private void performSearch() {
		webDriver.findElement(By.className("searchButtonClass")).click();
		waitFewSeconds(3000);
	}

	private void getListItems() {
		WebElement pane = webDriver.findElement(By.className("umaScopeListClass"));
		listBody = pane.findElement(By.tagName("tbody"));
		listItems = listBody.findElements(By.tagName("tr"));
	}

	private boolean assertUmaScopeExistInList(String umaScope) {
		getListItems();
		boolean found = false;
		for (WebElement element : listItems) {
			if (element.getText().contains(umaScope)) {
				found = true;
				foundScope = element;
				break;
			}
		}
		return found;
	}

}
