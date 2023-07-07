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
	
	@BeforeTest
	public void beforeTest() throws Exception{
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		baseUrl = "http://demo.guru99.com/test/web-table-element.php";
	}
	
	@Test(enabled = false)
	public void getTotalRowNumber() throws Exception{
		driver.get(baseUrl);
		
		List <WebElement> rows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		System.out.println("No of rows are: " + rows.size());
		
		List <WebElement> cols = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println("No of cols are: " + cols.size());
	}
	
	@Test(enabled = false)
	public void getTotalColNumber() throws Exception{
		driver.get(baseUrl);
		List <WebElement> cols = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println("No of cols are: " + cols.size());
	}
	
	public void getRowNumberByValue(String value) throws Exception{
		driver.get(baseUrl);
		List <WebElement> column = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		for(int i = 0; i < column.size(); i++) {
			if(column.get(i).getText().equals(value)) {
				System.out.println("Value is: " + (i + 1));
			}
		}
	}
	@Test()
	public void Test() throws Exception{
//		getRowNumberByValue("IDFC Bank");
		getTableCellValue(2, 3);
	}
	
	public void getTableCellValue(int row, int col) throws Exception{
		driver.get(baseUrl);
		WebElement find = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[" + row + "]/td[" + col + "]"));
		System.out.println("col: " + col + " " + "row: " + row + " " + find.getText());
	}
	
	@AfterTest
	public void afterTest() throws Exception{
//		driver.close();
	}

}
