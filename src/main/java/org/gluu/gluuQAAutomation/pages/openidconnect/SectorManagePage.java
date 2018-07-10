package org.gluu.gluuQAAutomation.pages.openidconnect;

import java.util.List;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class SectorManagePage extends AbstractPage {

	public void goToSectorAddPage() {
		WebElement element = webDriver.findElement(By.className("addSectorIdentifier"));
		element.click();
	}

	public void assertListIsNotEmpty() {
		Assert.assertFalse(isEmpty());
	}

	public void assertListIsEmpty() {
		Assert.assertTrue(isEmpty());
	}

	public boolean isEmpty() {
		WebElement form = webDriver.findElement(By.id("sectorIdentifiersFormId"));
		boolean isEmpty = false;
		try {
			WebElement table = form.findElement(By.tagName("table"));
			Assert.assertNotNull(table);
			WebElement body = table.findElement(By.tagName("tbody"));
			Assert.assertNotNull(body);
			List<WebElement> trs = table.findElements(By.tagName("tr"));
			Assert.assertNotNull(trs);
			Assert.assertNotNull(trs.get(0));
		} catch (Exception e) {
			isEmpty = true;
		}
		return isEmpty;
	}

}
