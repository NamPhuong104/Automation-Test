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

public class OrangeHRMLeaveList {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;
	
	public OrangeHRMLeaveList(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		jse = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	
//	One Value
	@FindBy(xpath = "//div[@class= \"orangehrm-paper-container\"]")
	WebElement waitTable;
	@FindBy(xpath = "//div[@role=\"document\"]//div[@class=\"oxd-form-actions\"]/button[@type=\"submit\"]")
	WebElement clickSaveOutSide;
	@FindBy(xpath = "//div[@class = \"oxd-input-group oxd-input-field-bottom-space\"]//textarea")
	WebElement inputComment;

	
//	List Value
	@FindBy(xpath = "//div[@class = \"orangehrm-bottom-container\"]//button[@type= \"button\"]")
	List<WebElement> chooseBackOrComment;
	
	public void scrollPageUpDown(int height) {
		wait.until(ExpectedConditions.visibilityOf(waitTable));
		jse.executeScript("window.scrollBy(0," + height + ")");
	}
	
	public void clickActionButton(String date, String name) {
		WebElement actionButton = driver.findElement(By.xpath("//div[text() ='"+date+"']/parent::div/parent::div/div[3]//div[text() = '"+name+"']/parent::div/parent::div/div[9]//button[@class=\"oxd-icon-button\"]"));
		actionButton.click();
	}
	
	public void clickDropDownAction(String date, String name, String actionName) {
		clickActionButton(date, name);
		WebElement action = driver.findElement(By.xpath("//div[text()= '" + date
				+ "']/parent::div/parent::div/child::div[9]//ul[@class = 'oxd-dropdown-menu']//p[text() = '"
				+ actionName + "']"));
		wait.until(ExpectedConditions.visibilityOf(action));
		action.click();
	}
	
	public void clickApproveOrReject(String date, String name, String type) {
		wait.until(ExpectedConditions.visibilityOf(waitTable));
		WebElement clickAppOrRej = driver.findElement(By.xpath("//div[text() ='"+date+"']/parent::div/parent::div/div[3]//div[text() = '"+name+"']/parent::div/parent::div/div[9]//button[text() = '"+type+"']"));
		clickAppOrRej.click();
	}
	
	public void chooseBackOrComment(String value) {
		wait.until(ExpectedConditions.visibilityOfAllElements(chooseBackOrComment));
		for (int i = 0; i < chooseBackOrComment.size(); i++) {
			if (chooseBackOrComment.get(i).getText().equals(value)) {
				chooseBackOrComment.get(i).click();
				break;
			}
		}
	}
	
	public void setComment(String value) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(inputComment));
		inputComment.sendKeys(value);
		Thread.sleep(2000);
		clickSaveOutSide.click();
	}
}
