package Day12_Assesment;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Day12_Frameworks.Day12_TC2OrangeHRMKeyWordExeccutors;
import Day12_Frameworks.OrangeHRMTC2DashBoardPOMPage;
import Day12_Frameworks.OrangeHRMTC2PIMPomPAge;
import Day12_Frameworks.TestCase2_TestngAnnotations;
import junit.framework.Assert;

public class HandlingOrangeHRMUsingFrameWorksTestCase_2 extends TestCase2_TestngAnnotations{
	@Test
	public void testcase2implmentation() throws EncryptedDocumentException, IOException, InterruptedException {
		WebElement DashboardText = driver.findElement(By.cssSelector("[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
		Assert.assertEquals(DashboardText.getText(), "Dashboard");
		System.out.println("Dashboard Displayed Successfully");
		
		OrangeHRMTC2DashBoardPOMPage dp= new OrangeHRMTC2DashBoardPOMPage(driver);
		dp.getMyinfobtn();
		WebElement PIMText = driver.findElement(By.cssSelector("[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
		Assert.assertEquals(PIMText.getText(), "PIM");
		System.out.println("PIM Page Displayed Successfully");
		
		FileInputStream excel= new FileInputStream("./src/test/resources/Day12_FrameWorkFiles/HandlingHRMUSingFrameWorks.xlsx");
		Workbook wb = WorkbookFactory.create(excel);
		Sheet sh = wb.getSheet("Sheet2");
		String fname = sh.getRow(1).getCell(0).getStringCellValue();
		String lname = sh.getRow(1).getCell(1).getStringCellValue();
		String empid = sh.getRow(1).getCell(2).getStringCellValue();
		
		OrangeHRMTC2PIMPomPAge pp=new OrangeHRMTC2PIMPomPAge(driver);
		pp.getFirstname(fname);
		Thread.sleep(1000);
		pp.getLasttname(lname);
		Thread.sleep(1000);
		pp.getEmpid(empid);
		Thread.sleep(2000);
		pp.getSavebtn();
		Thread.sleep(2000);
		System.out.println("User Details Saved Successfully");
		
		OrangeHRMTC2DashBoardPOMPage dp1= new OrangeHRMTC2DashBoardPOMPage(driver);
		dp1.getLogoudropdowntbtn();
		Thread.sleep(2000);
		dp1.getLogoutChoice();
		System.out.println("Logout successfull ");
		
		Day12_TC2OrangeHRMKeyWordExeccutors exe=new Day12_TC2OrangeHRMKeyWordExeccutors(driver);
		Thread.sleep(2000);
		exe.tc2Executors("OpenUrl");
		exe.tc2Executors("Username");
		exe.tc2Executors("Pass");
		exe.tc2Executors("LoginBtn");
		System.out.println("Login Successfull again");
		
		WebElement DashText = driver.findElement(By.cssSelector("[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
		Assert.assertEquals(DashText.getText(), "Dashboard");
		System.out.println("Again Dashboard Displayed Successfully");
		
		
		WebElement fsname = driver.findElement(By.xpath("//div[@class='oxd-topbar-header-userarea']/descendant::p[@class='oxd-userdropdown-name']"));
		Assert.assertEquals(fsname.getText(), "C Harindra");
		System.out.println("First Name And Last Name Are");
		System.out.println(fsname.getText());
		System.out.println("Details was saved successfully");
		
	}
	
	
}

