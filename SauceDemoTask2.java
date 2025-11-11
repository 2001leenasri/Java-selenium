package leanTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SauceDemoTask2 {
	
	public static void main(String[] args) {
		  
		  ChromeOptions opt = new ChromeOptions(); opt.addArguments("guest");
		  ChromeDriver driver = new ChromeDriver(opt);
		  driver.get("https://www.saucedemo.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.findElement(By.id("user-name")).sendKeys("standard_user");
		  driver.findElement(By.id("password")).sendKeys("secret_sauce");
		  driver.findElement(By.id("login-button")).click();
		  driver.findElement(By.className("product_sort_container")).click();
		  driver.findElement(By.xpath("//option[text()='Name (Z to A)']")).click();
		  
		  List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
	      List<WebElement> productPrices = driver.findElements(By.className("inventory_item_price"));
	        
	        System.out.println("First 3 Products after sorting by Name (Z to A):");
	        for (int i = 0; i < 3; i++) {
	            String name = productNames.get(i).getText();
	            String price = productPrices.get(i).getText();
	            System.out.println(name + " - " + price);
	        }
	        
	        driver.quit();
		  
		  }

}
