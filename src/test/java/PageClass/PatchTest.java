package PageClass;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PatchTest {
	
	
	
	Response response;
	String listOfUsers;
	String newuser;
	int StatusCode;
	String updateduser;
	int Statuscode;
	String Deleteduser;
	Object id;

	public void updateendpoint() {
		baseURI = "http://localhost:3000";
	    basePath ="/users";
		 
		
	}
	public void patchrequest() {
		
		JSONObject request  =  new JSONObject();
		 
		request.put("lastName",  "Shaik");
		 

		response = given().when().get();
		List<Object> list = response.jsonPath().getList("id");
 
		int listlength = list.size();
		if(listlength!= 0)
		{
			id =list.get(2);
		}

		
		response = given() 
				.contentType(ContentType.JSON)
			 	.accept(ContentType.JSON)
			 	.body(request.toString()).
			    when().
			   patch("/"+id);
		
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
	

}
