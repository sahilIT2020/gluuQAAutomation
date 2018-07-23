package org.gluu.gluuQAAutomation.pages.configuration.organization;

/**
 * Created by Nat on 2018-07-17.
 */

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;


@Component
public class OxTrustSettingsTab extends AbstractPage {

    public void goToOxTrustSettingsTab()  {
        WebElement oxTrustSettingTab = webDriver.findElement(
                By.cssSelector("//a[@href='#ox-trust']"));
        oxTrustSettingTab.click();

    }

    /*public void buildDateValue (String buildDate) {
        Select dateValue = new Select(
        webDriver.findElement(By.xpath("value input")));
    }

    public class  buildNumber (String buildNumberValue) {
        Select buildNumberSet = new Select(
                webDriver.findElement(By.xpath("value input")));
        )
    }*/

    public void setOrganizationName(String organizationNameValue) {
        WebElement setOrganizationNameValue = webDriver.findElement(
                By.name("organizationForm:displayName:j_idt358"));
        setOrganizationNameValue.clear();
        setOrganizationNameValue.sendKeys(organizationNameValue);

    }

    public void clickManagerGroup() {
        WebElement managerGroupName = webDriver.findElement(
                By.xpath("//a[@href='/identity/group/manage/update/@!19CF.B296.532F.83E2!0001!25C1.E1E4!0003!60B7']"));
        managerGroupName.click();

    }

    public void addOrganizationLogo() throws InterruptedException {
        webDriver.findElement(By.className("rf-fu-inp-cntr")).sendKeys(
                "C:/Users/Nat/Desktop/1.jpg");
        Thread.sleep(10000);

    }

    public void addOrganizationFavicon()throws InterruptedException {
        webDriver.findElement(By.className("rf-fu-btn-add")).sendKeys(
                "C:/Users/Nat/Desktop/logo.png");
        Thread.sleep(10000);

    }

    public void clickUpdateButton() {
        WebElement updateButton = webDriver.findElement(
                By.name("organizationForm:j_idt441"));
        updateButton.click();

    }

    public void clickCancelButton() {
        WebElement cancelButton = webDriver.findElement(
                By.name("organizationForm:j_idt442"));
        cancelButton.click();
    }
    public void assertCurrentPageIsOxTrustSettingsPage() {
        WebElement buildDate = webDriver.findElement(
                By.id("organizationForm:buildDate:label"));
        String buildDateText = buildDate.getText();
        assertThat(buildDateText.contains("Build Date"));

    }
    public void assertCurrentPageIsOrganizationSettingsPage() {
        String currentPageUrl = getCurrentPageUrl();
        Assert.assertTrue(currentPageUrl.endsWith("organization/configuration"));

    }

    public void assertOrganizationName (String organizationNameValue) {
        WebElement organizationNameSet = webDriver.findElement(
                By.name("organizationForm:displayName:j_idt358"));
        assertThat(organizationNameSet.getText()).isEqualTo(organizationNameValue);

    }

    public void assertCurrentPageIsGroupManageUpdatePage() {
        String thisPageUrl = getCurrentPageUrl();
        Assert.assertTrue(thisPageUrl.contains("group/manage/update"));
    }

    public void assertOrganizationLogoPresent(String removeLogoButtonValue) {
        WebElement removeLogoButton = webDriver.findElement(
                By.id("organizationForm:j_idt382:j_idt390"));
        assertThat(removeLogoButton.getText()).isEqualTo(removeLogoButtonValue);
    }

    public void assertFaviconPresent (String removeFaviconButtonValue) {
        WebElement removeFaviconButton = webDriver.findElement(
                By.id("organizationForm:j_idt401:j_idt409"));
        assertThat(removeFaviconButton.getText()).isEqualTo(removeFaviconButton);
    }
}
