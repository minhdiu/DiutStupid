package pagePactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;

public class NewtourRegister {
WebDriver driver;
@FindBy(linkText="REGISTER")
WebElement RegisBtn_home;

@FindBy(name="firstName")
WebElement firstName;

@FindBy(name="lastName")
WebElement lastName;

@FindBy(name="phone")
WebElement phone;

@FindBy(id="userName")
WebElement userName;

@FindBy(name="address1")
WebElement add1;

@FindBy(name="address2")
WebElement add2;

@FindBy(name="city")
WebElement city;

@FindBy(name="country")
WebElement country;

@FindBy(name="register")
WebElement registerBtn;

@FindBy(id="email")
WebElement email;

@FindBy(name="password")
WebElement password;

@FindBy(name="confirmPassword")
WebElement confirmPassword;


@FindBy(xpath= ".//*[contains(font,'Thank you for registering')]")

WebElement Act1;

public NewtourRegister(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver, this);	////This initElements method will create all WebElements	 
}

public void setUserName(String StrUserName)
{
	userName.sendKeys(StrUserName);
}


public void setfirstName(String StrfirstName)
{
	firstName.sendKeys(StrfirstName);
}


public void setlastName(String StrlastName)
{
	lastName.sendKeys(StrlastName);
}


public void setphone(String Strphone)
{
	phone.sendKeys(Strphone);
}


public void setaddress1(String Straddress1)
{
	add1.sendKeys(Straddress1);
}

public void setaddress2(String Straddress2)
{
	add2.sendKeys(Straddress2);
}

public void setcity(String StrCity)
{
	city.sendKeys(StrCity);
}

public void setcountry(String Strcountry)
{
    new Select(driver.findElement(By.name("country"))).selectByVisibleText("Strcountry");  
}

public void setEmail(String StrEmail)
{
	email.sendKeys(StrEmail);  
}

public void setpassword(String Strpassword)
{
	password.sendKeys(Strpassword);  
}

public void setconfirmPassword(String StrconfirmPassword)
{
	confirmPassword.sendKeys(StrconfirmPassword);  
}


public void clickRegisBtn()
{
	RegisBtn_home.click();  
}

public void clickRegisBtn2()
{
	registerBtn.click();  
}


public String getAtcResult()
{ return Act1.getText();
}


public void Register(String StrfirstName, String StrlastName,String Strphone, String StrUserName, String Straddress1, String Straddress2, String StrCity, String Strcountry,
		String StrEmail, String Strpassword, String StrconfirmPassword){
	this.clickRegisBtn();
	this.setfirstName(StrfirstName);
	this.setlastName(StrlastName);
	this.setphone(Strphone);
	this.setUserName(StrUserName);
	this.setaddress1(Straddress1);
	this.setaddress1(Straddress2);
	this.setcity(StrCity);
	this.setcountry(Strcountry);
	this.setEmail(StrEmail);
	this.setpassword(Strpassword);
	this.setconfirmPassword(StrconfirmPassword);
	this.clickRegisBtn2();
	
}





}
