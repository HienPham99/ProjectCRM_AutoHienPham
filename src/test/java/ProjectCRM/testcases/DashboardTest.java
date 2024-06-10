package ProjectCRM.testcases;

import ProjectCRM.pages.DashboardPage;
import ProjectCRM.pages.LoginPage;
import common.BaseTest;
import helpers.ExcelHelper;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 1)
    public void checkTotalSectionQuickStatistics() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );

        loginPage.verifyLoginSuccess();
        dashboardPage.checkTotalInvoicesAwaitingPayment();
        dashboardPage.checkTotalConvertedLeads();
        dashboardPage.checkTotalProjectsInProgress();
        dashboardPage.checkTotalTasksNotFinished();
    }

    @Test(priority = 2)
    public void checkSectionQuickStatisticsSelected() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        dashboardPage.clickButtonDashboardOptions();
        dashboardPage.verifyCheckboxQuickStatistics();

    }

    @Test(priority = 3)
    public void checkSectionQuickStatisticsUntick() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        dashboardPage.clickButtonDashboardOptions();
        dashboardPage.untickCheckboxQuickStatistics();
        dashboardPage.verifyUntickCheckboxQuickStatistics();

    }

}
