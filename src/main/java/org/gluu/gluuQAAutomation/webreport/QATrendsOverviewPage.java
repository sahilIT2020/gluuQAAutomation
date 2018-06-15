package org.gluu.gluuQAAutomation.webreport;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportResult;
import net.masterthought.cucumber.Trends;

public class QATrendsOverviewPage extends QAAbstractPage {

	public static final String WEB_PAGE = "overview-trends.html";

	private final Trends trends;

	public QATrendsOverviewPage(ReportResult reportResult, Configuration configuration, Trends trends) {
		super(reportResult, "overviewTrends.vm", configuration);
		this.trends = trends;
	}

	@Override
	public String getWebPage() {
		return WEB_PAGE;
	}

	@Override
	public void prepareReport() {
		context.put("buildNumbers", trends.getBuildNumbers());

		context.put("failedFeatures", trends.getFailedFeatures());
		context.put("totalFeatures", trends.getTotalFeatures());
		context.put("failedScenarios", trends.getFailedScenarios());
		context.put("totalScenarios", trends.getTotalScenarios());

		context.put("passedSteps", trends.getPassedSteps());
		context.put("failedSteps", trends.getFailedSteps());
		context.put("skippedSteps", trends.getSkippedSteps());
		context.put("pendingSteps", trends.getPendingSteps());
		context.put("undefinedSteps", trends.getUndefinedSteps());

		context.put("durations", trends.getDurations());
	}

}
