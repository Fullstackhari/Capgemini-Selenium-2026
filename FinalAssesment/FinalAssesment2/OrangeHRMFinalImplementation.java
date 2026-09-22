package FinalAssesment2;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import FinalAssesments_Utili.FinalAssesment2_testngNotations;
import FinalAssesments_Utili.OrangeHRMBuzzPomPage;
import FinalAssesments_Utili.OrangeHRMDashBoardPOMPage;
import junit.framework.Assert;

public class OrangeHRMFinalImplementation extends FinalAssesment2_testngNotations{
	@Test
	public void FinalImplenation() throws InterruptedException, EncryptedDocumentException, IOException {
		OrangeHRMDashBoardPOMPage dp= new OrangeHRMDashBoardPOMPage(driver);
		dp.getBuzbtn();
		System.out.println("Buzz Page Displayed Successfully");
		WebElement buzztext = driver.findElement(By.cssSelector("[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
		Assert.assertEquals(buzztext.getText(), "Buzz");
		System.out.println("Buzz Page Displayed Successfully");
		Thread.sleep(2000);
		FileInputStream excel= new FileInputStream("./src/test/resources/FileAssesment2Files/OrangeHRMFinalAssesment2.xlsx");
		Workbook wb = WorkbookFactory.create(excel);
		Sheet sh = wb.getSheet("Sheet1");
		String buzztxt = sh.getRow(1).getCell(0).getStringCellValue();
		OrangeHRMBuzzPomPage bp= new OrangeHRMBuzzPomPage(driver);
		bp.getBuzztextfield(buzztxt);
		Thread.sleep(2000);
		bp.getPostbtn();
		Thread.sleep(3000);
		WebElement Recentpost = driver.findElement(By.xpath("//div[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/descendant::p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text']"));
		Assert.assertEquals(Recentpost.getText(), "EAT LUV LIV…");
		System.out.println("Posted Succesfully");
		System.out.println("Posted Text Is");
		System.out.println(Recentpost.getText());
	}
}
