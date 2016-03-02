package tsc.com.selenium.day5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
 
public class DataproviderClass {
 
        @DataProvider(name="SearchProvider")
 
        public static Object[][] getDataFromDataprovider(){
 
            return new Object[][] {
 
                    { "diuttm", "123" },
 
                { "", "" },
 
              
                };
        }

}


