Feature: Shout

  In order to send location-sensitive messages to people nearby
  As a shouter
  I want to broadcast messages to people near me

  Rules:
  - max length of message is 180 characters
  - only shout to people within a certain distance
  - people remember everything

  To do:
  - only shout to people within a certain distance

  Background:
    Given the range is 100
    And the following people:
      | name     | Sean | Lucy | Larry |
      | location | 0    | 100  | 150   |

  Scenario: Listener is within range
    When Sean shouts "Free bagels!"
    Then Lucy hears Sean's message

  Scenario: Listener is out of range
    When Sean shouts "Free bagels!"
    Then Larry does not hear Sean's message

  Scenario: Two Shouts
    When Sean shouts "Free bagels!"
    When Sean shouts "Free toast!"
    Then Lucy hears the following messages:
      | Free bagels! |
      | Free toast!  |

    Scenario: Message is too long
      When Sean shouts:
      """
      This is a really long message
      so long in fact I am not going to be allowed
      to send it, at least if I keep typing like this until the length is over
      180 characters 180 characters 180 characters
      """
      Then nobody hears Sean's message