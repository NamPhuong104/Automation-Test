package pageFactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

public class OrangelHRMAssignLeave {
	WebDriver driver;
	WebDriverWait wait;
	public OrangelHRMAssignLeave(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

//	One Value
	@FindBy(xpath = "//div[@class= \"oxd-select-text oxd-select-text--active\"]")
	WebElement clickLt;
	
	@FindBy(xpath = "//div[@class = \"oxd-grid-4 orangehrm-full-width-grid\"]/div[1]//input")
	WebElement clickFd;
	
	@FindBy(xpath = "//div[@class = \"oxd-grid-4 orangehrm-full-width-grid\"]/div[2]//input")
	WebElement clickTd;
	
	@FindBy(xpath = "//form[@class = \"oxd-form\"]/div[4]//div[@class = \"oxd-grid-item oxd-grid-item--gutters\"][1]//div[@class =\"oxd-select-text oxd-select-text--active\"]")
	WebElement clickPd;
	
	@FindBy(xpath = "//form[@class = \"oxd-form\"]/div[4]//div[@class = \"oxd-grid-item oxd-grid-item--gutters\"][2]//div[@class =\"oxd-select-text oxd-select-text--active\"]")
	WebElement clickDuration;
	
	@FindBy(xpath = "//div[@class = \"oxd-form-row\"][4]/div/div[2]/div/div[2]")
	WebElement clickDurationSpecifyTimeFrom;
	
	@FindBy(xpath = "//div[@class = \"oxd-form-row\"][4]/div/div[2]//div[@class = \"oxd-select-wrapper\"]")
	WebElement clickStartDay;
	
	@FindBy(xpath = "//div[@class = \"oxd-form-row\"][4]/div/div[3]/div/div[2]")
	WebElement clickStartDayFrom;
	
	@FindBy(xpath = "//div[@class = \"oxd-form-row\"][4]/div/div[4]/div/div[2]")
	WebElement clickStartDayTo;
	
	@FindBy(xpath = "//input[@class = \"oxd-input oxd-input--active oxd-time-hour-input-text\"]")
	WebElement clickHour;
	
	@FindBy(xpath = "//input[@class = \"oxd-input oxd-input--active oxd-time-minute-input-text\"]")
	WebElement clickMinute;
	
	
	@FindBy(xpath = "//div[@class = \"oxd-form-row\"][4]/div/div[6]//div[@class = \"oxd-select-wrapper\"]")
	WebElement clickEndDay;
	
	@FindBy(xpath = "//div[@class = \"oxd-form-row\"][4]/div/div[7]/div/div[2]")
	WebElement clickEndDayFrom;
	
	@FindBy(xpath = "//div[@class = \"oxd-form-row\"][4]/div/div[8]/div/div[2]")
	WebElement clickEndDayTo;

	
	@FindBy(xpath = "//input[@class = \"oxd-input oxd-input--focus oxd-time-hour-input-text\"]")
	WebElement clearHour;
	
	@FindBy(xpath = "//input[@class = \"oxd-input oxd-input--focus oxd-time-minute-input-text\"]")
	WebElement clearMinute;
	
	
	@FindBy(xpath = "//textarea[@class= \"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]")
	WebElement clickComment;
	
	@FindBy(xpath = "//textarea[@class= \"oxd-textarea oxd-textarea--focus oxd-textarea--resize-vertical\"]")
	WebElement inputComment;
	
	
	@FindBy(xpath = "//button[@type= \"submit\"]")
	WebElement clickAssign;
	
	@FindBy(xpath = "//button[@class= \"oxd-button oxd-button--medium oxd-button--secondary orangehrm-button-margin\"]")
	WebElement clickOk;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	WebElement checkResult;
	
//	List Value
	@FindBy(xpath = "//div[@class= \"oxd-select-option\"]")
	List<WebElement> leaveType;
	
	@FindBy(xpath = "//div[@class= \"oxd-calendar-date\"]")
	List<WebElement> chooseCommonDate;
	
	@FindBy(xpath = "//div[@role = \"option\"]")
	List<WebElement> chooseCommonFunc;
	
	@FindBy(xpath = "//div[@class = \"oxd-time-period-label\"]")
	List<WebElement> chooseAMPM;
	

//	COMMON FUNCTION
	public void setNameEmployee(String name) {
		WebElement click = driver.findElement(By.xpath("//input[@placeholder = \"Type for hints...\"]"));
		wait.until(ExpectedConditions.visibilityOf(click));
		click.click();
		click.sendKeys(name);
	}

	public void chooseUser(String nameEmp) {
		WebElement chooseEmployee = driver.findElement(By.xpath("//div[@class = \"oxd-autocomplete-dropdown --positon-bottom\"]//span[text() = '" + nameEmp + "']"));
		wait.until(ExpectedConditions.visibilityOf(chooseEmployee));
		chooseEmployee.click();
	}
//// Choose value of From Date and To Date	
	public void chooseCommonDate(String day) {
		wait.until(ExpectedConditions.visibilityOfAllElements(chooseCommonDate));
		for(int i = 0; i < chooseCommonDate.size(); i++) {
			if(chooseCommonDate.get(i).getText().equals(day)) {
				chooseCommonDate.get(i).click();
				break;
			}
		}
	}

//// 
	public void chooseCommonFunc(String value) {
		wait.until(ExpectedConditions.visibilityOfAllElements(chooseCommonFunc));
		for(int i = 0; i< chooseCommonFunc.size(); i++) {
			if(chooseCommonFunc.get(i).getText().equals(value)) {
				chooseCommonFunc.get(i).click();
				break;
			}
		}
	}
//	Find and choose user
	public void inputUser(String value) {
		setNameEmployee(value);
		chooseUser(value);
	}
	
//	Click Leave Type
	public void clickLeaveType() {
		clickLt.click();
	}

//	Choose Leave Type
	public void chooseLT(String type) {
		wait.until(ExpectedConditions.visibilityOfAllElements(leaveType));
		for(int i = 0; i < leaveType.size(); i++) {
			if(leaveType.get(i).getText().equals(type)) {
				leaveType.get(i).click();
				break;
			}
		}
	}
	
	public void chooseLeaveType(String type) {
		clickLeaveType();
		chooseLT(type);
	}
	
	
//	Click From Date
	public void clickFd() {
		clickFd.click();
	}
	
	public void chooseFromDate(String value) {
		clickFd();
		chooseCommonDate(value);
	}
	
//	Click To Date
	public void clickTd() {
		clickTd.click();
	}
	
	public void chooseToDate(String value) {
		clickTd();
		chooseCommonDate(value);
	}
	
//	Click Partial Days
	public void clickPd() {
		clickPd.click();
	}
	
	public void choosePartialDays(String value) {
		clickPd();
		chooseCommonFunc(value);
	}
	
// 	Click Duration
	public void clickD() {
		clickDuration.click();
	}
	
	public void chooseDuration(String value) {
		clickD();
		chooseCommonFunc(value);
	}
	
	public void setDurationSpecifyTime(String hour, String minute, String session) {
		clickDurationSpecifyTimeFrom.click();
		inputHour(hour);
		inputMinute(minute);
		chooseAMPM(session);
	}
	
//	Click Start Day
	public void clickStartDay() {
		clickStartDay.click();
	}
	
	
//	Click End Day
	public void clickEndDay() {
		clickEndDay.click();
	}
	
//	Click Start Day From
	public void clickStartDayFrom() {
		clickStartDayFrom.click();
	}
	
	public void chooseStartDay(String value) {
		clickStartDay();
		chooseCommonFunc(value);
	}
//	Click Start Day To
	public void clickStartDayTo() {
		clickStartDayTo.click();
	}
	
//	Click End Day
	public void clickEndDayFrom() {
		clickEndDayFrom.click();
	}
	
	public void chooseEndDay(String value) {
		clickEndDay();
		chooseCommonFunc(value);
	}
	
	public void clickEndDayTo() {
		clickEndDayTo.click();
	}
//	Input House
	public void inputHour(String value) {
		wait.until(ExpectedConditions.visibilityOf(clickStartDayFrom));
		clickHour.click();
		clearHour.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		clearHour.sendKeys(value);
	}
//	Input Minute
	public void inputMinute(String value) {
		wait.until(ExpectedConditions.visibilityOf(clickStartDayTo));
		clickMinute.click();
		clearMinute.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		clearMinute.sendKeys(value);
	}
	
//	Choose AM or PM
	public void chooseAMPM(String value) {
		for(int i = 0; i < chooseAMPM.size(); i++) {
			if(chooseAMPM.get(i).getText().equals(value)) {
				chooseAMPM.get(i).click();
			}
		}
	}
	
	public void setTimeStartDayFrom(String hour, String minute, String session) {
		clickStartDayFrom();
		inputHour(hour);
		inputMinute(minute);
		chooseAMPM(session);
	}
	
	public void setTimeStartTo(String hour, String minute, String session) {
		clickStartDayTo();
		inputHour(hour);
		inputMinute(minute);
		chooseAMPM(session);
	}
	
	public void setTimeEndDayFrom(String hour, String minute, String session) {
		clickEndDayFrom();
		inputHour(hour);
		inputMinute(minute);
		chooseAMPM(session);
	}
	
	public void setTimeEndTo(String hour, String minute, String session) {
		clickEndDayTo();
		inputHour(hour);
		inputMinute(minute);
		chooseAMPM(session);
	}
	
	
//	Click comment and send key
	public void clickComment() {
		clickComment.click();
	}
	
	public void inputComment(String value) {
		inputComment.sendKeys(value);
	}
	
	public void setComment(String value) {
		clickComment();
		inputComment(value);
	}
	
//	click Assign and submit
	public void clickAssign() {
		clickAssign.click();
	}
	
	public void clickOk() {
		clickOk.click();
	}
	
	public void submit() {
		clickAssign();
		clickOk();
	}
	
//	Check Result
//	public void checkResult(String value) {
//		wait.until(ExpectedConditions.visibilityOf(checkResult));
//		String actualResult = checkResult.getText();
//		Assert.assertEquals(actualResult, value);
//	}
}
