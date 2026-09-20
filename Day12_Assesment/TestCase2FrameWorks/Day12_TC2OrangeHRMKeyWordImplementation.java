package Day12_Frameworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Day12_TC2OrangeHRMKeyWordImplementation {
	protected WebDriver driver;
	 public Day12_TC2OrangeHRMKeyWordImplementation(WebDriver driver) {
	        this.driver = driver;
	    }
	
	public void openurl() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	public void username() {
		driver.findElement(By.cssSelector("[name='username']")).sendKeys("Admin");
	}
	
	public void pass() {
		driver.findElement(By.cssSelector("[name='password']")).sendKeys("admin123");
	}
	
	public void loginbtn() {
		driver.findElement(By.cssSelector("[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).submit();
	}

}
