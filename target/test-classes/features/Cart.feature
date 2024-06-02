# Author: Falia Davina Gustaman
# Date: 31-Mei-2024
# File: Cart.feature
# Software Under Test: Swag Labs
# Description: [Deskripsi singkat tentang isi file]

@webtesting @cart
Feature: Swag Lab Cart

    Background:
        Given User has opened swag labs browser
        And User has logged into the application
        And User has navigated to the cart page

    Scenario: Verify navigation from cart into dashboard
        When User clicks on continue shopping button
        Then The user sees the name swag labs
        And Displays the product catalogue

    Scenario: Verify navigation from cart into checkout information page. Cart is not empty
        When User clicks on checkout button
        Then Displays fields for inputting first name, last name and Zip/Postal Code that have not been filled in
        And There is a cancel button

    Scenario: Verify navigation from cart into checkout information page. Cart is empty
        When User clicks on checkout button
        Then Stay on the cart page
