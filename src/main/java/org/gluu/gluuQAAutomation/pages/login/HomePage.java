package org.gluu.gluuQAAutomation.pages.login;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends AbstractPage {

	public void goToUsersMenu() {
		WebElement userMenu = webDriver.findElement(By.xpath("//*[@id='menuUsers']"));
		userMenu.click();
	}

	public void goToConfigurationMenu() {
		WebElement configurationMenu = webDriver.findElement(By.xpath("//*[@id='menuConfiguration']"));
		configurationMenu.click();
	}

	public void goSamlMenu() {
		WebElement samlMenu = webDriver.findElement(By.xpath("//*[@id='menuSAML']"));
		samlMenu.click();
	}

	public void goToProfileMenu() {
		WebElement profileMenu = webDriver.findElement(By.xpath("//*[@id='menuPersonal']"));
		profileMenu.click();
	}

	public void goToProfileViewMenu() {
		WebElement userMenu = webDriver.findElement(By.xpath("//*[@id='menuPersonal']"));
		userMenu.click();
		WebElement subMenu = waitElementByID("subMenuLinkPersonal1");
		subMenu.click();
	}

	public void goToUmaMenu() {
		WebElement umaMenu = webDriver.findElement(By.xpath("//*[@id='menuUMA']"));
		umaMenu.click();
		WebElement subMenu = waitElementByID("subMenuLinkUMA1");
		subMenu.click();
	}

	public void goToUmaScopeManagePage() {
		WebElement userMenu = waitElement("//*[@id='menuUMA']");
		userMenu.click();
		WebElement subMenu = waitElementByID("subMenuLinkUMA1");
		subMenu.click();
	}

	public void goToUmaResourceManagePage() {
		WebElement umaMenu = webDriver.findElement(By.xpath("//*[@id='menuUMA']"));
		umaMenu.click();
		WebElement subMenu = waitElementByID("subMenuLinkUMA2");
		subMenu.click();
	}

	public void goToOpenIDMenu() {
		WebElement openIdMenu = webDriver.findElement(By.xpath("//*[@id='menuOpenID']"));
		openIdMenu.click();
	}

	public void goToGroupAddPage() {
		goToGroupsManagePage();
		WebElement addButton = webDriver.findElement(By.className("addGroup"));
		addButton.click();
	}

	public void goToGroupsManagePage() {
		WebElement groupMenu = webDriver.findElement(By.xpath("//*[@id='menuUsers']"));
		groupMenu.click();
		WebElement subMenu = waitElement("//*[@id='subMenuLinkUsers1']");
		subMenu.click();
	}

	public void goToUsersManagePage() {
		WebElement userMenu = webDriver.findElement(By.xpath("//*[@id='menuUsers']"));
		userMenu.click();
		WebElement subMenu = waitElement("//*[@id='subMenuLinkUsers2']");
		subMenu.click();
	}

	public void goToUsersAddPage() {
		WebElement userMenu = webDriver.findElement(By.xpath("//*[@id='menuUsers']"));
		userMenu.click();
		WebElement subMenu = waitElement("//*[@id='subMenuLinkUsers3']");
		subMenu.click();
	}

	public void goToUsersImportPage() {
		WebElement userMenu = webDriver.findElement(By.xpath("//*[@id='menuUsers']"));
		userMenu.click();
		WebElement subMenu = waitElement("//*[@id='subMenuLinkUsers4']");
		subMenu.click();
	}

	public void goToOpenIDScopePage() {
		WebElement openIdMenu = webDriver.findElement(By.xpath("//*[@id='menuOpenID']"));
		openIdMenu.click();

		WebElement subMenu = waitElement("//*[@id='subMenuLinkOpenID1']");
		subMenu.click();
	}

	public void goToOpenIDClientsListPage() {
		WebElement openIdMenu = webDriver.findElement(By.xpath("//*[@id='menuOpenID']"));
		openIdMenu.click();
		WebElement subMenu = waitElement("//*[@id='subMenuLinkOpenID2']");
		subMenu.click();		
	}
	public void goToSectorListPage() {
		WebElement openIdMenu = webDriver.findElement(By.xpath("//*[@id='menuOpenID']"));
		openIdMenu.click();
		WebElement subMenu = waitElement("//*[@id='subMenuLinkOpenID3']");
		subMenu.click();		
	}

}
