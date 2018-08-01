import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleGetTest1 {
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("Setting up to get the Weather Details API");
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	}
	
	@Test
	public void GetWeatherDetails()
	{   
		

		// Get the RequestSpecification of the request that you want to sent
		// to the server. 
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		// Now let us print the body of the message to see what response
		// we have received from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is "+statusCode);
		Assert.assertEquals(statusCode, 200,"Correct:Success");

	}
	
	@AfterMethod
	public void quit()
	{
		System.out.println("Closing the API");
	}

}
