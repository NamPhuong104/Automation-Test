package orangeHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class generalFunction {
	private ChromeOptions options;
	public static WebDriver driver;
	private String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeTest
	public void beforeTest() throws Exception {

		options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get(baseUrl);
	}

	public static void login(String userN, String passW) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement username = driver.findElement(By.xpath("//input[@name = \"username\"]"));
		username.sendKeys(userN);
		WebElement password = driver.findElement(By.xpath("//input[@name = \"password\"]"));
		password.sendKeys(passW);

		driver.findElement(By.xpath("//button[@type= \"submit\"]")).click();
	}

	public static void selectModule(String nameM) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		List<WebElement> modules = driver.findElements(By.xpath("//li[@class= \"oxd-main-menu-item-wrapper\"]"));
		for (int i = 0; i < modules.size(); i++) {
			if (modules.get(i).getText().equals(nameM)) {
				modules.get(i).click();
				break;
			}
		}
	}

	public static void selectFunc(String funcName) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		List<WebElement> chooseFunc = driver.findElements(By.xpath("//*[@class= \"oxd-topbar-body-nav-tab-item\"]"));
		for (int i = 0; i < chooseFunc.size(); i++) {
			if (chooseFunc.get(i).getText().equals(funcName)) {
				chooseFunc.get(i).click();
				break;
			}
		}
	}

	public static void findEmployeeName(String keyFind, String nameEmployee) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement click = driver.findElement(By.xpath("//input[@placeholder = \"Type for hints...\"]"));
		click.click();
		click.sendKeys(keyFind);

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Thread.sleep(3000);
		List<WebElement> chooseEmployee = driver.findElements(By.xpath("//div[@class= \"oxd-autocomplete-option\"]"));
		for (int i = 0; i < chooseEmployee.size(); i++) {
			if (chooseEmployee.get(i).getText().equals(nameEmployee)) {
				chooseEmployee.get(i).click();
				break;
			}
		}
	}

	public static void selectLeaveType(String type) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement click = driver.findElement(By.xpath("//div[@class= \"oxd-select-text oxd-select-text--active\"]"));
		click.click();

		List<WebElement> chooseType = driver.findElements(By.xpath("//div[@class= \"oxd-select-option\"]"));
		for (int i = 0; i < chooseType.size(); i++) {
			if (chooseType.get(i).getText().equals(type)) {
				chooseType.get(i).click();
				break;
			}
		}
	}

	public static void selectFromDate(String day) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement click = driver
				.findElement(By.xpath("//div[@class = \"oxd-grid-4 orangehrm-full-width-grid\"]/div[1]//input"));
		click.click();
		
		Thread.sleep(3000);
		List<WebElement> fromDate = driver.findElements(By.xpath("//div[@class= \"oxd-calendar-date\"]"));
		for (int i = 0; i < fromDate.size(); i++) {
			if (fromDate.get(i).getText().equals(day)) {
				fromDate.get(i).click();
				break;
			}
		}
	}

	public static void selectToDate(String day) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement click = driver
				.findElement(By.xpath("//div[@class = \"oxd-grid-4 orangehrm-full-width-grid\"]/div[2]//input"));
		click.click();

		Thread.sleep(3000);
		List<WebElement> fromDate = driver.findElements(By.xpath("//div[@class= \"oxd-calendar-date\"]"));
		for (int i = 0; i < fromDate.size(); i++) {
			if (fromDate.get(i).getText().equals(day)) {
				fromDate.get(i).click();
				break;
			}
		}
	}

	public static void comments(String value) throws Exception {
		WebElement click = driver
				.findElement(By.xpath("//textarea[@class= \"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]"));
		click.click();
		
		Thread.sleep(3000);
		WebElement comments = driver.findElement(
				By.xpath("//textarea[@class = \"oxd-textarea oxd-textarea--focus oxd-textarea--resize-vertical\"]"));
		comments.sendKeys(value);
	}

	public static void submit() throws Exception {
		WebElement submit = driver.findElement(By.xpath("//button[@type= \"submit\"]"));
		submit.click();

		WebElement okButton = driver.findElement(By.xpath(
				"//button[@class= \"oxd-button oxd-button--medium oxd-button--secondary orangehrm-button-margin\"]"));
		okButton.click();
	}

	@Test
	public void assignL() throws Exception  {
		login("admin", "admin123");
		selectModule("Leave");
		selectFunc("Assign Leave");
		findEmployeeName("a", "Odis Adalwin");
		selectLeaveType("CAN - Personal");
		selectFromDate("25");
		comments("Automation Test");
		submit();

	}

	@AfterMethod
	public void afterTest() throws Exception {
		driver.close();
	}
}
