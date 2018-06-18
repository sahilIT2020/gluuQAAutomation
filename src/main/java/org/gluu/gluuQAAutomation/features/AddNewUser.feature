Feature: Add new user
@gluuQA
Scenario: Sign in as admin
 	When 	I sign in as administrator
 	Then 	I should see gluu home page
 	When 	I go to user add page
 	When 	I sign out
 	Then 	I should see the gluu login page