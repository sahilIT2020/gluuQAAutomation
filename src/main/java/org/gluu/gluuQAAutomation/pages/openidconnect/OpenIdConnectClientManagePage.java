package org.gluu.gluuQAAutomation.pages.openidconnect;

import java.util.List;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class OpenIdConnectClientManagePage extends AbstractPage {

	public void searchFor(String scope) {
		WebElement searchBox = webDriver.findElement(By.className("searchBoxClass"));
		searchBox.clear();
		searchBox.sendKeys(scope);
		performSearch();
	}

	private void performSearch() {
		webDriver.findElement(By.className("searchButtonClass")).click();
		waitFewSeconds(3000);
	}

	public void assertClientExist(String clientName) {
		Assert.assertTrue(assertClientExistInList(clientName));
	}

	private boolean assertClientExistInList(String clientName) {
		try {
			webDriver.findElement(By.className("umaClientListClass"));
			WebElement body = webDriver.findElement(By.className("umaClientListClass"))
					.findElements(By.tagName("tbody")).get(0);
			List<WebElement> listItems = body.findElements(By.tagName("tr"));
			boolean found = false;
			for (WebElement element : listItems) {
				if (element.getText().contains(clientName)) {
					found = true;
					break;
				}
			}
			return found;
		} catch (Exception e) {
			return false;
		}

	}

	public void editScope(String scope) {
		webDriver.findElement(By.className("umaClientListClass"));
		WebElement body = webDriver.findElement(By.className("umaClientListClass")).findElements(By.tagName("tbody"))
				.get(0);
		List<WebElement> listItems = body.findElements(By.tagName("tr"));
		for (WebElement element : listItems) {
			if (element.getText().contains(scope)) {
				element.findElements(By.tagName("td")).get(0).click();
				break;
			}
		}
	}

	public void goToClientAddPage() {
		webDriver.findElement(By.className("addClientButtonClass")).click();
	}

}
