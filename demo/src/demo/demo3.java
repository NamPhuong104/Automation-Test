package demo;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class demo3 {
	private WebDriver driver;
	private ChromeOptions options;
	private String baseUrl;
	
	@SuppressWarnings("deprecation")
	
	public void beforeTest() throws Exception{
		options = new ChromeOptions();
		options.addArguments("Start-maximized");
		driver=new ChromeDriver(options);
		baseUrl="https://github.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
	//"//a[@id='repositories-tab']/..//a[@id="+Xitem+"]"
	public void selectItem() {
		Actions actions = new Actions(driver);
		WebElement items = (WebElement) driver.findElements(By.xpath("//*[@class='search-input']"));
		actions.click(items).perform();
		WebElement item2= (WebElement) driver.findElements(By.xpath("//*[@id='query-builder-test']"));
		actions.sendKeys(item2,"hello").perform();

		
	}

	public void Test() throws Exception{
		driver.get(baseUrl);
		selectItem();
	}
}
	