package PageClass;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.ArrayList;
import java.util.List;

import io.restassured.response.Response;

public class DeleteTest {

	Response response;
	String listOfUsers;
	String newuser;
	int StatusCode;
	String updateduser;
	int Statuscode;
	String Deleteduser;
	Object id;
	public void Deleteuser() {
		baseURI = "http://localhost:3000";
//		 basePath ="/users/1";
 
		
	}
	public void DeleteRequest() {
		
		
		response = given().when().get();
		List<Object> list = response.jsonPath().getList("id");
  
		int listlength = list.size();
		if(listlength!= 0)
		{
			id =list.get(2);
		}

		response =  when().
				   delete("/"+id);
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
