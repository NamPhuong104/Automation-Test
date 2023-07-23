package exercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Week05 {
	private ChromeOptions options;
	private WebDriver driver;
	private String baseUrl;
	
	public void getTotalRowNumber() throws Exception {
		List<WebElement> row = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("No of rows are: " + row.size());
	}
	
	public void getTotalColumnNumber() throws Exception {
		List<WebElement> col = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
		System.out.println("No of columns are: " + col.size());
	}

	public void getRowNumberByValue(String value) throws Exception {
		List<WebElement> row = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		for (int i = 0; i < row.size(); i++) {
			if(row.get(i).getText().equals(value)) {
				System.out.println("Row number is: " + (i + 1));
				break;
			}
		}
	}
	
	public void getTableCellValue(int row, int col) throws Exception {
		WebElement index = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" + row + "]/td[" + col + "]"));
		System.out.println("Value at row " + row + " column " + col + " " + index.getText());
	}
	
	public void checkItemExistsOnTable(String value) throws Exception {
		List<WebElement> row = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		for (int i = 0; i < row.size(); i++) {
			if(row.get(i).getText().equals(value)) {
				System.out.println(value + " exists on table");
				break;
			}
		}
	}
	
	@BeforeTest
	public void beforeTest() throws Exception {
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		baseUrl = "https://demo.guru99.com/test/web-table-element.php";
	}
	
	@Test
	public void test() throws Exception {
		driver.get(baseUrl);
		getTotalRowNumber();
		getTotalColumnNumber();
		getRowNumberByValue("IDFC Bank");
		getTableCellValue(10, 3);
		checkItemExistsOnTable("REC");
	}
	
	@AfterTest
	public void afterTest() throws Exception {
		driver.close();
	}
	
}
