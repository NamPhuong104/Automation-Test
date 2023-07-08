package btTable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class getRowNumberByValue {

		public void beforeTest() throws Exception{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			ChromeDriver driver = new ChromeDriver(options);
			String baseUrl = "http://demo.guru99.com/test/web-table-element.php";
		}
			
			
		public void getRowNumberByValue(String value) throws Exception{
			WebDriver driver = new ChromeDriver();;
			String baseUrl = "http://demo.guru99.com/test/web-table-element.php";
			driver.get(baseUrl);
			List <WebElement> column = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
			for(int i = 0; i < column.size(); i++) {
				if(column.get(i).getText().equals(value)) {
					System.out.println("Value is: " + (i + 1));
				}
			}
		
	}

}
