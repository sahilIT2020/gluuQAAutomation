package org.gluu.gluuQAAutomation.webreport;

import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportResult;
import net.masterthought.cucumber.json.Element;
import net.masterthought.cucumber.json.Feature;

public class QAFailuresOverviewPage extends QAAbstractPage {
	public static final String WEB_PAGE = "overview-failures.html";

	public QAFailuresOverviewPage(ReportResult reportResult, Configuration configuration) {
		super(reportResult, "overviewFailures.vm", configuration);
	}

	@Override
	public String getWebPage() {
		return WEB_PAGE;
	}

	@Override
	public void prepareReport() {
		context.put("failures", collectFailures());
	}

	private List<Element> collectFailures() {
		List<Element> failures = new ArrayList<>();
		for (Feature feature : reportResult.getAllFeatures()) {
			if (feature.getStatus().isPassed()) {
				continue;
			}

			for (Element element : feature.getElements()) {
				if (!element.getStepsStatus().isPassed()) {
					failures.add(element);
				}
			}
		}
		return failures;
	}

}
