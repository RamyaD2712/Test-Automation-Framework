package com.ui.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(getClass());

	private static final By SIGN_IN_LINK_LOCATOR = By.className("login");
	
	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName,isHeadless);// To call the parent class constructor from the child class constructor
		//try {
			//goToWebsite(readProperty(QA, "URL"));
			goToWebsite(JSONUtility.readJSON(QA).getUrl());
	//	} 
	/*	catch (IOException e) {
			
			e.printStackTrace();
		}*/
	}
	
	public HomePage(WebDriver driver) {
		super(driver);//To call the parent class constructor from the child class constructor
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}

	public LoginPage goToLoginPage(){//Page Functions
		logger.info("Trying to Perform Click To Go To Sign Page");
		clickOn (SIGN_IN_LINK_LOCATOR);
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
	}
}
