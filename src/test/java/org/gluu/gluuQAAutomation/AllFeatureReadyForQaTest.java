package org.gluu.gluuQAAutomation;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

import cucumber.api.junit.Cucumber;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/main/java/org/gluu/gluuQAAutomation/features" }, plugin = { "pretty",
		"json:target/cucumber/json/cucumber.json" }, monochrome = true, tags = { "@gluuQA" })
@ActiveProfiles(value = "test")
public class AllFeatureReadyForQaTest {

}
