package org.gluu.gluuQAAutomation.pages.personal;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfilePage extends AbstractPage {


    public void updateDefaultAttributes(List<String> defaultList) {
        List<WebElement> attributesList = webDriver.findElements(By.className("rf-ii-fld"));
        waitElementByClass("rf-ii");
        for (int i = 0; i < defaultList.size(); i++) {
            attributesList.get(i).click();
            attributesList.get(i).sendKeys(defaultList.get(i));
        }
    }

}


