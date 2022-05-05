package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationTest {
	@Test
	public void Pagination() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		int pageSize = driver.findElements(By.xpath("//div[@id='example_paginate']//span//a")).size();
		List<String> names = new ArrayList<String>();
		for (int i = 1; i <= pageSize; i++) {
			String paginationSelector = "//div[@id='example_paginate']//span//a[" + i + "]";
			driver.findElement(By.xpath(paginationSelector)).click();
			List<WebElement> namesElements = driver.findElements(By.xpath("//table[@id='example']//tbody//tr//td[1]"));
			for (WebElement nameElements : namesElements) {
				names.add(nameElements.getText());
			}
		}
		for (String name : names) {
			System.out.println("Names of the elements: " + name);
		}
		int totalNames = names.size();
		System.out.println("No of names: " + totalNames);
		Reporter.info("Pagination");
		Reporter.logger.info("No of names: "+ totalNames);
		String displayedCount = driver.findElement(By.xpath("//div[@id='example_info']")).getText().split(" ")[5];
		System.out.println("Total no of displayed count: " + displayedCount);
		Reporter.logger.info("Total no of displayed count: " + displayedCount);
		Assert.assertEquals(displayedCount, String.valueOf(totalNames));
		Thread.sleep(5000);
		driver.quit();
	}
}
