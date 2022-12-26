package seleniumbrowserStack;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class LaunchingSampleUrl {
	@Test
public void launching() throws MalformedURLException {
		
		URL url=new URL("http://hub.browserstack.com/wd/hub");
		
		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability("browserstack.user", "keshavaraj_LxpJA3");
		ds.setCapability("browserstack.key", "GPfd3yNZDPi7DujQkLbE");
	    ds.setCapability("os", "Windows");
	    ds.setCapability("os_version", "10");
	    ds.setBrowserName("chrome");
		ds.setCapability("project", "Project");
		ds.setCapability("build", "browserstack-build");
		ds.setCapability("name", "test");
		
		WebDriver driver = new RemoteWebDriver(url,ds);
		driver.manage().window().maximize();
	    driver.get("https://www.facebook.com/");
	    driver.quit();
}
}
