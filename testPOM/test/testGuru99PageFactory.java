package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.Guru99HomePage;
import PageFactory.Guru99Login;


public class testGuru99PageFactory {
	WebDriver driver;
	Guru99Login objLogin;
	Guru99HomePage objHomePage;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");
	}

//	TestCase with Page Factory
	@Test(priority = 0)
	public void test_HomePage_Appear_Correct() {
		objLogin = new Guru99Login(driver);

		String loginPageTitleString = objLogin.getLoginTitle();
		Assert.assertTrue(loginPageTitleString.toLowerCase().contains("guru99 bank"));

		objLogin.loginToGuru99("mgr123", "mgr!23");

		objHomePage = new Guru99HomePage(driver);
		Assert.assertTrue(objHomePage.getHomePageDasboardUserName().toLowerCase().contains("manger id : mgr123"));
	}

}
