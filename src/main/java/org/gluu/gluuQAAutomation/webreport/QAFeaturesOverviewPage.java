package org.gluu.gluuQAAutomation.webreport;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportResult;

public class QAFeaturesOverviewPage extends QAAbstractPage {

	public static final String WEB_PAGE = QAReportBuilder.HOME_PAGE;

	public QAFeaturesOverviewPage(ReportResult reportResult, Configuration configuration) {
		super(reportResult, "overviewFeatures.vm", configuration);
	}

	@Override
	public String getWebPage() {
		return WEB_PAGE;
	}

	@Override
	public void prepareReport() {
		context.put("all_features", reportResult.getAllFeatures());
		context.put("report_summary", reportResult.getFeatureReport());

		context.put("classifications", configuration.getClassifications());
		context.put("parallel", configuration.isParallelTesting());
	}

}
