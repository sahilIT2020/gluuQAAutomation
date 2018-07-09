package org.gluu.gluuQAAutomation.pages.openidconnect;

import java.util.Arrays;
import java.util.List;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class ClientAddPage extends AbstractPage {

	public void setClientName(String name) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement nameArea = main.findElement(By.id("clientForm:displayName:outputInputPanel"));
		nameArea.click();
		List<WebElement> span = nameArea.findElements(By.tagName("span"));
		List<WebElement> inputs = span.get(1).findElements(By.cssSelector("input"));
		for (WebElement input : inputs) {
			if (input.getAttribute("type").equals("text")) {
				input.clear();
				input.sendKeys(name);
				input.sendKeys(Keys.TAB);
				break;
			}
		}
	}

	public void setDescription(String des) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement descriptionArea = main.findElement(By.id("clientForm:description:outputInputPanel"));
		WebElement description = descriptionArea.findElement(By.tagName("textarea"));
		description.clear();
		description.sendKeys(des);
	}

	public void setSecret(String secret) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement nameArea = main.findElement(By.id("clientForm:clientSecret:outputInputPanel"));
		nameArea.click();
		List<WebElement> span = nameArea.findElements(By.tagName("span"));
		List<WebElement> inputs = span.get(1).findElements(By.cssSelector("input"));
		for (WebElement input : inputs) {
			if (input.getAttribute("type").equals("text")) {
				input.clear();
				input.sendKeys(secret);
				input.sendKeys(Keys.TAB);
				break;
			}
		}
	}

	public void setType(String type) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement typeArea = main.findElement(By.id("clientForm:applicatonType:outputInputPanel"));
		WebElement selectBox = typeArea.findElement(By.tagName("select"));
		Select select = new Select(selectBox);
		select.selectByVisibleText(type);
	}

	public void setPreAutho(String value) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement typeArea = main.findElement(By.id("clientForm:oxAuthTrustedClientBox:outputInputPanel"));
		WebElement selectBox = typeArea.findElement(By.tagName("select"));
		Select select = new Select(selectBox);
		select.selectByVisibleText(value);
	}

	public void setPersistAutho(String value) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement typeArea = main.findElement(By.id("clientForm:persistClientAuthorizations:outputInputPanel"));
		WebElement selectBox = typeArea.findElement(By.tagName("select"));
		Select select = new Select(selectBox);
		select.selectByVisibleText(value);
	}

	public void setSubjectType(String value) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement typeArea = main.findElement(By.id("clientForm:subjectType:outputInputPanel"));
		WebElement selectBox = typeArea.findElement(By.tagName("select"));
		Select select = new Select(selectBox);
		select.selectByVisibleText(value);
	}

	public void setAuthendMethod(String value) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement typeArea = main.findElement(By.id("clientForm:tokenEndpointAuthMethod:outputInputPanel"));
		WebElement selectBox = typeArea.findElement(By.tagName("select"));
		Select select = new Select(selectBox);
		select.selectByVisibleText(value);
	}

	public void addScope(String scope) {
		WebElement commandSection = webDriver.findElement(By.id("clientForm:command:outputInputPanel"));
		commandSection.findElement(By.className("addScopeButton")).click();
		waitFewSeconds(2000);
		searchFor(scope);
		confirm();
		waitFewSeconds(2000);
	}

	private void searchFor(String value) {
		WebElement main = webDriver.findElement(By.id("scope:selectScopeModalPanel_content"));
		WebElement searchText = main.findElement(By.className("searchParameters"));
		searchText.clear();
		searchText.sendKeys(value);
		main.findElements(By.className("btn-primary")).get(0).click();
		waitFewSeconds(1000);
		WebElement pane = webDriver.findElement(By.id("scope:selectScopeModalPanel_content"));
		WebElement table = pane.findElements(By.tagName("table")).get(0);
		WebElement body = table.findElement(By.tagName("tbody"));
		WebElement row = body.findElements(By.tagName("tr")).get(0);
		row.findElements(By.tagName("td")).get(0).findElement(By.tagName("input")).click();
	}

	private void confirm() {
		WebElement main = webDriver.findElement(By.id("scope:selectScopeModalPanel_content"));
		WebElement footer = main.findElement(By.className("box-footer"));
		WebElement addButton = footer.findElements(By.tagName("input")).get(0);
		addButton.click();
	}

	public void addScopes(String scopes) {
		List<String> allScopes = Arrays.asList(scopes.split("\\s+"));
		for (String scope : allScopes) {
			System.out.println("##########Scope:" + scope);
			addScope(scope);
			waitFewSeconds(1000);
		}
	}

}
