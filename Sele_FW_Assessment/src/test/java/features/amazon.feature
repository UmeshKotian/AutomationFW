Feature: Open Amazon.com | Adding item in cart

  Scenario: Open Amazon.com | Adding a “Monitor” Item in Cart | verifying price and sub total value
    Given a user is on the amazon home page
    When user types "Monitor" in search field and press enter
    And user selects the first item on the list
    And user clicks on add to cart button
    And user clicks on cart button to open cart page
    Then verify that the cart price is identical to the product page
    And verify that the cart sub total is identical to the product page

  Scenario: Open Amazon.com | Adding a “Laptop” Item in Cart | verifying price and sub total value
    Given a user is on the amazon home page
    When user types "Laptop" in search field and press enter
    And user selects the second item on the list
    And user clicks on add to cart button for Laptop
    And user clicks on cart button to open cart page
    Then verify that the cart price is identical to the product page
    And verify that the cart sub total is identical to the product page
