package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="DragAndDrop"                                
     , summary=""
     , relativeUrl=""
     , connection="Dummy"
     )             
public class DragAndDrop {
WebDriver driver;
	public DragAndDrop(WebDriver driver) {
	this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	@TextType()
	@FindBy(xpath = "//div[@id='column-b']")
	public WebElement B;
	@TextType()
	@FindBy(xpath = "//div[@id='column-a']")
	public WebElement A;
	
	@TextType()
	@FindBy(xpath = "//button[text()='Selenium WebDriver']")
	public WebElement ele;
	
	
	public void clickmethod(String name){
	
	WebElement ele= driver.findElement(By.xpath("//button[text()='"+name+"']"));
	
	ele.click();}
			
	public void DD() throws InterruptedException{
	  Actions a = new Actions(driver);
	WebElement source= driver.findElement(By.xpath("//div[@id='column-b']"));
	
    WebElement target= driver.findElement(By.xpath("//div[@id='column-a']"));
    Thread.sleep(1000);
    Actions builder = new Actions(driver);
//Building a drag and drop action
Action dragAndDrop = builder.clickAndHold(source)
.moveToElement(target)
.release(target)
.build();
//Performing the drag and drop action
dragAndDrop.perform();
     // a.dragAndDrop(target, source).build().perform();
	}
}
