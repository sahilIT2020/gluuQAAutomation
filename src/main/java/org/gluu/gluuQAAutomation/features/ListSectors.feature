Feature: List sectors 
@gluuQA
Scenario: List sectors 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to sectors list page 
	Then 	I should see that the list is empty
	And 	I sign out