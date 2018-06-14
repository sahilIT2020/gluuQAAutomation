package org.gluu.gluuQAAutomation.webreport;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;

public class ReportGenerator {
	public static void generatedReport() {
		File reportOutputDirectory = new File("src/main/resources/");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target/cucumber/report/cucumber.json");

		String buildNumber = "1";
		String projectName = "GluuQAAutomation";
		boolean runWithJenkins = false;
		boolean parallelTesting = false;

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		configuration.setParallelTesting(parallelTesting);
		configuration.setRunWithJenkins(runWithJenkins);
		configuration.setBuildNumber(buildNumber);
		configuration.addClassifications("Platform", "Linux");
		configuration.addClassifications("Browser", "CHROME");
		configuration.addClassifications("Branch", "master");
		QAReportBuilder reportBuilder = new QAReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
	}
}
