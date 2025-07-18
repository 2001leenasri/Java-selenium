package printName;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestSauceDemo {
		
	// main method
		public static void main(String[] args) {
			
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("guest");

			// launch browser
			ChromeDriver driver = new ChromeDriver(opt);
			driver.get("https://www.saucedemo.com/v1/");
 			
			//Id
			// to enter user name
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			
			//Id
			// to enter password
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			
			//Linktext
			// to click login button
			driver.findElement(By.id("login-button")).click();
		
				
		}
	}

