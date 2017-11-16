package functionPackage;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {
    public static String[][] getExcelData() throws IOException, BiffException {
        String[][] arrayExcelData=null;

        FileInputStream fs=new FileInputStream("C:\\Users\\hbansal\\IdeaProjects\\SampleMavenProject\\src\\main\\resources\\logindetails.xls");
        Workbook wb=Workbook.getWorkbook(fs);
        Sheet sh=wb.getSheet("Sheet1");

        int totalCols=sh.getColumns();
        int totalRows=sh.getRows();
        arrayExcelData=new String[totalRows - 1][totalCols];

        for(int i=1;i < totalRows;i++)
        {
            for(int j=0;j< totalCols;j++)
            {
               arrayExcelData[i-1][j]=sh.getCell(j,i).getContents();
            }
        }
        return arrayExcelData;
    }


}
