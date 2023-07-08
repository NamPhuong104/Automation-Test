package radio;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class radio1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		
		
		driver.get("https://demo.guru99.com/test/radio.html");

		WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
		//WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
		
		//button 1 is selected
		radio1.click();
		System.out.print("radiobutton 1 is selected");
		//button 1 is deselected and button 2 is selected
		//radio2.click();
		//System.out.print("radiobutton 2 is selected");
		
		}}