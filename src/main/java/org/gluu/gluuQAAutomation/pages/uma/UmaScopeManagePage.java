package org.gluu.gluuQAAutomation.pages.uma;

import java.util.List;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class UmaScopeManagePage extends AbstractPage {

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

	private boolean assertUmaScopeExistInList(String umaScope) {
		webDriver.findElement(By.className("umaScopeListClass"));
		WebElement body = webDriver.findElement(By.className("umaScopeListClass")).findElements(By.tagName("tbody")).get(0);
		System.out.println("Source scope2:" + body.getAttribute("outerHTML"));
		List<WebElement> listItems = body.findElements(By.tagName("tr"));
		System.out.println("Source scope3: size" + listItems.size());
		boolean found = false;
		for (WebElement element : listItems) {
			if (element.getText().contains(umaScope)) {
				found = true;
				break;
			}
		}
		return found;
	}

}
