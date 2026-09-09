package Day3_Assesment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class QspidersDemoTestcase2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
		Thread.sleep(2000);
		//Clicking on calendar
		driver.findElement(By.cssSelector("[viewBox=\"0 0 1024 1024\"]")).click();
		Thread.sleep(1000);
		
		// Navigating to the next month in the current year.
		driver.findElement(By.cssSelector("[aria-label=\"Next Month\"]")).click();
		Thread.sleep(2000);
		
		//Selecting valid date from that month.
		WebElement date = driver.findElement(By.cssSelector("[aria-label=\"Choose Friday, October 23rd, 2026\"]"));
		Actions act=new Actions(driver);
		act.moveToElement(date).click().perform();
		
		//Verify the selected date is displayed correctly in the date field.
		WebElement placeholder = driver.findElement(By.cssSelector("[placeholder=\"Select A Date\"]"));
		String selectedDate = placeholder.getAttribute("value");
        System.out.println("Selected Date: " + selectedDate);
        if (selectedDate.contains("23")) {
            System.out.println("Selected date is displayed correctly");
        } else {
            System.out.println("Selected date is NOT displayed correctly");
        }
		
	}
}
