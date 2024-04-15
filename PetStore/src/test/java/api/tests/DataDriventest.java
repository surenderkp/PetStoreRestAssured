package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payloads.User;
import api.utilities.dataproviders;
import io.restassured.response.Response;

public class DataDriventest {
		
	@Test(priority=1, dataProvider="Data",dataProviderClass=dataproviders.class)
	public void Testpostuser(String UserID ,String un, String fname, String lname, String email,String pwd, String ph) {
		    User userpayload = new User();
			userpayload.setId(Integer.parseInt(UserID));
			userpayload.setUsername(un);
			userpayload.setFirstName(fname);
			userpayload.setLastName(lname);
			userpayload.setPassword(email);
			userpayload.setEmail(pwd);
			userpayload.setPhone(ph);
		
			Response response=UserEndpoints.createUser(userpayload);
			response.then().log();
			
			Assert.assertEquals(response.getStatusCode(), 200);
		}
	
	@Test(priority=2, dataProvider="usernames",dataProviderClass=dataproviders.class)
	public void Testdeleteuser(String username) {
		   
		
			Response response=UserEndpoints.DeleteUser(username);
			response.then().log();
			
			Assert.assertEquals(response.getStatusCode(), 200);
		}
}
