Feature: Configure custom NameId 
@gluuQA 
Scenario: Configure custom NameId 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to custom nameId configuration page 
	And 	I start the process to add new name id configuration
	And 	I set 'City' as source atrribute
	And 	I set 'City' as name
	And 	I set 'unspecified' as nameid type
	And 	I enable it
	And 	I save the name id
	Then 	I sign out