package ProjectCRM.pages;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.LogUtils;

import java.util.ArrayList;

public class ExpensesPage {

    private By optionValuePage = By.xpath("//div[@id='expenses_length']//select");
    private By inputSearch = By.xpath("//div[@id='expenses_filter']//input");
    private By pageTotal = By.xpath("//div[@id='expenses_info']");
    private By checkboxALL = By.xpath("(//table[@id='expenses']//div)[1]");

    private By checboxItem = By.xpath("//tbody/tr[1]/td[1]");

    private By iconFilter = By.xpath("//div[@id='vueApp']//i");
    private By newFilterLink = By.xpath("//a[normalize-space()='New Filter']");
    private By dropdowAddRule = By.xpath("//button[@data-id='expensesRules']");
    private By inputAddRule = By.xpath("//button[@data-id='expensesRules']/following::div//input[@type='search']");
    private By optionAddRule = By.xpath("//span[normalize-space()='Payment Mode']");
    private By dropdownPaymentMode = By.xpath("//*[@id=\"expenses\"]/div/div/div[2]/div/div[2]/div[2]/div/div/div/div[2]/div/div/button");
    private By inputPaymentMode = By.xpath("//*[@id=\"expenses\"]/div/div/div[2]/div/div[2]/div[2]/div/div/div/div[2]/div/div/div/div[1]/input");
    private By optionPaymentMode = By.xpath("//span[normalize-space()='Bank']");
    private By buttonApply = By.xpath("//button[normalize-space()='Apply']");
    private By dataAllAfterFiltertoBank = By.xpath("//tbody");
    private By dataAfterFilterToBank = By.xpath("//tbody/tr[1]/td[11]");

    public void checkAllDataTable() {
        Select select = new Select(WebUI.getWebElement(optionValuePage));
        select.selectByVisibleText("25");
        WebUI.sleep(1);
        LogUtils.info(select.getFirstSelectedOption().getText());
        int itemTotalOnePage = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println("Tổng số " + itemTotalOnePage + "item/page.");

        //Get total item
        String strTotal = WebUI.getElementText(pageTotal);
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
    }

    public void verifyWhenTickCheckboxAll() {
        WebUI.clickElement(checkboxALL);
        WebUI.sleep(2);
        Assert.assertFalse(WebUI.checkElementIsSelected(checboxItem), "Checkbox is Not selected");
    }

    public void searchToFilter() {
        WebUI.clickElement(iconFilter);
        WebUI.sleep(1);
        WebUI.clickElement(newFilterLink);
        WebUI.clickElement(dropdowAddRule);
        WebUI.sleep(2);
        WebUI.setText(inputAddRule, "Payment Mode");
        WebUI.sleep(1);
        WebUI.setKey(inputAddRule, Keys.ENTER);

        WebUI.clickElement(dropdownPaymentMode);
        WebUI.setText(inputPaymentMode, "Bank");
        WebUI.sleep(2);
        WebUI.setKey(inputPaymentMode, Keys.ENTER);
        WebUI.clickElement(buttonApply);
        WebUI.waitForPageLoaded();
    }

    public void verifyDataAfterSearchtoBank() {

        Assert.assertTrue(WebUI.checkElementExist(dataAllAfterFiltertoBank), "\uD83E\uDDF2 Data after filter NOT exist");
        Assert.assertTrue(WebUI.checkElementDisplayed(dataAllAfterFiltertoBank), "\uD83E\uDDF2 Data after filter NOT display");
        Assert.assertEquals(WebUI.getElementText(dataAfterFilterToBank), "Bank", "❌ Data search to Payment Mode not match.");
        System.out.println("Keyword search of Payment Mode is : " + WebUI.getElementText(dataAfterFilterToBank).trim());
        countDataTableAfterSearch();
    }

    public void countDataTableAfterSearch() {
        String strTotal = WebUI.getElementText(pageTotal);
        ArrayList<String> list = new ArrayList<String>();

        for (String strItem : strTotal.split("\\s")) {
            list.add(strItem);
        }
        int itemTotal = Integer.parseInt(list.get(5));
        System.out.println("\uD83D\uDC9DTìm được " + itemTotal + " item có Payment Mode theo keyword is: " + WebUI.getElementText(dataAfterFilterToBank).trim() + ".");

    }
}


