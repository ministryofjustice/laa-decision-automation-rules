Feature: Test Civil Client applications with passported or without passported benefit
  Scenario: Client with passport benefits and total capital under threshold off 3000 means will be accpeted
    Given a case with passport benefit 
    And a total capital of 1950.00
    When decision rules are fired
    Then means must be accepted
    
    
