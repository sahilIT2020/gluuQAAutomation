package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.configuration.OxTrustSettingPage;
import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
public class OxTrustSettingSteps extends BaseSteps {

	@Autowired
	private HomePage homePage;

	@Autowired
	private OxTrustSettingPage oxTrustSettingPage;

	@When("^I go to oxtrust setting configuration page$")
	public void goToSmtpPage() {
		homePage.goToOrganisationConfigurationMenuPage();
		oxTrustSettingPage.selectTab("OxTrust Settings");
	}

	@Then("^I should that the org name is not empty$")
	public void checkOrgNameIsNotEmpty() {
		oxTrustSettingPage.checkOrgNameIsNotEmpty();
	}

	@And("^I should that '(.+)' is the admin group$")
	public void checkgroup(String group) {
		oxTrustSettingPage.checkGroup(group);
	}

	@Then("^I set the default qa logo as organisation logo$")
	public void setOrgLogo() {
		oxTrustSettingPage.setLogo();
	}

	@Then("^I set the default qa logo as organisation favicon$")
	public void setOrgFavIcon() {
		oxTrustSettingPage.setFavIcon();
	}

	@And("^I set the new org name to '(.+)'$")
	public void setOrgName(String orgName) {
		oxTrustSettingPage.setOrgName(orgName);
	}

	@And("^I should that the org name is '(.+)'$")
	public void checkOrgName(String orgName) {
		oxTrustSettingPage.checkOrgName(orgName);
	}
	
	@And("^I set the oxtrust logging level to '(.+)'$")
	public void setOxTrustLogLevel(String level) {
		oxTrustSettingPage.setLogLevel(level);
	}

	@And("^I save the oxtrust configuration$")
	public void saveOxtrustConfig() {
		oxTrustSettingPage.save();
	}

	@After
	public void clear() {
		homePage.clear();
	}

}
