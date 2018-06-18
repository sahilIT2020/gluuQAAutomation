package org.gluu.gluuQAAutomation.pages.users;

import java.util.List;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class UserAddPage extends AbstractPage {
	private WebElement form;
	private List<WebElement> sections;

	public void fillUserName(String userName) {
		form = webDriver.findElement(By.xpath("//*[@id='j_idt162:selectedCustomAttributesId']"));
		sections = form.findElements(By.tagName("div"));
		WebElement userNameSection = sections.get(0);
		sections = userNameSection.findElements(By.xpath("following-sibling::div"));
		List<WebElement> elements = userNameSection.findElements(By.tagName("div"));
		WebElement userNameDiv = elements.get(1);
		userNameDiv.click();
		List<WebElement> userNameElements = userNameDiv.findElements(By.tagName("input"));
		Assert.assertTrue(userNameElements.size() == 2);
		userNameElements.get(1).sendKeys(userName);
		userNameElements.get(1).sendKeys(Keys.RETURN);
	}

	public void fillFirstName(String firstName) {
		WebElement userFirstNameSection = sections.get(0);
		List<WebElement> elements = userFirstNameSection.findElements(By.tagName("div"));
		WebElement userNameDiv = elements.get(1);
		userNameDiv.click();
		List<WebElement> userNameElements = userNameDiv.findElements(By.tagName("input"));
		Assert.assertTrue(userNameElements.size() == 2);
		userNameElements.get(1).sendKeys(firstName);
		userNameElements.get(1).sendKeys(Keys.RETURN);
	}

	public void fillLastName(String lastName) {
		WebElement userFirstNameSection = sections.get(2);
		List<WebElement> elements = userFirstNameSection.findElements(By.tagName("div"));
		WebElement userNameDiv = elements.get(1);
		userNameDiv.click();
		List<WebElement> userNameElements = userNameDiv.findElements(By.tagName("input"));
		Assert.assertTrue(userNameElements.size() == 2);
		userNameElements.get(1).sendKeys(lastName);
		userNameElements.get(1).sendKeys(Keys.RETURN);

	}

	public void fillDisplayName(String displayName) {
		WebElement userFirstNameSection = sections.get(1);
		List<WebElement> elements = userFirstNameSection.findElements(By.tagName("div"));
		WebElement userNameDiv = elements.get(1);
		userNameDiv.click();
		List<WebElement> userNameElements = userNameDiv.findElements(By.tagName("input"));
		Assert.assertTrue(userNameElements.size() == 2);
		userNameElements.get(1).sendKeys(displayName);
		userNameElements.get(1).sendKeys(Keys.RETURN);
	}

	public void fillEmail(String email) {
		WebElement userFirstNameSection = sections.get(3);
		List<WebElement> elements = userFirstNameSection.findElements(By.tagName("div"));
		WebElement userNameDiv = elements.get(1);
		userNameDiv.click();
		List<WebElement> userNameElements = userNameDiv.findElements(By.tagName("input"));
		Assert.assertTrue(userNameElements.size() == 2);
		userNameElements.get(1).sendKeys(email);
		userNameElements.get(1).sendKeys(Keys.RETURN);
	}

	public void fillPassword(String pwd) {
		WebElement passwordSection = sections.get(4);
		List<WebElement> elements = passwordSection.findElements(By.tagName("div"));
		WebElement passWordDiv = elements.get(1);
		passWordDiv = passWordDiv.findElement(By.tagName("div"));
		passWordDiv.click();
		passWordDiv = passWordDiv.findElement(By.tagName("span"));
		passWordDiv.click();
		List<WebElement> userNameElements = passWordDiv.findElements(By.tagName("input"));
		Assert.assertTrue(userNameElements.size() == 2);
		userNameElements.get(1).click();
		userNameElements.get(1).sendKeys(pwd);
		userNameElements.get(1).sendKeys(Keys.RETURN);

		fillPassword2(pwd);
	}

	private void fillPassword2(String pwd) {
		WebElement passwordSection = sections.get(5);
		List<WebElement> elements = passwordSection.findElements(By.tagName("div"));
		WebElement passWordDiv = elements.get(1);
		passWordDiv = passWordDiv.findElement(By.tagName("div"));
		passWordDiv.click();
		passWordDiv = passWordDiv.findElement(By.tagName("span"));
		passWordDiv.click();
		List<WebElement> userNameElements = passWordDiv.findElements(By.tagName("input"));
		Assert.assertTrue(userNameElements.size() == 2);
		userNameElements.get(1).click();
		userNameElements.get(1).sendKeys(pwd);
		userNameElements.get(1).sendKeys(Keys.RETURN);
	}

	public void fillStatus(String status) {
		WebElement userFirstNameSection = sections.get(6);
		List<WebElement> elements = userFirstNameSection.findElements(By.tagName("div"));
		WebElement userNameDiv = elements.get(1);
		userNameDiv.click();
		WebElement dropDown = userNameDiv.findElement(By.tagName("select"));
		Select select = new Select(dropDown);
		select.selectByVisibleText(status);
		userFirstNameSection.click();
	}

	public void save() {
		WebElement footer = webDriver.findElement(By.className("box-footer"));
		footer = footer.findElement(By.tagName("div"));
		List<WebElement> buttons = footer.findElements(By.tagName("input"));
		buttons.get(0).click();
		wait(60);
	}

}
