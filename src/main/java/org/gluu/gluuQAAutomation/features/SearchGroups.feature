Feature: Search group 
@gluuQA 
Scenario: Search group 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to group add page 
	And 	I add a group with display name 'QAGroupToSearchDN' 
	And 	I add a group with description 'QAGroupToSearchDescription' 
	And 	I add a group with visibility 'Public'
	And 	I save the group
	When 	I go to groups manage page 
	And 	I search for group with pattern 'QAGroupToSearchDN' 
	Then 	I should see a group with description 'QAGroupToSearchDescription' 
	And 	I should see a group with display name 'QAGroupToSearchDN' 
	When 	I sign out 