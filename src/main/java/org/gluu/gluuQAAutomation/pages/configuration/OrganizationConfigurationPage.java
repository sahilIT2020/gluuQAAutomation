package org.gluu.gluuQAAutomation.pages.configuration;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
@Component
public class OrganizationConfigurationPage extends AbstractPage {

	public void selectSMTPTab() {
		WebElement tabs=webDriver.findElement(By.className("nav-tabs"));
		
	}

}
