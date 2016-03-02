package pagePactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class NewtourLogin {
	WebDriver driver;

	@FindBy(name="userName")
	WebElement UserName;
	
	@FindBy(name="password")
	WebElement Pass;
	
	@FindBy(name="login")
	WebElement loginBtn;
	
	@FindBy(xpath=(".//*[contains(font,'Enter your user information to access')]"))
	WebElement Act_re;
	
	public NewtourLogin(WebDriver driver)
	{
		this.driver= driver;
		 PageFactory.initElements(driver, this);	////This initElements method will create all WebElements	 
	}

	public void setUserName(String StrUserName)
	{ UserName.sendKeys(StrUserName);}
	
	public void setPass(String StrPass)
	{Pass.sendKeys(StrPass);}
	
	public void clickLoginBtn()
	{loginBtn.click();}
	
	public String getActResult(){
		return Act_re.getText();}
	
	public void LogintoNewtour(String StrUserNAme, String StrPass)
	{
		this.setUserName(StrUserNAme);
		this.setPass(StrPass);
		this.clickLoginBtn();
	}
	}
	


	
	

