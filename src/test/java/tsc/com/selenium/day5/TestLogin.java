package tsc.com.selenium.day5;


	import java.util.concurrent.TimeUnit;
	 
	import org.openqa.selenium.WebDriver;
	 
	import org.openqa.selenium.firefox.FirefoxDriver;
	 
	import org.testng.Assert;
	 
	import org.testng.annotations.BeforeTest;
	 
	import org.testng.annotations.Test;
	import pagePactory.NewtourLogin;
	import pagePactory.NewtourRegister;
	import pagePactory.Newtour_Base;
	
	public class TestLogin {
	 
	    private static final String p = null;

		WebDriver driver;
	 
	    NewtourLogin objLogin;
	 
	    NewtourRegister objRegister;
	    Newtour_Base testBase;
	 
	    @Test
	 
	    public void LoginSucc(){

	 
	    objLogin = new NewtourLogin(driver);

	    objLogin.LogintoNewtour("diuttm","123");
	    Assert.assertEquals(objLogin.getActResult(), "Welcome back to Mercury Tours! Enter your user information to access the member-only areas of this site. If you don't have a log-in, please fill out the registration form.");
	 
	 
	 
	    }
	 
	     
	 
	}

