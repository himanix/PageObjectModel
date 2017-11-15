package functionPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SearchPage {

    static private By element_product=By.xpath("//div[@class='_3T_wwx']/div[1]");
    static private By element_cartbutton=By.xpath("//ul[@class='row']/li[1]");
    public static WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver=driver;
    }
    public static String fetchdetail()
    {
        return driver.getTitle();
    }
    public static void getdetail(){
        driver.findElement(element_product).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<String> windowsset = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowsset.get(1).toString());
        driver.findElement(element_cartbutton).click();
    }
}
