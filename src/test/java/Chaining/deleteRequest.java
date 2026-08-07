package Chaining;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class deleteRequest {

	@Test
	public void test_getUser(ITestContext context)
	{
		int id= (Integer)context.getAttribute("userId");
		String bearerToken = "35086feb582ad9db70d3537d1b8e232281658a99f37be44f4b5e05a97a714ed1";
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
			.pathParam("id", id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(204)
		.log()
		.all();
	}
}
