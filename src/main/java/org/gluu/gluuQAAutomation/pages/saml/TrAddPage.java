package org.gluu.gluuQAAutomation.pages.saml;

import java.util.Arrays;
import java.util.List;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class TrAddPage extends AbstractPage {

	public void setDisplayName(String dn) {
		WebElement element = webDriver.findElement(By.id("trustForm:displayName:outputInputPanel"));
		element = element.findElement(By.tagName("input"));
		element.clear();
		element.sendKeys(dn);
	}

	public void setDescription(String des) {
		WebElement element = webDriver.findElement(By.id("trustForm:description:outputInputPanel"));
		element = element.findElement(By.tagName("textarea"));
		element.clear();
		element.sendKeys(des);

	}

	public void setEntityType(String type) {
		WebElement element = webDriver.findElement(By.id("trustForm:entityType:outputInputPanel"));
		element = element.findElement(By.tagName("select"));
		Select select = new Select(element);
		select.selectByVisibleText(type);
	}

	public void selectFederation(String federation) {
		fluentWait(ONE_SEC);
		WebElement element = webDriver.findElement(By.id("trustForm:spMetaDataSourceTypeFederation:outputInputPanel"));
		WebElement box = element.findElement(By.tagName("select"));
		Select select = new Select(box);
		select.selectByVisibleText(federation);
	}

	public void setMetadataType(String mtype) {
		if (mtype.equalsIgnoreCase("federation")) {
			fluentWait(LARGE);
		}
		fluentWait(ONE_SEC);
		WebElement element = waitElementByID("trustForm:spMetaDataSourceType:outputInputPanel");
		WebElement box = element.findElement(By.tagName("select"));
		Select select = new Select(box);
		select.selectByVisibleText(mtype);
	}

	public void setMetadata() {
		fluentWait(ONE_SEC);
		String path = getUserDir().concat("/src/main/resources/qa_meta.xml");
		WebElement element = webDriver.findElement(By.id("trustForm:fileWrapper:outputInputPanel"));
		WebElement fileUploader = element.findElement(By.cssSelector("input[type='file']"));
		fileUploader.sendKeys(path);
		fluentWait(ONE_SEC);
	}

	public void configureRp(String profile) {
		fluentWait(ONE_SEC);
		WebElement element = webDriver.findElement(By.id("trustForm:configureSpecific:outputInputPanel"));
		element = element.findElement(By.tagName("input"));
		element.click();
		fluentWait(ONE_SEC);
		WebElement link = waitElementByID("trustForm:configureSpecific:RelyingPartyConfig");
		link.click();

		pickprofileAndSave(profile);
	}

	private void pickprofileAndSave(String profile) {
		WebElement popup = waitElementByID("TRConfigPanel_content_scroller");
		List<WebElement> options = popup.findElements(By.className("rf-pick-opt"));
		for (WebElement option : options) {
			if (option.getText().contains(profile)) {
				option.click();
			}
		}

		List<WebElement> buttons = popup.findElements(By.tagName("button"));
		for (WebElement button : buttons) {
			if (button.getText().endsWith("Add")) {
				button.click();
			}
		}
		fluentWait(ONE_SEC);
		WebElement footer = webDriver.findElement(By.id("relyingPartyUpdate"));
		footer.findElements(By.tagName("input")).get(0).click();
		fluentWait(ONE_SEC);
	}

	public void save() {
		WebElement footer = webDriver.findElement(By.id("updateButtons"));
		footer.findElements(By.tagName("input")).get(0).click();
		fluentWait(LITTLE);
	}

	public void releaseAttributes(String attributes) {
		List<String> attribs = Arrays.asList(attributes.split("\\s+"));
		WebElement panel = webDriver.findElement(By.id("trustForm:attributeTabPanelId"));
		WebElement sidePanel = panel.findElement(By.className("sidebar-menu"));
		for (String attri : attribs) {
			List<WebElement> lis = sidePanel.findElements(By.tagName("li"));
			for (WebElement li : lis) {
				if (li.getText().startsWith(attri)) {
					li.click();
					break;
				}
			}
		}
	}

	public void setFederationMetatData() {
		fluentWait(ONE_SEC);
		String path = getUserDir().concat("/src/main/resources/testshib-providers.xml");
		WebElement element = webDriver.findElement(By.id("trustForm:fileWrapper:outputInputPanel"));
		WebElement fileUploader = element.findElement(By.cssSelector("input[type='file']"));
		fileUploader.sendKeys(path);
		fluentWait(ONE_SEC);
	}

	public void selectId(String value) {
		WebElement link = webDriver
				.findElement(By.id("trustForm:spMetaDataSourceTypeFederationEntitySelection:outputInputPanel"));
		link.findElement(By.tagName("a")).click();
		fluentWait(ONE_SEC);
		WebElement main = webDriver.findElement(By.id("entityIdSelector_content"));
		WebElement select = main.findElement(By.tagName("select"));
		Select selectBox = new Select(select);
		selectBox.selectByVisibleText(value);
		main.findElement(By.id("EntityIdUpdate")).findElement(By.tagName("input")).click();
	}

	public void waitForTrValidation() {
		fluentWait(MINUTE);
	}
}
