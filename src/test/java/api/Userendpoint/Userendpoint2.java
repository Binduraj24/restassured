package api.Userendpoint;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.Routes.Baseurls;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Userendpoint2 {
	
	 static ResourceBundle geturl(){
		
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createuser(User payload) {
		String get_posturl=geturl().getString("post_url");
		
	Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
	   .when()
		.post(get_posturl);
		return response;
		
		
	}
	public static  Response getuser(String username) {
		String geturl=geturl().getString("get_url");
		Response response=given()
		                     .pathParam("username", username)
		                     .accept(ContentType.JSON)
		.when()
		.get(geturl);
		return response;
		
	}
	
	public static Response updateuser(String username,User payload) {
		String puturl=geturl().getString("update_url");
		Response response= given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.pathParam("username", username)
			
		   .when()
			 .put(puturl);
			return response;
			
			
		}
public static  Response deleteuser(String username) {
	String deleteurl=geturl().getString("delete_url");
		Response response=given()
		                     .pathParam("username", username)
		                     .accept(ContentType.JSON)
		.when()
		.delete(deleteurl);
		return response;
		
	}

}
