package org.gluu.gluuQAAutomation.webreport;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;

@Controller
public class ReportController {

	private static final String PATH_HOME = "/";
	private static final String PATH_FAILURES = "/failures";
	private static final String PATH_TAGS = "/tags";
	private static final String PATH_STEPS = "/steps";

	@RequestMapping(value = PATH_HOME, method = RequestMethod.GET)
	public String features(Model model) {
		return "FeaturesOverviewPage";
	}

	@RequestMapping(value = PATH_TAGS, method = RequestMethod.GET)
	public String tags(Model model) {
		return "TagsOverviewPage";
	}

	@RequestMapping(value = PATH_FAILURES, method = RequestMethod.GET)
	public String failures(Model model) {
		return "FailuresOverviewPage";
	}

	@RequestMapping(value = PATH_STEPS, method = RequestMethod.GET)
	public String steps(Model model) {
		return "StepsOverviewPage";
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String getOther(Model model, HttpServletRequest request) {
		String restOfTheUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		return restOfTheUrl;
	}

}
