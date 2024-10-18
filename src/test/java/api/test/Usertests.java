package api.test;

import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Userendpoint.Userendpoint;
import api.payload.User;
import io.restassured.response.Response;

public class Usertests {
	
	Faker faker;
	User userpayload;
	public org.apache.logging.log4j.Logger log;
	@BeforeClass
	public void setdata() {
		faker=new Faker();
		userpayload=new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setUsername(faker.name().username());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		//userpayload.getUserStatus(faker.phoneNumber().cellPhone());
		log=LogManager.getLogger(this.getClass());
	}
	@Test(priority=1)
	void testpostmethod() {
log.info("**********************************creating user*****************");
		Response response=Userendpoint.createuser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		log.info("********************************** user created*****************");
	}
	@Test(priority=2)
	void testgetmethod() {
		log.info("********************************** getting user information *****************");
		Response response=Userendpoint.getuser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		log.info("**********************************  user information is displayed*****************");
	}
	@Test(priority=3)
	void testputmethod() {
		log.info("********************************** updating user information *****************");
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setUsername(faker.name().username());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=Userendpoint.updateuser(this.userpayload.getUsername(),userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		Response response_afterupdate=Userendpoint.getuser(this.userpayload.getUsername());
		response_afterupdate.then().log().all();
		Assert.assertEquals(response_afterupdate.getStatusCode(),200);
		log.info("********************************** user information is updated*****************");
		
	}
	@Test(priority=4)
	void testdeletemethod() {
		log.info("********************************** user information is deleting*****************");	
		Response response=Userendpoint.deleteuser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		log.info("********************************** user information is deleted*****************");
	}

}
