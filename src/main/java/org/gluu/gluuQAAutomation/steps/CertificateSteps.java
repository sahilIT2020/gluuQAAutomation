package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.configuration.CertificatesPage;
import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

@RunWith(SpringRunner.class)
public class CertificateSteps extends BaseSteps {

	@Autowired
	private HomePage homePage;
	@Autowired
	private CertificatesPage certificatesPage;

	@And("^I go to certificates page$")
	public void goToCertPage() {
		homePage.goTocertificatesMenuPage();
	}

	@Then("^I should see '(.+)' certs in the list$")
	public void verifyCertsSize(String size) {
		certificatesPage.assertThereAreCerts(size);
	}
	
	@And("^I should see a cert named '(.+)'$")
	public void checkCert(String certName) {
		certificatesPage.assertCertExist(certName);
	}

	@After
	public void clear() {
		homePage.clear();
	}

}
