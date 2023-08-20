package pageFactory;

import java.time.Duration;
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


public class Holidays {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;

	public Holidays(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		jse = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
//	
	@FindBy(xpath = "//div[@class=\"oxd-table-filter\"]/div[2]//div[1]//div[1]//div[1]//div[1]/div[2]//div[1]//div[1]/input")
	WebElement holidaysFrom;
	@FindBy(xpath = "//div[@class=\"oxd-table-filter\"]/div[2]//div[1]//div[1]//div[1]//div[1]/div[2]//div[1]//div[2]/div[1]/div[3]/div")
	List<WebElement> clickFrom;
//
	@FindBy(xpath = "//div[@class=\"oxd-table-filter\"]/div[2]//div[1]//div//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"][2]//div[1]//div[2]//div[1]//div//input")
	WebElement holidaysTo;
	@FindBy(xpath = "//div[@class=\"oxd-table-filter\"]/div[2]//div[1]//div//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"][2]//div[1]//div[2]//div[2]//div[1]/div[3]/div")
	List<WebElement> clickTo;
//
	@FindBy(xpath = "//div[@class=\"oxd-table-filter\"]/div[2]//div[@class=\"oxd-form-actions\"]//button[1]")
	WebElement holidaysResetBtn;
//
	@FindBy(xpath = "//div[@class=\"oxd-table-filter\"]/div[2]//div[@class=\"oxd-form-actions\"]//button[2]")
	WebElement holidaysSearchBtn;
//
	@FindBy(xpath = "//div[@class=\"orangehrm-paper-container\"][1]//div[@class=\"orangehrm-header-container\"]//button")
	WebElement clickAddBtn;
//
	@FindBy(xpath = "//div[@class=\"oxd-layout-context\"]//div[1]//div[1]/div//div[1]//div[1]/div[2]/input")
	WebElement addholidaysName;
//
	@FindBy(xpath = "//div[@class=\"oxd-layout-context\"]//div[1]//div[1]//div[1]//div[1]//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"][2]//div[1]//div[2]//div[1]//div")
	WebElement addholidaysDate;
	@FindBy(xpath = "//div[@class=\"oxd-layout-context\"]//div[1]//div[1]//div[1]//div[1]//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"][2]//div[1]//div[2]//div[2]//div[1]/div[3]/div")
	List<WebElement> clickDate;
//
	@FindBy(xpath = "//div[@class=\"oxd-form-row\"]//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"][3]//div[1]/div[2]//div[1]//div[1]//div[1]")
	WebElement addholidaysFullDayHalfDay;
	@FindBy(xpath = "//div[@role=\"listbox\"]/div")
	List<WebElement> clickFullDayHalfDay;
//
	@FindBy(xpath = "//div[@class=\"orangehrm-background-container\"]/div//div[@class=\"oxd-form-actions\"]//button[1]")
	WebElement addholidaysCancelBtn;
//
	@FindBy(xpath = "//div[@class=\"orangehrm-background-container\"]/div//div[@class=\"oxd-form-actions\"]//button[2]")
	WebElement addholidaysSaveBtn;
//
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	WebElement toastResult ;
	
	
	public void clickAddBtn() {
		wait.until(ExpectedConditions.visibilityOf(clickAddBtn));
		clickAddBtn.click();
	}
	
	public void addDateName(String DateName) {
		addholidaysName.sendKeys(DateName);
	}
	public void clickDate() {
		addholidaysDate.click();
	}
	
	public void chooseDate(String value) {
		wait.until(ExpectedConditions.visibilityOfAllElements(clickDate));
		for(int i = 0; i< clickDate.size(); i++) {
			if(clickDate.get(i).getText().equals(value)) {
				clickDate.get(i).click();
				break;
			}
			
		}
	}
	
	public void clickFullDayHalfDay() {
		addholidaysFullDayHalfDay.click();
	}
	
	public void chooseFullDayHalfDay(String value) {
		wait.until(ExpectedConditions.visibilityOfAllElements(clickFullDayHalfDay));
		for(int i = 0; i< clickFullDayHalfDay.size(); i++) {
			if(clickFullDayHalfDay.get(i).getText().equals(value)) {
				clickFullDayHalfDay.get(i).click();
				break;
			}
			
		}
	}
	
	public void clickSaveBtn() {
		wait.until(ExpectedConditions.visibilityOf(addholidaysSaveBtn));
		addholidaysSaveBtn.click();
	}
	
	public void checkResult(String value){
		wait.until(ExpectedConditions.visibilityOf(toastResult));
		String actualResult  = toastResult.getText();
		Assert.assertEquals(actualResult, value);
	}
}
