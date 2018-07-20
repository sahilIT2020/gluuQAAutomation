package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.configuration.authentication.PassportAuthenticationPage;
import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
public class ManageAuthenticationSteps extends BaseSteps {
	@Autowired
	private HomePage homePage;

	@Autowired
	private PassportAuthenticationPage authenticationPage;

	@When("^I go to strategy page$")
	public void goToAuthenticationManagePage() {
		homePage.goToManageAutheticationMenuPage();
		authenticationPage.selectTab("Passport Authentication Method");
	}

	@And("^I add new strategy named '(.+)' with id '(.+)' and secret '(.+)'$")
	public void addNewStrategy(String name, String id, String secret) {
		authenticationPage.addStrategy(name, id, secret);
	}

	@And("^I enable passport status to '(.+)'$")
	public void setPassportStatus(String status) {
		authenticationPage.setPassportStatus(status);
	}

	@And("^I save the passport status changed$")
	public void save() {
		authenticationPage.save();
	}

	@After
	public void clear() {
		homePage.clear();
	}

}
