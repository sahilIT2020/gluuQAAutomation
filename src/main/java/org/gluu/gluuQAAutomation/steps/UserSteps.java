package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.gluu.gluuQAAutomation.pages.users.UserAddPage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

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

	@When("I go to user add page")
	public void goToUserAddPage() {
		homePage.goToUsersAddPage();
	}

	@Override
	public void cleanUp() {
		userAddPage.close();
	}

}
