package functionPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePage extends DriverFactory{

    public static WebDriver driver;
    public static WebElement element_box;
    private static By element_searchicon = By.className("vh79eN");
    private static By element_searchbox=By.className("LM6RPg");
    public HomePage(){
        super();
        this.driver = DriverFactory.driver;
    }

    public static void searchproduct(String search_text) throws InterruptedException {

        waitForElement(element_searchbox);
        sendText(element_searchbox,search_text);
       //driver.findElement(element_searchbox).sendKeys(search_text);
        clickElement(element_searchicon);
    }

    public static String getPageTitle(){
      return driver.getTitle();
    }
}
