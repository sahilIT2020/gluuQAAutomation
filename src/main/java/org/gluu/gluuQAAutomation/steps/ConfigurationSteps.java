package org.gluu.gluuQAAutomation.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.gluu.gluuQAAutomation.pages.configuration.organization.OxTrustSettingsTab;
import org.gluu.gluuQAAutomation.pages.configuration.organization.SystemConfigurationPage;
import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.gluu.gluuQAAutomation.pages.login.SignInPage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Nat on 2018-07-14.
 */

@RunWith(SpringRunner.class)
public class ConfigurationSteps extends BaseSteps {

    @Autowired
    private HomePage homePage;
    private SignInPage signInPage;

    @Autowired
    private SystemConfigurationPage systemConfigurationPage;
    private OxTrustSettingsTab oxTrustSettingsTab;

    @When("^I go to system organization configuration page$")
    public void gotoSystemOrganizationConfigurationPage() throws InterruptedException {
        homePage.goToOrganisationConfigurationMenuPage();
        wait(10000);

    }

    @And("^I set the Self-Service Password Reset to '(.+)'$")
    public void setSelfServicePasswordReset(String state) {
        systemConfigurationPage.setSelfServicePasswordReset(state);
    }

    @And("^I set the SCIM Support to '(.+)'$")
    public void setSCIMSupport(String scimState) {
        systemConfigurationPage.setSCIMSupport(scimState);
    }

    @And("^I set the Passport Support to '(.+)'$")
    public void setPassportSupport(String passportState) {
        systemConfigurationPage.setPassportSupport(passportState);
    }

    @And("^I set the DNS Server to '(.+)'$")
    public void setDNSServer(String dnsValue) {
        systemConfigurationPage.setDNSServer(dnsValue);
    }

    @And("^I set the Maximum Log Size to '(.+)'$")
    public void setMaximumLogSize(String logSizeValue) {
        systemConfigurationPage.setMaximumLogSize(logSizeValue);
    }

    @And("^I set the User to Edit Own Profile to '(.+)'$")
    public void setUserCanEditOwnProfile(String editOwnProfileValue) {
        systemConfigurationPage.setUserCanEditOwnProfile(editOwnProfileValue);
    }

    @And("^I set the Contact Email to '(.+)'$")
    public void setContactEmail(String contactEmail) {
        systemConfigurationPage.setContactEmail(contactEmail);
    }

    @And("^I click on the Update button$")
    public void clickUpdateButton() {
        systemConfigurationPage.clickUpdateButton();
    }

    @And("^I click on the Cancel button$")
    public void clickCancelButton() {
        systemConfigurationPage.clickCancelButton();
    }

    @Then("^I should see the Self-Service Password Reset set to '(.+)'$")
    public void assertPasswordResetStatus(String passwordResetStatus) {
        systemConfigurationPage.assertPasswordResetStatus(passwordResetStatus);
    }

    @And("^I should see the SCIM Support set to '(.+)'$")
    public void assertSCIMSupportStatus(String scimSupportStatus) {
        systemConfigurationPage.assertSCIMSupportStatus(scimSupportStatus);
    }

    @And("^I should see the Passport Support set to '(.+)'$")
    public void assertPassportSupportStatus(String passportSupportStatus) {
        systemConfigurationPage.assertPassportSupportStatus(passportSupportStatus);
    }

    @And("^I should see the DNS Server set to '(.+)'$")
    public void assertDNSServerValue(String dnsServerValueSet) {
        systemConfigurationPage.assertDNSServerValue(dnsServerValueSet);
    }

    @And("^I should not see the DNS Server set to '(.+)'$")
    public void assertNotDNSServerValue(String notDNSServerValueSet) {
        systemConfigurationPage.assertNotDNSServerValue(notDNSServerValueSet);
    }

    @And("^I should see the Maximum Log Size Value set to '(.+)'$")
    public void assertMaximumLogSizeValue(String logSizeValueSet) {
        systemConfigurationPage.assertMaximumLogSizeValue(logSizeValueSet);
    }

