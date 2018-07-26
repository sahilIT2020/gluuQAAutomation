package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.configuration.ServerStatusPage;
import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

@RunWith(SpringRunner.class)
public class ServerStatusSteps extends BaseSteps {
	@Autowired
	private HomePage homePage;
	@Autowired
	private ServerStatusPage serverStatusPage;

	@And("^I go to server status page$")
	public void goToServerStatusPage() {
		homePage.goToServerStatusMenuPage();
	}

	@Then("^I should see '(.+)' server parameters$")
	public void checkParametersSize(String size) {
		serverStatusPage.assertSizeIs(size);
	}

	@Then("^I should see the hostname is present and not empty$")
	public void checkServerHostName() {
		serverStatusPage.checkHostName();
	}

	@Then("^I should see the ip address is present and not empty$")
	public void checkServerIp() {
		serverStatusPage.checkIpAddress();
	}

	@Then("^I should see the system uptime is present and not empty$")
	public void checkServerSysUptime() {
		serverStatusPage.checkSystemUptime();
	}

	@Then("^I should see the last update is present and not empty$")
	public void checkServerLsatUpdate() {
		serverStatusPage.checkLastUpdate();
	}

	@Then("^I should see the polling interval is present and not empty$")
	public void checkServerPollingInterval() {
		serverStatusPage.checkPolling();
	}

	@Then("^I should see the person count is present and not empty$")
	public void checkServerPersonCount() {
		serverStatusPage.checkPersonCount();
	}

	@Then("^I should see the group count is present and not empty$")
	public void checkServerGroupCount() {
		serverStatusPage.checkGroupCount();
	}

	@Then("^I should see the free memory is present and not empty$")
	public void checkServerFreeMemory() {
		serverStatusPage.checkFreeMemory();
	}

	@Then("^I should see the free disk is present and not empty$")
	public void checkServerFreeDisk() {
		serverStatusPage.checkFreeDisk();
	}

	@After
	public void clear() {
		homePage.clear();
	}

}
