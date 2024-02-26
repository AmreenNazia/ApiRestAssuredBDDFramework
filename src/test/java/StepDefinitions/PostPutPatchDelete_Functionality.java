package StepDefinitions;

import java.io.IOException;

import PageClass.Commonpage;
import PageClass.DeleteTest;
import PageClass.PatchTest;
import PageClass.PostTest;
import PageClass.PutTest;
import io.cucumber.java.en.*;

public class PostPutPatchDelete_Functionality {

	private	PostTest action = new PostTest();
	private PutTest put = new PutTest();
	private PatchTest patch = new PatchTest();
	private DeleteTest delete = new DeleteTest();
	
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
	 
	 put.updatendpoint();
}

@When("the request put sent to update the user")
public void the_request_put_sent_to_update_the_user() {
	 
     
	put.putrequest();
}

@Then("validate the response of update user")
public void validate_the_response_of_update_user() throws IOException {
    put.validateUpdatesUser();
}

/* Update the user using Patch*/

@Given("the valid endpoint to update user")
public void the_valid_endpoint_to_update_user() {
    patch.updateendpoint();
}

@When("the request patch to update the user")
public void the_request_patch_to_update_the_user() {
     patch.patchrequest();
}

@Then("validate the response of updated user")
public void validate_the_response_of_updated_user() throws IOException {
   patch.validateUpdatedUser();
}
/*Delete the user*/

@Given("the valid endpoint to Delete user")
public void the_valid_endpoint_to_delete_user() {
    delete.Deleteuser();
}

@When("the request to delete the user")
public void the_request_to_delete_the_user() {
     delete.DeleteRequest();
}

@Then("validate the response of delete with {int}")
public void validate_the_response_of_delete_with(Integer statuscode) throws IOException {
     delete.validateDeleteduser(statuscode);
}

}
