Feature: Test Reqres User Api's with RestAssured

  @Tag01
  Scenario: Reqres Get API Test
    Given the valid endpoint to fetch users
    When the request is sent to get the list of users
    Then validate the response of list of users

  @Tag02
  Scenario Outline: Reqres Get Single User
    Given the valid endpoint to fectch user
    When the request sent to get the single user
    Then validate the response of single user first_name as "<first_name>"

    Examples: 
      | first_name |
      | Janet      |

  @Tag03
  Scenario Outline: Reqres Get Single User not found
    Given the valid endPoint to fetch invalid user
    When the request sent to get the single user with invalid id as <id>
    Then validate the response of single user with statuscode as <statuscode>

    Examples: 
      | id | statuscode |
      | 25 |        404 |

  @Tag04
  Scenario: Reqres Get list of resources
    Given the valid endpoint to fetch list of resources
    When the request sent to get the list of resources
    Then validate the response of list of resources

  @Tag05
  Scenario Outline: Reqres Get single resource
    Given the valid endpoint to fetch single resource
    When the request sent to get the single resource with id as <id>
    Then validate the response of single resource with year as <year> and status_code as <status_code>

    Examples: 
      | id | year | status_code |
      |  4 | 2003 |         200 |
