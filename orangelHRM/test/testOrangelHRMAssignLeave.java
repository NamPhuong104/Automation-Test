package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import pageFactory.OrangelHRMAssignLeave;
import util.OrangelHRMCommon;

public class testOrangelHRMAssignLeave {
	WebDriver driver;
	ChromeOptions options;
	WebDriverWait wait;

	OrangelHRMCommon common;
	OrangelHRMAssignLeave assignLeave;


	@BeforeTest
	public void setup() {
		options = new ChromeOptions();
		options.addArguments("Start-maximized");

		driver = new ChromeDriver(options);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		common = new OrangelHRMCommon(driver);
		common.loginToOrangel("admin", "admin123");

		assignLeave = new OrangelHRMAssignLeave(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		common.chooseModuleOrangel("Leave");
		common.chooseFunction("Assign Leave");
	}

	public void TC_AL_01() {
		assignLeave.setNameEmployee("Odis  Adalwin");
		assignLeave.chooseUser("Odis  Adalwin");
	}
}
