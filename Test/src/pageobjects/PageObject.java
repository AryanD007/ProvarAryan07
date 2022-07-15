package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="Page Object"                                
     , summary=""
     , relativeUrl=""
     , connection="Admin"
     )             
public class PageObject {
	 @TextType()
     @FindBy(xpath = "//input[@id='cas14']")
     public WebElement subject;
     
     @ButtonType()
     @FindBy(xpath = "//input[@name='save']")
     public WebElement save;
     
     @LinkType()
     @FindBy(xpath = "//a[contains(@title,'Google Search')]")
     public WebElement googleSearch;
     
     @BooleanType()
     @FindBy(xpath = "//input[@id='IsRecurrence']")
     public WebElement recurrence;
}
