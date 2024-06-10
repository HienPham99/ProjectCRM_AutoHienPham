package dataprovider;

import helpers.ExcelHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {

    @DataProvider(name = "DataLoginSuccess", parallel = true)
    public Object[][] dataLoginSuccess() {
//        return new Object[][]{
//                {"admin@example.com", "123456"},//set dữ liệu cứng
//                {"admin@example.com", "123456"},
//
//        };
        //đổi từ set dứ liệu cứng trong script sang = cách lấy dữ liệu từ file excel =  hàm sau:
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/resources/testdata/DataLogin.xlsx","Sheet1");

        return data;
    }

    @DataProvider(name = "DataLoginFail", parallel = true)
    public Object[][] dataLoginFail() {
        return new Object[][]{
                {"customer@example.com", "123456"},
                {"employee@example.com  ", "56789"}

        };

    }

    @DataProvider(name = "data_provider_login_excel_hashtable")
    public Object[][] dataLoginHRMFromExcelHashtable() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable(
                "src/test/resources/testdata/DataLogin.xlsx",
                "Sheet1", 2, 3);
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

}
