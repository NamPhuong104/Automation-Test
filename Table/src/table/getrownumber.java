package table;
import java.text.ParseException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class getrownumber {

	public static void main(String[] args)throws ParseException {
		WebDriver getrowandcol = new ChromeDriver();
		getrowandcol.get("http://demo.guru99.com/test/web-table-element.php\r\n"
				+ "");
		
		//No.of Columns
		List <WebElement> cot = getrowandcol.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		
		System.out.print("No of cols are : " +cot.size());
		
		
		//No.of Rows
		List <WebElement> dong = getrowandcol.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));
		
		System.out.print("No of rows are : " +dong.size());
		
		getrowandcol.close();
	}

}
