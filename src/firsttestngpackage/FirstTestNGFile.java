package firsttestngpackage;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTestNGFile {
	
	 	public String baseUrl = "http://demo.guru99.com/selenium/newtours/";
	    String driverPath = "C:\\Users\\kshitij.shrivastava\\Documents\\geckodriver-v0.17.0-win64\\geckodriver.exe";
	    public WebDriver driver ;	
  @BeforeTest
  public void launchBrowser() {
      
      System.out.println("launching firefox browser"); 
      //System.setProperty("webdriver.gecko.marionette", driverPath);
      System.setProperty("webdriver.gecko.driver", driverPath);
      //DesiredCapabilities cap = new DesiredCapabilities().firefox();
      driver = new FirefoxDriver();
      driver.get(baseUrl);
  } 
   @Test
   public void verifyHomepageTitle() {
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      
   }
   
   @AfterTest
   public void terminateBrowser(){
	   driver.close();
   }
}

