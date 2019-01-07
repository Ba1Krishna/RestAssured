package NewRestAssured.NewRestAssured;
import static com.jayway.restassured.RestAssured.given;
import io.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.Matchers;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class reconcilewaypointviewer {

	WebDriver driver;
	String a = "https://actualreconcilewaypointtaskquery-unexpected-koala.app.wtcdev2.paas.fedex.com/reconcileWaypoint/VIEWER";
	RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get(a);
	 ResponseBody body = response.getBody(); 
	 
	 JsonPath jsonPathEvaluator = body.jsonPath();
	 
	 
	 @BeforeTest
	public void testbefore()
	{
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\3691713\\Documents\\chromedriver.exe");
		   driver=new ChromeDriver();

	}
	
	public static String generateStringFromResource(String path) throws IOException {

	    return new String(Files.readAllBytes(Paths.get(path)));

	}

		ExtentTest logger;
		
		ExtentReports report =new ExtentReports("C:\\Users\\3691713\\Documents\\RestReports-1.html");
		
		@Test
		public void VerifyStatusCode()
		{
			
			logger= report.startTest("Verify status code:200 ok ");
			
			given().
		    when().get(a).
		    then().
		        assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		        body("get(0).operationId",equalTo("SDOM"));
			
			logger.log(LogStatus.PASS,"Status code verified as :200 Ok");
		    logger.log(LogStatus.PASS, a);
		    logger.log(LogStatus.PASS, body.asString());
			
		}
		
		@Test
		public void waypointUUID() {
			
			logger= report.startTest("Test 1 -verify waypointUUID");
			RestAssured.baseURI = "a";

		    given().
		    when().get(a).
		    then().
		    assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
	        body("get(0).waypointUUID",equalTo("VIEWER"));
		    
		    logger.log(LogStatus.PASS, a);
			logger.log(LogStatus.PASS,"waypointUUID verified");

		}
		
		@Test
		public void test_operationId() {
			
			logger= report.startTest("Test 2 -verify operationId");
			RestAssured.baseURI = "a";

		    given().
		    when().get(a).
		    then().
		        assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		        body("get(0).operationId",equalTo("SDOM")).log().body();
		    
		    logger.log(LogStatus.PASS,"OPER_ID verified");
		    logger.log(LogStatus.PASS, a);
		    }
		
		@Test
		public void tripId() {
			
			logger= report.startTest("Test 3 -verify tripId");
			RestAssured.baseURI = "a";
			
		    given().
		    when().get(a).
		    then().
		        assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		        body("get(0).tripId",equalTo("8787"));
		    
		    logger.log(LogStatus.PASS,"tripId verified");
		    logger.log(LogStatus.PASS, a);
		    logger.log(LogStatus.PASS, "tripId");
		    }
			
		@Test
		public void tripUUID() {
			
			logger= report.startTest("Test 4 -verify tripUUID");
			RestAssured.baseURI = "a";
			
		    given().
		    when().get(a).
		    then().
		        assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		        body("get(0).tripUUID",equalTo("Come back for Trip UUID"));
		    
		    logger.log(LogStatus.PASS,"tripUUID verified");
		    logger.log(LogStatus.PASS, a);
		    logger.log(LogStatus.PASS, "tripUUID");
		    }
		
		@Test
		public void waypointDate() {
			
			logger= report.startTest("Test 5 -verify waypointDate");
			RestAssured.baseURI = "a";
			
		    given().
		    when().get(a).
		    then().
		        assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		        body("get(0).waypointDate",equalTo("2018-11-28"));
		    
		    logger.log(LogStatus.PASS,"waypointDate verified");
		    logger.log(LogStatus.PASS, a);
		    logger.log(LogStatus.PASS, "waypointDate");
		    }
		
		@Test
		public void waypointStage() {
			
			logger= report.startTest("Test 6 -verify waypointStage");
			RestAssured.baseURI = "a";
			
		    given().
		    when().get(a).
		    then().
		        assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		        body("get(0).waypointStage",equalTo("RECONCILE"));
		    
		    logger.log(LogStatus.PASS,"waypointStage verified");
		    logger.log(LogStatus.PASS, a);
		    logger.log(LogStatus.PASS, "waypointStage");
		    }
		
		@Test
		public void waypointNumber() {
			
			logger= report.startTest("Test 7 -verify waypointNumber");
			RestAssured.baseURI = "a";
			
		    given().
		    when().get(a).
		    then().
		        assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		        body("get(0).waypointNumber",equalTo("4848484"));
		    
		    logger.log(LogStatus.PASS,"waypointNumber verified");
		    logger.log(LogStatus.PASS, a);
		    logger.log(LogStatus.PASS, "waypointNumber");
		    }
		
		@Test
		public void waypointType() {
			
			logger= report.startTest("Test 8 -verify waypointType");
			RestAssured.baseURI = "a";
			
		    given().
		    when().get(a).
		    then().
		        assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		        body("get(0).waypointType",equalTo("pickup and delivery Reconcile"));
		    
		    logger.log(LogStatus.PASS,"waypointType verified");
		    logger.log(LogStatus.PASS, a);
		    logger.log(LogStatus.PASS, "waypointType");
		    }
		
		@Test
		public void WayPointAddress() {
			
			logger= report.startTest("Test 9 -verify WayPointAddress");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(0).waypointAddressLineOne",equalTo("LAKE COUNTY PRESS")).and().body("get(0).waypointAddressLineTwo",equalTo("CROSS LABEL TEST SENDER"))
			.and().body("get(0).waypointAddressLineThree",equalTo("VRN Tester")).and().body("get(0).waypointAddressLineFour",equalTo("TAMPA"));
				    
				    logger.log(LogStatus.PASS, "WayPointAddress verified!!");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "WayPointAddress");
		        
		}
		
		@Test
		public void WayPointAddresscodes() {
			
			logger= report.startTest("Test 10 -verify WayPointAddress-codes");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(0).waypointCity",equalTo("Girona")).and().body("get(0).waypointStateOrProvinceCode",equalTo("ES"))
			.and().body("get(0).waypointPostalCode",equalTo("17004")).and().body("get(0).waypointUrbanizationCode",equalTo("99")).and().body("get(0).waypointCountryName",equalTo("Spain")).and().body("get(0).waypointSequenceNumber",equalTo("1"));
				    
				    logger.log(LogStatus.PASS, "WayPointAddress codes verified!!");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "waypointCity,waypointPostalCode,waypointPostalCode,waypointCountryName");
		        
		}
		
		@Test
		public void WYtimestamp() {
			
			logger= report.startTest("Test 11 -verify timestamp");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(0).waypointActualEngagedTimeStamp",equalTo("2018-12-31T10:00:00Z")).and().body("get(0).waypointActualDisengagedTimeStamp",equalTo("2018-12-31T10:00:00Z"));
			
				    
				    logger.log(LogStatus.PASS, "timestamp verified!!");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "waypointActualEngagedTimeStamp,waypointActualDisengagedTimeStamp");
		        
		}
		
		@Test
		public void handlingUnit() {
			
			logger= report.startTest("Test 12 -verify handlingUnitID,UUID");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(0).handlingUnitId",equalTo("610033300")).and().body("get(0).handlingUnitUUID",equalTo("99887766554433221"));
			
				    
				    logger.log(LogStatus.PASS, "handlingUnitID,UUID verified!!");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "waypointActualEngagedTimeStamp,waypointActualDisengagedTimeStamp");
		        
		}
		
		@Test
		public void taskUUID() {
			
			logger= report.startTest("Test 13 -verify taskUUID");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(0).taskUUID",Matchers.notNullValue());
			
				    
				    logger.log(LogStatus.PASS, "taskUUID is not  null!!");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskUUID");
		        
		}
		
		@Test
		public void taskType() {
			
			logger= report.startTest("Test 14 -verify taskType");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(0).taskType",equalTo("ACCEPT_SHIPMENT_UNIT_TASK"));
			
				    
				    logger.log(LogStatus.PASS, "taskType verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskType : ACCEPT_SHIPMENT_UNIT_TASK");
		        
		}
		
		@Test
		public void taskaddress() {
			
			logger= report.startTest("Test 15 -verify taskaddress");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(0).taskAddressLineOne",equalTo("AFRICAN EASTERN")).and().body("get(0).taskAddressLineTwo",equalTo("HOPE MILLS"))
			.and().body("get(0).taskAddressLineThree",equalTo("PLIEN ST")).and().body("get(0).taskAddressLineFour",equalTo("2ND ROAD"));
				    
				    logger.log(LogStatus.PASS, "taskaddress verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskaddress :lineone,linetwo,linethree,linefour");
		        
		}
		
		@Test
		public void taskadress2() {
			
			logger= report.startTest("Test 16 -verify taskaddress-codes");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(0).taskCity",equalTo("KIWI")).and().body("get(0).taskStateOrProvinceCode",equalTo("UAE"))
			.and().body("get(0).taskPostalCode",equalTo("23098")).and().body("get(0).taskUrbanizationCode",equalTo("99")).and().body("get(0).taskCountryName",equalTo("KUWAIT")).and().body("get(0).taskCountryCode",equalTo("+9"));
				    
				    logger.log(LogStatus.PASS, "taskaddress verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskaddress :city,postalcodes,countryname");
		        
		}
		
		@Test
		public void tasktimestamp() {
			
			logger= report.startTest("Test 17 -verify tasktimestamp");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(0).taskBeginTime",equalTo("2018-09-05T10:00:00Z")).and().body("get(0).taskEndTime",equalTo("2018-09-05T11:00:00Z"));
			
				    
				    logger.log(LogStatus.PASS, "tasktimestamp verified!!");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskBeginTime,taskEndTime");
		        
		}
		
		@Test
		public void taskOutcome() {
			
			logger= report.startTest("Test 18 -verify taskOutcome");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(0).taskOutcome",equalTo("ShipmentUnitAcceptedTaskOutcome"));
				    
				    logger.log(LogStatus.PASS, "taskOutcome verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskOutcome : ShipmentUnitAcceptedTaskOutcome");
		        
		}
		
		@Test
		public void taskoutcomedetails() {
			
			logger= report.startTest("Test 19 -verify taskout-come-details");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(0).taskOccurredTime",equalTo("2018-10-05T11:00:00Z")).and().body("get(0).taskPerformedBy",equalTo("92927")).and().body("get(0).taskPerformedByDeviceId",equalTo("3691711"))
			 .and().body("get(0).taskCircumstance",equalTo("[FEDEX-BOX, FEDEX-ENVELOPE]"));
			
				    
				    logger.log(LogStatus.PASS, "taskout-come-details verified!!");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskOccurredTime,taskPerformedBy,taskPerformedByDeviceId,taskCircumstance");
		        
		}
		
		@Test
		public void taskType1() {
			
			logger= report.startTest("Test 20 -verify taskType[1]");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(1).taskType",equalTo("ACCEPT_SHIPMENT_UNIT_TASK"))
			 .and().body("get(1).taskStage",equalTo("COMPLETE"));
			
				    
				    logger.log(LogStatus.PASS, "taskType verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskType[1] : ACCEPT_SHIPMENT_UNIT_TASK");
		        
		}
		
		@Test
		public void taskOutcome1() {
			
			logger= report.startTest("Test 20 -verify ShipmentUnitNotAcceptedTaskOutcome");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(1).taskOutcome",equalTo("ShipmentUnitNotAcceptedTaskOutcome"))
			 .and().body("get(1).taskOutcomeReasonDesc",equalTo("Not Accepted"));
			
				    
				    logger.log(LogStatus.PASS, "ShipmentUnitNotAcceptedTaskOutcome verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskOutcome: ShipmentUnitNotAcceptedTaskOutcome");
		        
		}
		
		@Test
		public void taskOutcome2() {
			
			logger= report.startTest("Test 21 -verify ShipmentUnitReleasedTaskOutcome");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(2).taskType",equalTo("RELEASE_SHIPMENT_UNIT_TASK"))
			 .and().body("get(2).taskOutcome",equalTo("ShipmentUnitReleasedTaskOutcome")).and().body("get(2).taskOccurredTime",equalTo("2018-11-28T10:00:00Z"));
			
				    
				    logger.log(LogStatus.PASS, "taskOutcome[1] verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskOutcome: ShipmentUnitNotAcceptedTaskOutcome");
		        
		}
		
		@Test
		public void releaseshipmentdetails() {
			
			logger= report.startTest("Test 21 -verify releaseshipmentdetails");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(2).taskType",equalTo("RELEASE_SHIPMENT_UNIT_TASK"))
			 .and().body("get(2).taskReceivedBy",equalTo("John")).and().body("get(2).taskOccurredAt",equalTo("Office"));
			
				    
				    logger.log(LogStatus.PASS, "releaseshipmentdetails verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskReceivedBy,taskOccurredAt");
		        
		}
		
		@Test
		public void ShipmentUnitNotReleased() {
			
			logger= report.startTest("Test 22 -verify ShipmentUnitNotReleasedtaskoutcome");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(3).taskType",equalTo("RELEASE_SHIPMENT_UNIT_TASK"))
			 .and().body("get(3).taskOutcome",equalTo("ShipmentUnitNotReleasedTaskOutcome")).and().body("get(3).taskOccurredTime",equalTo(null));
			
				    
				    logger.log(LogStatus.PASS, "ShipmentUnitNotReleasedtaskoutcome verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskOutcome:ShipmentUnitNotReleasedTaskOutcome");
		        
		}
		
		@Test
		public void ShipmentUnitNotReleasedTaskOutcome() {
			
			logger= report.startTest("Test 23 - ShipmentUnitNotReleasedTaskOutcome-details");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(3).taskType",equalTo("RELEASE_SHIPMENT_UNIT_TASK"))
			 .and().body("get(3).taskOutcomeReasonDesc",equalTo("Not Released")).and().body("get(3).taskOutcomeReasonType",equalTo("[NO_VALID_RECIPIENT]"))
			 .and().body("get(3).taskPerformedBy",equalTo("JONNY")).and().body("get(3).taskPerformedByDeviceId",equalTo("78787"));
				    
				    logger.log(LogStatus.PASS, "ShipmentUnitNotReleasedTaskOutcome-details verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskOutcomeReasonDesc,taskOutcomeReasonType");
		        
		}
		
		@Test
		public void paymenttask() {
			
			logger= report.startTest("Test 24 -verify ACCEPT_SHIPMENT_PAYMENT_TASK");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(4).taskType",equalTo("ACCEPT_SHIPMENT_PAYMENT_TASK"))
			 .and().body("get(4).taskOutcome",equalTo("PaymentAcceptedTaskOutcome")).and().body("get(4).taskOccurredTime",equalTo("2018-09-05T11:00:00Z"));
			
				    
				    logger.log(LogStatus.PASS, "PaymentAcceptedTaskOutcome verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskType: ACCEPT_SHIPMENT_PAYMENT_TASK");
		        
		}
		
		@Test
		public void paymentaccepteddetails() {
			
			logger= report.startTest("Test 25 - PaymentAcceptedTaskOutcome-details");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(4).taskType",equalTo("ACCEPT_SHIPMENT_PAYMENT_TASK"))
			 .and().body("get(4).amountRendered",equalTo(100)).and().body("get(4).amountType",equalTo("IATA"))
			 .and().body("get(4).currency",equalTo("USD")).and().body("get(4).billToParty",equalTo("BILL_SENDER"))
			 .and().body("get(4).paymentMethod",equalTo("APPLE_PAY")).and().body("get(4).paymentDesignationType",equalTo("ASSEMBLY"))
			 .and().body("get(4).paymentDesignationDesc",equalTo("PAY-ME"));
				    
				    logger.log(LogStatus.PASS, "PaymentAcceptedTaskOutcome-details verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "amountRendered,amountType,currency,billToParty,paymentMethod");
		        
		}
		
		@Test
		public void paymentNOTaccepteddetails() {
			
			logger= report.startTest("Test 26 - PaymentNotAcceptedTaskOutcome-details");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(5).taskType",equalTo("ACCEPT_SHIPMENT_PAYMENT_TASK"))
			 .and().body("get(5).taskOutcome",equalTo("PaymentNotAcceptedTaskOutcome")).and().body("get(5).taskOutcomeReasonDesc",equalTo("PAYMENT_NOT_ACCEPTED"))
			 .and().body("get(5).taskPerformedBy",equalTo("7433")).and().body("get(5).taskPerformedByDeviceId",equalTo("3691712"))
			 .and().body("get(5).taskCircumstance",equalTo("[INTERNATIONAL_ECONOMY, PAY-RECEIEVE]"));
			 
				    logger.log(LogStatus.PASS, "PaymentNotAcceptedTaskOutcome-details verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskOutcome:PaymentNotAcceptedTaskOutcome");
		        
		}
		
		@Test
		public void Capturesignature() {
			
			logger= report.startTest("Test 27 -verify Capture-Signature-details");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(6).taskType",equalTo("CAPTURE_SIGNATURE_TASK"))
			 .and().body("get(6).taskOutcome",equalTo("SignatureCapturedTaskOutcome")).and().body("get(6).taskOccurredTime",equalTo("2018-09-05T11:00:00Z"));
			
				    
				    logger.log(LogStatus.PASS, "Capture-Signature verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskType: CAPTURE_SIGNATURE_TASK");
		        
		}
		
		@Test
		public void Capturesignaturedetails() {
			
			logger= report.startTest("Test 28 -verify signature");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(6).taskType",equalTo("CAPTURE_SIGNATURE_TASK"))
			 .and().body("get(6).taskPerformedBy",equalTo("1234")).and().body("get(6).taskPerformedByDeviceId",equalTo("37393")).
			 and().body("get(6).signatureCaptureMethod",equalTo("HAND_SIGNED_ON_DOCUMENT")).and().body("get(6).signatureCaptureInterface",equalTo("SHIPPER")).
			 and().body("get(6).signatureCaptureInterfaceIndex",equalTo("LABEL"));
			
				    
				    logger.log(LogStatus.PASS, "signatureCaptureMethod verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "signatureCaptureMethod: HAND_SIGNED_ON_DOCUMENT");
		}
		
		@Test
		public void SignatureNotCapturedTaskOutcome() {
			
			logger= report.startTest("Test 29 -verify SignatureNotCapturedTaskOutcome");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(7).taskType",equalTo("CAPTURE_SIGNATURE_TASK"))
			 .and().body("get(7).taskOutcome",equalTo("SignatureNotCapturedTaskOutcome")).and().body("get(7).taskOutcomeReasonDesc",equalTo("NOT CAPTURED SIGNATURE")).
			 and().body("get(7).taskPerformedBy",equalTo("474")).and().body("get(7).taskPerformedByDeviceId",equalTo("3691712")).
			 and().body("get(7).taskCircumstance",equalTo("[SIGN ON, PACKAGE DELIEVRY]"));
			
				    
				    logger.log(LogStatus.PASS, "SignatureNotCapturedTaskOutcome verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "SignatureNotCapturedTaskOutcome");
		}
		
		@Test
		public void RelinquishedTaskOutcome() {
			
			logger= report.startTest("Test 30 -verify RELINQUISH_SHIPMENT_UNIT_TASK");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(8).taskType",equalTo("RELINQUISH_SHIPMENT_UNIT_TASK"))
			 .and().body("get(8).taskOutcome",equalTo("ShipmentUnitRelinquishedTaskOutcome")).and().body("get(8).taskOccurredTime",equalTo("2018-12-31T11:00:00Z")).
			 and().body("get(8).taskPerformedBy",equalTo("7584")).and().body("get(8).taskPerformedByDeviceId",equalTo("369171")).
			 and().body("get(8).taskDefiningAuthorityName",equalTo("LONE"));
			
				    
				    logger.log(LogStatus.PASS, "ShipmentUnitRelinquishedTaskOutcome verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskType: RELINQUISH_SHIPMENT_UNIT_TASK");
		}
		
		@Test
		public void RelinquishedTaskOutcomeDETAILS() {
			
			logger= report.startTest("Test 31 -verify RELINQUISH_TASK_DETAILS");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(8).taskType",equalTo("RELINQUISH_SHIPMENT_UNIT_TASK"))
			 .and().body("get(8).taskOutcome",equalTo("ShipmentUnitRelinquishedTaskOutcome")).and().body("get(8).taskAcquiredById",equalTo("3691712")).
			 and().body("get(8).taskAcquiredByType",equalTo("REGULATORY_AGENCY")).and().body("get(8).taskRelinquishedById",equalTo("12345")).
			 and().body("get(8).taskRelinquishedByType",equalTo("SHIPPER"));
			
				    
				    logger.log(LogStatus.PASS, "RelinquishedTaskOutcome-DETAILS verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskAcquiredByType,taskRelinquishedById,taskRelinquishedByType");
		}
		
		@Test
		public void AcquiredTaskOutcome() {
			
			logger= report.startTest("Test 32 -verify ACQUIRE_SHIPMENT_UNIT_TASK");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(9).taskType",equalTo("ACQUIRE_SHIPMENT_UNIT_TASK"))
			 .and().body("get(9).taskOutcome",equalTo("ShipmentUnitAcquiredTaskOutcome")).and().body("get(9).taskOccurredTime",equalTo("2018-09-05T11:00:00Z")).
			 and().body("get(9).taskPerformedBy",equalTo("87876")).and().body("get(9).taskPerformedByDeviceId",equalTo("3691713")).
			 and().body("get(9).taskCircumstance",equalTo("[ACQUIRE_SHIPMENT, UNIT_TASK]"));
			
				    
				    logger.log(LogStatus.PASS, "ACQUIRE_SHIPMENT_UNIT_TASK verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskType: ACQUIRE_SHIPMENT_UNIT_TASK");
		}
		@Test
		public void REROUTE() {
			
			logger= report.startTest("Test 33 -verify RECORD_HANDLING_UNIT_REROUTE_TASK");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(10).taskType",equalTo("RECORD_HANDLING_UNIT_REROUTE_TASK"))
			 .and().body("get(10).taskOutcome",equalTo("HandlingUnitRerouteRecordedTaskOutcome")).and().body("get(10).taskOutcomeReasonDesc",equalTo("Alice")).
			 and().body("get(10).taskOutcomeReasonType",equalTo("CUSTOMER_REQUEST")).and().body("get(10).taskPerformedBy",equalTo("1234")).
			 and().body("get(10).taskPerformedByDeviceId",equalTo("12")).and().body("get(10).taskCircumstance",equalTo("[circumstance1, circumstance2]"));
			
				    
				    logger.log(LogStatus.PASS, "RECORD_HANDLING_UNIT_REROUTE_TASK verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskType: RECORD_HANDLING_UNIT_REROUTE_TASK");
		}
		
		@Test
		public void IRREGULARITY() {
			
			logger= report.startTest("Test 34 -verify RECORD_SHIPMENT_UNIT_IRREGULARITY_TASK");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(11).taskType",equalTo("RECORD_SHIPMENT_UNIT_IRREGULARITY_TASK"))
			 .and().body("get(11).taskOutcome",equalTo("ShipmentUnitIrregularityRecordedTaskOutcome")).and().body("get(11).taskOutcomeReasonDesc",equalTo("SHIPMENT_WRONGADDRESS")).
			 and().body("get(11).taskOutcomeReasonType",equalTo("INCORRECT_ADDRESS")).and().body("get(11).taskPerformedBy",equalTo("6575")).
			 and().body("get(11).taskPerformedByDeviceId",equalTo("3691713")).and().body("get(11).taskCircumstance",equalTo("[SHIPMENTUNIT, IRREGULAR]"));
			
				    
				    logger.log(LogStatus.PASS, "RECORD_SHIPMENT_UNIT_IRREGULARITY_TASK verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskType: RECORD_SHIPMENT_UNIT_IRREGULARITY_TASK");
		}
		
		@Test
		public void REFUSEDTASK() {
			
			logger= report.startTest("Test 35 -verify RECORD_SHIPMENT_UNIT_REFUSED_TASK");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(12).taskType",equalTo("RECORD_SHIPMENT_UNIT_REFUSED_TASK"))
			 .and().body("get(12).taskOutcome",equalTo("ShipmentUnitRefusedRecordedTaskOutcome")).and().body("get(12).taskOutcomeReasonDesc",equalTo("REFUSED SHIPMENT")).
			 and().body("get(12).taskOutcomeReasonType",equalTo("NOT DELIVERD ON TIME")).and().body("get(12).taskPerformedBy",equalTo("333")).
			 and().body("get(12).taskPerformedByDeviceId",equalTo("3691712")).and().body("get(12).taskCircumstance",equalTo("[SHIPEMENT, REFUSED]"));
			
				    
				    logger.log(LogStatus.PASS, "RECORD_SHIPMENT_UNIT_REFUSED_TASK verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskType: RECORD_SHIPMENT_UNIT_REFUSED_TASK");
		}
		
		
		@Test
		public void IMPEDEDTASK() {
			
			logger= report.startTest("Test 36 -verify RECORD_HANDLING_UNIT_TRIP_IMPEDED_TASK");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(13).taskType",equalTo("RECORD_HANDLING_UNIT_TRIP_IMPEDED_TASK"))
			 .and().body("get(13).taskOutcome",equalTo("HandlingUnitTripImpededRecordedTaskOutcome")).and().body("get(13).taskOutcomeReasonDesc",equalTo("HANDLINGUNIT_LATE_ARRIVE")).
			 and().body("get(13).taskOutcomeReasonType",equalTo("ARRIVED_LATE_AT_HUB_OR_RAMP")).and().body("get(13).taskPerformedBy",equalTo("3839")).
			 and().body("get(13).taskPerformedByDeviceId",equalTo("3691713")).and().body("get(13).taskCircumstance",equalTo("[ARRIVED, LATE]"));
			
				    
				    logger.log(LogStatus.PASS, "RECORD_HANDLING_UNIT_TRIP_IMPEDED_TASK verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskType: RECORD_HANDLING_UNIT_TRIP_IMPEDED_TASK");
		}
		
		@Test
		public void REQUESTREROUTE() {
			
			logger= report.startTest("Test 37 -verify RECORD_HANDLING_UNIT_REQUEST_TO_REROUTE_TASK");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(14).taskType",equalTo("RECORD_HANDLING_UNIT_REQUEST_TO_REROUTE_TASK"))
			 .and().body("get(14).taskOutcome",equalTo("HandlingUnitRequestToRerouteRecordedTaskOutcome")).and().body("get(14).taskOutcomeReasonDesc",equalTo("DELIVERY TO FEDEX OFFICE")).
			 and().body("get(14).taskOutcomeReasonType",equalTo("CUSTOMER NOT AVALIABLE")).and().body("get(14).taskPerformedBy",equalTo("6484")).
			 and().body("get(14).taskPerformedByDeviceId",equalTo("3691713")).and().body("get(14).taskCircumstance",equalTo("[CLOSED, GATE]"));
			
				    
				    logger.log(LogStatus.PASS, "RECORD_HANDLING_UNIT_REQUEST_TO_REROUTE_TASK verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskType: RECORD_HANDLING_UNIT_REQUEST_TO_REROUTE_TASK");
		}
		
		
		@Test
		public void UNDELIVERED() {
			
			logger= report.startTest("Test 38 -verify RECORD_SHIPMENT_UNIT_UNDELIVERABLE_TASK");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(15).taskType",equalTo("RECORD_SHIPMENT_UNIT_UNDELIVERABLE_TASK"))
			 .and().body("get(15).taskOutcome",equalTo("ShipmentUnitUndeliverableRecordedTaskOutcome")).and().body("get(15).taskOutcomeReasonDesc",equalTo("SHIPMENT DELIVERY MISSED")).
			 and().body("get(15).taskOutcomeReasonType",equalTo("INSUFFICIENT TIME")).and().body("get(15).taskPerformedBy",equalTo("47474")).
			 and().body("get(15).taskPerformedByDeviceId",equalTo("43839")).and().body("get(15).taskCircumstance",equalTo("[SHIPMENT, UNDELIVERD]"));
			
				    
				    logger.log(LogStatus.PASS, "RECORD_SHIPMENT_UNIT_UNDELIVERABLE_TASK verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskType: RECORD_SHIPMENT_UNIT_UNDELIVERABLE_TASK");
		}
		
		@Test
		public void DEVIATION() {
			
			logger= report.startTest("Test 39 -verify RECORD_HANDLING_UNIT_ITINERARY_DEVIATION_TASK");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(16).taskType",equalTo("RECORD_HANDLING_UNIT_ITINERARY_DEVIATION_TASK"))
			 .and().body("get(16).taskOutcome",equalTo("HandlingUnitItineraryDeviationRecordedTaskOutcome")).and().body("get(16).taskOutcomeReasonDesc",equalTo("DIVERTED ROUTE")).
			 and().body("get(16).taskOutcomeReasonType",equalTo(null)).and().body("get(16).taskPerformedBy",equalTo("55")).
			 and().body("get(16).taskPerformedByDeviceId",equalTo("3691713")).and().body("get(16).taskCircumstance",equalTo("[DEVIATION, WRONG ROUTE]"));
			
				    
				    logger.log(LogStatus.PASS, "RECORD_HANDLING_UNIT_ITINERARY_DEVIATION_TASK verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskType: RECORD_HANDLING_UNIT_ITINERARY_DEVIATION_TASK");
		}
		
		@Test
		public void tripinterrupt() {
			
			logger= report.startTest("Test 40 -verify INTERRUPT_HANDLING_UNIT_TRIP_TASK");
			RestAssured.baseURI = "a";
			
			 given().
			 when().
			 get (a).then().assertThat().statusCode(200).
			 and().contentType(ContentType.JSON).and().body("get(17).taskType",equalTo("INTERRUPT_HANDLING_UNIT_TRIP_TASK"))
			 .and().body("get(17).taskOutcome",equalTo("HandlingUnitTripInterruptedTaskOutcome")).and().body("get(17).taskOutcomeReasonDesc",equalTo("ROAD-CLOSED")).
			 and().body("get(17).taskOutcomeReasonType",equalTo("DUE_TO_IMPEDIMENT")).and().body("get(17).taskPerformedBy",equalTo("3738")).
			 and().body("get(17).taskPerformedByDeviceId",equalTo("3691713")).and().body("get(17).taskCircumstance",equalTo("[TRIP, INTERRUPTED]"));
			
				    
				    logger.log(LogStatus.PASS, "INTERRUPT_HANDLING_UNIT_TRIP_TASK verified");
				    logger.log(LogStatus.PASS, a);
				    logger.log(LogStatus.PASS, "taskType: INTERRUPT_HANDLING_UNIT_TRIP_TASK");
		}
		
		
		
		@AfterMethod
		public void tearDown(ITestResult result)
		{
		
		if (result.getStatus() ==ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, " Test failed!!");
		}
		}
		
		
		@AfterClass
		public void tearDown()
		
		{
			report.endTest(logger);
		    logger.log(LogStatus.INFO,"Ending the Test");
		    logger.log(LogStatus.INFO,"Response Data displayed");
			report.flush();
			driver.get("C:\\Users\\3691713\\Documents\\RestReports-1.html");
			
		}
}
 
