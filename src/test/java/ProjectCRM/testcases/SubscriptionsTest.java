package ProjectCRM.testcases;

import ProjectCRM.pages.DashboardPage;
import ProjectCRM.pages.LoginPage;
import ProjectCRM.pages.SubscriptionsPage;
import common.BaseTest;
import helpers.ExcelHelper;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class SubscriptionsTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    SubscriptionsPage subscriptionsPage;

    @Test(priority = 1)
    public void verifyHeaderSubscripttions() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        subscriptionsPage = dashboardPage.clickMenuSubscriptions();
        subscriptionsPage.verifyHeaderSubscriptions();
    }

    @Test(priority = 2)
    public void verifyTotalAllDataSubscripts() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        subscriptionsPage = dashboardPage.clickMenuSubscriptions();
        subscriptionsPage.verifyTotalNotSubscribed();
        subscriptionsPage.verifyTotalActive();
        subscriptionsPage.verifyTotalFuture();
        subscriptionsPage.verifyTotalPastDue();
        subscriptionsPage.verifyTotalUnpaid();
        subscriptionsPage.verifyTotalIncomplete();
        subscriptionsPage.verifyTotalCanceled();
        subscriptionsPage.verifyTotalIncompleteExpired();
    }

}
