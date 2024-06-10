package ProjectCRM.testcases;

import ProjectCRM.pages.ContractPage;
import ProjectCRM.pages.DashboardPage;
import ProjectCRM.pages.LoginPage;
import common.BaseTest;
import helpers.ExcelHelper;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ContractTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ContractPage contractPage;

    @Test(priority = 1)
    public void verifyContentContractPage() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        contractPage = dashboardPage.clickMenuContract();
        contractPage.verifyHeaderContracts();
        contractPage.checkTotalAllContract();
        contractPage.checkBieuDoContract();
        contractPage.verifyAllDataContracts();
    }

    @Test(priority = 2)
    public void verifyAddAndSearchContract() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        contractPage = dashboardPage.clickMenuContract();
        contractPage.addNewContracts();
        contractPage.verifySearchContract();
            }
}
