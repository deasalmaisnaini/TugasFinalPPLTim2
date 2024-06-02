# Author: Falia Davina Gustaman
# Date: 31-Mei-2024
# File: Cart.feature
# Software Under Test: Swag Labs
# Description: [Deskripsi singkat tentang isi file]

@webtesting @cart
Feature: Swag Lab Cart

    Background:
        Given User has opened swag labs browser
        And User has log in to the application

    Scenario: Verify cart page
        When User clicks on the cart icon at the top right of the dashboard page
        Then Displays the list of product with remove button under each product
        And There is a continue shopping button
        And There is a checkout button

    Scenario: Verify navigation from cart into dashboard
        When User clicks on continue shopping button
        Then The user sees the name swag labs
        And Displays the product catalogue

    Scenario: Add 3 types of product with a quantity of 1 to the cart
        When User clicks add to cart button on product "1" once
        And User clicks add to cart button on product "2" once
        And User clicks add to cart button on product "3" once
        And User clicks on the cart icon at the top right of the dashboard page
        Then Displays the list of 3 products with remove button under each product
        And There is a continue shopping button
        And There is a checkout button
