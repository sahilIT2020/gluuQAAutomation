package org.gluu.gluuQAAutomation;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/main/java/org/gluu/gluuQAAutomation/features" }, plugin = { "pretty",
		"json:target/cucumber/json/cucumber.json" }, monochrome = true, tags= { "~@gluuQA"})
@ActiveProfiles(value = "test")
public class AllFeatureBeingImplementedTest {

}
