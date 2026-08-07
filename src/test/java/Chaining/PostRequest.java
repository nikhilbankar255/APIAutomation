package Chaining;


import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class PostRequest {

	@Test
	public void test_createUser(ITestContext context)
	{
		Faker faker = new Faker(); 
		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken = "35086feb582ad9db70d3537d1b8e232281658a99f37be44f4b5e05a97a714ed1";
	
		
		int id= given()
				.headers("Authorization", "Bearer "+bearerToken)
				.contentType("application/json")
				.body(data.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
			
		System.out.println("Generated ID is:"+id);
		
		context.setAttribute("userId", id);
	}		
}
