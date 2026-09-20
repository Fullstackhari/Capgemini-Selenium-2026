package Day12_Assesment;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Day12_Frameworks.OrangeHRMDashboardPOMPage;
import Day12_Frameworks.OrangeHRMRecruitmentPOMpage;
import Day12_Frameworks.OrangeHRMVacanciesPOMpage;
import Day12_Frameworks.TestCase1_TestngAnnotations;
import junit.framework.Assert;

public class HandlingOrangeHRMUsingFrameWorkTestCase_1  extends TestCase1_TestngAnnotations{
	@Test
	public void TestingORangeHRM() throws EncryptedDocumentException, IOException, InterruptedException {
		WebElement DashboardText = driver.findElement(By.cssSelector("[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
		Assert.assertEquals(DashboardText.getText(), "Dashboard");
		System.out.println("Dashboard Displayed Successfully");
		OrangeHRMDashboardPOMPage dsh=new OrangeHRMDashboardPOMPage(driver);
		dsh.getRecurtBtn();
		WebElement RecruitText = driver.findElement(By.cssSelector("[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
		Assert.assertEquals(RecruitText.getText(), "Recruitment");
		System.out.println("Recruitment Page Displayed Successfully");
		OrangeHRMRecruitmentPOMpage rp= new OrangeHRMRecruitmentPOMpage(driver);
		rp.getVacanciebtn();
		rp.getAddbtn();
		WebElement vacancyText = driver.findElement(By.cssSelector("[class='oxd-text oxd-text--h6 orangehrm-main-title']"));
		Assert.assertEquals(vacancyText.getText(), "Add Vacancy");
		System.out.println("Vacancy Page Displayed Successfully");
		FileInputStream excel=new FileInputStream("./src/test/resources/Day12_FrameWorkFiles/HandlingHRMUSingFrameWorks.xlsx");
		Workbook wb = WorkbookFactory.create(excel);
		Sheet sh = wb.getSheet("Sheet1");
		String vcancyname = sh.getRow(1).getCell(0).getStringCellValue();
		String desc = sh.getRow(1).getCell(1).getStringCellValue();
		DataFormatter formatter = new DataFormatter();
		String Noofvacancies = formatter.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(2));
		String hr = sh.getRow(1).getCell(3).getStringCellValue();
		OrangeHRMVacanciesPOMpage vp= new OrangeHRMVacanciesPOMpage(driver);
		vp.getVacancyname(vcancyname);
		Thread.sleep(1000);
		vp.getJobtitledropdown();
		Thread.sleep(1000);
		vp.getJobrole();
		Thread.sleep(1000);
		vp.getDescription(desc);
		Thread.sleep(1000);
		vp.getHR(hr);
		Thread.sleep(2000);
		vp.getHrrole();
		Thread.sleep(1000);
		vp.getNoofvacancies(Noofvacancies);
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		act.scrollByAmount(0, 1000).perform();
		vp.getSavebtn();
		Thread.sleep(2000);
		System.out.println("Vacancies Added successfully");
	}
}
