package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.gluu.gluuQAAutomation.pages.profile.ProfilePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
public class ProfileSteps extends BaseSteps {

	@Autowired
	private HomePage homePage;

	@Autowired
	private ProfilePage profilePage;

	@When("^I go to my profile page$")
	public void goToProfilePage() {
		homePage.goToProfileViewMenu();
	}

	@And("^I change my password from '(.+)' to '(.+)'$")
	public void changePassword(String oldPwd, String newPwd) {
		profilePage.changePassword(oldPwd,newPwd);
	}

}
