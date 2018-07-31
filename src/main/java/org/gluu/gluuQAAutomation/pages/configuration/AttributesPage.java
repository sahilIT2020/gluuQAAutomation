package org.gluu.gluuQAAutomation.pages.configuration;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class AttributesPage extends AbstractPage {

    public void showAllAttributes() {
        WebElement allButton = webDriver.findElement(
                By.id("attributesFormId:j_idt138"));
        allButton.click();

    }
    public void checkInactiveAttributes() {

        List<WebElement> listInactive = webDriver.findElements(
                By.xpath("//*[contains(text(),'INACTIVE')]"));
        Assert.assertTrue("Text not found!", listInactive.size() > 0);
    }
    public void checkActiveAttributes() {
        List<WebElement> listActive = webDriver.findElements(
                By.xpath("//*[contains(text(),'ACTIVE')]"));
        Assert.assertTrue("Text not found!", listActive.size() > 0);
    }
    public void checkAttributeDescriptionExists(String descriptionValue) {
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'" + descriptionValue +"')]")));
        List<WebElement> listActive = webDriver.findElements(
                By.xpath("//*[contains(text(),'" + descriptionValue +"')]"));
        Assert.assertTrue("Text not found!", listActive.size() > 0);
    }
    public void clickFirstListedAttribute () {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("attributesFormId:attributesListId")));
        WebElement attributeTable = webDriver.findElement(
                By.xpath("//*[@id=\"attributesFormId:attributesListId\"]/tbody/tr[1]/td[1]/a"));
        attributeTable.click();
    }

    public void updateAttribute() {
        WebElement updateButton = webDriver.findElement(
                By.xpath("//*[@id=\"updateButtons\"]/input[1]"));
        updateButton.click();

    }
    public void registerAttribute() {

        WebElement registerButton = webDriver.findElement(
                By.id("attributesFormId:register"));
        registerButton.click();

    }

    public void registerName(String registerNameValue) {
        WebElement registerAttributeName = webDriver.findElement(
                By.id("j_idt135:name:nameId"));
        registerAttributeName.clear();
        registerAttributeName.sendKeys(registerNameValue);
    }

    public void registerSAML1(String registerSAML1UriValue) {
        WebElement registerSAML1Uri = webDriver.findElement(
                By.id("j_idt135:saml1Uri:saml1Id"));
        registerSAML1Uri.clear();
        registerSAML1Uri.sendKeys(registerSAML1UriValue);
    }

    public void registerSAML2(String registerSAML2Value) {
        WebElement registerSAML2Uri = webDriver.findElement(
                By.id("j_idt135:saml2Uri:saml2Id"));
        registerSAML2Uri.clear();
        registerSAML2Uri.sendKeys(registerSAML2Value);

    }

    public void registerDisplayName(String registerDisplayNameValue) {
        WebElement displayName = webDriver.findElement(
                By.id("j_idt135:displayName:displayNameId"));
        displayName.clear();
        displayName.sendKeys(registerDisplayNameValue);

    }

    public void chooseType() {
        Select typeChosen = new Select(webDriver.findElement(
                By.id("j_idt135:dataType:dataTypeId")));
        typeChosen.selectByVisibleText("Boolean");

    }

    public void editType() {
        Select typeEdited = new Select(webDriver.findElement(
                By.id("j_idt135:editType:editTypeId")));
        typeEdited.deselectAll();
        typeEdited.selectByValue("ADMIN");

    }

    public void viewType() {
        Select typeViewed = new Select(webDriver.findElement(
                By.id("j_idt135:viewType:viewTypeId")));
        typeViewed.deselectAll();
        typeViewed.selectByValue("ADMIN");
    }

    public void usageType() {
        Select typeUsed = new Select(webDriver.findElement(
                By.id("j_idt135:usageType:usageTypeId")));
        typeUsed.deselectAll();
        typeUsed.selectByValue("OPENID");
    }

    public void multivalued() {
        Select multivaluedValue = new Select(webDriver.findElement(
                By.id("j_idt135:multivalued:multivaluedId")));
        multivaluedValue.selectByVisibleText("True");
    }

    public void claimName(String claimNameValue) {
        WebElement setClaimName = webDriver.findElement(
                By.id("j_idt135:claimName:claimNameId"));
        setClaimName.clear();
        setClaimName.sendKeys(claimNameValue);
    }

    public void scimAttribute() {
        Select scimAttributeValue = new Select(webDriver.findElement(
                By.id("j_idt135:scimattr:scimAttrId")));
        scimAttributeValue.selectByVisibleText("True");
    }

    public void setAttributeDescription(String descriptionValue) {
        WebElement descriptionText = webDriver.findElement(
                By.id("j_idt135:description:descriptionId"));
        descriptionText.clear();
        descriptionText.sendKeys(descriptionValue);
    }

    public void enableCustomValidation() {
        if (!webDriver.findElement(
                By.id("j_idt135:validationToggle:validationToggleId")).isSelected()) {
            webDriver.findElement(
                    By.id("j_idt135:validationToggle:validationToggleId"))
                    .findElement(By.xpath("..")).click();
        }
    }

    public void setValidationRegExp (String regExpValue) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt135:validationRE:validationREId")));
            WebElement regExText = webDriver.findElement(
                    By.id("j_idt135:validationRE:validationREId"));
            regExText.clear();
            regExText.sendKeys(regExpValue);
    }


    public void enableTooltip() {
        if (!webDriver.findElement(
                By.id("j_idt135:tooltipToggle:tooltipToggleId")).isSelected()) {
            webDriver.findElement(
                    By.id("j_idt135:tooltipToggle:tooltipToggleId"))
                    .findElement(By.xpath("..")).click();
        }

    }
    public void tooltipText(String textValue) {
        waitElementByID("j_idt135:tooltipText:tooltipTextId");
        WebElement tooltipField = webDriver.findElement(
                By.id("j_idt135:tooltipText:tooltipTextId"));
        tooltipField.sendKeys(textValue);

    }

    public void minimumLength(String minimumLengthSet) {
        WebElement minimumLengthValue = webDriver.findElement(
                By.id("j_idt135:minlength:minlengthid"));
        minimumLengthValue.clear();
        minimumLengthValue.sendKeys(minimumLengthSet);

        }
    public void maximumLength(String maximumLengthSet) {
        WebElement maximumLengthValue = webDriver.findElement(
                By.id("j_idt135:maxlength:maxlengthid"));
        maximumLengthValue.clear();
        maximumLengthValue.sendKeys(maximumLengthSet);

    }
    public void regexPattern (String regexPatternSet) {
        WebElement regexPatternValue = webDriver.findElement(
                By.id("j_idt135:regex:regexid"));
        regexPatternValue.clear();
        regexPatternValue.sendKeys(regexPatternSet);

    }
    public void status() {
        Select statusChosen = new Select(webDriver.findElement(
                By.id("j_idt135:status:statusId")));
        statusChosen.selectByVisibleText("INACTIVE");

    }
    public void registerButton() {
        WebElement regButtonFinal = webDriver.findElement(
                By.name("j_idt135:j_idt374"));
        regButtonFinal.click();

    }
    public void cancelButton() {
            WebElement cancelButtonFinal = webDriver.findElement(
                    By.name("j_idt135:j_idt375"));
            cancelButtonFinal.click();
    }
    public void deleteAttribute() {
        WebElement deleteButton = webDriver.findElement(
                By.id("j_idt135:j_idt375"));
        deleteButton.click();
        WebElement confirmDeletion = webDriver.findElement(
                By.id("deleteConfirmation:j_idt390"));
                confirmDeletion.click();

    }

}
