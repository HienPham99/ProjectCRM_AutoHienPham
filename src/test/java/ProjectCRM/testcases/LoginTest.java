package ProjectCRM.testcases;

import ProjectCRM.pages.DashboardPage;
import ProjectCRM.pages.LoginPage;
import common.BaseTest;
import helpers.ExcelHelper;
import keywords.WebUI;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 1)
    public void testLoginSuccess(){
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage=loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD",1)
                                );
        loginPage.verifyLoginSuccess();
        dashboardPage.logout();

    }

    @Test(priority = 2)
    public void testLoginFailWithEmailInvalid(){
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage=loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 2),
                excelHelper.getCellData("PASSWORD",2)
        );
        loginPage.verifyLoginFailWithEmailWrong();

    }

    @Test(priority = 3)
    public void testLoginFailWithEmailBlank(){
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage=loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 3),
                excelHelper.getCellData("PASSWORD",3)
        );
        loginPage.verifyLoginFailWithEmailBlank();

    }

    @Test(priority = 4)
    public void testLoginFailWithPasswordInvalid(){
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage=loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 4),
                excelHelper.getCellData("PASSWORD",4)
        );
        loginPage.verifyLoginFailWithEmailWrong();

    }

}
