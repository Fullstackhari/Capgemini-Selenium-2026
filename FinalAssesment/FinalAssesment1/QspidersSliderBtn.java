package FinalAssesment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class QspidersSliderBtn {
	@Test
	public void QspidersSLider() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/slider");
		Thread.sleep(2000);
		WebElement slider = driver.findElement(By.cssSelector("[class='rangeInputSlidebar absolute top-0 left-0 w-full mx-[1px]']"));
		Actions act= new Actions(driver);
		Thread.sleep(1000);
		act.clickAndHold(slider).moveByOffset(200,0).release().perform();
		boolean menjacket = driver.findElement(By.xpath("//h3[@class='text-sm font-bold pb-1' and text()='Mens Cotton Jacket']")).isDisplayed();
		System.out.println(menjacket);
		System.out.println("Scrolled till Men Jacket");
	}
}
