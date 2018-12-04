package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;

@RunWith(SpringRunner.class)
public class HomeSteps extends BaseSteps{
	@Autowired
	private HomePage homePage;
	
	
	@Then("^I should see that there '(.+)' data in the dashboard$")
	public void checkDashboardStatus(String value) {
		homePage.checkDashboard(value);
	}
	
	@After
	public void clear() {
		homePage.clear();
	}

}
