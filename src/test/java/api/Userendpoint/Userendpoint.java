package api.Userendpoint;
import static io.restassured.RestAssured.given;

import api.Routes.Baseurls;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Userendpoint {
	
	public static Response createuser(User payload) {
		
	Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
	   .when()
		.post(Baseurls.post_url);
		return response;
		
		
	}
	public static  Response getuser(String username) {
		
		Response response=given()
		                     .pathParam("username", username)
		                     .accept(ContentType.JSON)
		.when()
		.get(Baseurls.get_url);
		return response;
		
	}
	
	public static Response updateuser(String username,User payload) {
		
		Response response= given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.pathParam("username", username)
			
		   .when()
			 .put(Baseurls.put_url);
			return response;
			
			
		}
public static  Response deleteuser(String username) {
		
		Response response=given()
		                     .pathParam("username", username)
		                     .accept(ContentType.JSON)
		.when()
		.delete(Baseurls.delete_url);
		return response;
		
	}

}
