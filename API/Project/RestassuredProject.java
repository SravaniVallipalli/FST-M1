package RestAssuredProject;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import au.com.dius.pact.consumer.dsl.Matchers;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestassuredProject {
	String sshKey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIBoztAbddfPt+nOZfPJuyL9tgZrIB7o6bWo8+EvKu6gI1234213safdsd";
	int keyId;
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setUp() {
		requestSpec=new RequestSpecBuilder()
				.setBaseUri("https://api.github.com")
				.addHeader("ContentType", "application/json")
				.addHeader("Authorization", "Bearer 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23ssd")
				.build();
		
		
//		responseSpec = new ResponseSpecBuilder().
//				expectBody("title", Matchers.equalTo("testApiKey")).
//				expectBody("key", Matchers.equalTo(sshKey)).
//				expectResponseTime(Matchers.lessThanOrEqualTo(3000L)).
//				build();			
		
	}
		@Test(priority=1)
			public void postGitRequestTest() {
				Map<String,Object> reqBody=new HashMap<>();
				reqBody.put("title","testApiKey");
				reqBody.put("key", sshKey);
				Response response=RestAssured
						.given()
						.spec(requestSpec)
						.body(reqBody).log().all()
						.when().post("/user/keys")
						.then().log().all()
						.extract().response();
				
				Assert.assertEquals(response.getStatusCode(), 201, "Expected HTTP status code 201 for POST");
				keyId=response.jsonPath().getInt("id");				
		}
		@Test(priority=2)
		public void getGitRequestTest() {
			RestAssured.given().spec(requestSpec).pathParam("keyId",keyId)
			.when().get("/user/keys/{keyId}")
			.then().statusCode(200).log().all();
		}
			
		@Test(priority=3)
		public void deleteGitRequestTest() {
			RestAssured.given().spec(requestSpec).pathParam("keyId",keyId)
			.when().delete("/user/keys/{keyId}")
			.then().statusCode(204);
		}
		
		
		
		
	
	
}
	

