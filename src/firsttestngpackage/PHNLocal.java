package firsttestngpackage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PHNLocal {
	public WebDriver driver;
	public String URL;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	
	//Code to connect to Saucelabs
   /* public static final String USERNAME = "kshitij0312";
	public static final String ACCESS_KEY = "ac8ad00b-e829-4874-8f19-85b4aeee818c";
	public String Node = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";*/
 

	@BeforeTest
	public void launchbrowser(String browser) throws MalformedURLException {
		//String URL = "http://www.calculator.net";
		String URL = "https://myrecord.ehealthtest.health.gov.au/locallogin/login.html";
 
		
			driver = new RemoteWebDriver(new URL(Node), cap);
			// Puts an Implicit wait, Will wait for 10 seconds before throwing
			// exception
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
			// Launch website
			driver.navigate().to(URL);
			driver.manage().window().maximize();
		}
	}
 
	@Test
	public void createPHN() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		//driver.get("https://myrecord.ehealthtest.health.gov.au/locallogin/login.html");
		//PTF
		driver.findElement(By.id("j_username")).sendKeys("0000000000000000000000008003608666785365");
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
		
	}
 
	/*@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
*/
}

