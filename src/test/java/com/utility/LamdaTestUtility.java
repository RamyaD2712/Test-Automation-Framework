package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LamdaTestUtility {

	private static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<DesiredCapabilities>();

	public static WebDriver intializeLambdaTestSession(String browser, String testName) {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("browserVersion", "127");
		Map<String, Object> ltOptions = new HashMap();
		ltOptions.put("username", "ramyacd.271292");
		ltOptions.put("accessKey", "1ecKb63UZAs5mvOj1NL9Rbww0dj7haYcRD9KHiGcvbNwgIRW0w");
		ltOptions.put("build", "Selenium 4");
		ltOptions.put("name", testName);
		ltOptions.put("platformName", "Windows 10");
		ltOptions.put("seCdp", true);
		ltOptions.put("selenium_version", "4.23.0");
		capabilities.setCapability("LT:Options", ltOptions);
		capabilitiesLocal.set(capabilities);
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driverLocal.set(driver);
		return driverLocal.get();
	}

	public static void quitSession() {
		if (driverLocal.get() != null) {
			driverLocal.get().quit();
		}
	}
}
