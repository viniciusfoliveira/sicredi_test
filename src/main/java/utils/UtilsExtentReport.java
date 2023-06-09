package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UtilsExtentReport {

    private static ExtentReports reports;
    private static ExtentSparkReporter spark;


    public static ExtentReports ExtentReport() {

        if (reports == null) {
            reports = new ExtentReports();
            spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
            reports.attachReporter(spark);
        }

        return reports;
    }

    public static void sucess(String cenario) {
        ExtentTest test = reports.createTest(cenario);
        test.log(Status.PASS, cenario);
    }

    public static void fail(String cenario) {
        ExtentTest test = reports.createTest(cenario);
        test.log(Status.PASS, cenario);
    }

    public static void fecharCenario() {
        reports.flush();
    }
}
