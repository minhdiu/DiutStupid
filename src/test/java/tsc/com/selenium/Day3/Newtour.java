package tsc.com.selenium.Day3;

import java.io.IOException;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Newtour {
	protected Properties p;
	protected WebDriver driver;
	protected String urlBase;

	@Before
	public void beforeClass() throws IOException {
	    Properties p = new Properties();
		// Read config file
		p = Utility1.readConfig();
		String browser = p.getProperty("browserName");
		urlBase=p.getProperty("base_url");		
		
		if (browser.equalsIgnoreCase("firefox") ){
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "F:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		driver.get(urlBase);
	}
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	public void Login(String name, String pass){
	    //private static final String p = null;
	        driver.findElement(By.name("userName")).sendKeys(name);
	        driver.findElement(By.name("password")).sendKeys(pass);
	        driver.findElement(By.name("login")).click();
	    }
	@Test
	public void loginFail() throws Exception {
	   
        Login("","");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    String actual_re = driver.findElement(By.xpath(".//*[contains(font,'Enter your user information to access')]")).getText();
	    Assert.assertEquals(actual_re, "Welcome back to Mercury Tours! Enter your user information to access the member-only areas of this site. If you don't have a log-in, please fill out the registration form.");
	}
	@Test
	public void loginSucc() throws Exception {
	    Login("diuttm","123");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    String actual_re2= driver.findElement(By.xpath(".//*[contains(font,'Use our Flight Finder')]")).getText();
	    Assert.assertEquals(actual_re2, "Use our Flight Finder to search for the lowest fare on participating airlines. Once you've booked your flight, don't forget to visit the Mercury Tours Hotel Finder to reserve lodging in your destination city.");
	}
	@Test
    public void registerSuc(){
      driver.findElement(By.linkText("REGISTER")).click();
      driver.findElement(By.name("firstName")).sendKeys("Diu");
      driver.findElement(By.name("lastName")).sendKeys("TTM");
      driver.findElement(By.name("phone")).sendKeys("123456");   
      driver.findElement(By.id("userName")).sendKeys("diuttm");
      driver.findElement(By.name("address1")).sendKeys("hanoi");
      driver.findElement(By.name("address2")).sendKeys("Hai Duong");
      driver.findElement(By.name("city")).sendKeys("Ha Noi");
      new Select(driver.findElement(By.name("country"))).selectByVisibleText("VIETNAM");   
      driver.findElement(By.id("email")).sendKeys("diuttm@gmail.com");
      driver.findElement(By.name("password")).sendKeys("123");
      driver.findElement(By.name("confirmPassword")).sendKeys("123");
      driver.findElement(By.name("register")).click();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      String actualre= driver.findElement(By.xpath(".//*[contains(font,'Thank you for registering')]")).getText();
      Assert.assertEquals(actualre,"Thank you for registering. You may now sign-in using the user name and password you've just entered.");
    }
   @Test
    public void registerFail(){
        driver.findElement(By.linkText("REGISTER")).click();
        driver.findElement(By.name("register")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String actualre= driver.findElement(By.xpath(".//*[contains(font,'Thank you for registering')]")).getText();
        Assert.assertEquals(actualre,"Thank you for registering. You may now sign-in using the user name and password you've just entered.");
      }
	 @Test
	    public void find_flight_sucess() throws Exception {
	         Login("diuttm","123");
	        new Select(driver.findElement(By.name("passCount"))).selectByVisibleText("1");
	        new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("London");
	        new Select(driver.findElement(By.name("fromMonth"))).selectByVisibleText("March");
	        new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText("1");
	        new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("New York");
	        new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText("April");
	        new Select(driver.findElement(By.name("toDay"))).selectByVisibleText("2");
	        driver.findElement(By.name("findFlights")).click();
	        String actual= driver.findElement(By.xpath(".//*[contains(text(), 'Select your departure')]")).getText();
	        Assert.assertEquals(actual, "Select your departure and return flight from the selections below. Your total price will be higher than quoted if you elect to fly on a different airline for both legs of your travel.");
	    }
	    @Test
	  public void select_flight_sucess() throws Exception {
	   find_flight_sucess();
	   driver.findElement(By.name("reserveFlights")).click();
	   String actual= driver.findElement(By.xpath("//tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font")).getText();
	     Assert.assertEquals(actual, "Please review your travel itinerary and make your purchase.");
	  }
	    @Test
	    public void book_flight() throws Exception {
	    select_flight_sucess();
	    driver.findElement(By.name("buyFlights")).click();
	    String actual= driver.findElement(By.xpath("//tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]")).getText();
	     Assert.assertEquals(actual, "Your itinerary has been booked!");
	}
	
}
