package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.gluu.gluuQAAutomation.pages.openidconnect.ClientAddPage;
import org.gluu.gluuQAAutomation.pages.openidconnect.OpenIdConnectClientManagePage;
import org.gluu.gluuQAAutomation.pages.openidconnect.OpenIdConnectScopeAddPage;
import org.gluu.gluuQAAutomation.pages.openidconnect.OpenIdConnectScopeManagePage;
import org.gluu.gluuQAAutomation.pages.openidconnect.OpenIdConnectScopeUpdatePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
public class OpenIdConnectSteps extends BaseSteps {
	@Autowired
	private HomePage homePage;
	@Autowired
	private OpenIdConnectScopeManagePage opConnectScopeManagePage;
	@Autowired
	private OpenIdConnectClientManagePage openIdConnectClientManagePage;
	@Autowired
	private OpenIdConnectScopeAddPage openIdConnectScopeAddPage;
	@Autowired
	private OpenIdConnectScopeUpdatePage openIdConnectScopeUpdatePage;
	@Autowired
	private ClientAddPage clientAddPage;

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

	@Then("^I should not see an openid scope named '(.+)'$")
	public void searchForScopeInList(String scope) {
		opConnectScopeManagePage.assertScopeDontExist(scope);
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
	public void setDisplayName(String dn) {
		openIdConnectScopeAddPage.setDisplayName(dn);
	}

	@And("^I edit the display name value to '(.+)'$")
	public void editDisplayName(String dn) {
		openIdConnectScopeAddPage.setDisplayName(dn);
	}

	@And("^I set the description '(.+)'$")
	public void setDescription(String des) {
		openIdConnectScopeAddPage.setDescription(des);
	}

	@And("^I edit the description value to '(.+)'$")
	public void editDescription(String des) {
		openIdConnectScopeAddPage.setDescription(des);
	}

	@And("^I set the scope type to '(.+)'$")
	public void setScopeType(String type) {
		openIdConnectScopeAddPage.setType(type);
	}

	@And("^I set dynamic registration to '(.+)'$")
	public void setRegistrationType(String rType) {
		openIdConnectScopeAddPage.setRegistrationType(rType);
	}

	@And("^I save the scope registration$")
	public void perfomSave() {
		openIdConnectScopeAddPage.save();
	}

	@And("^I save the scope edition$")
	public void perfomEdition() {
		openIdConnectScopeUpdatePage.edit();
	}

	@And("^I start the process to edit the scope named '(.+)'$")
	public void editCurrentScope(String scope) {
		opConnectScopeManagePage.editScope(scope);
	}

	@When("^I delete that scope$")
	public void deleteScope() {
		openIdConnectScopeUpdatePage.delete();
	}

	@And("^I set the client name to '(.+)'$")
	public void setClientName(String name) {
		clientAddPage.setClientName(name);
	}

	@And("^I set the client description to '(.+)'$")
	public void setClientDes(String des) {
		clientAddPage.setDescription(des);
	}

	@And("^I set the client secret to '(.+)'$")
	public void setClientSecret(String secret) {
		clientAddPage.setSecret(secret);
	}

	@And("^I set application type to '(.+)'$")
	public void setType(String type) {
		clientAddPage.setType(type);
	}

	@And("^I set preauthorization to '(.+)'$")
	public void setPreAuth(String value) {
		clientAddPage.setPreAutho(value);
	}

	@And("^I set persist authorization to '(.+)'$")
	public void setPersistAuth(String value) {
		clientAddPage.setPersistAutho(value);
	}

	@And("^I set subject type to '(.+)'$")
	public void setSubjectType(String value) {
		clientAddPage.setSubjectType(value);
	}

	@And("^I set authentication method to '(.+)'$")
	public void setAuthendMethod(String value) {
		clientAddPage.setAuthendMethod(value);
	}
	@And("^I add the scope named '(.+)'$")
	public void addScope(String scope) {
		clientAddPage.addScope(scope);
	}
	
	@And("^I add following scopes '(.+)'$")
	public void addScopes(String scopes) {
		clientAddPage.addScopes(scopes);
	}

	@After
	public void clear() {
		homePage.clear();
	}

}
