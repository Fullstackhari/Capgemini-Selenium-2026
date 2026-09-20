package Day12_Frameworks;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestCase2_TestngAnnotations {
	protected WebDriver driver=null;
	@BeforeSuite
	public void DBTest() {
		System.out.println("DataBase Connectivity Established");
	}
	
	@BeforeTest
	public void PCTest() {
		System.out.println("Pre Conditions");
	}
	
	@BeforeClass
	public void CrossBrowserTest() throws IOException {
		// Avoid Change Password popup
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		FileInputStream file=new FileInputStream("./src/test/resources/Day12_FrameWorkFiles/Day12_TestCase2.properties");
		Properties p=new Properties();
		p.load(file);
		String browser = p.getProperty("browser");
		if(browser.equals("chrome")) {
			driver=new ChromeDriver(settings);
		}else if(browser.equals("edge")) {
			driver= new EdgeDriver();
		}else if(browser.equals("FireFox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("Luanched Browser Successfully");
		
	}
	
	@BeforeMethod
	public void LoginTest() throws InterruptedException, IOException {
		Day12_TC2OrangeHRMKeyWordExeccutors exe=new Day12_TC2OrangeHRMKeyWordExeccutors(driver);
		exe.tc2Executors("OpenUrl");
		exe.tc2Executors("Username");
		exe.tc2Executors("Pass");
		exe.tc2Executors("LoginBtn");
		System.out.println("Login Succesfull");
		
	}
	
	@AfterMethod
	public void LogoutTest() throws InterruptedException {
		OrangeHRMDashboardPOMPage dp= new OrangeHRMDashboardPOMPage(driver);
//		dp.getLogoudropdowntbtn();
//		Thread.sleep(1000);
//		dp.getLogoutChoice();
		System.out.println("Logout Succesfull");
	}
	
	
	@AfterClass
	public void BrowserClosingTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Browser Closed successfully");
	}
	
	@AfterTest
	public void at() {
		System.out.println("Post Conditions");
	}
	
	@AfterSuite
	public void DataBaseClosing() {
		System.out.println("DataBase Connectivity closed");
	}
}
