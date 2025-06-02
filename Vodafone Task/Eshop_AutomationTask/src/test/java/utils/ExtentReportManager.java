package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "/target/ExtentReport.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);

            reporter.config().setTheme(Theme.DARK);
            reporter.config().setDocumentTitle("Eshop Automation Report");
            reporter.config().setReportName("Eshop Functional Test Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}
