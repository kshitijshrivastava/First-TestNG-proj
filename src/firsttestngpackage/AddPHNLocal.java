package firsttestngpackage;

import java.net.MalformedURLException;
//import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddPHNLocal {
	
	public WebDriver driver;
	public String URL;
	
@BeforeTest
	public void launchbrowser() {
		String URL = "https://myrecord.ehealthtest.health.gov.au/locallogin/login.html";
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\kshitij.shrivastava\\Documents\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kshitij.shrivastava\\Documents\\chromedriver_win32\\chromedriver.exe");

		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		
			
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			
			driver.navigate().to(URL);
			driver.manage().window().maximize();
	}
	
	@Test
	public void createPHN() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		//driver.get("https://myrecord.ehealthtest.health.gov.au/locallogin/login.html");
		driver.findElement(By.id("j_username")).sendKeys("0000000000000000000000008003608000119545");
		
		driver.findElement(By.id("j_password")).sendKeys("Welcome123");
		driver.findElement(By.id("submit")).click();
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class = 'card--entry non-take--control card--active click']")));

		driver.findElement(By.xpath("//a[@class = 'card--entry non-take--control card--active click']")).click();
		driver.findElement(By.xpath("//a[@href= '/content/ncp/documents.html' and text() = 'Documents']")).click();
		driver.findElement(By.xpath("//span[contains(text(), 'View Key Information')]")).click();
		driver.findElement(By.xpath("//a[@href='/content/ncp/documents/key_info/phn.html']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Add a Personal Health Note')]")).click();
		driver.findElement(By.id("eventdate")).sendKeys("12-Dec-2016");
		driver.findElement(By.id("title")).sendKeys("Note");
		driver.findElement(By.id("description")).sendKeys("Detailed Note");
		driver.findElement(By.id("add-phn")).click();
	}
	@AfterTest
	public void closeBrowser() {
	    driver.quit();
	}
}
