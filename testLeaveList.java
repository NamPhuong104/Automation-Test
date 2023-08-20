package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Last.Common;
import Last.Excel;
import pageFactory.LeaveList;


public class testLeaveList {
	WebDriver driver;
	Common objCommon;
	LeaveList objLeaveList;
	
	@BeforeTest( )
	public void beforeTest() {
		driver = new ChromeDriver();
		Reporter.log("Browser Open");
		driver.manage().window().maximize();
		Reporter.log("Browser Maximized");
		driver.get("https://opensource-demo.orangehrmlive.com");
		Reporter.log("Application Started");
		objCommon = new Common(driver);
		objCommon.loginToOrangeHRM("Admin", "admin123");
		objLeaveList = new LeaveList(driver);
		
	}
	
	@BeforeMethod()
	public void beforeMethod() {
		objCommon.chooseModuleOrangel("Leave");
		objCommon.chooseFunction("Leave List");
		
	}
	
	@Test()
	public void TR_LL_01() throws Exception {
		Excel.openFile(".\\ORANGEHRMFT\\src\\Data.xlsx", "LeaveList");
		objLeaveList.clickFromDate();
		objLeaveList.chooseFromDate(Excel.getCellData(1, 2));
		objLeaveList.clickToDate();
		objLeaveList.chooseToDate(Excel.getCellData(1, 3));
		objLeaveList.clickShow();
		objLeaveList.chooseShow(Excel.getCellData(1, 4));
		objLeaveList.clickType();
		objLeaveList.chooseType(Excel.getCellData(1, 5));
		objLeaveList.findEmployeeName(Excel.getCellData(1, 6));
		Thread.sleep(10000);
		objLeaveList.chooseEmployeeName(Excel.getCellData(1, 7));
		objLeaveList.clickUnit();
		objLeaveList.chooseUnit(Excel.getCellData(1, 8));
		objLeaveList.clickResertBtn();
		Excel.setCellData(1, 10, objCommon.getToastResult());
		if (objCommon.getToastResult().equals(Excel.getCellData(1, 9))) {
			objCommon.testCompleted(1, 11, true, "PASSED");
		} else {
			objCommon.testCompleted(1, 11, false, "FAILED");
		}
		
		Excel.saveAndCloseFile(".\\ORANGEHRMFT\\src\\Data.xlsx");
	}
	
	@Test()
	public void TR_LL_02() throws Exception {
		Excel.openFile(".\\ORANGEHRMFT\\src\\Data.xlsx", "LeaveList");
		objLeaveList.clickFromDate();
		objLeaveList.chooseFromDate(Excel.getCellData(2, 2));
		objLeaveList.clickToDate();
		objLeaveList.chooseToDate(Excel.getCellData(2, 3));
		objLeaveList.clickShow();
		objLeaveList.chooseShow(Excel.getCellData(2, 4));
		objLeaveList.clickType();
		objLeaveList.chooseType(Excel.getCellData(2, 5));
		objLeaveList.findEmployeeName(Excel.getCellData(2, 6));
		Thread.sleep(10000);
		objLeaveList.chooseEmployeeName(Excel.getCellData(2, 7));
		objLeaveList.clickUnit();
		objLeaveList.chooseUnit(Excel.getCellData(2, 8));
		objLeaveList.clickResertBtn();
		Excel.setCellData(2, 10, objCommon.getToastResult());
		if (objCommon.getToastResult().equals(Excel.getCellData(2, 9))) {
			objCommon.testCompleted(2, 11, true, "PASSED");
		} else {
			objCommon.testCompleted(2, 11, false, "FAILED");
		}
		Excel.saveAndCloseFile(".\\ORANGEHRMFT\\src\\Data.xlsx");
	}
}
