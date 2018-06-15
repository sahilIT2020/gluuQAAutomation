package org.gluu.gluuQAAutomation.webreport;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportResult;
import net.masterthought.cucumber.json.Feature;

public class QAFeatureReportPage extends QAAbstractPage {
	private final Feature feature;

	public QAFeatureReportPage(ReportResult reportResult, Configuration configuration, Feature feature) {
		super(reportResult, "reportFeature.vm", configuration);
		this.feature = feature;
	}

	@Override
	public String getWebPage() {
		return feature.getReportFileName();
	}

	@Override
	public void prepareReport() {
		context.put("parallel", configuration.isParallelTesting());
		context.put("feature", feature);
	}

}
