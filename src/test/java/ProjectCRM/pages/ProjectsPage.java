package ProjectCRM.pages;

import drivers.DriverManager;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class ProjectsPage {

    private String headerProjectExpected = "Projects Summary";

    private String totalNotStartedExpected = "0";
    private String totalInProgressExpected = "23";
    private String totalOnHoldExpected = "0";
    private String totalCancelledExpected = "0";
    private String totalFinishedExpected = "1";

    private By headerProject = By.xpath("//span[normalize-space()='Projects Summary']");

    private By totalNotStarted = By.xpath("//span[normalize-space()='Not Started']/preceding-sibling::span");
    private By totalInProgress = By.xpath("//span[normalize-space()='In Progress']/preceding-sibling::span");
    private By totalOnHold = By.xpath("//span[normalize-space()='On Hold']/preceding-sibling::span");
    private By totalCancelled = By.xpath("//span[normalize-space()='Cancelled']/preceding-sibling::span");
    private By totalFinished = By.xpath("//span[normalize-space()='Finished']/preceding-sibling::span");

    private By optionValuePage = By.xpath("//div[@id='projects_length']//select");

    private By inputSearch = By.xpath("(//input[@type='search'])[2]");////div[@id='projects_filter']//input[@type='search']
    private By pageTotal = By.xpath("//div[@id='projects_info']");
    private By buttonNext = By.xpath("//div[@id='projects_wrapper']//a[normalize-space()='Next']");
    private By fistItemProjectOnTable = By.xpath("//table//tbody//tr[1]//td[2]");

    private By buttonAddNewProject = By.xpath("//div[@id='vueApp']//a[normalize-space()='New Project']");
    private By headerAddNewProject = By.xpath("//h4[normalize-space()='Add new project']");
    private By inputProjectName = By.xpath("//input[@id='name']");
    private By dropdownCustomer = By.xpath("//button[@data-id='clientid']");
    private By inputSearchCustomer = By.xpath("(//select[@id='clientid']/following::div//input[@type='search'])[1]");
    private By inputOptionCustomer = By.xpath("(//div[@id='bs-select-6']//ul[@role='presentation']//span)[2]");//span[normalize-space()='Merkle Software A6']";
    private By dropdownBillingType = By.xpath("//button[@data-id='billing_type']");
    private By inputBillingType = By.xpath("//button[@data-id='billing_type']/following::a[normalize-space()='Fixed Rate']");
    private By dropdownStatus = By.xpath("//button[@data-id='status']");
    private By inputStatus = By.xpath("//span[normalize-space()='In Progress']");
    private By buttonSave = By.xpath("//button[@type='submit']");

    public void verifyHeaderProjectPage() {
        SoftAssert softAssert = new SoftAssert();
        WebUI.waitForPageLoaded();
        WebUI.waitForElementVisible(headerProject);
        softAssert.assertTrue(WebUI.checkElementDisplayed(headerProject), "Header Project NOT displayed.");
        softAssert.assertEquals(WebUI.getElementText(headerProject), headerProjectExpected, "Conten Header Project NOT match.");

        System.out.println("\uD83C\uDF81Actual Header của Project page là: " + WebUI.getElementText(headerProject));
        System.out.println("☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️");
        softAssert.assertAll();
    }

    public void checkTotalNotStarted() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalNotStarted), "The Not Started NOT exits.");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalNotStarted), "The Not Started Not displays");
        softAssert.assertEquals(WebUI.getElementText(totalNotStarted), totalNotStartedExpected, "FAIL. The Not Started NOT match.");
        System.out.println("\uD83C\uDF3ANot Started: " + WebUI.getElementText(totalNotStarted));
        softAssert.assertAll();
    }

    public void checkTotalInProgress() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalInProgress), "The In Progress NOT exits.");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalInProgress), "The In Progress Not displays");
        softAssert.assertEquals(WebUI.getElementText(totalInProgress), totalInProgressExpected, "FAIL. The In Progress NOT match.");
        System.out.println("\uD83C\uDF3AIn Progress: " + WebUI.getElementText(totalInProgress));
        softAssert.assertAll();
    }

    public void checkTotalOnHold() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalOnHold), "The On Hold NOT exits.");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalOnHold), "The On Hold Not displays");
        softAssert.assertEquals(WebUI.getElementText(totalOnHold), totalOnHoldExpected, "FAIL. The On Hold NOT match.");
        System.out.println("\uD83C\uDF3AOn Hold: " + WebUI.getElementText(totalOnHold));
        softAssert.assertAll();
    }

    public void checkTotalCancelled() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalCancelled), "The Cancelled NOT exits.");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalCancelled), "The Cancelled Not displays");
        softAssert.assertEquals(WebUI.getElementText(totalCancelled), totalCancelledExpected, "FAIL. The Cancelled NOT match.");
        System.out.println("\uD83C\uDF3ACancelled: " + WebUI.getElementText(totalCancelled));
        softAssert.assertAll();
    }

    public void checkTotalFinished() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalFinished), "The Finished NOT exits.");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalFinished), "The Finished Not displays");
        softAssert.assertEquals(WebUI.getElementText(totalFinished), totalFinishedExpected, "FAIL. The Finished NOT match.");
        System.out.println("\uD83C\uDF3AFinished: " + WebUI.getElementText(totalFinished));
        softAssert.assertAll();
    }

    public void checkAllDataTable() {

        Select select = new Select(WebUI.getWebElement(optionValuePage));
        select.selectByVisibleText("10");//Lựa chọn giá trị hiển thị trên 1 page
        WebUI.sleep(1);

        LogUtils.info(select.getFirstSelectedOption().getText());

        int itemTotalOnePage = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println("Tổng số " + itemTotalOnePage + "item/page.");

        //Get total item
        String strTotal = WebUI.getElementText(pageTotal);
        ArrayList<String> list = new ArrayList<String>();

        //Tách khoảng trắng= "\\s"
        for (String strItem : strTotal.split("\\s")) {
            list.add(strItem);
        }

        String pageTotalText = WebUI.getElementText(pageTotal);
        System.out.println("⭐️ Content hiển thị ở chân page là: " + pageTotalText);

        int itemTotal = Integer.parseInt(list.get(5));
        System.out.println("Tổng số " + itemTotal + " item");
        int pageTotal = itemTotal / itemTotalOnePage;
        int sodu = itemTotal % itemTotalOnePage;
        System.out.println("Trong đó có Tổng số nguyên là: " + pageTotal + " _____pages.");
        System.out.println("Và dư: " + sodu + " item");

        if (sodu > 0) {
            pageTotal = pageTotal + 1;
        }

        System.out.println("===> Tổng số Page: " + pageTotal);

        for (int i = 1; i <= pageTotal; i++) {
            //Nhấn nút Next để đến trang tiếp theo
            if (i < pageTotal) {
                WebUI.clickElement(buttonNext);
                WebUI.sleep(5);
            }
        }
    }

    public void checkSearchTableByColumn(int column, String value) {
        List<WebElement> row = DriverManager.getDriver().findElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size(); //Lấy ra số dòng
        System.out.println("  ");
        System.out.println("Hiển thị " + rowTotal + " dòng dữ liệu trên 1 Page.");

        //Duyệt từng dòng theo lệnh for.
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = DriverManager.getDriver().findElement(By.xpath("//table//tbody/tr[" + i + "]/td[" + column + "]"));

            //Scroll xuống dưới trang.
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", elementCheck);

            System.out.print(value + " - "); //Expected
            System.out.println(elementCheck.getText()); //in ra kq Actual
            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }
    }


    public void checkDataTableAll() {
        Select select = new Select(WebUI.getWebElement(optionValuePage));
        select.selectByVisibleText("10");//Lựa chọn giá trị hiển thị trên 1 page
        WebUI.sleep(1);

        LogUtils.info(select.getFirstSelectedOption().getText());

        int itemTotalOnePage = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println("Tổng số " + itemTotalOnePage + "item/page.");

        //Get total item
        String strTotal = WebUI.getElementText(pageTotal);
        ArrayList<String> list = new ArrayList<String>();

        //Tách khoảng trắng= "\\s"
        for (String strItem : strTotal.split("\\s")) {
            list.add(strItem);
        }

        String pageTotalText = WebUI.getElementText(pageTotal);
        System.out.println("⭐️ Content hiển thị ở chân page là: " + pageTotalText);

        int itemTotal = Integer.parseInt(list.get(5));
        System.out.println("Tổng số " + itemTotal + " item");
        int pageTotal = itemTotal / itemTotalOnePage;
        int sodu = itemTotal % itemTotalOnePage;
        System.out.println("Trong đó có Tổng số nguyên là: " + pageTotal + " _____pages.");
        System.out.println("Và dư: " + sodu + " item");

        if (sodu > 0) {
            pageTotal = pageTotal + 1;
        }

        System.out.println("===> Tổng số Page: " + pageTotal);

        for (int i = 1; i <= pageTotal; i++) {
            //Nhấn nút Next để đến trang tiếp theo
            if (i < pageTotal) {
                WebUI.clickElement(buttonNext);
                WebUI.sleep(5);
            }
        }
    }

    public void clickButtonAddNewProject() {
        WebUI.clickElement(buttonAddNewProject);
    }

    public void addNewProject(String PROJECT_NAME) {
        // WebUI.waitForPageLoaded();
        WebUI.setText(inputProjectName, PROJECT_NAME);
        WebUI.clickElement(dropdownCustomer);
        WebUI.sleep(1);
        WebUI.setText(inputSearchCustomer, "Merkle Software A6");
        WebUI.sleep(2);
        WebUI.clickElement(inputOptionCustomer);
        WebUI.sleep(2);
        WebUI.clickElement(dropdownBillingType);
        WebUI.sleep(1);
        WebUI.setKey(inputBillingType, Keys.ENTER);
        WebUI.sleep(1);
        WebUI.clickElement(dropdownStatus);
        WebUI.sleep(1);
        WebUI.clickElement(inputStatus);
        WebUI.sleep(1);
        WebUI.clickElement(buttonSave);
    }

    public void searchAndVerifyProject(String PROJECT_NAME) {
        WebUI.setText(inputSearch, PROJECT_NAME);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(fistItemProjectOnTable), "PROJECT_NAME  NOT exists.");
        Assert.assertTrue(WebUI.checkElementDisplayed(fistItemProjectOnTable), "Không tìm thấy PROJECT_NAME vừa add.");
        WebUI.sleep(1);
        System.out.println("\uD83C\uDF81Project Name tìm thấy là: " + WebUI.getElementText(fistItemProjectOnTable));
        WebUI.clickElement(fistItemProjectOnTable);
        WebUI.sleep(1);
    }

    public void searchProjectNewAdd(String PROJECT_NAME) {
        WebUI.setText(inputSearch, PROJECT_NAME);
        WebUI.waitForPageLoaded();
    }

    public void searchProjectNomal(String searchValue) {
        WebUI.setText(inputSearch, searchValue);
        WebUI.waitForPageLoaded();
    }

    public void checkDataAfterSearch(String value) {
        //Get item on One Page
        Select select = new Select(WebUI.getWebElement(optionValuePage));
        select.selectByVisibleText("10");//Lựa chọn giá trị hiển thị trên 1 page
        WebUI.sleep(1);
        LogUtils.info(select.getFirstSelectedOption().getText());

        int itemTotalOnePage = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println("Tổng số " + itemTotalOnePage + "item/page.");

        searchProjectNomal(value);//search data: trả ra số lượng items
        //Get total item
        String strTotal = WebUI.getElementText(pageTotal);
        ArrayList<String> list = new ArrayList<String>();

        //Tách khoảng trắng= "\\s"
        for (String strItem : strTotal.split("\\s")) {
            list.add(strItem);
        }

        String pageTotalText = WebUI.getElementText(pageTotal);
        System.out.println("⭐️ Content hiển thị ở chân page là: " + pageTotalText);

        int itemTotal = Integer.parseInt(list.get(5));
        System.out.println("\uD83C\uDF45Tổng số " + itemTotal + " item");
        int pageTotal = itemTotal / itemTotalOnePage;
        int sodu = itemTotal % itemTotalOnePage;
        System.out.println("Trong đó có Tổng số nguyên là: " + pageTotal);
        System.out.println("Và dư: " + sodu + " item");

        if (sodu > 0) {
            pageTotal = pageTotal + 1;
        }

        System.out.println("===> Tổng số Page: " + pageTotal);

        for (int i = 1; i <= pageTotal; i++) {
            checkSearchTableByColumn(3, value);
            //Nhấn nút Next để đến trang tiếp theo
            if (i < pageTotal) {
                WebUI.clickElement(buttonNext);
                WebUI.sleep(5);
            }
        }
    }

}
