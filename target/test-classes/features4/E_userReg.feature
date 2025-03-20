Feature: User Registration

	Scenario: Registering a new user
    Given I am on the login page
    When I click the register button
    Then I enter user ID as "Kamal01"
    And I fill in account information
    Then the account should be created successfully