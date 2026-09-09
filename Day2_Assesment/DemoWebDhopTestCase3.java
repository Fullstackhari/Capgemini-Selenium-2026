package Day2_Assesment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class DemoWebDhopTestCase3 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		WebElement lap = driver.findElement(By.linkText("14.1-inch Laptop"));
		System.out.println(lap.getText());
		
		//Fetching the Size of the Add to cart button 
		WebElement cartbtn = driver.findElement(By.xpath("//div[@class=\"page home-page\"]/descendant::a[text()='14.1-inch Laptop']/../../descendant::div[@class=\"buttons\"]/descendant::input"));
		Dimension size = cartbtn.getSize();
		System.out.println("Height of Add to Cart Btn "+size.getHeight());
		System.out.println("Width of Add to Cart Btn "+size.getWidth());
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		//Clicking on the Add to cart button
		driver.findElement(By.xpath("//div[@class=\"page home-page\"]/descendant::a[text()='14.1-inch Laptop']/../../descendant::div[@class=\"buttons\"]/descendant::input")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		Thread.sleep(3000);
		
		//Verifying whether the remove checkBox is selected or no
		WebElement removebox = driver.findElement(By.cssSelector("[name='removefromcart']"));
		if(removebox.isSelected()){
		System.out.println("Checkbox is selected");
		}else{
		System.out.println("CheckBox is not selected");
		}
		
		//Fetching the RemoveCheckBox Rect details
		Rectangle rect = removebox.getRect();
		System.out.println("X point of Removebox: "+rect.getX());
		System.out.println("Y point of Removebox: "+rect.getY());
		System.out.println("Height of the removebox: "+rect.getHeight());
		System.out.println("Width of the removebox: "+rect.getWidth());
		
		//Verify alert before clicking Apply Coupon

        boolean alertPresentBefore = false;
        try {
            driver.switchTo().alert();
            alertPresentBefore = true;
        } catch (Exception e) {
            alertPresentBefore = false;
        }

        if (alertPresentBefore) {
            System.out.println("Alert is displayed BEFORE clicking Apply Coupon");
        } else {
            System.out.println("Alert is NOT displayed BEFORE clicking Apply Coupon");
        }
        
        // Click Apply Coupon

        driver.findElement(By.name("applydiscountcouponcode")).click();
        Thread.sleep(1000);

        // After clicking Apply Coupon

        WebElement message = driver.findElement(By.className("message"));

        if (message.isDisplayed()) {
            System.out.println("Alert message is visible AFTER clicking Apply Coupon");
            System.out.println("Message: " + message.getText());
        } else {
            System.out.println("Alert message is NOT visible AFTER clicking Apply Coupon");
        }

		//Taking the Screenshot of the Added Laptop To the Cart
        WebElement img = driver.findElement(By.xpath("//div[@class='page shopping-cart-page']/descendant::img[@alt='Picture of 14.1-inch Laptop']"));
		File src=img.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/laptop.png");
		FileHandler.copy(src, dest);
		
		
		
	}

}
