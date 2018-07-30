package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.configuration.attributesImExport.AttributesExportPage;
import org.gluu.gluuQAAutomation.pages.configuration.attributesImExport.AttributesImportPage;
import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

@RunWith(SpringRunner.class)
public class AttributesImportExportSteps extends BaseSteps {

	@Autowired
	private HomePage homePage;

	@Autowired
	private AttributesExportPage attributesExportPage;
	@Autowired
	private AttributesImportPage attributesImportPage;

	@And("^I go to Attributes export page$")
	public void goToExportPage() {
		homePage.goToImportExportAttributesMenuPage();
		attributesExportPage.clickExportButton();
	}

	@And("^I go to Attributes import page$")
	public void goToAttributeImportPage() {
		homePage.goToImportExportAttributesMenuPage();
	}

	@And("^I import the file named '(.+) from the download directory$")
	public void importAttributes(String fileName) {
		attributesImportPage.importAttributesFromFile(fileName);
	}
	
	@Then("^I validate and import those attributes$")
	public void validateImport() {
		attributesImportPage.validateAndImport();
	}

	@And("^I pick the attribute named '(.+)'$")
	public void pickAttributeToExport(String name) {
		attributesExportPage.pickAttributeToImport(name);
	}

	@And("^I export them$")
	public void export() {
		attributesExportPage.export();
	}

	@Then("^I should see a file named '(.+)' in downloads folder")
	public void checkFileDownloaded(String fileName) {
		attributesExportPage.verifyFile(fileName);
	}

	@After
	public void clear() {
		homePage.clear();
	}

}
