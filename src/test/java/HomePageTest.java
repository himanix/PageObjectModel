import functionPackage.DriverFactory;
import functionPackage.HomePage;
import functionPackage.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {


    HomePage homePage=new HomePage();

    @Test
    public void verifyhomepage() throws InterruptedException {
        String expectedTitle = homePage.getPageTitle();
        homePage.searchproduct("camera");
      /*  String actualTitle = "Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More";
        Assert.assertEquals(expectedTitle,actualTitle);*/
        /*SearchPage searchPage=new SearchPage(driver);
        String str1=SearchPage.fetchdetail();
        String str2="Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More";
        Assert.assertEquals(str1,str2);*/
    }

    @AfterClass
    public void quitApplication(){
        DriverFactory.closeBrowser();
    }


}
