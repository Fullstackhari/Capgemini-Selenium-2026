package SauceDemoKeyWordUtil;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoKeyWordImplementation {
	WebDriver driver;
	public void launchBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void openurl() {
		driver.get("https://www.saucedemo.com/");
	}
	
	public void username() {
		driver.findElement(By.id("user-name")).sendKeys("problem_user");
	}
	
	public void password() {
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}
	
	public void loginbtn() {
		driver.findElement(By.id("login-button")).submit();
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
}
