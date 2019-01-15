Feature: Shout

#  Scenario: Listener is within range
#    Given Lucy is 1 metre from Sean
#    When Sean shouts "free bagels at Sean's"
#    Then Lucy hears Sean's message

    #Lesson 3 Scenario Exercise
   Scenario: Listener shouts back
    Given Lucy is 1 metre from Sean
    When Sean shouts "free bagels at Sean's"
    Then Lucy hears Sean's message
    And Lucy shouts back to Sarah

  Scenario: Listener has # cucumber in there bag
    Given Lucy is has 100 cucumbers in her bag
    When Sean shouts "free bagels at Sean's"
    Then Lucy hears Sean's message
    And Lucy shouts back to Sarah

  Scenario: Regex matching test
    Given Lucy buys 1 cucumbers
    When Sean shouts "free bagels at Sean's"
    Then Lucy hears Sean's message
    And Lucy shouts back to Sarah

#  Scenario: Listener hears a different message
#    Given Lucy is located 15m from Sean
#    When Sean shouts "free coffee"
#    Then Lucy hears Sean's message

#  Scenario: Listener is out of range
#    Given Lucy is located 1000m from sean
#    When Sean shouts "free bagels at Sean's"
#    Then Lucy cannot hear the message