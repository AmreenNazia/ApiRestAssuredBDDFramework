package PageClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;

import Utilities.LoggerLoad;

public class PostPutPatchDelete {
	
	Response response;
	String listOfUsers;
	 String newuser;
	int StatusCode;
	String updateduser;
	int Statuscode;
	String Deleteduser;
	
	/* Post Validation*/
	public void endNewUser() {
		
		baseURI = "http://localhost:3000";
		basePath ="/users";
		 
	}
	
	public void CreateUser() {
		
		JSONObject request = new JSONObject();
		request.put("firstName","Nazia" );
		request.put("lastName",  "Jamal");
		request.put("subjectId", "2");
		
//		 
	 	 
		response = given().contentType(ContentType.JSON)
			 	.accept(ContentType.JSON)
			 	.body(request.toString()).
			    when().
			    post();
		
		 
		 newuser = response.getBody().asPrettyString();
		 StatusCode  = response.statusCode();
		 System.out.println("-------------New User-----------");
		 System.out.println(newuser);
		  
		 
		 
	}
	public void ValidateNewUser() throws IOException {
		 
			File file = new File("/Users/amreennaziasyed/eclipse-workspace/DSALGO/RestAssured_BddFramework/src/test/resources/Data/db.json");
			FileInputStream fileinputstream = new FileInputStream(file);
			String Listofusers = IOUtils.toString(fileinputstream, "UTF-8");
			 
			
			 
			if (Listofusers.contains("Nazia"))
			{
				
	        	 System.out.println("Verification passed for creating new user");
			
	         }
			else {  
				System.out.println("Verification Failed");
			}
	

	}
	
	/*Put Validation*/
	
	public void updatendpoint() {
		baseURI = "http://localhost:3000";
		 basePath ="/users/1";
		 
		
	}
	public void putrequest() {
		
		JSONObject request  =  new JSONObject();
		request.put("firstName","Amreen Nazia" );
		request.put("lastName",  "Jamal Shaik");
		request.put("subjectId", "2");
		 
		 
		response = given() 
				.contentType(ContentType.JSON)
			 	.accept(ContentType.JSON)
			 	.body(request.toString()).
			    when().
			   put();
		
		updateduser = response.getBody().asPrettyString();
		 System.out.println("-------------Updated User-----------");
		System.out.println(updateduser);
		
	}
	
	public void validateUpdatesUser() throws IOException {
		
		File file = new File("/Users/amreennaziasyed/eclipse-workspace/DSALGO/RestAssured_BddFramework/src/test/resources/Data/db.json");
		FileInputStream fileinputstream = new FileInputStream(file);
		String Listofusers = IOUtils.toString(fileinputstream, "UTF-8");
		 
		
		 
		if (Listofusers.contains("Amreen Nazia"))
		{
			
        	 System.out.println("Verification passed for updating a user details with Put");
		
         }
		else {  
			System.out.println("Verification Failed");
		}
		
	}
	
	/* Update the user using Patch*/
	public void updateendpoint() {
		baseURI = "http://localhost:3000";
		 basePath ="/users/1";
		 
		
	}
	public void patchrequest() {
		
		JSONObject request  =  new JSONObject();
		 
		request.put("lastName",  "Shaik");
		 
		 
		response = given() 
				.contentType(ContentType.JSON)
			 	.accept(ContentType.JSON)
			 	.body(request.toString()).
			    when().
			   patch();
		
		updateduser = response.getBody().asPrettyString();
		 System.out.println("-------------Updated User details with last name -----------");
		 System.out.println(updateduser);
		
	}
	
	public void validateUpdatedUser() throws IOException {
		
		File file = new File("/Users/amreennaziasyed/eclipse-workspace/DSALGO/RestAssured_BddFramework/src/test/resources/Data/db.json");
		FileInputStream fileinputstream = new FileInputStream(file);
		String Listofusers = IOUtils.toString(fileinputstream, "UTF-8");
		 
		
		 
		if (Listofusers.contains("Shaik"))
		{
			
        	 System.out.println("Verification passedfor updating user details using Patch");
		
         }
		else {  
			System.out.println("Verification Failed");
		}
		
	}
	
	
	/*Delete the user*/
	public void Deleteuser() {
		baseURI = "http://localhost:3000";
		 basePath ="/users/1";
		 
		
	}
	public void DeleteRequest() {
		
		 
		 
		response =  when().
				   delete();
		Deleteduser = response.getBody().asPrettyString();
		Statuscode = response.getStatusCode();
		
		 System.out.println("-------------User got Deleted -----------");
		 
		 System.out.println(updateduser);
		 System.out.println("-------------Status code after Deleting-----------");
		 System.out.println(Statuscode);
			    
		
	}
	
	public void validateDeleteduser(Integer statuscode){
		
		 
		
		if((Statuscode == statuscode)|| (Statuscode == 200) || (Statuscode == 404))
		{
			System.out.println("Verfication passed for Deleted user");
	}
	
	
	}
 
}
