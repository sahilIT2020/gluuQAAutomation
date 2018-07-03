package org.gluu.gluuQAAutomation.pages.users;

import java.util.List;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

@Component
public class UserUpdatePage extends AbstractPage {
	private WebElement form;
	private List<WebElement> sections;

	public void fillDisplayName(String name) {
		form = webDriver.findElement(By.className("selectedCustomAttributesId"));
		sections = form.findElements(By.tagName("div"));
		WebElement userNameSection = sections.get(0);
		sections = userNameSection.findElements(By.xpath("following-sibling::div"));
		List<WebElement> elements = userNameSection.findElements(By.tagName("div"));
		WebElement userNameDiv = elements.get(1);
		userNameDiv.click();
		List<WebElement> userNameElements = userNameDiv.findElements(By.tagName("input"));
		Assert.assertTrue(userNameElements.size() == 2);
		userNameElements.get(1).clear();
		userNameElements.get(1).sendKeys(name);
		userNameElements.get(1).sendKeys(Keys.RETURN);
	}

	public void fillUserName(String name) {
		scrollDown();
		WebElement userFirstNameSection = sections.get(7);
		List<WebElement> elements = userFirstNameSection.findElements(By.tagName("div"));
		WebElement userNameDiv = elements.get(1);
		Actions actions = new Actions(webDriver);
		actions.moveToElement(userNameDiv).click().perform();
		List<WebElement> userNameElements = userNameDiv.findElements(By.tagName("input"));
		Assert.assertTrue(userNameElements.size() == 2);
		userNameElements.get(1).clear();
		userNameElements.get(1).sendKeys(name);
		userNameElements.get(1).sendKeys(Keys.RETURN);
	}

	public void fillEmail(String email) {
		WebElement userFirstNameSection = sections.get(1);
		List<WebElement> elements = userFirstNameSection.findElements(By.tagName("div"));
		WebElement userNameDiv = elements.get(1);
		userNameDiv.click();
		List<WebElement> userNameElements = userNameDiv.findElements(By.tagName("input"));
		Assert.assertTrue(userNameElements.size() == 2);
		userNameElements.get(1).clear();
		userNameElements.get(1).sendKeys(email);
		userNameElements.get(1).sendKeys(Keys.RETURN);
	}

	public void save() {
		WebElement footer = webDriver.findElement(By.className("updateButtons"));
		List<WebElement> buttons = footer.findElements(By.tagName("input"));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(buttons.get(1)).click().perform();
	}

	public void delete() {
		WebElement footer = webDriver.findElement(By.className("updateButtons"));
		List<WebElement> buttons = footer.findElements(By.tagName("input"));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(buttons.get(2)).click().perform();

		WebElement dialog = webDriver.findElement(By.id("deleteConfirmation:acceptRemovalModalPanel_content"));
		dialog.findElements(By.tagName("input")).get(0).click();
	}

	public void cancel() {
		WebElement footer = webDriver.findElement(By.className("updateButtons"));
		List<WebElement> buttons = footer.findElements(By.tagName("input"));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(buttons.get(3)).click().perform();
	}

	public void changePassword(String pwd) {

		WebElement footer = webDriver.findElement(By.className("updateButtons"));
		List<WebElement> buttons = footer.findElements(By.tagName("input"));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(buttons.get(0)).click().perform();

		WebElement form = webDriver.findElement(By.id("personPassword:changePasswordForm:passwordGroupId"));
		List<WebElement> passwordFields = form.findElements(By.tagName("input"));
		for (WebElement element : passwordFields) {
			element.clear();
			element.sendKeys(pwd);
		}
		List<WebElement> spans = form.findElements(By.xpath("following-sibling::span"));
		spans.get(0).findElements(By.tagName("input")).get(0).click();
		
		computeHeavy(10000);
	}

}
