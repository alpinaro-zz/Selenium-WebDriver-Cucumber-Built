Feature: US1001 Amazon Search

  Background: Amazon Homepage
    When user goes to "amazonURL"
    Then user checks page title contains "Amazon"

  @amazon @java
    Scenario: TC001 Amazon Java Search
    Then user checks if searchbox is enabled
    And user search "java"
    Then user checks if results contains "java"
    Then user closes browser