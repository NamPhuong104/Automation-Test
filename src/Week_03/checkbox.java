package Week_03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//public class checkbox {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String baseUrl = "https://chandanachaitanya.github.io/selenium-practice-site/";
//		 WebDriver driver = new ChromeDriver();
//		 
//		 driver.get(baseUrl);
//		 
//		 WebElement option1 = driver.findElement(By.id("bicycle-checkbox"));
//		 
//		 option1.click();
//		 
//		 if(option1.isSelected()) {
//			 System.out.println("This checkbox is Toggled On");
//		 }
//		 else {
//			 System.out.println("This checkbox is Toggled Off");
//		 }
//		 option1.click();
//		 if(!option1.isSelected()) {
//			 System.out.println("Checkbox is now Toggled Off ");
//		 }
//	}
//}


// check option exists on checkbox
public class checkbox {

	public static void main(String[] args) {
		String baseUrl = "https://chandanachaitanya.github.io/selenium-practice-site/";
		WebDriver driver = new ChromeDriver();
		
		driver.get(baseUrl);
		
		WebElement list = driver.findElement(By.id("twoWheelVehicles"));
		List<WebElement> childElements = list.findElements(By.name("vehicle"));
		for (int i = 0; i< childElements.size(); i++) {
			if (childElements.get(i).getAttribute("value").equals("Sedan")) {
				childElements.get(i).click();
				break;
			}
		}
	}
}
