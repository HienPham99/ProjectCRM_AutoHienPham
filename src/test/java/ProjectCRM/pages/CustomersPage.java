package ProjectCRM.pages;

import drivers.DriverManager;
import keywords.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomersPage {

    private String headerCustomerContent = "Customers Summary";

    private String totalTotalCustomersExpected = "458";
    private String totalActiveCustomersExpected = "441";
    private String totalInactiveCustomersExpected = "17";
    private String totalActiveContactsExpected = "16";
    private String totalInactiveContactsExpected = "1";
    private String totalContactsLoggedInTodayExpected = "0";

    private By headerCustomers = By.xpath("//span[normalize-space()='Customers Summary']");
    private By buttonAddNewCustomers = By.xpath("//div[@id='wrapper']//a[normalize-space()='New Customer']");
    private By inputSearchCustomer = By.xpath("//div[@id='clients_filter']/descendant::input");
    private By buttonImportCustomers = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//a[contains(@href,'clients/all_contacts')]");

    private By sectionCustomers = By.xpath("(//span[normalize-space()='Customers Summary']/ancestor::h4)/following::div[1]");
    private By totalCustomers = By.xpath("//span[normalize-space()='Total Customers']/preceding-sibling::span");
    private By totalActiveCustomers = By.xpath("//span[normalize-space()='Active Customers']/preceding-sibling::span");
    private By totalInactiveCustomers = By.xpath("//span[normalize-space()='Inactive Customers']/preceding-sibling::span");
    private By totalActiveContacts = By.xpath("//span[normalize-space()='Active Contacts']/preceding-sibling::span");
    private By totalInactiveContacts = By.xpath("//span[normalize-space()='Inactive Contacts']/preceding-sibling::span");
    private By totalContactsLoggedInToday = By.xpath("//span[normalize-space()='Contacts Logged In Today']/preceding-sibling::span");

    private By buttonNext=By.xpath("//a[normalize-space()='Next']");
    private By optionDisplayPage = By.xpath("//select[@name='clients_length']");
    //Add New customers
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVAT = By.xpath("//input[@id='vat']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By dropdownGroup = By.xpath("//button[@data-id='groups_in[]']");
    private By inputSearchGroup = By.xpath("//div[@app-field-wrapper='groups_in[]']//input[@type='search']");
    private By fieldGroup = By.xpath("//div[contains(text(),'Gold')]");
    private By dropdownCurrency = By.xpath("//label[normalize-space()='Currency']/following-sibling::div/button[@data-id='default_currency']");
    private By inputSearchCurrency = By.xpath("//div[@app-field-wrapper='default_currency']//input[@type='search']");
    private By dropdownDefaultLanguage = By.xpath("//label[normalize-space()='Default Language']/following-sibling::div//button[@type='button']");
    private By optionDefaultLanguage = By.xpath("//span[normalize-space()='Vietnamese']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By dropdownCountry = By.xpath("//label[@for='country']/following-sibling::div//button[@type='button']");
    private By inputSearchCountry = By.xpath("//div[@app-field-wrapper='country']//input[@type='search']");
    private By buttonSave = By.xpath("//div[@id='profile-save-section']//button[2]");
    private By buttonSaveAndCreateContact = By.xpath("//div[@id='profile-save-section']//button[1]");

    public static By pageTotal = By.xpath("//div[@id='clients_info']");
    private By fistItemcustomerOnTable = By.xpath("//td[@class='sorting_1']/a");

    public void verifyHeaderCustomerPage() {
        SoftAssert softAssert = new SoftAssert();
        WebUI.waitForPageLoaded();
        WebUI.waitForElementVisible(headerCustomers);
        softAssert.assertTrue(WebUI.checkElementDisplayed(headerCustomers), "Header Customers NOT displayed.");
        softAssert.assertEquals(WebUI.getElementText(headerCustomers), headerCustomerContent, "Conten Header Customers NOT match.");
        System.out.println("\uD83C\uDF81Actual Header của Customers page là: " + WebUI.getElementText(headerCustomers));
        System.out.println("☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️");
        softAssert.assertAll();
    }

    public void checkTotalCustomers() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalCustomers), "The Total Customers NOT exits.");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalCustomers), "The Total Customers Not displays");
        softAssert.assertEquals(WebUI.getElementText(totalCustomers), totalTotalCustomersExpected, "FAIL. The Total Customers NOT match.");
        System.out.println("\uD83C\uDF3ATotal Customers: " + WebUI.getElementText(totalCustomers));
        softAssert.assertAll();
    }

    public void checkActiveCustomers() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalActiveCustomers), "The Active Customers NOT exits.");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalActiveCustomers), "The Active Customers Not displays");
        softAssert.assertEquals(WebUI.getElementText(totalActiveCustomers), totalActiveCustomersExpected, "FAIL. The Active Customers NOT match.");
        System.out.println("\uD83C\uDF3AActive Customers: " + WebUI.getElementText(totalActiveCustomers));
        softAssert.assertAll();
    }

    public void checkInactiveCustomers() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalInactiveCustomers), "The Inactive Customers NOT exits.");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalInactiveCustomers), "The Inactive Customers Not displays");
        softAssert.assertEquals(WebUI.getElementText(totalInactiveCustomers), totalInactiveCustomersExpected, "FAIL. The Inactive Customers NOT match.");
        System.out.println("\uD83C\uDF3AInactive Customers: " + WebUI.getElementText(totalInactiveCustomers));
        softAssert.assertAll();
    }

    public void checkActiveContacts() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalActiveContacts), "The Active Contacts NOT exits.");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalActiveContacts), "The Active Contacts Not displays");
        softAssert.assertEquals(WebUI.getElementText(totalActiveContacts), totalActiveContactsExpected, "FAIL. The Active Contacts NOT match.");
        System.out.println("\uD83C\uDF3AActive Contacts: " + WebUI.getElementText(totalActiveContacts));
        softAssert.assertAll();
    }

    public void checkInactiveContacts() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalInactiveContacts), "The Inactive Contacts NOT exits.");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalInactiveContacts), "The Inactive Contacts Not displays");
        softAssert.assertEquals(WebUI.getElementText(totalInactiveContacts), totalInactiveContactsExpected, "FAIL. The Inactive Contacts NOT match.");
        System.out.println("\uD83C\uDF3AInactive Contacts: " + WebUI.getElementText(totalInactiveContacts));
        softAssert.assertAll();
    }

    public void checkContactsLoggedInToday() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalContactsLoggedInToday), "The Contacts Logged In Today NOT exits.");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalContactsLoggedInToday), "The Contacts Logged In Today Not displays");
        softAssert.assertEquals(WebUI.getElementText(totalContactsLoggedInToday), totalContactsLoggedInTodayExpected, "FAIL. The Contacts Logged In Today NOT match.");
        System.out.println("\uD83C\uDF3AOntacts Logged In Today: " + WebUI.getElementText(totalContactsLoggedInToday));
        System.out.println("☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️");
        softAssert.assertAll();
    }

    public void clickButtonAddNewCustomer() {
        WebUI.clickElement(buttonAddNewCustomers);
    }

    public void inputFormData(String COMPANY_NAME) {
        WebUI.setText(inputCompany, COMPANY_NAME);
        WebUI.setText(inputVAT, "10");
        WebUI.setText(inputPhone, "09876543218");
        WebUI.setText(inputWebsite, "merkle.com");
        WebUI.clickElement(dropdownGroup);
        WebUI.sleep(1);
        WebUI.setText(inputSearchGroup, "Gold");
        WebUI.sleep(1);
        WebUI.setKey(inputSearchGroup, Keys.ENTER);
        WebUI.clickElement(dropdownGroup);
        WebUI.setText(inputAddress, "Cầu Giấy");
        WebUI.setText(inputCity, "Ha Noi");
        WebUI.setText(inputState, "Ha Noi");
        WebUI.setText(inputZipCode, "15200");
        WebUI.clickElement(dropdownCountry);
        WebUI.sleep(1);
        WebUI.setText(inputSearchCountry, "Vietnam");
        WebUI.sleep(1);
        WebUI.setKey(inputSearchCountry, Keys.ENTER);
        WebUI.clickElement(buttonSave);
        WebUI.sleep(5);
    }

    public void searchAndVerifyCustomer(String COMPANY_NAME) {
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(fistItemcustomerOnTable), "COMPANY_NAME  NOT exists.");
        Assert.assertTrue(WebUI.checkElementDisplayed(fistItemcustomerOnTable), "Không tìm thấy COMPANY_NAME vừa add.");
        WebUI.sleep(2);
        verifyCustomerDetail(COMPANY_NAME);

    }

    public void searchCustomerNewAdd(String COMPANY_NAME) {
        WebUI.setText(inputSearchCustomer, COMPANY_NAME);
        WebUI.waitForPageLoaded();
    }


    public void searchCustomerNomal(String searchValue) {
        WebUI.setText(inputSearchCustomer, searchValue);
        WebUI.waitForPageLoaded();
    }


    public void verifyCustomerDetail(String COMPANY_NAME) {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(fistItemcustomerOnTable);
        Assert.assertEquals(WebUI.getElementAttribute(inputCompany, "value"), COMPANY_NAME, "Company NOT match.");
        Assert.assertEquals(WebUI.getElementAttribute(inputVAT, "value"), "10", "VAT NOT match.");
        Assert.assertEquals(WebUI.getElementAttribute(inputPhone, "value"), "09876543218", "Phone NOT match.");
        Assert.assertEquals(WebUI.getElementAttribute(inputWebsite, "value"), "merkle.com", "WEB NOT match.");

        Assert.assertEquals(WebUI.getElementText(dropdownGroup), "Gold", "Data Group NOT match.");

        Assert.assertEquals(WebUI.getElementAttribute(inputAddress, "value"), "Cầu Giấy", "Address NOT match.");
        Assert.assertEquals(WebUI.getElementAttribute(inputCity, "value"), "Ha Noi", "City NOT match.");
        Assert.assertEquals(WebUI.getElementAttribute(inputState, "value"), "Ha Noi", "State NOT match.");
        Assert.assertEquals(WebUI.getElementAttribute(inputZipCode, "value"), "15200", "ZipCode NOT match.");

    }

    public void verifySearchTableByColumn(int total, int column, String value) {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> rows = DriverManager.getDriver().findElements(By.xpath("//table//tbody/tr"));
        int rowsCount = rows.size();
        System.out.println("  ");
        System.out.println("♻️ Hiển thị " + rowsCount + "dòng dữ liệu trên 1 page.");
        //softAssert.assertEquals(rowsCount, checkPageTotal(),"");

        String pageTotalText = WebUI.getElementText(pageTotal);
        System.out.println("⭐️ Content hiển thị ở chân page là: " + pageTotalText);

        String pageTotalNumber = pageTotalText.split(" ")[5];
        System.out.println("✅ Tổng số dữ liệu(entries) tìm được là: " + pageTotalNumber);
        softAssert.assertEquals(Integer.parseInt(pageTotalNumber), total, "The page total number not match.");

        for (int i = 1; i <= rowsCount; i++) {
            WebElement elementCheck = DriverManager.getDriver().findElement(By.xpath("//table//tbody/tr[" + i + "]/td[" + column + "]"));

            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", elementCheck);

            softAssert.assertAll();

            System.out.print(value + " - ");
            System.out.println(elementCheck.getText());
            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");

        }
    }

    public void checkSearchTableByColumn1(int column, String value) {

        //Xác định số dòng của table sau khi search trên 1 page
        List<WebElement> row = DriverManager.getDriver().findElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size();
        System.out.println("  ");
        System.out.println("Hiển thị " + rowTotal + " dòng dữ liệu trên 1 Page.");

        //Duyệt từng dòng theo lệnh for.
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = DriverManager.getDriver().findElement(By.xpath("//table//tbody/tr[" + i + "]/td[" + column + "]"));

            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", elementCheck);

            System.out.print(value + " - ");
            System.out.println(elementCheck.getText());
            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }
    }

    //Hàm check full item-> số page và số data trên 1 page trước khi search.
    public void checkDataTableAll() {
        Select select = new Select(WebUI.getWebElement(optionDisplayPage));
        select.selectByVisibleText("50");
        WebUI.sleep(1);

        LogUtils.info(select.getFirstSelectedOption().getText());

        int itemTotalOnePage = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println("Tổng số " + itemTotalOnePage + "item/page.");

        //Get total item
        String strTotal = WebUI.getElementText(By.xpath("//div[@id='clients_info']"));
        ArrayList<String> list = new ArrayList<String>();

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

    public void checkDataAfterSearch(String value) {
        //Get item on One Page
        Select select = new Select(WebUI.getWebElement(optionDisplayPage));
        select.selectByVisibleText("25");
        WebUI.sleep(1);
        LogUtils.info(select.getFirstSelectedOption().getText());

        int itemTotalOnePage = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println("Tổng số " + itemTotalOnePage + "item/page.");

        searchCustomerNomal(value);
        //Get total item
        String strTotal = WebUI.getElementText(By.xpath("//div[@id='clients_info']"));
        ArrayList<String> list = new ArrayList<String>();

        for (String strItem : strTotal.split("\\s")) {
            list.add(strItem);
        }

        String pageTotalText = WebUI.getElementText(pageTotal);
        System.out.println("⭐️ Content hiển thị ở chân page là: " + pageTotalText);

        int itemTotal = Integer.parseInt(list.get(5));
        System.out.println("Tổng số " + itemTotal + " item");
        int pageTotal = itemTotal / itemTotalOnePage;
        int sodu = itemTotal % itemTotalOnePage;
        System.out.println("Trong đó có Tổng số nguyên là: " + pageTotal);
        System.out.println("Và dư: " + sodu + " item");

        if (sodu > 0) {
            pageTotal = pageTotal + 1;
        }

        System.out.println("===> Tổng số Page: " + pageTotal);

        for (int i = 1; i <= pageTotal; i++) {
            checkSearchTableByColumn1(3, value);

            if (i < pageTotal) {
                WebUI.clickElement(buttonNext);
                WebUI.sleep(5);
            }
        }
    }

}

