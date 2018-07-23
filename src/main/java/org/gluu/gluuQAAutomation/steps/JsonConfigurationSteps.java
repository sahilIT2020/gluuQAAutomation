package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.configuration.json.CacheProviderJsonPage;
import org.gluu.gluuQAAutomation.pages.configuration.json.OxAuthConfigurationPage;
import org.gluu.gluuQAAutomation.pages.configuration.json.OxTrustConfigurationPage;
import org.gluu.gluuQAAutomation.pages.configuration.json.OxTrustImportConfigurationPage;
import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
public class JsonConfigurationSteps extends BaseSteps {
	@Autowired
	private HomePage homePage;
	@Autowired
	private OxTrustConfigurationPage oxTrustConfigurationPage;
	@Autowired
	private OxAuthConfigurationPage oxAuthConfigurationPage;
	@Autowired
	private CacheProviderJsonPage cacheProviderJsonPage;
	@Autowired
	private OxTrustImportConfigurationPage oxTrustImportConfigurationPage;

	@When("^I go to oxtrust Json configuration page$")
	public void goToOxtrustJsonConfigPage() {
		homePage.goToJsonConfigurationMenuPage();
		homePage.selectTab("oxTrust Configuration");
	}
	// oxtrust steps

	@Then("^I should see the cert dir set to '(.+)'$")
	public void checkCertDirIs(String dir) {
		oxTrustConfigurationPage.assertCertDirIs(dir);
	}

	@Then("^I should see the base dn set to '(.+)'$")
	public void checkBaseDn(String dn) {
		oxTrustConfigurationPage.assertBaseDn(dn);
	}

	@Then("^I should see that the log level is set to '(.+)'$")
	public void checkLogLevel(String level) {
		oxTrustConfigurationPage.assertLogLevel(level);
	}

	@Then("^I should see that the sicm max count is set to '(.+)'$")
	public void checkScimMaxCount(String count) {
		oxTrustConfigurationPage.assertScimMaxCount(count);
	}

	@And("^I should see the org iname is empty$")
	public void checkOrgIname() {
		oxTrustConfigurationPage.assertOrgInameIsEmpty();
	}

	@And("^I should see that the support mail is not empty$")
	public void checkSupportEmailNotEmpty() {
		oxTrustConfigurationPage.assertEmailNotEmpty();
	}

	@And("^I should see that the appliance inum is not empty$")
	public void checkApplianceInumNotEmpty() {
		oxTrustConfigurationPage.assertApplianceInumNotEmpty();
	}

	@And("^I should see that the application url is not empty$")
	public void checkApplicationUrlNotEmpty() {
		oxTrustConfigurationPage.assertApplicationUrlNotEmpty();
	}

	@And("^I should see that the base endpoint is correct$")
	public void checkBaseEndPointIscorrect() {
		oxTrustConfigurationPage.assertBaseEndpointIsCorrect();
	}

	// oxAuth steps

	@When("^I go to oxauth Json configuration page$")
	public void goToOxAuthJsonConfigPage() {
		homePage.goToJsonConfigurationMenuPage();
		homePage.selectTab("oxAuth Configuration");
	}

	@And("^I should see that the login page is correct$")
	public void checkLoginPageIscorrect() {
		oxAuthConfigurationPage.assertLoginPageIsCorrect();
	}

	@And("^I should see that the authorization page is correct$")
	public void checkAuthorizationPageIscorrect() {
		oxAuthConfigurationPage.assertAuthorizationPageIsCorrect();
	}

	@And("^I should see that the authorization endpoint is correct$")
	public void checkAuthorizationEndPointIscorrect() {
		oxAuthConfigurationPage.assertAuthorizationEndPointIsCorrect();
	}

	@And("^I should see that the token endpoint is correct$")
	public void checkTokenEndPointIscorrect() {
		oxAuthConfigurationPage.assertTokenEndPointIsCorrect();
	}

	@And("^I should see that the userinfo endpoint is correct$")
	public void checkUserInfoEndPointIscorrect() {
		oxAuthConfigurationPage.assertUserInfoEndPointIsCorrect();
	}

	@And("^I should see that the clientinfo endpoint is correct$")
	public void checkClientInfoEndPointIscorrect() {
		oxAuthConfigurationPage.assertClientInfoEndPointIsCorrect();
	}

	@And("^I should see that the endsession endpoint is correct$")
	public void checkEnSessionEndPointIscorrect() {
		oxAuthConfigurationPage.assertEndSessionEndPointIsCorrect();
	}

	@And("^I should see that the registration endpoint is correct$")
	public void checkRegistrationEndPointIscorrect() {
		oxAuthConfigurationPage.assertRegistrationEndPointIsCorrect();
	}

	@And("^I should see that the oidc discovery endpoint is correct$")
	public void checkOidcDiscoveryEndPointIscorrect() {
		oxAuthConfigurationPage.assertOidcDiscoveryEndPointIsCorrect();
	}

	@And("^I should see that the oidc configuration endpoint is correct$")
	public void checkOidcConfigEndPointIscorrect() {
		oxAuthConfigurationPage.assertOidcConfigEndPointIsCorrect();
	}

	// cache provider steps

	@When("^I go to cache provider Json configuration page$")
	public void goToCacheProviderJsonConfigPage() {
		homePage.goToJsonConfigurationMenuPage();
		homePage.selectTab("Cache Provider Configuration");
	}

	@Then("^I should see the cache provider type set to '(.+)'$")
	public void checkCacheProviderType(String type) {
		cacheProviderJsonPage.checkProviderType(type);
	}

	@And("^I should see a memcache config with type '(.+)' with servers '(.+)' with maxOQL '(.+)' with buffer '(.+)' with put expiration '(.+)'")
	public void veriyMemCache(String type, String servers, String maxOQL, String bufferSize, String expiration) {
		cacheProviderJsonPage.verifyMemCache(type, servers, maxOQL, bufferSize, expiration);
	}

	@And("^I should see a redis config with type '(.+)' with servers '(.+)' and put expriration '(.+)'$")
	public void verifyRedisConfig(String type, String servers, String expiration) {
		cacheProviderJsonPage.verifyRedisConfig(type, servers, expiration);
	}

	// oxtrust import steps

	@When("^I go to oxtrust import Json configuration page$")
	public void goToOxTrustImportConfigPage() {
		homePage.goToJsonConfigurationMenuPage();
		homePage.selectTab("oxTrust Import Configuration");
	}

	@Then("^I should see an item with ldapName '(.+)' and displayName '(.+)' and dataType '(.+)' and required '(.+)'$")
	public void veryfyMappingEntry(String lName, String dName, String type, String required) {
		oxTrustImportConfigurationPage.veryMappingEntry(lName,dName,type,required);
	}

	@After
	public void clear() {
		homePage.clear();
	}

}
