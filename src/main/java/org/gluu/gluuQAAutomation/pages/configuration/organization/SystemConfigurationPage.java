package org.gluu.gluuQAAutomation.pages.configuration.organization;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Nat on 2018-07-16.
 */

@Component
public class SystemConfigurationPage extends AbstractPage {


    public void setSelfServicePasswordReset (String resetState) {
        Select passwordReset = new Select(
                webDriver.findElement(
                        By.id("organizationForm:passwordReset:passwordResetId")));
        passwordReset.selectByValue(resetState);
    }

    public void setSCIMSupport(String scimState) {
        Select scimSupport = new Select(
                webDriver.findElement (
                        By.id("organizationForm:scimEnabledState:scimEnabledStateId")));
        scimSupport.selectByValue(scimState);
    }

    public void setPassportSupport (String passportState) {
        Select passportSupport = new Select(
                webDriver.findElement(
                        By.id("organizationForm:passportEnabledState:passportEnabledStateId")));
        passportSupport.selectByValue(passportState);
    }

    public void setDNSServer (String dnsServerValue) {
        WebElement setDNSServerField = webDriver.findElement(
                By.name("organizationForm:dnsServer:j_idt176"));
        setDNSServerField.clear();
        setDNSServerField.sendKeys(dnsServerValue);
    }

    public void setMaximumLogSize(String maximumLogSizeValue) {
        WebElement logSizeField = webDriver.findElement(
                By.name("organizationForm:maxLogSize:j_idt187"));
        logSizeField.clear();
        logSizeField.sendKeys(maximumLogSizeValue);

    }

    public void setUserCanEditOwnProfile (String editOwnProfile) {
        Select userProfile = new Select(
                webDriver.findElement(
                        By.id("organizationForm:profileManagment:profileManagmentStateId")));
        userProfile.selectByValue(editOwnProfile);

    }

    public void setContactEmail (String setContactEmail) {
        WebElement contactEmailField = webDriver.findElement(
                By.name("organizationForm:j_idt209:j_idt210"));
        contactEmailField.clear();
        contactEmailField.sendKeys(setContactEmail);

    }

    public void clickCancelButton() {
        WebElement cancelButton = webDriver.findElement(
                By.name("organizationForm:j_idt442"));
        cancelButton.click();

    }

    public void clickUpdateButton () {
        WebElement updateButton = webDriver.findElement (
                By.name("organizationForm:j_idt441"));
        updateButton.click();

    }

    public void assertPasswordResetStatus (String enabled) {
        Select passwordFieldStatus = new Select(webDriver.findElement(
                By.id("organizationForm:passwordReset:passwordResetId")));
        WebElement passwordReset = passwordFieldStatus.getFirstSelectedOption();
        assertThat(passwordReset.getText()).isEqualTo(enabled);

    }

    public void assertSCIMSupportStatus (String disabled) {
        Select scimSupportFieldStatus = new Select(webDriver.findElement(
                By.id("organizationForm:scimEnabledState:scimEnabledStateId")));
        WebElement scimSupport = scimSupportFieldStatus.getFirstSelectedOption();
        assertThat(scimSupport.getText()).isEqualTo(disabled);

    }

    public void assertPassportSupportStatus (String disabled) {
        Select passportSupportNameStatus = new Select(webDriver.findElement(
                By.id("organizationForm:passportEnabledState:passportEnabledStateId")));
        WebElement passportSupport = passportSupportNameStatus.getFirstSelectedOption();
        assertThat(passportSupport.getText()).isEqualTo(disabled);

    }

    public void assertDNSServerValue (String dnsServerValue) {
        WebElement dnsServerField = webDriver.findElement(
                By.name("organizationForm:dnsServer:j_idt176"));
        assertThat(dnsServerField.getAttribute("value")).isEqualTo(dnsServerValue);

    }
    public void assertNotDNSServerValue (String notDNSServerValue) {
        WebElement notDNSServerField = webDriver.findElement(
                By.name("organizationForm:dnsServer:j_idt176"));
        assertThat(notDNSServerField.getAttribute("value")).isNotEqualTo(notDNSServerValue);
    }

    public void assertMaximumLogSizeValue (String logSizeValue) {
        WebElement maximumLogSizeField = webDriver.findElement(
                By.name("organizationForm:maxLogSize:j_idt187"));
        assertThat(maximumLogSizeField.getAttribute("value")).isEqualTo(logSizeValue);

    }
    public void assertNotMaximumLogSizeValue (String notLogSizeValue) {
        WebElement notMaximumLogSizeField = webDriver.findElement(
                By.name("organizationForm:maxLogSize:j_idt187"));
        assertThat(notMaximumLogSizeField.getAttribute("value")).isNotEqualTo(notLogSizeValue);

    }

    public void assertUserCanEditOwnProfileValue (String editProfileValue) {
        Select userCanEditOwnProfileStatus = new Select(webDriver.findElement(
                By.id("organizationForm:profileManagment:profileManagmentStateId")));
        WebElement editOwnProfile = userCanEditOwnProfileStatus.getFirstSelectedOption();
        assertThat(editOwnProfile.getText()).isEqualTo(editProfileValue);

    }

    public void assertContactEmailValue (String contactEmailValue)
    {WebElement contactEmailSet = webDriver.findElement(
            By.name("organizationForm:j_idt209:j_idt210"));
        assertThat(contactEmailSet.getAttribute("value")).isEqualTo(contactEmailValue);

    }

    public void assertNotContactEmailValue (String notContactEmailValue)
    {WebElement notContactEmailSet = webDriver.findElement(
            By.name("organizationForm:j_idt209:j_idt210"));
        assertThat(notContactEmailSet.getAttribute("value")).isNotEqualTo(notContactEmailValue);

    }
}
