package Day10_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

public class SauceDemoTestNgAnnotataions {
	
	WebDriver driver=null;
	
	@BeforeSuite
	public void DataBaseEstablishment() {
		System.out.println("DataBase Connectivity Established");
	}
	
	@BeforeTest
	public void BT() {
		System.out.println("Pre Conditions");
	}
	
	@BeforeClass
	public void CrossBrowserTest() throws IOException {
		// Avoid Change Password popup
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		FileInputStream file=new FileInputStream("./src/main/java/Day10_Utilities/SauceDemo.properties");
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
		FileInputStream file=new FileInputStream("./src/main/java/Day10_Utilities/SauceDemo.properties");
		Properties pl=new Properties();
		pl.load(file);
		String url = pl.getProperty("url");
		String username = pl.getProperty("username");
		String pass = pl.getProperty("pass");
		
		SauceDemoLoginPomPage sd= new SauceDemoLoginPomPage(driver);
		driver.get(url);
		sd.getUsername(username);
		sd.getPass(pass);
		Thread.sleep(2000);
		sd.getLoginbtn();
		System.out.println("Login Succesfull");
		sd.getProductpage();
		
	}
	
	@BeforeMethod(dependsOnMethods = "LoginTest")
	public void oderPalcementTest() throws InterruptedException, EncryptedDocumentException, IOException {
		FileInputStream excel=new FileInputStream("./src/main/java/Day10_Utilities/SauceDemoDay10.xlsx");
		Workbook wb = WorkbookFactory.create(excel);
		String firstname = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String lasttname = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		DataFormatter formatter = new DataFormatter();
		String zipcode = formatter.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(2));
		SauceDemoProductPomPage pp=new SauceDemoProductPomPage(driver);
		pp.getProductAddtoCart();
		pp.getOneItemInProduct();
		Thread.sleep(2000);
		pp.getAddTocartbtn();
		pp.getProductNameVerification();
		Thread.sleep(2000);
		pp.getCheckOutBtn();
		Thread.sleep(1000);
		pp.getCheckoutFirstname(firstname);
		Thread.sleep(500);
		pp.getCheckoutLastname(lasttname);
		Thread.sleep(500);
		pp.getCheckoutPostal(zipcode);
		Thread.sleep(1000);
		pp.getContinue();
		pp.getCheckoutpagevalidation();
		Thread.sleep(1000);
		pp.getFinishBtn();
		pp.getThankyouMessage();
		System.out.println("Successfully completed order placement");
		Thread.sleep(2000);
		
	}
	
	@AfterMethod
	public void LogoutTest() throws InterruptedException {
		SauceDemoLogoutPomPage lo=new SauceDemoLogoutPomPage(driver);
		lo.getHamburgerbtn();
		Thread.sleep(2000);
		lo.getLogoutbtn();
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
