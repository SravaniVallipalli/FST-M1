package Activities;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3 {
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setUp() {
		requestSpec=new RequestSpecBuilder().
				addHeader("Content-Type","application/json").
				setBaseUri("https://petstore.swagger.io/v2/pet").build();
		responseSpec=new ResponseSpecBuilder().
				expectStatusCode(200).
				expectContentType("application/json").
				expectBody("status", Matchers.equalTo("alive")).build();
		
		}
	@DataProvider(name="PetInfo")
	public Object[][] petInfoProvider(){
		Object[][] testData=new Object[][] {
			{77232,"Riley","alive"},
			{77233,"Hansel","alive"}
		};
		return testData;
		
	}
	//post
	@Test(priority=1, dataProvider="PetInfo")
	//testcase using data provider
	public void addPets(int petId, String petName,String petStatus) {
		Map<String,Object> reqBody=new HashMap<>();
		reqBody.put("id", petId);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);
		given().spec(requestSpec).
		body(reqBody).
		when().post().
		then().spec(responseSpec).
		body("name",Matchers.equalTo(petName));
		
	}
	//get
	@Test(priority=2, dataProvider="PetInfo")
	public void getPets(int petId, String petName, String petStatus) {
		given().spec(requestSpec).
		pathParam("petId",petId).
		log().all().
		when().get("/{petId}").
		then().spec(responseSpec).
		body("name",Matchers.equalTo(petName))
		.log().all();
	}
	//delete
	@Test(priority=3, dataProvider="PetInfo")
	public void deletePets(int petId, String petName, String petStatus) {
		given().spec(requestSpec)
		.pathParam("petId",petId)
		.when().delete("/{petId}")
		.then()
		.body("code", Matchers.equalTo(200))
		.body("message", Matchers.equalTo(""+petId))
		.log().all();
	}
}
