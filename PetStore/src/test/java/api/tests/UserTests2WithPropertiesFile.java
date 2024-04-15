package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2WithPropertiesFile;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests2WithPropertiesFile {
		
	Faker faker;
	User userpayload;
	
	public Logger logger;
	@BeforeClass
	public void setupp() {
		faker = new Faker();
		userpayload = new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		//for logs
		
		logger= LogManager.getLogger(this.getClass());
		
	}
	@Test(priority=1)
	public void testpostuser() {
		logger.info("***************  Creating User   *****************");
		Response response=UserEndpoints2WithPropertiesFile.createUser(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("***************   User Created   *****************");
	}
	
	@Test(priority=2)
	public void testreaduser() {
		
		logger.info("***************  Reading User   *****************");
		Response response=UserEndpoints2WithPropertiesFile.ReadUser(this.userpayload.getUsername());
		response.then().log().all();
	
		
		Assert.assertEquals(response.getHeader("Content-Type"),"application/json");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("***************   User Details Displayed   *****************");
	}
	
	@Test(priority=3)
	public void testupdateuser() {
		logger.info("***************  Updating User   *****************");
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setPassword(faker.internet().password(5,10));
		
		logger.info("***************  User Updated  *****************");
		
		
		Response response=UserEndpoints2WithPropertiesFile.UpdateUser(this.userpayload.getUsername() , userpayload);
		response.then().log().all();	
		
		Assert.assertEquals(response.getHeader("Content-Type"),"application/json");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=4)
	public void testdeleteuser() {
		
		logger.info("***************  Deleting User   *****************");
		Response response=UserEndpoints2WithPropertiesFile.DeleteUser(this.userpayload.getUsername());
		response.then().log().all();
		logger.info("***************   User Deleted   *****************");
	
		
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
