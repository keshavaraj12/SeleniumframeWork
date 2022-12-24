package seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launching_Browser {
	@Parameters({"browser"})
	@Test
	public void lanchbrowser(String browser) throws MalformedURLException {
			URL url=new URL("http://192.168.43.222:4444/wd/hub");
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new RemoteWebDriver(url,dc);
			driver.manage().window().maximize();
			driver.get("https://www.amazon.in/");
		driver.quit();
	}
}
