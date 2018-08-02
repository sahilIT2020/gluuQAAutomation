package org.gluu.gluuQAAutomation.steps;

import com.google.common.collect.Lists;
import cucumber.api.java.en.And;
import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.gluu.gluuQAAutomation.pages.personal.ProfilePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class ProfileSteps extends BaseSteps {

@Autowired
private HomePage homePage;
@Autowired
private ProfilePage profilePage;

@And("^I go to the personal profile page")
public void goToPersonalProfilePage() {
    homePage.goToProfileViewMenu();
}
@And("^I set the new values to '(.+)'$")
public void setNewAttributeValues(String newValues) {
    List<String> values = Lists.newArrayList(newValues.split(","));
    profilePage.updateDefaultAttributes(values);
}

}

