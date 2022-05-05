package common;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporter extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	WebDriver driver;

	public void onStart(ITestContext testContext)
		{
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/" + "practice.html");//specifying location of the report
			htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml"); //this is simple config file taken from extent reports documentation site

			extent = new ExtentReports();

			extent.attachReporter(htmlReporter);
		
			extent.setSystemInfo("user", "Shubhangi");

			htmlReporter.config().setDocumentTitle("practice Project"); // Tile of report
			htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
			htmlReporter.config().setTheme(Theme.DARK); //dark theme set 
		}

	public void onTestSuccess(ITestResult tr)
		{
			logger = extent.createTest(tr.getName()); // create new entry in the report
			logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // setting green colour for passed tests
		
		logger.log(Status.PASS,"Successful");
		}

	public void onTestFailure(ITestResult tr)
		{
			logger = extent.createTest(tr.getName()); // create new entry in the report
			logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // setting red colour for Failed tests
		logger.fail(tr.getThrowable());
		
		try {
			logger.addScreenCaptureFromPath(Screenshot.getSreenshotPath(tr.getMethod().getMethodName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		}

	public void onTestSkipped(ITestResult tr)
		{
			logger = extent.createTest(tr.getName()); // create new entry in the report
			logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));//setting orange colour for skipped tests
		}

	public void onFinish(ITestContext testContext)
		{
			extent.flush();//when all tests finished simple we will call this flush method to generate reports..
		}
	
	public static void info(String desc)
	{
		logger=extent.createTest(desc);
		//logger.log(Status.INFO, desc);
}
}

