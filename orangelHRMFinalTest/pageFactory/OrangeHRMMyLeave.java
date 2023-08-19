package pageFactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMMyLeave {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;

	public OrangeHRMMyLeave(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		jse = (JavascriptExecutor) driver;
	}

//	One Value	
	@FindBy(xpath = "//textarea[@class= \"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]")
	WebElement clickComment;

	@FindBy(xpath = "//div[@class = \"oxd-input-group oxd-input-field-bottom-space\"]//textarea")
	WebElement inputComment;

	@FindBy(xpath = "//button[@type= \"submit\"]")
	WebElement clickSave;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	WebElement checkResult;

	@FindBy(xpath = "//div[@role=\"document\"]//div[@class=\"oxd-form-actions\"]/button[@type=\"button\"]")
	WebElement clickCancelOutSide;

	@FindBy(xpath = "//div[@role=\"document\"]//div[@class=\"oxd-form-actions\"]/button[@type=\"submit\"]")
	WebElement clickSaveOutSide;

	@FindBy(xpath = "//div[@class= \"orangehrm-paper-container\"]")
	WebElement waitTable;

//	List Value
	@FindBy(xpath = "//div[@class = \"orangehrm-bottom-container\"]//button[@type= \"button\"]")
	List<WebElement> chooseBackOrComment;

	@FindBy(xpath = "//div[@class = \"oxd-table-cell oxd-padding-cell\"][2]")
	List<WebElement> getDate;

	@FindBy(xpath = "//div[@class = \"oxd-table-cell oxd-padding-cell\"][9]//button[@class = \"oxd-icon-button\"]")
	List<WebElement> clickBtnView;

	@FindBy(xpath = "//div[@role= \"dialog\"]//form[@class = \"oxd-form\"]//button")
	List<WebElement> chooseCancelOrSave;

	public void scrollPageUpDown(int height) {
		wait.until(ExpectedConditions.visibilityOf(waitTable));
		jse.executeScript("window.scrollBy(0," + height + ")");
	}

//	choose Back or Comment
	public void chooseBackOrComment(String value) {
		wait.until(ExpectedConditions.visibilityOfAllElements(chooseBackOrComment));
		for (int i = 0; i < chooseBackOrComment.size(); i++) {
			if (chooseBackOrComment.get(i).getText().equals(value)) {
				chooseBackOrComment.get(i).click();
				break;
			}
		}
	}

//	click Cancel 
	public void cancelMyLeave(String date) {
		WebElement clickCancel = driver.findElement(By.xpath(
				"//div[text()= '"+date+"']/parent::div/parent::div/child::div[9]//button[text()=\" Cancel \"]"));
		wait.until(ExpectedConditions.visibilityOf(clickCancel));
		clickCancel.click();
	}

//	set comment 
	public void setComment(String value) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(inputComment));
		inputComment.sendKeys(value);
		Thread.sleep(2000);
		clickSaveOutSide.click();
	}

	public void clickActionButton(String date) {
		WebElement actionButton = driver.findElement(By.xpath("//div[text()= '" + date
				+ "']/parent::div/parent::div/child::div[9]//button[@class = 'oxd-icon-button']"));
		actionButton.click();

	}

//	click dropdown action 
	public void clickDropdownAction(String date, String actionName) {
		clickActionButton(date);
		WebElement action = driver.findElement(By.xpath("//div[text()= '" + date
				+ "']/parent::div/parent::div/child::div[9]//ul[@class = 'oxd-dropdown-menu']//p[text() = '"
				+ actionName + "']"));
		wait.until(ExpectedConditions.visibilityOf(action));
		action.click();
	}

}
