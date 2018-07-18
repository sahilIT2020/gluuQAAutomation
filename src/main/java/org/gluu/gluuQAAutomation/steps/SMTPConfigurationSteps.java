package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.configuration.OrganizationConfigurationPage;
import org.gluu.gluuQAAutomation.pages.configuration.SMTPConfigPage;
import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.en.And;
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
		organizationConfigurationPage.selectTab("SMTP Server Configuration");
	}

	@And("^I set '(.+)' as smtp host$")
	public void setSmtpHost(String host) {
		smtpConfigPage.setSmtpHost(host);
	}

	@And("^I set '(.+)' as from name$")
	public void setSmtpFromName(String name) {
		smtpConfigPage.setSmtpFromName(name);
	}

	@And("^I set '(.+)' as from email address$")
	public void setSmtpFromEmailAddress(String address) {
		smtpConfigPage.setSmtpFromEmailAddress(address);
	}

	@And("^I set '(.+)' as username$")
	public void setSmtpUserName(String name) {
		smtpConfigPage.setSmtpUserName(name);
	}

	@And("^I set '(.+)' as password$")
	public void setSmtpUserPwd(String pwd) {
		smtpConfigPage.setSmtpPassword(pwd);
	}

	@And("^I set '(.+)' as smtp port$")
	public void setSmtpPort(String port) {
		smtpConfigPage.setSmtpPort(port);
	}

	@And("^I ckeck require authentication$")
	public void setSmtRequireAuthentication() {
		smtpConfigPage.setSmtpRequireAuthentication(true);
	}

	@And("^I ckeck require ssl$")
	public void setSmtSSL() {
		smtpConfigPage.setSmtpRequireSSL(true);
	}

	@And("^I check trust server$")
	public void setSmtpTrustServer() {
		smtpConfigPage.setSmtpTrustServer(true);
	}

	@And("^I test the configuration$")
	public void testSmtpServer() {
		smtpConfigPage.test();
	}
	
	@And("^I save the configuration$")
	public void saveSmtpServer() {
		smtpConfigPage.update();
	}

}
