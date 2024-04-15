package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
// here we perform crud operation , create retrieve/read , update and delete
public class UserEndpoints {
	public static Response 	createUser(User payload){
		Response	response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(Routes.post_url);
		
		return response;
		}
	public static Response 	ReadUser(String userName){
		Response	response=given()
				.pathParam("username", userName)
			.when()
				.get(Routes.get_url);
		
		return response;
		}
	public static Response 	UpdateUser(String userName,User payload){
		Response	response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)
			.when()
				.put(Routes.put_url);
		
		return response;
		}
	public static Response 	DeleteUser(String userName){
		Response	response=given()
				.pathParam("username", userName)
			.when()
				.delete(Routes.delete_url);
		
		return response;
		}
	
	
}
