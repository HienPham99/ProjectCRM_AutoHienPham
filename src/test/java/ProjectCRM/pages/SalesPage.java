package ProjectCRM.pages;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SalesPage {

    private By menuSales = By.xpath("//span[@class='menu-text'][normalize-space()='Sales']"); //span[normalize-space()='Sales'])[1]");
    private By menuOptionSales = By.xpath("((//span[normalize-space()='Sales'])[1]/parent::a)/following-sibling::ul");
    private By subMenuProposals = By.xpath("//span[normalize-space()='Proposals']");
    private By subMenuEstimates = By.xpath("//span[normalize-space()='Estimates']");
    private By subMenuInvoices = By.xpath("//span[normalize-space()='Invoices']");
    private By subMenuPayments = By.xpath("//span[normalize-space()='Payments']");
    private By subMenuCreditNotes = By.xpath("//span[normalize-space()='Credit Notes']");
    private By subMenuItems = By.xpath("//span[normalize-space()='Items']");

    private By allDataFormProposals = By.xpath("//table[@id='proposals']");
    private By optiontPage = By.xpath("//div[@id='proposals_wrapper']//select");

    private By buttonFillter = By.xpath("//div[@id='vueApp']//button");
    private By newFilterLink = By.xpath("//a[normalize-space()='New Filter']");
    private By editLink = By.xpath("//div[@id='vueApp']//a[normalize-space()='Edit']");
    private By formFilter = By.xpath("//h4[normalize-space()='Create Filter']/parent::div/parent::div");
    private By headerCreateFilter = By.xpath("//h4[normalize-space()='Create Filter']");
    private By iconX = By.xpath("(//h4[normalize-space()='Create Filter']/preceding::span)[69]");

    private By dropdownAddRule = By.xpath("(//h4[normalize-space()='Create Filter']/following::button[@type='button'])[1]");
    private By inputAddRule = By.xpath("//input[@aria-label='Search']");
    private By dropdownStatus = By.xpath("//button[@data-id='multiSelectRulestatus']");
    private By inputStatus = By.xpath("//button[@data-id='multiSelectRulestatus']/following::input[1]");
    private By buttonApply = By.xpath("//button[normalize-space()='Apply']");
    private By dataTable = By.xpath("//tbody/tr//td[10]");
    private By iconRemoveStatus = By.xpath("(//button[@data-id='multiSelectRulestatus']/parent::div)/following::i");

    public void clickSubProposals(){
        WebUI.clickElement(subMenuProposals);
    }

    public void verifyAllDataProposals() {
        SoftAssert softAssert = new SoftAssert();
        WebUI.waitForPageLoaded();
        softAssert.assertTrue(WebUI.checkElementExist(allDataFormProposals), "Fail. Data proposals NOT exist");
        softAssert.assertTrue(WebUI.checkElementDisplayed(allDataFormProposals), "Fail. Data proposals NOT displayed");
        softAssert.assertAll();
    }

    public void searchByFilter() {
        SoftAssert softAssert = new SoftAssert();
        WebUI.clickElement(buttonFillter);
        WebUI.sleep(1);
        WebUI.clickElement(newFilterLink);
        Assert.assertTrue(WebUI.checkElementExist(formFilter), "Form filter not exist");
        Assert.assertTrue(WebUI.checkElementDisplayed(formFilter), "Form filter not displayed");
        softAssert.assertEquals(WebUI.getElementText(headerCreateFilter), "Create Filter", "FAILED, header create filter NOT match.");
        WebUI.clickElement(dropdownAddRule);
        WebUI.sleep(1);
        WebUI.setText(inputAddRule, "status");
        WebUI.sleep(1);
        WebUI.setKey(inputAddRule, Keys.ENTER);
        WebUI.clickElement(dropdownStatus);
        WebUI.sleep(1);
        WebUI.setText(inputStatus, "Sent");
        WebUI.sleep(1);
        WebUI.setKey(inputStatus, Keys.ENTER);
        WebUI.clickElement(dropdownStatus);
        WebUI.sleep(1);
        WebUI.clickElement(buttonApply);
        softAssert.assertAll();
    }

    public void verifyDataAfterSearchByStatus(){
        WebUI.waitForPageLoaded();
        Assert.assertEquals(WebUI.getElementText(dataTable),"Sent","FAILED, Actual result NOT match.");
        System.out.println("Status tìm được là: " + WebUI.getElementText(dataTable));
    }

    public void EditFilter(){
        WebUI.clickElement(buttonFillter);
        WebUI.sleep(1);
        WebUI.clickElement(editLink);
        WebUI.sleep(1);
        Assert.assertTrue(WebUI.checkElementExist(formFilter), "Form filter not exist");
        Assert.assertTrue(WebUI.checkElementDisplayed(formFilter), "Form filter not displayed");
        WebUI.clickElement(iconRemoveStatus);
        WebUI.sleep(1);
        WebUI.clickElement(buttonApply);
    }

    public void ClickIconX(){
        WebUI.clickElement(buttonFillter);
        WebUI.sleep(1);
        WebUI.clickElement(newFilterLink);
        WebUI.sleep(1);
        WebUI.clickElement(iconX);
    }

    public void verifyAfterClickIconX(){
        Assert.assertFalse(WebUI.checkElementDisplayed(headerCreateFilter),"FAIL. Header create filter displayed");
    }
}
