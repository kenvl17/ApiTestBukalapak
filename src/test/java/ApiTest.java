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
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

public class ApiTest {

    Function func = new Function();
    static ExtentSparkReporter spark;
    static ExtentReports extent;
    static ExtentTest test;
    static String baseURI = "https://jsonplaceholder.cypress.io/posts";

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
        Assert.assertEquals((func.getData()),"Valid");
       
    }

    @Test(enabled = true)
    public void testPost() throws JSONException {
        test = extent.createTest("Test Create Post "); 
        Assert.assertEquals((func.addPost()),"Valid");
    }

 
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
       
        if (result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL,"Test Failed");
             
        }  
        else{
             test.log(Status.PASS,"Test Passed");
            
        }
        extent.flush();
}

}
