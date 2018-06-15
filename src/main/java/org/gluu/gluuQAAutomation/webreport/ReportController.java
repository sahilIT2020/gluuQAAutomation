package org.gluu.gluuQAAutomation.webreport;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportController {

	private static final String PATH_HOME = "/";
	private static final String PATH_FAILURES = "/failures";
	private static final String PATH_FEATURES = "/features";
	private static final String PATH_TAGS = "/tags";
	private static final String PATH_STEPS = "/steps";

	@RequestMapping(value = PATH_HOME, method = RequestMethod.GET)
	public String home(Model model) {
		return "HomePage";
	}

	@RequestMapping(value = PATH_TAGS, method = RequestMethod.GET)
	public String tags(Model model) {
		ReportGenerator.generatedReport();
		return "TagsOverviewPage";
	}

	@RequestMapping(value = PATH_FAILURES, method = RequestMethod.GET)
	public String failures(Model model) {
		ReportGenerator.generatedReport();
		return "FailuresOverviewPage";
	}

	@RequestMapping(value = PATH_FEATURES, method = RequestMethod.GET)
	public String features(Model model) {
		ReportGenerator.generatedReport();
		return "FeaturesOverviewPage";
	}

	@RequestMapping(value = PATH_STEPS, method = RequestMethod.GET)
	public String steps(Model model) {
		return "StepsOverviewPage";
	}

}
