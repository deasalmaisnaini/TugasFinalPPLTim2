Feature: Update User

  @api @updateapi
  Scenario Outline: Test update user valid
    Given prepare url for "UPDATE_USER"
    And hit api post create new user for create new user
    When hit api update profile user with data
      | field   | value   |
      | <field> | <value> |
    Then validation status code api user is equals 200
    Then validation response body update user

    Examples: 
      | field        | value                    |
      | title        | dr                       |
      | firstName    | rachma                   |
      | lastName     | alia                     |
     
 @api @updateapi
  Scenario Outline: Test update user invalid
    Given prepare url for "UPDATE_USER"
    And hit api post create new user for create new user
    When hit api update profile user with data
      | field   | value   |
      | <field> | <value> |
    Then validation status code api user is equals 400
    Then validation response body update user

    Examples: 
      | field        | value                    |
      | registerDate | 2023-04-28T04:12:38.601Z |
      | firstName    | a                        |
