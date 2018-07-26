package org.gluu.gluuQAAutomation.steps;

import org.gluu.gluuQAAutomation.pages.configuration.cr.CacheRefreshPage;
import org.gluu.gluuQAAutomation.pages.login.HomePage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import cucumber.api.java.After;
import cucumber.api.java.en.And;

@RunWith(SpringRunner.class)
public class CacheRefreshSteps extends BaseSteps {

	@Autowired
	private HomePage homePage;
	@Autowired
	private CacheRefreshPage cacheRefreshPage;

	@And("^I go to cache refresh page$")
	public void goToCacheRefreshPage() {
		homePage.goToCacheRefreshMenuPage();
	}

	@And("^I select the tab named '(.+)'$")
	public void selectTab(String name) {
		cacheRefreshPage.selectTab(name);
	}

	@And("^I add a source attribute named '(.+)' to destination attribute named '(.+)'$")
	public void addSourceAttribute(String source, String destination) {
		cacheRefreshPage.addSourceAttribute(source, destination);
	}

	@And("^I set polling interval to '(.+)' minutes$")
	public void setPollingInterval(String intervall) {
		cacheRefreshPage.setPollingInterval(intervall);
	}

	@And("^I enable cache refresh$")
	public void enableCacheRefresh() {
		cacheRefreshPage.enableCacheRefresh();
	}
	
	@And("^I add a key attribute named '(.+)'$")
	public void addKeyAttrib(String attrib) {
		cacheRefreshPage.addKeyAttrib(attrib);
	}
	
	@And("^I save the cache refresh configuration$")
	public void saveCRConfig() {
		cacheRefreshPage.save();
	}

	@After
	public void clear() {
		homePage.clear();
	}
}
