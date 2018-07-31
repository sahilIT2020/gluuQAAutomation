Feature: Configure custom NameId 
@gluuQA
Scenario: Configure new custom NameId 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to custom nameId configuration page 
	And 	I start the process to add new name id configuration
	And 	I add a namedid with source attrib 'City' with name 'City' with type 'unspecified' and enable 'true'
	And 	I save the namedid configuration
	Then 	I should see a named id named 'City' in the list
	And 	I sign out
	
@gluuQA
Scenario: Delete custom NameId 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to custom nameId configuration page 
	And 	I delete the nameID name 'City'
	Then 	I should not see a named id named 'City' in the list
	Then 	I sign out	