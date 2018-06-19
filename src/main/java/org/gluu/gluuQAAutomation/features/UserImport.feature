Feature: Zmport users
@gluuQA
Scenario: Zmport users to gluu server
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to users import page
	And 	I import the sample excel file
	When 	I sign out 
	Then 	I should see the gluu login page