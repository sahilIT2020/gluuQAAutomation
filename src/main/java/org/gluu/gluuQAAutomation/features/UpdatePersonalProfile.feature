Feature: Update a personal profile
  @gluuQA
  Scenario: Update a personal profile
    When I sign in as administrator
    And I go to the personal profile page
    And I set the new values to 'test,QA'

