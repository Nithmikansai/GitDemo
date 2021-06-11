package Mavengroup.Mavenjava;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReportTest {
	ExtentReports extent;
	@BeforeTest
	public void configuration()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter  reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("web automation results");
		reporter.config().setDocumentTitle("Test Results");
		 extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","suresh");
	}
	@Test
	public void browserLogin() throws InterruptedException
	{
		ExtentTest intent=extent.createTest("Initial Test");
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse_workspace\\Chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		System.out.println(driver.getTitle());
		driver.close();
		intent.fail("Result do not match");
		extent.flush();
		}
}
