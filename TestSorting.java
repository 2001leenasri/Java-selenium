package printName;

import java.awt.List;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestSorting {
	// main method
	public static void main(String[] args) throws InterruptedException {
				
				ChromeOptions opt = new ChromeOptions();
				opt.addArguments("guest");

				// launch browser
				ChromeDriver driver = new ChromeDriver(opt);
				driver.get("https://www.saucedemo.com/v1/");
				
				driver.manage().window().maximize();
                 
				// Implicitly Wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 			
				//Id  // to enter user name
				driver.findElement(By.id("user-name")).sendKeys("standard_user");
				
				//Id  // to enter password
				driver.findElement(By.id("password")).sendKeys("secret_sauce");
				
				//Linktext  // to click login button
				driver.findElement(By.id("login-button")).click();
				
				WebElement firstproductname = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
			    String productname=firstproductname.getText();
			    System.out.println(productname);
				
				WebElement firstproductprice = driver.findElement(By.xpath("//div[text()='29.99']"));
				String productprice=firstproductprice.getText();
				System.out.println(productprice);
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//button[@class='btn_primary btn_inventory']")).click();
				
				driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']")).click();
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//a[text()='CHECKOUT']")).click();
				
				driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Leenasri");
				
				driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("S");
				
				driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("613003");
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
				
	//			List<WebElement> price= driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
	//			List<Integer> Prices= new ArrayList<Integer>();
				  
	//			  for (int i=0;i<price.size();i++) {
	//				  String Text = price.get(i).getText();
					  
	//				  if(!text.)
					  
	//			  }
				  
	//			Collections.sort(Prices);
	//			System.out.println("second largest" + Prices.get (Prices.size() -2));
				
				
				
				driver.findElement(By.xpath("//a[text()='FINISH']")).click();

                File source=driver.getScreenshotAs(OutputType.FILE);
				
				File dst= new File("./images/img.png");
						
				FileUtils.copyFile(source,dst);

				
				driver.close();
					
			}
}

