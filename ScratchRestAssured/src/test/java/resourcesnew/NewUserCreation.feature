@sanity

Feature: Creation of new User for a specific site

  Scenario Outline: Creation of new Users for a specific demo site
    Given User will request to hit the application URL
    And User will pass the payload in the request
    When user will hit the "<endpoint>"
    Then User is going to validate the response with "<status_code>"

    Examples: 
      | endpoint | status_code |
      | post     |         200 |
