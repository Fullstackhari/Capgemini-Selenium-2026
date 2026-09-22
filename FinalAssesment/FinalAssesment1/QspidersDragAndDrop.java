package FinalAssesment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class QspidersDragAndDrop {
	@Test
	public void DragAndDrop() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToMultiple?sublist=3");
		Thread.sleep(2000);
		WebElement LapCharger = driver.findElement(By.xpath("//div[text()='Laptop Charger']"));
		WebElement LapAccesories = driver.findElement(By.xpath("//div[@class=' dropzone drop-column min-h-[200px] bg-slate-100']/descendant::div"));
		LapCharger.click();
		Actions act=new Actions(driver);
		act.clickAndHold(LapCharger).moveToElement(LapAccesories).release().perform();
		Thread.sleep(3000);
		WebElement LapCover = driver.findElement(By.xpath("//div[text()='Laptop Cover']"));
		LapCover.click();
		Actions act1=new Actions(driver);
		act1.clickAndHold(LapCover).moveToElement(LapAccesories).release().perform();
		Thread.sleep(3000);
		
		
		WebElement MobCharger = driver.findElement(By.xpath("//div[text()='Mobile Charger']"));
		WebElement MobAccesories = driver.findElement(By.xpath("//div[@class=' dropzone drop-column  min-h-[200px] bg-slate-100']/descendant::div"));
		MobCharger.click();
		Actions act2=new Actions(driver);
		act.clickAndHold(MobCharger).moveToElement(MobAccesories).release().perform();
		Thread.sleep(3000);
		WebElement MobCover = driver.findElement(By.xpath("//div[text()='Mobile Cover']"));
		MobCover.click();
		Actions act3=new Actions(driver);
		act1.clickAndHold(MobCover).moveToElement(MobAccesories).release().perform();

		
	}
}
