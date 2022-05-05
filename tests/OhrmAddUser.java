package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.page.OhrmAddUserPage;

public class OhrmAddUser extends BaseClass {
	
	@Test(priority = 1, dataProvider = "multiSheetExcelRead") //dataProviderClass = ExcelDataProvider.class)
    public void AddUser(String Empname, String Username, String Password, String ConfirmPassword) {
	OhrmAddUserPage adduser=new OhrmAddUserPage(driver);
	LoginToApplication();
	adduser.clickOnAdminTab();
	adduser.clickOnAddUserBtn();
	adduser.enterEmployeeName(Empname);
	adduser.enterUsernamename(Username);
	adduser.enterPassword(Password);
	adduser.enterConfirmPassword(ConfirmPassword);
	adduser.clickOnsaveBtn();
	//WaitUtility.waitForSeconds(6);
	}
}
