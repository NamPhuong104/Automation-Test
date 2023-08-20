package pageFactory;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LeaveList {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;

	public LeaveList(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		jse = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
//	
	@FindBy(xpath = "//div[@class=\"oxd-form-row\"][1]/div[1]/div[1]/div/div[2]")
	WebElement listFromDate;
	@FindBy(xpath = "//div[@class=\"oxd-date-input-calendar\"]/div/div[3]/div")
	List<WebElement> clickFromDate;
//
	@FindBy(xpath = "//div[@class=\"oxd-table-filter\"]//div[@class=\"oxd-grid-4 orangehrm-full-width-grid\"]/div[2]/div[1]/div[2]/div[1]/div[1]/input")
	WebElement listToDate;
	@FindBy(xpath = "//div[@class=\"oxd-date-input-calendar\"]/div/div[3]/div")
	List<WebElement> clickToDate;
//
	@FindBy(xpath = "//div[@class=\"oxd-form-row\"][1]//div[3]//div[2]//div[1]//div[1]//div[1]")
	WebElement listShowLeaveWithStatus;
	@FindBy(xpath = "//div[@class=\"oxd-form-row\"][1]//div[3]//div[2]//div//div[@role=\"listbox\"]//div")
	List<WebElement> clickShowLeaveWithStatus;
//
	@FindBy(xpath = "//div[@class=\"oxd-form-row\"][1]//div[4]//div[2]//div[1]//div[1]//div[1]")
	WebElement listLeaveType;
	@FindBy(xpath = "//div[@class=\"oxd-form-row\"][1]//div[4]//div[2]//div[1]//div[@role=\"listbox\"]/div")
	List<WebElement> clickLeaveType;
//
	@FindBy(xpath = "//div[@class=\"oxd-form-row\"][2]//div[1]//div[1]//div[1]/div[2]//div[1]//div[1]/input")
	WebElement listEmployeeName;
	@FindBy(xpath = "//div[@role=\"listbox\"]/div")
	List<WebElement> clickEmployeeName;
//
	@FindBy(xpath = "//div[@class=\"oxd-form-row\"][2]//div[1]//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"][2]//div[1]//div[2]//div[1]//div[1]//div[1]")
	WebElement listSubUnit;
	@FindBy(xpath = "//div[@class=\"oxd-form-row\"][2]//div[1]//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"][2]//div[1]//div[2]//div[@role=\"listbox\"]//div")
	List<WebElement> clickSubUnit;
//
	@FindBy(xpath = "//div[@class=\"oxd-table-filter-area\"]//div[@class=\"oxd-form-actions\"]/button[1]")
	WebElement listResetBtn;
//
	@FindBy(xpath = "//div[@class=\"oxd-table-filter\"]//div[@class=\"oxd-table-filter-area\"]//div[@class=\"oxd-form-actions\"]//button[2]")
	WebElement listSearchBtn;
//
	//
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	WebElement toastResult ;
	
	public void clickFromDate() {
		listFromDate.click();
	}
	
	public void chooseFromDate(String value) {
		wait.until(ExpectedConditions.visibilityOfAllElements(clickFromDate));
		for(int i = 0; i< clickFromDate.size(); i++) {
			if(clickFromDate.get(i).getText().equals(value)) {
				clickFromDate.get(i).click();
				break;
			}
			
		}
	}
	
	public void clickToDate() {
		listToDate.click();
	}
	
	public void chooseToDate(String value) {
		wait.until(ExpectedConditions.visibilityOfAllElements(clickToDate));
		for(int i = 0; i< clickToDate.size(); i++) {
			if(clickToDate.get(i).getText().equals(value)) {
				clickToDate.get(i).click();
				break;
			}
			
		}
	}
	
	public void clickShow() {
		listShowLeaveWithStatus.click();
	}
	
	public void chooseShow(String value) {
		wait.until(ExpectedConditions.visibilityOfAllElements(clickShowLeaveWithStatus));
		for(int i = 0; i< clickShowLeaveWithStatus.size(); i++) {
			if(clickShowLeaveWithStatus.get(i).getText().equals(value)) {
				clickShowLeaveWithStatus.get(i).click();
				break;
			}
			
		}
	}
	
	public void clickType() {
		listLeaveType.click();
	}
	
	public void chooseType(String value) {
		wait.until(ExpectedConditions.visibilityOfAllElements(clickLeaveType));
		for(int i = 0; i< clickLeaveType.size(); i++) {
			if( clickLeaveType.get(i).getText().equals(value)) {
				clickLeaveType.get(i).click();
				break;
			}
			
		}
	}
	
	public void findEmployeeName(String employee) {
		listEmployeeName.sendKeys(employee);
	}
	
	public void chooseEmployeeName(String value) {
		wait.until(ExpectedConditions.visibilityOfAllElements(clickEmployeeName));
		for(int i = 0; i< clickEmployeeName.size(); i++) {
			if(clickEmployeeName.get(i).getText().equals(value)) {
				clickEmployeeName.get(i).click();
				break;
			}
			
		}
	}
	
	public void clickUnit() {
		listSubUnit.click();
	}
	
	public void chooseUnit(String value) {
		wait.until(ExpectedConditions.visibilityOfAllElements(clickSubUnit));
		for(int i = 0; i< clickSubUnit.size(); i++) {
			if( clickSubUnit.get(i).getText().equals(value)) {
				clickSubUnit.get(i).click();
				break;
			}
			
		}
	}
	
	public void clickResertBtn() {
		wait.until(ExpectedConditions.visibilityOf(listResetBtn));
		listResetBtn.click();
	}
	
	public void clickSearchBtn() {
		wait.until(ExpectedConditions.visibilityOf(listSearchBtn));
		listSearchBtn.click();
	}
	
	public void checkResult(String value){
		wait.until(ExpectedConditions.visibilityOf(toastResult));
		String actualResult  = toastResult.getText();
		Assert.assertEquals(actualResult, value);
	}
	
}
