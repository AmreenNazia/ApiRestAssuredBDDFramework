package StepDefinitions;

import java.io.IOException;

import PageClass.Commonpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


 
public class GetListOfUsers_Functionality {

	private	Commonpage page = new Commonpage();
	 
/* First Scenario to get the list of users*/
	 
	 
	@Given("the valid endpoint to fetch users")
	public void setupEndpoint() {
		 
		 page.setupEndpoint();

	}

	@When("the request is sent to get the list of users")
	public void getRequest() throws IOException {
			
		page.getRequestOfUsers();

	}

	@Then("validate the response of list of users")
	public void validateListOfUsers() throws IOException {
 		 
		page.ValidateListOfUsers();
	   }

 /*Second scenario to get the single user details and validate*/
	
	
	@Given("the valid endpoint to fectch user")
	public void the_valid_endpoint_to_fectch_user() {
	     page.setupforUser();
	
	}

	@When("the request sent to get the single user")
	public void getSingleUser() {
		 
		page.getSingleUser();
	}

	@Then("validate the response of single user first_name as {string}")
	public void validateSingleUser(String first_name) {
		 
		page.validateSingleUser(first_name);
	}

///*Third Scenario to get the response of single user not found*/
	

@Given("the valid endPoint to fetch invalid user")
public void the_valid_end_point_to_fetch_invalid_user() {
	page.getNoUser();
}

@When("the request sent to get the single user with invalid id as {int}")
public void the_request_sent_to_get_the_single_user_with_invalid_id_as(Integer id) {
	page.getSingleuserWithinvalid(id);
	
}

@Then("validate the response of single user with statuscode as {int}")
public void validate_the_response_of_single_user_with_statuscode_as(Integer statuscode) {
	 
	page.ValidateTheStatusCode(statuscode);
}


///* Fourth Scenario to get the list of resources*/
//
@Given("the valid endpoint to fetch list of resources")
public void the_valid_endpoint_to_fetch_list_of_resources() {
	page.endresources();
}

@When("the request sent to get the list of resources")
public void the_request_sent_to_get_the_list_of_resources() {
	 
	page.getlistofresources();
}

@Then("validate the response of list of resources")
public void validate_the_response_of_list_of_resources() throws IOException {
	page.validatelistofResources();
	  
}
 
///*Fifth Scenario to get the Single resource*/


@Given("the valid endpoint to fetch single resource")
public void the_valid_endpoint_to_fetch_single_resource() {
	page.endsingleResource();
}

@When("the request sent to get the single resource with id as {int}")
public void the_request_sent_to_get_the_single_resource_with_id_as(Integer id) {
	page.getSingleResource(id);
	
}

@Then("validate the response of single resource with year as {int} and status_code as {int}")
public void validate_the_response_of_single_resource_with_year_as_and_status_code_as(Integer year, Integer status_code) {
	
			page.validateSingleResource(year, status_code);
			
			 
	}



}
