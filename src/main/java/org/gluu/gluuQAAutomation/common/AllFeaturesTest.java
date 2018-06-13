package org.gluu.gluuQAAutomation.common;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

import cucumber.api.junit.Cucumber;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "org.gluu.gluuQAAutomation.steps" }, features = { "src/main/java/org/gluu/gluuQAAutomation/features" })
@ActiveProfiles(value = "test")
public class AllFeaturesTest {
	
	
}
