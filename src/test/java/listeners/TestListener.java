package listeners;


import com.aventstack.extentreports.Status;
import helpers.CaptureHelper;
import helpers.PropertiesHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.AllureManager;
import reports.ExtentTestManager;
import utils.LogUtils;

public class TestListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext arg0) {
        PropertiesHelper.loadAllFile();
           }

    @Override
    public void onFinish(ITestContext result) {
        //Kết thúc và thự thi Extents report
        //ExtentReportManager.getExtentReports().flush();

    }

    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info(" ");
        LogUtils.info("️⭐️⭐️⭐️TestStart: " + result.getName() + "⭐⭐️⭐️⭐️");
        CaptureHelper.startRecord(result.getName());
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       LogUtils.info("❤️☘️☘️☘️️===>TestSuccess: \" + result.getName()+ \" is SUCCESSFULLY.❤️❤️❤️❤️❤");
        CaptureHelper.stopRecord();
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is Passed.");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.error("❌☘️☘️☘️===>TestFailure: " + result.getName()+ " is FAILED. ❌❌❌❌❌");
        CaptureHelper.captureScreenshot(result.getName());
        CaptureHelper.stopRecord();

        ExtentTestManager.addScreenShot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());//Lấy ra lý do lỗi
        ExtentTestManager.logMessage(Status.FAIL,result.getName() + " is Failed.");

        AllureManager.saveScreenshotPNG();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.info("  ");
        LogUtils.warn("️⚠️☘️☘️☘️TestSkipped: " + result.getName()+ " is SKIPPED⚠️⚠️⚠️⚠️⚠️");
        CaptureHelper.stopRecord();
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        LogUtils.info("onTestFailedButWithinSuccessPercentage: " + arg0.getName());
    }

}

