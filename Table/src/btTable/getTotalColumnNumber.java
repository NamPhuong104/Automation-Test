package btTable;
import java.text.ParseException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class getTotalColumnNumber {

	public static void main(String[] args)throws ParseException {
		WebDriver getcol = new ChromeDriver();
		getcol.get("http://demo.guru99.com/test/web-table-element.php\r\n"
				+ "");
		
		List <WebElement> cot = getcol.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));

		System.out.print("No of cols are : " +cot.size());
		
		getcol.close();
		
	}

}
