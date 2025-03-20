Feature: Search Functionality

  Scenario: Search for a pet
    Given I am in user page
    When I search for pet
    Then I should see search results containing pet
    And I select the product id
    Then I get the price