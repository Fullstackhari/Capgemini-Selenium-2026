package Day5_Assesment;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoAppQSpidersLoginUsingJsonFile_TestCase3 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		FileReader  file= new FileReader("./src/test/resources/DataDrivenTesting/DemoQspiders.json");
		JSONParser j= new JSONParser();
		//creating object for the JsonObject
		Object obj = j.parse(file);
		//DownCasting the Json object to java object
		JSONObject json = (JSONObject)obj;
		
		//Fetching/reading the credentials from the json file
		String browser = json.get("browser").toString();
		String url = json.get("url").toString();
		String name = json.get("name").toString();
		String mail = json.get("email").toString();
		String password = json.get("pass").toString();
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		Thread.sleep(2000);
		
		//Register phase
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("email")).sendKeys(mail);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[type='submit']")).submit();
		
		Thread.sleep(2000);
		//Login phase
		driver.findElement(By.id("email")).sendKeys(mail);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[type='submit']")).submit();

		

	}

}
