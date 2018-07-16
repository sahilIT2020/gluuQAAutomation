Feature: SMTP config 
@gluuQAPending 
Scenario: SMTP config 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to smtp configuration page 