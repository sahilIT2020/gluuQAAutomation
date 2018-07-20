package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.configuration.OxAuthSettingPage;
import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
public class OxAuthSettingSteps extends BaseSteps {

	@Autowired
	private HomePage homePage;

	@Autowired
	private OxAuthSettingPage oxAuthSettingPage;

	@When("^I go to oxauth setting configuration page$")
	public void goToSmtpPage() {
		homePage.goToOrganisationConfigurationMenuPage();
		oxAuthSettingPage.selectTab("oxAuth Settings");
	}

	@Then("^I should that the server ip is empty$")
	public void checkIpIsEmpty() {
		oxAuthSettingPage.checkServerIpIsEmpty();
	}
	
	@After
	public void clear() {
		homePage.clear();
	}

}
