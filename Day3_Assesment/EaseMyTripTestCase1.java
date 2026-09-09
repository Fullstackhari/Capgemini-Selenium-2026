package Day3_Assesment;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

class EaseMyTripTestCase1 {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.easemytrip.com/");
		Thread.sleep(3000);
		
		//Selecting the city in "from"
		driver.findElement(By.id("FromSector_show")).click();
		driver.findElement(By.id("a_FromSector_show")).sendKeys("Banglore");
		Thread.sleep(2000);
		List<WebElement> Fromcities = driver.findElements(By.id("fromautoFill"));
		for(WebElement city:Fromcities) {
			if(city.getText().contains("Mys")) {
				city.click();
				break;
			}
		}
		
		//selecting the city from the "to"
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[id=\"a_Editbox13_show\"]")).sendKeys("chennai");
		Thread.sleep(2000);
		List<WebElement> ToCities =driver.findElements(By.id("toautoFill"));
		for (WebElement city1 : ToCities) {
		    if (city1.getText().contains("Pu")) {
		        city1.click();
		        break;
		    }
		}
		
		//selecting the departure date using actions
		Thread.sleep(2000);	
		WebElement date = driver.findElement(By.xpath("//li[contains(@id,'17/09/2026')]"));
		Actions ac1 = new Actions(driver);
		ac1.moveToElement(date).click().perform();
		
		//clicking Traveller & Class and  2 Adults and keep the class as Economy
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[id=\"trvlr_colm\"]")).click();
		driver.findElement(By.id("add")).click();
		Thread.sleep(2000);
		WebElement classs = driver.findElement(By.id("lbEconomy"));
		if (classs.isSelected()) {
		    System.out.println("Economy is already selected");
		} else {
		    classs.click();
		    System.out.println("Economy was not selected, so it is selected now");
		}
		
		//clicking on the done button
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[id=\"traveLer\"]")).click();

		System.out.println("--------Parent window title------------");
		System.out.println(driver.getTitle());

		
		//clicking on search 
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[class=\"srchBtnSe\"]")).click();
		
		
		
		//validating the child window after clicking search by fetching the title of the child window
		System.out.println("--------Child window title------------");
		Set<String> allids=driver.getWindowHandles();
		for(String id:allids) {
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains("https://www.easemytrip.com/flight-search")) {
				System.out.println(driver.getTitle());
			}
		}
	}
}
