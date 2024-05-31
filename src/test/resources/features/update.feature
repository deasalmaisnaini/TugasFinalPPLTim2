Feature: 
  Scenario: Test update user normal
    Given prepare url for "UPDATE_USER"
    And hit api post create new user for create new user
    When hit api update profile user 
    Then validation status code api user is equals 200
    Then validation response body update user
    Then validation response json with JSONSchema "update_profile_user_normal.json"
