package pageObjects.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OhrmAddUserPage 
{
	// declaration
				@FindBy(xpath = "//a[.='Admin']")
				private WebElement adminTab;
				@FindBy(xpath = "//input[@id='btnAdd']")
				private WebElement addUserBtn;
				@FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
				private WebElement employeeName;
				@FindBy(xpath = "//input[@id='systemUser_userName']")
				private WebElement username;
				@FindBy(xpath = "//input[@id='systemUser_password']")
				private WebElement password;
				@FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
				private WebElement confirmPassword;
				@FindBy(xpath = "//input[@value='Save']")
				private WebElement saveBtn;

			//Initialisation
				public OhrmAddUserPage(WebDriver driver) 
				{
					PageFactory.initElements(driver, this);
				}

			//Utilisation
				
				public void clickOnAdminTab() 
				{
					adminTab.click();
				}
				public void clickOnAddUserBtn() 
				{
					addUserBtn.click();
				}
				public void enterEmployeeName(String Empname) 
				{
					employeeName.sendKeys(Empname);
				}
				public void enterUsernamename(String Username) 
				{
					username.sendKeys(Username);
				}
				public void enterPassword(String Password) 
				{
					password.sendKeys(Password);
				}

				public void enterConfirmPassword(String ConfirmPassword) 
				{

					confirmPassword.sendKeys(ConfirmPassword);
				}	
				public void clickOnsaveBtn() 
				{
					saveBtn.click();
				}
}
