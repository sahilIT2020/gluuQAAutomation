package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.gluu.gluuQAAutomation.pages.users.UserAddPage;
import org.gluu.gluuQAAutomation.pages.users.UserImportPage;
import org.gluu.gluuQAAutomation.pages.users.UserManagePage;
import org.gluu.gluuQAAutomation.pages.users.UserUpdatePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
public class UserSteps extends BaseSteps {
	@Autowired
	private HomePage homePage;
	@Autowired
	private UserAddPage userAddPage;
	@Autowired
	private UserUpdatePage userUpdatePage;
	@Autowired
	private UserManagePage userManagePage;
	@Autowired
	private UserImportPage userImportPage;

	@When("^I go to user add page$")
	public void goToUserAddPage() {
		homePage.goToUsersAddPage();
	}

	@And("^I add a user named '(.+)'$")
	public void setUserName(String userName) {
		userAddPage.fillUserName(userName);
	}

	@And("^With first name '(.+)'$")
	public void setFirstName(String firstName) {
		userAddPage.fillFirstName(firstName);
	}

	@And("^With last name '(.+)'$")
	public void setLastName(String lastName) {
		userAddPage.fillLastName(lastName);
	}

	@And("^With display name '(.+)'$")
	public void setDisplayName(String displayName) {
		userAddPage.fillDisplayName(displayName);
	}

	@And("^With email '(.+)'$")
	public void setEmail(String email) {
		userAddPage.fillEmail(email);
	}

	@And("^With password '(.+)'$")
	public void setPassword(String pwd) {
		userAddPage.fillPassword(pwd);
	}

	@And("^With status '(.+)'$")
	public void setStatus(String status) {
		userAddPage.fillStatus(status);
	}

	@And("^I save the user$")
	public void saveUser() {
		userAddPage.save();
	}

	@When("^I go to users manage page$")
	public void gotoUserManagePage() {
		homePage.goToUsersManagePage();
	}

	@And("^I search for user with pattern '(.+)'$")
	public void searchUser(String pattern) {
		userManagePage.searchUser(pattern);
	}

	@Then("^I should see a user named '(.+)'$")
	public void checkUserExistence(String userName) {
		userManagePage.assertUserWithExist(userName);
	}

	@Then("^I should not see a user named '(.+)'$")
	public void checkUserNonExistence(String userName) {
		userManagePage.assertUserNotWithExist(userName);
	}

	@And("^I should see a user with display name '(.+)'$")
	public void checkUserExistenceByDisplayName(String displayName) {
		userManagePage.assertUserWithExist(displayName);
	}

	@When("^I start to update that user$")
	public void startUpdate() {
		userManagePage.startUserUpdate();
	}

	@And("^I set the userName to '(.+)'$")
	public void updateUserName(String userName) {
		userUpdatePage.fillUserName(userName);
	}

	@And("^I set the display name to '(.+)'$")
	public void updateDisplayName(String displayName) {
		userUpdatePage.fillDisplayName(displayName);
	}

	@And("^I set the email to '(.+)'$")
	public void updateEmail(String email) {
		userUpdatePage.fillEmail(email);
	}

	@And("^I save the update$")
	public void save() {
		userUpdatePage.save();
	}

	@And("^I delete the current user$")
	public void delete() {
		userUpdatePage.delete();
	}

	@When("^I go to users import page$")
	public void goToUsersImportPage() {
		homePage.goToUsersImportPage();
	}

	@And("^I import the sample excel file locate at '(.+)'$")
	public void importFile(String filePath) {
		userImportPage.importUsers(filePath);
	}

	@And("^I set his password to '(.+)'$")
	public void changePassword(String pwd) {
		userUpdatePage.changePassword(pwd);
		homePage.goToUsersManagePage();
	}

	@After
	public void clear() {
		System.out.println("#########clear browser cookies##########");
		homePage.clear();
	}

}
