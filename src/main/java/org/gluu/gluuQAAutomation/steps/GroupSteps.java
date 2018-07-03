package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.gluu.gluuQAAutomation.pages.users.GroupAddPage;
import org.gluu.gluuQAAutomation.pages.users.GroupManagePage;
import org.gluu.gluuQAAutomation.pages.users.GroupUpdatePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
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
	@Autowired
	private GroupUpdatePage groupUpdatePage;

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

	@And("^I should not see a group with display name '(.+)'$")
	public void checkGroupNonExistenceByDisplayName(String displayName) {
		groupManagePage.assertGroupNotWithExist(displayName);
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
		groupAddPage.fillVisiblility(value);
	}

	@And("^I add the user named '(.+)' as member$")
	public void pickAUser(String user) {
		groupAddPage.pickUser(user);
	}

	@When("^I start to update that group")
	public void startGroupUpdate() {
		groupManagePage.startGroupUpdate();
	}

	@And("^I set the new display name to '(.+)'$")
	public void setDisplayName(String displayName) {
		groupUpdatePage.fillDisplayName(displayName);
	}

	@And("^I set the new description to '(.+)'$")
	public void setDescription(String des) {
		groupUpdatePage.fillDescription(des);
	}

	@And("^I set the new visibility to '(.+)'$")
	public void setVisibility(String vi) {
		groupUpdatePage.fillVisibility(vi);
	}

	@And("^I save the group$")
	public void saveGroup() {
		groupAddPage.save();
	}

	@And("^I save the group edition$")
	public void editGroup() {
		groupUpdatePage.save();
	}

	@And("^I delete the current group$")
	public void dleteGroup() {
		groupUpdatePage.delete();
	}
	@After
	public void clear() {
		System.out.println("#########clear browser cookies##########");
		homePage.clear();
	}
}
