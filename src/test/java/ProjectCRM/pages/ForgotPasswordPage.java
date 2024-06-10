package ProjectCRM.pages;

import drivers.DriverManager;
import helpers.PropertiesHelper;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.LogUtils;

public class ForgotPasswordPage {

    public static By forgotPasswordLink = By.xpath("//a[normalize-space()='Forgot Password?']");
    private By headerForgotPassword = By.xpath("//h1[normalize-space()='Forgot Password']");
    private By inputEmailAddress = By.xpath("//input[@id='email']");
    private By buttonConfirm = By.xpath("//button[normalize-space()='Confirm']");
    private By errorForgotPassword = By.xpath("(//div[normalize-space()='Error setting new password'])[1]");

//    private void setEmail(String email) {
//        WebUI.setText(inputEmailAddress, email);
//    }

    public void verifyForgotPasswordSuccess() {
        WebUI.waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("authentication/forgot_password"), "Fail. Không phải là Forgot password page.");
        WebUI.sleep(3);
        Assert.assertTrue(WebUI.checkElementDisplayed(headerForgotPassword), "Header Forgot password not displayed.");
        Assert.assertEquals(WebUI.getElementText(headerForgotPassword), "Forgot Password", "Header Forgot password not match.");

    }

    public void verifyForgotPasswordUnsuccess() {
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementDisplayed(errorForgotPassword), "Error message forgot password not displayed.");
        Assert.assertEquals(WebUI.getElementText(errorForgotPassword), "Error setting new password", "Fail. Error message forgot password NOT match.");
        WebUI.highLightElement(errorForgotPassword);
        LogUtils.info("_________________________");
        LogUtils.info("______ Verify forgot passwor usnuccess ______");

    }

    public ForgotPasswordPage forgotPassword(String email) {
        WebUI.waitForPageLoaded();
        WebUI.setText(inputEmailAddress,email);
        WebUI.clickElement(buttonConfirm);
        return new ForgotPasswordPage();
    }
}
