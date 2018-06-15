package org.gluu.gluuQAAutomation;

import org.gluu.gluuQAAutomation.webreport.ReportGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GluuQaAutomationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GluuQaAutomationApplication.class, args);
		context.getBean(ReportGenerator.class);
		ReportGenerator.generatedReport();
	}
}
