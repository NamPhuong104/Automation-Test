package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.OrangeHRMMyLeave;
import util.ExcelUtil;
import util.OrangelHRMCommon;

public class testOrangeHRMMyLeave {
		WebDriver driver;
		WebDriverWait wait;
		OrangelHRMCommon common;
		OrangeHRMMyLeave myLeave;
		
		
		@BeforeTest
		public void setup() {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			common = new OrangelHRMCommon(driver);
			common.loginToOrangel("admin", "admin123");
			myLeave = new OrangeHRMMyLeave(driver);
		}
	@BeforeMethod
	public void beforeMethod() {
		common.chooseModuleOrangel("Leave");
		common.chooseFunction("My Leave");
	}
	
	@AfterTest
	public void afterTest() throws Exception{
//		driver.close();
	}
	
	@Test(enabled = false)
	public void TC_ML_01()throws Exception {
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "MyLeave");
		ExcelUtil.setCellData(1, 4, common.getToastResult());
		if(common.getToastResult().equals(ExcelUtil.getCellData(1, 3))) {
			common.testCompleted(1, 5, true, "PASSED");
		}else {
			common.testCompleted(1, 5, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx");
	}
	
	@Test()
	public void TC_ML_02() throws Exception {
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "MyLeave");
		myLeave.scrollPageUpDown(500);
		myLeave.clickDropdownAction("2023-08-17", "Add Comment");
		
		myLeave.setComment(ExcelUtil.getCellData(2, 2));
		ExcelUtil.setCellData(2, 4, common.getToastResult());
		if(common.getToastResult().equals(ExcelUtil.getCellData(2, 3))) {
			common.testCompleted(2, 5, true, "PASSED");
		}else {
			common.testCompleted(2, 5, false, "FAIlED");
		}
		ExcelUtil.saveAndCloseFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx");
	}
	
	@Test(enabled = false)
	public void TC_ML_03() throws Exception{
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "MyLeave");
		myLeave.scrollPageUpDown(1000);
		myLeave.clickDropdownAction("2023-08-21", "View Leave Details");
		ExcelUtil.saveAndCloseFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx");
	}
	
	@Test(enabled = false)
	public void TC_ML_04() throws Exception {
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "MyLeave");
		myLeave.scrollPageUpDown(500);
		myLeave.cancelMyLeave("2023-08-21");
		
		ExcelUtil.setCellData(4, 4, common.getToastResult());
		if(common.getToastResult().equals(ExcelUtil.getCellData(4, 3))) {
			common.testCompleted(4, 5, true, "PASSED");
		}else {
			common.testCompleted(4, 5, false, "FAIlED");
		}
		ExcelUtil.saveAndCloseFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx");
	}
	
	@Test(enabled = false)
	public void TC_ML_05() throws Exception{
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "MyLeave");
		myLeave.clickDropdownAction("2023-08-22", "View PIM Info");
		ExcelUtil.saveAndCloseFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx");
	}
}
























