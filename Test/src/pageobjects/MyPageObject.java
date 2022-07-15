package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.provar.core.model.ui.api.UiFacet;
import com.provar.core.testapi.annotations.*;

@Page( title="My Page Object"                                
     , summary=""
     , relativeUrl=""
     , connection="Admin"
     )             
public class MyPageObject {

	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Sign in']")
	public WebElement signIn;
	@LinkType()
	@FindBy(xpath = "//div[@id='main']//a[normalize-space(.)='Learn SQL']")
	public WebElement learnSQL;
	@LinkType()
	@FindBy(xpath = "//p/a[normalize-space(.)='SQL Data Types']")
	public WebElement sQLDataTypes;
	@PageRow()
	public static class W3Sql {
	}
	@FacetFindBys(value = {
			@FacetFindBy(findBy = @FindBy(xpath = "(//div[4]/table)[1]//tr[position() > 1]"), facet = UiFacet.DATA_ROWS),
			@FacetFindBy(findBy = @FindBy(xpath = "((//div[4]/table)[1]//tr)[1]"), facet = UiFacet.HEADER_ROW) })
	@FindBy(xpath = "(//div[4]/table)[1]")
	@PageTable(firstRowContainsHeaders = false, row = W3Sql.class)
	public List<W3Sql> w3Sql;
			
}
