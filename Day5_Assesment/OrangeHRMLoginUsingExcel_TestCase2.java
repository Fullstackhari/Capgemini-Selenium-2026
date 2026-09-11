package Day5_Assesment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHRMLoginUsingExcel_TestCase2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream file= new FileInputStream("./src/test/resources/DataDrivenTesting/ExcelOrangeHRM.xlsx");
		
		//Reading the File from the Excel file 
		Workbook wb = WorkbookFactory.create(file);
		
		//Fetching  all the credentials from the Excel sheet according to the 
		String browser = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String url = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String username = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String pass = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		
		//Fetching the Locator values form the Excel Sheet
		String usernameloc = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		String passloc = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
		String loginloc = wb.getSheet("Sheet1").getRow(1).getCell(6).getStringCellValue();
		
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("Edge")) {
			driver=new EdgeDriver();
		}else if(browser.equals("Firefox")) {
			driver=new FirefoxDriver();
		}
		
		//performing actions on the OrnageHRM By reading the data from the Excel Sheet
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.name(usernameloc)).sendKeys(username);
		driver.findElement(By.name(passloc)).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(loginloc)).submit();
		
		
	}

}
