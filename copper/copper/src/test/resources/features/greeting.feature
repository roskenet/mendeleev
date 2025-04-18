Feature: User Greeting
  Background: The user should be greeted in a very casual and friendly way.

  Scenario: Calling hello with a name
    Given the client calls our service with the name "Elvis"
    Then the response code is 200
    And the response should contain "Hello, Elvis!"

  Scenario: Calling hello with full name
    Given the client calls our service with the name "Elvis A. Presley"
    Then the response code is 200
    And the response should contain "Hello, Elvis!"
