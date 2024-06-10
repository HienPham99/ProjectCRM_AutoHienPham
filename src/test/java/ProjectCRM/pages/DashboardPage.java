package ProjectCRM.pages;

import drivers.DriverManager;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DashboardPage {

    public static By menuDashboardTotal = By.xpath("//ul[@id='side-menu']");

    private String totalInvoicesAwaitingPaymentExpected = "3 / 4";
    private String totalConvertedLeadsExpected = "6 / 12";
    private String totalProjectsInProgressExpected = "26 / 27";
    private String totalTasksNotFinishedExpected = "19 / 21";

    public static By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuReports = By.xpath("//span[normalize-space()='Reports']");
    public static By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    private By menuSales = By.xpath("//span[@class='menu-text'][normalize-space()='Sales']");
    private By menuSubscriptions = By.xpath("//span[normalize-space()='Subscriptions']");
    private By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    private By menuExpenses=By.xpath("(//span[normalize-space()='Expenses'])[1]");
    public static By menuContract=By.xpath("//span[normalize-space()='Contracts']");
    private By menuTasks = By.xpath("//span[normalize-space()='Tasks']");

    private By dropdownProfile = By.xpath("//li[contains(@class,'icon header-user-profile')]");
    private By optionLogout = By.xpath("//ul[@class='dropdown-menu animated fadeIn']//li[@class='header-logout']//a[@href='#'][normalize-space()='Logout']");

    private By buttonDashboardOption = By.xpath("//div[normalize-space()='Dashboard Options']");
    private By checkboxQuickStatistics = By.xpath("//input[@id='widget_option_top_stats']");
    private By sectionQuickStatistics = By.xpath("//div[@id='widget-top_stats']");

    private By totalInvoicesAwaitingPayment = By.xpath("(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");
    private By totalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");
    private By totalProjectsInProgress = By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span");
    private By totalTasksNotFinished = By.xpath("(//span[normalize-space()='Tasks Not Finished']/parent::div)/following-sibling::span");

    public void clickMenuDashboard() {
        WebUI.clickElement(menuDashboard);
    }

    public CustomersPage clickMenuCustomer() {
        WebUI.clickElement(menuCustomer);
        return new CustomersPage();
    }

    public SalesPage clickMenuSales() {
        WebUI.clickElement(menuSales);
        WebUI.waitForPageLoaded();
        return new SalesPage();
    }

    public SubscriptionsPage clickMenuSubscriptions() {
        WebUI.clickElement(menuSubscriptions);
        WebUI.waitForPageLoaded();
        return new SubscriptionsPage();
    }

    public ExpensesPage clickMenuExpenses() {
        WebUI.clickElement(menuExpenses);
        WebUI.waitForPageLoaded();
        return new ExpensesPage();
    }

    public ContractPage clickMenuContract() {
        WebUI.clickElement(menuContract);
        WebUI.waitForPageLoaded();
        return new ContractPage();
    }

    public ProjectsPage clickMenuProject() {
        WebUI.clickElement(menuProjects);
        WebUI.waitForPageLoaded();
        return new ProjectsPage();
    }

    public TasksPage clickMenuTasks() {
        WebUI.clickElement(menuTasks);
        WebUI.waitForPageLoaded();
        return new TasksPage();
    }

    public void clickButtonDashboardOptions() {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(buttonDashboardOption);
    }

    public void untickCheckboxQuickStatistics() {
        WebUI.clickElement(checkboxQuickStatistics);
        WebUI.waitForPageLoaded();
    }

    public void verifyCheckboxQuickStatistics() {
        SoftAssert softAssert = new SoftAssert();

        WebUI.sleep(1);
        softAssert.assertTrue(WebUI.checkElementIsSelected(checkboxQuickStatistics), "Fail. The value of the checkbox Quick Statistics NOT match");
        softAssert.assertTrue(WebUI.checkElementDisplayed(sectionQuickStatistics), "Fail. The section Quick Statistics NOT display");
        softAssert.assertAll();
    }

    public void verifyUntickCheckboxQuickStatistics() {
        WebUI.sleep(1);
        Assert.assertFalse(WebUI.checkElementIsSelected(checkboxQuickStatistics), "Fail. The checkbox Quick Statistics được tick");
        Assert.assertFalse(WebUI.checkElementDisplayed(sectionQuickStatistics), "Fail. The section Quick Statistics display");
        WebUI.sleep(5);
        WebUI.clickElement(checkboxQuickStatistics);
        WebUI.waitForPageLoaded();
    }

    public void checkTotalInvoicesAwaitingPayment() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalInvoicesAwaitingPayment), "The Invoices Awaiting Payment NOT exits.");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalInvoicesAwaitingPayment), "The Invoices Awaiting Payment Not displays");
        softAssert.assertEquals(WebUI.getElementText(totalInvoicesAwaitingPayment), totalInvoicesAwaitingPaymentExpected, "FAIL. Total Invoices Awaiting Payment NOT match.");
        System.out.println("\uD83C\uDF3ATotal Invoices Awaiting Payment: " + WebUI.getElementText(totalInvoicesAwaitingPayment));
        softAssert.assertAll();
    }

    public void checkTotalConvertedLeads() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalConvertedLeads), "The Converted Leads NOT exits.");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalConvertedLeads), "The Converted Leads Not displays");
        softAssert.assertEquals(WebUI.getElementText(totalConvertedLeads), totalConvertedLeadsExpected, "FAIL. Total Converted Leads NOT match.");
        System.out.println("\uD83C\uDF3AConverted Leads: " + WebUI.getElementText(totalConvertedLeads));
        softAssert.assertAll();
    }

    public void checkTotalProjectsInProgress() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalProjectsInProgress), "The Projects In Progress NOT exits.");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalProjectsInProgress), "The Projects In Progress Not displays");
        softAssert.assertEquals(WebUI.getElementText(totalProjectsInProgress), totalProjectsInProgressExpected, "FAIL. Total Projects In Progress NOT match.");
        System.out.println("\uD83C\uDF3AProjects In Progress: " + WebUI.getElementText(totalProjectsInProgress));
        softAssert.assertAll();
    }

    public void checkTotalTasksNotFinished() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalTasksNotFinished), "The Tasks Not Finished NOT exits.");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalTasksNotFinished), "The Tasks Not Finished Not displays");
        softAssert.assertEquals(WebUI.getElementText(totalTasksNotFinished), totalTasksNotFinishedExpected, "FAIL. Total Tasks Not Finished NOT match.");
        System.out.println("\uD83C\uDF3ATasks Not Finished: " + WebUI.getElementText(totalTasksNotFinished));
        softAssert.assertAll();
    }


    public void verifyMenuReportDisplay() {
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(menuReports), "Menu report NOT exit.");
        Assert.assertTrue(WebUI.checkElementDisplayed(menuReports), "Menu report Not displayed.");
    }

    public void verifyMenuReportNotDisplay() {
        WebUI.waitForPageLoaded();
        Assert.assertFalse(WebUI.checkElementExist(menuReports), "Menu Reporst is exist.");

    }

    public LoginPage logout() {
        WebUI.clickElement(dropdownProfile);
        WebUI.clickElement(optionLogout);
        WebUI.waitForPageLoaded();

        return new LoginPage();

    }
}
