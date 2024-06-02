# Author: Falia Davina Gustaman
# Date: 31-Mei-2024
# File: Checkout.feature
# Software Under Test: Swag Labs
# Description: [Deskripsi singkat tentang isi file]

@webtesting @checkout
Feature: Swag Lab Checkout

    Background:
        Given User has opened swag labs browser
        And User has logged into the application

    Scenario: Verify checkout page
        Given User find the product "1" and click the add to cart button
        When User has navigated to the Cart page
        And User clicks on the checkout button
        Then The fields for inputting first name, last name, and Zip or Postal Code are displayed and have not been filled in

    Scenario: Check for checkout information is filled with valid data (no empty field)
        Given User find the product "2" and click the add to cart button
        And User has navigated to the checkout information page
        When User enters First Name, Last Name, and Zip or Postal Code
        And User clicks on the continue button
        Then A list of products to be checked out is displayed
        And Payment information, shipping information, and the total price are displayed
        And There is a cancel button

    Scenario: Verify navigation shipping information into checkout complete
        Given User find the product "3" and click the add to cart button
        And User has navigated to the shipping information page
        When User clicks on finish button
        Then Displays Thank you for your order! message with checklist and circle logo on the top of it
