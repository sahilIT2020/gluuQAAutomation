package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.gluu.gluuQAAutomation.pages.uma.UmaResourceManagePage;
import org.gluu.gluuQAAutomation.pages.uma.UmaScopeAddPage;
import org.gluu.gluuQAAutomation.pages.uma.UmaScopeManagePage;
import org.gluu.gluuQAAutomation.pages.uma.UmaScopeUpdatePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
public class UmaSteps extends BaseSteps {

	@Override
	public void cleanUp() {
		homePage.open();
	}

	@Autowired
	private HomePage homePage;
	@Autowired
	private UmaScopeManagePage umaManagePage;
	@Autowired
	private UmaResourceManagePage umaResourceManagePage;
	@Autowired
	private UmaScopeAddPage umaScopeAddPage;
	@Autowired
	private UmaScopeUpdatePage umaScopeUpdatePage;

	@When("^I go to uma scope list page$")
	public void goToScopeManagePage() {
		homePage.goToUmaScopeManagePage();
	}

	@When("^I go to uma resources list page$")
	public void goToResourcesManagePage() {
		homePage.goToUmaResourceManagePage();
	}

	@When("^I go to uma scope add page$")
	public void goToScopeAddPage() {
		homePage.goToUmaScopeManagePage();
		umaManagePage.goToScopeAddPage();
	}

	@Then("^I should see a uma scope named '(.+)'$")
	public void assertUmaScopeExist(String scopeName) {
		umaManagePage.assertUmaScopeExist(scopeName);
	}

	@Then("^I should see a uma resource named '(.+)' with scopes '(.+)'$")
	public void assertUmaResourceExist(String resName, String scopeName) {
		umaResourceManagePage.assertUmaResourceExist(scopeName);
	}

	@And("^I search for scopes with pattern '(.+)'$")
	public void searchUmaScopes(String pattern) {
		umaManagePage.searchUmaScope(pattern);
	}

	@And("^I search for resources with pattern '(.+)'$")
	public void searchUmaResources(String pattern) {
		umaResourceManagePage.searchUmaResource(pattern);
	}

	@And("^I set uma scope id to a random value$")
	public void setRadomUmaScopeId() {
		umaScopeAddPage.setRandomScopeId();
	}

	@And("^I edit uma scope id to '(.+)' $")
	public void editUmaScopeId(String id) {
		umaScopeUpdatePage.editUmaScopeId(id);
	}

	@And("^I edit uma scope dsplay name to '(.+)' $")
	public void editUmaScopeDn(String dn) {
		umaScopeUpdatePage.editUmaScopeDisplayName(dn);
	}

	@And("^I set uma scope display name to '(.+)'$")
	public void setUmaDisplayName(String dn) {
		umaScopeAddPage.setDisplayName(dn);
	}

	@And("^I set uma scope logo to '(.+)'$")
	public void setUmaLogo(String logo) {
		umaScopeAddPage.setLogo(logo);
	}

	@And("^I set uma scope policy to '(.+)'$")
	public void setUmaPolicy(String policy) {
		umaScopeAddPage.setPolicy(policy);
	}

	@And("^I save the scope$")
	public void saveScope() {
		umaScopeAddPage.save();
	}

	@Override
	public void setup() {
		homePage.close();
	}

}
