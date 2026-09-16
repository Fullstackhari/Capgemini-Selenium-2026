package Day8PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom_Candidates {
	WebDriver driver;
	public Pom_Candidates(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//cadidate 
	@FindBy(xpath="//a[text()=\"Candidates\"]")
	private WebElement candidate;
	
	@FindBy(xpath="//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"][1]")
	private WebElement jobdrop;
	
	@FindBy(xpath="//i[@class=\"oxd-icon bi-caret-up-fill oxd-select-text--arrow\"]/ancestor::div[@class=\"oxd-grid-4 orangehrm-full-width-grid\"]/descendant::span[text()=\"Payroll Administrator\"]")
	private WebElement jobT;
	
	@FindBy(xpath="(//div[@class=\"oxd-select-text-input\"])[2]")
	private WebElement cvacancydrop;
	
	@FindBy(xpath="//i[@class=\"oxd-icon bi-caret-up-fill oxd-select-text--arrow\"]/ancestor::div[@class=\"oxd-select-text oxd-select-text--focus\"]/following-sibling::div/descendant::span[text()=\"Payroll Administrator\"]")
	private WebElement cvacancy;
	
	@FindBy(xpath="(//div[@class=\"oxd-select-text-input\"])[3]")
	private WebElement HMDrop;
	
	@FindBy(xpath="(//div[@class=\"oxd-select-text-input\"])[3]/parent::div/following-sibling::div/descendant::span[text()=\"Test User\"]")
	private WebElement hM;
	
	
	@FindBy(xpath="(//div[@class=\"oxd-select-text-input\"])[4]")
	private WebElement statusdrop;
	
	@FindBy(xpath="(//div[@class=\"oxd-select-text-input\"])[4]/parent::div/following-sibling::div/descendant::span[text()=\"Application Initiated\"]")
	private WebElement status;
	
	@FindBy(xpath="//input[@placeholder=\"Type for hints...\"]")
	private WebElement cname;
	
	@FindBy(xpath="(//input[@placeholder=\"From\"])")
	private WebElement caldrop;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement search;
	
	@FindBy(xpath="//div[@class=\"oxd-table-body\"]/descendant:::div[text()=\"C Harindra\"]")
	private WebElement applicant;
	
	@FindBy(xpath="//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")
	private WebElement logdrop;
	
	@FindBy(xpath="//a[@class=\"oxd-userdropdown-link\" and text()=\"Logout\"]")
	private WebElement logout;

	@FindBy(xpath="//span[text()='(1) Record Found']")
	private WebElement record;
	
	@FindBy(xpath="(//div[@class='oxd-table-row oxd-table-row--with-border'])[2]/descendant::div[@role='cell']/descendant::div[text()]\"")
	private WebElement recorddetails;
	
	public void getCandidate() {
		 candidate.click();;
	}
	
	public void getJobDrop() {
		 jobdrop.click();
	}

	public void getJobT() {
		 jobT.click();
	}
	
	public void getCvacancyDrop() {
		cvacancydrop.click();
	}
	
	public void getCvacancy() {
		 cvacancy.click();;
	}

	public void getHMDrop() {
		HMDrop.click();
	}	
	
	public void gethM() {
		 hM.click();;
		 
	}

	public void getStatusDrop() {
		statusdrop.click();
	}
	
	public void getStatus() {
		 status.click();
	}
	
	public void getCName(String v) {
		 cname.sendKeys(v);
	}
	public void getdate() {
		 caldrop.sendKeys("2026-09-09");
	}
	
	public void getSearch() throws InterruptedException {
		 search.click();
		 Thread.sleep(3000);
	}

	public void getRecord() {
		if(record.isDisplayed()) {
			System.out.println("Record Found Successfully");
		}else {
			System.out.println("Record Not found");
		}
	}

	public void getRecorddetails() {
		System.out.println("-------------Record Details are--------------");
		List<WebElement> recordetails = driver.findElements(By.xpath("(//div[@class='oxd-table-row oxd-table-row--with-border'])[2]/descendant::div[@role='cell']/descendant::div[text()]"));
		for(WebElement ele:recordetails) {
				System.out.println(ele.getText());
		}
	}
	
	
}
