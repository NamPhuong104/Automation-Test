package pageFactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserManagement {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;

	public UserManagement(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		jse = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

//
	@FindBy(xpath = "//div[@class=\"orangehrm-background-container\"]/div[2]/div[1]/button")
	WebElement usermanagementAddBtn;
//
	@FindBy(xpath = "//div[@class=\"orangehrm-card-container\"]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]")
	WebElement addusermanagementUserRole;
	@FindBy(xpath = "//div[@role=\"listbox\"]/div")
	List<WebElement> clickaddusermanagementUserRole;
//
	@FindBy(xpath = "//div[@class=\"orangehrm-background-container\"]//div[1]//div[1]//div[1]/div[@class=\"oxd-grid-item oxd-grid-item--gutters\"][2]//div[1]//div[2]//div[1]//div[1]/input")
	WebElement addusermanagementEmployeeName;
	@FindBy(xpath = "//div[@role=\"listbox\"]/div")
	List<WebElement> addclickusermanagementEmployeeName;
//
	@FindBy(xpath = "//div[@class=\"orangehrm-card-container\"]//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]")
	WebElement addusermanagementStatus;
	@FindBy(xpath = "//div[@role=\"listbox\"]/div")
	List<WebElement> addclickusermanagemetStatus;
//
	@FindBy(xpath = "//div[@class=\"orangehrm-card-container\"]//div[4]//div[1]//div[2]//input")
	WebElement addusermanagementUserName;
//
	@FindBy(xpath = "//div[@class=\"orangehrm-card-container\"]//div[@class=\"oxd-form-row user-password-row\"]//div[1]//div[1]//div[1]//div[2]//input")
	WebElement addusermanagementPassword;
//
	@FindBy(xpath = "//div[@class=\"orangehrm-card-container\"]//div[@class=\"oxd-form-row user-password-row\"]//div[1]//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"]//div[1]//div[2]//input")
	WebElement addusermanagementConfirmPassword;
//
	@FindBy(xpath = "//div[@class=\"orangehrm-card-container\"]//div[@class=\"oxd-form-actions\"]/button[1]")
	WebElement addusermanagementCancelBtn;
//
	@FindBy(xpath = "//div[@class=\"orangehrm-card-container\"]//div[@class=\"oxd-form-actions\"]/button[2]")
	WebElement addusermanagementSaveBtn;
	
	
	public void clickUserRole() {
		addusermanagementUserRole.click();
	}
	
	public void findEmployeeName(String employee) {
		addusermanagementEmployeeName.sendKeys(employee);
	}
	
	public void chooseEmployeeName(String value) {
		wait.until(ExpectedConditions.visibilityOfAllElements(addclickusermanagementEmployeeName));
		for(int i = 0; i< addclickusermanagementEmployeeName.size(); i++) {
			if(addclickusermanagementEmployeeName.get(i).getText().equals(value)) {
				addclickusermanagementEmployeeName.get(i).click();
				break;
			}
			
		}
	}
	
	public void clickStatus() {
		addusermanagementStatus.click();
	}
	
	public void chooseStatus(String value) {
		wait.until(ExpectedConditions.visibilityOfAllElements(addclickusermanagemetStatus));
		for(int i = 0; i< addclickusermanagemetStatus.size(); i++) {
			if(addclickusermanagemetStatus.get(i).getText().equals(value)) {
				addclickusermanagemetStatus.get(i).click();
				break;
			}
			
		}
	}
	
	public void addUserName(String userName) {
		addusermanagementUserName.sendKeys(userName);
	}
	
	public void addPassword(String password) {
		addusermanagementPassword.sendKeys(password);
	}
	
	public void addConfirmPassword(String Cpassword) {
		addusermanagementConfirmPassword.sendKeys(Cpassword);
	}
	
	
	public void chooseUserRole1(String value) {
		wait.until(ExpectedConditions.visibilityOfAllElements(clickaddusermanagementUserRole));
		for(int i = 0; i< clickaddusermanagementUserRole.size(); i++) {
			if(clickaddusermanagementUserRole.get(i).getText().equals(value)) {
				clickaddusermanagementUserRole.get(i).click();
				break;
			}
			
		}
		
	}
	
	
	public void clickAddBtn() {
		wait.until(ExpectedConditions.visibilityOf(usermanagementAddBtn));
		usermanagementAddBtn.click();
	}
	
	public void clickCancelBtn() {
		wait.until(ExpectedConditions.visibilityOf(addusermanagementCancelBtn));
		addusermanagementCancelBtn.click();
	}
	
	public void clickSaveBtn() {
		wait.until(ExpectedConditions.visibilityOf(addusermanagementSaveBtn));
		addusermanagementSaveBtn.click();
	}


}
