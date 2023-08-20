package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Last.Common;
import Last.Excel;
import pageFactory.UserManagement;

public class testUserManagement {
	WebDriver driver;
	Common objCommon;
	UserManagement objUserManagement;
	
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
		objUserManagement = new UserManagement(driver);
		
	}
	
	@BeforeMethod()
	public void beforeMethod() {
		objCommon.chooseModuleOrangel("Admin");
		objCommon.chooseFunction("UserManagement");
	}
	
	@Test(enabled = false)
	public void TR_UM_01() throws Exception {
		objUserManagement.clickAddBtn();
		objUserManagement.clickUserRole();
		objUserManagement.chooseUserRole1("Admin");
		objUserManagement.findEmployeeName("j");
		Thread.sleep(5000);
		objUserManagement.chooseEmployeeName("Jordan Mathews");
		objUserManagement.clickStatus();
		objUserManagement.chooseStatus("Enabled");
		objUserManagement.addUserName("an1234567");
		objUserManagement.addPassword("a1234567");
		objUserManagement.addConfirmPassword("a1234567");
		Thread.sleep(3000);
		objUserManagement.clickSaveBtn();
	}
	
	@Test(enabled = false)
	public void TR_UM_02() throws Exception {
		objUserManagement.clickAddBtn();
		objUserManagement.clickUserRole();
		objUserManagement.chooseUserRole1("Admin");
		objUserManagement.findEmployeeName("j");
		Thread.sleep(5000);
		objUserManagement.chooseEmployeeName("Jadine Jackie");
		objUserManagement.clickStatus();
		objUserManagement.chooseStatus("Disabled");
		objUserManagement.addUserName("an12345678");
		objUserManagement.addPassword("a12345678");
		objUserManagement.addConfirmPassword("a12345678");
		Thread.sleep(3000);
		objUserManagement.clickSaveBtn();
	}
	

	@Test(enabled = false)
	public void TR_UM_04() throws Exception {
		objUserManagement.clickAddBtn();
		objUserManagement.clickUserRole();
		objUserManagement.chooseUserRole1("ESS");
		objUserManagement.findEmployeeName("j");
		Thread.sleep(5000);
		objUserManagement.chooseEmployeeName("Linda Jane Anderson");
		objUserManagement.clickStatus();
		objUserManagement.chooseStatus("Disabled");
		objUserManagement.addUserName("an12345678910");
		objUserManagement.addPassword("a12345678910");
		objUserManagement.addConfirmPassword("a12345678910");
		Thread.sleep(3000);
		objUserManagement.clickCancelBtn();
	}
	
	@Test()
	public void TC_OHRM_EC_01() throws Exception {
		Excel.openFile(".\\ORANGEHRMFT\\src\\Data.xlsx", "User Management");
		objUserManagement.clickAddBtn();
		objUserManagement.clickUserRole();
		objUserManagement.chooseUserRole1(Excel.getCellData(1, 2));
		objUserManagement.findEmployeeName(Excel.getCellData(1, 3));
		Thread.sleep(5000);
		objUserManagement.chooseEmployeeName(Excel.getCellData(1, 4));
		objUserManagement.clickStatus();
		objUserManagement.chooseStatus(Excel.getCellData(1, 5));
		objUserManagement.addUserName(Excel.getCellData(1, 6));
		objUserManagement.addPassword(Excel.getCellData(1, 7));
		objUserManagement.addConfirmPassword(Excel.getCellData(1, 8));
		Thread.sleep(3000);
		objUserManagement.clickCancelBtn();
		Excel.setCellData(1, 10, objCommon.getToastResult());
		if (objCommon.getToastResult().equals(Excel.getCellData(1, 9))) {
			objCommon.testCompleted(1, 11, true, "PASSED");
		} else {
			objCommon.testCompleted(1, 11, false, "FAILED");
		}
		
		Excel.saveAndCloseFile(".\\ORANGEHRMFT\\src\\Data.xlsx");
	}
	
	@Test
	public void TC_OHRM_EC_02() throws Exception {
		Excel.openFile(".\\ORANGEHRMFT\\src\\Data.xlsx", "UserManagement");
		objUserManagement.clickAddBtn();
		objUserManagement.clickUserRole();
		objUserManagement.chooseUserRole1(Excel.getCellData(2, 2));
		objUserManagement.findEmployeeName(Excel.getCellData(2, 3));
		Thread.sleep(5000);
		objUserManagement.chooseEmployeeName(Excel.getCellData(2, 4));
		objUserManagement.clickStatus();
		objUserManagement.chooseStatus(Excel.getCellData(2, 5));
		objUserManagement.addUserName(Excel.getCellData(2, 6));
		objUserManagement.addPassword(Excel.getCellData(2, 7));
		objUserManagement.addConfirmPassword(Excel.getCellData(2, 8));
		Thread.sleep(3000);
		objUserManagement.clickSaveBtn();
		Excel.setCellData(2, 10, objCommon.getToastResult());
		if (objCommon.getToastResult().equals(Excel.getCellData(1, 9))) {
			objCommon.testCompleted(2, 11, true, "PASSED");
		} else {
			objCommon.testCompleted(2, 11, false, "FAILED");
		}
		
		Excel.saveAndCloseFile(".\\ORANGEHRMFT\\src\\Data.xlsx");
	}
	
	@Test(enabled = false)
	public void TC_OHRM_EC_03() throws Exception {
		objUserManagement.clickAddBtn();
		Excel.openFile(".\\ORANGEHRMFT\\src\\Data.xlsx", "UserManagement");
		objUserManagement.clickUserRole();
		objUserManagement.chooseUserRole1(Excel.getCellData(3, 2));
		objUserManagement.findEmployeeName(Excel.getCellData(3, 3));
		Thread.sleep(5000);
		objUserManagement.chooseEmployeeName(Excel.getCellData(3, 4));
		objUserManagement.clickStatus();
		objUserManagement.chooseStatus(Excel.getCellData(3, 5));
		objUserManagement.addUserName(Excel.getCellData(3, 6));
		objUserManagement.addPassword(Excel.getCellData(3, 7));
		objUserManagement.addConfirmPassword(Excel.getCellData(3, 8));
		Thread.sleep(3000);
		objUserManagement.clickSaveBtn();
		Excel.setCellData(3, 10, objCommon.getToastResult());
		if (objCommon.getToastResult().equals(Excel.getCellData(3, 9))) {
			objCommon.testCompleted(3, 11, true, "PASSED");
		} else {
			objCommon.testCompleted(3, 11, false, "FAILED");
		}
		
		Excel.saveAndCloseFile(".\\ORANGEHRMFT\\src\\Data.xlsx");
	}
	
	@Test(enabled = false)
	public void TC_OHRM_EC_04() throws Exception {
		Excel.openFile(".\\ORANGEHRMFT\\src\\Data.xlsx", "UserManagement");
		objUserManagement.clickAddBtn();
		objUserManagement.clickUserRole();
		objUserManagement.chooseUserRole1(Excel.getCellData(4, 2));
		objUserManagement.findEmployeeName(Excel.getCellData(4, 3));
		Thread.sleep(5000);
		objUserManagement.chooseEmployeeName(Excel.getCellData(4, 4));
		objUserManagement.clickStatus();
		objUserManagement.chooseStatus(Excel.getCellData(4, 5));
		objUserManagement.addUserName(Excel.getCellData(4, 6));
		objUserManagement.addPassword(Excel.getCellData(4, 7));
		objUserManagement.addConfirmPassword(Excel.getCellData(4, 8));
		Thread.sleep(3000);
		objUserManagement.clickCancelBtn();
		Excel.setCellData(4, 10, objCommon.getToastResult());
		if (objCommon.getToastResult().equals(Excel.getCellData(4, 9))) {
			objCommon.testCompleted(4, 11, true, "PASSED");
		} else {
			objCommon.testCompleted(4, 11, false, "FAILED");
		}
		
		Excel.saveAndCloseFile(".\\ORANGEHRMFT\\src\\Data.xlsx");
	}

}
