package SauceDemoKeyWordUtil;

public class SauceDemoKeyWordExecutors {
	SauceDemoKeyWordImplementation s= new SauceDemoKeyWordImplementation();
	public void sauceexecutors(String keyword) {
		if(keyword.equals("LaunchBrowser")) {
			s.launchBrowser();
		}else if(keyword.equals("OpenUrl")) {
			s.openurl();
		}else if(keyword.equals("UserName")) {
			s.username();
		}else if(keyword.equals("Password")) {
			s.password();
		}else if(keyword.equals("LoginBtn")) {
			s.loginbtn();
		}else if(keyword.equals("CloseBrowser")) {
			s.closeBrowser();
			
		}
	}
}
