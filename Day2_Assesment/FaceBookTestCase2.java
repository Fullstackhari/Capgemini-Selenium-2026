package Day2_Assesment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBookTestCase2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		//Fetching location of the Create New Account Button
		Point createaccLoc = driver.findElement(By.cssSelector("[aria-label=\"Create new account\"]")).getLocation();
		System.out.println("Create new Account Location:"+createaccLoc);
		System.out.println(createaccLoc.getX());
		System.out.println(createaccLoc.getY());
		
		WebElement EmailDom = driver.findElement(By.id("_R_1h6kqsqppb6amH1_"));
		//DOM Attribute and Property before entering Email Address
		System.out.println(EmailDom.getDomAttribute("name"));
		System.out.println(EmailDom.getDomProperty("name"));
		EmailDom.sendKeys("hari@gmail.com");
		//DOM Attribute and Property After entering Email Address
		System.out.println(EmailDom.getDomAttribute("name"));
		System.out.println(EmailDom.getDomProperty("name"));
		
		driver.findElement(By.cssSelector("[aria-label=\"Create new account\"]")).click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		//Fetching the Size of the Submit/SignupButton
		WebElement Submitbtn = driver.findElement(By.xpath("(//span[text()='Submit'])[2]"));
		Dimension size = Submitbtn.getSize();
		System.out.println("Submit button width:"+size.getWidth());
		System.err.println("Submit button:"+size.getHeight());
		
		//Fetching the CSS properties of Submit/SignupButton
		System.out.println(Submitbtn.getCssValue("text-align"));
		System.out.println(Submitbtn.getCssValue("font-family"));
		System.out.println(Submitbtn.getCssValue("background-color"));
		System.out.println(Submitbtn.getCssValue("padding-inline-end"));
		

	}

}
