package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.Userendpoint.Userendpoint;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class datadriventest {
	
	@Test(priority=1,dataProvider="alldata",dataProviderClass=DataProviders.class)
	public void dduserstest_post(String id,String username,String firstname,String lastname,String email,String password,String phone) {
		//user class i heved to pojo class to create userpayload
		User userpayload=new User();
		userpayload.setId(Integer.parseInt(id));
		userpayload.setUsername(username);
		userpayload.setFirstname(firstname);
		userpayload.setLastname(lastname);
		userpayload.setEmail(email);
		userpayload.setPassword(password);
		
		Response response=Userendpoint.createuser(userpayload);
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
   @Test(priority=2,dataProvider="username",dataProviderClass=DataProviders.class)
	public void deleteallcreatedusers_indatabase(String username) {
	
	Response response=Userendpoint.deleteuser(username);
	Assert.assertEquals(response.getStatusCode(),200);
		
	}
}
