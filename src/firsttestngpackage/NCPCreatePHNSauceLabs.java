package firsttestngpackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.ITestResult;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;

public class NCPCreatePHNSauceLabs {


	public WebDriver driver;
	public String URL;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;
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
		} /*else if (browser.equalsIgnoreCase("ie")) {
			System.out.println(" Executing on IE");
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setBrowserName("ie");
			cap.setCapability("platform", "Windows 8");
			cap.setCapability("version", "10.0");
			//String Node = "http://192.168.1.3:5568/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Launch website
			driver.navigate().to(URL);
			driver.manage().window().maximize();
		} */
		
		else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}	
	@Test
	public void createEmergency() throws InterruptedException {

		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\kshitij.shrivastava\\Documents\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();

		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		//driver.get("https://myrecord.ehealthtest.health.gov.au/locallogin/login.html");
		driver.findElement(By.id("j_username")).sendKeys("0000000000000000000000008003608000119545");
		//Enter wrong Password
		driver.findElement(By.id("j_password")).sendKeys("Welcome123");
		driver.findElement(By.id("submit")).click();
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class = 'card--entry non-take--control card--active click']")));

		driver.findElement(By.xpath("//a[@class = 'card--entry non-take--control card--active click']")).click();
		
		//Code for Emergency contact
		/*driver.findElement(By.xpath("//a[text()= 'Profile & Settings']")).click();
		driver.findElement(By.xpath("//span[text() = 'View Emergency Contacts']")).click();
		driver.findElement(By.xpath("//button[text() = 'Add an emergency contact']")).click();
		driver.findElement(By.xpath("//button[@class = 'btn dropdown-toggle btn-default']")).click();
		driver.findElement(By.xpath("//span[text() = 'Emergency Contact']")).click();
		driver.findElement(By.id("nameInput")).sendKeys("Martin");
		driver.findElement(By.id("contactNumberInput")).sendKeys("09945099450");
		driver.findElement(By.id("emailInput")).sendKeys("Martin@abc.com");
		driver.findElement(By.id("relationshipInput")).sendKeys("Brother");
		driver.findElement(By.id("addContactSave")).click();*/
		
		//code for PHN
		driver.findElement(By.xpath("//a[@href= '/content/ncp/documents.html' and text() = 'Documents']")).click();
		driver.findElement(By.xpath("//span[contains(text(), 'View Key Information')]")).click();
		driver.findElement(By.xpath("//a[@href='/content/ncp/documents/key_info/phn.html']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Add a Personal Health Note')]")).click();
		driver.findElement(By.id("eventdate")).sendKeys("12-Dec-2016");
		driver.findElement(By.id("title")).sendKeys("Note");
		driver.findElement(By.id("description")).sendKeys("Detailed Note");
		driver.findElement(By.id("add-phn")).click();
		
		//driver.close();
		
		
		//Code for Emergency contact
		/*wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Remove']")));
		driver.findElement(By.xpath("//button[text() = 'Remove']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Confirm']")));
		driver.findElement(By.xpath("//button[text() = 'Confirm']")).click();*/
	

	}

	@AfterTest
	public void closeBrowser() {
	    driver.quit();
	}
}

