package Day1_Assesment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class SauceDemoJavaScriptExecutorTestCase {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("user-name")).sendKeys("problem_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		//Taking  action on the login button using the Submit method
		driver.findElement(By.id("login-button")).submit();
		
		//TypeCasting WebDriver to JavaScriptExecutor
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		//Scrolling using window.scrollBy to the end of the WebPage
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(2000);
		
		//TypeCasting WebDriver to TakeScreenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/products-page.png");
		FileHandler.copy(src, dest);
		
		Thread.sleep(2000);
		driver.quit();

	}

}
