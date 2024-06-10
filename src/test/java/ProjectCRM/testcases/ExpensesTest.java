package ProjectCRM.testcases;

import ProjectCRM.pages.DashboardPage;
import ProjectCRM.pages.ExpensesPage;
import ProjectCRM.pages.LoginPage;
import common.BaseTest;
import helpers.ExcelHelper;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ExpensesTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ExpensesPage expensesPage;

    @Test(priority = 1)
    public void verifyAllDataExpenses() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        expensesPage = dashboardPage.clickMenuExpenses();
        expensesPage.checkAllDataTable();
    }

    @Test(priority = 2)
    public void verifyTickCheckboxAll() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        expensesPage = dashboardPage.clickMenuExpenses();
        expensesPage.verifyWhenTickCheckboxAll();
    }

    @Test(priority = 3)
    public void verifySearchToFilter() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        expensesPage = dashboardPage.clickMenuExpenses();
        expensesPage.searchToFilter();
        expensesPage.verifyDataAfterSearchtoBank();
    }
}
