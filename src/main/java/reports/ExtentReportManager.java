package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static  ExtentReports getExtentReports(){
        //Khởi tạo thông số đầu ra TestManager
        ExtentSparkReporter reporter= new ExtentSparkReporter("reports/ExtentReport/ExtentReport.html");
        reporter.config().setReportName("Extene Reports |Hien Tester");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java | Hien Tester");
        extentReports.setSystemInfo("Author", "Hien Tester");
        return extentReports;
    }

}
