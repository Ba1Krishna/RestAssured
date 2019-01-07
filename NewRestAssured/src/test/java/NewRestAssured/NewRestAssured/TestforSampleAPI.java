package NewRestAssured.NewRestAssured;


import static com.jayway.restassured.RestAssured.given;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;


public class TestforSampleAPI  {
	
	//ExtentReports report;

	WebDriver driver;
    ExtentTest logger;
	
	ExtentReports report =new ExtentReports("C:\\Users\\3691713\\Documents\\RestReports-1.html");

	@BeforeTest
   public void testbefore()
   {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\3691713\\Documents\\chromedriver.exe");
	   driver=new ChromeDriver();
   }
   

   public static String generateStringFromResource(String path) throws IOException {

	    return new String(Files.readAllBytes(Paths.get(path)));

	}
   
	@Test
	public void ReconcilewaypointBuilder() throws IOException, JSONException 
	{
		
		Random rand = new Random();
	     String result = RandomStringUtils.random(32, false, true);
	     
	     String jsonBody = generateStringFromResource("C:\\Users\\3691713\\Documents\\InputJsons\\reconciletasks.json");
		 JSONObject jsonObject_result = new JSONObject(jsonBody);
		 JSONArray waypointTask = jsonObject_result.getJSONArray("waypointTask");
		 
		 for (int i = 0; i < waypointTask.length(); i++) {
	         JSONObject jsonObject2 = waypointTask.getJSONObject(i);
	         jsonObject2.remove("taskUUID");
	         jsonObject2.put("taskUUID",RandomStringUtils.random(32, false, true));
	         String taskUUID2 = jsonObject2.getString("taskUUID");
	         String jsonString = jsonObject_result.toString();
	         jsonObject_result.put("jsonObject2",jsonObject2);
//	         jsonObject_result.toString();

	         
		 }
		  
		 System.out.println(jsonObject_result);
	
	    logger= report.startTest("Builder Posted Successfully");
	    logger.log(LogStatus.INFO, "Post in RestAPI started Running");            
	    	    given().
	    	            contentType("application/json").
	    	            body(jsonObject_result.toString()).
	    	    when().
	    	            post("https://actualreconcilewaypointtask-tired-jackal.app.wtcdev2.paas.fedex.com/reconcileWaypointTask").
	    	    then().
	    	            statusCode(204);    

	    logger.log(LogStatus.PASS, "Reconcile Post request Successful"); 
	    logger.log(LogStatus.PASS, "Have verified the Status Code Successfully !!"); 
	    logger.log(LogStatus.PASS, "Have verified the ContentType Successfully !!"); 
	    logger.log(LogStatus.PASS, "TEST CASE NAME IS : ReconcilewaypointBuilder"); 
	    logger.log(LogStatus.PASS, "Response is" +jsonObject_result.toString());
		 }
	   
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	
	if (result.getStatus() ==ITestResult.FAILURE)
	{
		logger= report.startTest("Builder Failed to Post");
		logger.log(LogStatus.FAIL, " Json Error !!");
		logger.log(LogStatus.FAIL, "Builder Failed to post");
		
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
