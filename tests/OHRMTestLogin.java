package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import common.Constants;
import common.Reporter;
import pageObjects.page.OHRMLoginPage;


public class OHRMTestLogin extends BaseClass {
		@Test()
		public void Login() throws InterruptedException, IOException {
			OHRMLoginPage LoginPage = new OHRMLoginPage(driver);
			LoginPage.setCredentials(Constants.ohrm_username, Constants.ohrm_password);
			LoginPage.clickLogin();
			Reporter.info("Login Orange HRM");
			Reporter.logger.info("Login Orange HRM Application sucessfully");
		
	}
}
