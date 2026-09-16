package Day9_Assesment;

import SauceDemoKeyWordUtil.SauceDemoKeyWordExecutors;

public class SauceDemoKeywords {
	public static void main(String[] args) throws InterruptedException {
		SauceDemoKeyWordExecutors s=new SauceDemoKeyWordExecutors();
		s.sauceexecutors("LaunchBrowser");
		s.sauceexecutors("OpenUrl");
		s.sauceexecutors("UserName");
		s.sauceexecutors("Password");
		Thread.sleep(2000);
		s.sauceexecutors("LoginBtn");
		Thread.sleep(2000);
		s.sauceexecutors("CloseBrowser");
	}
}
