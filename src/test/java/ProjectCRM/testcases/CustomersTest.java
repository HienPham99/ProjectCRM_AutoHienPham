package ProjectCRM.testcases;

import ProjectCRM.pages.CustomersPage;
import ProjectCRM.pages.DashboardPage;
import ProjectCRM.pages.LoginPage;
import common.BaseTest;
import helpers.ExcelHelper;
import keywords.WebUI;
import listeners.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.LogUtils;

import java.util.ArrayList;

@Listeners(TestListener.class)
public class CustomersTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;

    private String COMPANY_NAME = "Merkle Blucom A2";
    private String searchValue = "Merkle";

    @Test(priority = 1)
    public void verifyHeaderCustomerPage() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        loginPage.verifyLoginSuccess();
        customersPage = dashboardPage.clickMenuCustomer();
        customersPage.verifyHeaderCustomerPage();
        customersPage.checkTotalCustomers();
        customersPage.checkActiveCustomers();
        customersPage.checkInactiveCustomers();
        customersPage.checkActiveContacts();
        customersPage.checkInactiveContacts();
        customersPage.checkContactsLoggedInToday();

    }

    @Test(priority = 2)
    public void verifyAllItemCustomerPage() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        loginPage.verifyLoginSuccess();
        customersPage = dashboardPage.clickMenuCustomer();
        customersPage.checkDataTableAll();

    }

    @Test(priority = 3)
    public void verifyAddNewCustomerAndSearchDataAddNew() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );

        customersPage = dashboardPage.clickMenuCustomer();
        customersPage.verifyHeaderCustomerPage();

        customersPage.clickButtonAddNewCustomer();
        customersPage.inputFormData(COMPANY_NAME);
        customersPage=dashboardPage.clickMenuCustomer();
        customersPage.searchCustomerNewAdd(COMPANY_NAME);
        customersPage.checkDataTableAll();
        customersPage.searchAndVerifyCustomer(COMPANY_NAME);

    }

    @Test(priority = 4)
    public void verifySearchDataNormal() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "Sheet1");
        dashboardPage = loginPage.loginCRM(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );

        customersPage = dashboardPage.clickMenuCustomer();
        customersPage.verifyHeaderCustomerPage();
        customersPage.searchCustomerNomal(searchValue);
        customersPage.checkDataTableAll();

    }

}
