Feature: End To End Swag Labs

  @webtesting @EndToEnd
  Scenario: End To End Testing Swag Labs
    Given User has opened swag labs browser
    When User enter username as "standard_user" and password as "secret_sauce"
    And User click login button
    And User find the product "2" and click the add to cart button
    And Press the cart icon on the product detail page
    And User has navigated to the Cart page
    And User clicks on the checkout button
    And User has navigated to the checkout information page
    And User enters First Name, Last Name, and Zip or Postal Code
    And User clicks on the continue button
    And User clicks on finish button
    Then Displays Thank you for your order! message with checklist and circle logo on the top of it
