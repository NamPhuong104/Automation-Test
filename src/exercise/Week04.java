package exercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Week04 {
	private ChromeOptions options;
	private WebDriver driver;
	private String baseUrl1;
	private String baseUrl2;

	public void selectMenuItem(String menuItem) {
		List<WebElement> menuChildElements = driver.findElements(
				By.xpath("//div[@class=\"menu-block\"]/ul/child::li//a[contains(text()," + menuItem + ")]"));
		for (int i = 0; i < menuChildElements.size(); i++) {
			if (menuChildElements.get(i).getText().contentEquals(menuItem)) {
				menuChildElements.get(i).click();
				break;
			}
		}
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		baseUrl1 = "https://demo.guru99.com/test/guru99home/";
		baseUrl2 = "https://demo.guru99.com/test/simple_context_menu.html";
	}

	// PowerPoint 04_01
	@Test
	public void firstTest() throws Exception {
		driver.get(baseUrl1);
		selectMenuItem("Testing");
	}

	// PowerPoint 04_02
	@Test
	public void secondTest() throws Exception {
		driver.get(baseUrl2);
		Actions actions = new Actions(driver);

		WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		actions.doubleClick(doubleClickButton).perform();
		driver.switchTo().alert().accept();
	}

	@Test
	public void thirdTest() throws Exception {
		driver.get(baseUrl2);
		Actions actions = new Actions(driver);

		WebElement rightClickButton = driver.findElement(By.cssSelector(".context-menu-one"));
		actions.contextClick(rightClickButton).perform();
		WebElement copy = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
		copy.click();
		driver.switchTo().alert().accept();
	}
	
	@AfterTest
	public void afterTest() throws Exception {
		driver.close();
	}
}
