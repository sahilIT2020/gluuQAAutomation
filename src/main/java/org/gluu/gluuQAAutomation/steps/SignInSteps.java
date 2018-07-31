package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.GluuQaAutomationApplication;
import org.gluu.gluuQAAutomation.pages.login.PasswordResetPage;
import org.gluu.gluuQAAutomation.pages.login.SignInPage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { GluuQaAutomationApplication.class })
public class SignInSteps extends BaseSteps {
	@Autowired
	private SignInPage signInPage;

	@Autowired
	private PasswordResetPage passwordResetPage;

	@When("^I sign in as administrator$")
	public void signInAsAdmin() {
		signInPage.goToLoginPage();
		signInPage.fillFormAsAdmin();
		signInPage.submit();
	}
	
	@Then("^I should be able to login as '(.+)' with password '(.+)'$")
	public void loginAsUserWithPassword(String userName,String pwd) {
		signInPage.goToLoginPage();
		signInPage.fillForm(userName, pwd);
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

	@When("^I sign out$")
	public void signOut() {
		signInPage.signOut();
	}

	@Then("^I should see the gluu login page$")
	public void checkLoginPage() {
		signInPage.checkCurrentPageIsLoginPage();
	}

	@And("^I click on password reset link$")
	public void clickPasswordReset() {
		signInPage.clickForgotPasswordLink();
	}

	@And("^I send the mail$")
	public void sendMail() {
		passwordResetPage.sendMail();
	}

	@After
	public void clear() {
		signInPage.clear();
	}

	@Then("^I set '(.+)' as email$")
	public void setEmail(String email) {
		passwordResetPage.setEmail(email);
	}
	
	@Then("^I should see that the mail was send$")
	public void  checkEmailWasSend() {
		passwordResetPage.verifyMailWasSend();
	}

}