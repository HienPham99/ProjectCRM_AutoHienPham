package ProjectCRM.pages;

import drivers.DriverManager;
import helpers.PropertiesHelper;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.LogUtils;

public class LoginPage {

    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[@id='alerts']//div");
    private By errorMessageEmailBlank = By.xpath("//div[@class='alert alert-danger text-center']");


    private void setEmail(String email) {
        WebUI.setText(inputEmail, email);
    }

    private void setPassword(String password) {
        WebUI.setText(inputPassword, password);
    }

    private void clickLoginbutton() {
        WebUI.clickElement(buttonLogin);
    }

    private void clickForgotPasswordlink() {
        WebUI.clickElement(ForgotPasswordPage.forgotPasswordLink);
    }

    public void verifyLoginSuccess() {
        WebUI.waitForPageLoaded();
        Assert.assertFalse(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "Login unsuccessful. Vẫn ở trang Login page.");
        Assert.assertTrue(WebUI.checkElementDisplayed(DashboardPage.menuDashboardTotal), "Login unsuccessful. Không hiêển thị trang dashboard page");
        Assert.assertEquals(WebUI.getElementText(DashboardPage.menuDashboard), "Dashboard", "Login unsuccessful. Không phải content của Dashboard page");

        LogUtils.info("_________________________");
        LogUtils.info("______ Verify login success ______");
    }

    public void verifyLoginFailWithEmailWrong() {
        WebUI.waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "Fail. Không còn ở trang login page.");
        Assert.assertTrue(WebUI.checkElementDisplayed(errorMessage), "Error message not displayed.");
        Assert.assertEquals(WebUI.getElementText(errorMessage), "Invalid email or password", "Fail. Error message NOT match.");
        WebUI.highLightElement(errorMessage);
    }

    public void verifyLoginFailWithEmailBlank() {
        WebUI.waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(WebUI.checkElementDisplayed(errorMessageEmailBlank), "Error message NOT display");
        Assert.assertEquals(WebUI.getElementText(errorMessageEmailBlank), "The Email Address field is required.", "Fail. Constaint of Error message when Email blank NOT match.");
        WebUI.highLightElement(errorMessageEmailBlank);
    }

    public void verifyLoginFailWithPasswordlWrong() {
        WebUI.waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "Fail. Không còn ở trang login page.");
        Assert.assertTrue(WebUI.checkElementDisplayed(errorMessage), "Error message not displayed.");
        Assert.assertEquals(WebUI.getElementText(errorMessage), "Invalid email or password", "Fail. Error message NOT match.");
        WebUI.highLightElement(errorMessage);
    }

    public ForgotPasswordPage clickForgotPassword() {
        WebUI.opeURL(PropertiesHelper.getValue("url"));
        WebUI.waitForPageLoaded();
        clickForgotPasswordlink();
        WebUI.sleep(2);
        return new ForgotPasswordPage();
    }

    public DashboardPage loginCRM(String email, String password) {
        WebUI.opeURL(PropertiesHelper.getValue("url"));
        WebUI.waitForPageLoaded();
        setEmail(email);
        setPassword(password);
        clickLoginbutton();
        WebUI.sleep(2);

        return new DashboardPage();
    }


}
