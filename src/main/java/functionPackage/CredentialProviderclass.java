package functionPackage;

import jxl.read.biff.BiffException;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class CredentialProviderclass {
    @DataProvider(name="CredentialProvider")
    public static Object[][] getdatafromCredentialProvider() throws IOException, BiffException {
       return ReadExcel.getExcelData();
    }
}
