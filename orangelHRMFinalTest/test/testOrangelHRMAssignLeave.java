package test;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageFactory.OrangelHRMAssignLeave;
import util.ExcelUtil;
import util.OrangelHRMCommon;

@Listeners(test.listenerTest.class)

@Test
public class testOrangelHRMAssignLeave {
	WebDriver driver;
	ChromeOptions options;
	WebDriverWait wait;

	OrangelHRMCommon common;
	OrangelHRMAssignLeave assignLeave;


	@BeforeTest()
	public void setup() {
		options = new ChromeOptions();
		options.addArguments("Start-maximized");

		driver = new ChromeDriver(options);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		common = new OrangelHRMCommon(driver);
		common.loginToOrangel("admin", "admin123");

		assignLeave = new OrangelHRMAssignLeave(driver);
	}

	@BeforeMethod()
	public void beforeMethod() {
		common.chooseModuleOrangel("Leave");
		common.chooseFunction("Assign Leave");
	}
	
	@AfterTest()
	public void afterTest() throws Exception {
		driver.close();
	}

	
	@Test()
	public void TC_AL_01() throws Exception {
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "AssignLeave");
		Reporter.log("Open File");
		Reporter.log("Enter Information With All Valid Required Fields");
		assignLeave.inputUser(ExcelUtil.getCellData(1, 2));
		assignLeave.chooseLeaveType(ExcelUtil.getCellData(1, 3));
		assignLeave.chooseFromDate(ExcelUtil.getCellData(1, 4));
		assignLeave.chooseToDate(ExcelUtil.getCellData(1, 5));
		assignLeave.choosePartialDays(ExcelUtil.getCellData(1, 6));
		
		assignLeave.chooseStartDay(ExcelUtil.getCellData(1, 8));
		assignLeave.setTimeStartDayFrom(ExcelUtil.getCellData(1, 9), ExcelUtil.getCellData(1, 10), null);
		assignLeave.setTimeStartTo(ExcelUtil.getCellData(1, 12), ExcelUtil.getCellData(1, 13), ExcelUtil.getCellData(1, 14));
		
		assignLeave.chooseEndDay(ExcelUtil.getCellData(1, 15));
		assignLeave.setTimeEndDayFrom(ExcelUtil.getCellData(1, 16), ExcelUtil.getCellData(1, 17), null);
		assignLeave.setTimeEndTo(ExcelUtil.getCellData(1, 19), ExcelUtil.getCellData(1, 20), ExcelUtil.getCellData(1, 21));
		
