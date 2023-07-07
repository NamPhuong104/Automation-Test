package Week_03;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class radioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://chandanachaitanya.github.io/selenium-practice-site/");
//		WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
//		WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
		
		WebElement list = driver.findElement(By.id("booksCheckboxes"));
		List<WebElement> childElements = list.findElements(By.name("books"));
		for (int i = 0; i< childElements.size(); i++) {
			if (childElements.get(i).getAttribute("value").equals("Self help books")) {
				childElements.get(i).click();
				break;
			}
		
		}
	}

}

