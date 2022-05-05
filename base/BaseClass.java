package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import common.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.page.OHRMLoginPage;

public class BaseClass {
	public static WebDriver driver;

	@BeforeClass
	public static void setUp() throws IOException {
		Constants.Initconfig();
		String browserValue = Constants.browser;
		String ohrmurl = Constants.ohrmurl;

		if (browserValue.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(ohrmurl);
		} else if (browserValue.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(ohrmurl);

		} else if (browserValue.equalsIgnoreCase("msedge")) {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(ohrmurl);
		}
	}

	public void LoginToApplication() {
		OHRMLoginPage LoginPage = new OHRMLoginPage(driver);
		LoginPage.setCredentials(Constants.ohrm_username, Constants.ohrm_password);
		LoginPage.clickLogin();
	}

	@AfterClass
	public void close() {
		driver.close();
	}
}
