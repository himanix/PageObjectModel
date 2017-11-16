import functionPackage.CredentialProviderclass;
import functionPackage.DriverFactory;
import functionPackage.LoginwithDataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {

    LoginwithDataProvider login=new LoginwithDataProvider();

    @BeforeMethod
    public void navigateToBaseurl()
    {
        DriverFactory.deleteCookies();
        DriverFactory.navigatetourl();
    }
    @Test(dataProvider = "CredentialProvider",dataProviderClass = CredentialProviderclass.class)
    public void checklogin(String username,String password) {
        login.checkCredentials(username,password);
        login.logout();
    }

   /* @AfterClass
    public void quitApplication(){
        DriverFactory.closeBrowser();
    }*/
}
