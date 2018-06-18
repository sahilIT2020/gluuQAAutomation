package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.gluu.gluuQAAutomation.pages.users.UserAddPage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
public class UserSteps extends BaseSteps {
	@Override
	public void setup() {
		userAddPage.open();
	}

	@Autowired
	private HomePage homePage;
	@Autowired
	private UserAddPage userAddPage;

	@When("^I go to user add page$")
	public void goToUserAddPage() {
		homePage.goToUsersAddPage();
	}

	@And("^I add a user named '(.+)'$")
	public void setUserName(String userName) {
		userAddPage.fillUserName(userName);
	}

	@And("^With first name '(.+)'$")
	public void setFirstName(String firstName) {
		userAddPage.fillFirstName(firstName);
	}

	@And("^With last name '(.+)'$")
	public void setLastName(String lastName) {
		userAddPage.fillLastName(lastName);
	}

	@And("^With display name '(.+)'$")
	public void setDisplayName(String displayName) {
		userAddPage.fillDisplayName(displayName);
	}

	@And("^With email '(.+)'$")
	public void setEmail(String email) {
		userAddPage.fillEmail(email);
	}

	@And("^With password '(.+)'$")
	public void setPassword(String pwd) {
		userAddPage.fillPassword(pwd);
	}

	@And("^With status '(.+)'$")
	public void setStatus(String status) {
		userAddPage.fillStatus(status);
	}

	@And("^I save the user$")
	public void saveUser() {
		userAddPage.save();
	}

	@Override
	public void cleanUp() {
		userAddPage.close();
	}

}
