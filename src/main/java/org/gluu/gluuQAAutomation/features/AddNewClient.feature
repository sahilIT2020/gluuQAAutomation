Feature: Add new client
@gluuQA
Scenario: Add new client
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to openid connect clients list page
	And 	I start the process to add new client