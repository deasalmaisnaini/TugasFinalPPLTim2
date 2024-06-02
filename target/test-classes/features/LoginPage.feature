#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Login to Swag Labs

  Background: 
    Given User has opened swag labs browser

  @Interface @TC01 
  Scenario: verifikasi halaman login
    Then There are fields for inputting username and password that have not been filled in
    And There is a green Login Button
    And There is a Swag Labs logo name

  @TCID01
  Scenario: Verify if login is successful with valid credentials
    When User enter username as "standard_user" and password as "secret_sauce"
    And User click login button
    Then User should be able to see Dashboard Page

  @TCID01
  Scenario Outline: Verify if login is unsuccessful with invalid credentials
    When User enter username as "<username>" and password as "<password>"
    And User click login button
    Then Showing symbol red x in the "<error_field>"
    And Showing Error message "<error_message>"
    And Stay on the login page
    And The label and border in the "<error_field>" field are red

    Examples: 
      | username      | password     | error_message                                               | error_field | TCID  |
      | standard_user |              | You need Password                                           | password    | TC012 |
      |               | secret_sauce | You need Username                                           | username    | TC013 |
      |               |              | You need Username & Password                                | both        | TC014 |
      | standard_user | secret       | Username and password do not match any user in this service | both        | TC015 |
      | standarad     | secret_user  | Username and password do not match any user in this service | both        | TC016 |
      | standard      | secret       | Username and password do not match any user in this service | both        | TC017 |
