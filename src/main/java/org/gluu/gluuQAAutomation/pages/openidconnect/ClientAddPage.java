package org.gluu.gluuQAAutomation.pages.openidconnect;

import java.util.List;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class ClientAddPage extends AbstractPage {

	public void setClientName(String name) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement element = main.findElement(By.className("clientNameTextBox"));
		element.click();
		for (WebElement input : element.findElements(By.tagName("input"))) {
			if (input.getAttribute("type").equals("text")) {
				input.clear();
				input.sendKeys(name);
				break;
			}
		}
	}

	public void setDescription(String des) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement element = main.findElement(By.className("clientDescriptionTextArea"));
		element.clear();
		element.sendKeys(des);
	}

	public void setSecret(String secret) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement element = main.findElement(By.className("clientSecretTextBox"));
		;
		element.clear();
		element.sendKeys(secret);
	}

	public void setType(String type) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement selectBox = main.findElement(By.className("applicationTypeSelectBox"));
		Select select = new Select(selectBox);
		select.selectByVisibleText(type);
	}

	public void setPreAutho(String value) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement selectBox = main.findElement(By.className("persistClientAuthorizationSelectBox"));
		Select select = new Select(selectBox);
		select.selectByVisibleText(value);
	}

	public void setPersistAutho(String value) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement selectBox = main.findElement(By.className("oxAuthTrustedClientSelectBox"));
		Select select = new Select(selectBox);
		select.selectByVisibleText(value);
	}

	public void setSubjectType(String value) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement selectBox = main.findElement(By.className("subjectTypeSelectBox"));
		Select select = new Select(selectBox);
		select.selectByVisibleText(value);
	}

	public void setAuthendMethod(String value) {
		WebElement main = webDriver.findElement(By.className("box-header"));
		WebElement selectBox = main.findElement(By.className("tokenEndpointAuthMethodSelectBox"));
		Select select = new Select(selectBox);
		select.selectByVisibleText(value);
	}

	public void addScope(String scope) {
		fluentWait(ONE_SEC);
		scrollDown();
		scrollDown();
		WebElement addScopeButton = webDriver.findElement(By.className("AddScopeButton"));
		addScopeButton.click();
		searchForScope(scope);
		confirm();
	}

	private void searchForScope(String value) {
		fluentWait(ONE_SEC);
		WebElement main = waitElementByID("scope:selectScopeModalPanel_content");
		WebElement searchText = main.findElement(By.className("searchParameters"));
		searchText.clear();
		searchText.sendKeys(value);
		main.findElements(By.className("btn-primary")).get(0).click();
		fluentWait(ONE_SEC);
		WebElement pane = waitElementByID("scope:selectScopeModalPanel_content");
		WebElement table = pane.findElements(By.tagName("table")).get(0);
		WebElement body = table.findElement(By.tagName("tbody"));
		WebElement row = body.findElements(By.tagName("tr")).get(0);
		row.findElements(By.tagName("td")).get(0).findElement(By.tagName("input")).click();
	}

	private void searchForResponseType(String id, String value) {
		WebElement pane = waitElementByID(id);
		WebElement firstTable = pane.findElements(By.tagName("table")).get(0);
		WebElement table = firstTable.findElements(By.tagName("table")).get(0);
		WebElement body = table.findElement(By.tagName("tbody"));
		List<WebElement> rows = body.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			if (row.getText().contains(value)) {
				row.findElements(By.tagName("td")).get(0).findElement(By.tagName("input")).click();
			}
		}
		List<WebElement> items = firstTable.findElements(By.className("btn-primary"));
		items.get(0).click();
	}

	private void confirm() {
		WebElement main = waitElementByID("scope:selectScopeModalPanel_content");
		WebElement footer = main.findElement(By.className("box-footer"));
		WebElement addButton = footer.findElements(By.tagName("input")).get(0);
		addButton.click();
	}

	public void responseType(String type) {
		scrollDown();
		fluentWait(ONE_SEC);
		waitElementByClass("box-header");
		WebElement addScopeButton = webDriver.findElement(By.className("AddResponseTypeButton"));
		addScopeButton.click();
		searchForResponseType("responseType:selectEntityModalPanel_content", type);
	}

	public void grantType(String grantType) {
		scrollDown();
		fluentWait(ONE_SEC);
		waitElementByClass("box-header");
		WebElement addScopeButton = webDriver.findElement(By.className("AddGrantTypeButton"));
		addScopeButton.click();
		searchForResponseType("grantType:selectEntityModalPanel_content", grantType);
	}

	public void loginRedirect(String url) {
		scrollDown();
		fluentWait(ONE_SEC);
		waitElementByClass("box-header");
		WebElement addScopeButton = webDriver.findElement(By.className("AddRedirectLoginUriButton"));
		addScopeButton.click();
		WebElement pane = waitElementByID("loginRedirect:inputText_container");
		WebElement main = pane.findElement(By.id("loginRedirect:inputText_content"));
		List<WebElement> inputs = main.findElements(By.cssSelector("input"));
		for (WebElement input : inputs) {
			if (input.getAttribute("type").equals("text")) {
				input.clear();
				input.sendKeys(url);
			}
		}

		WebElement footer = main.findElement(By.className("box-footer"));
		footer.findElements(By.tagName("input")).get(0).click();
	}

	public void save() {
		scrollDown();
		fluentWait(ONE_SEC);
		WebElement footer = waitElementByID("updateButtons");
		footer.findElements(By.tagName("input")).get(0).click();
	}

}
