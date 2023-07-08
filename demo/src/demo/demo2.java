package demo;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.List;

@SuppressWarnings("unused")
public class demo2 {
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
	public void SearchItem(String Xitem) {
		Actions actions = new Actions(driver);
		WebElement item= (WebElement) driver.findElement(By.xpath("//button[@class='header-search-button placeholder input-button form-control d-flex flex-1 flex-self-stretch flex-items-center no-wrap width-full py-0 pl-2 pr-0 text-left border-0 box-shadow-none']"));
		actions.click(item).perform();
		WebElement item2= (WebElement) driver.findElement(By.xpath("//input[@id='query-builder-test']"));
		actions.sendKeys(item2, Xitem).perform();
		
	}
	
	public void Test() throws Exception{
		driver.get(baseUrl);
		SearchItem("Hello");
	}
}