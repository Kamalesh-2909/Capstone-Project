Feature: Shopping Cart

  Scenario: Add product to cart
    Given I am logging in
    When I search for pet animal
    Then I add the pet to the cart
    And the cart should contain the pet

  Scenario: Remove product from cart
    Given I have a product in the cart
    When I remove the product from the cart
    Then the cart should be empty

  Scenario: Update cart quantity
    Given I add pet in the cart
    When I update the quantity
    Then the total price should be updated accordingly

  Scenario: Proceed to checkout
     Given I am in shopping cart
     When I gave the payment details
     Then I confirm the order
     And order is confirmed 