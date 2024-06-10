package ProjectCRM.testcases;

import ProjectCRM.pages.ForgotPasswordPage;
import ProjectCRM.pages.LoginPage;
import common.BaseTest;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ForgotPasswordTest extends BaseTest {

    LoginPage loginPage;
    ForgotPasswordPage forgotPasswordPage;

    @Test
    public void testForgotPassword() {
        loginPage = new LoginPage();
        forgotPasswordPage = new ForgotPasswordPage();
        forgotPasswordPage = loginPage.clickForgotPassword();
        forgotPasswordPage.forgotPassword("admin@example.com");
        forgotPasswordPage.verifyForgotPasswordUnsuccess();
    }
}
