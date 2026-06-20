package Com.DemoWebShop_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.DemoWebShop_POM.Home_Page;
import Com.DemoWebShop_POM.Login_Page;
import Com.DemoWebShop_POM.Welcome_Page;

public class BaseTest {

	public WebDriver driver;
	public static WebDriver sdriver;

	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public FileUtility fileutility = new FileUtility();
	public Welcome_Page welcomePage;
	public Login_Page loginPage;
	public Home_Page homePage;
	public WebDriverUtility webDriverUtility = new WebDriverUtility();

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite ----Database Connection");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test ----Report Generation");

		spark = new ExtentSparkReporter(FrameworkConstants.extendReportPath);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		test = reports.createTest("DemoWebShop Address Module");

	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("Before Class ----Browser SetUp");
		String browser = fileutility.readDataFromPropertyFile("browserName");
		String url = fileutility.readDataFromPropertyFile("url");

		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Chrome browser is launched");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.out.println("Edge browser is launched");
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("foirefox browser is launched");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		sdriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);

	}

	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {
		System.out.println("Before Method ----Login Application");

		welcomePage = new Welcome_Page(driver);
		welcomePage.getLoginLink().click();

		loginPage = new Login_Page(driver);
		loginPage.getEmailTextField().sendKeys(fileutility.readDataFromPropertyFile("username"));
		loginPage.getPasswordTextField().sendKeys(fileutility.readDataFromPropertyFile("password"));
		loginPage.getLoginButton().click();
		homePage = new Home_Page(driver);

	}

	@AfterMethod
	public void AfteMethod() throws InterruptedException {
		System.out.println("After Method ----Logout Application");
		Thread.sleep(3000);
		homePage.getLogoutLink().click();

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("After Class ----Exit Browser");
		Thread.sleep(3000);
		driver.quit();

	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test ----Report Closed");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite ----Logout Application");
	}

}
