package Examples;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstTest {
	// GET https://petstore.swagger.io/v2/pet/findByStatus?status=sold
	@Test
	public void getRequestWithQueryParam() {
		Response response=RestAssured.given()
				.baseUri("https://petstore.swagger.io/v2")
				.header("Content-Type","apllication/json")
				.queryParam("status", "sold").
				//send request and receive response
				when().get("/pet/findByStatus");	
				//get the response status code
				System.out.println("status code :" +response.getStatusCode());
				//get the response headers
				//System.out.println("response headers :" +response.getHeader());
				//get the response body
				System.out.println("body: \n" +response.getBody().asString());
				System.out.println("body: \n" +response.getBody().asPrettyString());
				//extraxt json properties using jsonpath
				String getStatus=response.then().extract().path("[0].status");
				
				response.then().statusCode(200).
				body("[0].status",Matchers.equalTo("sold"));

	}
		// GET https://petstore.swagger.io/v2/pet/{petId}
	public void getRequestWithPathParam() {
		RestAssured.given()
				.baseUri("https://petstore.swagger.io/v2")
				.header("Content-Type","apllication/json")
				.pathParam("petId", 12).
				//send request and receive response
				when().get("/pet/{petId}").
				then().statusCode(200).
				body("id",Matchers.equalTo("12"));

	}
	
	
}
