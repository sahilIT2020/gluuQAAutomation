package org.gluu.gluuQAAutomation.webreport;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportResult;
import net.masterthought.cucumber.json.support.TagObject;

public class QATagReportPage extends QAAbstractPage {
	private final TagObject tagObject;

	public QATagReportPage(ReportResult reportResult, Configuration configuration, TagObject tagObject) {
		super(reportResult, "reportTag.vm", configuration);
		this.tagObject = tagObject;
	}

	@Override
	public String getWebPage() {
		return tagObject.getReportFileName();
	}

	@Override
	public void prepareReport() {
		context.put("tag", tagObject);
	}

}
