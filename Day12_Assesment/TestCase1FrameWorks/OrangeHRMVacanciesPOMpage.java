package Day12_Frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMVacanciesPOMpage {
	WebDriver driver;
	public OrangeHRMVacanciesPOMpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="(//div[@class='oxd-grid-item oxd-grid-item--gutters']/descendant::input)[1]")
	private WebElement vacancyname;
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters']/descendant::div[@class='oxd-select-wrapper']")
	private WebElement jobtitledropdown;
	
	@FindBy(css="[placeholder='Type description here']")
	private WebElement description;
	
	@FindBy(css="[placeholder='Type for hints...']")
	private WebElement HR;
	
	@FindBy(xpath="(//div[@class='oxd-grid-item oxd-grid-item--gutters']/descendant::input)[3]")
	private WebElement noofvacancies;
	
	@FindBy(xpath="//div[@role='option']/descendant::span[text()='Automaton Tester']")
	private WebElement jobrole;
	
	@FindBy(xpath="//div[@class='oxd-autocomplete-dropdown --positon-bottom']/descendant::span[text()='Orange  Test']")
	private WebElement hrrole;
	
	@FindBy(xpath="//div[@class='oxd-form-actions']/descendant::button[@type='submit']")
	private WebElement savebtn;
	public void getSavebtn() {
		savebtn.submit();
	}

	public void getHrrole() {
		hrrole.click();
	}

	public void getJobrole() {
		jobrole.click();
	}

	public void getVacancyname(String value) {
		vacancyname.sendKeys(value);;
	}

	public void getJobtitledropdown() {
		jobtitledropdown.click();
	}

	public void getHR(String value) {
		HR.sendKeys(value);
	}

	public void getDescription(String value) {
		description.sendKeys(value);;
	}

	public void getNoofvacancies(String value) {
		noofvacancies.sendKeys(value);;
	}
}
