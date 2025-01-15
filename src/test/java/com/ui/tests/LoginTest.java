package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.Listeners.TestListeners.class)
public class LoginTest extends TestBase {
	
	Logger logger = LoggerUtility.getLogger(getClass());
	
    @Test(description = "verfies with the valid user is able to login into the application", groups={"e2e","Sanity"}, dataProviderClass = com.ui.dataproviders.LOginDataProvider.class, dataProvider="LOginTestDataProvider")
	public void loginTest(User user) {
    
    	  assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getuserName(), "Ramya D");
      }
    @Test(description = "verfies with the valid user is able to login into the application", groups={"e2e","Sanity"}, dataProviderClass = com.ui.dataproviders.LOginDataProvider.class, dataProvider="LOginTestCSVDataProvider")
	public void loginCSVTest(User user) {
    
    	  assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getuserName(), "Ramya D");
      }
    @Test(description = "verfies with the valid user is able to login into the application", groups={"e2e","Sanity"}, dataProviderClass = com.ui.dataproviders.LOginDataProvider.class, dataProvider="LOginTestExcelDataProvider",retryAnalyzer = com.ui.Listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(User user) {
       
    	  assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getuserName(), "Ramya D");
      
      }
}
