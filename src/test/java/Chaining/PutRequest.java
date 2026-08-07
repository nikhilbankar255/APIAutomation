package Chaining;
import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;


public class PutRequest {

	@Test
	public void test_updateUser(ITestContext context)
	{
		int id= (Integer)context.getAttribute("userId");
		
		Faker faker = new Faker(); 
		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken = "35086feb582ad9db70d3537d1b8e232281658a99f37be44f4b5e05a97a714ed1";
	
		
		 given()
				.headers("Authorization", "Bearer "+bearerToken)
				.contentType("application/json")
				.body(data.toString())
				.pathParam("id", id)
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
	}	
}
