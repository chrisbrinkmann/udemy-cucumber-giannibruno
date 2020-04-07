package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
	protected static WebDriver driver;
	private static String browserName;

	public static WebDriver getDriver() {
		// Read from config properties file
		try {
			ReadConfigFile configReader = new ReadConfigFile();
			browserName = configReader.getProperty("browser.name");
			
			System.out.println("!!!BROWSERNAME: " + browserName);

			switch (browserName) {

			case "firefox":
				if (driver == null) {
					System.setProperty("webdriver.gecko.driver",
							Constant.GECKO_DRIVER_PATH);
					DesiredCapabilities capabilities = DesiredCapabilities
							.firefox();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();
				}
				break;
			case "chrome":
				if (driver == null) {
					System.setProperty("webdriver.chrome.driver",
							Constant.CHROME_DRIVER_PATH);
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Big exception!");
			e.printStackTrace();
		} finally {
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		return driver;
	}
}
