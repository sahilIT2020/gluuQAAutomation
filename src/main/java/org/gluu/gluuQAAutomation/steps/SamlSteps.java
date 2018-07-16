package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.gluu.gluuQAAutomation.pages.saml.NameIdAddPage;
import org.gluu.gluuQAAutomation.pages.saml.NameIdConfigurationPage;
import org.gluu.gluuQAAutomation.pages.saml.TrAddPage;
import org.gluu.gluuQAAutomation.pages.saml.TrManagePage;
import org.gluu.gluuQAAutomation.pages.saml.TrUpdatePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
public class SamlSteps extends BaseSteps {
	@Autowired
	private HomePage homePage;

	@Autowired
	private TrAddPage trAddPage;

	@Autowired
	private TrUpdatePage trUpdatePage;

	@Autowired
	private TrManagePage trManagePage;

	
	@Autowired
	private NameIdConfigurationPage namdIdConfigurationPage;
	
	@Autowired
	private NameIdAddPage nameIdAddPage;
	
	@When("^I go to tr add page$")
	public void goToTrAddPage() {
		homePage.goSamlTrAddPage();
	}

	@When("^I go to tr list page$")
	public void goToTrListPage() {
		homePage.goSamlTrListPage();
	}

	@Then("^I set '(.+)' as display name$")
	public void setTrDisplayName(String dn) {
		trAddPage.setDisplayName(dn);
	}

	@Then("^I edit the display name to '(.+)'$")
	public void editTrDisplayName(String dn) {
		trUpdatePage.setDisplayName(dn);
	}

	@Then("^I edit the description to '(.+)'$")
	public void editTrDescription(String des) {
		trUpdatePage.setDescription(des);
	}

	@Then("^I set '(.+)' as description$")
	public void setTrDesc(String des) {
		trAddPage.setDescription(des);
	}

	@Then("^I set '(.+)' as entity type$")
	public void setEntityType(String type) {
		trAddPage.setEntityType(type);
	}

	@Then("^I set '(.+)' as metadata location$")
	public void setMetadataType(String type) {
		trAddPage.setMetadataType(type);
	}

	@Then("^I set '(.+)' metadata$")
	public void setMetadata(String path) {
		trAddPage.setMetadata(path);
	}

	@Then("^I configure sp with '(.+)' profile$")
	public void configureSp(String profile) {
		trAddPage.configureRp(profile);
	}

	@And("^I release the following attributes '(.+)'$")
	public void releaseAttributes(String attributes) {
		trAddPage.releaseAttributes(attributes);
	}

	@And("^I save the current tr$")
	public void save() {
		trAddPage.save();
	}

	@And("^I update the current tr$")
	public void update() {
		trUpdatePage.update();
	}

	@And("^I search for tr named '(.+)'")
	public void searchTr(String pattern) {
		trManagePage.searchFor(pattern);
	}

	@Then("^I should see a tr with display name '(.+)' in the list$")
	public void checkTrExistInList(String trName) {
		trManagePage.assertTrExist(trName);
	}

	@Then("^I should not see a tr with display name '(.+)' in the list$")
	public void checkTrNotExistInList(String trName) {
		trManagePage.assertTrNotExist(trName);
	}

	@When("^I start the edition of tr named '(.+)'")
	public void startTrEdition(String name) {
		trManagePage.goToDetailOf(name);
	}

	@When("^I delete the tr named '(.+)'$")
	public void deleteTr(String name) {
		trManagePage.goToDetailOf(name);
		trUpdatePage.delete();
	}
	
	@After
	public void clear() {
		homePage.clear();
	}
	
	@When("^I go to custom nameId configuration page$")
	public void goToNameIdConfigPage() {
		homePage.goNameIdConfigurePage();
	}
	
	@And("^I start the process to add new name id configuration$")
	public void startAddingNewNamedId() {
		namdIdConfigurationPage.startAddingNewConfiguration();
	}
	
	@And("^I set '(.+)' as source atrribute$")
	public void setSourceAttribute(String source) {
		nameIdAddPage.setSourceAttribute(source);
	}
	
	@And("^I set '(.+)' as name$")
	public void setName(String source) {
		nameIdAddPage.setName(source);
	}
	
	@And("^I set '(.+)' as nameid type$")
	public void setType(String source) {
		nameIdAddPage.setType(source);
	}
	@And("^I enable it$")
	public void setEnable() {
		nameIdAddPage.enable();
	}
	
	@And("^I save the name id$")
	public void saveNameId() {
		nameIdAddPage.save();
	}
	

}
