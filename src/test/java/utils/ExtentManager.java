package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if(extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("reports/ExtentReport.html");

            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("GUI Elements Test");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }
}