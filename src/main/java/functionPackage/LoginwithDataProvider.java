package functionPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginwithDataProvider extends DriverFactory {

     WebDriver driver;
     By email_field=By.xpath("//input[@type='email']");
     By next_button=By.xpath("//content[@class='CwaK9']");
     By pswd_field=By.xpath("//input[@type='password']");
     By letter_dropdown=By.xpath("//a[@class='gb_b gb_gb gb_R']");
     By logout_button=By.linkText("Sign out");
     By new_account=By.xpath("//div[@id='identifierLink']");
    public LoginwithDataProvider(){
        super();
        this.driver=DriverFactory.driver;
    }

    public void checkCredentials(String username,String password){
        sendText(email_field,username);
        clickElement(next_button);
        waitForElement(pswd_field);
        sendText(pswd_field,password);
        clickElement(next_button);
    }
    public void logout(){
        waitForPresence(letter_dropdown);
        waitForEnabled(letter_dropdown);
        WebElement ele = driver.findElement(letter_dropdown);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", ele);
       // clickElement(letter_dropdown);
        clickElement(logout_button);
        waitForElement(new_account);
        clickElement(new_account);
    }
}
