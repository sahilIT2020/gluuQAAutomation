package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.gluu.gluuQAAutomation.pages.openidconnect.OpenIdConnectClientManagePage;
import org.gluu.gluuQAAutomation.pages.openidconnect.OpenIdConnectScopeManagePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
public class OpenIdConnectSteps  extends BaseSteps{
	@Autowired
	private HomePage homePage;
	@Autowired
	private OpenIdConnectScopeManagePage opConnectScopeManagePage;
	@Autowired
	private OpenIdConnectClientManagePage openIdConnectClientManagePage;
	
	@When("^I go to openid connect scopes list page$")
	public void goToOpenIdScopesListPage() {
		homePage.goToOpenIDScopePage();
	}
	@When("^I search for openid scopes with pattern '(.+)'$")
	public void searchOpenIDScopes(String pattern) {
		opConnectScopeManagePage.searchFor(pattern);
	}
	@Then("^I should see an openid scope named '(.+)'$")
	public void searchScopeInList(String scope) {
		opConnectScopeManagePage.assertScopeExist(scope);
	}
	
	@When("^I go to openid connect clients list page$")
	public void goToOpenIdClientListPage() {
		homePage.goToOpenIDClientsListPage();
	}
	@When("^I search for openid clients with pattern '(.+)'$")
	public void searchOpenIDClients(String pattern) {
		openIdConnectClientManagePage.searchFor(pattern);
	}
	@Then("^I should see an openid client named '(.+)'$")
	public void searchClientInList(String client) {
		openIdConnectClientManagePage.assertClientExist(client);
	}
	@And("^I start the process to add new client$")
	public void clickAddClientButton() {
		openIdConnectClientManagePage.goToClientAddPage();
	}
	@And("^I start the process to add new scope$")
	public void clickAddScopeButton() {
		opConnectScopeManagePage.goToScopeAddPage();
	}
	@And("^I set the display name '(.+)'$")
	public void setDisplayName(String name) {
		
	}
	@And("^I set the description '(.+)'$")
	public void setDescription(String des) {
		
	}
	@And("^I set the scope type to '(.+)'$")
	public void setScopeType(String type) {
		
	}

}
