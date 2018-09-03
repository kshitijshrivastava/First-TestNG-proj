package firsttestngpackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FailedLogin {
	public WebDriver driver;
	public String URL;
	public static final String USERNAME = "kshitij031286";
	public static final String ACCESS_KEY = "fe7b541f-4b17-4042-a788-5b7870437bb4";
	public String Node = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	@Parameters("browser")
	@BeforeTest
	public void launchbrowser(String browser) throws MalformedURLException {
		String URL = "https://myrecord.ehealthtest.health.gov.au/locallogin/login.html";

		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on FireFox");
			//String Node = "http://192.168.1.3:5566/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setCapability("platform", "macOS 10.12");
			cap.setCapability("version", "54.0");
			cap.setCapability("name", "Test on macOS - Firefox");

			driver = new RemoteWebDriver(new URL(Node), cap);
			// Puts an Implicit wait, Will wait for 10 seconds before throwing
			// exception
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Launch website
			driver.navigate().to(URL);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(" Executing on CHROME");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setCapability("platform", "Windows 10");
			cap.setCapability("version", "60.0");
			cap.setCapability("name", "Test on Windows 10 - Chrome");
			//String Node = "http://192.168.1.3:5567/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Launch website
			driver.navigate().to(URL);
			driver.manage().window().maximize();
		} 
		
		else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}	
	@Test
	public void createEmergency() throws InterruptedException {

		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		driver.findElement(By.id("j_username")).sendKeys("0000000000000000000000008003608833438120");
		//Enter wrong Password
		driver.findElement(By.id("j_password")).sendKeys("Peach@412");
		driver.findElement(By.id("submit")).click();
		System.out.println("Test Passed Successfully");
		
		
		
	}

	@AfterTest
	public void closeBrowser() {
	    driver.quit();
	}

}
