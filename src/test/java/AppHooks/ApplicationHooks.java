package AppHooks;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.TakeScreenShot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private DriverFactory driverFactory ;
	private ConfigReader configReader;
	private WebDriver driver ;
	Properties prop ;
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = 	configReader.init_prop();
	}
	@Before(order =1)
	public void launchBrowser() {
		String BrowserName	= prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(BrowserName);
	}
	
	@After(order = 0)
	public void  quitBrowser(){
		
		driver.quit();
	
	}
	
	@After(order = 1)
	public void takeScreenshot(Scenario scenario) throws IOException {
		
		if(scenario.isFailed()) {
			
			
			TakeScreenShot.getScreenShot(driver,"screesnshot");
			
			
		}
		
		
		
	}
}
