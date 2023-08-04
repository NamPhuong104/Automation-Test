package exercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Week03 {
	private ChromeOptions options;
	private WebDriver driver;
	private JavascriptExecutor jse;
	private String baseUrl1;
	private String baseUrl2;

	@BeforeTest
	public void beforeTest() throws Exception {
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		jse = (JavascriptExecutor)driver;
		baseUrl1 = "http://demo.guru99.com/test/radio.html";
		baseUrl2 = "https://chandanachaitanya.github.io/selenium-practice-site";
	}

	// PowerPoint 03_01
	@Test(enabled = false)
	public void firstTest() throws Exception {
		driver.get(baseUrl1);

		WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
		WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
		radio1.click();
		radio2.click();
	}

	@Test(enabled = false)
	public void secondTest() throws Exception {
		driver.get(baseUrl1);

		WebElement option1 = driver.findElement(By.id("vfb-6-0"));
		// Toggle on the check box
		option1.click();
		// Check whether the check box is toggled on
		if (option1.isSelected()) {
			System.out.println("Check box is toggled on");
		} else {
			System.out.println("Check box is toggled off");
		}
		// Toggle off the check box
		option1.click();
		// Check whether the check box is toggle off
		if (!option1.isSelected()) {
			System.out.println("Check box is toggled off");
		}
	}

	@Test(enabled = false)
	public void thirdTest() throws Exception {
		driver.get(baseUrl2);

		// Choose option with dynamic value
		String bookName = "Self help books";
		WebElement bookListElement = driver.findElement(By.id("booksCheckboxes"));
		List<WebElement> bookChildElements = bookListElement.findElements(By.name("books"));
		for (WebElement bookChildElement : bookChildElements) {
			if (bookChildElement.getAttribute("value").equals(bookName)) {
				bookChildElement.click();
				break;
			}
		}

		// Check option exists on radio button
		boolean isFailed = true;
		for (WebElement bookChildElement : bookChildElements) {
			if (bookChildElement.getAttribute("value").equals(bookName)) {
				isFailed = false;
				Assert.assertEquals(true, true);
			}
		}
		if (isFailed) {
			Reporter.log("There is no expected element: " + bookName + "in list");
			Assert.assertEquals(true, false);
		}
	}

	// PowerPoint 03_02
	@Test(enabled = false)
	public void fourthTest() throws Exception {
		driver.get(baseUrl2);

		Select programmingLanguageList = new Select(driver.findElement(By.id("programming-languages")));
		programmingLanguageList.selectByVisibleText("JavaScript");
		programmingLanguageList.selectByIndex(5);
	}

	// Word 03_03
	@Test
	public void fifthTest() throws Exception {
		driver.get(baseUrl2);

		WebElement bicycle = driver.findElement(By.name("vehicle1"));
		WebElement messageTextBox = driver.findElement(By.id("enterText"));
		WebElement click = driver.findElement(By.id("click"));

		Actions actions = new Actions(driver);

		// a
		actions
				.click(bicycle)
				.perform();

		// b
		actions
				.moveToElement(driver.findElement(By.id("labelText")))
				.doubleClick()
				.perform();

		// c
		actions
				.moveToElement(messageTextBox)
				.click()
				.keyDown(Keys.SHIFT)
				.sendKeys(messageTextBox, "hi there")
				.keyUp(Keys.SHIFT)
				.perform();

		// d
		actions
				.moveToElement(click)
				.perform();
		jse.executeScript("window.scrollBy(0,200)");
		actions
				.dragAndDropBy(click, 0, 90)
				.perform();
	}

	@AfterTest
	public void afterTest() throws Exception {
		driver.close();
	}
}
