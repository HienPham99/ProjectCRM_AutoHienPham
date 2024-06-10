package keywords;

import com.aventstack.extentreports.Status;
import drivers.DriverManager;
import reports.AllureManager;
import reports.ExtentTestManager;
import utils.LogUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class WebUI {

    private static int TIMEOUT = 10; //time chờ của WebDriverWait
    private static double STEP_TIME = 0.5; // time chờ đợi của hàm sleep
    private static int PAGE_LOAD_TIMEOUT = 40;//time chờ đợi trang load xong

    public static void sleep(double seconds) {
        try {
            Thread.sleep((long) (1000 * seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logConsole(Object message) {
        LogUtils.info(message);
    }


    public static WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);

    }

    public static List<WebElement> getWebElements(By by) {
        return DriverManager.getDriver().findElements(by);

    }

    public static boolean checkElementExist(By by) {
        List<WebElement> listElement = getWebElements(by); //DriverManager.getDriver().findElements(by);

        if (listElement.size() > 0) {
            LogUtils.info("Element " + by + " existing.");
            return true;
        } else {
            LogUtils.info("Element " + by + " Not exist.");
            return false;
        }

    }

    public static boolean checkElementDisplayed(By by) {
        //waitForElementVisible(by);
        WebUI.sleep(3);
        boolean check = getWebElement(by).isDisplayed();
        return check;
    }

    public static boolean checkElementIsSelected(By by) {
        WebUI.sleep(2);
        boolean check = getWebElement(by).isSelected();
        return check;
    }

    @Step("Open URL: {0}")
    public static void opeURL(String url) {
        DriverManager.getDriver().get(url);
        LogUtils.info("Open Website: " + url);
        ExtentTestManager.logMessage(Status.INFO, "Open URL: " + url);
    }

    @Step("Click Element: {0}")
    public static void clickElement(By by) {
       // waitForElementClickable(by);
        WebUI.sleep(3);
        getWebElement(by).click();
        LogUtils.info("Click Element: " + by);
        ExtentTestManager.logMessage(Status.INFO, "Click element: " + by);
    }

    @Step("Click Element: {0} with timeout is {1}s")
    public static void clickElement(By by, int second) {
        waitForElementClickable(by, second);
        getWebElement(by).click();
        LogUtils.info("Click Element: " + by + " with timeout is " + second + "(s).");
        ExtentTestManager.logMessage(Status.INFO, "Click element: " + by);
    }

    @Step("Input text: {1} on element {0}")
    public static void setText(By by, String value) {
        //waitForElementVisible(by);
        WebUI.sleep(1);
        getWebElement(by).sendKeys(value);
        LogUtils.info("Input text: " + "'" + value + "'" + " on input: " + by);
        ExtentTestManager.logMessage(Status.INFO, "Input text: " + "'" + value + "'" + " on input: " + by);
    }

    @Step("Input text: {2} on element {0} with timeout {1}")
    public static void setText(By by, int second, String value) {
        waitForElementVisible(by, second);
        getWebElement(by).sendKeys(value);
        LogUtils.info("Input text: " + "'" + value + "'" + " on input: " + by);
        ExtentTestManager.logMessage(Status.INFO, "Input text: " + value + " on element " + by);
    }

    @Step("GET TEXT OF ELEMENT: {0} ")
    public static String getElementText(By by) {
        //waitForElementVisible(by);
        WebUI.sleep(2);
        WebUI.sleep(STEP_TIME);
        String text = DriverManager.getDriver().findElement(by).getText();
        LogUtils.info("GET TEXT OF ELEMENT: '" + by + "'" + " ===> " + text);
        ExtentTestManager.logMessage(Status.INFO, "Get text of element: " + by);
        ExtentTestManager.logMessage(Status.INFO, "==> Text: " + getWebElement(by).getText());

        AllureManager.saveTextLog("===> " + text);
        return text;
    }

    @Step("Get attribute of element: {0}")
    public static String getElementAttribute(By by, String attributeName) {
        waitForElementVisible(by);
        WebUI.sleep(STEP_TIME);
        String value = DriverManager.getDriver().findElement(by).getAttribute(attributeName);
        LogUtils.info("Get attribute of element: " + by + " ===> " + value);
        ExtentTestManager.logMessage(Status.INFO, "Get attribute value of element: " + by);
        ExtentTestManager.logMessage(Status.INFO, "==> Attribute value: " + getWebElement(by).getAttribute(attributeName));

        AllureManager.saveTextLog("===> " + value);
        return value;
    }


    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(PAGE_LOAD_TIMEOUT), Duration.ofMillis(100));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            LogUtils.info("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                LogUtils.error(error.getStackTrace());
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());

        }
    }

    public static void waitForElementVisible(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());

        }
    }

    public static void waitForElementInvisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Timeout waiting for the element NOT visible. " + by.toString());
            Assert.fail("Timeout waiting for the element NOT visible. " + by.toString());

        }
    }

    public static void waitForElementInvisible(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));//hàm chờ đợi element KHÔNG hiển thị
        } catch (Throwable error) {
            LogUtils.error("Timeout waiting for the element NOT visible. " + by.toString());
            Assert.fail("Timeout waiting for the element NOT visible. " + by.toString());

        }
    }

    public static void waitForElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));//Hàm chờ đợi element tồn tại
        } catch (Throwable error) {
            LogUtils.error("Element not exist. " + by.toString());
            Assert.fail("Element not exist. " + by.toString());

        }
    }

    public static void waitForElementPresent(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Element not exist. " + by.toString());
            Assert.fail("Element not exist. " + by.toString());

        }
    }

    public static void waitForElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT), Duration.ofMillis(800));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            LogUtils.error("Timeout waiting for the element ready to click. " + by.toString());
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());

        }
    }

    public static void waitForElementClickable(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            LogUtils.error("Timeout waiting for the element ready to click. " + by.toString());
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());

        }
    }

    public static void captureScreenImage(String imageName) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //Get size screen browser
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        LogUtils.info("Kích thước khung hình: " + screenSize);
        //Khởi tạo kích thước khung hình với kích cỡ trên
        Rectangle screenRectangle = new Rectangle(screenSize);
        //Tạo hình chụp với độ lớn khung đã tạo trên
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //Lưu hình vào dạng file với dạng png
        File file = new File("src/test/resources/screenshots/" + imageName + ".png");
        try {
            ImageIO.write(image, "png", file);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void setTextAndKey(By by, String value, Keys key) {
        waitForPageLoaded();
        getWebElement(by).sendKeys(value, key);
        LogUtils.info("Set text: " + value + " on element " + by);
    }

    public static void setKey(By by, Keys key) {
        waitForPageLoaded();
        getWebElement(by).sendKeys(key);
        LogUtils.info("Set key: " + key.name() + " on element " + by);
    }

    public static void scrollToElement(By element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(element));
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToPosition(int X, int Y) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(" + X + "," + Y + ");");
    }

    public static boolean moveToElement(By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    public static boolean moveToOffset(int X, int Y) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveByOffset(X, Y).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    public static boolean hoverElement(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            LogUtils.error("Hover on element: " + by);
            ExtentTestManager.logMessage(Status.FAIL, "Hover on element " + by);
            return false;
        }

    }

    public static boolean mouseHover(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean dragAndDrop(By fromElement, By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.dragAndDrop(getWebElement(fromElement), getWebElement(toElement)).perform();
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    public static boolean dragAndDropElement(By fromElement, By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    public static boolean dragAndDropOffset(By fromElement, int X, int Y) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            //Tính từ vị trí click chuột đầu tiên (clickAndHold)
            action.clickAndHold(getWebElement(fromElement)).pause(1).moveByOffset(X, Y).release().build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    public static boolean pressENTER() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean pressESC() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean pressF11() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_F11);
            robot.keyRelease(KeyEvent.VK_F11);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static WebElement highLightElement(By by) {
        if (DriverManager.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.border='2px solid red'", getWebElement(by));
            sleep(1);
        }
        return getWebElement(by);
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        waitForPageLoaded();
        LogUtils.info("Assert equals: " + actual + " and " + expected);
        Assert.assertEquals(actual, expected, message);
    }

    public static void assertContains(String actual, String expected, String message) {
        waitForPageLoaded();
        LogUtils.info("Assert contains: " + actual + " and " + expected);
        boolean check = actual.contains(expected);
        Assert.assertTrue(check, message);
    }

}
