package tsc.com.selenium.Day3;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

public class TestBase1 {
protected Properties p;

@BeforeSuite
public void beforeClass() throws IOException {

// Read config file
p = Utility.readConfig();
String brower = p.getProperty("browserName") ;
}
}
