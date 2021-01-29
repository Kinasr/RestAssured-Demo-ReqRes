package dataProviders;

import helpers.ReadFromExcelSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class UserDataProvider {

    @DataProvider
    public Object[][] getUsersDataFromPage1() throws IOException, InvalidFormatException {
        ReadFromExcelSheet read = new ReadFromExcelSheet("reqres users data.xlsx","page1");
        return read.readDataFromExcel();
    }

    @DataProvider
    public Object[][] getUsersDataFromPage2() throws IOException, InvalidFormatException {
        ReadFromExcelSheet read = new ReadFromExcelSheet("reqres users data.xlsx","page2");
        return read.readDataFromExcel();
    }

    @DataProvider
    public Object[] getSingleUserData(String userId) {
        ReadFromExcelSheet read = new ReadFromExcelSheet("reqres users data.xlsx","page2");
        return ;
    }
}
