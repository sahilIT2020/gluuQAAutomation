package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.gluu.gluuQAAutomation.pages.configuration.ViewLogFilePage;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
public class LogFileSteps extends BaseSteps {

	@Autowired
	private HomePage homePage;
	@Autowired
	private ViewLogFilePage viewLogFilePage;


	@When("^I go to view log file page$")
	public void goToScopeManagePage() {
		homePage.goToLogFileViewMenuPage();
	}

	@Then("^I should see log files named '(.+)' and '(.+)'")
	public void assertLogFilesExist(String oxTrustLogs, String oxAuthLogs ) {
		viewLogFilePage.assertLogFilesExist(oxTrustLogs,oxAuthLogs);
	}
	@After
	public void clear() {
		System.out.println("#########clear browser cookies##########");
		homePage.clear();
	}

}

