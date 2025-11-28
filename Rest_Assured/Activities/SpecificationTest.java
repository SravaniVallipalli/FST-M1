package Examples;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationTest {
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	int petId;
	
	@BeforeMethod
	@BeforeClass
	public void setUp() {
		//create the request specification
		// only set common items else will use everything specified, like body which is for only post will go with get and delete.
		requestSpec=new RequestSpecBuilder()
					.setBaseUri("https://petstore.swagger.io/v2/")
					.addHeader("content-Type","application/json").build();
					
		//create the response specification
		responseSpec=new ResponseSpecBuilder()
					.expectStatusCode(200)
					.expectBody("status",Matchers.equalTo("alive")).
					expectResponseTime(Matchers.lessThanOrEqualTo(5000L)).build();
	}
	
	@Test(priority=1)
	public void postRequestTest() {
		Map<String, Object> reqBody=new HashMap<>();
		reqBody.put("id",779897);
		reqBody.put("name", "retrweq");
		reqBody.put("status", "alive");
		//send request, save response
		Response response=
				given().
				spec(requestSpec).body(reqBody).
				log().all().
				when().
				post("/pet");
		//extract the pet id from response
		this.petId=response.then().extract().path("id");
		//assertions
		response.then().spec(responseSpec).log().all();
	}

	@Test(priority=2)
	public void getRequestTest() {
		//send request, receive response and alert
		given().spec(requestSpec).pathParam("petId", this.petId).
		when().get("/pet/{petId}").
		then().spec(responseSpec);
	
	}
	@Test(priority=3)
	public void deleteRequestTest() {
		given().spec(requestSpec).pathParam("petId",this.petId).
		when().delete("/pet/{petId}").
		then().statusCode(200).body("message",Matchers.equalTo(""+this.petId));
		
	}
	
	
	
}
