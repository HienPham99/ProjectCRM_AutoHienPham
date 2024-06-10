package ProjectCRM.testcases;

import ProjectCRM.pages.DashboardPage;
import ProjectCRM.pages.LoginPage;
import ProjectCRM.pages.ProjectsPage;
import common.BaseTest;
import helpers.ExcelHelper;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ProjectsTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProjectsPage projectsPage;

    private String PROJECT_NAME = "Merkle Blucomerce";
    private String searchValue = "Merkle";


    @Test(priority = 1)
    public void verifyHeaderProjectPage() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        loginPage.verifyLoginSuccess();
        projectsPage = dashboardPage.clickMenuProject();
        projectsPage.verifyHeaderProjectPage();
        projectsPage.checkTotalNotStarted();
        projectsPage.checkTotalInProgress();
        projectsPage.checkTotalOnHold();
        projectsPage.checkTotalCancelled();
        projectsPage.checkTotalFinished();
    }

    @Test(priority = 2)
    public void verifyAllDataProject() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        loginPage.verifyLoginSuccess();
        projectsPage = dashboardPage.clickMenuProject();
        projectsPage.checkAllDataTable();
    }

    @Test(priority = 3)
    public void verifyAddNewProject() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        projectsPage = dashboardPage.clickMenuProject();
        projectsPage.clickButtonAddNewProject();
        projectsPage.addNewProject(PROJECT_NAME);
        projectsPage = dashboardPage.clickMenuProject();
        projectsPage.searchAndVerifyProject(PROJECT_NAME);

    }

}
