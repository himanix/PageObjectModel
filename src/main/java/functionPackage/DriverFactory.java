package functionPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

     public static WebDriver driver;
     Properties prop=new Properties();
     InputStream is=null;
     String browser;
     static String url;
     static Integer maxTimeOut;
     public static WebDriverWait mywait;


    public DriverFactory(){
        prop=readPropertiesFile("config.properties");
        setGlobalVariables(prop);
        openBrowser();
    }

    public void openBrowser() {
        if(browser.equals("firefox")) {
            String exepath="src\\main\\resources\\drivers\\geckodriver.exe";
            System.setProperty("webdriver.gecko.driver",exepath);
            driver = new FirefoxDriver();
        }
        else if(browser.equals("chrome")){
            String exePath = "src\\main\\resources\\drivers\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);
            driver = new ChromeDriver();
        }
        //driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void setGlobalVariables(Properties prop) {
        browser=prop.getProperty("browser");
        url=prop.getProperty("applicationUrl");
        maxTimeOut=Integer.parseInt(prop.getProperty("maxwaittime"));
    }

    public static void closeBrowser(){
        driver.quit();
    }

    public static void waitForPresence(By locator){
        mywait = new WebDriverWait(driver,maxTimeOut);
        mywait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForElement(By locator){
        mywait = new WebDriverWait(driver,maxTimeOut);
        mywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForEnabled(By locator){
        mywait=new WebDriverWait(driver,maxTimeOut);
        mywait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void deleteCookies(){
        driver.manage().deleteAllCookies();
    }

    public static void navigatetourl(){
        driver.navigate().to(url);
    }

    public static void clickElement(By locator){
        driver.findElement(locator).click();
    }

    public static void sendText(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    public static boolean checkVisibility(By locator){
        try {
            if (driver.findElement(locator).isDisplayed()) {
                return true;
            }
        }catch (NoSuchElementException e){
            System.out.println("Element not found" + e);
            return false;
        }
        return false;
    }
   /*public static void checkVisibility(By locator){
       try {
           if (driver.findElement(locator).isDisplayed()) {
              clickElement(locator);
           }
       }catch (NoSuchElementException e){
           System.out.println("Element not found" + e);

       }
   }*/

    public Properties readPropertiesFile(String fileName){
        try {
            is=new FileInputStream(fileName);
            prop.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
