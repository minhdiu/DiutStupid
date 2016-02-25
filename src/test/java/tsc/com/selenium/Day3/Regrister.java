package tsc.com.selenium.Day3;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;;

public class Regrister 
{
     private WebDriver driver;

      @After
      public void tearDown() throws Exception {
        driver.quit();
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
       
      
}
