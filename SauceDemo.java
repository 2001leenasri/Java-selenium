
/*
 * package leanTest;
 * 
 * import java.time.Duration; import org.openqa.selenium.By; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.chrome.ChromeOptions;
 * 
 * public class SauceDemo {
 * 
 * public static void main(String[] args) {
 * 
 * ChromeOptions opt = new ChromeOptions(); opt.addArguments("guest");
 * ChromeDriver driver = new ChromeDriver(opt);
 * driver.get("https://www.saucedemo.com/");
 * driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 * driver.findElement(By.id("user-name")).sendKeys("standard_user");
 * driver.findElement(By.id("password")).sendKeys("secret_sauce");
 * driver.findElement(By.id("login-button")).click();
 * driver.findElement(By.className("product_sort_container")).click();
 * driver.findElement(By.xpath("//option[text()='Price (low to high)']")).click(
 * );
 * driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']"))
 * .click(); driver.findElement(By.className("shopping_cart_link")).click(); } }
 */

package leanTest;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class SauceDemo {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--guest");
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.saucedemo.com/");
    }

    @DataProvider(name = "sortOptions")
    public Object[][] sortOptions() {
        return new Object[][] {
            {"Price (low to high)", "lohi"},
            {"Price (high to low)", "hilo"},
            {"Name (A to Z)", "az"}
        };
    }

    @Test(dataProvider = "sortOptions")
    public void filterAndAddToCart(String sortType, String sortValue) {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(sortDropdown);
        select.selectByValue(sortValue);

        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
        List<WebElement> productPrices = driver.findElements(By.className("inventory_item_price"));
        List<WebElement> addButtons = driver.findElements(By.xpath("//button[contains(@id,'add-to-cart')]"));

        String firstProductName = productNames.get(0).getText();
        String firstProductPrice = productPrices.get(0).getText();

        addButtons.get(0).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        String cartProductName = driver.findElement(By.className("inventory_item_name")).getText();
        String cartProductPrice = driver.findElement(By.className("inventory_item_price")).getText();
        String quantity = driver.findElement(By.className("cart_quantity")).getText();

        Assert.assertEquals(cartProductName, firstProductName, "Product name is incorrect");
        Assert.assertEquals(cartProductPrice, firstProductPrice, "Product price does not match");
        Assert.assertEquals(quantity, "1", "Quantity is not 1");

        System.out.println("Test passed for: " + sortType);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

