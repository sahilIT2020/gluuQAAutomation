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

	public void goToUsersAddPage() {
		WebElement userMenu = webDriver.findElement(By.xpath("//*[@id='menuUsers']"));
		userMenu.click();
		WebElement element = waitElement("//*[@id='subMenuLinkUsers3']");
		element.click();
	}

	public void goToUsersSearchPage() {
		WebElement userMenu = webDriver.findElement(By.xpath("//*[@id='menuUsers']"));
		userMenu.click();
		WebElement userAddMenu = waitElement("//*[@id='subMenuLinkUsers2']");
		userAddMenu.click();
	}

	public void goToUsersImportPage() {
		WebElement userMenu = webDriver.findElement(By.xpath("//*[@id='menuUsers']"));
		userMenu.click();
		WebElement userAddMenu = waitElement("//*[@id='subMenuLinkUsers4']");
		userAddMenu.click();
	}

}
