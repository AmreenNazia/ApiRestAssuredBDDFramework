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
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;

import Utilities.LoggerLoad;

public class PostTest {
	
	Response response;
	String listOfUsers;
	 String newuser;
	int StatusCode;
	String updateduser;
	int Statuscode;
	String Deleteduser;
	Object id;
	
	
	 
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
	
	 


 
}