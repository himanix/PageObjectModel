package functionPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePage extends DriverFactory{

    public static WebDriver driver;
    public static WebElement element_box;


    @FindBy(className = "vh79eN")
    private static WebElement element_searchicon;

    @FindBy(className = "LM6RPg" )
    private static WebElement element_searchbox;

    public HomePage(){
        super();
        this.driver = DriverFactory.driver;
        PageFactory.initElements(driver,this);
    }

    public static void searchproduct(String search_text) throws InterruptedException {

        waitForElement(element_searchbox);
        sendText(element_searchbox,search_text);

        clickElement(element_searchicon);
    }

    public static String getPageTitle(){
      return driver.getTitle();
    }
}
