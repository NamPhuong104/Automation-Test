package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(exercise.ListenerTest.class)

public class Week07 implements ITestListener {
	private ChromeOptions options;
	private WebDriver driver;
	private String baseUrl = "https://demo.guru99.com/V4/";

	@BeforeTest
	public void beforeTest() throws Exception {
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get(baseUrl);
	}
	
	@Test
	public void Login() throws Exception {
		driver.findElement(By.name("uid")).sendKeys("mngr34926");
		driver.findElement(By.name("password")).sendKeys("amUpenu");
		driver.findElement(By.name("btnLogin")).click();
	}
	
	@Test
	public void TestToFail() throws Exception {
		System.out.println("This method to test fail");
		Assert.assertTrue(false);
	}
}
