Feature: Book Endpoint should work
  Scenario: client makes a call to /books
    When the client call /books
    Then the client recieves status code of 200
    And the client gets all books