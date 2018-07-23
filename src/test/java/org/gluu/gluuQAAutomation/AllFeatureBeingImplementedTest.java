package org.gluu.gluuQAAutomation;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/main/java/org/gluu/gluuQAAutomation/features" }, plugin = { "pretty",
		"json:target/cucumber/json/cucumber.json" }, monochrome = true, tags = { "@gluuQAPending1" })
public class AllFeatureBeingImplementedTest {

}
