package org.gluu.gluuQAAutomation.pages.openidconnect;

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
		fluentWait(LITTLE);
		scrollDown();
		scrollDown();
		WebElement commandSection = waitElementByID("clientForm:command:outputInputPanel");
		WebElement addScopeButton = commandSection.findElement(By.className("addScopeButton"));
		addScopeButton.click();
		searchForScope(scope);
		confirm();
	}

	private void searchForScope(String value) {
		fluentWait(SMALL);
		WebElement main = waitElementByID("scope:selectScopeModalPanel_content");
		WebElement searchText = main.findElement(By.className("searchParameters"));
		searchText.clear();
		searchText.sendKeys(value);
		main.findElements(By.className("btn-primary")).get(0).click();
		fluentWait(SMALL);
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
		fluentWait(LITTLE);
		waitElementByClass("box-header");
		waitElementByID("clientForm:displayName:outputInputPanel");
		WebElement commandSection = waitElementByID("clientForm:command:outputInputPanel");
		WebElement addScopeButton = commandSection.findElement(By.className("addResponseTypeButton"));
		addScopeButton.click();
		searchForResponseType("responseType:selectEntityModalPanel_content", type);
	}

	public void grantType(String grantType) {
		scrollDown();
		fluentWait(LITTLE);
		waitElementByClass("box-header");
		waitElementByID("clientForm:displayName:outputInputPanel");
		WebElement commandSection = waitElementByID("clientForm:command:outputInputPanel");
		WebElement addScopeButton = commandSection.findElement(By.className("addGrantTypeButton"));
		addScopeButton.click();
		searchForResponseType("grantType:selectEntityModalPanel_content", grantType);
	}

	public void loginRedirect(String url) {
		scrollDown();
		fluentWait(LITTLE);
		waitElementByClass("box-header");
		waitElementByID("clientForm:displayName:outputInputPanel");
		WebElement commandSection = waitElementByID("clientForm:command:outputInputPanel");
		WebElement addScopeButton = commandSection.findElement(By.className("addLoginRedirectButton"));
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
		fluentWait(LITTLE);
		WebElement footer = waitElementByID("updateButtons");
		footer.findElements(By.tagName("input")).get(0).click();
	}

}
