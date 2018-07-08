Feature: Add new scope 
@gluuQAPending 
Scenario: Add new scope 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to openid connect scopes list page 
	And 	I start the process to add new scope
	And 	I set the display name 'QaAddedScopeDN'
	And 	I set the description 'QaAddedScopeDes'
	And 	I set the scope type to 'QaAddedScopeDN'
	And 	I set dynamic registration to 'true'