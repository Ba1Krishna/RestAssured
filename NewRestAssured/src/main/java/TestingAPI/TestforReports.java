package TestingAPI;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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

public class TestforReports {
	
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
	
	@Test
	public void test_streetaddessvalidity() {
		
		
	    logger= report.startTest("Test 1- verify address");
	    logger.log(LogStatus.INFO, "API started Running");
	    given().
	    when().
	        get("https://jsonplaceholder.typicode.com/users/1").
	    then().
	        assertThat().
	        body("address.street",equalTo("Kulas Light"));
	    
	    logger.log(LogStatus.PASS, "Address validated Success!!");
	}

	
	
	@Test
	public void test_phoneNumberValidity() {
		
		logger= report.startTest("Test 2- verify address");
		
	        
	    given().
	    when().
	        get("https://jsonplaceholder.typicode.com/users/1").
	    then().
	        assertThat().
	        body("phone",equalTo("1-770-736-8031 x56442"));
	    
	    logger.log(LogStatus.PASS, "Phone Number Success!!");
	}
	
	@Test
	public void test_catchphaseValidity() {
		
		logger= report.startTest("Test 3- verify address");
	        
	    given().
	    when().
	        get("https://jsonplaceholder.typicode.com/users/1").
	    then().
	        assertThat().
	        body("company.catchPhrase",equalTo("Multi-layered client-server neural-net"));
	    logger.log(LogStatus.PASS, "catch phase validated Success!!");
	}
	
	@Test
	public void test_websiteaddressValidity() {
		
		logger= report.startTest("Test 4- verify address");
	        
	    given().
	    when().
	        get("https://jsonplaceholder.typicode.com/users/1").
	    then().
	        assertThat().
	        body("website",equalTo("hildegard.org"));
	    logger.log(LogStatus.PASS, "Website address validated Success!!");
	}
	
	@Test
	public void test_zipcodeValidity() {
		
		logger= report.startTest("Test 5- verify address");
	        
	    given().
	    when().
	        get("https://jsonplaceholder.typicode.com/users/1").
	    then().
	        assertThat().
	        body("address.zipcode",equalTo("92998-3874"));
	    logger.log(LogStatus.PASS, "Zip code data validated Success!!");
	}
	
	@Test
	public void test_UserNameValidity() {
		
		logger= report.startTest("Test 6- verify address");
	        
	    given().
	    when().
	        get("https://jsonplaceholder.typicode.com/users/1").
	    then().
	        assertThat().
	        body("username",equalTo("Bret"));
	    logger.log(LogStatus.PASS, " user name validated Success!!");
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
