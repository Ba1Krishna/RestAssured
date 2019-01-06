package TestingAPI;
import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus; 

public class Operationstopbuilder2 {
	
	//ExtentReports report;
	
	WebDriver driver;
    ExtentTest logger;
	
	ExtentReports report =new ExtentReports("C:\\Users\\3691713\\Documents\\RestReports-1.html");

   @BeforeSuite
   public void testbefore()
   {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\3691713\\Documents\\chromedriver.exe");
	   driver=new ChromeDriver();
   }
   
   
   
   public String generateStringFromResource(String path) throws IOException {

	    return new String(Files.readAllBytes(Paths.get(path)));

	}
   
	
	@Test
	public void test_waypointPostStatus() throws IOException {
		
		
	    logger= report.startTest("Test 1- verify address");
	    logger.log(LogStatus.INFO, "Post in RestAPI started Running");
	   
	    String jsonBody = generateStringFromResource("C:\\Users\\3691713\\Documents\\InputJsons\\operationstop.json");
	 

	    	    given().
	    	            contentType("application/json").
	    	            body(jsonBody).
	    	    when().
	    	            post("https://operationstoprulesengine-comedic-ardvark.app.wtcdev2.paas.fedex.com/operationStop").
	    	    then().
	    	            statusCode(204);
	    
	  
	    logger.log(LogStatus.PASS, "post successful!");
	}

	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	
	if (result.getStatus() ==ITestResult.FAILURE)
	{
		logger.log(LogStatus.FAIL, " Post Not Successful !!");
	}
	}
	
	
	@AfterClass
	public void tearDown()
	
	{
		report.endTest(logger);
		report.flush();
		driver.get("C:\\Users\\3691713\\Documents\\RestReports-1.html");
		
	}
	
	
}
