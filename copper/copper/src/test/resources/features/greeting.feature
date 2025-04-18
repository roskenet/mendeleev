Feature: Hello Endpoint

  Scenario: Call /hello with a name
    Given the client calls our service with the name "Elvis"
    Then the response should contain "Hello, Elvis!"

