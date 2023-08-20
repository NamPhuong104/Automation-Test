package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Last.Common;
import Last.Excel;
import pageFactory.Holidays;

public class testHolidays {
	WebDriver driver;
	Common objCommon;
	Holidays objHolidays;
	
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
		objHolidays = new Holidays(driver);
		
	}
	
	@BeforeMethod()
	public void beforeMethod() {
		objCommon.chooseModuleOrangel("Leave");
		objCommon.selectbfunc("Configure");
		objCommon.selectSection("Holidays");
	}
	
	@Test()
	public void TR_HL_011()throws Exception{
		
	}
	
	@Test(enabled = false)
	public void TR_HL_022()throws Exception{
		
	}
	
	@Test()
	public void TR_HL_03()throws Exception{
		objHolidays.clickAddBtn();
		objHolidays.addDateName("love");
		objHolidays.clickDate();
		objHolidays.chooseDate("23");
		objHolidays.clickFullDayHalfDay();
		objHolidays.chooseFullDayHalfDay("Half Day");
		objHolidays.clickSaveBtn();
		objHolidays.checkResult("Successfully Saved");
	}
	
	@Test(enabled = false)
	public void TR_HL_04()throws Exception{
		objHolidays.clickAddBtn();
		objHolidays.addDateName("eat");
		objHolidays.clickDate();
		objHolidays.chooseDate("24");
		objHolidays.clickFullDayHalfDay();
		objHolidays.chooseFullDayHalfDay("Full Day");
		objHolidays.clickSaveBtn();
//		objHolidays.checkResult("Successfully Saved");
	}
	
	@Test()
	public void TR_HD_01() throws Exception {
		objHolidays.clickAddBtn();
		Excel.openFile(".\\ORANGEHRMFT\\src\\Data.xlsx", "Holidays");
		objHolidays.addDateName(Excel.getCellData(1, 2));
		objHolidays.clickDate();
		objHolidays.chooseDate(Excel.getCellData(1, 3));
		objHolidays.clickFullDayHalfDay();
		objHolidays.chooseFullDayHalfDay(Excel.getCellData(1, 4));
		objHolidays.clickSaveBtn();
		objHolidays.checkResult(Excel.getCellData(1, 5));
		Excel.setCellData(1, 6, objCommon.getToastResult());
		if (objCommon.getToastResult().equals(Excel.getCellData(1, 5))) {
			objCommon.testCompleted(1, 7, true, "PASSED");
		} else {
			objCommon.testCompleted(1, 7, false, "FAILED");
		}
		
		Excel.saveAndCloseFile(".\\ORANGEHRMFT\\src\\Data.xlsx");
	}
	
	@Test
	public void TR_HD_02() throws Exception {
		Excel.openFile(".\\ORANGEHRMFT\\src\\Data.xlsx", "Holidays");
		objHolidays.clickAddBtn();
		objHolidays.addDateName(Excel.getCellData(2, 2));
		objHolidays.clickDate();
		Thread.sleep(10000);
		objHolidays.chooseDate(Excel.getCellData(2, 3));
		objHolidays.clickFullDayHalfDay();
		objHolidays.chooseFullDayHalfDay(Excel.getCellData(2, 4));
		objHolidays.clickSaveBtn();
		objHolidays.checkResult(Excel.getCellData(2, 5));
		Excel.setCellData(2, 6, objCommon.getToastResult());
		if (objCommon.getToastResult().equals(Excel.getCellData(2, 5))) {
			objCommon.testCompleted(2, 7, true, "PASSED");
		} else {
			objCommon.testCompleted(2, 7, false, "FAILED");
		}
		
		Excel.saveAndCloseFile(".\\ORANGEHRMFT\\src\\Data.xlsx");
	}

}
