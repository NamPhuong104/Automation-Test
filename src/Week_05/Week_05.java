package Week_05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Week_05 {
	private ChromeOptions options;
	private WebDriver driver;
	private String baseUrl;
	
//	Cau 1
	@Test(enabled = false)
	public void getTotalRowNumber() throws Exception{
		driver.get(baseUrl);
		
		List <WebElement> rows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		System.out.println("No of rows are: " + rows.size());
	}
	
//	Cau 2
	@Test(enabled = false)
	public void getTotalColNumber() throws Exception{
		driver.get(baseUrl);
		List <WebElement> cols = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println("No of cols are: " + cols.size());
	}
	
//	Cau 3
	public void getRowNumberByValue(String value) throws Exception{
		List <WebElement> column = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		for(int i = 0; i < column.size(); i++) {
			if(column.get(i).getText().equals(value)) {
				System.out.println("Value is: " + (i + 1));
			}
		}
	}
	
//	Cau 4
	@Test(enabled = false)
	public void getTableCellValue(int row, int col) throws Exception{
		WebElement find = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[" + row + "]/td[" + col + "]"));
		System.out.println("col: " + col + " " + "row: " + row + " " + find.getText());
	}
	
//	Cau 5
	public void checkItemExistsOnTable(String result) throws Exception{
		List <WebElement> check = driver.findElements(By.xpath("/*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		for(int i = 0; i < check.size(); i++) {
			if(check.get(i).getText().equals(result)) {
				System.out.println("kq ton tai ");
				break;
			}
		}
	}
	
	@BeforeTest
	public void beforeTest() throws Exception{
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		baseUrl = "http://demo.guru99.com/test/web-table-element.php";
	}
	
	@Test
	public void Test() throws Exception{
		driver.get(baseUrl);
//		getRowNumberByValue(driver, "IDFC Bank");
//		getTableCellValue(driver, 2, 3);
		checkItemExistsOnTable("UCO Bank");
	}

	@AfterTest
	public void afterTest() throws Exception{	
//		driver.close();
	}

}
