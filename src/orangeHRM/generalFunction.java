package orangeHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class generalFunction {
	private ChromeOptions options;
	public static WebDriver driver;
	public static WebDriverWait wait;
	private String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeTest
	public void beforeTest() throws Exception {
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get(baseUrl);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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
		for (WebElement module : modules) {
			if (module.getText().equals(nameM)) {
				module.click();
				break;
			}
		}
	}

	public static void selectFunc(String funcName) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		List<WebElement> chooseFunc = driver.findElements(By.xpath("//*[@class= \"oxd-topbar-body-nav-tab-item\"]"));
		for (WebElement element : chooseFunc) {
			if (element.getText().equals(funcName)) {
				element.click();
				break;
			}
		}
	}

	public static void findEmployeeName(String nameEmployee) throws Exception {
		WebElement click = driver.findElement(By.xpath("//input[@placeholder = \"Type for hints...\"]"));
		click.click();
		click.sendKeys(nameEmployee);

		WebElement chooseEmployee = driver.findElement(By.xpath("//div[@class = \"oxd-autocomplete-dropdown --positon-bottom\"]//span[text() = '" + nameEmployee + "']"));

		wait.until(ExpectedConditions.visibilityOf(chooseEmployee));
		chooseEmployee.click();

	}

	public static void selectLeaveType(String type) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement click = driver.findElement(By.xpath("//div[@class= \"oxd-select-text oxd-select-text--active\"]"));
		click.click();

		wait.until(ExpectedConditions.visibilityOf(click));
		List<WebElement> chooseType = driver.findElements(By.xpath("//div[@class= \"oxd-select-option\"]"));
		for (WebElement element : chooseType) {
			if (element.getText().equals(type)) {
				element.click();
				break;
			}
		}
	}

	public static void selectFromDate(String day) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement click = driver
				.findElement(By.xpath("//div[@class = \"oxd-grid-4 orangehrm-full-width-grid\"]/div[1]//input"));
		click.click();

