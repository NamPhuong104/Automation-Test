package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.OrangeHRMLeaveList;
import util.ExcelUtil;
import util.OrangelHRMCommon;

public class testOrangeHRMLeaveList {
	WebDriver driver;
	WebDriverWait wait;
	OrangelHRMCommon common;
	OrangeHRMLeaveList leaveList;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		common = new OrangelHRMCommon(driver);
		common.loginToOrangel("admin", "admin123");
		leaveList = new OrangeHRMLeaveList(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		common.chooseModuleOrangel("Leave");
		common.chooseFunction("Leave List");
	}
	
	@AfterTest
	public void afterTest() throws Exception{
//		driver.close();
	}

	
	@Test(enabled = false)
	public void TC_LL_01() throws Exception{
		leaveList.scrollPageUpDown(1000);
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "LeaveList");
		
		leaveList.clickApproveOrReject(ExcelUtil.getCellData(1, 2), ExcelUtil.getCellData(1, 3), " Approve ");
		ExcelUtil.setCellData(1, 6, common.getToastResult());
		if(common.getToastResult().equals(ExcelUtil.getCellData(1, 5))) {
			common.testCompleted(1, 7, true, "PASSED");
		}else{
			common.testCompleted(1, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx");
	}
	
	@Test(enabled = false)
	public void TC_LL_02() throws Exception{
		leaveList.scrollPageUpDown(1000);
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "LeaveList");
		leaveList.clickApproveOrReject(ExcelUtil.getCellData(2, 2), ExcelUtil.getCellData(2, 3), " Reject ");
		ExcelUtil.setCellData(2, 6, common.getToastResult());
		if(common.getToastResult().equals(ExcelUtil.getCellData(2, 5))) {
			common.testCompleted(2, 7, true, "PASSED");
		}else {
			common.testCompleted(2, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx");
	}
	
	@Test(enabled = false)
	public void TC_LL_03() throws Exception{
		leaveList.scrollPageUpDown(500);
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "LeaveList");
		leaveList.clickDropDownAction(ExcelUtil.getCellData(3, 2), ExcelUtil.getCellData(3, 3), "Add Comment");
		leaveList.setComment(ExcelUtil.getCellData(3, 4));
		
		ExcelUtil.setCellData(3, 6, common.getToastResult());
		if(common.getToastResult().equals(ExcelUtil.getCellData(3, 5))) {
			common.testCompleted(3, 7, true, "PASSED");
		}else {
			common.testCompleted(3, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx");
	}
	
	@Test()
	public void TC_LL_04() throws Exception{
		leaveList.scrollPageUpDown(500);
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "LeaveList");
		leaveList.clickDropDownAction(ExcelUtil.getCellData(4, 2), ExcelUtil.getCellData(4, 3), "View Leave Details");
		ExcelUtil.saveAndCloseFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx");
	}
	
	
	@Test()
	public void TC_LL_05() throws Exception{
		leaveList.scrollPageUpDown(500);
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "LeaveList");
		leaveList.clickDropDownAction(ExcelUtil.getCellData(4, 2), ExcelUtil.getCellData(4, 3), "View Leave Details");
		leaveList.chooseBackOrComment("Back");
		ExcelUtil.saveAndCloseFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx");
	}
	
	@Test(enabled = false)
	public void TC_LL_06() throws Exception{
		leaveList.scrollPageUpDown(500);
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "LeaveList");
		leaveList.clickDropDownAction(ExcelUtil.getCellData(7, 2), ExcelUtil.getCellData(7, 3), "View Leave Details");
		leaveList.chooseBackOrComment("Comments");
		leaveList.setComment(ExcelUtil.getCellData(7, 4));
		
		ExcelUtil.setCellData(7, 6, common.getToastResult());
		if(common.getToastResult().equals(ExcelUtil.getCellData(7, 5))) {
			common.testCompleted(7, 7, true, "PASSED");
		}else {
			common.testCompleted(7, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx");
	}
	
	@Test()
	public void TC_LL_07() throws Exception{
		leaveList.scrollPageUpDown(500);
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "LeaveList");
		leaveList.clickDropDownAction(ExcelUtil.getCellData(7, 2), ExcelUtil.getCellData(7, 3), "Cancel Leave");
		ExcelUtil.saveAndCloseFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx");
	}
	@Test()
	public void TC_LL_08() throws Exception{
		leaveList.scrollPageUpDown(500);
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "LeaveList");
		leaveList.clickDropDownAction(ExcelUtil.getCellData(9, 2), ExcelUtil.getCellData(9, 3), "View PIM Info");
		ExcelUtil.saveAndCloseFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx");
	}
	
	@Test(enabled = false)
	public void TC_LL_09() throws Exception{
		ExcelUtil.openFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx", "LeaveList");
		ExcelUtil.setCellData(10, 6, common.getToastResult());
		if(common.getToastResult().equals(ExcelUtil.getCellData(10, 5))) {
			common.testCompleted(10, 7, true, "PASSED");
		}else {
			common.testCompleted(10, 7, false, "FAILED");
		}
		ExcelUtil.saveAndCloseFile(".\\orangelHRMFinalTest\\data\\TestData.xlsx");
	}
}
