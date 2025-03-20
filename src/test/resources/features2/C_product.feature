Feature: Product Details Page

  Scenario: Validate product information
    Given I am in home page
    When I search for "Amazon Parrot"
    Then I should select the product id
    And I should see product details including title, description, price, image and availability 

  Scenario: Add product to cart
    Given I am in product page
    When I add the product to cart
    Then the product should be visible in the cart