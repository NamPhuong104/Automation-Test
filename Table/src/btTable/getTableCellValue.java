package btTable;
import java.text.NumberFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import dev.failsafe.internal.util.Assert;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class getTableCellValue {

	 public static int getTableCellValue(int row, int col) {
	    	WebDriver driver;
			System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://demo.guru99.com/test/web-table-element.php");
	        WebElement value = driver.findElement(By.xpath
	        		("//*[@id=\"leftcontainer\"]/table/tbody/tr["+ col +"]/td["+ row +"]\r\n"));
	        String num = value.getText();
	        System.out.print("Dap an o cot do: " + num);
	        return 0;
	        
	    }
	    public static int checkIfExist(String input) {
			WebDriver driver;
			System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://demo.guru99.com/test/web-table-element.php");
			
	        List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
	        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));

			
			for(int i = 1; i<rows.size(); i++)
			{
				for(int u=1; u<col.size(); u++) {
			        WebElement value = driver.findElement(By.xpath
			        		("//*[@id=\"leftcontainer\"]/table/tbody/tr["+ i +"]/td["+ u +"]\r\n"));
			        String num = value.getText();
			        if (num.equals(input)){
			            System.out.print("Co dap an " + num + " tai col " + u + " tai row " +i+"  ");
			        };
			        
				}

			}
			
	        return 0;
	    }
	    
	    public static void main(String[] args) {
	    	checkIfExist("Nestle India");
	    }
	}
