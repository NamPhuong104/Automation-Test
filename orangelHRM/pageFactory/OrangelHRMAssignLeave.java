package pageFactory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangelHRMAssignLeave {
	WebDriver driver;
	WebDriverWait wait;
	public OrangelHRMAssignLeave(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

//	One Value


//	List Value



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

}
