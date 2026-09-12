package Day6_Assesment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HandlingOrangeHRMUsingPropertyandExcelFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Reading the Common Data from the Properties file
		FileInputStream file= new FileInputStream("./src/test/resources/DataDrivenFramework/OrangeHRMLogin.properties");
		Properties p=new Properties();
		p.load(file);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String pass = p.getProperty("pass");
		
		//Reading the Test script data from the Excel File 
		FileInputStream file2 = new FileInputStream("./src/test/resources/DataDrivenFramework/OrangeHRMExcelFile.xlsx");
		Workbook wb = WorkbookFactory.create(file2);
		
		String firstname = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String lastname = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String pusername = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String empname = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		String pimpass = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		
		// Avoiding Change Password popup
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[name='username']")).sendKeys(username);
		driver.findElement(By.cssSelector("[name='password']")).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[type='submit']")).submit();
		
		//Clicking on PIM link -> click on +Add button ->entering First name, Last name , EmployeeId 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']/descendant::a[@href='/web/index.php/pim/viewPimModule']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		Thread.sleep(8000);
		driver.findElement(By.cssSelector("[name='firstName']")).sendKeys(firstname);
		driver.findElement(By.cssSelector("[name='lastName']")).sendKeys(lastname);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::span")).click();
		
		//clicking on Create Login Details toggle button and entering user name , password and confirm password and click on save button
		Thread.sleep(3000);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(pimpass);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(pimpass);
		Thread.sleep(1000);
		driver.findElement(By.xpath("((//div[@class='oxd-form-row'])[2]/descendant::div[@class='oxd-input-group oxd-input-field-bottom-space']/descendant::input)[1]")).sendKeys(pusername);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=' Save ']")).submit();
		
		//clicking on Admin link and enter user name , selecting role ,entering employee name and select status and clicking on search button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']/descendant::a[@href='/web/index.php/admin/viewAdminModule']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='oxd-table-filter-area']/descendant::div[@class='oxd-grid-item oxd-grid-item--gutters'])[1]/descendant::input")).sendKeys(pusername);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='oxd-select-wrapper']/descendant::i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])")).click();
		WebElement role = driver.findElement(By.xpath("//span[text()='ESS']"));
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		act.click(role).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]")).sendKeys(empname);
		Thread.sleep(2000);
		WebElement emp=driver.findElement(By.xpath("//div[@role='listbox']"));
		Actions ac1=new Actions(driver);
		ac1.moveToElement(emp, 20, 10).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='oxd-select-wrapper']/descendant::i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")).click();
		WebElement status = driver.findElement(By.xpath("//span[text()='Enabled']"));
		Actions act1=new Actions(driver);
		Thread.sleep(2000);
		act1.click(status).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()=' Search ']")).submit();
		
		//Validation of the Record Details 
		Thread.sleep(2000);
		WebElement recordfound = driver.findElement(By.xpath("//span[text()='(1) Record Found']"));
		if(recordfound.isDisplayed()) {
			System.out.println("Record Found Successfully");
		}else {
			System.out.println("Record Not found");
		}
		
		//Fetching the each record details
		Thread.sleep(1000);
		List<WebElement> recordetails = driver.findElements(By.xpath("(//div[@class='oxd-table-row oxd-table-row--with-border'])[2]/descendant::div[@role='cell']/descendant::div[text()]"));
		System.out.println("-------------Record Details are--------------");
		for(WebElement ele:recordetails) {
				System.out.println(ele.getText());
		}
	}

}
