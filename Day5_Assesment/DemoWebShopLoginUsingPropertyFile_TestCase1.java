package Day5_Assesment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoWebShopLoginUsingPropertyFile_TestCase1 {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileInputStream file =new FileInputStream("./src/test/resources/DataDrivenTesting/LoginCreden.properties");
		//Reading the Properties File
		Properties p=new Properties();
		p.load(file);
		
		//Fetching all the properties from property file using getProperty
		String browser = p.getProperty("browser");
		String email = p.getProperty("email");
		String pass = p.getProperty("pass");
		String url = p.getProperty("url");
		String fname = p.getProperty("firstname");
		String lname = p.getProperty("lastname");
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		Thread.sleep(2000);
		
		//Registering before log in
		driver.findElement(By.linkText("Register")).click();	
		Thread.sleep(1000);
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys(fname);
		driver.findElement(By.id("LastName")).sendKeys(lname);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pass);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(By.id("register-button")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[class=\"button-1 register-continue-button\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(1000);
		
		//Logging in to the WebShopDemoApp after registering the DemoWebShopApp
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pass);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[class=\"button-1 login-button\"]")).submit();
		
		
	}
}
