package Activities;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity2 {
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	String userId;
	
	
		
		@BeforeClass
		public void setUp() {
			requestSpec=new RequestSpecBuilder().
						setBaseUri("https://petstore.swagger.io/v2/user").
						addHeader("Content-Type","application/json").build();
			responseSpec=new ResponseSpecBuilder().
					expectStatusCode(200).
					expectBody("message",Matchers.equalTo("9990")).
					expectResponseTime(Matchers.lessThanOrEqualTo(5000L)).build();
			}
		
		
		@Test(priority=1)
		public void addNewUserFromFile() throws IOException {
			FileInputStream userInfo=new FileInputStream("src\\test\\resources\\userInfo.json");
			Response response=given().
					spec(requestSpec).
					body(userInfo).log().all().
					when().post();
			userInfo.close();
			response.then().log().all();
			//extract 
				//userId=response.then().extract().path("message");
				response.then().spec(responseSpec).log().all();
			//	response.then().body("code", Matchers.equalTo(200));
				//response.then().body("message", Matchers.equalTo("9990"));
		}
	@Test(priority=2)
	public void getUserInfo() {
		File outputJSON=new File("src/test/java/activities/userGETResponse.json");
		Response response=given().
				spec(requestSpec).
				pathParam("username","drews").
				log().all().
				when().get("/{username}");
				//get response body
		String resBody=response.getBody().asPrettyString();
		try {
		//create json file
			outputJSON.createNewFile();
			// Write response body to external file
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(resBody);
			writer.close();
		}
		catch(IOException excp) {
			excp.printStackTrace();
		
		}
		//assertion
		response.then().body("id", Matchers.equalTo(9990));
		response.then().body("username", Matchers.equalTo("drews"));
		response.then().body("firstName", Matchers.equalTo("Justin"));
		response.then().body("lastName", Matchers.equalTo("Case"));
		response.then().body("email", Matchers.equalTo("justincase@mail.com"));
		response.then().body("password", Matchers.equalTo("password123"));
		response.then().body("phone", Matchers.equalTo("9812763450"));
		
		
		}
	
	@Test(priority = 3)
	public void deleteRequestTest() {
		//Send the request, save the response
		given().spec(requestSpec).pathParam("username", "drews").log().all().
		when().delete("/{username}").
		then().statusCode(200).body("message", Matchers.equalTo("drews"));
		//Extract the response
		//Assertions

		// Assertion
//		response.then().body("code", equalTo(200));
//		response.then().body("message", equalTo("justinc"));
		
	}
	}

