# Author: Dea Salma Isnaini
# Date: 31-Mei-2024
# File: Menu.feature
# Software Under Test: Swag Lab
# Description: This file contains scenarios for testing the feature menu in swag labs. 

@webtesting @menu
Feature: Swag Lab Menu

  Background: 
    Given User has opened swag labs browser
    And User has logged in by entering valid credential data

  Scenario: Menu interaction is opening the sidebar
    When Press the three line icon or hamburger icon
    Then The sidebar appears displaying several menus

  Scenario: Menu interaction is Closing the Sidebar by pressing the "X" button
    When Press the three line icon or hamburger icon
    And Pressing the "X" button on the sidebar
    Then The sidebar that appears will close and display the product detail page again
    
  Scenario: Menu interaction, namely Selecting the Sidebar Menu "About"
    When Press the three line icon or hamburger icon
    And Press the "About" menu in the sidebar
    Then The page moves to the sauce lab website page
