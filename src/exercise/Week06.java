package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Week06 {
	private ChromeOptions options;
	private WebDriver driver;
	private String baseUrl = "https://demo.guru99.com/test/newtours/index.php";

	@BeforeTest
	public void beforeTest() throws Exception {
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get(baseUrl);
	}

	// Exercise 1
	@BeforeMethod()
	public void verifyHomepageTitle() throws Exception {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 0, enabled = false)
	public void register() throws Exception {
		driver.findElement(By.linkText("REGISTER")).click();
		String expectedTitle = "Register: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 1, enabled = false)
	public void support() throws Exception {
		driver.findElement(By.linkText("SUPPORT")).click();
		String expectedTitle = "Under Construction: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterMethod()
	public void goBackToHome() throws Exception {
		driver.findElement(By.linkText("Home")).click();
	}
	
	//Exercise 2
	@Test(priority = 0)
	public void verifyRegisterSuccessfully() throws Exception {
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(1000);
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("test@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("test");
		WebElement confirmPassword = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
		confirmPassword.sendKeys("test");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	@Test(priority = 1)
	public void verifyLoginSuccessfully() throws Exception {
		WebElement userName = driver.findElement(By.xpath("//input[@name='userName']"));
		userName.sendKeys("test@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("test");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	@Test(priority = 2)
	public void verifyFindFlightTicket() throws Exception {
		driver.findElement(By.linkText("Flights")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='findFlights']")).click();
	}
	

	@AfterTest()
	public void afterTest() throws Exception {
		driver.close();
	}
}
