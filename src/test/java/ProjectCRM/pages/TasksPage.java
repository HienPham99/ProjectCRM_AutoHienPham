package ProjectCRM.pages;

import drivers.DriverManager;
import helpers.ExcelHelper;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class TasksPage {

    private String headerTasksExpected = "Tasks Summary";

    private String totalNotStartedExpected = "1";
    private String totalInProgressExpected = "13";
    private String totalTestingExpected = "0";
    private String totalAwaitingFeedbackExpected = "0";
    private String totalCompleteExpected = "2";

    private By headerTasks = By.xpath("//span[normalize-space()='Tasks Summary']");

    private By iconSwitch = By.xpath("(//a[normalize-space()='New Task']/following::a)[1]");
    private By formSwitch = By.xpath("//div[@id='kan-ban-tab']");
    private By totalNotStarted = By.xpath("//span[normalize-space()='Not Started']/preceding-sibling::span");
    private By totalInProgress = By.xpath("//span[normalize-space()='In Progress']/preceding-sibling::span");
    private By totalTesting = By.xpath("//span[normalize-space()='Testing']/preceding-sibling::span");
    private By totalAwaitingFeedback = By.xpath("//span[normalize-space()='Awaiting Feedback']/preceding-sibling::span");
    private By totalComplete = By.xpath("//span[normalize-space()='Complete']/preceding-sibling::span");

    private By optionPage = By.xpath("//div[@id='tasks_length']");
    private By inputSearch = By.xpath("//div[@id='tasks_filter']//input");
    private By checkboxAll = By.xpath("//input[@id='mass_select_all']");
    private By totalPage = By.xpath("//div[@id='tasks_info']");
    //private By fistItemTaskOnTableAll = By.xpath("//table//tbody//tr[1]/td[3]");
    private By firstItemTaskOnTableAddNew = By.xpath("//*[@id=\"tasks\"]/tbody/tr/td[3]/a");
    private By pageTotal = By.xpath("//div[@id='tasks_info']");

    private By buttonAddNewTask = By.xpath("//a[normalize-space()='New Task']");
    private By formAddNewTask = By.xpath("//div[@id='_task_modal']//div[@class='modal-content']");
    private By headerFormAddNewTask = By.xpath("//h4[@id='myModalLabel']");
    private By checkboxPublic = By.xpath("//input[@id='task_is_public']");
    private By inputSubject = By.xpath("//input[@id='name']");
    private By inputHourlyRate = By.xpath("//input[@id='hourly_rate']");
    private By inputDueDate = By.xpath("//input[@id='duedate']");
    private By dropdownPriority = By.xpath("//button[@data-id='priority']");
    private By optionPriority = By.xpath("//span[normalize-space()='High']");
    private By dropdownRepeatEvery = By.xpath("//button[@data-id='repeat_every']");
    private By optionRepeatEvery = By.xpath("//span[normalize-space()='1 Year']");
    private By buttonSave = By.xpath("//button[normalize-space()='Save']");

    private By formAddTaskSuccess=By.xpath("//*[@id=\"task-modal\"]/div/div");
    private By iconX = By.xpath("//*[@id=\"task-modal\"]/div/div/div[1]/button/span");

    private By buttonTasksOverview = By.xpath("//a[normalize-space()='Tasks Overview']");
    private By headerFormTasksOverview = By.xpath("//*[@id=\"wrapper\"]/div/div/div/form");
    private By monthDisplay = By.xpath("//*[@id=\"wrapper\"]/div/div/div/div/div/h4");
    private By buttonBackToTasksList = By.xpath("//*[@id=\"wrapper\"]/div/div/div/form/div/div[1]/a");

    public void verifyHeaderTasks() {
        WebUI.waitForPageLoaded();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(headerTasks), "Header Task NOT exist");
        softAssert.assertTrue(WebUI.checkElementDisplayed(headerTasks), "Header Task NOT display");
        softAssert.assertEquals(WebUI.getElementText(headerTasks), headerTasksExpected, "Content header task NOT match.");
        softAssert.assertAll();
    }

    public void checkTotalNotStarted() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalNotStarted), "Not Started NOT exist");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalNotStarted), "Not Started NOT display");
        softAssert.assertEquals(WebUI.getElementText(totalNotStarted), totalNotStartedExpected, "Content Not Started NOT match.");
        System.out.println("\uD83C\uDF3ATotal Not Started is: " + WebUI.getElementText(totalNotStarted));
        softAssert.assertAll();
    }

    public void checkTotalInProgress() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalInProgress), "Total In Progress NOT exist");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalInProgress), "Total In Progress NOT display");
        softAssert.assertEquals(WebUI.getElementText(totalInProgress), totalInProgressExpected, "Total In Progress NOT match.");
        System.out.println("\uD83C\uDF3ATotal In Progress is: " + WebUI.getElementText(totalInProgress));
        softAssert.assertAll();
    }

    public void checkTotalTesting() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalTesting), "Total Testing NOT exist");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalTesting), "Total Testing NOT display");
        softAssert.assertEquals(WebUI.getElementText(totalTesting), totalTestingExpected, "Total Testing NOT match.");
        System.out.println("\uD83C\uDF3ATotal Testing is: " + WebUI.getElementText(totalTesting));
        softAssert.assertAll();
    }

    public void checkTotalAwaitingFeedback() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalAwaitingFeedback), "Total Awaiting Feedback NOT exist");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalAwaitingFeedback), "Total Awaiting Feedback NOT display");
        softAssert.assertEquals(WebUI.getElementText(totalAwaitingFeedback), totalAwaitingFeedbackExpected, "Total Awaiting Feedback NOT match.");
        System.out.println("\uD83C\uDF3ATotal Awaiting Feedback is: " + WebUI.getElementText(totalAwaitingFeedback));
        softAssert.assertAll();
    }

    public void checkTotalComplete() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalComplete), "Total Complete NOT exist");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalComplete), "Total Complete NOT display");
        softAssert.assertEquals(WebUI.getElementText(totalComplete), totalCompleteExpected, "Total Complete NOT match.");
        System.out.println("\uD83C\uDF3ATotal Complete is: " + WebUI.getElementText(totalComplete));
        softAssert.assertAll();
    }

    public void checkAllTotalTasks() {
        WebUI.waitForPageLoaded();
        checkTotalNotStarted();
        checkTotalInProgress();
        checkTotalTesting();
        checkTotalAwaitingFeedback();
        checkTotalComplete();
    }

    public void countDataTableTasks() {
        String strTotal = WebUI.getElementText(pageTotal);
        ArrayList<String> list = new ArrayList<String>();

        for (String strItem : strTotal.split("\\s")) {
            list.add(strItem);
        }
        int itemTotal = Integer.parseInt(list.get(5));
        System.out.println("\uD83D\uDC9DTìm được " + itemTotal + " item.");

    }

    public void verifyWhenClickIconSwitch() {
        WebUI.clickElement(iconSwitch);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(formSwitch), "Form data after switch NOT exists");
        Assert.assertTrue(WebUI.checkElementDisplayed(formSwitch), "Form data after switch NOT displayed");
        WebUI.sleep(1);
        WebUI.clickElement(iconSwitch);
    }

    public void verifyWhenClickTaskOverviewButton() {
        WebUI.clickElement(buttonTasksOverview);
        WebUI.waitForPageLoaded();
        SoftAssert softAssert=new SoftAssert();
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("detailed_overview"), "Vẫn ở form Task page.");
        softAssert.assertTrue(WebUI.checkElementExist(headerFormTasksOverview), "Form Task Overview NOT exists");
        softAssert.assertTrue(WebUI.checkElementExist(monthDisplay), "Tháng hiện tại NOT exists");
        softAssert.assertTrue(WebUI.checkElementDisplayed(headerFormTasksOverview), "Form Task Overview NOT displayed");
        softAssert.assertTrue(WebUI.checkElementDisplayed(monthDisplay), "Tháng hiện tại NOT displayed");
        softAssert.assertEquals(WebUI.getElementText(monthDisplay), "June", "Tháng?");
        softAssert.assertAll();
        WebUI.sleep(1);
        WebUI.clickElement(buttonBackToTasksList);
    }

    public void addNewTask(String SUBJECT){
        WebUI.clickElement(buttonAddNewTask);
        WebUI.waitForPageLoaded();
        WebUI.clickElement(checkboxPublic);
        WebUI.setText(inputSubject, SUBJECT);
        WebUI.setKey(inputHourlyRate, Keys.CLEAR);
        WebUI.setText(inputHourlyRate, "124");
        WebUI.setText(inputDueDate, "31-12-2025");
        WebUI.clickElement(dropdownPriority);
        WebUI.sleep(1);
        WebUI.clickElement(optionPriority);
        WebUI.sleep(1);
        WebUI.clickElement(dropdownRepeatEvery);
        WebUI.sleep(1);
        WebUI.clickElement(optionRepeatEvery);
        WebUI.clickElement(buttonSave);
        WebUI.sleep(2);
    }
    public void verifyAddTaskSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(formAddTaskSuccess),"Form add task NOT exist");
        Assert.assertTrue(WebUI.checkElementDisplayed(formAddTaskSuccess),"Form add task NOT displayed");
        WebUI.sleep(5);
        WebUI.clickElement(iconX);
    }

    public void searchTask(String SUBJECT){
        WebUI.setText(inputSearch,SUBJECT);
        WebUI.sleep(1);
        Assert.assertTrue(WebUI.checkElementExist(firstItemTaskOnTableAddNew),"Task name NOT exists");
        Assert.assertTrue(WebUI.checkElementDisplayed(firstItemTaskOnTableAddNew),"Task name NOT displayed");
        WebUI.clickElement(firstItemTaskOnTableAddNew);
        System.out.println("\uD83C\uDF49Keyword Task search is: " + SUBJECT);
        WebUI.waitForPageLoaded();
        verifyAddTaskSuccess();
    }



}
