package blueocean.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import blueOcean.EnterSDAndSearchBanPage;

public class SearchBanInSD {

	public WebDriver driver;
	
	@Test
	public void sdBanSearch() {
		
		System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Drivers\\IEDriverServer.exe");
		DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
		capab.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);

		capab.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,
				true);
		capab.setCapability(
				InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
		capab.setCapability(
				InternetExplorerDriver.IE_USE_PRE_PROCESS_PROXY, true);

		driver = new InternetExplorerDriver(capab);
		driver.get("https://smartdesktop-pt168.tmi.telus.com/");
		
		System.out.println("Browser is launched");
			
		EnterSDAndSearchBanPage bansearch = PageFactory.initElements(driver, EnterSDAndSearchBanPage.class);
		
		bansearch.loginHabitat();
		
		System.out.println("Logged into Ban search page");
		
		bansearch.enterSD();
		
		System.out.println("Entered SD page with the searched ban");
	}
	
}
