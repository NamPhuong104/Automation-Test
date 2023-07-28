package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class assignLeave extends generalFunction{
	
	@Test(enabled = false)
	public void assignL() throws Exception  {
		login("admin", "admin123");
		selectModule("Leave");
		selectFunc("Assign Leave");
		findEmployeeName("a", "Odis Adalwin");
		selectLeaveType("CAN - Personal");
		selectFromDate("25");
		selectToDate("26");
		partialDay("All Days");
		duration("Half Day - Morning");
		comments("Automation Test");
		submit();
		String expectedResult = "Successfully Saved";
		WebElement toastResult = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']"));
		String actuaResult = toastResult.getText();
		Assert.assertEquals(actuaResult, expectedResult);
	}
	
	@Test
	public void testReject() throws Exception {
		login("admin", "admin123");
		selectModule("Leave");
		selectFunc("Leave List");
		reject("Charlie Carter");
	}
}
