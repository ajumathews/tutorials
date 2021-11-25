Feature: hello world can be called
  Scenario: client makes a call to /hello
    When the client call /hello
    Then the client recieves status code of 200
    And the client recieves message hello