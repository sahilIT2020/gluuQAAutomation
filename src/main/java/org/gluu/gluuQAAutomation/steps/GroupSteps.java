package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.gluu.gluuQAAutomation.pages.users.GroupAddPage;
import org.gluu.gluuQAAutomation.pages.users.GroupManagePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
public class GroupSteps extends BaseSteps {

	@Autowired
	private GroupManagePage groupManagePage;
	@Autowired
	private HomePage homePage;
	@Autowired
	private GroupAddPage groupAddPage;

	@Override
	public void cleanUp() {
		groupManagePage.close();
	}

	@Override
	public void setup() {
		groupManagePage.open();
	}

	@When("^I go to groups manage page$")
	public void gotoGroupManagePage() {
		homePage.goToGroupsManagePage();
	}

	@When("^I go to group add page$")
	public void goToGroupAddPage() {
		homePage.goToGroupAddPage();
	}

	@And("^I search for group with pattern '(.+)'$")
	public void searchGroup(String pattern) {
		groupManagePage.searchGroup(pattern);
	}

	@Then("^I should see a group with description '(.+)'$")
	public void checkGroupExistence(String description) {
		groupManagePage.assertGroupWithExist(description);
	}

	@And("^I should see a group with display name '(.+)'$")
	public void checkGroupExistenceByDisplayName(String displayName) {
		groupManagePage.assertGroupWithExist(displayName);
	}

	@And("^I add a group with display name '(.+)'$")
	public void fillGroupDN(String value) {
		groupAddPage.fillDisplayName(value);
	}

	@And("^I add a group with description '(.+)'$")
	public void fillGroupDesc(String value) {
		groupAddPage.fillDescription(value);
	}

	@And("^I add a group with visibility '(.+)'$")
	public void fillStatus(String value) {
		groupAddPage.fillStatus(value);
	}
	
	@And("^I add the user named '(.+)' as member$")
	public void pickAUser(String user) {
		groupAddPage.pickUser(user);
	}

	@And("^I save the group$")
	public void saveGroup() {
		groupAddPage.save();
	}

}
