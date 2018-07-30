package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.configuration.RegistrationManagePage;
import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

@RunWith(SpringRunner.class)
public class RegistrationSteps extends BaseSteps {

	@Autowired
	private HomePage homePage;

	@Autowired
	private RegistrationManagePage registrationManagePage;

	@And("^I go to registration manage page$")
	public void goToRegistrationManagePage() {
		homePage.goToManageRegistrationMenuPage();
	}

	@Then("^I should see that the captcha status is '(.+)'")
	public void checkCaptcha(String status) {
		registrationManagePage.checkCaptchaIsEnable(status);
	}

	@Then("^I should see that the registration status is '(.+)'")
	public void checkRegistration(String status) {
		registrationManagePage.checkRegistrationAttribIsEnable(status);
	}

	@Then("^I should see that the site key is '(.+)'")
	public void checkSiteKey(String key) {
		registrationManagePage.checkSiteKey(key);
	}

	@Then("^I should see that the site secret is '(.+)'")
	public void checkSiteSecret(String secret) {
		registrationManagePage.checkSiteSecret(secret);
	}

	@Then("^I should see that the css location is '(.+)'")
	public void checkCssLocation(String location) {
		registrationManagePage.checkCssLocation(location);
	}

	@Then("^I should see that the js location is '(.+)'")
	public void checkJsLocation(String location) {
		registrationManagePage.checkJsLocation(location);
	}

	@After
	public void clear() {
		homePage.clear();
	}

}
