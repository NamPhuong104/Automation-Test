package Week_04;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Week_04 {
	private WebDriver driver;
	private String baseUrl;
	private ChromeOptions options;

	@BeforeTest
	public void beforeTest() throws Exception {
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		baseUrl = "https://demo.guru99.com/test/guru99home/";
	}

	public void selectMenuItem(String item) {
		List<WebElement> MenuItems = driver
				.findElements(By.xpath("//li[starts-with(@class,'item')]/child::a[contains(text()," + item + ")]"));
		for (int i = 0; i < MenuItems.size(); i++) {
			if (MenuItems.get(i).getText().contentEquals(item)) {
				MenuItems.get(i).click();
				break;
			}
		}
	}

	@Test
	public void Test() throws Exception {
		driver.get(baseUrl);
		selectMenuItem("Testing");
		
	}
}
