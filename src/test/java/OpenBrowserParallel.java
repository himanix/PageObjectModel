import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenBrowser {

    @Parameters("browser")
    @Test
    public void paralleltesting(String browser)
    {
        if(browser.equals("firefox"))
        {
           String exepath="src\\main\\resources\\drivers\\geckodriver.exe";
           System.setProperty("webdriver.gecko.driver",exepath);
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            //capabilities.setCapability("marionette", true);
            WebDriver driver = new FirefoxDriver();
            driver.get("http://flipkart.com");
        }
        else if(browser.equals("chrome"))
        {
            String exePath = "src\\main\\resources\\drivers\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);
            WebDriver driver = new ChromeDriver();
            driver.get("http://google.com");

        }

    }
}


