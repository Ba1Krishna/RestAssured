package TestingAPI;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.Assert.assertEquals;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class googletest {
	
	WebDriver driver;

	   @BeforeSuite
	   public void testbefore()
	   {
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\3691713\\Documents\\chromedriver.exe");
		   driver=new ChromeDriver();
	   }
	   

		
		
		ExtentTest logger;
		
		ExtentReports report =new ExtentReports("C:\\Users\\3691713\\Documents\\RestReports-1.html");
		
@Test
public void exampleRestTest() {
	
    given()
        .contentType(ContentType.JSON)
    .when()
        .get("https://jsonplaceholder.typicode.com/users/1")
    .then()
        .statusCode(200)
        .body("address.street", equalTo("Kulas Light"))
        .body("address.suite", equalTo("Apt. 556"));
    
}

//@Test
//public void GetWeatherDetailsCondensed()
//{
//	// Specify the base URL to the RESTful web service
//	RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users/1";
//
//	// Get the RequestSpecification of the request that you want to sent
//	// to the server. The server is specified by the BaseURI that we have
//	// specified in the above step.
//	RequestSpecification httpRequest = RestAssured.given();
//
//	// Make a GET request call directly by using RequestSpecification.get() method.
//	// Make sure you specify the resource name.
//	Response response = httpRequest.get("https://jsonplaceholder.typicode.com/users/1");
//
//	// Response.asString method will directly return the content of the body
//	// as String.
//	System.out.println("Response Body is =>  " + response.asString());
//}

@Test
public void givenUrl_whenMultipleXmlValuesTestEqualInShortHand_thenCorrect() {
	
	logger= report.startTest("Test 2 verify company details");

	given()
    .contentType(ContentType.JSON)
.when()
.get("https://jsonplaceholder.typicode.com/users/1")
    .then()
      .body("company.name", equalTo("Romaguera-Crona"))
      .body("company.catchPhrase", equalTo("Multi-layered client-server neural-net"))
        .body("company.bs", equalTo("harness real-time e-markets")); 
	
    logger.log(LogStatus.PASS, " company details verified!!");

}

@Test
public void RestServiceTest(){
	
	logger= report.startTest("Test 3 verify lattitude and lang");

	given()
.when().
        get("https://jsonplaceholder.typicode.com/users/1").
        then().
            assertThat().
            body("geo.lat", equalTo("-37.3159")).
        and().
            assertThat().body("geo.lng", equalTo("81.1496")).
        and().
            assertThat().body("website", equalTo("hildegard.org")); 
    logger.log(LogStatus.PASS, " lattitude and langitue verified!!");


}


@Test
public void exampleJsonPathTest() {
	logger= report.startTest("verify phone and id");

  Response res = get("https://jsonplaceholder.typicode.com/users/1");
  String json = res.asString();
  JsonPath jp = new JsonPath(json);
  assertEquals("1-770-736-8031 x56442", jp.get("phone"));
  assertEquals("92998-3874", jp.get("zipcode"));
  logger.log(LogStatus.PASS, " lattitude and langitue verified!!");
	System.out.println("Response Body is =>  " + res.asString());


}
@Test
public void givenUrl_whenSuccessAndJsonHasUsername_thenCorrect() {
	logger= report.startTest("verify ursename");

    get("https://jsonplaceholder.typicode.com/users/1").then().statusCode(200).assertThat()
            .body("username", equalTo("Bret"));
    logger.log(LogStatus.PASS, " lattitude and langitue verified!!");

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
private Response get(String string) {
	// TODO Auto-generated method stub	
	return null;
}

	
}

