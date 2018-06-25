Feature: Search user 
@gluuQA 
Scenario: Search user 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to users manage page 
	And 	I search for user with pattern 'QA' 
	Then 	I should see a user named 'QaUser' 
	And 	I should see a user with display name 'QaUserDN' 
	When 	I sign out 
	Then 	I should see the gluu login page