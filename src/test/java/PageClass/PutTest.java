package PageClass;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
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

public class PutTest {

	Response response;
	String listOfUsers;
	String newuser;
	int StatusCode;
	String updateduser;
	int Statuscode;
	String Deleteduser;
	Object id;


	public void updatendpoint() {
		baseURI = "http://localhost:3000";
				 basePath ="/users";
	}
	public void putrequest() {

		JSONObject request  =  new JSONObject();
		request.put("firstName","Amreen Nazia" );
		request.put("lastName",  "Jamal Shaik");
		request.put("subjectId", "2");

		
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
				put("/"+id);

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
}