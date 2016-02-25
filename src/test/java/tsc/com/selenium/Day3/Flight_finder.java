package tsc.com.selenium.Day3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class Flight_finder {
    private static final String p = null;
    WebDriver driver;
    Newtour a;
    @Test
    public void find_flight_sucess() throws Exception {
        Newtour a= new Newtour();
        a.Login("diuttm","123",driver);
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
    @After
   public void tearDown() throws Exception {
       driver.quit();
   }
}
