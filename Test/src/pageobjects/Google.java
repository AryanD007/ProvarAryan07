package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="Google"                                
     , summary=""
     , relativeUrl=""
     , connection="Google"
     )             
public class Google {

	@LinkType()
	@FindBy(xpath = "//a[text()='Gmail']")
	public WebElement gmail;
	@LinkType()
	@FindBy(xpath = "//span[contains(text(),'Create an account')]")
	public WebElement getGmailCreateAnAccount;
	@TextType()
	@FindBy(xpath = "//input[@name='firstName']")
	public WebElement First_name;
	@TextType()
	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement Last_name;
	@TextType()
	@FindBy(xpath = "//input[@type='email']")
	public WebElement email;
	@TextType()
	@FindBy(xpath = "//input[@name='Passwd']")
	public WebElement Password;
	@TextType()
	@FindBy(xpath = "//input[@name='ConfirmPasswd']")
	public WebElement Confirm_password;
	@ButtonType()
	@FindBy(xpath = "//span[text()='Next']")
	public WebElement next;
			
}
