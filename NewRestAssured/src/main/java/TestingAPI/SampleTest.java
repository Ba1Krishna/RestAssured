package TestingAPI;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus; 

//import net.minidev.json.JSONObject;

public class SampleTest {
	WebDriver driver;
    ExtentTest logger;
	
	ExtentReports report =new ExtentReports("C:\\Users\\3691713\\Documents\\RestReports-1.html");

   @BeforeSuite
   public void testbefore()
   {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\3691713\\Documents\\chromedriver.exe");
	   driver=new ChromeDriver();
   }

	
public static void main(String[] args) throws JSONException {
	
	
	
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("waypointUUID", "qwww"); 
	
	 JSONObject waypointAssociation = new JSONObject();
	 
	 JSONObject waypointForHandlingUnitAssociation = new JSONObject();
	 waypointForHandlingUnitAssociation.put("handlingUnitUUID", "756");
	 waypointAssociation.put("waypointForHandlingUnitAssociation", waypointForHandlingUnitAssociation);
	 
	 requestParams.put("waypointAssociation", waypointAssociation);

	 
	 /* waypoint object */
	 
	 JSONObject waypoint = new JSONObject();
	 waypoint.put("name", "RECONCILE");
	 waypoint.put("description", "RECONCILE");
	 waypoint.put("waypointId", "1234");
	 waypoint.put("engagementStatus", "RECONCILE");
	 waypoint.put("actualEngageDateTime", "2018-09-05T10:00:00");
	 waypoint.put("actualDisengageDateTime", "2018-09-05T11:00:00Z");
	 waypoint.put("bypassDateTime", " 2018-09-05T10:00:00Z");
	 
	 JSONObject plannedEngageWindow = new JSONObject();
	 plannedEngageWindow.put("beginDateTime", "2018-09-05T10:00:00Z");
	 plannedEngageWindow.put("endDateTime", "2018-09-05T10:10:00Z");
	 waypoint.put("plannedEngageWindow",plannedEngageWindow);
	 
	 JSONObject estimatedEngageWindow = new JSONObject();
	 estimatedEngageWindow.put("beginDateTime", "2018-09-05T10:00:00Z");
	 estimatedEngageWindow.put("endDateTime", "2018-09-05T10:10:00");
	 waypoint.put("estimatedEngageWindow",estimatedEngageWindow);
	 waypoint.put("sequenceNumber", "12345"); 
	 
	 waypoint.put("legacyLocationCode", "8080"); 
	 waypoint.put("operationId", "HKAA"); 
	 waypoint.put("dispatchId", "00001"); 
	 waypoint.put("tripId", "2000"); 
	 
	 JSONObject travelerId = new JSONObject();
	 travelerId.put("definingAuthority", "authority");
	 travelerId.put("type", "ENTERPRISE");
	 travelerId.put("value", "value");
	 waypoint.put("travelerId",travelerId);
	 waypoint.put("travelerType","COURIER");
	 
	 
	 
	 
	 /* address object */
	 JSONObject address = new JSONObject();
	 
	 List<String> streetLines = new ArrayList<String>();
	 streetLines.add("FedEx Parkway");
	 streetLines.add("WTC Building 80");
	 streetLines.add("Line3");
	 streetLines.add("Line4");
	 address.put("streetLines", streetLines);
	 
	 address.put("city","memphis");
	 address.put("stateOrProvinceCode","TN");
	 address.put("postalCode","38125");
	 address.put("urbanizationCode","+1");
	 address.put("countryCode","100");
	 address.put("countryName","USA");
	 
	 /*waypoint task object*/
	 
	 JSONArray waypointTask = new JSONArray();
	 
	 
	 JSONObject one = new JSONObject();
	 one.put("taskUUID","T1011");
	 
	 JSONObject task = new JSONObject();
	 task.put("taskType","ACCEPT_SHIPMENT_PAYMENT_TASK");
	 task.put("actualStartDateTime","2018-09-05T10:00:00Z");
	 task.put("stage","COMPLETE");
	 task.put("legacyLocationCd","code");
	 
	 
	 JSONObject handlingUnitId = new JSONObject();
	 handlingUnitId.put("source","ENTERPRISE");
	 handlingUnitId.put("value","79546352782");
	 handlingUnitId.put("definingAuthorityName","Name");
	 
	 JSONObject plannedPerformWindow = new JSONObject();
	 plannedPerformWindow.put("beginDateTime","memphis");
	 plannedPerformWindow.put("endDateTime","memphis");
	 
	 
	 
	 task.put("handlingUnitId", handlingUnitId);
	 task.put("address", address);
	 task.put("plannedPerformWindow", plannedPerformWindow);
	 
	 /* taskend details */
	 
	 JSONObject taskEndDetail = new JSONObject();
	 taskEndDetail.put("actualEndDateTime","2018-09-05T11:00:00Z");
	 
	 JSONObject paymentAcceptedTaskOutcome = new JSONObject();
	 
	 paymentAcceptedTaskOutcome.put("acceptanceDateTime", "2018-09-05T11:00:00Z");

	 List<String> circumstance = new ArrayList<String>();

	 circumstance.add("circumstance1");
	 circumstance.add("circumstance3");
	 taskEndDetail.put("circumstance",circumstance);
	 
	 List<String> outcomeComment = new ArrayList<String>();

	 outcomeComment.add("outcomecomment");
	 outcomeComment.add("outcome11");
	 taskEndDetail.put("outcomeComment",outcomeComment);
	 
     

      JSONArray paymentDesignation=new JSONArray();
      
      
      JSONObject obj = new JSONObject();
      obj.put("paymentMethod", "APPLE_PAY");
      obj.put("billToParty", "BILL_SENDER");
      obj.put("paymentDesignationType", "ASSEMBLY");
      obj.put("paymentDesignationDescription", "DESC");
       
      paymentDesignation.put(obj);
      


	 paymentAcceptedTaskOutcome.put("paymentDesignation", paymentDesignation);

	 taskEndDetail.put("paymentAcceptedTaskOutcome", paymentAcceptedTaskOutcome);
	 
	 

	 taskEndDetail.put("performingPartyId", "1324");
	 taskEndDetail.put("performingDeviceId", "3691713");


	 task.put("taskEndDetail", taskEndDetail);
	 one.put("task", task);
	
	 
	 waypointTask.put(one);   
	 
	 
	 requestParams.put("waypoint", waypoint);
	 requestParams.put("address", address);
	 requestParams.put("waypointTask", waypointTask);
	 

	
	 
	 System.out.println(""+requestParams);
	 
	 
	 
	 
//	 requestParams.get(key);
}



public String generateStringFromResource(String path) throws IOException {

    return new String(Files.readAllBytes(Paths.get(path)));

}




@Test
public void test_waypointPostStatus() throws IOException {
	
	
    logger= report.startTest("Test 1- verify Post");
    logger.log(LogStatus.INFO, "Post in RestAPI started Running");
   
    String jsonBody = generateStringFromResource("requestParams");
 

    	    given().
    	            contentType("application/json").
    	            body(jsonBody).
    	    when().
    	            post("https://actualreconcilewaypointtask-tired-jackal.app.wtcdev2.paas.fedex.com/reconcileWaypointTask").
    	    then().
    	            statusCode(204);
    
  
    logger.log(LogStatus.PASS, "post successful!");
}
}