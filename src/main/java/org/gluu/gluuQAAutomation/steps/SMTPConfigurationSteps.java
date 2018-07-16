package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.configuration.OrganizationConfigurationPage;
import org.gluu.gluuQAAutomation.pages.configuration.SMTPConfigPage;
import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
public class SMTPConfigurationSteps extends BaseSteps {
	@Autowired
	private HomePage homePage;

	@Autowired
	private SMTPConfigPage smtpConfigPage;
	
	@Autowired
	private OrganizationConfigurationPage organizationConfigurationPage;

	@When("^I go to smtp configuration page$")
	public void goToSmtpPage() {
		homePage.goToOrganisationConfigurationMenuPage();
		organizationConfigurationPage.selectSMTPTab();
	}

}
