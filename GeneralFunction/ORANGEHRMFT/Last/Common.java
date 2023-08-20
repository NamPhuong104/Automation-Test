package Last;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Common {
	WebDriver driver;
	WebDriverWait wait;

	public Common(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name = \"username\"]")
	WebElement userName;

	@FindBy(xpath = "//input[@name = 'password']")
	WebElement password;

	@FindBy(xpath = "//button[@type= 'submit']")
	WebElement login;


	// Login
	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameOrangeHRM;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordOrangeHRM;
	@FindBy(xpath = "//div[starts-with(@class, 'oxd-form-actions')]/child::button")
	WebElement loginBtn;

	public void setUserName(String userName) {
		usernameOrangeHRM.sendKeys(userName);
	}

	public void setPassword(String password) {
		passwordOrangeHRM.sendKeys(password);
	}

	public void clickLogin() {
		loginBtn.click();
	}

	public void loginToOrangeHRM(String userName, String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.setUserName(userName);
		this.setPassword(password);
		this.clickLogin();
	}


//	Dashboard
	@FindBy(xpath = "//div[@class = 'oxd-sidepanel-body']/ul/li")
	List<WebElement> chooseModule;

	@FindBy(xpath = "//li[@class='oxd-topbar-body-nav-tab']")
	List<WebElement> func;
	
	@FindBy(xpath = "//li[@class=\"oxd-topbar-body-nav-tab --parent\"]")
	List<WebElement> bfunc;

	@FindBy(xpath = "//ul[@class=\"oxd-dropdown-menu\"]//li")
	List<WebElement> sections;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	WebElement toastResult;

	public void chooseModuleOrangel(String nameM) {
		wait.until(ExpectedConditions.visibilityOfAllElements(chooseModule));
		for (WebElement element : chooseModule) {
			if(element.getText().equals(nameM)) {
				element.click();
				break;
			}
		}
	}

	public void chooseFunction(String name) {
		wait.until(ExpectedConditions.visibilityOfAllElements(func));
		for (WebElement element : func) {
			if(element.getText().equals(name)) {
				element.click();
				break;
			}
		}
	}
	
	public void selectbfunc(String names) {
		wait.until(ExpectedConditions.visibilityOfAllElements(bfunc));
		for (int i = 0; i < bfunc.size(); i++) {
			if (bfunc.get(i).getText().equals(names)) {
				bfunc.get(i).click();
				break;
			}
		}
	}
	
	public void selectSection(String names) {
		wait.until(ExpectedConditions.visibilityOfAllElements(sections));
		for (int i = 0; i < sections.size(); i++) {
			if (sections.get(i).getText().equals(names)) {
				sections.get(i).click();
				break;
			}
		}
	}
	
	public String getToastResult() {
		wait.until(ExpectedConditions.visibilityOf(toastResult));
		return toastResult.getText();
	}
	
	public void testCompleted(int rolNum, int colNum, boolean isPassed, String message) throws Exception {
		Excel.setCellData(rolNum, colNum, message);
		if (isPassed) {
			Excel.fillGreenColour(rolNum, colNum);
		} else {
			Excel.fillRedColour(rolNum, colNum);
		}
		Assert.assertTrue(isPassed);
	}

}