    @And("^I should not see the Maximum Log Size Value set to '(.+)'$")
    public void assertNotMaximumLogSizeValue(String notLogSizeValueSet) {
        systemConfigurationPage.assertNotMaximumLogSizeValue(notLogSizeValueSet);
    }

    @And("^I should see the User to Edit Own Profile set to '(.+)'$")
    public void assertUserCanEditOwnProfileValue(String editOwnProfileStatus) {
        systemConfigurationPage.assertUserCanEditOwnProfileValue(editOwnProfileStatus);
    }

    @And("^I should see the Contact Email set to '(.+)'$")
    public void assertContactEmailValue(String contactEmailValue) {
        systemConfigurationPage.assertContactEmailValue(contactEmailValue);
    }

    @And("^I should not see the Contact Email set to '(.+)'$")
    public void assertNotContactEmailValue(String notContactEmailValue) {
        systemConfigurationPage.assertNotContactEmailValue(notContactEmailValue);
    }
    
    @After
	public void clear() {
		homePage.clear();
	}

    @And("^I click on the Ox Trust Settings Page$")
    public void oxTrustSettingsPage()  {
        oxTrustSettingsTab.goToOxTrustSettingsTab();

    }

    @And("^I set the Organization name to '(.+)'$")
    public void newOrganizationName(String newOrganizationNameValue) {
        oxTrustSettingsTab.setOrganizationName(newOrganizationNameValue);
    }

    @And("^I click on the Manager Group name$")
    public void clickManagerGroupName() {
        oxTrustSettingsTab.clickManagerGroup();

    }

    @And("^I add the Organization Logo$")
    public void uploadOrganizationLogo() throws InterruptedException {
        oxTrustSettingsTab.addOrganizationLogo();

    }

    @And("^I add the Organization Favicon$")
    public void uploadOrganizationFavicon() throws InterruptedException {
        oxTrustSettingsTab.addOrganizationFavicon();

    }

    @And("^I click the OxTrust Update button$")
    public void updateButton() {
        oxTrustSettingsTab.clickUpdateButton();
    }

    @And("^I click the OxTrust Cancel button$")
    public void cancelButton() {
        oxTrustSettingsTab.clickCancelButton();
    }

    @And("^I should see the OxTrust Settings page$")
    public void assertThisPageIsOxTrustSettingsPage() {
        oxTrustSettingsTab.assertCurrentPageIsOxTrustSettingsPage();

    }

    @And("^I should see the Organization name set to '(.+)'$")
    public void assertOrganizationNameValue(String organizationNameSet) {
        oxTrustSettingsTab.assertOrganizationName(organizationNameSet);
    }

    @And("^I see the current page URL contains '(.+)'$")
    public void assertPageIsGroupManageUpdatePage() {
        oxTrustSettingsTab.assertCurrentPageIsGroupManageUpdatePage();
    }

    @And("^I should see the uploaded logo has a '(.+)' button$")
    public void assertRemoveLogoButtonValue(String removeLogoButtonValue) {
        oxTrustSettingsTab.assertOrganizationLogoPresent(removeLogoButtonValue);
    }

    @And("^I should see the uploaded favicon has a '(.+)' button$")
    public void assertRemoveFaviconButton (String removeFaviconButtonValue) {
        oxTrustSettingsTab.assertFaviconPresent(removeFaviconButtonValue);
}
    @Then("^I should see the organization configuration page$")
        public void assertOrganizationConfigurationPage() {
        oxTrustSettingsTab.assertCurrentPageIsOrganizationSettingsPage();
    }

    @Then("^I should see the Group Manage Update Page$")
        public void assertGroupManageUpdatePage() {
        oxTrustSettingsTab.assertCurrentPageIsGroupManageUpdatePage();
        }

    @And("^I sign out of the Gluu Server$")
    public void signOut() {
        signInPage.signOut();
    }
}