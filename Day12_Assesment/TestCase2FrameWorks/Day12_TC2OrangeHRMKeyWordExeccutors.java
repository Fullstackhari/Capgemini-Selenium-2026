package Day12_Frameworks;

import org.openqa.selenium.WebDriver;

public class Day12_TC2OrangeHRMKeyWordExeccutors {
	 Day12_TC2OrangeHRMKeyWordImplementation tc2;

	 public Day12_TC2OrangeHRMKeyWordExeccutors(WebDriver driver) {
	        tc2 = new Day12_TC2OrangeHRMKeyWordImplementation(driver);
	    }
	public void tc2Executors(String keyword) {
		if(keyword.equals("OpenUrl")) {
			tc2.openurl();
		}else if(keyword.equals("Username")) {
			tc2.username();
		}else if(keyword.equals("Pass")) {
			tc2.pass();
		}else if(keyword.equals("LoginBtn")) {
			tc2.loginbtn();
		}
	}
}
