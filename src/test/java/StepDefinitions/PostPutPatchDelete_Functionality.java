package StepDefinitions;

import java.io.IOException;

import PageClass.Commonpage;
import PageClass.PostPutPatchDelete;
import io.cucumber.java.en.*;

public class PostPutPatchDelete_Functionality {

	private	PostPutPatchDelete action = new PostPutPatchDelete();
	
	/* Post Validation*/
	@Given("the valid endpoint of new user")
	public void the_valid_endpoint_of_new_user() {
		 action.endNewUser();
	     
	}
	@When("the request Post sent to create the user")
	public void the_request_post_sent_to_create_the_user() {
		action.CreateUser();
	    
	}

	@Then("validate the response of new user with list of users")
	public void validate_the_response_of_new_user_with_list_of_users() throws IOException {
	     action.ValidateNewUser();
	}

 
	/*Put Validation*/
 @Given("the valid endpoint of update user")
public void the_valid_endpoint_of_update_user() {
     action.updatendpoint();
}

@When("the request put sent to update the user")
public void the_request_put_sent_to_update_the_user() {
     action.putrequest();
}

@Then("validate the response of update user")
public void validate_the_response_of_update_user() throws IOException {
    action.validateUpdatesUser();
}

/* Update the user using Patch*/

@Given("the valid endpoint to update user")
public void the_valid_endpoint_to_update_user() {
    action.updateendpoint();
}

@When("the request patch to update the user")
public void the_request_patch_to_update_the_user() {
     action.patchrequest();
}

@Then("validate the response of updated user")
public void validate_the_response_of_updated_user() throws IOException {
   action.validateUpdatedUser();
}
/*Delete the user*/

@Given("the valid endpoint to Delete user")
public void the_valid_endpoint_to_delete_user() {
    action.Deleteuser();
}

@When("the request to delete the user")
public void the_request_to_delete_the_user() {
     action.DeleteRequest();
}

@Then("validate the response of delete with {int}")
public void validate_the_response_of_delete_with(Integer statuscode) throws IOException {
     action.validateDeleteduser(statuscode);
}

}
