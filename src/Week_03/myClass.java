package Week_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class myClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/login.html");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("nguyennamphuong104@gmail.com");
		WebElement password = driver.findElement(By.id("passwd"));
		password.sendKeys("12345");
		WebElement login = driver.findElement(By.id("SubmitLogin"));
		login.click();
		
		WebElement notification = driver.findElement(By.tagName("h3"));
		if(notification.getText().contentEquals("Successfully Logged in...")) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
	}

}
