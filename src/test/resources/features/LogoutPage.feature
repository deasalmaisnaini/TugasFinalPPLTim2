@Functionality 
Feature: Logout Functionality

  @TCID021
  Scenario: Verify if logout is successful
    Given User has opened swag labs browser
    Given User has logged in to swag labs
    When User clicks on humberger icon at top left corner
    And clicks on logout button
    Then User should be able to logged out successfully
