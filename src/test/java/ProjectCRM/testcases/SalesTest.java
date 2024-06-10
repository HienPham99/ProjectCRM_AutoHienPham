package ProjectCRM.testcases;

import ProjectCRM.pages.DashboardPage;
import ProjectCRM.pages.LoginPage;
import ProjectCRM.pages.SalesPage;
import common.BaseTest;
import helpers.ExcelHelper;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class SalesTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    SalesPage salesPage;

    @Test(priority = 1)
    public void verifyAllDataProposals() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        salesPage = dashboardPage.clickMenuSales();
        salesPage.clickSubProposals();
        salesPage.verifyAllDataProposals();

    }

    @Test(priority = 2)
    public void verifySearchByFilter() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        salesPage = dashboardPage.clickMenuSales();
        salesPage.clickSubProposals();
        salesPage.searchByFilter();
        salesPage.verifyDataAfterSearchByStatus();
    }

    @Test(priority = 3)
    public void verifyEditFilter() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        salesPage = dashboardPage.clickMenuSales();
        salesPage.clickSubProposals();
        salesPage.searchByFilter();
        salesPage.verifyDataAfterSearchByStatus();
        salesPage.EditFilter();
        salesPage.verifyDataAfterSearchByStatus();
    }

    @Test(priority = 4)
    public void verifyClickIconXOnHeaderFilter() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        salesPage = dashboardPage.clickMenuSales();
        salesPage.clickSubProposals();
        salesPage.ClickIconX();
        salesPage.verifyAfterClickIconX();
    }
}
