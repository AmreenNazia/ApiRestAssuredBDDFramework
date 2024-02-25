package PageClass;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.Assert;

import Utilities.LoggerLoad;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Commonpage {

	Response response;
	String ListOfUsers;
	String singleUser;
	String ListOfResources;
	String userNotfound;
 
	/* First Scenario to get the list of users*/

	public void setupEndpoint() {
		baseURI = "https://reqres.in";


	}
	public void getRequestOfUsers() {
		response = given().
				when().
				get("/api/users/?page=2");
		ResponseBody body = response.getBody();
		System.out.println("---------List of Users from Reqres.in---------");
		
		ListOfUsers =  body.asPrettyString();
		System.out.println(ListOfUsers);

	}
	public void ValidateListOfUsers() throws IOException {
		File file = new File("/Users/amreennaziasyed/eclipse-workspace/DSALGO/RestAssured_BddFramework/TestData/Schema.json");
		 
		FileInputStream fileinputstream = new FileInputStream(file);
		System.out.println(fileinputstream);
		String Listofusers = IOUtils.toString(fileinputstream, "UTF-8");
		 

		Assert.assertEquals(ListOfUsers, Listofusers);
		System.out.println("Verification has passed for list of users");
	}
	/*Second scenario to get the single user details and validate*/	
	public void setupforUser() {
		baseURI = "https://reqres.in/api";
	    basePath ="/users/2";

	}
	public void getSingleUser() {
		
		response = given().
			    when().
			    get().
			    then().
			    contentType(ContentType.JSON).extract().response();
		
		 singleUser = response.getBody().asPrettyString();
		 System.out.println("---------Single user from Reqres.in---------");
		 System.out.println(singleUser);
	}
	
	public void validateSingleUser(String first_name) {
		String FirstName = response.path("data.first_name");
		 
		 Assert.assertEquals(FirstName,first_name);
		 System.out.println("Verification has passed for single user");
	}
	/*Third Scenario to get the response of single user not found*/
	
	
	public void getNoUser() {
		baseURI = "https://reqres.in/api";
	    basePath ="/users/";
	}
	public void getSingleuserWithinvalid(Integer id) {
		response = given().
				queryParam("id",id).
		    when().
		    	get().
		    then().statusCode(404).
		    	contentType(ContentType.JSON).extract().response();
		
		userNotfound = response.getBody().asPrettyString();
		 System.out.println("---------User not found from Reqres.in---------");
		 System.out.println(userNotfound);
   
	}
	public void ValidateTheStatusCode(Integer statuscode) {
		Integer StatusCode = response.getStatusCode();
		 
		Assert.assertEquals(StatusCode,statuscode);
		System.out.println("Verification has passed for user not found");
	
	}
	
	/* Fourth Scenario to get the list of resources*/
	public void endresources() {
		baseURI = "https://reqres.in/api";
	    basePath ="/unknown";
	}
	public void getlistofresources() {
		response = given().
			    when().
			    get();
		ResponseBody body_01 = response.getBody();
		ListOfResources =  body_01.asPrettyString();
		System.out.println("---------List of resources from Reqres.in---------");
		 System.out.println(ListOfResources);
		
	}
	
	public void validatelistofResources() throws IOException {
		File file = new File("/Users/amreennaziasyed/eclipse-workspace/DSALGO/RestAssured_BddFramework/TestData/SchemaPage_01.json");
		FileInputStream fileinputstream = new FileInputStream(file);
		String Listofresources = IOUtils.toString(fileinputstream, "UTF-8");
		 
		 Assert.assertEquals(ListOfResources, Listofresources);
		 System.out.println("Verification has passed for list of resources ");
	}
	
	
	/*Fifth Scenario to get the Single resource*/
	public void endsingleResource() {
		baseURI = "https://reqres.in/api";
	    basePath ="/unknown/";
	}
	public void getSingleResource(Integer id) {
		response = given().
				queryParam("id",id).
		    when().
		    	get().
		    then().statusCode(200).
		    	contentType(ContentType.JSON).extract().response();
		
		String  singleResource = response.getBody().asPrettyString();
		 System.out.println("---------Single resource from Reqres.in---------");
		 System.out.println(singleResource);
	}
	
	
	public void validateSingleResource(Integer year,Integer status_code) {
		int Year = response.path("data.year");
		int StatusCode = response.getStatusCode();
		
		boolean result = (Year==year && StatusCode == status_code);
		try
		{
			Assert.assertTrue(result);
			System.out.println("Verification passed for single resource");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		 
}
	 
}	
	
