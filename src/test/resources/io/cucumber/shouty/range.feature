Feature: Range

  In order to send location-sensitive messages to people nearby
  As a shouter
  I want to broadcast messages only to people within a specified range

  Rules:
  - broadcast to all users within 1 mile

  Background:
    Given A person named Lucy
    And A person named Sean

  Scenario: Listener hears a message
    When Sean shouts "Free bagels!"
    And Lucy is within 1 mile
    Then Lucy hears Sean's message

  Scenario: Listener does not hears a message
    When Sean shouts "Free bagels!"
    And Lucy is outside of 1 mile
    Then Lucy does not hear Sean's message