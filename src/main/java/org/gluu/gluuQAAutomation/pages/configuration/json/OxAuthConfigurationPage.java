package org.gluu.gluuQAAutomation.pages.configuration.json;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class OxAuthConfigurationPage extends AbstractPage {

	public void assertLoginPageIsCorrect() {
		WebElement element = webDriver.findElement(By.name("root[loginPage]"));
		Assert.assertNotNull(element);
	}

	public void assertAuthorizationPageIsCorrect() {
		WebElement element = webDriver.findElement(By.name("root[authorizationPage]"));
		Assert.assertNotNull(element);
	}

	public void assertAuthorizationEndPointIsCorrect() {
		WebElement element = webDriver.findElement(By.name("root[authorizationEndpoint]"));
		Assert.assertNotNull(element);
	}

	public void assertTokenEndPointIsCorrect() {
		WebElement element = webDriver.findElement(By.name("root[tokenEndpoint]"));
		Assert.assertNotNull(element);
	}

	public void assertUserInfoEndPointIsCorrect() {
		WebElement element = webDriver.findElement(By.name("root[userInfoEndpoint]"));
		Assert.assertNotNull(element);
	}

	public void assertClientInfoEndPointIsCorrect() {
		WebElement element = webDriver.findElement(By.name("root[clientInfoEndpoint]"));
		Assert.assertNotNull(element);
	}

	public void assertEndSessionEndPointIsCorrect() {
		WebElement element = webDriver.findElement(By.name("root[endSessionEndpoint]"));
		Assert.assertNotNull(element);
	}

	public void assertRegistrationEndPointIsCorrect() {
		WebElement element = webDriver.findElement(By.name("root[registrationEndpoint]"));
		Assert.assertNotNull(element);
	}

	public void assertOidcDiscoveryEndPointIsCorrect() {
		WebElement element = webDriver.findElement(By.name("root[openIdDiscoveryEndpoint]"));
		Assert.assertNotNull(element);
	}

	public void assertOidcConfigEndPointIsCorrect() {
		WebElement element = webDriver.findElement(By.name("root[openIdConfigurationEndpoint]"));
		Assert.assertNotNull(element);
	}

}
