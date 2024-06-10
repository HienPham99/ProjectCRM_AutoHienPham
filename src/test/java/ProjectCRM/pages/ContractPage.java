package ProjectCRM.pages;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class ContractPage {

    private String headerContractExpected = "Contract Summary";
    private String totalActiveExpected = "13";
    private String totalExpiredExpected = "1";
    private String totalAboutToExpireExpected = "1";
    private String totalRecentlyAddedExpected = "11";
    private String totalTrashExpected = "0";

    private String notiMessageExpected = "Contract added successfully";
    private By headerContract = By.xpath("//span[normalize-space()='Contract Summary']");
    private By bieuDoContract = By.xpath("//*[@id=\"wrapper\"]/div/div/div/div[2]/div/div[1]");

    private By buttonAddNewContract = By.xpath("//a[normalize-space()='New Contract']");
    private By dropdownCustomer = By.xpath("//button[@data-id='clientid']");
    private By inputCustomer = By.xpath("//*[@id=\"contract-form\"]/div[2]/div/div/div[1]/input");
    private By optionCustomer = By.xpath("//span[normalize-space()='Merkle Blucom']");
    private By inputSubject = By.xpath("//input[@id='subject']");
    private By inputContractValue = By.xpath("//label[normalize-space()='Contract Value']/following-sibling::div//input");
    private By dropdownContractType = By.xpath("//label[normalize-space()='Contract type']/following-sibling::div//button");
    private By inputContracType = By.xpath("//label[normalize-space()='Contract type']/following-sibling::div//input");
    private By optionContractType = By.xpath("//span[normalize-space()='Credit Contract']");
    private By inputStartDate = By.xpath("//input[@id='datestart']");
    private By inputEndDate = By.xpath("//input[@id='dateend']");
    private By textAreaDescription = By.xpath("//textarea[@id='description']");
    private By buttonSave = By.xpath("//textarea[@id='description']/parent::div/following-sibling::div//button");
    private By notifileMessage = By.xpath("//span[@class='alert-title']");

    private By totalActive = By.xpath("//span[contains(.,'Active')]/preceding-sibling::span");
    private By totalExpired = By.xpath("//span[normalize-space()='Expired']/preceding-sibling::span");
    private By totalAbouttoExpire = By.xpath("//span[normalize-space()='About to Expire']/preceding-sibling::span");
    private By totalRecentlyAdded = By.xpath("//span[normalize-space()='Recently Added']/preceding-sibling::span");
    private By totalTrash = By.xpath("//span[normalize-space()='Trash']/preceding-sibling::span");

    private By fishItemContractsOnTable = By.xpath("//table//tbody//tr[1]//td[2]");
    private By iconView = By.xpath("//*[@id=\"contracts\"]/tbody/tr[1]/td[2]/div/a[1]");
    private By iconDelete = By.xpath("(//table[@id='contracts']//a[normalize-space()='Delete'])[1]");
    private By allDataContract = By.xpath("//tbody");
    private By inputSearch = By.xpath("//*[@id=\"contracts_filter\"]/label/div/input"); //div[@id='contracts_filter']//input");
    private By totalPage = By.xpath("//div[@id='contracts_info']");

    public void verifyHeaderContracts() {
        WebUI.waitForPageLoaded();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(headerContract), "\uD83D\uDCA5Header Contract NOT exist");
        softAssert.assertTrue(WebUI.checkElementDisplayed(headerContract), "\uD83D\uDCA5Header Contract NOT display");
        softAssert.assertEquals(WebUI.getElementText(headerContract), headerContractExpected, "\uD83D\uDCA5The Content Header Contract NOT match");
        System.out.println("\\uD83C\uDF81Content header contract actual is: " + WebUI.getElementText(headerContract));
        softAssert.assertAll();
    }

    public void checkTotalActive() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalActive), "\uD83D\uDCA5Total Active NOT exist");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalActive), "\uD83D\uDCA5Total Active NOT display");
        softAssert.assertEquals(WebUI.getElementText(totalActive), totalActiveExpected, "\uD83D\uDCA5Total Active NOT match");
        System.out.println("\uD83C\uDF3ATotal Active actual is: " + WebUI.getElementText(totalActive));
        softAssert.assertAll();
    }

    public void checkTotalExpired() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalExpired), "\uD83D\uDCA5Total Expired NOT exist");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalExpired), "\uD83D\uDCA5Total Expired NOT display");
        softAssert.assertEquals(WebUI.getElementText(totalExpired), totalExpiredExpected, "\uD83D\uDCA5Total Expired NOT match");
        System.out.println("\uD83C\uDF3ATotal Expired actual is: " + WebUI.getElementText(totalExpired));
        softAssert.assertAll();
    }

    public void checkTotalAbouttoExpire() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalAbouttoExpire), "\uD83D\uDCA5Total About to Expire NOT exist");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalAbouttoExpire), "\uD83D\uDCA5Total About to Expire NOT display");
        softAssert.assertEquals(WebUI.getElementText(totalAbouttoExpire), totalAboutToExpireExpected, "\uD83D\uDCA5Total About to Expire NOT match");
        System.out.println("\uD83C\uDF3ATotal About to Expire actual is: " + WebUI.getElementText(totalAbouttoExpire));
        softAssert.assertAll();
    }

    public void checkTotalRecentlyAdded() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalRecentlyAdded), "\uD83D\uDCA5Total Recently Added NOT exist");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalRecentlyAdded), "\uD83D\uDCA5Total Recently Added NOT display");
        softAssert.assertEquals(WebUI.getElementText(totalRecentlyAdded), totalRecentlyAddedExpected, "\uD83D\uDCA5Total Recently Added NOT match");
        System.out.println("\uD83C\uDF3ATotal Recently Added actual is: " + WebUI.getElementText(totalRecentlyAdded));
        softAssert.assertAll();
    }

    public void checkTotalTrash() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(totalTrash), "\uD83D\uDCA5Total Trash NOT exist");
        softAssert.assertTrue(WebUI.checkElementDisplayed(totalTrash), "\uD83D\uDCA5Total Trash NOT display");
        softAssert.assertEquals(WebUI.getElementText(totalTrash), totalTrashExpected, "\uD83D\uDCA5Total Trash NOT match");
        System.out.println("\uD83C\uDF3ATotal Trash actual is: " + WebUI.getElementText(totalTrash));
        softAssert.assertAll();
    }

    public void checkTotalAllContract() {
        checkTotalActive();
        checkTotalExpired();
        checkTotalAbouttoExpire();
        checkTotalRecentlyAdded();
        checkTotalTrash();
    }

    public void checkBieuDoContract() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(WebUI.checkElementExist(bieuDoContract), "\uD83D\uDCA5Biểu đồ contract NOT exist");
        softAssert.assertTrue(WebUI.checkElementDisplayed(bieuDoContract), "\uD83D\uDCA5Biểu đồ contract NOT display");
       // WebUI.captureScreenImage("bdc");
        softAssert.assertAll();
    }

    public void verifyAllDataContracts() {
        String strTotal = WebUI.getElementText(totalPage);
        ArrayList<String> list = new ArrayList<String>();

        for (String strItem : strTotal.split("\\s")) {
            list.add(strItem);
        }
        int itemTotal = Integer.parseInt(list.get(5));
        System.out.println("\uD83D\uDC9DTìm được " + itemTotal + " item");
    }

    public void addNewContracts() {
        WebUI.clickElement(buttonAddNewContract);
        WebUI.sleep(1);
        WebUI.clickElement(dropdownCustomer);
        WebUI.sleep(1);
        WebUI.setText(inputCustomer, "Merkle Blucom");
        WebUI.sleep(2);
        WebUI.clickElement(optionCustomer);
        WebUI.setText(inputSubject, "MacA2");
        WebUI.setText(inputContractValue, "2000");
        WebUI.setText(inputEndDate, "20-08-2024");
        WebUI.setText(textAreaDescription, "Làm điều bạn thích là tự do. Thích điều bạn làm là hạnh phúc.");
        WebUI.clickElement(buttonSave);
        WebUI.sleep(2);
        WebUI.clickElement(DashboardPage.menuContract);
    }

    public void verifySearchContract() {
        WebUI.waitForPageLoaded();
        WebUI.setText(inputSearch, "MacA2");
        WebUI.sleep(2);
        WebUI.scrollToElement(totalPage);
        Assert.assertTrue(WebUI.checkElementExist(fishItemContractsOnTable), "Contract  NOT exists.");
        Assert.assertTrue(WebUI.checkElementDisplayed(fishItemContractsOnTable), "Không tìm thấy Contract vừa add.");
    }

}
