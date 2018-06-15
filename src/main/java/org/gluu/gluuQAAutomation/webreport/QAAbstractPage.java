package org.gluu.gluuQAAutomation.webreport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.app.event.EventCartridge;
import org.apache.velocity.app.event.implement.EscapeHtmlReference;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportResult;
import net.masterthought.cucumber.ValidationException;
import net.masterthought.cucumber.util.Counter;
import net.masterthought.cucumber.util.Util;

public abstract class QAAbstractPage {

	private static final Logger LOG = Logger.getLogger(QAAbstractPage.class.getName());

	private final VelocityEngine engine = new VelocityEngine();
	protected final VelocityContext context = new VelocityContext();

	/** Name of the HTML file which will be generated. */
	private final String templateFileName;
	/** Results of the report. */
	protected final ReportResult reportResult;
	/** Configuration used for this report execution. */
	protected final Configuration configuration;

	protected QAAbstractPage(ReportResult reportResult, String templateFileName, Configuration configuration) {
		this.templateFileName = templateFileName;
		this.reportResult = reportResult;
		this.configuration = configuration;

		this.engine.init(buildProperties());
		buildGeneralParameters();
	}

	public void generatePage() {
		prepareReport();
		generateReport();
	}

	/**
	 * Returns HTML file name (with extension) for this report.
	 *
	 * @return HTML file for the report
	 */
	public abstract String getWebPage();

	protected abstract void prepareReport();

	private void generateReport() {
		context.put("report_file", getWebPage());
		Template template = engine.getTemplate("templates/generators/" + templateFileName);
		File reportFile = new File(configuration.getReportDirectory(),
				QAReportBuilder.BASE_DIRECTORY + File.separatorChar + getWebPage());
		try (Writer writer = new OutputStreamWriter(new FileOutputStream(reportFile), StandardCharsets.UTF_8)) {
			template.merge(context, writer);
		} catch (IOException e) {
			throw new ValidationException(e);
		}
	}

	private Properties buildProperties() {
		Properties props = new Properties();
		props.setProperty("runtime.log", new File(configuration.getReportDirectory(), "velocity.log").getPath());
		props.setProperty("resource.loader", "file");
		props.setProperty("file.resource.loader.path", "src/main/resources/cucumber");
		props.setProperty("file.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.FileResourceLoader");
		props.setProperty("file.resource.loader.cache", "false");
		return props;
	}

	private void buildGeneralParameters() {
		// to escape html and xml
		EventCartridge ec = new EventCartridge();
		ec.addEventHandler(new EscapeHtmlReference());
		context.attachEventCartridge(ec);

		// to provide unique ids for elements on each page
		context.put("counter", new Counter());
		context.put("util", Util.INSTANCE);

		context.put("run_with_jenkins", configuration.isRunWithJenkins());
		context.put("trends_present", configuration.getTrendsStatsFile() != null);
		context.put("build_project_name", configuration.getProjectName());
		context.put("build_number", configuration.getBuildNumber());

		// if report generation fails then report is null
		String formattedTime = reportResult != null ? reportResult.getBuildTime() : ReportResult.getCurrentTime();
		context.put("build_time", formattedTime);

		// build number is not mandatory
		String buildNumber = configuration.getBuildNumber();
		if (StringUtils.isNotBlank(buildNumber) && configuration.isRunWithJenkins()) {
			if (NumberUtils.isCreatable(buildNumber)) {
				context.put("build_previous_number", Integer.parseInt(buildNumber) - 1);
			} else {
				LOG.log(Level.INFO,
						String.format("Could not parse build number: %1$s.", configuration.getBuildNumber()));
			}
		}
	}

}
