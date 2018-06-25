package org.gluu.gluuQAAutomation.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ApplicationDriver {

	private static final String WIN = "WIN";
	private static final String MAC = "MAC";
	private static final String LINUX = "LINUX";
	private static final String CHROME = "CHROM";
	private static final String GLUU_SERVER_URL = "GLUU_SERVER_URL";
	private static final String GLUU_USERNAME = "GLUU_USERNAME";
	private static final String GLUU_USERPWD = "GLUU_USERPWD";
	private static final String QA_BROWSER = "QA_BROWSER";
	private static final String QA_OS = "QA_OS";
	private static WebDriver driver;
	private static Settings settings;
	private static ChromeOptions options;

	public static WebDriver getInstance() {
		if (driver == null) {
			readConfiguration();
			initDriverOptions();
			if (settings.getOs().equalsIgnoreCase(WIN) && settings.getBrowser().startsWith(CHROME)) {
				System.setProperty("webdriver.chrome.driver",
						"src/main/java/org/gluu/gluuQAAutomation/util/chromedriver-win.exe");
				driver = new ChromeDriver();
				return driver;
			} else if (settings.getOs().equalsIgnoreCase(MAC) && settings.getBrowser().startsWith(CHROME)) {
				System.setProperty("webdriver.chrome.driver",
						"src/main/java/org/gluu/gluuQAAutomation/util/chromedriver-mac");
				driver = new ChromeDriver();
				return driver;
			} else if (settings.getOs().equalsIgnoreCase(LINUX) && settings.getBrowser().startsWith(CHROME)) {
				System.setProperty("webdriver.chrome.driver",
						"src/main/java/org/gluu/gluuQAAutomation/util/chromedriver-linux");
				driver = new ChromeDriver(options);
				return driver;

			} else {
				throw new IllegalArgumentException("OS or Browser not supported yet");
			}
		}
		return driver;
	}

	public static Settings getSettings() {
		if (settings == null) {
			readConfiguration();
		}
		return settings;
	}

	private ApplicationDriver() {
	}

	public static void initDriverOptions() {
		options = new ChromeOptions();
		options.setCapability("acceptInsecureCerts", true);
		options.setCapability("applicationCacheEnabled", true);
		options.setCapability("browserConnectionEnabled", true);
		options.setCapability("networkConnectionEnabled", true);
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("start-maximized");
	}

	public static void readConfiguration() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("src/main/java/org/gluu/gluuQAAutomation/configuration/config.properties");
			prop.load(input);
			settings = new Settings(prop.getProperty(GLUU_SERVER_URL), prop.getProperty(GLUU_USERNAME),
					prop.getProperty(GLUU_USERPWD), prop.getProperty(QA_BROWSER), prop.getProperty(QA_OS));
			AbstractPage.settings = settings;
			System.out.println("*********************************************************************");
			System.out.println(settings.toString());
			System.out.println("*********************************************************************");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
