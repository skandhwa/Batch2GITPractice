@smoke
Feature: Creation of New User With Token

  Scenario Outline: Creation of NewUser with Token
    Given User will login into the application with the corresponding baseURI
    And the User will pass the payload with the required token
    When User will submit the post request with corresponding endpoint as "<endpoint>"
    Then User will be validating the status code as "<status_code>"
    Then the User will validate the responsebody of the sent request
    
   

    Examples: 
      | endpoint        | status_code |
      | public/v2/users |         201 |
