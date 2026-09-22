package FinalAssesment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class QspidersDisabledToggleBtn {
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapps.qspiders.com/ui/toggle?sublist=0");
	driver.findElement(By.linkText("Disabled")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//label[@class='inline-flex items-center cursor-not-allowed'])[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//label[@class='inline-flex items-center cursor-not-allowed'])[2]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//label[@class='inline-flex items-center cursor-not-allowed'])[3]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//label[@class='inline-flex items-center cursor-not-allowed'])[4]")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("togglers")).click();
	WebElement ordertext = driver.findElement(By.cssSelector("[class='text-lg text-orange-600 font-bold text-center']"));
	Assert.assertEquals(ordertext.getText(), "ORDER PLACED");
	System.out.println(ordertext.getText());
	System.out.println("Order Placed Successfully");
	}
}
