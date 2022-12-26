package seleniumbrowserStack;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LaunchingInDifferentOS_VERSION_BROWSER {
	@Parameters({"osname","version","browser"})
	@Test
public void differentOSTest(String osname,String version,String browser) throws MalformedURLException {
	URL url=new URL("http://hub.browserstack.com/wd/hub");
	
	DesiredCapabilities ds = new DesiredCapabilities();
	ds.setCapability("browserstack.user", "keshavaraj_LxpJA3");
	ds.setCapability("browserstack.key", "GPfd3yNZDPi7DujQkLbE");
    ds.setCapability("os", osname);
    ds.setCapability("os_version", version);
    ds.setBrowserName(browser);
	ds.setCapability("project", "Project");
	ds.setCapability("build", "browserstack-builds");
	ds.setCapability("name", "test");
	
	WebDriver driver = new RemoteWebDriver(url,ds);
	driver.manage().window().maximize();
    driver.get("https://www.amazon.in/");
    driver.quit();
}
}
