package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LamdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(getClass());
	private boolean isLambdaTest;
	// private boolean isHeadless = false;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "Load the HomePage of the Website")
	public void setUp(@Optional("chrome") String browser,@Optional("false") boolean isLambdaTest,@Optional("true") boolean isHeadless, ITestResult result) {

		this.isLambdaTest = isLambdaTest;
		WebDriver lamdadriver;
		if (isLambdaTest) {

			lamdadriver = LamdaTestUtility.intializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lamdadriver);

		} else {
			// Running the test on local machine !!!
			logger.info("Load the HomePage of the Website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}

	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Tear Down the browser")
	public void tearDown() {
		if (isLambdaTest) {
			LamdaTestUtility.quitSession();
		} else {
			homePage.quit();
		}
	}
}
