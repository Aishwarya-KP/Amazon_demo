@tag
Feature: Amazon Functionality check
  @tag1
  Scenario: Check Add to cart functionality
  
    Given User navigates to the homepage
    Then verify Amazon logo displayed
    And verify cart has no items displayed
    When user searches for "black tshirt"
    Then verify search results displayed for "black tshirt"
    When choose the sort option "Price: Low to High"
    Then select the first item in the list
    Then choose the size as "S"
    And Get the price of the product 
    When click add to cart
    Then Check the cart number has changed to "1"
    Then verify the price on cart page
    And Click buy now option
    Then User signs in 