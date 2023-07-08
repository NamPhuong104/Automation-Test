package btTable;
import java.text.ParseException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class getTotalRowNumber {

	public static void main(String[] args)throws ParseException {
		WebDriver getrow = new ChromeDriver();
		getrow.get("http://demo.guru99.com/test/web-table-element.php");
		
		List <WebElement> dong = getrow.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));
		
		System.out.print("No of rows are : " +dong.size());
		
		getrow.close();

	}

}
