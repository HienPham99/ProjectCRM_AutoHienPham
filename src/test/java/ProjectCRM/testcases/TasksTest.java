package ProjectCRM.testcases;

import ProjectCRM.pages.DashboardPage;
import ProjectCRM.pages.LoginPage;
import ProjectCRM.pages.TasksPage;
import common.BaseTest;
import helpers.ExcelHelper;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TasksTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    TasksPage tasksPage;

    private String SUBJECT = "AutoTestA1";


    @Test(priority = 1)
    public void verifyHeaderFormTasks(){
        loginPage= new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        tasksPage = dashboardPage.clickMenuTasks();
        tasksPage.verifyHeaderTasks();
        tasksPage.checkAllTotalTasks();
        tasksPage.countDataTableTasks();
    }

    @Test(priority = 2)
    public void verifyClickSwitchIconTasks(){
        loginPage= new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        tasksPage = dashboardPage.clickMenuTasks();
        tasksPage.verifyWhenClickIconSwitch();
    }
    @Test(priority = 3)
    public void verifyClickTaskOverviewButton(){
        loginPage= new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        tasksPage = dashboardPage.clickMenuTasks();
        tasksPage.verifyWhenClickTaskOverviewButton();
    }

    @Test(priority = 4)
    public void verifyAddNewTask(){
        loginPage= new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        tasksPage = dashboardPage.clickMenuTasks();
        tasksPage.addNewTask(SUBJECT);
        tasksPage.verifyAddTaskSuccess();
    }

    @Test(priority = 5)
    public void verifySearchTask(){
        loginPage= new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        tasksPage = dashboardPage.clickMenuTasks();
        tasksPage.addNewTask(SUBJECT);
        tasksPage.verifyAddTaskSuccess();
        tasksPage.searchTask(SUBJECT);
    }

}
