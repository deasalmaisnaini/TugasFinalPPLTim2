# Author: Dea Salma Isnaini
# Date: 31-Mei-2024
# File: Menu.feature
# Software Under Test: Swag Lab
# Description: This file contains scenarios for testing the feature product detail in swag labs.
@webtesting @productdetail
Feature: Swag Lab Product Detail

  Background: 
    Given User has opened swag labs browser
    And User has logged in by entering valid credential data

  @TCPD01
  Scenario: Verify Product Details Page
    When Select and press the product Sauce Labs Fleece Jacket
    Then The product detail page appears with a display containing more detail

  @TCPD04
  Scenario: Verify Product Details Page
    Given User has Select and press the product Sauce Labs Fleece Jacket
    And User already on the product detail page
    When Press the cart icon on the product detail page
    Then The page moves to a page that displays the contents of the cart

  @TCPD05
  Scenario: The page navigation flow to the cart page by pressing the left arrow icon
    Given User has Select and press the product Sauce Labs Fleece Jacket
    And User already on the product detail page
    When Press the left arrow icon on the product detail page.
    Then User should be able to see Dashboard Page
