package org.gluu.gluuQAAutomation;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"src/main/java/org/gluu/gluuQAAutomation/features" }, monochrome = true, dryRun = true)
@ActiveProfiles(value = "test")
public class AllFeatureDryRunTest {

}
