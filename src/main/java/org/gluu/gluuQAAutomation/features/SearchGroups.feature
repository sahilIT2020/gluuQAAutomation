Feature: Search group 
@gluuQA 
Scenario: Search group 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to groups manage page 
	And 	I search for group with pattern 'QA' 
	Then 	I should see a group with description 'QAGroupDescription' 
	And 	I should see a group with display name 'QAGroupDN' 
	When 	I sign out 