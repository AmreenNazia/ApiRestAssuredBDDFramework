Feature: Validate different request on Reqres

@Tag06
Scenario Outline: Create a new User 
Given the valid endpoint of new user
When the request Post sent to create the user  
Then validate the response of new user with list of users

@Tag07
Scenario Outline: Update a old user
Given the valid endpoint of update user
When the request put sent to update the user
Then validate the response of update user 
@Tag08
Scenario Outline: Update any key of old user
Given the valid endpoint to update user
When the request patch to update the user
Then validate the response of updated user
@Tag09
Scenario Outline: Delete one of the user
Given the valid endpoint to Delete user
When the request to delete the user
Then validate the response of delete with <statuscode>

Examples:
| statuscode |
| 204 |

 