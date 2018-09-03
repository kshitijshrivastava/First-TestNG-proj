package firsttestngpackage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
 


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelExecutionSampleRemote {
	
	public WebDriver driver;
	public String URL;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	
	//Code to connect to Saucelabs
   /* public static final String USERNAME = "kshitij0312";
	public static final String ACCESS_KEY = "ac8ad00b-e829-4874-8f19-85b4aeee818c";
	public String Node = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";*/
 
	@Parameters("browser")
	@BeforeTest
	public void launchbrowser(String browser) throws MalformedURLException {
		//String URL = "http://www.calculator.net";
		String URL = "http://www.google.co.in";
 
		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on FireFox");
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			//cap.setCapability("platform", "Windows 10");
			//cap.setCapability("version", "55.0");
			
			//DesiredCapabilities cap = DesiredCapabilities.firefox();
			//cap.setCapability("platform", "Windows 10");
			//cap.setCapability("version", "47.0");
			String Node = "http://10.239.194.65:5555/wd/hub";
 
			driver = new RemoteWebDriver(new URL(Node), cap);
			// Puts an Implicit wait, Will wait for 10 seconds before throwing
			// exception
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
			// Launch website
			driver.navigate().to(URL);
			driver.manage().window().maximize();
		}else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(" Executing on CHROME");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			//cap.setCapability("platform", "Windows 10");
			//cap.setCapability("version", "60.0");
			String Node = "http://10.239.194.65:5555/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
			// Launch website
			driver.navigate().to(URL);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("internet explorer")) {
			System.out.println(" Executing on IE");
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setBrowserName("internet explorer");
			//cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			
			//DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			cap.setCapability("requireWindowFocus", true);
			//WebDriver driver = new InternetExplorerDriver(cap);
			
			//cap.setCapability("platform", "Windows 10");
			//cap.setCapability("version", "11.0");
			String Node = "http://10.239.194.65:5555/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
			// Launch website
			driver.navigate().to(URL);
			//driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("MicrosoftEdge")) {
			System.out.println(" Executing on MicrosoftEdge");
			DesiredCapabilities cap = DesiredCapabilities.edge();
			cap.setBrowserName("MicrosoftEdge");
			//cap.setCapability("platform", "Windows 10");
			//cap.setCapability("version", "11.0");
			String Node = "http://10.239.194.65:5569/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
			// Launch website
			driver.navigate().to(URL);
			driver.manage().window().maximize();
		}else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}
 
	@Test
	public void calculatepercent() {
		
		driver.findElement(By.id("lst-ib")).sendKeys("ndtv");
		
	}
 
	/*@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
*/
}
