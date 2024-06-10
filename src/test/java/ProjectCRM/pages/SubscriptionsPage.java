package ProjectCRM.pages;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class SubscriptionsPage {

    private String headerSubscriptionExpected = "Subscriptions Summary";
    private String totalNotSubscribedExpected = "0";
    private String totalActiveExpected = "0";
    private String totalFutureExpected = "0";
    private String totalPastDueExpected = "0";
    private String totalUnpaidExpected = "0";
    private String totalIncompleteExpected = "0";
    private String totalCanceledExpected = "0";
    private String totalIncompleteExpiredExpected = "0";

    private By headerSubscriptions = By.xpath("//div[@id='wrapper']//h4");//h4[normalize-space()='Subscriptions Summary']
    private By totalNotSubscribed = By.xpath("//span[normalize-space()='Not Subscribed']/preceding-sibling::span");
    private By totalActive = By.xpath("//span[normalize-space()='Active']/preceding-sibling::span");
    private By totalFuture = By.xpath("//span[normalize-space()='Future']/preceding-sibling::span");
    private By totalPastDue = By.xpath("//span[normalize-space()='Past Due']/preceding-sibling::span");
    private By totalUnpaid = By.xpath("//span[normalize-space()='Unpaid']/preceding-sibling::span");
    private By totalIncomplete = By.xpath("//span[normalize-space()='Incomplete']/preceding-sibling::span");
    private By totalCanceled = By.xpath("//span[normalize-space()='Canceled']/preceding-sibling::span");
    private By totalIncompleteExpired = By.xpath("//span[normalize-space()='Incomplete Expired']/preceding-sibling::span");

    public void verifyHeaderSubscriptions(){
        WebUI.waitForPageLoaded();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(WebUI.getElementText(headerSubscriptions),headerSubscriptionExpected, " Header Subscriptions NOT match");
        System.out.println("\uD83C\uDF80Header Subscriptions là: " + WebUI.getElementText(headerSubscriptions));
        softAssert.assertAll();
    }

    public void verifyTotalNotSubscribed(){
        WebUI.waitForPageLoaded();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(WebUI.getElementText(totalNotSubscribed),totalNotSubscribedExpected, " Total Not Subscriptions NOT match");
        System.out.println("\uD83C\uDF80Total Not Subscriptions is: "+ WebUI.getElementText(totalNotSubscribed));
        softAssert.assertAll();
    }
    public void verifyTotalActive(){
        WebUI.waitForPageLoaded();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(WebUI.getElementText(totalActive),totalActiveExpected, " Total Active NOT match");
        System.out.println("\uD83C\uDF80Total Active is: "+ WebUI.getElementText(totalActive));
        softAssert.assertAll();
    }
    public void verifyTotalFuture(){
        WebUI.waitForPageLoaded();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(WebUI.getElementText(totalFuture),totalFutureExpected, " Total Future NOT match");
        System.out.println("\uD83C\uDF80Total Future is: "+ WebUI.getElementText(totalFuture));
        softAssert.assertAll();
    }
    public void verifyTotalPastDue(){
        WebUI.waitForPageLoaded();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(WebUI.getElementText(totalPastDue),totalPastDueExpected, " Total Past Due NOT match");
        System.out.println("\uD83C\uDF80Total Past Due is: "+ WebUI.getElementText(totalPastDue));
        softAssert.assertAll();
    }
    public void verifyTotalUnpaid(){
        WebUI.waitForPageLoaded();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(WebUI.getElementText(totalUnpaid),totalUnpaidExpected, " Total Unpaid NOT match");
        System.out.println("\uD83C\uDF80Total Unpaid is: "+ WebUI.getElementText(totalUnpaid));
        softAssert.assertAll();
    }
    public void verifyTotalIncomplete(){
        WebUI.waitForPageLoaded();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(WebUI.getElementText(totalIncomplete),totalIncompleteExpected, " Total Incomplete NOT match");
        System.out.println("\uD83C\uDF80Total Incomplete is: "+ WebUI.getElementText(totalIncomplete));
        softAssert.assertAll();
    }
    public void verifyTotalCanceled(){
        WebUI.waitForPageLoaded();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(WebUI.getElementText(totalCanceled),totalCanceledExpected, " Total Incomplete Expired NOT match");
        System.out.println("\uD83C\uDF80Total Incomplete Expired is: "+ WebUI.getElementText(totalCanceled));
        softAssert.assertAll();
    }

    public void verifyTotalIncompleteExpired(){
        WebUI.waitForPageLoaded();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(WebUI.getElementText(totalIncompleteExpired),totalIncompleteExpiredExpected, " Total Incomplete Expired NOT match");
        System.out.println("\uD83C\uDF80Total Incomplete Expired is: "+ WebUI.getElementText(totalIncompleteExpired));
        softAssert.assertAll();
    }



}
