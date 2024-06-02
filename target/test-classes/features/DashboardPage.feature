#Author: Syifa Khairina
#Keywords Summary : Feature, Scenario, Given, When, Then, And, But, Scenario Outline, Examples, Background, @Tags, <placeholder>, Comments  
#Feature: Dashboard Page
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
@webtesting 
Feature: Swag Labs Dashboard Page

    Background: 
    Given User has opened swag labs browser
    And User enter username as "standard_user" and password as "secret_sauce"   
    And User click login button

    @Interface @TC01 
    Scenario: Verify Dashboard Page
    Then There is an Add To Cart button
    And There is a Swag Labs App logo name

    @TCID01
    Scenario: Check the functionality of adding products to cart by Adding one product to cart 
    When User press the "Add To Cart" button on one product 
    Then Cart Badge Value is updated to 1

    @TCID02
    Scenario: Check the functionality of canceling a product added to the shopping cart by pressing the "Remove" button with the condition that there is one product in the shopping cart
    And User press the "Add To Cart" button on one product
    And User press the "Remove" button on one product
    Then Cart Badge is not displayed