//		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		List<WebElement> fromDate = driver.findElements(By.xpath("//div[@class= \"oxd-calendar-date\"]"));
		for (WebElement element : fromDate) {
			if (element.getText().equals(day)) {
				element.click();
				break;
			}
		}
	}

	public static void selectToDate(String day) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement click = driver
				.findElement(By.xpath("//div[@class = \"oxd-grid-4 orangehrm-full-width-grid\"]/div[2]//input"));
		click.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		List<WebElement> fromDate = driver.findElements(By.xpath("//div[@class= \"oxd-calendar-date\"]"));
		for (WebElement element : fromDate) {
			if (element.getText().equals(day)) {
				element.click();
				break;
			}
		}
	}


	public static void partialDay(String value) throws Exception{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement click = driver.findElement(By.xpath("//form[@class = \"oxd-form\"]/div[4]//div[@class = \"oxd-grid-item oxd-grid-item--gutters\"][1]//div[@class =\"oxd-select-text oxd-select-text--active\"]"));
		click.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		Thread.sleep(2000);
		List<WebElement> partialDay = driver.findElements(By.xpath("//div[@class = \"oxd-select-option\"]"));
		for (WebElement element : partialDay) {
			if(element.getText().equals(value)) {
				element.click();
				break;
			}
		}
	}

	public static void duration(String value) throws Exception{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement click = driver.findElement(By.xpath("//form[@class = \"oxd-form\"]/div[4]//div[@class = \"oxd-grid-item oxd-grid-item--gutters\"][2]//div[@class =\"oxd-select-text oxd-select-text--active\"]"));
		click.click();

//		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> duration = driver.findElements(By.xpath("//div[@class = \"oxd-select-option\"]"));
		for (WebElement element : duration) {
			if(element.getText().equals(value)) {
				element.click();
				break;
			}
		}
	}

	public static void chooseSpcifyStartFromTime(String hourse, String minute, String amOrPm) throws Exception{
		WebElement click = driver.findElement(By.xpath("//div[@class = \"oxd-form-row\"][4]/div/div[3]/div/div[2]"));
		click.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		Thread.sleep(500);
		WebElement chooseHouse = driver.findElement(By.xpath("//input[@class = \"oxd-input oxd-input--active oxd-time-hour-input-text\"]"));
		chooseHouse.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		chooseHouse.sendKeys(hourse);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		Thread.sleep(500);
		WebElement chooseMinute = driver.findElement(By.xpath("//input[@class = \"oxd-input oxd-input--active oxd-time-minute-input-text\"]"));
		chooseMinute.click();
		chooseMinute.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		chooseMinute.sendKeys(minute);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		Thread.sleep(500);
		List<WebElement> chooseAmPm = driver.findElements(By.xpath("//div[@class = \"oxd-time-period-label\"]"));
		for (WebElement element : chooseAmPm) {
			if(element.getText().equals(amOrPm)) {
				element.click();
			}
		}
	}

	public static void chooseSpcifyStartToTime(String hourse, String minute, String amOrPm) throws Exception{
		WebElement click = driver.findElement(By.xpath("//div[@class = \"oxd-form-row\"][4]/div/div[4]/div/div[2]"));
		click.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		Thread.sleep(500);
		WebElement chooseHouse = driver.findElement(By.xpath("//input[@class = \"oxd-input oxd-input--active oxd-time-hour-input-text\"]"));
		chooseHouse.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		chooseHouse.sendKeys(hourse);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		Thread.sleep(500);
		WebElement chooseMinute = driver.findElement(By.xpath("//input[@class = \"oxd-input oxd-input--active oxd-time-minute-input-text\"]"));
		chooseMinute.click();
		chooseMinute.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		chooseMinute.sendKeys(minute);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		Thread.sleep(500);
		List<WebElement> chooseAmPm = driver.findElements(By.xpath("//div[@class = \"oxd-time-period-label\"]"));
		for (WebElement element : chooseAmPm) {
			if(element.getText().equals(amOrPm)) {
				element.click();
			}
		}
	}

	public static void chooseSpcifyEndFromTime(String hourse, String minute, String amOrPm) throws Exception{
		WebElement click = driver.findElement(By.xpath("//div[@class = \"oxd-form-row\"][4]/div/div[7]/div/div[2]"));
		click.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		Thread.sleep(500);
		WebElement chooseHouse = driver.findElement(By.xpath("//input[@class = \"oxd-input oxd-input--active oxd-time-hour-input-text\"]"));
		chooseHouse.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		chooseHouse.sendKeys(hourse);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		Thread.sleep(500);
		WebElement chooseMinute = driver.findElement(By.xpath("//input[@class = \"oxd-input oxd-input--active oxd-time-minute-input-text\"]"));
		chooseMinute.click();
		chooseMinute.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		chooseMinute.sendKeys(minute);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		Thread.sleep(500);
		List<WebElement> chooseAmPm = driver.findElements(By.xpath("//div[@class = \"oxd-time-period-label\"]"));
		for (WebElement element : chooseAmPm) {
			if(element.getText().equals(amOrPm)) {
				element.click();
			}
		}
	}

	public static void chooseSpcifyEndToTime(String hourse, String minute, String amOrPm) throws Exception{
		WebElement click = driver.findElement(By.xpath("//div[@class = \"oxd-form-row\"][4]/div/div[8]/div/div[2]"));
		click.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		Thread.sleep(500);
		WebElement chooseHouse = driver.findElement(By.xpath("//input[@class = \"oxd-input oxd-input--active oxd-time-hour-input-text\"]"));
		chooseHouse.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		chooseHouse.sendKeys(hourse);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		Thread.sleep(500);
		WebElement chooseMinute = driver.findElement(By.xpath("//input[@class = \"oxd-input oxd-input--active oxd-time-minute-input-text\"]"));
		chooseMinute.click();
		chooseMinute.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		chooseMinute.sendKeys(minute);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		Thread.sleep(500);
		List<WebElement> chooseAmPm = driver.findElements(By.xpath("//div[@class = \"oxd-time-period-label\"]"));
		for (WebElement element : chooseAmPm) {
			if(element.getText().equals(amOrPm)) {
				element.click();
			}
		}
	}

	public static void chooseStartDay(String value) throws Exception{
		WebElement click = driver.findElement(By.xpath("//div[@class = \"oxd-form-row\"][4]/div/div[2]//div[@class = \"oxd-select-wrapper\"]"));
		click.click();

		List<WebElement> chooseSpecifyEndDay = driver.findElements(By.xpath("//div[@role = \"option\"]"));
		for (WebElement element : chooseSpecifyEndDay) {
			if(element.getText().equals(value)) {
				element.click();
			}
		}
	}

	public static void chooseEndDay(String value) throws Exception{
		WebElement click = driver.findElement(By.xpath("//div[@class = \"oxd-form-row\"][4]/div/div[6]//div[@class = \"oxd-select-wrapper\"]"));
		click.click();

		List<WebElement> chooseSpecifyEndDay = driver.findElements(By.xpath("//div[@role = \"option\"]"));
		for (WebElement element : chooseSpecifyEndDay) {
			if(element.getText().equals(value)) {
				element.click();
			}
		}
	}


	public static void comments(String value) throws Exception {
		WebElement click = driver
				.findElement(By.xpath("//textarea[@class= \"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]"));
		click.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement comments = driver.findElement(
				By.xpath("//textarea[@class = \"oxd-textarea oxd-textarea--focus oxd-textarea--resize-vertical\"]"));
		comments.sendKeys(value);
	}

	public static void submit() throws Exception {
		WebElement submit = driver.findElement(By.xpath("//button[@type= \"submit\"]"));
		submit.click();

//		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement okButton = driver.findElement(By.xpath(
				"//button[@class= \"oxd-button oxd-button--medium oxd-button--secondary orangehrm-button-margin\"]"));
		okButton.click();
	}

	public static void reject(String nameEmp) throws Exception {
		List<WebElement> reject = driver.findElements(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell'][3]"));
//		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		for(int i = 0; i < reject.size(); i++) {
			if(reject.get(i).getText().equals(nameEmp)) {
				List<WebElement> click = driver.findElements(By.xpath("//div[@class = \"oxd-table-cell-actions\"]/button[text() = \" Reject \"]"));
				click.get(i).click();
			}
		}
	}

	public static void checkResult(String value) throws Exception{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		Thread.sleep(1000);
		WebElement toastResult = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']"));
		String actualResult  = toastResult.getText();
		Assert.assertEquals(actualResult, value);
	}

	@AfterMethod
	public void afterTest() throws Exception {
		driver.close();
	}
}
