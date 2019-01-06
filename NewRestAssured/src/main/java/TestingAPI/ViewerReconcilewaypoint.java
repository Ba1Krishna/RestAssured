package TestingAPI;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;


import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.http.ContentType;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 

public class ViewerReconcilewaypoint {
	
	//ExtentReports report;
	
	WebDriver driver;

   @BeforeSuite
   public void testbefore()
   {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\3691713\\Documents\\chromedriver.exe");
	   driver=new ChromeDriver();
   }
   
	
	
	ExtentTest logger;
	
	ExtentReports report =new ExtentReports("C:\\Users\\3691713\\Documents\\RestReports-1.html");
	
	
	/* TEST FOR OPERATIONID*/
	@Test
	public void test_operationId() {
		
		logger= report.startTest("Test 1 - Reconcilewapoint Viewer - operationId verified ");
		
	       
	    given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).operationId",equalTo("1"));
	    
	    logger.log(LogStatus.PASS, "operationId validated!!");
	    
	}
	
	
	/* TEST FOR tRIPid*/
	@Test
	public void test_tripId() {
		
		logger= report.startTest("Test 2 -  verify tripId value");
		
	        
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).tripId",equalTo("1000"));
	    
	    logger.log(LogStatus.PASS, "tripId validated!!");
	    
	}
	
	/* TEST FOR WAYPOINTDATE*/
	@Test
	public void test_waypointDate() {
		
		logger= report.startTest("Test 3 - verify waypointDate ");
		
	    given().
	    when().
        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
    then().
        assertThat().
        body("get(0).waypointDate",equalTo("2018-11-28"));
    
    logger.log(LogStatus.PASS, "waypointDate validated!!");
    
}
	
	
	@Test
	public void test_taskUuid() {
		
		logger= report.startTest("Test 4 - verify taskUuid");
	        
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskUuid",equalTo("taskrestdmo1"));
	    
	    logger.log(LogStatus.PASS, "taskUuid validated!!");
	    
	}
	
	@Test
	public void test_taskType() {
		
		logger= report.startTest("Test 5 - verify taskType");
	        
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskType",equalTo("RELEASE_SHIPMENT_UNIT_TASK"));
	    
	    logger.log(LogStatus.PASS, "taskType validated!!");
	    
	}
	
	
	@Test
	public void test_taskStage() {
		
		logger= report.startTest("Test 6- verify taskStage");
		
	        
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskStage",equalTo("COMPLETE"));
	    
	    logger.log(LogStatus.PASS, "taskStage validated!!");
	    
	}
	
	@Test
	public void test_waypointUuid() {
//	    String jsonBody = generateStringFromResource("C:\\Users\\3691713\\Documents\\InputJsons\\firstJson.json");

		logger= report.startTest("Test 7 - verify waypointUuid");
	        
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).waypointUUID",equalTo("Restdemo"));
	    
	    logger.log(LogStatus.PASS, "waypointUUID validated!!");
	    
	}
	

	@Test
	public void test_tripUuid() {
		
		logger= report.startTest("Test 8- verify tripUuid");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).tripUuid",equalTo("Come back for Trip UUID"));
	    
	    logger.log(LogStatus.PASS, "tripUuid validated!!");
	    
	}
	
	@Test
	public void test_waypointAddressLineOne() {
		
		logger= report.startTest("Test 9- verify waypointAddressLineOne");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).waypointAddressLineOne",equalTo("80 FedEx Parkway"));
	    
	    logger.log(LogStatus.PASS, "waypointAddressLineOne validated!!");
	    
	}
	
	@Test
	public void test_waypointAddressLineTwo() {
		
		logger= report.startTest("Test 10 - verify waypointAddressLineTwo");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).waypointAddressLineTwo",equalTo("Building 80"));
	    
	    logger.log(LogStatus.PASS, "waypointAddressLineTwo validated!!");
	    
	}
	
	@Test
	public void test_waypointAddressLineThree() {
		
		logger= report.startTest("Test 11- verify waypointAddressLineThree");
		
	    given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/896e772c-6438-402b-bf62-b3d3076352fd").
	    then().
	        assertThat().
	        body("get(0).waypointAddressLineThree",equalTo("Accenture"));
	    logger.log(LogStatus.PASS, "waypointAddressLineThre validated Success!!");
	    
	}
	
	@Test
	public void test_waypointAddressLineFour() {
		
		logger= report.startTest("Test 12- verify waypointAddressLineFour");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).waypointAddressLineFour",equalTo("Cafe"));
	    
	    logger.log(LogStatus.PASS, "waypointAddressLineFour validated!!");
	    
	}
	
	@Test
	public void test_waypointCity() {
		
		logger= report.startTest("Test 13 - verify waypointCity");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).waypointCity",equalTo("Collierville"));
	    
	    logger.log(LogStatus.PASS, "waypointCity validated!!");
	    
	}
	
	@Test
	public void test_waypointStateOrProvinceCode() {
		
		logger= report.startTest("Test 14 - verify waypointStateOrProvinceCode");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).waypointStateOrProvinceCode",equalTo("TN"));
	    
	    logger.log(LogStatus.PASS, "waypointStateOrProvinceCode validated!!");
	    
	}
	
	@Test
	public void test_waypointPostalCode() {
		
		logger= report.startTest("Test 15 - verify waypointPostalCode");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).waypointPostalCode",equalTo("12345"));
	    
	    logger.log(LogStatus.PASS, "waypointPostalCode validated!!");
	    
	}
	
	@Test
	public void test_waypointUrbanizationCode() {
		
		logger= report.startTest("Test 16 - verify waypointUrbanizationCode");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).waypointUrbanizationCode",equalTo("12345"));
	    
	    logger.log(LogStatus.PASS, "waypointUrbanizationCode validated!!");
	    
	}
	
	@Test
	public void test_waypointCountryCode() {
		
		logger= report.startTest("Test 17 - verify waypointCountryCode");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).waypointCountryCode",equalTo("USA"));
	    
	    logger.log(LogStatus.PASS, "waypointCountryCode validated!!");
	    
	}
	
	@Test
	public void test_waypointCountryName() {
		
		logger= report.startTest("Test 18 - verify waypointCountryName");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).waypointCountryName",equalTo("USA"));
	    
	    logger.log(LogStatus.PASS, "waypointCountryName validated!!");
	    
	}
	
	@Test
	public void test_waypointActualEngagedTimeStamp() {
		
		logger= report.startTest("Test 19 - verify waypointActualEngagedTimeStamp");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).waypointActualEngagedTimeStamp",equalTo("2018-11-28T10:00:00Z"));
	    
	    logger.log(LogStatus.PASS, "waypointActualEngagedTimeStamp validated!!");
	    
	}
	
	@Test
	public void test_waypointActualDisengagedTimeStamp() {
		
		logger= report.startTest("Test 20 - verify waypointActualDisengagedTimeStamp");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).waypointActualDisengagedTimeStamp",equalTo("2018-11-28T11:00:00Z"));
	    
	    logger.log(LogStatus.PASS, "waypointActualDisengagedTimeStamp validated!!");
	    
	}
	
	@Test
	public void test_waypointSequenceNumber() {
		
		logger= report.startTest("Test 21 - verify waypointSequenceNumber");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).waypointSequenceNumber",equalTo("1"));
	    
	    logger.log(LogStatus.PASS, "waypointSequenceNumbe validated!!");
	    
	}
	
	@Test
	public void test_handlingUnitId() {
		
		logger= report.startTest("Test 22 - verify handlingUnitId");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).handlingUnitId",equalTo("Actual Reconcile WP Task Test"));
	    
	    logger.log(LogStatus.PASS, "handlingUnitId validated!!");
	    
	}
	
	@Test
	public void test_handlingUnitUUID() {
		
		logger= report.startTest("Test 23 - verify handlingUnitUUID");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).handlingUnitUUID",equalTo("bb18f1e8-660f-4001-af90-2b49ee156fa1"));
	    
	    logger.log(LogStatus.PASS, "handlingUnitUUID validated!!");
	    
	}
	
	@Test
	public void test_taskUUID() {
		
		logger= report.startTest("Test 24 - verify taskUUID");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskUUID",equalTo("taskrestdmo1"));
	    
	    logger.log(LogStatus.PASS, "taskUUID validated!!");
	    
	}
	
	@Test
	public void test_taskType1() {
		
		logger= report.startTest("Test 25 - verify taskType");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskType",equalTo("RELEASE_SHIPMENT_UNIT_TASK"));
	    
	    logger.log(LogStatus.PASS, "taskType validated!!");
	    
	}
	
	@Test
	public void test_taskAddressLineOne() {
		
		logger= report.startTest("Test 26 - verify taskAddressLineOne");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskAddressLineOne",equalTo("50 FedEx Parkway"));
	    
	    logger.log(LogStatus.PASS, "taskAddressLineOne validated!!");
	    
	}
	
	@Test
	public void test_taskAddressLineTwo() {
		
		logger= report.startTest("Test 27 - verify taskAddressLineTwo");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskAddressLineTwo",equalTo("Building 50"));
	    
	    logger.log(LogStatus.PASS, "taskAddressLineTwo validated!!");
	    
	}
	
	@Test
	public void test_taskAddressLineThree() {
		
		logger= report.startTest("Test 28 - verify taskAddressLineThree");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskAddressLineThree",equalTo("Cafe"));
	    
	    logger.log(LogStatus.PASS, "taskAddressLineThree validated!!");
	    
	}
	
	@Test
	public void test_taskAddressLineFour() {
		
		logger= report.startTest("Test 29 - verify taskAddressLineFour");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskAddressLineFour",equalTo("Accenture"));
	    
	    logger.log(LogStatus.PASS, "taskAddressLineFour validated!!");
	    
	}
	
	@Test
	public void test_taskCity() {
		
		logger= report.startTest("Test 30 - verify taskCity");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskCity",equalTo("Collierville"));
	    
	    logger.log(LogStatus.PASS, "taskCity validated!!");
	    
	}
	
	@Test
	public void test_taskStateOrProvinceCode() {
		
		logger= report.startTest("Test 31 - verify taskStateOrProvinceCode");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskStateOrProvinceCode",equalTo("TN"));
	    
	    logger.log(LogStatus.PASS, "taskStateOrProvinceCode validated!!");
	    
	}
	
	@Test
	public void test_taskPostalCode() {
		
		logger= report.startTest("Test 32 - verify taskPostalCode");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskPostalCode",equalTo("12345"));
	    
	    logger.log(LogStatus.PASS, "taskPostalCode validated!!");
	    
	}
	
	@Test
	public void test_taskUrbanizationCode() {
		
		logger= report.startTest("Test 33 - verify taskUrbanizationCode");
		
	    given().
	    when().
        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
    then().
        assertThat().
        body("get(0).taskUrbanizationCode",equalTo("12345"));
    
    logger.log(LogStatus.PASS, "taskUrbanizationCode validated!!");
    
}
	
	@Test
	public void test_taskEndTime() {
		
		logger= report.startTest("Test 34 - verify taskEndTime");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskEndTime",equalTo("2018-11-28T11:00:00Z"));
	    
	    logger.log(LogStatus.PASS, "taskEndTime validated!!");
	    
	}
	
	@Test
	public void test_taskOutcome() {
		
		logger= report.startTest("Test 35 - verify taskOutcome");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskOutcome",equalTo("ShipmentUnitReleasedTaskOutcome"));
	    
	    logger.log(LogStatus.PASS, "taskOutcome validated!!");
	    
	}
	
	@Test
	public void test_taskOccurredTime() {
		
		logger= report.startTest("Test 36 - verify taskOccurredTime");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskOccurredTime",equalTo("2018-11-28T10:00:00Z"));
	    
	    logger.log(LogStatus.PASS, "taskOccurredTime validated!!");
	    
	}
	
	@Test
	public void test_taskPerformedBy() {
		
		logger= report.startTest("Test 37 - verify taskPerformedBy");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskPerformedBy",equalTo("JJ"));
	    
	    logger.log(LogStatus.PASS, "taskPerformedBy validated!!");
	    
	}
	
	@Test
	public void test_taskPerformedByDeviceId() {
		
		logger= report.startTest("Test 38 - verify taskPerformedByDeviceId");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskPerformedByDeviceId",equalTo("12"));
	    
	    logger.log(LogStatus.PASS, "taskPerformedByDeviceId validated!!");
	    
	}
	
	
	@Test
	public void test_taskReceivedBy() {
		
		logger= report.startTest("Test 39 - verify taskReceivedBy");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskReceivedBy",equalTo("JJ"));
	    
	    logger.log(LogStatus.PASS, "taskReceivedBy validated!!");
	    
	}
	
	@Test
	public void test_taskOccurredAt() {
		
		logger= report.startTest("Test 40 - verify taskOccurredAt");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).taskOccurredAt",equalTo("Office"));
	    
	    logger.log(LogStatus.PASS, "taskOccurredAt validated!!");
	    
	}
	
	@Test
	public void test_waypointType() {
		
		logger= report.startTest("Test 41 - verify taskOutcomeComments");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).waypointType",equalTo("PLANNED"));
	    
	    logger.log(LogStatus.PASS, "waypointType validated!!");
	    
	}
	
	@Test
	public void test_waypointStage() {
		
		logger= report.startTest("Test 42 - verify waypointStage");
		
		given().
	    when().
	        get("https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/Restdemo").
	    then().
	        assertThat().
	        body("get(0).waypointStage",equalTo("RECONCILE"));
	    
	    logger.log(LogStatus.PASS, "waypointStage validated!!");
	    
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	
	if (result.getStatus() ==ITestResult.FAILURE)
	{
		logger.log(LogStatus.FAIL, " user name validated Success!!");
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

