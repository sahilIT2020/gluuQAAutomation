package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.GluuQaAutomationApplication;
import org.gluu.gluuQAAutomation.pages.login.SignInPage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { GluuQaAutomationApplication.class, SignInPage.class })
@SpringBootTest
public class SignInSteps {

	@Autowired
	private SignInPage signInPage;

	@When("^I sign in as administrator$")
	public void signInAsAdmin() {
		signInPage.goToLoginPage();
		signInPage.fillFormAsAdmin();
		signInPage.submit();
	}

	@When("^I sign in with username '(.+)' and password '(.+)'$")
	public void signInWithUserNameAndPassword(String userName, String password) {
		signInPage.goToLoginPage();
		signInPage.fillForm(userName, password);
		signInPage.submit();
	}

	@Then("^I should see gluu home page$")
	public void assertCurrentPageIsAdminPage() {
		signInPage.checkCurrentPageIsHomePage();
	}

}