		assignLeave.setComment(ExcelUtil.getCellData(1, 22));
		assignLeave.submit();
		ExcelUtil.setCellData(1, 24, common.getToastResult());
		if(common.getToastResult().equals(ExcelUtil.getCellData(1, 23))) {
			common.testCompleted(1, 25, true, "PASSED");
		}
		else{
			common.testCompleted(1,25, false, "FAILED");
		}
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".//orangelHRMFinalTest//data//TestData.xlsx");
		Reporter.log("Save And Close File");
	}
	
	@Test()
	public void TC_AL_02() throws Exception {
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "AssignLeave");
		Reporter.log("Open File");
		Reporter.log("Enter Information With All Valid Required Fields");
		assignLeave.inputUser(ExcelUtil.getCellData(2, 2));
		assignLeave.chooseLeaveType(ExcelUtil.getCellData(2, 3));
		assignLeave.chooseFromDate(ExcelUtil.getCellData(2, 4));
		assignLeave.chooseToDate(ExcelUtil.getCellData(2, 5));
		assignLeave.choosePartialDays(ExcelUtil.getCellData(2, 6));
		
		assignLeave.chooseStartDay(ExcelUtil.getCellData(2, 8));
		
		assignLeave.setComment(ExcelUtil.getCellData(2, 22));
		assignLeave.submit();
		
		ExcelUtil.setCellData(2, 24, common.getToastResult());
		if(common.getToastResult().equals(ExcelUtil.getCellData(2, 23))) {
			common.testCompleted(2, 25, true, "PASSED");
		}
		else{
			common.testCompleted(2,25, false, "FAILED");
		}
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".//orangelHRMFinalTest//data//TestData.xlsx");
		Reporter.log("Save And Close File");
	}
	
	@Test()
	public void TC_AL_03() throws Exception{
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "AssignLeave");
		Reporter.log("Open File");
		Reporter.log("Enter Information With All Valid Required Fields");
		assignLeave.inputUser(ExcelUtil.getCellData(3, 2));
		assignLeave.chooseLeaveType(ExcelUtil.getCellData(3, 3));
		assignLeave.chooseFromDate(ExcelUtil.getCellData(3, 4));
		
		assignLeave.setComment(ExcelUtil.getCellData(3, 22));
		assignLeave.submit();
		
		ExcelUtil.setCellData(3, 24, common.getToastResult());
		if(common.getToastResult().equals(ExcelUtil.getCellData(3, 23))) {
			common.testCompleted(3, 25, true, "PASSED");
		}
		else{
			common.testCompleted(3,25, false, "FAILED");
		}
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".//orangelHRMFinalTest//data//TestData.xlsx");
		Reporter.log("Save And Close File");
	}
	
	@Test()
	public void TC_AL_04() throws Exception{
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "AssignLeave");
		Reporter.log("Open File");
		Reporter.log("Enter Information With All Valid Required Fields");
		assignLeave.inputUser(ExcelUtil.getCellData(4, 2));
		assignLeave.chooseLeaveType(ExcelUtil.getCellData(4, 3));
		assignLeave.chooseFromDate(ExcelUtil.getCellData(4, 4));
		assignLeave.chooseToDate(ExcelUtil.getCellData(4, 5));
		assignLeave.choosePartialDays(ExcelUtil.getCellData(4, 6));
		assignLeave.chooseStartDay(ExcelUtil.getCellData(4, 8));
		
		assignLeave.setComment(ExcelUtil.getCellData(4, 22));
		assignLeave.submit();
		
		ExcelUtil.setCellData(4, 24, common.getToastResult());
		if(common.getToastResult().equals(ExcelUtil.getCellData(4, 23))) {
			common.testCompleted(4, 25, true, "PASSED");
		}
		else{
			common.testCompleted(4,25, false, "FAILED");
		}
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".//orangelHRMFinalTest//data//TestData.xlsx");
		Reporter.log("Save And Close File");
	}
	
	@Test()
	public void TC_AL_05() throws Exception{
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "AssignLeave");
		Reporter.log("Open File");
		Reporter.log("Enter Information With All Valid Required Fields");
		assignLeave.inputUser(ExcelUtil.getCellData(5, 2));
		assignLeave.chooseLeaveType(ExcelUtil.getCellData(5, 3));
		assignLeave.chooseFromDate(ExcelUtil.getCellData(5, 4));
		assignLeave.choosePartialDays(ExcelUtil.getCellData(5, 7));
		assignLeave.setDurationSpecifyTime(ExcelUtil.getCellData(5, 9),ExcelUtil.getCellData(5, 10), "");
		assignLeave.setTimeStartDayFrom(ExcelUtil.getCellData(5, 12), ExcelUtil.getCellData(5, 13), ExcelUtil.getCellData(5, 14));
		
		
		assignLeave.setComment(ExcelUtil.getCellData(5, 22));
		assignLeave.submit();
		
		ExcelUtil.setCellData(5, 24, common.getToastResult());
		
		if(common.getToastResult().equals(ExcelUtil.getCellData(5, 23))) {
			common.testCompleted(5, 25, true, "PASSED");
		}
		else{
			common.testCompleted(5,25, false, "FAILED");
		}
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".//orangelHRMFinalTest//data//TestData.xlsx");
		Reporter.log("Save And Close File");
	}
	
	@Test()
	public void TC_AL_06() throws Exception {
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "AssignLeave");
		Reporter.log("Open File");
		Reporter.log("Enter Information With All Valid Required Fields");
		assignLeave.inputUser(ExcelUtil.getCellData(6, 2));
		assignLeave.chooseLeaveType(ExcelUtil.getCellData(6, 3));
		assignLeave.chooseFromDate(ExcelUtil.getCellData(6, 4));
		assignLeave.chooseToDate(ExcelUtil.getCellData(6, 5));
		assignLeave.choosePartialDays(ExcelUtil.getCellData(6, 6));
		
		assignLeave.chooseStartDay(ExcelUtil.getCellData(6, 8));
		
		assignLeave.setComment(ExcelUtil.getCellData(6, 22));
		assignLeave.submit();
		
		ExcelUtil.setCellData(6, 24, common.getToastResult());
		if(common.getToastResult().equals(ExcelUtil.getCellData(6, 23))) {
			common.testCompleted(6, 25, true, "PASSED");
		}
		else{
			common.testCompleted(6,25, false, "FAILED");	
		}
		Reporter.log("Write Result");
		ExcelUtil.saveAndCloseFile(".//orangelHRMFinalTest//data//TestData.xlsx");
		Reporter.log("Save And Close File");
	}
	
}
