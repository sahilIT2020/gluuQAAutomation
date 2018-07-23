Feature: Update OxTrust Settings
  @gluuQA6
  Scenario: Update OxTrust Settings as an admin

    Given I sign in as administrator
    Then I should see gluu home page
    When I go to system organization configuration page
    And I click on the Ox Trust Settings Page
    Then I should see the OxTrust Settings page
    Given I set the Organization name to 'Gluu Incorporated'
    And I add the Organization Logo
    And I add the Organization Favicon
    And I click on the Update button
    Then I click on the Ox Trust Settings Page
    And I should see the Organization name set to 'Gluu Incorporated'
    And I should see the uploaded logo has a 'Remove' button
    And I should see the uploaded favicon has a 'Remove' button
    Given I click on the Manager Group name
    Then I should see the Group Manage Update Page
    And I sign out
