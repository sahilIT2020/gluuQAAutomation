Feature: Add social strategy 
@gluuQAPending
Scenario: Add social strategy
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to strategy page
	And 	I enable passport status to 'Enabled'
	And 	I save the passport status changed
	When 	I go to strategy page
	And 	I add new strategy named 'github' with id 'a97a8b59b74d81887316' and secret 'df71abbb97eef23701af1d1b3402de5a02e883ae'
	Then 	I sign out 