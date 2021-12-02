/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kentvanlim
 */
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import com.test.function.Function;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Listeners;

public class ApiTest {

    Function func = new Function();
    ExtentSparkReporter spark;
    ExtentReports extent;
    static ExtentTest test;
    static String baseURI = "https://jsonplaceholder.cypress.io/posts";
    String result = "";

    @BeforeTest
    public void initiateTest() {
        RestAssured.baseURI = baseURI;
        spark = new ExtentSparkReporter("Report Api/Report-Test-Bukalapak.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Test(enabled = true)
    public void testGet() throws JSONException {
        test = extent.createTest("Test Get Data");
        logReport(func.getData(), "Get Post with correct datatype ");
    }

    @Test(enabled = true)
    public void testPost() throws JSONException {
        test = extent.createTest("Test Create Post "); 
        logReport(func.addPost(), "Create Post with correct response ");
    }

    public static void logReport(String result, String message) {
        try {
            Assert.assertEquals(result, "Valid", "Valid result");
            test.log(Status.PASS, message + " Passed");
        } catch (AssertionError e) {
            test.log(Status.FAIL, message + " Failed");
        }
    }

    @AfterMethod
    public void tearDown() {
        extent.flush();

    }

}
