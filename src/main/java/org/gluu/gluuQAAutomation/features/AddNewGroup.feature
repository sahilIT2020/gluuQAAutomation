Feature: Add new group 
@gluuQA
Scenario: Add new group 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to group add page 
	And 	I add a group with display name 'QAGroupDN' 
	And 	I add a group with description 'QAGroupDescription' 
	And 	I add a group with visibility 'Public'
	And 	I add the user named 'admin' as member
	And 	I save the group
	Then 	I go to groups manage page 
	And 	I search for group with pattern 'qa' 
	Then 	I should see a group with description 'QAGroupDescription' 
	And 	I should see a group with display name 'QAGroupDN'
	Then 	I sign out