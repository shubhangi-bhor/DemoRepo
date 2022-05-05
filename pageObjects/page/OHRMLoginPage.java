package pageObjects.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OHRMLoginPage {
	// declaration
				@FindBy(xpath = "//input[@id='txtUsername']")
				private WebElement username;
				@FindBy(xpath = "//input[@id='txtPassword']")
				private WebElement password;
				@FindBy(xpath = "//input[@id='btnLogin']")
				private WebElement loginBtn;

			//Initialisation
				public OHRMLoginPage(WebDriver driver) 
				{
					PageFactory.initElements(driver, this);
				}

			//Utilisation
				
				public void setCredentials(String validUsername, String validPassword) 
				{
					if (username.isDisplayed()) 
					{
						username.sendKeys(validUsername);
					}
					if (password.isDisplayed()) 
					{
						password.sendKeys(validPassword);
					}
				}

				public void clickLogin() 
				{

					loginBtn.click();
				}

}
