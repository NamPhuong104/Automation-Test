package util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangelHRMCommon {
	WebDriver driver;
	WebDriverWait wait;

	public OrangelHRMCommon(WebDriver driver) {
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


//	Login
	public void setUserName(String userN) {
		userName.sendKeys(userN);
	}

	public void setPassword(String passw) {
		password.sendKeys(passw);
	}

	public void loginBtn() {
		login.click();
	}



	public void loginToOrangel(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
		this.loginBtn();
	}


//	Dashboard
	@FindBy(xpath = "//div[@class = 'oxd-sidepanel-body']/ul/li")
	List<WebElement> chooseModule;

	@FindBy(xpath = "//li[@class='oxd-topbar-body-nav-tab']")
	List<WebElement> func;

	@FindBy(xpath = "//li[@class = 'oxd-topbar-body-nav-tab --parent']")
	List<WebElement> sections;

	@FindBy(xpath = "//ul[@class =\"oxd-dropdown-menu\"]/li")
	List<WebElement> childSections;


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

	public void chooseSections(String name) {
		wait.until(ExpectedConditions.visibilityOfAllElements(sections));
		for (WebElement section : sections) {
			if(section.getText().equals(name)) {
				section.click();
				break;
			}
		}
	}

	public void ChooseChildSections(String name) {
		wait.until(ExpectedConditions.visibilityOfAllElements(childSections));
		for (WebElement childSection : childSections) {
			if(childSection.getText().equals(name)) {
				childSection.click();
				break;
			}
		}
	}


}
