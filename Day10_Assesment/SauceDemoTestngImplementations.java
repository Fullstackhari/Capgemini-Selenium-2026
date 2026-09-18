package Day10_Assesment;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Day10_Utilities.SauceDemoCartPomPage;
import Day10_Utilities.SauceDemoCheckOutPompage;
import Day10_Utilities.SauceDemoProductPomPage;
import Day10_Utilities.SauceDemoTestNgAnnotataions;

public class SauceDemoTestngImplementations extends SauceDemoTestNgAnnotataions {
	@Test
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
		
		SauceDemoCartPomPage cp=new SauceDemoCartPomPage(driver);
		cp.getProductNameVerification();
		Thread.sleep(2000);
		cp.getCheckOutBtn();
		Thread.sleep(1000);
		SauceDemoCheckOutPompage cop=new SauceDemoCheckOutPompage(driver);
		cop.getCheckoutFirstname(firstname);
		Thread.sleep(500);
		cop.getCheckoutLastname(lasttname);
		Thread.sleep(500);
		cop.getCheckoutPostal(zipcode);
		Thread.sleep(1000);
		cop.getContinue();
		cop.getCheckoutpagevalidation();
		Thread.sleep(1000);
		cop.getFinishBtn();
		pp.getThankyouMessage();
		System.out.println("Successfully completed order placement");
		Thread.sleep(2000);
		
	}
}
