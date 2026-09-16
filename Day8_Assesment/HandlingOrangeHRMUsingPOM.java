package Day8_Assesment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Day8PomUtilities.PomLogin;
import Day8PomUtilities.Pom_Candidates;
import Day8PomUtilities.Pom_Recruiter;

public class HandlingOrangeHRMUsingPOM {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Day8_Resources/OrangeHRMLogin.properties");
		Properties p = new Properties();
		p.load(fis);
		
		//properties file
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("pass");
		
		//excelfile
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Day8_Resources/Day8.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String FirstName = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String Lastname = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String Email = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		//double PhoneNumber = wb.getSheet("Sheet1").getRow(1).getCell(4).getNumericCellValue();
		String CName = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
			driver= new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		//login
		PomLogin p1 =new PomLogin(driver);
		p1.getUn(USERNAME);
		p1.getPwd(PASSWORD);
		p1.getLgbutton();
		
		Pom_Recruiter p2 = new Pom_Recruiter(driver);
		//click on recruiter
		p2.getRecruitmrnt();
		//click on add
		p2.getAddbutton();
		//firstname
		p2.getFname(FirstName);
		//lastname
		p2.getLname(Lastname);
		//email
		p2.getEmail(Email);
		//phno
		//p2.getPhno(PhoneNumber);
		
		//vacancy
		p2.getVacancy().click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		//resume
		Thread.sleep(5000);
		p2.getResume("C:\\Users\\harin\\OneDrive\\Desktop\\C_Harindra_Resume.pdf");
		Thread.sleep(2000);
		p2.getSave();
		
		Pom_Candidates p3 = new Pom_Candidates(driver);
		p3.getCandidate();
		
		Thread.sleep(3000);
		p3.getJobDrop();
		Thread.sleep(3000);
		p3.getJobT();
		Thread.sleep(3000);
		p3.getCvacancyDrop();
		Thread.sleep(3000);
		p3.getCvacancy();
		Thread.sleep(3000);
		p3.getHMDrop();
		Thread.sleep(3000);
		p3.gethM();
		Thread.sleep(3000);
		p3.getStatusDrop();
		Thread.sleep(3000);
		p3.getStatus();
		p3.getCName(FirstName);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		p3.getdate();
		p3.getSearch();
		
		Thread.sleep(2000);
		WebElement recordfound = driver.findElement(By.xpath("//span[text()='(1) Record Found']"));
		if(recordfound.isDisplayed()) {
			System.out.println("Record Found Successfully");
		}else {
			System.out.println("Record Not found");
		}
		
		Thread.sleep(1000);
		List<WebElement> recordetails = driver.findElements(By.xpath("(//div[@class='oxd-table-row oxd-table-row--with-border'])[2]/descendant::div[@role='cell']/descendant::div[text()]"));
		System.out.println("-------------Record Details are--------------");
		for(WebElement ele:recordetails) {
				System.out.println(ele.getText());
		}
	
		
	}
}
